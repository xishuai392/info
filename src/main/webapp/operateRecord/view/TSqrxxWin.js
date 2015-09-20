/**
 * @description 新增修改共用弹出窗口，嵌入一个EditForm，实现对TSqrxx的新增、修改
 * @author codeCreater
 * @date 2014年11月20日
 */

Ext.define('component.operateRecord.view.TSqrxxWin', {
    extend : 'ZTEsoft.window.PopWindow',
    config : {
        formPanel : null,
        action : Ext.create("component.operateRecord.action.TSqrxxAction")
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
                var model = Ext.create("component.operateRecord.model.TSqrxxModel");
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
                var model = Ext.create("component.operateRecord.model.TSqrxxModel");
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
	            xtype : "textfield",
	            name : "zjlx"
        	},
	      	{
	            fieldLabel : "查询类型",
	            xtype : "textfield",
	            name : "cxsqrlx"
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