/**
 *暂停按钮
 */
Ext.define("ZTEsoft.button.PauseButton", {
	extend : "Ext.button.Button",
	alias : "widget.ztepausebutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/pause.png',
			name : 'pause',
			text : '暂停'
		});
		me.callParent([config]);
	}
});
