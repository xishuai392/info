Ext.define('PM.view.mains.Header', {
    extend : 'Ext.panel.Panel',
    alias : 'widget.zteheader',
    initComponent : function() {
        this.callParent(arguments);
    },
    constructor : function(config) {
        var me = this;
        config = config || {};
        Ext.applyIf(this, {
            xtype : 'box',
            cls : 'header',
            region : 'north',
            // html : '<h1>阳光计费稽核系统</h1>',
            bodyStyle : 'border-bottom:0',
            height : 59,
            dockedItems : [{
                xtype : 'toolbar',
                height : 59,
                style : 'background-image: url(' + ctx + '/common/images/logo.png) !important; background-repeat: no-repeat;background-position:center left;',
                dock : 'top',
                items : ['->', {
                    xtype : 'box',
                    html : '<img src="' + ctx + '/common/images/icons/user.png" style="width:16px;height:16px;"></img>'
                }, {
                    xtype : 'label',
                    name : 'staffInfo',
                    text : userSession.userName + '(' + userSession.userCode + '),欢迎登陆!'
                }, {
                    xtype : 'label',
                    text : '当前时间:'
                }, {
                    xtype : 'label',
                    name : 'clock',
                    style : 'margin-right:20px;',
                    // text:Ext.Date.format(new Date(), Date.patterns.LongTime),
                    listeners : {
                        'render' : function() {
                            var me = this;
                            var task = {
                                run : function() {
                                    me.setText(Ext.util.Format.date(new Date(), 'Y-m-d H:i:s A'));
                                },
                                interval : 1000
                            };
                            Ext.TaskManager.start(task);
                        }
                    }
                }, {
                    iconCls : 'loginOut',
                    scale : 'large',
                    handler : me.loginOut,
                    scope : me
                }]
            }]
        });
        me.callParent([config]);
    },
    getQueryParam : function(name, queryString) {
        var match = RegExp(name + '=([^&]*)').exec(queryString || location.search);
        if (match) {
            return decodeURIComponent(match[1]);
        } else {
            return null;
        }
    },
    setParam : function(param) {
        var queryString = Ext.Object.toQueryString(Ext.apply(Ext.Object.fromQueryString(location.search), param));
        location.search = queryString;
    },
    loginOut : function() {
        Ext.MessageBox.confirm(StrConstants.HINT, '确定要退出系统吗？', function(btn) {
            if (btn == 'yes') {
                Ext.Ajax.request({
                    url : ctx + '/login/loginOut.do',
                    method : 'POST',
                    success : function(response) {
                        window.top.location.href = ctx + '/login.jsp';
                    },
                    failure : function(response, action) {
                        ExtUtils.error('登出失败');
                    }
                });
            }

        });

    },
    updPassword : function() {
        Ext.create('Ext.window.Window', {
            id : 'updPassWordWin',
            title : '密码修改',
            height : 150,
            width : 300,
            layout : 'fit',
            items : { // Let's put an empty grid in just to illustrate fit
                // layout
                id : 'updPassWordForm',
                xtype : 'form',
                layout : 'anchor',
                url : ctx + '/user/saveUser.do',
                frame : true,
                // layout:'form',
                // The fields
                defaults : {
                    xtype : 'textfield',
                    labelAlign : 'right'
                },
                items : [{
                    fieldLabel : '旧密码',
                    inputType : 'password',
                    name : 'oldPassword',
                    allowBlank : false
                }, {
                    fieldLabel : '新密码',
                    name : 'newPassword',
                    inputType : 'password',
                    allowBlank : false
                }]
            },
            buttons : [{
                text : '确定',
                handler : function() {
                    var form = Ext.getCmp('updPassWordForm').getForm();
                    if (form.isValid()) {
                        Ext.getBody().mask("请稍等，密码修改中...", "x-mask-loading");
                        Ext.Ajax.request({
                            url : ctx + '/user/updPassword.do',
                            method : 'post',
                            disableCaching : true,
                            params : {
                                newPassword : form.findField('newPassword').getValue(),
                                oldPassword : form.findField('oldPassword').getValue()
                            },
                            success : function(response) {
                                var text = response.responseText;
                                if (text == 0) {
                                    Ext.Msg.alert('结果', '密码修改失败--你输入的旧密码错误');
                                } else {
                                    Ext.Msg.alert('结果', '密码修改成功');
                                    Ext.getCmp('updPassWordWin').close();
                                }
                                Ext.getBody().unmask();
                            }
                        });
                    }
                }
            }]
        }).show();
    }
});