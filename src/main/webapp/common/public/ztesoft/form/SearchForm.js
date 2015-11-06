/**
 * 查询表单控件
 * 给表单指定searchHandler方法或者指定store,如果有做模糊查询的字段,请根据模糊查询的情况给字段的name属性加上%
 */
Ext.define('ZTEsoft.form.SearchForm', {
	extend : 'Ext.form.Panel',
	alias : 'widget.ztesearchform',
	requires:['ZTEsoft.form.field.ClearTextField','ZTEsoft.button.QueryButton','ZTEsoft.button.ResetButton'],
	constructor : function(config) {
		config=config||{};
		var me=this;
		if(config.store){
			me.store=config.store;
			delete config.store;
		}
		Ext.applyIf(config,{
			layout:'column',
			frame:true,
			title:'查询',
			defaults:{
				labelAlign:'right',
				labelWidth:100,
				xtype:'zteclear',
				style:'margin-left:5px;margin-top:2px;margin-bottom:2px;'
			}
		});
		Ext.applyIf(config.defaults, {
			labelAlign:'right',
			labelWidth:100,
			xtype:'zteclear',
			style:'margin-left:5px;margin-top:2px;;margin-bottom:2px'
		});
		me._operation(config.items);
//		var labelWidth=config.defaults.labelWidth;
		if (config.items) {
//			config.items.push({xtype:'tbspacer',width:labelWidth},{
//						xtype : 'ztequerybutton',
//						handler : Ext.bind(me.formSearchHandler, me)
//					},{
//						xtype : 'zteresetbutton',
//						handler : Ext.bind(me.formResetHandler, me)
//					});
			
			//是否显示button，默认是显示的
			if(typeof(config.hiddenBtns) == "undefined"||!config.hiddenBtns){
				config.items.push({
						xtype : 'panel',
						layout : 'table',
						border :false,
						frame:false,
						bodyStyle:'background:#dfe9f6',
						items : [{
									xtype : 'tbspacer',
									width : 5
								}, {
									xtype : 'ztequerybutton',
									handler : Ext.bind(me.formSearchHandler, me)
								}, {
									xtype : 'tbspacer',
									width : 5
								}, {
									xtype : 'zteresetbutton',
									handler : Ext.bind(me.formResetHandler, me)
								}]
					});
			}
		}
		me.callParent([config]);
	},
	_operation:function(items){
		var me=this;
		if(!me._operationMap){
			me._operationMap={};
		}
		Ext.each(items,function(item){
        	var key=item.name;
        	var operation=item.operation||ZTEsoft.common.WEBConstants.OPERATION.EqualTo;
        	if(key){
        		me._operationMap[key]={paramName:key,operation:operation,paramValue:[]};
        	}
		});
	},
	formSearchHandler:function(){
		if(!this.getForm().isValid()) return;
		if(Ext.isFunction(this.searchHandler)){
			this.searchHandler(arguments);
		}else{
			if(this.store){
				this.setParams(this.store.proxy.extraParams,this.getForm().getValues());
				this.store.loadPage(1);
			}else{
				console.error('请给表单设置store,否则无法执行查询方法');
			}
		}
	},
	setParams:function(extraParams,params){
		var me=this;
		Ext.apply(extraParams,params);
		for(var key in extraParams){
			if(Ext.isEmpty(params[key])&&params[key]!=''){
				delete extraParams[key];
			}else{
				me._operationMap[key]['paramValue']=extraParams[key];
			}
		}
		var arr=[];
		for (var key in me._operationMap){
			if(!Ext.isEmpty(me._operationMap[key]['paramValue'])&&!Ext.isArray(me._operationMap[key]['paramValue'])){
				me._operationMap[key]['paramValue']=[me._operationMap[key]['paramValue']];
				arr.push(me._operationMap[key]);
			}
		}
//		console.info(arr);
		var conditionStr=Ext.isEmpty(arr)?null:Ext.encode(arr);
		extraParams.queryConditions=conditionStr;
	},
	formResetHandler:function(){
		if(Ext.isFunction(this.resetHandler)){
			this.resetHandler(arguments);
		}else{
		    this.getForm().reset();
		}
	}
});
