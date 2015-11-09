/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component.byTheQuery.view.TBcxrxxPanel', {

        region : "center",
        // isPage : true,
        title : "被查询人列表"
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
	            fieldLabel : "sqrId",
	            xtype : "textfield",
	            hidden : true,
	            name : "sqrId"
        	},
	      	
	      	{
	            fieldLabel : "zjlx",
	            xtype : "textfield",
	            hidden : true,
	            name : "zjlx"
        	},
        	{
	            fieldLabel : "查询人姓名",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "sqrXm"
        	},
	      	{
	            fieldLabel : "被查询人姓名",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "xm"
        	},
        	{
	            fieldLabel : "被查询人证件号",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "zjh"
        	},
	      	{
	            fieldLabel : "sfzzp",
	            xtype : "textfield",
	            hidden : true,
	            name : "sfzzp"
        	},
	      	{
	            fieldLabel : "sfzf",
	            xtype : "textfield",
	            hidden : true,
	            name : "sfzf"
        	},
	      	{
	            fieldLabel : "zfly",
	            xtype : "textfield",
	            hidden : true,
	            name : "zfly"
        	},
	      	{
	            fieldLabel : "sfdy",
	            xtype : "textfield",
	            hidden : true,
	            name : "sfdy"
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
	            fieldLabel : "xgrq",
	            xtype : "textfield",
	            hidden : true,
	            name : "xgrq"
        	},
	      	{
	            fieldLabel : "rklx",
	            xtype : "textfield",
	            hidden : true,
	            name : "rklx"
        	},
	      	{
	            fieldLabel : "cxcs",
	            xtype : "textfield",
	            hidden : true,
	            name : "cxcs"
        	}	       
        ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
