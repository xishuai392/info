/**
 * @description 数据库交互管理类
 * 
 * @author codeCreater
 */

Ext.define("component.demo.action.EhcacheAction", {

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
            url : '/demo/ehcache/add.do',
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
            url : '/demo/ehcache/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            empId
     * @param {}
     *            callbackFunction
     */
    delRecord : function(empId, callbackFunction) {
        var config = {
            url : '/demo/ehcache/delete.do',
            params : {
                'empId' : empId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} empId
     * @param {} callbackFunction
     */
    qryRecord : function(empId, callbackFunction) {
        var config = {
            url : '/demo/ehcache/qryRecordInfo.do',
            params : {
                'empId' : empId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

})