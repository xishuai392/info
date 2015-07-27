/**
 * 添加按钮
 */
Ext.define("ZTEsoft.button.QueryButton", {
	extend : "Ext.button.Button",
	alias : "widget.ztequerybutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/magnifier.png',
			name : 'query',
			text : '查询'
		});
		me.callParent([config]);
	}
});
