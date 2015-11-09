/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component.operateRecord.view.TSqrxxPanel', {

        region : "center",
        // isPage : true,
        title : "申请人信息列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
     	      	{
    	            fieldLabel : "id",
    	            xtype : "textfield",
    	            hidden : true,
    	            name : "id"
            	},
    	      	{
    	            fieldLabel : "姓名",
    	            xtype : "textfield",
    	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
    	            name : "xm"
            	},
    	      	{
    	            fieldLabel : "证件号",
    	            xtype : "textfield",
    	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
    	            name : "zjh"
            	},
    	      	{
    	            fieldLabel : "证件类型",
    	            xtype : "combo",
    	            name : "zjlx",
    	            displayField : 'text',
    	            valueField : 'value',
    	            value : '',
    	            editable : false,
    	            store : new Ext.data.ArrayStore({
    	                fields : ['value', 'text'],
    	                data : [['', '全部'], ['10', '身份证'], ['20', '其他']]
    	            })
            	},
    	      	{
    	            fieldLabel : "查询类型",
    	            xtype : "combo",
    	            name : "cxsqrlx",
    	            displayField : 'text',
    	            valueField : 'value',
    	            value : '',
    	            editable : false,
    	            store : new Ext.data.ArrayStore({
    	                fields : ['value', 'text'],
    	                data : [['', '全部'], ['10', '律师'], ['20', '党政军机关'], ['30', '司法机关'], ['40', '企事业单位'], ['50', '个人'], ['60', '人民团体'], ['70', '其他']]
    	            })
            	},
    	      	{
    	            fieldLabel : "cxrdw",
    	            xtype : "textfield",
    	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
    	            hidden : true,
    	            name : "cxrdw"
            	},
    	      	{
    	            fieldLabel : "cxsy",
    	            xtype : "textfield",
    	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
    	            hidden : true,
    	            name : "cxsy"
            	},
            	{
		            fieldLabel : "查询起始日期",
		            xtype : "datefield",
		            format : 'Y-m-d',
		            value : new Date(),
		            afterSubTpl : WEBConstants.REQUIRED,
		            editable : false,
		            name : "startDate"
		        }, {
		            fieldLabel : "查询结束日期",
		            xtype : "datefield",
		            format : 'Y-m-d',
		            value : new Date(),
		            vtype : "compare",
		            target : 'startDate',
		            editable : false,
		            name : "endDate"
		        },
    	      	{
    	            fieldLabel : "czdw",
    	            xtype : "textfield",
    	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
    	            hidden : true,
    	            name : "czdw"
            	},
    	      	{
    	            fieldLabel : "czr",
    	            xtype : "textfield",
    	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
    	            hidden : true,
    	            name : "czr"
            	},
            	{
    	            fieldLabel : "查询来源",
    	            xtype : "combo",
    	            name : "cxbs",
    	            hidden : true,
    	            displayField : 'text',
    	            valueField : 'value',
    	            value : '',
    	            editable : false,
    	            store : new Ext.data.ArrayStore({
    	                fields : ['value', 'text'],
    	                data : [['', '全部'], ['10', '终端'], ['20', '窗口']]
    	            })
            	}	       
            ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
