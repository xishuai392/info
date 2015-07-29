/**
 * @description AuditUser分页数据源
 * 
 * @author codeCreater
 * 
 */

Ext.define('component.permission.store.AuditUserStore', {
    extend : 'Ext.data.Store',
    model : 'component.permission.model.AuditUserModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/permission/audituser/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
