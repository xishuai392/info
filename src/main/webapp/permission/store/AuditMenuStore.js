/**
 * @description AuditMenu分页数据源
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.permission.store.AuditMenuStore', {
    extend : 'Ext.data.Store',
    model : 'component.permission.model.AuditMenuModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/permission/auditmenu/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
