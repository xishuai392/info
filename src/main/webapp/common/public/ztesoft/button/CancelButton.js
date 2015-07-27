/**
 * 添加按钮
 */
Ext.define("ZTEsoft.button.CancelButton", {
	extend : "Ext.button.Button",
	alias : "widget.ztecancelbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/arrow_undo.png',
			name : 'cancel',
			text : '取消'
		});
		me.callParent([config]);
	}
});
