Ext.define('AM.model.User', {
    extend : 'Ext.data.Model',

    requires : ['Ext.data.reader.Json'],

    fields : [{
        name : 'userId',
        type : 'int'
    }, {
        name : 'userName',
        type : 'string'
    }, {
        name : 'userCode',
        type : 'string'
    }, {
        name : 'nickName',
        type : 'string'
    }, {
        name : 'telephone',
        type : 'string'
    }, {
        name : 'email',
        type : 'string'
    }, {
        name : 'age',
        type : 'string'
    }, {
        name : 'password',
        type : 'string'
    }, {
        name : 'state',
        type : 'string'
    }, {
        name : 'createdDate',
        type : 'string'
    }]
});