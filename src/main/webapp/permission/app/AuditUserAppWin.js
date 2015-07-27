/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component..permission.view.AuditUserPanel', {
        region : "center",
        // isPage : true,
        title : "AuditUser列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "userId",
	            xtype : "textfield",
	            name : "userId"
        	},
	      	{
	            fieldLabel : "userName",
	            xtype : "textfield",
	            name : "userName"
        	},
	      	{
	            fieldLabel : "userCode",
	            xtype : "textfield",
	            name : "userCode"
        	},
	      	{
	            fieldLabel : "telephone",
	            xtype : "textfield",
	            name : "telephone"
        	},
	      	{
	            fieldLabel : "email",
	            xtype : "textfield",
	            name : "email"
        	},
	      	{
	            fieldLabel : "password",
	            xtype : "textfield",
	            name : "password"
        	},
	      	{
	            fieldLabel : "age",
	            xtype : "textfield",
	            name : "age"
        	},
	      	{
	            fieldLabel : "state",
	            xtype : "textfield",
	            name : "state"
        	},
	      	{
	            fieldLabel : "createdDate",
	            xtype : "textfield",
	            name : "createdDate"
        	},
	      	{
	            fieldLabel : "orgId",
	            xtype : "textfield",
	            name : "orgId"
        	}	       
        ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
