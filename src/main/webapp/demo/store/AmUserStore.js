/**
 * @description AM_USER分页数据源,DEMO
 * 
 * @author pan.xiaobo
 * 
 */

Ext.define('component.demo.store.AmUserStore', {
    extend : 'Ext.data.Store',
    model : 'component.demo.model.AmUserModel',
    proxy : {
        type : 'ajax',
        url : webRoot + 'demo/amuser/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }

});
