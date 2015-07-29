/**
 * @description 数据库交互管理类
 * 
 * @author codeCreater
 */

Ext.define("component.permission.action.AuditMenuAction", {

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
            url : '/permission/auditmenu/add.do',
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
            url : '/permission/auditmenu/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            menuId
     * @param {}
     *            callbackFunction
     */
    delRecord : function(menuId, callbackFunction) {
        var config = {
            url : '/permission/auditmenu/delete.do',
            params : {
                'menuId' : menuId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} menuId
     * @param {} callbackFunction
     */
    qryRecord : function(menuId, callbackFunction) {
        var config = {
            url : '/permission/auditmenu/qryRecordInfo.do',
            params : {
                'menuId' : menuId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

})