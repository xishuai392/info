/**
 * 添加按钮
 */
Ext.define("ZTEsoft.button.OkButton", {
	extend : "Ext.button.Button",
	alias : "widget.zteokbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/accept.png',
			name : 'ok',
			text : '确定'
		});
		me.callParent([config]);
	}
});
