/**
 * @author 	Damen
 * @date 	2013-11-18
 * @define 	ZTEsoft.tree.TreeCommonMethod
 * 
 * @title   方法(methods)
 * @methods selectNode(node) 				: 选中节点
 * @methods removeNode(node) 				: 删除节点
 * @methods setNodeChecked(nodeId,checked) 	: 节点勾选
 * @methods getSelectNode() 				: 获取选择节点
 * @methods getCheckValue 					: 返回选中的节点
 * @methods refreshNodeData(nodeId) 		: 刷新某节点
 * @methods refreshData() 					: 刷新整个树
 */

Ext.define('ZTEsoft.tree.TreeCommonMethod', {
	treeSigleCheck : function(node,checked){
		var me = this;
		me.getRootNode().cascadeBy(function(tNode){
			if(node!=tNode){
				tNode.data.checkable=true;
				if(me.onlyLeafCheckable){
					if(tNode.data.leaf){
						tNode.set('checked', checked);
					}
				}else{
					tNode.set('checked', checked);
				}
			}
		});
	},
	childSigleCheck : function(node, checked, excludeNodes) {
		if (node.isExpandable()) {
			node.expand(false, function() {
				var childNodes = node.childNodes, length = childNodes.length, i;
				
				for (i = 0; i < length; i++) {
					var child = childNodes[i];
					
					if (child.isExpandable()) {
//						this.childExpand(child, checked, excludeNodes);
					}
					if ((!excludeNodes || !Ext.Array.contains(excludeNodes,
							child))
							&& child.raw.checkable) {
						child.set('checked', checked);
						
//						child.fireEvent('checkchange', child, checked);
					}
				}
			},this);
		}
	},
	// 节点向下选择
	childCheck : function(node, checked, excludeNodes) {
		var me = this;
		if (node.isExpandable()) {
			node.expand(false, function() {
				var childNodes = node.childNodes, length = childNodes.length, i;

				for (i = 0; i < length; i++) {
					var child = childNodes[i];

					if (child.isExpandable()) {
						this.childExpand(child, checked, excludeNodes);
					}
					if ((!excludeNodes || !Ext.Array.contains(excludeNodes,
							child))
							&& child.raw.checkable) {
						
				        var view = me.getView();
			            var uiNode = view.getNodeByRecord(child);
						if(Ext.get(uiNode).isVisible()){
							child.set('checked', checked);
						}
						child.fireEvent('checkchange', child, checked);
					}
				}
			},this);
		}
	},
	childExpand : function(child, checked, excludeNodes) {
		child.expand(false, function() {
			this.childCheck(child, checked, excludeNodes)
		}, this);
	},
	// 节点向上选择
	parentCheck : function(node, checked, single) {
		var parent = node.parentNode;
		if(!Ext.isEmpty(parent)){
			parent.set('checked', checked);

			parent.fireEvent('checkchange', parent, checked);
			if (!single) {
				this.parentCheck(parent, checked);
			}
		}
	},
	// 取tree值 [value,rawValue]
	getTreeValue : function(node) {
		var result = '';
		var rawResult = '';
		if (!node) {
			node = this.getRootNode()
		}

		if (node.isExpandable()) {
			var childNodes = node.childNodes, length = childNodes.length, i;

			for (i = 0; i < length; i++) {
				var child = childNodes[i];

				if (child.isExpandable()) {
					var r = this.getTreeValue(child);

					if (r[0]) {

						if (result != '') {
							result += ',';
						}
						result += r[0];
					}
					if (r[1]) {
						if (rawResult != '') {
							rawResult += ',';
						}
						rawResult += r[1];
					}
				}

				if (child.data.checked) {
					if (result != '') {
						result += ',';
					}
					if (rawResult != '') {
						rawResult += ','
					}
					result += child.data.id;
					rawResult += child.data.text;

				}

			}
		}

		return [result, rawResult];

	},
	setTreeCheckAbled : function(){
		var me = this;
        var view = me.getView();

        this.getRootNode().cascadeBy(function(node, view){
            var uiNode = view.getNodeByRecord(this);
            if(!Ext.isEmpty(uiNode)){
	            Ext.get(uiNode).query('.x-tree-checkbox')[0].disabled='disabled';
            }
        }, null, [me, view]);
	},
	// 设值
	setValue : function(value) {
		var values;
		if (typeof value === 'string') {
			values = value.split(',');
		} else {
			values = value;
		}

		if (toString.call(values) === '[object Array]') {

			var root = this.getRootNode();
			this.initValue(root, values);

		}

	},
	initValue : function(node, values) {
		if (node.isExpandable()) {
			node.expand(false, function() {
				var childNodes = node.childNodes, length = childNodes.length, i;

				for (i = 0; i < length; i++) {
					var child = childNodes[i];
					if (child.isExpandable()) {
						this.initValue(child, values);
					}
					if (Ext.Array.contains(values, child.data.id)
							&& child.raw.checkable) {

						child.set('checked', true);

						child.fireEvent('checkchange', child, true);

					}
				}
			}, this);
		}
	},// 通过id获取节点,只能获取到已经加载过的节点
	getNode : function(nodeId, parentNode) {
		var me = this;
		
		if (!parentNode) {
			parentNode = this.getRootNode();
		}
		if (parentNode.data.id == nodeId) {
			return parentNode;
		}
		if (parentNode.isExpandable()) {
			var childNodes = parentNode.childNodes, length = 0, i;
			if (childNodes) {
				length = childNodes.length;
			}
			for (i = 0; i < length; i++) {
				var child = childNodes[i];

				if (child.isExpandable()) {
					var node = me.getNode(nodeId, child);
					if (node) {
						return node;
					}
				} else {
					if (child.data.id == nodeId) {
						return child;
					}
				}
			}
		}
		return null;
	},
	onUpdate : function(record) {
		var me = this, index, node;

		if (me.rendered) {
			index = me.store.indexOf(record);
			if (index > -1) {
				node = me.bufferRender([record], index)[0];
				// ensure the node actually exists in the DOM
				if (me.getNode(record)) {
					me.all.replaceElement(index, node, true);
					me.updateIndexes(index, index);
					// Maintain selection after update
					me.selModel.refresh();
					if (me.hasListeners.itemupdate) {
						me.fireEvent('itemupdate', record, index, node);
					}
					return node;
				}
			}
		}
	},
	addList: function(leaf) {
        var me = this,
        listTree = me.getListTree(),
        cellEditingPlugin = listTree.cellEditingPlugin,
        selectionModel = listTree.getSelectionModel(),
        selectedList = selectionModel.getSelection()[0],
        parentList = selectedList.isLeaf() ? selectedList.parentNode : selectedList,
        newList = Ext.create('SimpleTasks.model.List', {
            name: 'New ' + (leaf ? 'List' : 'Folder'),
            leaf: leaf,
            loaded: true // set loaded to true, so the tree won't try to dynamically load children for this node when expanded
        }),
        expandAndEdit = function() {
            if(parentList.isExpanded()) {
                selectionModel.select(newList);
                me.addedNode = newList;
                cellEditingPlugin.startEdit(newList, 0);
            } else {
                listTree.on('afteritemexpand', function startEdit(list) {
                    if(list === parentList) {
                        selectionModel.select(newList);
                        me.addedNode = newList;
                        cellEditingPlugin.startEdit(newList, 0);
                        // remove the afterexpand event listener
                        listTree.un('afteritemexpand', startEdit);
                    }
                });
                parentList.expand();
            }
        };
            
        parentList.appendChild(newList);
        listTree.getStore().sync();
        if(listTree.getView().isVisible(true)) {
            expandAndEdit();
        } else {
            listTree.on('expand', function onExpand() {
                expandAndEdit();
                listTree.un('expand', onExpand);
            });
            listTree.expand();
        }
    },
	/**
	 * 隐藏节点
	 */
	hideNode : function(hideNode){
		var me = this; 
		me.getRootNode().cascadeBy(function(node){
			if(hideNode.data.id == node.data.id){
				node.destroy();
			}
		});
	},
	/**
	 * 方法 Methods
	 */
	selectNode : function(nodeId,callback,scop){
		var me = this;
		me.getRootNode().cascadeBy(function(node){
			if(node.data.id==nodeId){
				me.getSelectionModel().select(node);
				if(Ext.isFunction(callback)){
					callback.call(scop||me,node);
				}
			}
		});
	},
	/**
	 * 分层加载迭代方法
	 */
	expandLevelFn : function(){
		var me = this;
		me.expandLevel = me.expandLevel-1;
		if(Ext.isEmpty(me.getSelectionModel().getStore())||Ext.isEmpty(me.getSelectionModel().getStore().data)){
			return;
		}
		var nodeLen = me.getSelectionModel().getStore().data.length;
		nodeLen = me.rootVisible?nodeLen:nodeLen+1;
		
		var nodeNum =0;
		if(me.expandLevel>0){
			me.getRootNode().cascadeBy(function(node){
				var currNode=this;
				
				if(node.childNodes.length==0){
					me.expandNode(currNode,null,function(node){
						nodeNum++;
						if(nodeNum==nodeLen){
							me.expandLevelFn();
						}
					});
				}else{
					nodeNum++;
					if(nodeNum==nodeLen){
						me.expandLevelFn(callback);
					}
				}
			});
		}else{
			me.fireEvent('allLoad');
		}
	},
	/**
	 * 展开到指定更节点
	 * params:{id:}
	 */
	expandParentPath : function(params,callback,scop){
		var me = this;

		var pathArr = params.parentPath.split('/');
		if(Ext.isEmpty(params.parentPath)){
			me.selectNode(params.nodeId,function(node){
				if(Ext.isFunction(callback)){
					callback.call(scop||me,node);
				}
			});
		}else{
			me.getRootNode().cascadeBy(function(node){
				var currNode = this;
				if(node.data.id==pathArr[pathArr.length-1]){
					if(node.childNodes.length>0){
						var pId = "/"+pathArr[pathArr.length-1];
						var pPath = params.parentPath;
						params.parentPath = pPath.substr(0,pPath.length-pId.length);
						return me.expandParentPath(params,callback);
					}else{
						me.expandNode(currNode,null,function(){
							var pId = "/"+pathArr[pathArr.length-1];
							var pPath = params.parentPath;
							params.parentPath = pPath.substr(0,pPath.length-pId.length);
							return me.expandParentPath(params,callback);
						});
					}
				}
			});
		}
	},
	removeNode : function(nodeId,callback,scop){
		var me = this;
		var currNode;
		me.getRootNode().cascadeBy(function(node){
			if(node.data.id==nodeId){
				currNode = node;
				if(Ext.isFunction(callback)){
					callback.call(scop||me,node);
				}
			}
		});
		currNode.remove();
	},
	selectNodeByBizId : function(bizId,fieldName,callback,scop){
		var me = this,flag=false;
		me.getRootNode().cascadeBy(function(node){
			var attrs = null;
			if(node.raw.attributes){
				attrs = Ext.JSON.decode(node.raw.attributes);
			}else{
				attrs = node.raw;
			}
			if(!Ext.isEmpty(attrs)&&attrs[fieldName]==bizId){
				me.getSelectionModel().select(node);
				callback.call(scop||me,node);
				flag=true;
			}
		});
		if(!flag){
			callback.call(scop||me,null);
		}
	},
	setNodeChecked : function(nodeId, checked) {
		if (checked != false) {
			checked = true;
		}
		this.getNode(nodeId).set('checked', checked);
	},
	getSelectNode : function(){
		var me = this;
		var nodes = me.getSelectionModel().getSelection();
		return nodes[0];
	},
	getCheckValue : function() {
		var me = this;
    	var checkNodes = me.getChecked();
		return checkNodes;
	},
	/**
	 * 刷新某节点
	 */
	refreshNodeData : function(nodeId) {
		var me = this;
		var store = me.getStore();
		var node = me.getNode(nodeId);
		
		store.load({
			node : node,
			callback : function() {
				me.onUpdate(store, node);
			}
		});
	},
	refreshData : function(callback,scop) {
		var me = this;
		
		var view = me.getView();
		if (me.rootId) {
			me.store.root = {
				text : 'root',
				id : me.rootId||'0',
				expanded : true
			};
			me.getRootNode().data.id = me.rootId || '0';
		}
		if (me.url) {
			me.store.proxy.url = me.url;
		}
		me.store.load({
			callback : function() {
				view.refresh();
				if(Ext.isFunction(callback)){
					callback.call(scop||me,null);
				}
			}
		});
	}
});