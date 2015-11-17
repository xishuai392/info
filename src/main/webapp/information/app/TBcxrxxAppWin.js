/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component.information.view.TBcxrxxPanel', {

        region : "center",
        // isPage : true,
        title : "TBcxrxx列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "id",
	            xtype : "textfield",
	            name : "id"
        	},
	      	{
	            fieldLabel : "sqrId",
	            xtype : "textfield",
	            name : "sqrId"
        	},
	      	{
	            fieldLabel : "zjh",
	            xtype : "textfield",
	            name : "zjh"
        	},
	      	{
	            fieldLabel : "zjlx",
	            xtype : "textfield",
	            name : "zjlx"
        	},
	      	{
	            fieldLabel : "xm",
	            xtype : "textfield",
	            name : "xm"
        	},
	      	{
	            fieldLabel : "sfzzp",
	            xtype : "textfield",
	            name : "sfzzp"
        	},
	      	{
	            fieldLabel : "sfzf",
	            xtype : "textfield",
	            name : "sfzf"
        	},
	      	{
	            fieldLabel : "zfly",
	            xtype : "textfield",
	            name : "zfly"
        	},
	      	{
	            fieldLabel : "sfdy",
	            xtype : "textfield",
	            name : "sfdy"
        	},
	      	{
	            fieldLabel : "bcxrq",
	            xtype : "textfield",
	            name : "bcxrq"
        	},
	      	{
	            fieldLabel : "xgrq",
	            xtype : "textfield",
	            name : "xgrq"
        	},
	      	{
	            fieldLabel : "rklx",
	            xtype : "textfield",
	            name : "rklx"
        	},
	      	{
	            fieldLabel : "cxcs",
	            xtype : "textfield",
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
