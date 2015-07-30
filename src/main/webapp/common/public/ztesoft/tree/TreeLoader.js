Ext.define('ZTEsoft.tree.TreeLoader', {
	extend : 'Ext.data.TreeStore',
	alias : 'widget.TreeLoader',
	constructor : function(config) {
		var conditions = Ext.applyIf({
			autoExpand : true,
    		 root : Ext.apply({
    			 expanded : true
			},config.root),
			proxy : Ext.apply({
				type : 'ajax',
	            actionMethods: 'POST',
	            extraParams : {
	    			 nodeTypeId:-1
	    		 },
	            reader : {
					type : 'json',
					extractData : function(root) {
						var me = this,Model   = me.model,length  = root.length,records = new Array(length),convertedValues, node, record, i;
				        if (!root.length && Ext.isObject(root)) {
				            root = [root];
				            length = 1;
				        }
				        for (i = 0; i < length; i++) {
				            node = root[i];
				            if(Ext.isEmpty(node.checked)){
				            	delete node.checked;
				            }
				            if (node.isModel) {
				                records[i] = node;
				            } else {
				                records[i] = record = new Model(undefined, me.getId(node), node, convertedValues = {});
				                record.phantom = false;
				                me.convertRecordData(convertedValues, node, record);
				                if (me.implicitIncludes && record.associations.length) {
				                    me.readAssociated(record, node);
				                }
				            }
				            if(!Ext.isEmpty(records[i].get('icon'))){
				            	records[i].set('icon',webRoot+records[i].get('icon'));
				            }
				        }
				        return records;
					}
	            }
			},config.proxy)
		},config);
		this.callParent([conditions]);
	}
});
