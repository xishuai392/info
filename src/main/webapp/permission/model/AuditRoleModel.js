/**
 * @description 表,AUDIT_ROLE
 * 
 * @author codeCreater
 */
Ext.define('component..permission.model.AuditRoleModel', {
    extend : 'Ext.data.Model',
    fields : [
       		{
	            name : 'roleId',
	            type : 'auto'
        	},
       		{
	            name : 'roleName',
	            type : 'auto'
        	},
       		{
	            name : 'comments',
	            type : 'auto'
        	},
       		{
	            name : 'stateDate',
	            type : 'auto'
        	},
       		{
	            name : 'state',
	            type : 'auto'
        	},
       		{
	            name : 'createdDate',
	            type : 'auto'
        	}       
			]
});