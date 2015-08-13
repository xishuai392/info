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
            layout : 'border',
            html : '<div id="menuDivId"></div>',
            defaults : {
                bodyPadding : '5 15 5 5' // 配置下面的节点node间隔大小
            },
            dockedItems : [{
                xtype : 'treepanel',
                dock : 'top',
                region : 'center',
                id : 'menuTree',
                frame : true,
                displayField : 'title',
                width : 200,
                height : 800,
                border : false,
                title : '菜单列表',
                store : Ext.create('component.permission.store.AuditMenuTreeStore'),
                collapsible : false,
                header : false,
                hideHeaders : true,
                useArrows : true,
                rootVisible : true,
//                viewConfig : {
//                    plugins : {
//                        ptype : 'treeviewdragdrop',
//                        appendOnly : true
//                    }
//                },
                columns : [{
                    xtype : 'treecolumn', // this is so we know which column
                                            // will show the tree
                    text : 'Forum',
                    flex : 2.5,
                    sortable : true,
                    dataIndex : 'text'
                }],
                listeners : {
                    'itemclick' : function(view, record) {
                    	//console.log("menu click");
                    	//console.log(record);
                        if (Ext.isEmpty(record.data.attributeMap.urlString)) {
                            return;
                        }

                        //console.log("record.data.menuId:"+record.data.attributeMap.menuId);
                        var contentPanel = Ext.getCmp('main_content_panel');
                        var pnl = contentPanel.getComponent('ZTEtab-' + record.data.attributeMap.menuId);
                        if (!pnl) {
                            pnl = contentPanel.add({
                                xtype : 'component',
                                id : 'ZTEtab-' + record.data.attributeMap.menuId,
                                title : record.data.attributeMap.menuTitle,
                                closable : true,
                                layout : 'fit',
                                border : false,
                                autoEl : {
                                    tag : 'iframe',
                                    name : 'ZTEtab-' + record.data.attributeMap.menuId,
                                    style : 'height: 100%; width: 100%; border: none;',
                                    src : webRoot + record.data.attributeMap.urlString
                                },
                                listeners : {
                                    load : {
                                        element : 'el',
                                        fn : function() {
                                            Ext.getBody().unmask();
                                        }
                                    },
                                    render : function() {
                                        Ext.getBody().mask('页面载入中......');
                                    }
                                }
                            });
                        }
                        contentPanel.setActiveTab(pnl);
                    } // itemclick
                } // listeners
            }],

            listeners : {
                // 收缩后 添加mouseover事件
                'collapse' : function() {
                    Ext.getDom("main_west_menupanel-placeholder").onmouseover = function() {
                        var menupanel = Ext.getCmp('main_west_menupanel');
                        if (menupanel.getCollapsed()) {
                            menupanel.expand();
                        }
                    };
                }
            }
        });
        this.callParent(arguments);
    }
});