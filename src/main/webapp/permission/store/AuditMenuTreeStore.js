/**
 * @description 菜单数数据源
 * 
 */
Ext.define('component.permission.store.AuditMenuTreeStore', {
    extend : 'Ext.data.TreeStore',
    model : 'component.permission.model.AuditMenuTreeModel',
    nodeParam : 'parentMenuId',
    proxy : {
        type : 'ajax',
        reader: 'json',
        url : webRoot + 'permission/auditmenu/findByPid.do'
    },
    // 设置根节点
    root : {
        text : '主菜单',
        id : '-1',
        expanded : true
    }

});
