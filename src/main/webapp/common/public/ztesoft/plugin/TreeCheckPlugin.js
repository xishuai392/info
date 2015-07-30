/**
			var selections = me.KPITreePanel.getSelectionModel().getSelection();//.set('checked',false);
 			 console.info(selections);
 			 selections = me.KPITreePanel.getChecked();
 			 console.info(selections);
 */

Ext.define('ZTEsoft.plugin.TreeCheckPlugin', {
	extend : 'Ext.AbstractPlugin',
	alias : 'plugin.TreeCheckPlugin',
	init : function(tree) {
		var me = this;
//		if(!tree.disableClick){
//			tree.on('itemclick',function(view, record, item, index,e,eOpts){
//				if(record!=null){
//					var checked = record.get('checked');
//					if(!Ext.isEmpty(checked)){
//						record.set('checked', !checked);
//						this.fireEvent('checkchange',record,!checked);
//					}
//				}
//		 	 });
//		}
		tree.on('checkchange', function(node, checked) {
			node.checked = checked;
			me.childCheck(node, checked);
		});
		tree.childExpand=Ext.Function.bind(me.childExpand,tree);
		tree.childCheck=Ext.Function.bind(me.childCheck,tree);//me.childCheck.bind(tree);
		me.callParent([arguments]);
	},
	childCheck : function(node, checked) {
		var me = this;
		if (node.isExpandable()) {
			if(node.isExpanded()){
				me.childExpand(node, checked);
			}
			else{
				node.expand(false, function() {
					me.childExpand(node, checked);
				});
			}
		}
	},
	childExpand:function(node, checked){
		var childNodes = node.childNodes, length = childNodes.length, i;
		for (i = 0; i < length; i++) {
			var child = childNodes[i];
			if (child.isExpandable()&&!child.isLeaf()) {
				this.childCheck(child, checked);
			}
			if(child.get('checked')!=null)
				child.set('checked', checked);
		}
	}
});
