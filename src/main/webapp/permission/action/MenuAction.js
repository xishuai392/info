/**
 * 数据库交互管理类:AM_MENU表
 */

Ext.define("PM.action.MenuAction", {


    /**
     * 查询登录员工所拥有的菜单列表
     * 
     * @param {}
     *            callbackFunction
     */
    qryMenuListByLoginUser : function(callbackFunction) {
        var config = {
            url : "server/menus.localjson",
            callback : callbackFunction
        };
        ExtUtils.doAjaxQuerySync(config);
    }

});