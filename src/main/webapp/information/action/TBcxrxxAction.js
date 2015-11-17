/**
 * @description 数据库交互管理类
 * 
 * @author codeCreater
 */

Ext.define("component.information.action.TBcxrxxAction", {

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
            url : '/information/tbcxrxx/add.do',
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
            url : '/information/tbcxrxx/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            id
     * @param {}
     *            callbackFunction
     */
    delRecord : function(id, callbackFunction) {
        var config = {
            url : '/information/tbcxrxx/delete.do',
            params : {
                'id' : id
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} id
     * @param {} callbackFunction
     */
    qryRecord : function(id, callbackFunction) {
        var config = {
            url : '/information/tbcxrxx/qryRecordInfo.do',
            params : {
                'id' : id
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

});