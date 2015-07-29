/**
 * @description 表,EHCACHE
 * 
 * @author codeCreater
 */
Ext.define('component.demo.model.EhcacheModel', {
    extend : 'Ext.data.Model',
    fields : [
       		{
	            name : 'empId',
	            type : 'auto'
        	},
       		{
	            name : 'empName',
	            type : 'auto'
        	},
       		{
	            name : 'empAge',
	            type : 'auto'
        	},
       		{
	            name : 'empSex',
	            type : 'auto'
        	},
       		{
	            name : 'empBirthday',
	            type : 'auto'
        	}       
			]
});