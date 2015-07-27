/**
 * @description 表,AUDIT_USER_ROLE
 * 
 * @author codeCreater
 */
Ext.define('component..permission.model.AuditUserRoleModel', {
    extend : 'Ext.data.Model',
    fields : [
       		{
	            name : 'userRoleId',
	            type : 'auto'
        	},
       		{
	            name : 'roleId',
	            type : 'auto'
        	},
       		{
	            name : 'userId',
	            type : 'auto'
        	},
       		{
	            name : 'state',
	            type : 'auto'
        	},
       		{
	            name : 'isNormal',
	            type : 'auto'
        	},
       		{
	            name : 'isBasic',
	            type : 'auto'
        	}       
			]
});