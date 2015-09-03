/**
 * 人口信息查询首页
 */
Ext.onReady(function() {
    var sqrxxPanel,zjPanel,ssxzlPanel,infoMainPanel;
    
    var cardNav = function (incr) { 
    	
    	console.log(infoMainPanel.getLayout().getPrev());
    	console.log(infoMainPanel.getLayout().getNext());
    	var layout = infoMainPanel.getLayout();
	    //layout[incr]();
	    Ext.getCmp('cardPrev').setDisabled(!layout.getPrev());
	    Ext.getCmp('cardNext').setDisabled(!layout.getNext());
    
	    var thizId = layout.activeItem.id.split('card')[1]; 
	    thizId = parseInt(thizId);
	    var nextId = parseInt(thizId, 10) + incr; 
	    
	    switch(thizId){
	    	case 0 : 
	    		//填写申请人信息
	    		console.log('当前是填写申请人信息');
	    		if(sqrxxPanel.getForm().isValid()){
	    			ExtUtils.info('通过表单校验');
	    			Ext.getCmp('cardPrev').setDisabled(false);
	   				Ext.getCmp('cardNext').setDisabled(false);
	   				layout.setActiveItem(nextId);
	    		}
	    		break;
	    	case 1 :
	    		console.log('当前是扫描身份证');
	    		//扫描身份证
	    		if(incr<0){
	    			//返回到填写申请人信息
	    			Ext.getCmp('cardPrev').setDisabled(true);
	   				Ext.getCmp('cardNext').setDisabled(false);
	    		}else{
	    			
	    		}
	    		layout.setActiveItem(nextId);
	    		break;
	    		
	    }
	    
	    console.log("thizId:"+thizId);
	    console.log("incr:"+incr);
	    
	    console.log("parseInt(thizId, 10):"+parseInt(thizId, 10));
	    console.log("nextId:"+nextId);
	     
	    //Ext.getCmp('cardPrev').setDisabled(next === 0); 
	    //Ext.getCmp('cardNext').setDisabled(next === 2); 
	}; 

    // 1、申请人信息填写
    sqrxxPanel = Ext.create("ZTEsoft.form.SearchForm", {
    	id : 'card0',
        layout : 'column',
        hiddenBtns : true,
        frame : true,
        title : '填写申请人信息',
        defaults : {
            labelAlign : 'right',
            labelWidth : 100,
            //xtype : 'textfield',
            style : 'margin-left:5px;margin-top:2px;margin-bottom:2px;'
        },
        items : [
        
        {
            fieldLabel : "证件号",
            xtype : "textfield",
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            width: 500,
            name : "userName"
        }, {
            fieldLabel : "证件类型",
            xtype : "combo",
            name : "state",
            displayField : 'text',
            valueField : 'value',
            editable : false,
            allowBlank : false,
            value : '10',
            store : new Ext.data.ArrayStore({
                fields : ['value', 'text'],
                data : [['10', '身份证'], ['20', '其他']]
            })
        },{
            fieldLabel : "姓名",
            xtype : "textfield",
            allowBlank : false,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            name : "userName"
        },{
            fieldLabel : "查询申请人类型",
            xtype : "combo",
            name : "state",
            displayField : 'text',
            valueField : 'value',
            editable : false,
            allowBlank : false,
            value : '50',
            store : new Ext.data.ArrayStore({
                fields : ['value', 'text'],
                data : [['10', '律师'],['20', '党政军机关'],['30', '司法机关'],
                	['40', '企事业单位'],['50', '个人'], ['60', '人民团体'],
                	['70', '其他']]
            })
        },{
            fieldLabel : "申请查询人单位",
            xtype : "textfield",
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            name : "userName"
        },{
            fieldLabel : "查询事由",
            xtype : "textfield",
            grow      : true,
            width: 500,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            name : "userName"
        }]

    });
    
    //2、证件扫描
    zjPanel = Ext.create('Ext.Panel', { 
	    title: '证件扫描', 
	    id : 'card1', 
	    items: [],
	    tbar: [ {
	        text: '开始扫描', 
	        handler: function(){
	        	ExtUtils.info('开始扫描证件');
	        } 
	    }]
    });
    
    //3、介绍信及相关资料扫描
    ssxzlPanel = Ext.create('Ext.Panel', { 
	    title: '介绍信及相关资料扫描', 
	    id : 'card2', 
	    items: [],
	    tbar: [ {
	        text: '开始扫描', 
	        handler: function(){
	        	ExtUtils.info('开始扫描介绍信及相关资料');
	        } 
	    }]
    });
    
    
     // 4、被查询人信息填写 
    bcxrxxPanel = Ext.create("ZTEsoft.form.SearchForm", {
    	id : 'card0',
        layout : 'column',
        hiddenBtns : true,
        frame : true,
        title : '被申请人信息',
        defaults : {
            labelAlign : 'right',
            labelWidth : 100,
            //xtype : 'textfield',
            style : 'margin-left:5px;margin-top:2px;margin-bottom:2px;'
        },
        items : [
        {
            fieldLabel : "身份证号码",
            xtype : "textfield",
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            width: 500,
            name : "userName"
        }]
    });
    
    //人口信息查询主要面板
    infoMainPanel = Ext.create('Ext.Panel', { 
	    title: '人口信息查询', 
	    layout: 'card', 
	    region : "center",
	    activeItem: 0,    //默认活动项 
	    id: 'cardPanel', 
	    items: [sqrxxPanel,zjPanel,ssxzlPanel],
	    tbar: ['->', { 
	        id: 'cardPrev', 
	        text: '« 上一步', 
	        disabled : true,
	        handler: Ext.Function.bind(cardNav, this, [-1]) 
	    }, { 
	        id: 'cardNext', 
	        text: '下一步 »', 
	        handler: Ext.Function.bind(cardNav, this, [1]) 
	    }]
    });
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [infoMainPanel]
    });

});
