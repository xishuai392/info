/**
 * @description 分页工具栏
 * 
 */
Ext.define('ZTEsoft.toolbar.Paging', {
    extend: 'Ext.toolbar.Paging',
    alias: 'widget.ztepagingtoolbar',
    alternateClassName: 'ZTEsoft.PagingToolbar',
    constructor:function(config){
    	var me=this;
    	config=config||{};
    	var combo=me.createCombo(config);
    	Ext.applyIf(config, {
			displayInfo : true,
			frame:false,
			autoScroll : true,
			beforePageText : "第",// update
			afterPageText : "页  共 {0} 页",// update
			firstText : "第一页",
			prevText : "上一页",// update
			nextText : "下一页",
			lastText : "最后页",
			refreshText : "刷新",
			displayMsg : "显示{0} - {1}条,共{2}条",// update
			emptyMsg : '没有数据',
			items : ['-', '每页显示', combo, '条']
		});
    	me.callParent([config]);
    },
    createCombo:function(config){
    	var me=this;
    	return Ext.create('Ext.form.field.ComboBox',{
            itemId : 'pageSizeComboItem',
            xtype : 'combobox',
            name : 'pagesize',
//            hiddenName : 'pagesize',
            typeAhead : true,
            triggerAction : 'all',
//            lazyRender : true,
            queryMode : 'local',
//            forceSelection : false,
            autoSelect : false,
            vtype : 'integer',
            store : Ext.create('Ext.data.ArrayStore', {
                fields : ['value', 'text'],
                data : [[5, '5'],[10, '10'], [15, '15'], [20, '20'], [30, '30'], [50, '50'], [100, '100']]
            }),
            valueField : 'value',
            displayField : 'text',
            value : config.store?(config.store.pageSize||WEBConstants.DEFAULT_PAGE_SIZE):WEBConstants.DEFAULT_PAGE_SIZE,
            width : 50,
            enableKeyEvents : true,
            listeners : {
                scope : me,
                keyup : me.onPageSizeComboKeyUp,
                select : me.onPageSizeComboSelect
            }
        });
    },
 	onPageSizeComboKeyUp : function(field, e) {
        var me = this;
        var k = e.getKey();
        if (!field.isValid()) {
            field.setValue(me.store.defaultPageSize);
        }
        if (k == e.ENTER) {
            e.stopEvent();
            if (!me.store.isLoading()) {
                me.store.currentPage = 1;
                me.store.pageSize = field.getValue();
                me.store.load();
            }
        }
    },
    onPageSizeComboSelect : function(field, record) {
        var me = this;
        if (!field.isValid()) {
            field.setValue(me.store.defaultPageSize);
        }
        if (!me.store.isLoading()) {
            me.store.currentPage = 1;
            me.store.pageSize = field.getValue();
            me.store.load();
        }
    }
});
