/**
 * @description 窗口信息查询服务统计报表
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.report.store.QueryCzdwByGroupStoreNew', {
    extend : 'Ext.data.Store',
    model : 'component.report.model.ReportFullResultModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/report/queryReportGroupByCzdwDataNew.do'
    }

});
