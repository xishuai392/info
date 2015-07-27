/**
 * @description 表,AUDIT_USER
 * 
 * @author codeCreater
 */
Ext.define('component..permission.model.AuditUserModel', {
    extend : 'Ext.data.Model',
    fields : [
       		{
	            name : 'userId',
	            type : 'auto'
        	},
       		{
	            name : 'userName',
	            type : 'auto'
        	},
       		{
	            name : 'userCode',
	            type : 'auto'
        	},
       		{
	            name : 'telephone',
	            type : 'auto'
        	},
       		{
	            name : 'email',
	            type : 'auto'
        	},
       		{
	            name : 'password',
	            type : 'auto'
        	},
       		{
	            name : 'age',
	            type : 'auto'
        	},
       		{
	            name : 'state',
	            type : 'auto'
        	},
       		{
	            name : 'createdDate',
	            type : 'auto'
        	},
       		{
	            name : 'orgId',
	            type : 'auto'
        	}       
			]
});