/**
 * @description 对Ehcache的表格展现及增删改，基于Panel，持有Grid及工具栏，按钮工具栏再关联弹出窗口
 * @author codeCreater
 * @date 2014年11月19日
 */
Ext.define('component..demo.view.EhcachePanel', {
    extend : 'Ext.panel.Panel',
    layout : "border",
    requires : ['component..demo.model.EhcacheModel', 'ZTEsoft.button.AddButton', 'ZTEsoft.button.EditButton', 'ZTEsoft.button.DelButton'],
    config : {
        busizGrid : null,
        action : Ext.create("component..demo.action.EhcacheAction")
    },
    constructor : function(config) {
        var me = this;
        config = config || {};

        // TODO 设置额外的参数
        // me.pkFiledId = config.pkFiledId;

        // 创建顶部工具栏
        me.toolsBar = me.createTbar();

        me.tbar = me.toolsBar;

        // 创建业务相关的组件
        me.busizGrid = me.createGridPanel();
        me.items = [me.busizGrid];

        this.callParent([config]);
        me.bindEvent();
    },

    initComponent : function() {
        var me = this;
        // 载入的时候默认选中第一条；如果没有任何记录，则处理按钮灰化
        me.busizGrid.getStore().on("load", function(thiz, records) {
            if (Ext.isEmpty(records)) {
                var items = me.busizGrid.getSelectedItems();
                me.busizGrid.getSelectionModel().fireEvent('selectionchange', null, items);
            } else {
                me.busizGrid.select(0);
            }
        });
        var toolsBar = me.toolsBar;
        me.busizGrid.getSelectionModel().on('selectionchange', function(sm, items) {
            // TODO 设置工具栏按钮的状态
            if (Ext.isEmpty(items)) {
                toolsBar.down("zteeditbutton[itemId=btnEdit]").disable();
                toolsBar.down("ztedelbutton[itemId=btnDel]").disable();
                return;
            }

            toolsBar.down("zteeditbutton[itemId=btnEdit]").enable();
            toolsBar.down("ztedelbutton[itemId=btnDel]").enable();

        });

        me.busizGrid.getStore().getProxy().extraParams = {
        // TODO 自定义业务条件：带业务条件查询

        };
        
        this.callParent();
    },

    // 创建数据源
    createStore : function() {
        return Ext.create('component..demo.store.EhcacheStore', {
        		autoLoad : true,
            // 定义分页大小
            pageSize : WEBConstants.DEFAULT_PAGE_SIZE
        });
    },

    // 创建表格
    createGridPanel : function() {
        var me = this;
        var grid = Ext.create('ZTEsoft.grid.Panel', {
            border : false,
            region : "center",
            isPage : true,
            store : me.createStore(),
            columns : [
	        {
	        	text : "empId",
	            dataIndex : "empId",
	            flex : 1
	        },
	        {
	        	text : "empName",
	            dataIndex : "empName",
	            flex : 1
	        },
	        {
	        	text : "empAge",
	            dataIndex : "empAge",
	            flex : 1
	        },
	        {
	        	text : "empSex",
	            dataIndex : "empSex",
	            flex : 1
	        },
	        {
	        	text : "empBirthday",
	            dataIndex : "empBirthday",
	            flex : 1
	        }       
		]

        });
        return grid;
    },

    // 创建顶部工具栏：新增、修改、删除...
    createTbar : function() {
        var me = this;
        var tbar = Ext.create('Ext.toolbar.Toolbar', {
            items : ['->',{
                itemId : 'btnAdd',
                xtype : "zteaddbutton"
            }, '-', {
                itemId : 'btnEdit',
                xtype : "zteeditbutton"
            }, '-', {
                itemId : 'btnDel',
                xtype : "ztedelbutton"
            }, '-']
        });
        return tbar;
    },
    // 给按钮绑定事件
    bindEvent : function() {
        var me = this;
        if (me.down('[xtype=zteaddbutton]')) {
            me.down('[xtype=zteaddbutton]').on('click', Ext.bind(me.addBtnHandler, me));
        }
        if (me.down('[xtype=zteeditbutton]')) {
            me.down('[xtype=zteeditbutton]').on('click', Ext.bind(me.editBtnHandler, me));
        }
        if (me.down('[xtype=ztedelbutton]')) {
            me.down('[xtype=ztedelbutton]').on('click', Ext.bind(me.delBtnHandler, me));
        }
    },
    // 新增 按钮的事件
    addBtnHandler : function() {
        var me = this;
        var win = Ext.create('component..demo.view.EhcacheWin', {
            winType : WEBConstants.ACTIONTYPE.NEW,
            callback : function(result) {
                ExtUtils.info(StrConstants.HINT_ADD_SUCCESS);
                var model = Ext.create("component..demo.model.EhcacheModel");
                model.data = result;
                me.busizGrid.getStore().add(model);
                me.busizGrid.select(model);
            }
        });
        win.show();
    },
    // 修改按钮的事件
    editBtnHandler : function() {
        var me = this;
        var items = me.busizGrid.getSelectedItems();
        if (Ext.isEmpty(items)) {
            ExtUtils.info(StrConstants.HINT_SELECT_FIRST);
            return;
        }
        var item = me.busizGrid.getSelectedItem();
        var pkFiledId = item.get("empId");
        var win = Ext.create('component..demo.view.EhcacheWin', {
            pkFiledId : pkFiledId,
            winType : WEBConstants.ACTIONTYPE.EDIT,
            callback : function(result) {
                ExtUtils.info(StrConstants.HINT_MOD_SUCCESS);

                // TODO 设置要更新的字段
                var changedColumns = ['empName' ,'empAge' ,'empSex' ,'empBirthday' ];
                for (var colKey in changedColumns) {
                    var colValue = changedColumns[colKey];
                    item.set(colValue, result[colValue]);
                }
                // TODO 如果还有其他字段要更新（比如从其他地方获取到的值）
                // item.set("XXXX", others.XXXX);;

                me.busizGrid.getStore().commitChanges();
                var items = me.busizGrid.getSelectedItems();
                me.busizGrid.getSelectionModel().fireEvent('selectionchange', me.busizGrid.getSelectionModel(), items);
            }
        });
        win.show();
    },
    // 删除按钮的事件
    delBtnHandler : function() {
        var me = this;
        var items = me.busizGrid.getSelectedItems();
        if (Ext.isEmpty(items)) {
            ExtUtils.info(StrConstants.HINT_SELECT_FIRST);
            return;
        }
        Ext.MessageBox.confirm(StrConstants.HINT, StrConstants.HINT_DEL_CONFIRM, function(btn) {
            if (btn == 'yes') {
                var item = items[0];
                var pkFiledId = item.get("empId");
                me.getAction().delRecord(pkFiledId, function(result) {
                    ExtUtils.info(StrConstants.HINT_DEL_SUCCESS);
                    me.busizGrid.removeItemToNext(item);
                });
            }
        });
    }

});
