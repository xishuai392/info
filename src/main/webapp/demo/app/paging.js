Ext.require(['ZTEsoft.toolbar.Paging']);
Ext.onReady(function(){
	var store=Ext.create('ZTEsoft.data.JsonStore',{
			autoLoad:true,
			pageSize:WEBConstants.DEFAULT_PAGE_SIZE,
			url:ctx+'/demo/amuser/queryRecordByPage.do',
			fields:['userId','userName']
		});
	var grid=Ext.create('Ext.grid.Panel',{
		title:'测试',
//		renderTo:Ext.getBody(),
		width:'100%',
		height:'100%',
		store:store,
		dockedItems:[{
			xtype:'ztepagingtoolbar',
			store:store,
			dock:'bottom'
		}],
		columns:[{
			text:'userId',
			dataIndex:'userId'
		},{
			text:'userName',
			dataIndex:'userName'
		}]
	});
	Ext.create('Ext.container.Viewport',{
		layout:'fit',
		items:grid
	});
});