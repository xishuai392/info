Ext.define('PM.view.mains.Menu', {
    extend : 'Ext.panel.Panel',
    id : 'main_west_menupanel',
    alias : 'widget.ztemenu',
    initComponent : function() {
        Ext.apply(this, {
            id : 'main_west_menupanel',
            title : '导航菜单',
            // iconCls : 'sitemap',
            region : 'west',
            enableDD : false,
            split : true,
            width : 212,
            minSize : 130,
            maxSize : 300,
            rootVisible : false,
            containerScroll : true,
            collapsible : true,
            autoScroll : false,
            layout : 'accordion',
            defaults : {
                bodyPadding : '5 15 5 5' // 配置下面的节点node间隔大小
            },
            listeners : {
                //收缩后 添加mouseover事件
                'collapse' : function() {
                    Ext.getDom("main_west_menupanel-placeholder").onmouseover = function() {
                        console.log('mouseover');
                        var menupanel = Ext.getCmp('main_west_menupanel');
                        console.log('menupanel.getCollapsed() -->' + menupanel.getCollapsed());
                        if(menupanel.getCollapsed()) {
                            menupanel.expand();
                        }
                    };
                }
            }
        });
        this.callParent(arguments);
    }
});