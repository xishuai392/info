/**
 * @description 表,AUDIT_ORGANIZATION
 * 
 * @author codeCreater
 */
Ext.define('component.permission.model.AuditOrganizationModel', {
    extend : 'Ext.data.Model',
    fields : [
       		{
	            name : 'orgId',
	            type : 'auto'
        	},
       		{
	            name : 'parentOrgId',
	            type : 'auto'
        	},
       		{
	            name : 'orgCode',
	            type : 'auto'
        	},
       		{
	            name : 'orgName',
	            type : 'auto'
        	},
       		{
	            name : 'orgLevel',
	            type : 'auto'
        	},
       		{
	            name : 'createdTime',
	            type : 'auto'
        	},
       		{
	            name : 'orgDesc',
	            type : 'auto'
        	},
       		{
	            name : 'state',
	            type : 'auto'
        	},
       		{
	            name : 'stateTime',
	            type : 'auto'
        	}       
			]
});