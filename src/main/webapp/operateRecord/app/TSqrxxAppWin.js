/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizPanel, thizSearchForm;;

    // 记录表格
    thizPanel = Ext.create('component.operateRecord.view.TSqrxxPanel', {

        region : "center",
        // isPage : true,
        title : "申请人信息列表"
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
    	            fieldLabel : "姓名",
    	            xtype : "textfield",
    	            name : "xm"
            	},
    	      	{
    	            fieldLabel : "证件号",
    	            xtype : "textfield",
    	            name : "zjh"
            	},
    	      	{
    	            fieldLabel : "证件类型",
    	            xtype : "combo",
    	            name : "zjlx",
    	            displayField : 'text',
    	            valueField : 'value',
    	            editable : false,
    	            store : new Ext.data.ArrayStore({
    	                fields : ['value', 'text'],
    	                data : [['', '全部'], ['10', '身份证'], ['20', '其他']]
    	            })
            	},
    	      	{
    	            fieldLabel : "查询类型",
    	            xtype : "combo",
    	            name : "cxsqrlx",
    	            displayField : 'text',
    	            valueField : 'value',
    	            editable : false,
    	            store : new Ext.data.ArrayStore({
    	                fields : ['value', 'text'],
    	                data : [['', '全部'], ['10', '律师'], ['20', '党政军机关'], ['30', '司法机关'], ['40', '企事业单位'], ['50', '个人'], ['60', '人民团体'], ['70', '其他']]
    	            })
            	},
    	      	{
    	            fieldLabel : "cxrdw",
    	            xtype : "textfield",
    	            hidden : true,
    	            name : "cxrdw"
            	},
    	      	{
    	            fieldLabel : "cxsy",
    	            xtype : "textfield",
    	            hidden : true,
    	            name : "cxsy"
            	},
    	      	{
    	            fieldLabel : "日期",
    	            xtype : "textfield",
    	            name : "cxrq"
            	},
    	      	{
    	            fieldLabel : "czdw",
    	            xtype : "textfield",
    	            hidden : true,
    	            name : "czdw"
            	},
    	      	{
    	            fieldLabel : "czr",
    	            xtype : "textfield",
    	            hidden : true,
    	            name : "czr"
            	},
    	      	{
    	            fieldLabel : "cxbs",
    	            xtype : "textfield",
    	            hidden : true,
    	            name : "cxbs"
            	}	       
            ]

    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizPanel]
    });

});
