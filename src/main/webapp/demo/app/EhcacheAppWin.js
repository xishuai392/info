/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component..demo.view.EhcachePanel', {
        region : "center",
        // isPage : true,
        title : "Ehcache列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "empId",
	            xtype : "textfield",
	            name : "empId"
        	},
	      	{
	            fieldLabel : "empName",
	            xtype : "textfield",
	            name : "empName"
        	},
	      	{
	            fieldLabel : "empAge",
	            xtype : "textfield",
	            name : "empAge"
        	},
	      	{
	            fieldLabel : "empSex",
	            xtype : "textfield",
	            name : "empSex"
        	},
	      	{
	            fieldLabel : "empBirthday",
	            xtype : "textfield",
	            name : "empBirthday"
        	}	       
        ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
