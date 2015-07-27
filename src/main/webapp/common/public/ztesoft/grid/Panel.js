/**
 * 
 * @description 表格控件，设置一些通用属性 <br>
 *              isPage:boolean类型，是否分页，若true，必须传入store，自动创建右对齐分页工具栏 <br>
 *              方法： removeItemToNext 删除当前行并移动到下一行记录，自动触发表格的selectionchange事件
 *              <br>
 * 
 * pageInc：增加一条记录，刷新分页组件<br>
 * 
 * @author pan.xiaobo
 */

Ext.define("ZTEsoft.grid.Panel", {
    extend : "Ext.grid.Panel",
    alias : "widget.ztegrid",
    constructor : function(config) {
        config = config || {};
        // default config
        var defaultConfig = {
            forceFit : true,
            columnLines : true,
            rowLines : true,
            frame : false
        };

        // column property setting
        /*
         * if (config && config.columns) { for (var index in config.columns) {
         * var column = config.columns[index];
         *//*
             * if (!column.xtype) { continue; }
             *//*
             * 
             *//*
             * if (column.xtype == "numbercolumn") { } // 日期类型格式化：如果没有设置则默认格式化
             * else if (column.xtype == "datecolumn") { if (!column.format) {
             * column.format = WEBConstants.DEFAULT_DATE_FORMAT; } }
             *//*
             * } }
             */

        if (!config.store) {
            ExtUtils.warn('分页表格必须传递一个数据源Store!');
            console.log("分页表格必须传递一个数据源Store!");
            Ext.applyIf(config, defaultConfig);

            this.callParent([config]);
            return;
        }

        if(config.isPage){
       	var paging=Ext.create('ZTEsoft.toolbar.Paging', {
       					dock: 'bottom',
						store : config.store
					});
			if(config.dockedItems){
				config.dockedItems.push(paging);
			}else{
				config.dockedItems=[paging];
			}
        }

        // 单元格提示
        var tooltip = Ext.create('ZTEsoft.plugin.GridToolTip');
        if (config.plugins) {
            config.plugins.push(tooltip);
        } else {
            config.plugins = [tooltip];
        }

        Ext.applyIf(config, defaultConfig);

        this.callParent([config]);
       
    },
    
//    addDockedItems:function(config){
//		var toolbar = Ext.create('ZTEsoft.toolbar.Paging', {
//						store : config.store
//					});
//		this.addDocked(toolbar,['bottom']);
//	},

    /**
     * 删除当前行并移动到下一行记录，自动触发表格的selectionchange事件
     */
    removeItemToNext : function(currentItem) {
        if (!currentItem) {
            return;
        }

        var me = this;
        var itemCount = me.getStore().getCount();

        var index = me.getStore().indexOf(currentItem);
        this.getStore().remove(currentItem);
        // 最后一条删除了要选择上一条记录
        if (index == itemCount - 1) {
            this.getSelectionModel().select(index - 1);
        }
        // 不是最后一条记录删除，则可以直接选择下一条记录，他的index还是跟以前一样
        else {
            this.getSelectionModel().select(index);
        }

        // 记录数变化
        var totalCount = me.getStore().getTotalCount();
        if (totalCount > 0) {
            me.getStore().totalCount = totalCount - 1;
            if (me.isPage && me.down('pagingtoolbar')) {
                me.down('pagingtoolbar').onLoad();
            }
        }
    },

    /**
     * 增加一条记录，刷新分页组件
     */
    pageInc : function() {
        var me = this;
        if (me.isPage && me.down('pagingtoolbar')) {
            me.getStore().totalCount = me.getStore().getTotalCount() + 1;
            me.down('pagingtoolbar').onLoad();
        }
    },

    /**
     * 选中指定index的那条记录/选中指定对象，会触发selectionchange事件 <br>
     * 
     * @param index
     */
    select : function(index) {
        this.getSelectionModel().select(index);

    },

    /**
     * 返回当前选择的唯一一条记录，注意是model对象
     * 
     * @return
     */
    getSelectedItem : function() {
        var items = this.getSelectionModel().getSelection();
        if (Ext.isEmpty(items)) {
            return null;
        }

        return items[0];
    },

    /**
     * 返回当前选中的多条记录，注意是model对象集合
     * 
     * @return
     */
    getSelectedItems : function() {
        return this.getSelectionModel().getSelection();
    }
});
