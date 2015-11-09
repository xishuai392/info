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
        url : webRoot + '/byTheQuery/tbcxrxx/select4Page.do',
        actionMethods: {
            create : 'POST',
            read   : 'POST', // by default GET
            update : 'POST',
            destroy: 'POST'
        },
        reader : ztesoft_pageReader
    }

});
