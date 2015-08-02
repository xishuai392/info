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
            url : "base/getGeneralTree.do?sqlKey=com.ztesoft.web.common.db.dao.mapper.GeneralTreeMapper.menuTree",
            callback : callbackFunction
        };
        ExtUtils.doAjaxQuerySync(config);
    }

});