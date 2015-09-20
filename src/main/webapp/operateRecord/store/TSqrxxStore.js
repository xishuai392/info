/**
 * @description TSqrxx分页数据源
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.operateRecord.store.TSqrxxStore', {
    extend : 'Ext.data.Store',
    model : 'component.operateRecord.model.TSqrxxModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/operateRecord/tsqrxx/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
