/**
 * 报表统计
 */
Ext.define('ZTEsoft.window.PopSearchWindow', {
	extend : 'Ext.window.Window',
	alias : 'widget.popSearchWindow',
	config:{
		searchForm:null,
		mainGrid:null
	},
	constructor : function(config) {
		config = config || {};
		var me = this;
		Ext.applyIf(config, {
			layout : 'border',
			width : '70%',
			height:'100%',
			resizable:false,
			frame : true,
			plain : true, // 背景
            constrain : true, // 限制窗口不超出浏览器边界
            modal : true,
            border : false,
			closeAction : 'hide',
			title : '弹出窗口',
			items:[config.searchForm,config.mainGrid],
			dockedItems : [{// 菜单栏
				xtype : 'toolbar',
				dock : 'bottom',
				ui : 'footer',
				layout : {
					pack : 'center'
				},
				items : [{
					text : '确定',
					width:50,
					name : 'btnOk'
				}, {
					text : '取消',
					width:50,
					name : 'btnCancel'
				}]
			}]
		});
		me.callParent([config]);
		me.bindEvent();
	},
	bindEvent:function(){
		var me=this;
		me.down('button[name=btnOk]').on('click',Ext.bind(me.okHandler,me));
		me.down('button[name=btnCancel]').on('click',Ext.bind(me.cancelHandler,me));
		if(me.mainGrid){
			me.mainGrid.on('itemdblclick',Ext.bind(me.okHandler,me));
		}
	},
	okHandler:function(){
		var me=this;
		if(me.callback){
			me.callback(me);
		}else if(me.mainGrid&&me.targetField){
			var record=ExtUtils.gridSelectCheck(me.mainGrid);
			if(record===false) return;
			me.targetField.setValue(record.raw[me.displayField]+","+record.raw[me.valueField]);
			me.close();
		}
	},
	cancelHandler:function(){
		var me=this;
		me.close();
	}
});