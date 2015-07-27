/**
 * 添加按钮
 */
Ext.define("ZTEsoft.button.EditButton", {
	extend : "Ext.button.Button",
	alias : "widget.zteeditbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/edit.png',
			name : 'edit',
			text : '修改'
		});
		me.callParent([config]);
	}
});
