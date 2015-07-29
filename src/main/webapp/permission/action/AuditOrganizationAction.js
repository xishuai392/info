/**
 * @description 数据库交互管理类
 * 
 * @author codeCreater
 */

Ext.define("component.permission.action.AuditOrganizationAction", {

    /**
     * 新增记录
     * 
     * @param {}
     *            params
     * @param {}
     *            callbackFunction
     */
    addRecord : function(params, callbackFunction) {
        var config = {
            url : '/permission/auditorganization/add.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 修改记录
     * 
     * @param {}
     *            params
     * @param {}
     *            callbackFunction
     */
    modRecord : function(params, callbackFunction) {
        var config = {
            url : '/permission/auditorganization/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            orgId
     * @param {}
     *            callbackFunction
     */
    delRecord : function(orgId, callbackFunction) {
        var config = {
            url : '/permission/auditorganization/delete.do',
            params : {
                'orgId' : orgId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} orgId
     * @param {} callbackFunction
     */
    qryRecord : function(orgId, callbackFunction) {
        var config = {
            url : '/permission/auditorganization/qryRecordInfo.do',
            params : {
                'orgId' : orgId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

})