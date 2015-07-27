/**
 * @description AuditRole分页数据源
 * 
 * @author codeCreater
 * 
 */

Ext.define('component..permission.store.AuditRoleStore', {
    extend : 'Ext.data.Store',
    model : 'component..permission.model.AuditRoleModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/permission/auditrole/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
