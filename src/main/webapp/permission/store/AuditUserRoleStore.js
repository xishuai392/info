/**
 * @description AuditUserRole分页数据源
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.permission.store.AuditUserRoleStore', {
    extend : 'Ext.data.Store',
    model : 'component.permission.model.AuditUserRoleModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/permission/audituserrole/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
