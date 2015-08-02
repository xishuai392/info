/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component.permission.view.AuditRolePanel', {

        region : "center",
        // isPage : true,
        title : "角色列表"
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizPanel.getBusizGrid().getStore(),
        items : [
	      	{
	            fieldLabel : "角色名称",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "roleName"
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
	        }]       

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
