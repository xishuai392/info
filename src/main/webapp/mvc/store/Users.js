Ext.define('AM.store.Users', {
    extend : 'Ext.data.Store',
    model : 'AM.model.User',
    autoLoad : true,

    proxy : {
        type : 'ajax',
        url : webRoot + 'demo/amuser/queryRecordByPage.do',
        reader : ztesoft_pageReader
    }
//    proxy : {
//        type : 'ajax',
//        api : {
//            read : webRoot + 'data/users.json',
//            update : webRoot + 'data/updateUsers.json'
//        },
//        reader : {
//            type : 'json',
//            root : 'users',
//            successProperty : 'success'
//        }
//    }
});