Ext.define('ZTEsoft.plugin.GridToolTip', {
	extend : 'Ext.AbstractPlugin',
	alias : 'widget.ztegridtooltip',
	init : function(grid) {
		var me = this;
		grid.on('afterrender', Ext.bind(me.initToolTip,me,[grid],0));
		me.callParent(arguments);
	},
	updateToolTip:function(tip,eOpts,grid,columns,cellIndex){
		var me=this;
		var label=columns[cellIndex]['text'];
		var dataIndex=columns[cellIndex]['dataIndex'];
		var cellElement=tip.triggerElement;
		var rowElement=cellElement.parentNode;
		var record=grid.getView().getRecord(cellElement.parentNode);
		var rowIndex=grid.getView().indexInStore(rowElement);
		var value=record?record.get(dataIndex):"";
		// 如果有自定义的renderer则返回自定义renderer取值
		var col = columns[cellIndex];
        if (Ext.isFunction(col.renderer)) {
            value = col.renderer(value, grid.view.cellValues, record, rowIndex, cellIndex, grid.getStore(), grid.getView());
        }
        if(Ext.isFunction(me.toolTipRenderer)){
			value=me.toolTipRenderer.apply(me.scope||me,[grid,record,record.get(dataIndex),label,cellIndex,rowIndex,cellElement,rowElement,dataIndex,eOpts]);
		}
        
		if(Ext.isEmpty(value)||value===false){
			return false;
		}
		label='<div style="text-overflow:ellipsis;white-space: nowrap;">'+label+':</div>';
//		if(Ext.isFunction(col.renderer)){
//		    value='<div style="text-overflow:ellipsis;white-space: nowrap;">'+value+'<div>';
//		}else if(value.length<30){
//			value='<div style="text-overflow:ellipsis;white-space: nowrap;">'+value+'<div>';
//		}else{
			value='<div style="word-break:break-all;width:300px;">'+value+'<div>';
//		}
		tip.update(label+value);
	},
	initToolTip : function(grid) {
		var me=this;
		var view = grid.getView();
		var columns=view.getHeaderCt().getGridColumns();
		Ext.create('Ext.tip.ToolTip', {
			// The overall target element.
			target : view.el,
			// Each grid row causes its own separate show and hide.
			delegate : 'td .x-grid-cell',
			dismissDelay:10000,
//					deletate : view.cellSelector,
			// Moving within the row should not hide the tip.
			trackMouse : true,
			// Render immediately so that tip.body can be referenced
			// prior to the first show.
			renderTo : Ext.getBody(),
			listeners : {
				// Change content dynamically depending on which element
				// triggered the show.
				beforeshow : function updateTipBody(tip,eOpts) {
					var cellIndex = Number(tip.triggerElement.cellIndex);
					if(Ext.isFunction(me.toolTipRenderer)||Ext.isEmpty(me.cellIndex)){
						if(Ext.isEmpty(columns[cellIndex])||Ext.isEmpty(columns[cellIndex]['text'])||columns[cellIndex]['xtype']==='checkcolumn'){
							return false;
						}
						return me.updateToolTip(tip,eOpts,grid,columns,cellIndex);						
					}else{
						if(Ext.Array.contains(me.cellIndex,cellIndex)){
							return me.updateToolTip(tip,eOpts,grid,columns,cellIndex);
						}else{
							return false;
						}
					}
				}
			}
		});
	}
});
