/**
 * @description t_sqrxxfj
 * 
 * @author codeCreater
 * 
 */
Ext.define('component.information.store.TsqrxxfjStore', {
    extend : 'Ext.data.Store',
    model : 'component.information.model.ImageModel',
    proxy : {
        type : 'ajax',
        url : webRoot + '/information/tsqrxxfj/qryList.do',
        reader : {
            type : 'json'
        }
    }

});
