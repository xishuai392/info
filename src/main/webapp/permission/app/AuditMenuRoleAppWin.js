/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component..permission.view.AuditMenuRolePanel', {
        region : "center",
        // isPage : true,
        title : "AuditMenuRole列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "menuRoleId",
	            xtype : "textfield",
	            name : "menuRoleId"
        	},
	      	{
	            fieldLabel : "roleId",
	            xtype : "textfield",
	            name : "roleId"
        	},
	      	{
	            fieldLabel : "menuId",
	            xtype : "textfield",
	            name : "menuId"
        	}	       
        ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
