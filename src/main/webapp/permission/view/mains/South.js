Ext.define('PM.view.mains.South',{
    extend: 'Ext.panel.Panel',
    alias: 'widget.ztesouth',
    initComponent : function() {
        this.callParent(arguments);
    },
    constructor : function(config) {
        var me = this;
        config = config || {};
        Ext.applyIf(config,{
            id:"bottom",
            //frame:true,
            region:"south",
            bodyStyle : 'border-bottom:0',
            height:30,
            //collapsed:true,
            dockedItems : [{
                xtype : 'toolbar',
                dock : 'top',
                height : 30,
                items : ['->', {
                    xtype : 'box',
                    html : '<img src="' + ctx + '/common/images/icons/user.png" style="width:16px;height:16px;"></img>'
                }, {
                    xtype : 'label',
                    name : 'staffInfo',
                    text : userSession.userName + '(' + userSession.userCode + '),欢迎登陆!'
                },'-', {
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
                },'-', {
                    iconCls : 'changepasswd',
                    scale : 'medium',
                    textAlign : 'left',
                    text : '修改密码',
                    handler : me.updPassword,
                    scope : me
                }]
            }]
        });
        me.callParent([config]);
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