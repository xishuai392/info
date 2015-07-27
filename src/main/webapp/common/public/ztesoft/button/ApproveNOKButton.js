/**
 * 审批不通过按钮
 */
Ext.define("ZTEsoft.button.ApproveNOKButton", {
	extend : "Ext.button.Button",
	alias : "widget.zteapprovenokbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/cross.png',
			name : 'approvenok',
			text : '审批不通过'
		});
		me.callParent([config]);
	}
});
