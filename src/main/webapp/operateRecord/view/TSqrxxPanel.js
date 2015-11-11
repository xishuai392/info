/**
 * @description 对TSqrxx的表格展现及增删改，基于Panel，持有Grid及工具栏，按钮工具栏再关联弹出窗口
 * @author codeCreater
 * @date 2014年11月19日
 */
Ext.define('component.operateRecord.view.TSqrxxPanel', {
    extend : 'Ext.panel.Panel',
    layout : "border",
    requires : ['component.operateRecord.model.TSqrxxModel', 'ZTEsoft.button.AddButton', 'ZTEsoft.button.EditButton', 'ZTEsoft.button.DelButton'],

    config : {
        busizGrid : null,
        detailWin : null,
        action : Ext.create("component.operateRecord.action.TSqrxxAction")

    },
    
    constructor : function(config) {
        var me = this;
        config = config || {};

        // TODO 设置额外的参数
         me.pkFiledId = config.pkFiledId;

        // 创建顶部工具栏
       // me.toolsBar = me.createTbar();

       // me.tbar = me.toolsBar;

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
//            if (Ext.isEmpty(items)) {
//                toolsBar.down("zteeditbutton[itemId=btnEdit]").disable();
//                toolsBar.down("ztedelbutton[itemId=btnDel]").disable();
//                return;
//            }
//
//            toolsBar.down("zteeditbutton[itemId=btnEdit]").enable();
//            toolsBar.down("ztedelbutton[itemId=btnDel]").enable();

        });

        me.busizGrid.getStore().getProxy().extraParams = {
        // TODO 自定义业务条件：带业务条件查询

        };
        
        this.callParent();
    },

    // 创建数据源
    createStore : function() {
    	var store = Ext.create('component.operateRecord.store.TSqrxxStore', {

        	autoLoad : false,
            // 定义分页大小
            pageSize : WEBConstants.DEFAULT_PAGE_SIZE
        });
    	return store;
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
	        	text : "id",
	            dataIndex : "id",
	            hidden : true,
	            flex : 1
	        },
	        {
	        	text : "被查询人姓名",
	            dataIndex : "xm",
	            flex : 1
	        },
	        {
	        	text : "被查询人证件号",
	            dataIndex : "zjh",
	            flex : 1
	        },
	        {
	        	text : "证件类型",
	            dataIndex : "zjlx",
	            renderer : function(value) {
	                return value == '10' ? '身份证' : '其他';
	            },
	            flex : 1
	        },
	        {
	        	text : "查询类型",
	            dataIndex : "cxsqrlx",
	            renderer : function(value) {
	            	if(value == '10'){
	            		return'律师';
	            	}else if(value == '20'){
	            		return'党政军机关';
	            	}else if(value == '30'){
	            		return'司法机关';
	            	}else if(value == '40'){
	            		return'企事业单位';
	            	}else if(value == '50'){
	            		return'个人';
	            	}else if(value == '60'){
	            		return'人民团体';
	            	}else if(value == '70'){
	            		return'其他';
	            	}
	            },
	            flex : 1
	        },
	        {
	        	text : "cxrdw",
	            dataIndex : "cxrdw",
	            hidden : true,
	            flex : 1
	        },
	        {
	        	text : "cxsy",
	            dataIndex : "cxsy",
	            hidden : true,
	            flex : 1
	        },
	        {
	        	text : "日期",
	            dataIndex : "cxrq",
	            renderer : function(value) {
	            	return value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8);
	            },
	            flex : 1
	        },
	        {
	        	text : "czdw",
	            dataIndex : "czdw",
	            hidden : true,
	            flex : 1
	        },
	        {
	        	text : "czr",
	            dataIndex : "czr",
	            hidden : true,
	            flex : 1
	        },
	        {
	        	text : "查询类型",
	            dataIndex : "cxbs",
	            renderer : function(value) {
	            	if(value == '10'){
	            		return'终端查询';
	            	}else if(value == '20'){
	            		return'窗口查询';
	            	}
	            },
	            flex : 1
	        },
	        {
	        	text : "操作",
	        	xtype : 'actioncolumn',
	            items :[{
	            	icon: ctx + '/common/images/icons/application_view_detail.png',
	            	tooltip: '查看',
	            	handler: function(grid, rowIndex, colIndex) {
//	                    var rec = grid.getStore().getAt(rowIndex);
//	                    alert("Edit " + rec.get('firstname'));
	            		me.showDetail(grid,"", rowIndex, colIndex);
	                }
	            }],
	            width: 100
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
//        if (me.down('[xtype=actioncolumn]')) {
//            me.down('[xtype=actioncolumn]').on('click', Ext.bind(me.showDetail, me));
//        }
    },
    showDetail : function(grid,rowHtml, rowIndex, colIndex){
//    	console.log(grid);
//    	console.log(rowHtml);
//    	console.log(rowIndex);
//    	console.log(colIndex);
    	 var me = this;
//         var items = me.busizGrid.getSelectedItems();
//         if (Ext.isEmpty(items)) {
//             ExtUtils.info(StrConstants.HINT_SELECT_FIRST);
//             return;
//         }
//         var item = me.busizGrid.getSelectedItem();
//         var pkFiledId = item.get("id");
         var sqrxxId = grid.getStore().getAt(rowIndex).data.id;
         console.log(sqrxxId);
//         console.log("pkFiledId:"+pkFiledId);
         console.log("sqrxxId:"+sqrxxId);
         if(null==me.getDetailWin()){
         	console.log(3);
	         var win = Ext.create('component.operateRecord.view.TSqrxxDetailWin', {
	        	 pkFiledId : sqrxxId,
	             winType : WEBConstants.ACTIONTYPE.VIEW
	         });
	         me.setDetailWin(win);
	         
         }else{
         	console.log(4);
         	me.getDetailWin().pkFiledId = sqrxxId;
         	me.getDetailWin().loadData();
         }
         me.getDetailWin().show();
         console.log(5);
    },
    // 新增 按钮的事件
    addBtnHandler : function() {
        var me = this;
        var win = Ext.create('component.operateRecord.view.TSqrxxWin', {

            winType : WEBConstants.ACTIONTYPE.NEW,
            callback : function(result) {
                ExtUtils.info(StrConstants.HINT_ADD_SUCCESS);
                var model = Ext.create("component.operateRecord.model.TSqrxxModel");

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
        var pkFiledId = item.get("id");
        var win = Ext.create('component.operateRecord.view.TSqrxxWin', {
            pkFiledId : pkFiledId,
            winType : WEBConstants.ACTIONTYPE.EDIT,
            callback : function(result) {
                ExtUtils.info(StrConstants.HINT_MOD_SUCCESS);

                // TODO 设置要更新的字段
                var changedColumns = ['zjh' ,'zjlx' ,'xm' ,'cxsqrlx' ,'cxrdw' ,'cxsy' ,'cxrq' ,'czdw' ,'czr' ,'cxbs' ];
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
                var pkFiledId = item.get("id");
                me.getAction().delRecord(pkFiledId, function(result) {
                    ExtUtils.info(StrConstants.HINT_DEL_SUCCESS);
                    me.busizGrid.removeItemToNext(item);
                });
            }
        });
    }

});
