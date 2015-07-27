/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component..permission.view.AuditOrganizationPanel', {
        region : "center",
        // isPage : true,
        title : "AuditOrganization列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "orgId",
	            xtype : "textfield",
	            name : "orgId"
        	},
	      	{
	            fieldLabel : "parentOrgId",
	            xtype : "textfield",
	            name : "parentOrgId"
        	},
	      	{
	            fieldLabel : "orgCode",
	            xtype : "textfield",
	            name : "orgCode"
        	},
	      	{
	            fieldLabel : "orgName",
	            xtype : "textfield",
	            name : "orgName"
        	},
	      	{
	            fieldLabel : "orgLevel",
	            xtype : "textfield",
	            name : "orgLevel"
        	},
	      	{
	            fieldLabel : "createdTime",
	            xtype : "textfield",
	            name : "createdTime"
        	},
	      	{
	            fieldLabel : "orgDesc",
	            xtype : "textfield",
	            name : "orgDesc"
        	},
	      	{
	            fieldLabel : "state",
	            xtype : "textfield",
	            name : "state"
        	},
	      	{
	            fieldLabel : "stateTime",
	            xtype : "textfield",
	            name : "stateTime"
        	}	       
        ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
