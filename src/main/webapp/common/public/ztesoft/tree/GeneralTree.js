Ext.define('ZTEsoft.tree.GeneralTree', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.generalTree',
    requires: ['ZTEsoft.tree.TreeLoader'],
    border:false,
	collapsible: false,
	headerPosition : 'top',
	split:true,
	title : '通用树',
	width : 250,
    loadObj : null,
    searchObj : null,
    isSearch : false,
    isExternalStore : false,   //是否为外面传进来的store
    lastSearchTime : null,
    mixins: {
        treeFilter : 'ZTEsoft.tree.TreeCommonFilter',
        treeMethod : 'ZTEsoft.tree.TreeCommonMethod'
    },
    config : {
		rootVisible: false,
		rootId:  -1,
		rootText: '根节点',
		loadUrl : webRoot+"base/getGeneralTree.do",
		searchUrl : webRoot+"base/queryTree.do",
		searchServer : true,       //是否后台查询(true:后台查询；false:前台查询)
		showSearch : true,         //是否显示查询框
    	displayName : null,
    	barExpand : true,			//是否显示展开、收缩按钮
    	filterState : true,				//是否过滤状态(查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
		plugins : [Ext.create("ZTEsoft.plugin.TreeCheckPlugin"),Ext.create('ZTEsoft.plugin.GridToolTip')]
    },
    constructor: function(cfg) {
    	var me=this;
    	me.initConfig(cfg);
    	var paramMap = {
            sqlKey : cfg.sqlKey,
            deep : 2,
            rootId : cfg.rootId,
            valueField : 'id',
            displayField : 'text',
            searchField : cfg.paramMap.displayField,
            parentField : 'pid',
            stateField : 'state', // 状态属性(查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
            stateValue : '00A', // 有效状态值(查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
            operation : WEBConstants.OPERATION.Like   // 查询框匹配方式，默认使用模糊查询
        };
        Ext.apply(paramMap,cfg.paramMap);
        cfg.paramMap = paramMap;
    	//添加展开和收缩工具栏
    	me.iniToolbar(cfg);
        if(!cfg.store){
        	me.iniStore(cfg);
        	me.bindEvent();
        }else{
        	me.isExternalStore = true;
        	me.searchServer = false;
        }
        this.callParent([cfg]);
        me.iniQueryParam();
    },
    bindEvent:function(){
    	var me=this;
    	this.store.on('beforeload',function (store, operation, eOpts) {
		 	if (document.body) {
                me.loading = new Ext.LoadMask(document.body, {
                    msg : StrConstants.HINT_LOADING// 完成后移除
                });
                me.loading.show();
            }
			store.proxy.extraParams.rootId=operation.id;
        });
        this.store.on('load', function(thiz, records) {
        	if (me.loading) {
                me.loading.hide();
            }
	    	// 载入的时候默认选中第一条
	        var item = ExtUtils.gridSelectCheck(me, false, false);
	        if (!item && records.childNodes.length > 0) {
	            item = records.childNodes[0];
	            me.getSelectionModel().select(item);
	            me.fireEvent('itemclick', null, item);
	        }
	        if(me.isSearch){
        		me.expandAll();
	        }
	        if (!me.rootVisible && records.data.id == me.rootId && records.childNodes.length == 0) {
	        	me.fireEvent('itemclick', null, null);
	        }
	    });
    },
    
    iniToolbar:function(cfg){
    	var me=this;
    	if(!me.showSearch && !me.barExpand){
    		return;
    	}
    	if(cfg.dockedItems){
    		var addFlag=false;
    		if(Ext.isArray(cfg.dockedItems)){
    			for(var i=cfg.dockedItems.length-1;i--;i>=0){
    				if(cfg.dockeItems[i].dock=='top'){
    					var items=cfg.dockeItems[i].items;
    					if(!Ext.isArray(items)){
    					    items=[items];
    					}
    					Ext.Array.insert(items,0,me.getButtons());
    					addFlag=true;
    				}
    			}
    		}else{
    			if(cfg.dockeItems.dock=='top'){
    				var items=cfg.dockeItems.items;
    				if(!Ext.isArray(items)){
    					    items=[items];
    				}
					Ext.Array.insert(items,0,me.getButtons());
					addFlag=true;
    			}
    		}
    		if(addFlag==false){
    			cfg.dockedItems.push({
			        xtype: 'toolbar',
			        dock: 'top',
			        items: me.getButtons()
			    });
    		}
    	}else if(Ext.isArray(cfg.tbar)){
    		Ext.Array.insert(cfg.tbar,0,me.getButtons());
    	}else if(cfg.tbar){
    		cfg.tbar=[cfg.tbar];
    		Ext.Array.insert(cfg.tbar,0,me.getButtons());
    	}
    	if(!cfg.tbar && !cfg.dockedItems){
    		cfg.dockedItems = [];
    		cfg.dockedItems.push({
		        xtype: 'toolbar',
		        dock: 'top',
		        items: me.getButtons()
		    });
    	}
    },
    
    iniStore:function(cfg){
    	var me=this;
    	var root = {
            text : me.rootText,
            id : me.rootId,
            icon : webRoot + (cfg.rootIcon || cfg.paramMap.icon)
        };
        this.store = Ext.create('ZTEsoft.tree.TreeLoader', {
    		 root:root,
    		 autoLoad : true,
    		 folderSort : cfg.folderSort || false,
    		 proxy:{
    			 extraParams : {
    				 paramMap:Ext.JSON.encode(cfg.paramMap)
	    		 },
 				url : me.loadUrl
    		 },
    		 fields: ['id','text','rate','type','attr1','attr2','attributeMap'].concat(cfg.fields||[])
		 });
    },
    	
    getButtons:function(){
    	var me=this;
    	var items = [];
    	if(me.showSearch){
    		var name = me.initialConfig.paramMap.searchField;
    		var emptyText = '快速检索功能';
    		var labelWidth = 0;
    		if(me.displayName){
    			emptyText = '请输入' + me.displayName;
    			labelWidth = me.displayName.length * 15;
    		}
    		me.displayName
    		items.push({
                        xtype : 'clearTextField',
			            name : name,
			            labelWidth : labelWidth,
			            flex:1,
			            labelAlign : 'right',
			            fieldLabel : me.displayName,
			            emptyText : emptyText
                    }, {
                        xtype : 'ztequerybutton',
			            handler : function() {
			                var searchName = Ext.String.trim(me.down('[name='+name +']').getValue());
			                if(!me.searchServer){
			                	if(searchName != ''){
				                	me.filterByText(searchName);
				                }else{
				                	me.clearFilter();
				                }
			                	return;
			                }
			                if(searchName == ''){
			                	me.searchHandler();
			                	return;
			                }
			                var conditions = [];
			                var index = 0;
			                if(me.filterState && me.initialConfig.paramMap.stateField != null){
			                	conditions[index ++] = {
				                	paramName:me.initialConfig.paramMap.stateField,
				                	paramValue:[me.initialConfig.paramMap.stateValue],
				                	operation:WEBConstants.OPERATION.EqualTo
				                };
			                }
			                conditions[index] = {
			                	paramName:name,
			                	paramValue:[searchName],
			                	operation:me.initialConfig.paramMap.operation
			                };
			                me.searchHandler(Ext.encode(conditions));
			            }
                    });
    	}
    	if(me.barExpand){
    		items.push({
					xtype : 'button',
					iconCls : 'x-tool-img x-tool-expand',
					style : 'width:21px;margin-right:-3px;',
					tooltip:'展开',
					handler : function() {
//						me.getEl().mask('展开中...');
						var record=me.getSelectionModel().getLastSelected();
						if(Ext.isEmpty(record)) return;
//						me.expandNode(record,true);
						record.expand(true);
						me.getView().refresh();
//						me.expandNode(record,true,function() {
//							me.getEl().unmask();
//						});
//						me.expandAll(function(){
//							me.getView().refresh();
//							me.getEl().unmask();
//						});
					}
				},{
					xtype : 'button',
					iconCls : 'x-tool-img x-tool-collapse',
					style : 'width:21px;',
					tooltip:'收缩',
					handler : function() {
						var record=me.getSelectionModel().getLastSelected();
						if(Ext.isEmpty(record)) return;
//						me.collapseNode(record,true);
//						me.collapseAll();
						record.collapse();
						me.getView().refresh();
					}
				});
    	}
    	return items;
    },
    
    iniQueryParam: function() {
    	var me=this;
		var reqObj = {};
        reqObj.valueField = me.paramMap.valueField;
        reqObj.displayField = me.paramMap.displayField;
        reqObj.parentField = me.paramMap.parentField;
        reqObj.rootId = me.rootId;
        reqObj.rootText = me.rootText;
        reqObj.icon = me.paramMap.icon;
        reqObj.orderByClause = me.paramMap.orderByClause;
        if(me.paramMap.tableName){
        	reqObj.tableName = me.paramMap.tableName.toUpperCase();
        }
        me.searchObj = reqObj;
        me.loadObj = me.store.proxy.extraParams.paramMap;
    },
    
    searchHandler: function(queryConditions) {
    	var me=this;
    	var now = Ext.Date.now();
		if(me.lastSearchTime && now - me.lastSearchTime < 3000){
			return;
		}else{
			me.lastSearchTime = now;
		}
    	me.getSelectionModel().deselectAll();
    	if(queryConditions){
    		me.isSearch = true;
    		me.searchObj.queryConditions = queryConditions;
    		me.store.proxy.url = me.searchUrl;
    		me.store.proxy.extraParams = me.searchObj;
    		me.store.load();
    	}else{
    		var root = me.getStore().getRootNode();
        	if(root.data.leaf){
        		root.data.leaf = false;
        		root.data.expanded = true;
        	}
        	me.refreshTreeData(root);
    	}
    },
    
    refreshTreeData : function(treeNode) {
    	var me=this;
    	if(!treeNode){
    		treeNode = me.getStore().getRootNode();
//    		return false;
    	}
    	if(me.isSearch && !me.isExternalStore){
    		me.isSearch = false;
    		me.store.proxy.url = me.loadUrl;
        	me.store.proxy.extraParams = {};
    		me.store.proxy.extraParams.paramMap = me.loadObj;
        }
        me.store.load({ // 刷新节点
            node : treeNode,
            callback : function() {
                if (me.rootVisible || treeNode.data.id != me.searchObj.rootId) {
                    me.getSelectionModel().select(treeNode);
                    me.fireEvent('itemclick', me, treeNode);
                }
                me.getView().refresh();
            }
        });
    }
});