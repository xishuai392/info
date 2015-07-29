/**
 * @description 数据库交互管理类
 * 
 * @author codeCreater
 */

Ext.define("component.permission.action.AuditUserRoleAction", {

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
            url : '/permission/audituserrole/add.do',
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
            url : '/permission/audituserrole/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            userRoleId
     * @param {}
     *            callbackFunction
     */
    delRecord : function(userRoleId, callbackFunction) {
        var config = {
            url : '/permission/audituserrole/delete.do',
            params : {
                'userRoleId' : userRoleId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} userRoleId
     * @param {} callbackFunction
     */
    qryRecord : function(userRoleId, callbackFunction) {
        var config = {
            url : '/permission/audituserrole/qryRecordInfo.do',
            params : {
                'userRoleId' : userRoleId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

})