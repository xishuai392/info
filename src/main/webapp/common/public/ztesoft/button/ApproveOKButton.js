/**
 * 审批通过按钮
 */
Ext.define("ZTEsoft.button.ApproveOKButton", {
	extend : "Ext.button.Button",
	alias : "widget.zteapproveokbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/accept.png',
			name : 'approveok',
			text : '审批通过'
		});
		me.callParent([config]);
	}
});
