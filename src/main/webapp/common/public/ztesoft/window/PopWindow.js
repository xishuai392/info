Ext.define('ZTEsoft.window.PopWindow', {
	extend:'Ext.window.Window',
	alias:'widget.ztepopwindow',
	config:{
		targetButton:null
	},
	constructor:function(config){
		var me=this;
		config=config||{};
		if(config.width){
			var width=config.width.toString();
			if(width.indexOf('%')>-1){
				config.width=width.substr(0,width.indexOf("%"));
				config.width=Ext.getBody().getWidth()*Number(config.width)/100;
			}
		}else{
				config.width=Ext.getBody().getWidth()*0.7;
		}
		if(config.height){
			var height=config.height.toString();
			if(height.indexOf('%')>-1){
				config.height=height.substr(0,height.indexOf("%"));
				config.height=Ext.getBody().getHeight()*Number(config.height)/100;
			}
		}else{
			config.height=Ext.getBody().getHeight();
		}
		Ext.applyIf(config,{
			closeAction:'hide',
			modal:true,
			title : '弹出窗口',
			width : '70%',
			height:'100%',
			resizable:false,
			frame : true,
			plain : true, // 背景
            constrain : true, // 限制窗口不超出浏览器边界
            modal : true,
            border : false
		});
		me.addDockedItems(config);
		me.callParent([config]);
		me.bindEvent();
	},
	addDockedItems : function(config) {
        var toolbar = Ext.create('Ext.toolbar.Toolbar', {
            dock : 'bottom',
            ui : 'footer',
            layout : {
                pack : 'center'
            },
            items : [{
                text : '确定',
                iconCls : 'accept',
                name : 'okBtn'
            }, {
                text : '取消',
                iconCls : 'arrow_undo',
                name : 'cancelBtn'
            }, {
                text : '重置',
                iconCls : 'arrow_rotate_anticlockwise',
                name : 'resetBtn'
            }, {
                text : '关闭',
                hidden:true,
                iconCls : 'close',
                name : 'closeBtn'
            }]
        });
        if(config.dockedItems){
        	if(Ext.isArray(config.dockedItems)){
        		  config.dockedItems.push(toolbar);
        	}else{
        		config.dockedItems=[config.dockedItems,toolbar];
        	}
        }else{
        	config.dockedItems=[toolbar];
        }
//        this.addDocked(toolbar, ['bottom']);
    },
	bindEvent:function(){
		var me=this;
		me.on('show',function(){
			if(me.winType&&me.winType==WEBConstants.ACTIONTYPE.VIEW){
				me.down('[name=okBtn]').hide();
				me.down('[name=cancelBtn]').hide();
				me.down('[name=resetBtn]').hide();
				me.down('[name=closeBtn]').show();
			}else if(me.winType&&(me.winType==WEBConstants.ACTIONTYPE.SELECT||me.winType==WEBConstants.ACTIONTYPE.EDIT)){
				me.down('[name=okBtn]').show();
				me.down('[name=cancelBtn]').show();
				me.down('[name=resetBtn]').hide();
				me.down('[name=closeBtn]').hide();
			}else if(me.winType&&(me.winType==WEBConstants.ACTIONTYPE.NOBUTTON)){
				me.down('[name=okBtn]').hide();
				me.down('[name=cancelBtn]').hide();
				me.down('[name=resetBtn]').hide();
				me.down('[name=closeBtn]').hide();
			}else{
				me.down('[name=okBtn]').show();
				me.down('[name=cancelBtn]').show();
				me.down('[name=resetBtn]').hide();
				me.down('[name=closeBtn]').hide();
			}
		});
		if(Ext.isFunction(me.okHandler)){//普通弹出窗口
			me.down('[name=okBtn]').on('click',Ext.bind(me.okHandler,me));
		}else if(me.grid&&me.displayField&&me.valueField){//由textbuttonfield弹出的窗口
			me.down('[name=okBtn]').on('click',function(){
				if(me.targetButton){
					var record=ExtUtils.gridSelectCheck(me.grid);
					if(!record) return;
					var valueFieldArr=me.valueField.split(',');
					var value="";
					Ext.each(valueFieldArr,function(valueField){
						value+=record.get(valueField);
					});
					me.targetButton.setValue(record.get(me.displayField)+","+value);
					me.close();
				}else{
					Ext.Msg.alert('提示','请设置目标');
				}
			});
		}
		me.down('[name=closeBtn]').on('click',function(){
			me.cancelHandler();
		});
		me.down('[name=cancelBtn]').on('click',function(){
			if(me.winType&&me.winType==WEBConstants.ACTIONTYPE.SELECT){
				me.cancelHandler();
			}else{
				ExtUtils.confirm(StrConstants.HINT_CANCEL_CONFIRM,me.cancelHandler,me);
			}
		});
		me.down('[name=resetBtn]').on('click',function(){
			if(me.resetHandler){
				me.resetHandler(arguments);
			}else if(me.resetForm){
				me.resetForm.getForm().reset();
			}
		});
	},
	cancelHandler:function(){
		this.close();
	}
});