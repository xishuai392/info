/**
 * @description am_user表,DEMO
 * 
 * @author pan.xiaobo
 */
Ext.define('component.demo.model.AmUserModel', {
    extend : 'Ext.data.Model',
    fields : [
        {
            name : 'userId',
            type : 'int'
        },
        {
            name : 'userName',
            type : 'string'
        },
        {
            name : 'userCode',
            type : 'string'
        },
        {
            name : 'nickName',
            type : 'string'
        },
        {
            name : 'telephone',
            type : 'string'
        },
        {
            name : 'email',
            type : 'string'
        },
        {
            name : 'age',
            type : 'string'
        },
        {
            name : 'password',
            type : 'string'
        },
        {
            name : 'state',
            type : 'string'
        },
        {
            name : 'createdDate',
            type : 'string'
        },
        {
            name : 'testNumberOne',
            type : 'auto'
        },
        {
            name : 'testNumberTwo',
            type : 'auto'
        },
        {
            name : 'testDoubleOne',
            type : 'auto'
        },
        {
            name : 'testDoubleTwo',
            type : 'auto'
        },
        {
            name : 'photo',
            type : 'auto'
        },
        {
            name : 'testText',
            type : 'auto'
        }]
})