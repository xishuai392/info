Ext.require(['ZTEsoft.button.QueryButton','ZTEsoft.button.ResetButton','ZTEsoft.button.OkButton','ZTEsoft.button.CancelButton','ZTEsoft.picker.DateTimePicker','ZTEsoft.form.field.TextButtonField','ZTEsoft.form.field.DateTimeField','ZTEsoft.button.AddButton','ZTEsoft.button.EditButton','ZTEsoft.button.DelButton']);
Ext.onReady(function(){
	 var view = Ext.create('Ext.panel.Panel', {
	 	title:'test',
	 	width:500,
	 	height:500
	 });
	var tab=Ext.create('Ext.tab.Panel', {
		 region:'center',
		 frame:false,
		 cls:'zte-tab-default',
//		 border:false,
	    tabBar : {
		    height : 60,
		    defaults : {
		    	width: 50,
		        height : 56
		    }
		},
	    items: [{
	        title: 'Bar',
	        tabConfig: {
//	        	cls:'zte-tab-default',
	        	title: '<div style="padding-top:32px;">test</div>',
	        	iconAlign:'top',
//	            scale:'large',
	            icon: ctx+'/images/aix.gif',
	            tooltip: 'A button tooltip'
	        }
	    },{
	        title: 'Bar',
	        tabConfig: {
//	        	cls:'zte-tab-default',
	        	iconAlign:'top',
//	        	scale:'large',
	        	title: '<div style="padding-top:32px;">test1</div>',
	            icon: ctx+'/images/aix.gif',
	            tooltip: 'A button tooltip'
	        }
	    },{
	        title: 'Bar',
	        tabConfig: {
//	        	cls:'zte-tab-default',
	        	iconAlign:'top',
//	        	scale:'large',
	        	title: '<div style="padding-top:32px;">test2</div>',
	            icon: ctx+'/images/aix.gif',
	            tooltip: 'A button tooltip'
	        }
	    }]
	});
	var panel=Ext.create('Ext.panel.Panel',{
		 region:'north',
		 frame:true,
		 border:false,
		 style:'border-width:0;border-radius:0',
//		 height:300,
		 dockedItems: [{
	        xtype: 'toolbar',
	        dock: 'top',
	        items: ['->','-',{
	            text: 'Admin',
	            icon: ctx+'/images/icons/application_add.png'
//	            menu:Ext.create('ZTEsoft.menu.DateTimeMenu')
	        },{
	            text: '平台管理',
	            icon: ctx+'/images/icons/application_add.png'
	        },{
	            text: '退出',
	            icon: ctx+'/images/icons/application_add.png'
	        },{
	        	xtype:'zteaddbutton'
	        },{
	        	xtype:'zteeditbutton'
	        },{
	        	xtype:'ztedelbutton'
	        },{
	        	xtype:'zteokbutton'
	        },{
	        	xtype:'ztecancelbutton'
	        },{
	        	xtype:'ztequerybutton'
	        },{
	        	xtype:'zteresetbutton'
	        },{
	        	xtype:'ztedatetimefield'
	        },{
	        	xtype:'ztetimepicker'
	        }]
	    }]
	});
	Ext.create('Ext.container.Viewport',{
		layout:'border',
		frame:false,
		border:false,
		items:[panel,tab]
	});
	var window=Ext.create('ZTEsoft.window.PopWindow',{
		layout:'fit',
		items:[{xtype:'panel'}]
	});
//	window.show();
});