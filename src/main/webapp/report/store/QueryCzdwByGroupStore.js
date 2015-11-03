/**
 * @description 窗口信息查询服务统计报表
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.report.store.QueryCzdwByGroupStore', {
    extend : 'Ext.data.Store',
    model : 'component.report.model.QueryReportModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/report/queryReportGroupByCzdwData.do'
    }

});
