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
            height:35,
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
                }]
            }]
        });
        me.callParent([config]);
    }
});