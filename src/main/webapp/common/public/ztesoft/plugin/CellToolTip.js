/**
 * @description 表格的单元格提示插件
 */

Ext.define('ZTEsoft.plugin.CellToolTip', {
    extend : 'Ext.AbstractPlugin',
    alias : 'plugin.CellQTip',
    config : {
        debug : false
    },

    init : function(grid) {
        // You may not need the scope, but if you do, this binding will
        // allow to preserve the scope configured in the column...
        var pluginRenderer = Ext.Function.bind(this.renderer, this);

        Ext.each(grid.query('gridcolumn'), function(col) {
            var renderer = col.renderer;
            // srcRenderer：自定义的renderer
            col.srcRenderer = renderer;
            col.renderer = renderer ? Ext.Function.createSequence(renderer, pluginRenderer) : pluginRenderer;
        });
    },

    renderer : function(value, metaData, record, rowIndex, colIndex, store, view) {
        var col = view.getGridColumns()[colIndex];
        // 如果有自定义的renderer则返回自定义renderer取值
        if (col.srcRenderer) {
            value = col.srcRenderer(value, metaData, record, rowIndex, colIndex, store, view);
        }

        // 解决显示null的问题
        if (Ext.isEmpty(value)) {
            value = "";
        }
        metaData.tdAttr = 'data-qtip="' + value + '"';
        return value;
    }
});