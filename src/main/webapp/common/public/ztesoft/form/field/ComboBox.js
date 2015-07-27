Ext.define("ZTEsoft.form.field.ComboBox", {
			extend : 'Ext.form.field.ComboBox',
			alias : 'widget.ztecombo',
			constructor : function(config) {
				config=config||{};
				var me = this;
				var store = null;
				if (config.queryMode == "local"||config.mode=="local"||!Ext.isEmpty(config.data)) {
					config.queryMode='local',
					store = Ext.create("Ext.data.ArrayStore", {
								fields : config.fields?config.fields:(config.valueField?[config.displayField,config.valueField]:['label','value']),
								data : config.data
							});
				} else {
					store = Ext.create("Ext.data.JsonStore",{
								proxy : {
									type : 'ajax',
									url : config.url||(ctx + '/combo/selectList.do'),
									reader : {
										type : 'json'
									}
								},
								fields : config.fields?config.fields:(config.valueField?[config.displayField,config.valueField]:['label','value']),
								autoLoad : true
							});
					store.on("beforeload", function(store, records, options) {
								store.proxy.extraParams.sqlKey = config.sqlKey;
								store.proxy.extraParams.paramMap = Ext.JSON.encode(me.paramMap||{});
							});
				}
				Ext.applyIf(config, {
					editable : false,
					typeAhead : true,
					displayField : 'label',
					valueField:'value',
					triggerAction : 'all',
					store : store
				});
				if(config.clear){
					config.trigger2Cls=Ext.baseCSSPrefix + 'form-clear-trigger';
				}
				me.callParent([config]);
			},
			onTrigger2Click : function(){
		    	this.setRawValue(null);
		    	this.setValue(null);
		    }
		});
