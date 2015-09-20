/**
 * @description 被查询人信息
 * 
 * @author codeCreater
 */
Ext.define('component.information.model.QueryResultInfoModel', {
    extend : 'Ext.data.Model',
    fields : [
    		{
	            name : 'bcxrxxId',
	            type : 'auto'
        	},
       		{
	            name : 'name',
	            type : 'auto'
        	},
       		{
	            name : 'idCardNum',
	            type : 'auto'
        	},
       		{
	            name : 'birthDate',
	            type : 'auto'
        	},
       		{
	            name : 'address',
	            type : 'auto'
        	},
       		{
	            name : 'populationType',
	            type : 'auto'
        	},
       		{
	            name : 'isHavingTR',
	            type : 'auto'
        	}
			]
});