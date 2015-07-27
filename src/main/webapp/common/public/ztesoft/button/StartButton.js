/**
 * 废弃按钮
 */
Ext.define("ZTEsoft.button.StartButton", {
	extend : "Ext.button.Button",
	alias : "widget.ztestartbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/play.png',
			name : 'start',
			text : '启动'
		});
		me.callParent([config]);
	}
});
