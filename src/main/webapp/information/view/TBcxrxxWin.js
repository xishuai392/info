/**
 * @description 新增修改共用弹出窗口，嵌入一个EditForm，实现对TBcxrxx的新增、修改
 * @author codeCreater
 * @date 2014年11月20日
 */

Ext.define('component.information.view.TBcxrxxWin', {
    extend : 'ZTEsoft.window.PopWindow',
    config : {
        formPanel : null,
        action : Ext.create("component.information.action.TBcxrxxAction")
    },
    /**
     * 构造函数，用于初始化界面
     * 
     * @param {}
     *            config
     */
    constructor : function(config) {
        config = config || {};

        var me = this;

        // TODO 设置额外的参数
        me.pkFiledId = config.pkFiledId;

        me.winType = config.winType;

        // 创建表单
        me.formPanel = me.createFormPanel();

        if (me.winType == WEBConstants.ACTIONTYPE.VIEW) {
            config.title = '详情';
        }
        if (me.winType == WEBConstants.ACTIONTYPE.NEW) {
            config.title = '新增';
        }
        if (me.winType == WEBConstants.ACTIONTYPE.EDIT) {
            config.title = '编辑';
        }
        Ext.applyIf(config, {
            width : '30%',
            height : '50%',
            layout : 'fit',
            maximizable : true,
            items : [me.formPanel],
            resizable : true
        });
        this.callParent([config]);
    },
    // 初始化界面
    initComponent : function() {
        var me = this;

        // 编辑
        if (me.winType == WEBConstants.ACTIONTYPE.EDIT) {

            // TODO 隐藏或显示某些字段
            // me.formPanel.getForm().findField("createdDate").setVisible(false);
            me.getAction().qryRecord(me.pkFiledId, function(result) {
                var model = Ext.create("component.information.model.TBcxrxxModel");
                model.data = result;
                me.formPanel.getForm().loadRecord(model);
            });
        }
        // 新增
        if (me.winType == WEBConstants.ACTIONTYPE.NEW) {

            // TODO 隐藏或显示某些字段，或设定默认值等
            // me.formPanel.getForm().findField("createdDate").setVisible(false);
        }
        // 详情
        if (me.winType == WEBConstants.ACTIONTYPE.VIEW) {
            me.getAction().qryRecord(me.pkFiledId, function(result) {
                var model = Ext.create("component.information.model.TBcxrxxModel");
                model.data = result;
                me.formPanel.getForm().loadRecord(model);
                me.formPanel.disableFields();
            });
        }

        this.callParent();
    },

    // 创建编辑表单
    createFormPanel : function() {
        var me = this;
        var formPanel = Ext.create('ZTEsoft.form.EditForm', {
            itemId : 'editForm',
            columnNum : 1,
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
        return formPanel;
    },
    // 确定按钮回调函数，在此处理新增、修改操作
    okHandler : function() {
        var me = this;
        if (!me.formPanel.getForm().isValid()) {
            return;
        }
        var params = me.formPanel.getForm().getValues();
        // TODO 设置或清除不传递到后台的值
        // delete params.createdDate;
        // params.xxxx = xxxx;

        // 新增
        if (me.winType == WEBConstants.ACTIONTYPE.NEW) {

            me.getAction().addRecord(params, function(result) {
                // 再回调父组件（Grid）的响应函数，用于更新父组件的记录
                me.callback(result);
                me.close();
            });
        }
        // 修改
        if (me.winType == WEBConstants.ACTIONTYPE.EDIT) {
            params.userId = me.pkFiledId;
            me.getAction().modRecord(params, function(result) {
                // 再回调父组件（Grid）的响应函数，用于更新父组件的记录
                me.callback(result);
                me.close();
            });
        }

        // 详情
        if (me.winType == WEBConstants.ACTIONTYPE.VIEW) {
            me.close();
        }

    }

});