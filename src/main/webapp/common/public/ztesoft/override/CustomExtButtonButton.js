/**
 * @description  
 * 按钮权限
 * @author Administrator
 * @date 2015年7月8日
 */
Ext.override(Ext.button.Button, {
	enable:function(){
		if(this.hasPrivilege===false){
			return;
		}else{
			this.callParent(arguments);
		}
	}
});
 
 
 
 