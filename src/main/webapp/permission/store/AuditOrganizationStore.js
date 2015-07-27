/**
 * @description AuditOrganization分页数据源
 * 
 * @author codeCreater
 * 
 */

Ext.define('component..permission.store.AuditOrganizationStore', {
    extend : 'Ext.data.Store',
    model : 'component..permission.model.AuditOrganizationModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/permission/auditorganization/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
