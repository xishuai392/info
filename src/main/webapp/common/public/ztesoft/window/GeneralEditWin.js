Ext.define('ZTEsoft.window.GeneralEditWin', {
	extend : 'Ext.window.Window',
	alias : 'widget.generalEditWin',
	requires:[],
    closeAction:'hide',
	maximizable:true,
	modal:true,
	width:Ext.getBody().getWidth()*0.9,
	height:Ext.getBody().getHeight()*0.9,
	layout:'border',
	frame:false,
	config:{
	},
	buttonAlign:'center',
	constructor : function(config) {
		var me = this;
		me.config = config;
		config=config||{};
		config.items = Ext.create('ZTEsoft.form.FormPanel', {
    	    region:'center',border:false,frame:false,
    	    name:'searchForm',
    	    items:config.items
    	});
    	me.buttons = [{text:config.saveText||'保存',action:'save',handler:function(){
    		var entity = me.down('form').getForm().getValues();
    		if(!me.down('form').getForm().isValid())return ExtUtils.tip('提示','请完成表单必填项!');
    		if(Ext.isFunction(config.beforeSubmit)){
    			entity = config.beforeSubmit(entity);
    		}
    		if(entity){
	    		Ext.Persistent[me.action](config.sqlKey,entity,function(){
					ExtUtils.tip('提示','操作成功!',config.callback);
	    		});
    		}
    	}},{text:'重置',action:'reset',handler:function(){
    		me.down('form').getForm().reset();
    	}},{text:'关闭',handler:function(){
    		me.close();
    	}}]
		me.callParent([config]);
		me.on('show',function(){
			if(me.action=='view'){
				me.down('[action=save]').hide();
				me.down('[action=reset]').hide();
			}
			else{
				me.down('[action=save]').show();
				me.down('[action=reset]').show();
			}
		});
	},
	bindEvent:function(){
		var me = this;
	}
});