/**
 * @description 数据库交互管理类
 * 
 * @author codeCreater
 */

Ext.define("component..permission.action.AuditRoleAction", {

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
            url : '/permission/auditrole/add.do',
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
            url : '/permission/auditrole/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            roleId
     * @param {}
     *            callbackFunction
     */
    delRecord : function(roleId, callbackFunction) {
        var config = {
            url : '/permission/auditrole/delete.do',
            params : {
                'roleId' : roleId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} roleId
     * @param {} callbackFunction
     */
    qryRecord : function(roleId, callbackFunction) {
        var config = {
            url : '/permission/auditrole/qryRecordInfo.do',
            params : {
                'roleId' : roleId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

})