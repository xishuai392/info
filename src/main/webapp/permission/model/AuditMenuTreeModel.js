/**
 * @description 表,AUDIT_MENU
 * 
 * @author codeCreater
 */
Ext.define('component.permission.model.AuditMenuTreeModel', {
    extend : 'Ext.data.Model',
    fields : [
    {
	            name : 'id',
	            type : 'auto'
        	},
        	{
	            name : 'text',
	            type : 'auto'
        	},
        	{
	            name : 'icon',
	            type : 'auto'
        	},
        	{
	            name : 'iconCls',
	            type : 'auto'
        	},
        	{
	            name : 'hrefTarget',
	            type : 'auto'
        	},
        	{
	            name : 'expandable',
	            type : 'auto'
        	},
        	{
	            name : 'leaf',
	            type : 'auto'
        	},
        	{
	            name : 'attributeMap',
	            type : 'auto'
        	},
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