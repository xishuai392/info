/**
 * 添加按钮
 */
Ext.define("ZTEsoft.button.DelButton", {
	extend : "Ext.button.Button",
	alias : "widget.ztedelbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/delete.png',
			name : 'del',
			text : '删除'
		});
		me.callParent([config]);
	}
});
