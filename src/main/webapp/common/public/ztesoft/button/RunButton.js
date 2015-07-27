/**
 * 发布按钮
 */
Ext.define("ZTEsoft.button.RunButton", {
	extend : "Ext.button.Button",
	alias : "widget.zterunbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/run.png',
			name : 'run',
			text : '发布'
		});
		me.callParent([config]);
	}
});
