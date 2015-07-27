Ext.require(['ZTEsoft.form.field.TextButtonField','ZTEsoft.button.QueryButton','ZTEsoft.button.ResetButton','ZTEsoft.button.OkButton','ZTEsoft.button.CancelButton','ZTEsoft.picker.DateTimePicker','ZTEsoft.form.field.TextButtonField','ZTEsoft.form.field.DateTimeField','ZTEsoft.button.AddButton','ZTEsoft.button.EditButton','ZTEsoft.button.DelButton']);
Ext.onReady(function(){
//	var form=Ext.create('ZTEsoft.form.EditForm',{
//		frame:true,
//		title:'test',
//		renderTo:Ext.getBody(),
////		layout:'anchor',
//		autoColumnWidth:true,
//		items:[{
//			fieldLabel:'测试',
//			allowBlank:false,
//			operation:ZTEsoft.common.WEBConstants.OPERATION.EqualTo,
//			name:'name'
//		},{
//			xtype:'ztetextbutton',
//			allowBlank:false,
//			operation:ZTEsoft.common.WEBConstants.OPERATION.GreaterThan,
//			fieldLabel:'测试',
//			name:'test',
//			handler:function(){
//				alert('tt');
//			}
//		},{
//			fieldLabel:'测试'
//		},{
//			fieldLabel:'测试'
//		},{
//			fieldLabel:'测试'
//		},{
//			fieldLabel:'测试'
//		},{
//			fieldLabel:'测试'
//		}]
//	});
	var store=Ext.create('ZTEsoft.data.JsonStore',{
		url:ctx+'demo/amuser/queryRecordByPage.do',
		fields:['ttt']
	});
	var form=Ext.create('ZTEsoft.form.EditForm',{
		frame:true,
		title:'test',
		renderTo:Ext.getBody(),
		store:store,
		autoColumnWidth:true,
//		layout:'column',
		defaults:{
			xtype:'textfield'
		},
		items:[{
			fieldLabel:'测试',
			name:'name1'
		},{
			fieldLabel:'测试',
			name:'name2'
		},{
			fieldLabel:'测试',
			name:'name3'
		},{
			fieldLabel:'测试',
			name:'name4'
		},{
			fieldLabel:'测试',
			name:'name5'
		},{
			fieldLabel:'测试',
			name:'name6'
		},{
			fieldLabel:'测试',
			name:'name7'
		},{
			xtype:'ztedatetimefield',
			fieldLabel:'测试',
			name:'name7'
		}]
	});
//	var field=form.down('[name=name]');
//	console.info(field);
});