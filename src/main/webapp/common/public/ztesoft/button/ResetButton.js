/**
 * 添加按钮
 */
Ext.define("ZTEsoft.button.ResetButton", {
	extend : "Ext.button.Button",
	alias : "widget.zteresetbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/arrow_rotate_anticlockwise.png',
			name : 'reset',
			text : '重置'
		});
		me.callParent([config]);
	}
});
