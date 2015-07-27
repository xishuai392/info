/**
 * @description AuditMenuRole分页数据源
 * 
 * @author codeCreater
 * 
 */

Ext.define('component..permission.store.AuditMenuRoleStore', {
    extend : 'Ext.data.Store',
    model : 'component..permission.model.AuditMenuRoleModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/permission/auditmenurole/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
