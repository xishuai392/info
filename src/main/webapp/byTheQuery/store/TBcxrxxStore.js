/**
 * @description TBcxrxx分页数据源
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.byTheQuery.store.TBcxrxxStore', {
    extend : 'Ext.data.Store',
    model : 'component.byTheQuery.model.TBcxrxxModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/byTheQuery/tbcxrxx/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
