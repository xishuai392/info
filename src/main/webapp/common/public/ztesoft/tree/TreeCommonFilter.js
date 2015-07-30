/**
 * @author 	Damen
 * @date 	2013-11-18
 * @define 	component.public.TreeCommonFilter
 * 
 */

Ext.define('ZTEsoft.tree.TreeCommonFilter', {
    filterByText: function(text) {
        this.filterBy(text, 'text');
    },
    /**
     * Filter the tree on a string, hiding all nodes expect those which match and their parents.
     * @param The term to filter on.
     * @param The field to filter on (i.e. 'text').
     */
    filterBy: function(text, by) {
        this.clearFilter();
        var view = this.getView(),
            me = this,
            nodesAndParents = [];
        // Find the nodes which match the search term, expand them.
        // Then add them and their parents to nodesAndParents.
        this.getRootNode().cascadeBy(function(node, view){
            var currNode = this;
 
            if(currNode && currNode.data[by] && currNode.data[by].toString().toLowerCase().indexOf(text.toLowerCase()) > -1) {
            	if(me.localFilter){
            		me.expand(currNode.getPath());
            	}else{
            		me.expandPath(currNode.getPath());
            	}
                while(currNode.parentNode) {
                    nodesAndParents.push(currNode.id);
                    currNode = currNode.parentNode;
                }
            }
        }, null, [me, view]);
        // Hide all of the nodes which aren't in nodesAndParents
        this.getRootNode().cascadeBy(function(node, view){
            var uiNode = view.getNodeByRecord(this);
            if(uiNode && !Ext.Array.contains(nodesAndParents, this.id)) {
            	Ext.get(uiNode).setDisplayed('none');
            }
        }, null, [me, view]);
    },
    clearFilter: function() {
    	var me = this;
        var view = this.getView();
//        if(me.checkable){
//        	me.getRootNode().cascadeBy(function(tNode){
//        		tNode.set('checked', false);
//        	});
//        }
        this.getRootNode().cascadeBy(function(node, view){
            var uiNode = view.getNodeByRecord(this);
            if(uiNode) {
                Ext.get(uiNode).setDisplayed('table-row');
            }
        }, null, [this, view]);
    }
});