/**
 * 带清除按钮的文本框组件
 */
Ext.define('ZTEsoft.form.field.ClearTextField', {
	extend : 'Ext.form.field.Trigger',
	alias : ['widget.zteclear', 'widget.clearTextField'],
	trigger1Cls : Ext.baseCSSPrefix + 'form-clear-trigger',
	clear : function() {
		this.setValue(null);
	},
	onTrigger1Click : function() {
		this.clear();
	}
});