/**
 * @description 数据库交互管理类
 * 
 * @author codeCreater
 */

Ext.define("component.permission.action.AuditMenuRoleAction", {

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
            url : '/permission/auditmenurole/add.do',
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
            url : '/permission/auditmenurole/update.do',
            params : params,
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },

    /**
     * 删除记录
     * 
     * @param {}
     *            menuRoleId
     * @param {}
     *            callbackFunction
     */
    delRecord : function(menuRoleId, callbackFunction) {
        var config = {
            url : '/permission/auditmenurole/delete.do',
            params : {
                'menuRoleId' : menuRoleId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 查询某条记录
     * @param {} menuRoleId
     * @param {} callbackFunction
     */
    qryRecord : function(menuRoleId, callbackFunction) {
        var config = {
            url : '/permission/auditmenurole/qryRecordInfo.do',
            params : {
                'menuRoleId' : menuRoleId
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    },
    
    /**
     * 保存选中的菜单节点
     * @param {} roleId
     * @param {} menuIds
     * @param {} callbackFunction
     */
    saveMenuRole :function(roleId,menuIds,callbackFunction){
    	var config = {
            url : '/permission/auditmenurole/saveMenuRole.do',
            params : {
                'roleId' : roleId,
                'menuIds' : menuIds
            },
            callback : callbackFunction
        };

        ExtUtils.doAjax(config);
    }

});