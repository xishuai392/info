/**
 * 详细内容按钮
 */
Ext.define("ZTEsoft.button.DetailButton", {
	extend : "Ext.button.Button",
	alias : "widget.ztedetailbutton",
	constructor : function(config) {
		var me = this;
		config = config || {};
		Ext.applyIf(config, {
			icon : ctx + '/common/images/icons/application_view_detail.png',
			name : 'detail',
			text : '查看'
		});
		me.callParent([config]);
	}
});
