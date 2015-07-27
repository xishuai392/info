Ext.define('AM.view.user.List' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.userlist',

    title : 'All Users',
    store: 'Users',

    columns: [
        {header: 'userName',  dataIndex: 'userName',  flex: 1},
        {header: 'userCode',  dataIndex: 'userCode',  flex: 1},
        {header: 'nickName',  dataIndex: 'nickName',  flex: 1},
        {header: 'telephone',  dataIndex: 'telephone',  flex: 1},
        {header: 'age',  dataIndex: 'age',  flex: 1},
        {header: 'Email', dataIndex: 'email', flex: 1}
    ]
});
