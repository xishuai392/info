/**
 * 废弃按钮
 */
Ext.define("ZTEsoft.button.UninstallButton", {
	extend : "Ext.button.Button",
	alias : "widget.zteuninstallbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/stop.png',
			name : 'uninstall',
			text : '作废'
		});
		me.callParent([config]);
	}
});
