/**
 * @description  AuditMenuRoleTreeWin munu_role树形
 * @author codeCreater
 * @date 2014年11月20日
 */

Ext.define('component.permission.view.AuditMenuRoleTreeWin', {
    extend : 'ZTEsoft.window.PopWindow',
    config : {
        treePanel : null,
        action : Ext.create("component.permission.action.AuditMenuRoleAction")
    },
    closeAction : 'hide',
    /**
     * 构造函数，用于初始化界面
     * 
     * @param {}
     *            config
     */
    constructor : function(config) {
        config = config || {};

        var me = this;

        // TODO 设置额外的参数
        me.pkFiledId = config.pkFiledId;
        
        me.roleId = config.roleId;

        me.winType = config.winType;

        
        //创建菜单树
    	me.treePanel = me.createTreePanel(me.roleId);
    

        Ext.applyIf(config, {
            width : 300,
            height : 450,
            layout : 'fit',
            maximizable : true,
            items : [me.treePanel],
            resizable : true
        });
        this.callParent([config]);
    },
    // 初始化界面
    initComponent : function() {
        var me = this;

        this.callParent();
    },
    
    //菜单树
    createTreePanel : function(roleId){
    	console.log("roleId:"+roleId);
    	
    	//菜单数
	    menuRoleTree = Ext.create('ZTEsoft.tree.GeneralTree', {
	    	region : 'center',
	        // split:false,
	        width:300,
	        title : '菜单树',
	        //rootVisible : true,
	        border : true,
	        showSearch : false,
	        deep : 5,
	        displayName : "菜单",
	        nodeParam : 'menuId',
	        checkable : true,
	        cascadeCheck : 'up',
	        paramMap : {
	            sqlKey : 'com.ztesoft.web.common.db.dao.mapper.GeneralTreeMapper.menuRoleTree',
	            roleId : roleId,
	            checked : true,
	            valueField : 'menuId',
	            checkField : 'checked',
	            displayField : 'menuTitle'
	        },
	        listeners : {
	        	afterrender : function(){
	        		this.getSelectionModel().select(1);
	        		this.expandAll();
	        	},
	    		select : function(dataview, record, index, e){
	    			//console.log('menu tree selected');
	    		},
	    		checkchange : function(node, checked, eOpts ){
	    			
	    			if (checked == true) {
					    node.checked = checked;
					    // console.dir(node.parentNode);
					    //alert(node.get("leaf"));
					    //获得父节点
					    pNode = node.parentNode;
					  	//当checked == true通过循环将所有父节点选中
					    for (; pNode != null; pNode = pNode.parentNode) {
					    	//console.log(pNode.data.id);
					    	if(pNode.data.id!=-1)
					    		pNode.set("checked", true);
					    }
				    }
				    //当该节点有子节点时，将所有子节点选中删除
				    if (!node.get("leaf") && !checked)
				    	node.cascade(function(node){
				    	node.set('checked', false);
				    });
	    		}
	    	}
	    });
    	return menuRoleTree;
    },

    // 确定按钮回调函数，在此处理新增、修改操作
    okHandler : function(thiz,ob1,ob2) {
        var me = this;
        
        var nodes = me.down('treepanel').getChecked( );
        var menuIds = [];
        Ext.Array.each(nodes, function(node, index, allItems) {
		    menuIds.push(node.data.id);
		});
        
        me.getAction().saveMenuRole(me.roleId,menuIds,function(result){
        	ExtUtils.info(StrConstants.HINT_SAVE_SUCCESS);
        	me.close();
        });
        

    }

});