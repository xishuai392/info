/**
 * @description 被查询人信息
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.information.store.QueryResultInfoStore', {
    extend : 'Ext.data.Store',
    model : 'component.information.model.QueryResultInfoModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/information/queryByOther.do'
    }

});
