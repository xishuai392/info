Ext.define('PM.view.mains.TabPanel', {
    extend : 'Ext.tab.Panel',
//    requires : ['Ext.ux.TabCloseMenu'],
    alias : 'widget.ztetabpanel',
    initComponent : function() {
        Ext.apply(this, {
            id : 'main_content_panel',
            activeTab : 0,
            bodyStyle : 'border-top:0;border-left:0;border-right:0;border-bottom:0'
            /**
             * 增加页签右键功能
             */
//            plugins : Ext.create('Ext.ux.TabCloseMenu', {
//                closeTabText : '关闭当前页',
//                closeOthersTabsText : '关闭其他页',
//                closeAllTabsText : '关闭所有页',
//                enableRefresh : true,
//                extraItemsTail : ['-', {
//                    text : '刷新',
//                    hideOnClick : true,
//                    handler : function(item) {
//                        var tabName = currentItem.el.id;// 获取选项卡的id
//                        var tabs = Ext.getCmp("main_content_panel");
//                        // frames[tabName]这是iframe的name,设置成与tabid同名,在MenuCtrl.js里面设置
//                        window.frames[tabName].location.reload(); 
//                        Ext.getBody().mask('页面载入中......');
//                        setTimeout(function() {
//                            Ext.getBody().unmask(); // 遮罩持续时间2秒
//                        }, 2000);
//                    }
//                }],
//                listeners : {
//                    aftermenu : function() {
//                        currentItem = null;
//                    },
//                    beforemenu : function(menu, item) {
//                        currentItem = item;
//                    }
//                }
//            }),
//            items : [{
//                id : 'ZTEtab-AuditIndexPage',
//                title : '首页',
//                iconCls : 'home',
//                closable : true,
//                layout : 'fit',
//                html : '<iframe scrolling="auto" name="HomePage" frameborder="1" width="100%" height="100%" src="' + webRoot
//                        + '/audit/index/index.do"></iframe>'
//            }]
        });
        this.callParent(arguments);
    }
});