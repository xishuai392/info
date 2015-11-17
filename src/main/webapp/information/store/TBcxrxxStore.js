/**
 * @description TBcxrxx分页数据源
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.information.store.TBcxrxxStore', {
    extend : 'Ext.data.Store',
    model : 'component.information.model.TBcxrxxModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/information/tbcxrxx/select4Page.do',
        reader : ztesoft_pageReader
    }

});
