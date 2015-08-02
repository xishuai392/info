/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component.permission.view.AuditUserPanel', {
        region : "center",
        // isPage : true,
        title : "用户列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "用户名称",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "userName"
        	},
	      	{
	            fieldLabel : "用户编码",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "userCode"
        	},
	      	{
	            fieldLabel : "状态",
	            xtype : "combo",
	            name : "state",
	            displayField : 'text',
	            valueField : 'value',
	            editable : false,
	            store : new Ext.data.ArrayStore({
	                fields : ['value', 'text'],
	                data : [['00A', '有效'], ['00X', '无效']]
	            })
	        },
	      	{
	            fieldLabel : "所属组织",
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
