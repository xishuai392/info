/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component..permission.view.AuditMenuPanel', {
        region : "center",
        // isPage : true,
        title : "AuditMenu列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "menuId",
	            xtype : "textfield",
	            name : "menuId"
        	},
	      	{
	            fieldLabel : "menuTitle",
	            xtype : "textfield",
	            name : "menuTitle"
        	},
	      	{
	            fieldLabel : "menuIconPath",
	            xtype : "textfield",
	            name : "menuIconPath"
        	},
	      	{
	            fieldLabel : "urlString",
	            xtype : "textfield",
	            name : "urlString"
        	},
	      	{
	            fieldLabel : "displayIndex",
	            xtype : "textfield",
	            name : "displayIndex"
        	},
	      	{
	            fieldLabel : "height",
	            xtype : "textfield",
	            name : "height"
        	},
	      	{
	            fieldLabel : "width",
	            xtype : "textfield",
	            name : "width"
        	},
	      	{
	            fieldLabel : "parentMenuId",
	            xtype : "textfield",
	            name : "parentMenuId"
        	}	       
        ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
