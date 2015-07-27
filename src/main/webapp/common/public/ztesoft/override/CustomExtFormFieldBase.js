/**
 * @description  
 * 处理表单详情页面输入框的光标闪烁问题、空格处理和xss校验
 * @author Administrator
 * @date 2015年7月8日
 */
Ext.override(Ext.form.field.Base, {
	initComponent : function(config) {
		this.callParent([config]);
		this.on('focus', function() {
			if (this.readOnly) {
				this.blur();
			}
		});
	},
	isValid:function(){
		var me=this;
		var isValid=me.callParent(arguments);
		if(isValid===false){
			return isValid;
		}
		var value=me.getValue();
		me.clearInvalid();
		if(me.allowBlank===false&&Ext.isString(value)&&Ext.isEmpty(Ext.String.trim(value))){
        	me.markInvalid(me.blankText);
        	isValid=false;
        }
        value=value+"";
        //mysql中varchar定义的长度的单位是字符，中文和英文字母都被当作1个字符来对待
//        if(value.getLength()>me.maxLength){
//        	me.markInvalid(Ext.String.format(me.maxLengthText,value.getLength()));
//        	isValid=false;
//        }
        if(!Ext.form.VTypes.xssStr(value,me)){
        	me.markInvalid(Ext.form.VTypes.xssStrText);
        	isValid=false;
        }
        return isValid;
	}
});
 
 
 
 