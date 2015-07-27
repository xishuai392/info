/**
 * @description 数据库交互管理类,用户信息管理 DEMO
 * 
 * @author pan.xiaobo
 */

Ext.define("component.demo.action.AmUserAction", {

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
            url : 'demo/amuser/add.do',
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
            url : 'demo/amuser/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            userId
     * @param {}
     *            callbackFunction
     */
    delRecord : function(userId, callbackFunction) {
        var config = {
            url : 'demo/amuser/delete.do',
            params : {
                'userId' : userId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} userId
     * @param {} callbackFunction
     */
    qryRecord : function(userId, callbackFunction) {
        var config = {
            url : 'demo/amuser/qryRecordInfo.do',
            params : {
                'userId' : userId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

})