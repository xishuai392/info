/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component..permission.view.AuditUserRolePanel', {
        region : "center",
        // isPage : true,
        title : "AuditUserRole列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "userRoleId",
	            xtype : "textfield",
	            name : "userRoleId"
        	},
	      	{
	            fieldLabel : "roleId",
	            xtype : "textfield",
	            name : "roleId"
        	},
	      	{
	            fieldLabel : "userId",
	            xtype : "textfield",
	            name : "userId"
        	},
	      	{
	            fieldLabel : "state",
	            xtype : "textfield",
	            name : "state"
        	},
	      	{
	            fieldLabel : "isNormal",
	            xtype : "textfield",
	            name : "isNormal"
        	},
	      	{
	            fieldLabel : "isBasic",
	            xtype : "textfield",
	            name : "isBasic"
        	}	       
        ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
