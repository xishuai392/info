/**
 * @description Ehcache分页数据源
 * 
 * @author codeCreater
 * 
 */

Ext.define('component..demo.store.EhcacheStore', {
    extend : 'Ext.data.Store',
    model : 'component..demo.model.EhcacheModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/demo/ehcache/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
