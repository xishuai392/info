/**
 * @description 表,AUDIT_MENU
 * 
 * @author codeCreater
 */
Ext.define('component..permission.model.AuditMenuModel', {
    extend : 'Ext.data.Model',
    fields : [
       		{
	            name : 'menuId',
	            type : 'auto'
        	},
       		{
	            name : 'menuTitle',
	            type : 'auto'
        	},
       		{
	            name : 'menuIconPath',
	            type : 'auto'
        	},
       		{
	            name : 'urlString',
	            type : 'auto'
        	},
       		{
	            name : 'displayIndex',
	            type : 'auto'
        	},
       		{
	            name : 'height',
	            type : 'auto'
        	},
       		{
	            name : 'width',
	            type : 'auto'
        	},
       		{
	            name : 'parentMenuId',
	            type : 'auto'
        	}       
			]
});