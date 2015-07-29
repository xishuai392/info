/**
 * @description 表,AUDIT_MENU_ROLE
 * 
 * @author codeCreater
 */
Ext.define('component.permission.model.AuditMenuRoleModel', {
    extend : 'Ext.data.Model',
    fields : [
       		{
	            name : 'menuRoleId',
	            type : 'auto'
        	},
       		{
	            name : 'roleId',
	            type : 'auto'
        	},
       		{
	            name : 'menuId',
	            type : 'auto'
        	}       
			]
});