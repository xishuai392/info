/**
 * 添加按钮
 */
Ext.define("ZTEsoft.button.AddButton", {
	extend : "Ext.button.Button",
	alias : "widget.zteaddbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/add.png',
			name : 'add',
			text : '新增'
		});
		me.callParent([config]);
	}
});
