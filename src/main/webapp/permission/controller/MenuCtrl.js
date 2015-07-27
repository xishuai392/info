Ext.define('PM.controller.MenuCtrl', {
    extend : 'Ext.app.Controller',

    init : function() {
        this.control({
        
        });

        var action = Ext.create("PM.action.MenuAction");
        /**
         * 查询用户的所有有权限的菜单，返回格式为目录下面挂children的菜单列表，直接循环目录去创建treePanel
         */
        action.qryMenuListByLoginUser(function(records) {
            if (Ext.isEmpty(records)) {
                return;
            }
            var len = records.length;
            for (var i = 0; i < len; i++) {
                var recordData = records[i];
                var treeStore = Ext.create("Ext.data.TreeStore", {
                    fields : ['nodeId', 'url', 'text']
                });
                treeStore.setRootNode(recordData);
                
                var treePnl = Ext.create("Ext.tree.Panel", {
                    title : recordData.text,
                    width : 200, // 面板宽度
                    minSize : 180,
                    maxSize : 250,
                    draggable : false,
                    split : true, // 可以折叠
                    autoHeight : false,
                    autoScroll : true, // 自动滚动
                    enableDD : false, // 是否支持拖拽效果
                    containerScroll : true, // 是否支持滚动条
                    rootVisible : false, // 是否隐藏根节点,很多情况下，我们选择隐藏根节点增加美观性
                    border : true, // 边框
                    animate : true, // 动画效果
                    store : treeStore,
                    listeners : {
                        'itemclick' : function(view, record) {
                            if (Ext.isEmpty(record.data.url)) {
                                return;
                            }

                            var contentPanel = Ext.getCmp('main_content_panel');
                            var pnl = contentPanel.getComponent('ZTEtab-' + record.data.nodeId);
                            if (!pnl) {
                                pnl = contentPanel.add({
                                    xtype : 'component',
                                    id : 'ZTEtab-' + record.data.nodeId,
                                    title : record.data.text,
                                    closable : true,
                                    layout : 'fit',
                                    border : false,
                                    autoEl : {
                                        tag : 'iframe',
                                        name : 'ZTEtab-' + record.data.nodeId,
                                        style : 'height: 100%; width: 100%; border: none;',
                                        src : webRoot + record.data.url
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
                }); // treePnl
                
                Ext.getCmp('main_west_menupanel').add(treePnl);
            }

        });
    }
});