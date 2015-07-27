/**
 * @description  
 * 处理表单详情页面输入框的光标闪烁问题
 * 文本输入框+按钮的组件会继承该基类，如下拉框
 * @author Administrator
 * @date 2015年7月8日
 */
Ext.override(Ext.form.field.Trigger, {
	initComponent : function(config) {
		this.callParent([config]);
		this.on('afterrender', function() {
			var me=this;
			Ext.get(this.inputEl).on('focus', function() {
				if (me.readOnly) {
					this.blur();
				}
			});
		});
	}
});
 
 
 
 