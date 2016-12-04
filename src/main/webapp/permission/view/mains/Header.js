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
            bodyStyle : 'border-bottom:0',
            height : 80,
            dockedItems : [{
                xtype : 'toolbar',
                height : 80,
                style : 'background-image: url(' + ctx + '/common/images/logo_1900_80.jpg) !important; background-repeat: no-repeat;background-position:center left;background-size:100% 100%;background-size:  cover;filter:progid:DXImageTransform.Microsoft.AlphaImageLoader( src="' + ctx + '/common/images/logo.jpg",sizingMethod="scale");',
                // filter:progid:DXImageTransform.Microsoft.AlphaImageLoader( src=' + ctx + '/common/images/logo.jpg,sizingMethod='scale');
                dock : 'top',
                items : ['->', {
                    iconCls : 'changepasswd',
                    scale : 'medium',
                    textAlign : 'left',
                    text : '修改密码',
                    hidden : false,
                    handler : me.updPassword,
                    scope : me
                },{
                    iconCls : 'loginOut',
                    scale : 'medium',
                    textAlign : 'left',
                    text : '退出系统',
                    hidden : true,
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
    	Ext.getBody().mask();
        Ext.create('Ext.window.Window', {
            id : 'updPassWordWin',
            title : '修改密码',
            iconCls : 'changepasswd',
            height : 150,
            width : 300,
            layout : 'fit',
            items : { // Let's put an empty grid in just to illustrate fit
                // layout
                id : 'updPassWordForm',
                xtype : 'zteeditform',
                layout : 'anchor',
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
                    minLength : 6,
                    allowBlank : false
                }, {
                    fieldLabel : '确认密码',
                    name : 'newPassword2',
                    inputType : 'password',
                    initialPassField : 'newPassword',
                    vtype : "password",
                    minLength : 6,
                    allowBlank : false
                }]
            },
            listeners : {
            	'close' : function(thiz,opts){
            		Ext.getBody().unmask();
            	}
            
            },
            buttons : [{
                text : '确定',
                iconCls : 'accept',
                handler : function() {
                    var form = Ext.getCmp('updPassWordForm').getForm();
                    if (form.isValid()) {
                        //Ext.getBody().mask("请稍等，密码修改中...", "x-mask-loading");
                        
                        var config = {
				            url : '/permission/audituser/updPassword.do',
				            params : {
				            	newPassword : form.findField('newPassword').getValue(),
                                oldPassword : form.findField('oldPassword').getValue()
				            },
				            callback : function(){
				            	//Ext.getBody().unmask();
				            	ExtUtils.info('密码修改成功.');
				            	Ext.getCmp('updPassWordWin').close();
				            },
				            exceptionCallback : function(){
				            	//Ext.getBody().unmask();
				            }
				        };
				
				        ExtUtils.doAjaxSync(config);
			        
				        /**
                        Ext.Ajax.request({
                            url : ctx + '/user/updPassword.do',
                            method : 'post',
                            disableCaching : true,
                            params : {
                                newPassword : form.findField('newPassword').getValue(),
                                oldPassword : form.findField('oldPassword').getValue()
                            },
                            success : function(response) {
                            	Ext.getBody().unmask();
                                var text = response.responseText;
                                if (text == 0) {
                                    Ext.Msg.alert('结果', '密码修改失败--你输入的旧密码错误');
                                } else {
                                    Ext.Msg.alert('结果', '密码修改成功');
                                    Ext.getCmp('updPassWordWin').close();
                                }
                                
                            }
                        });
                        **/
                        
                    }
                }
            },{
	            xtype : 'button',
	            text : '取消',
	            iconCls : 'arrow_undo',
	            handler : function() {
	            	Ext.getCmp('updPassWordWin').close();
	            }
            }]
        }).show();
    }
});