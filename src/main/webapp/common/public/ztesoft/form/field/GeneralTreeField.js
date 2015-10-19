/**
 * @description 通用树表单项
 * 若不需要查询框，则valueField、displayField和sqlKey这三项必填
 * 若需要查询框，则还要配置parentField、tableName
 * @author codeCreater
 * @date 2014年11月20日
 */

Ext.define('ZTEsoft.form.field.GeneralTreeField', {
	extend : 'ZTEsoft.form.field.TextButtonField',
	requires : ['ZTEsoft.form.field.ClearTextField','ZTEsoft.button.QueryButton'],
    alias: ['widget.treeField'],
    config : {
    	title : null,
    	rootId : 0,							//根节点值
    	rootText:'根节点',
        rootVisible: true,				//是否显示根节点
        valueField : 'id',
        displayField : 'text',
        icon : null,
        deep : 2,							//每次查询多少级子节点（i-1）,默认每次只查询一级子节点
        sqlKey : null,					//xxxMapper.xml中的sqlKey
    	initTreeId : null,				//初始节点id，如果有设置值，则选择的树节点时，不能选该节点及其子节点，
    	showSearch : true,         //是否显示查询框
    	displayName : null,
    	searchUrl : null,				//树查询访问的后台地址，如果有配置该属性，后面的几项配置可以不要
    	parentField : null,         	//父id属性(查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
    	filterState : true,				//是否过滤状态(查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
        stateField : 'state',        	//状态属性(查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
        stateValue : '00A',         	//有效状态值(查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
        tableName : null,			//表名(数据库中的表名，查询树节点会用到，如果不需要显示查询框，则不必设置，否则需要设置)
        orderByClause : null,      //排序字段(如：GROUP_ID DESC)
    	operation : WEBConstants.OPERATION.Like  //查询框匹配方式，默认使用模糊查询
    },
    firstInit : true,
    parentIds : {},
	trigger1Cls : Ext.baseCSSPrefix + 'form-org-trigger',trigger2Cls : Ext.baseCSSPrefix + 'form-clear-trigger',
	onTrigger1Click:function(){
		var me = this;
		if (me.readOnly) {
			return false;
		}
		if(!this.tree){
			var treeWidth=320;
			if(!me.searchUrl){
				me.searchUrl = webRoot+"base/queryTree.do"
			}
			this.tree = Ext.create('Ext.window.Window',{
				title:me.title,
				closeAction:'hide',
				width:treeWidth,
				height:Ext.getBody().getHeight()*0.8,
				modal:true,
				plain : true, // 背景
				constrain : true, // 限制窗口不超出浏览器边界
				layout:'border',
				listeners : {
                    beforeshow : function() {
                        if (me.firstInit) {
                            me.firstInit = false;
                        } else {
                        	var name = me.displayField;
                        	me.tree.down('[name='+name +']').setValue("");
                        	me.treepanel.searchHandler();
                        }
                    }
                },
				items:Ext.create('ZTEsoft.tree.GeneralTree',Ext.apply({
					collapsible: false,
					rootVisible: me.rootVisible,
					region:'center',
					width:treeWidth
				},{title:null,rootId : me.rootId,rootText:me.rootText,
					filterState : me.filterState,displayName : me.displayName,
					showSearch : me.showSearch,
					searchUrl : me.searchUrl,
			    	paramMap : {
                        sqlKey : me.sqlKey,
                        deep : me.deep,
                        icon : me.icon,
                        valueField : me.valueField,
                        displayField : me.displayField,
                        parentField : me.parentField,
                        stateField : me.stateField,
                        stateValue : me.stateValue,
                        operation : me.operation,
                        orderByClause : me.orderByClause,
                        tableName : me.tableName
                    },
			    	buttonAlign:'center',
					buttons:[{
						text:'确定',
						handler:function(){
							var nodes = me.treepanel.getSelectionModel().getSelection();
							if(nodes.length==0){
								return Ext.Msg.alert('提示',StrConstants.HINT_SELECT_FIRST);
							}
							var valid = me.myValidate(nodes);
							if(!valid){
								return false;
							}
							if (me.initTreeId != null) {
                                me.parents = {};
				                ExtUtils.getParentNodes(nodes[0],me.parents);
				                if (me.parents[me.initTreeId]) {
                                    ExtUtils.info(StrConstants.HINT_SELECT_PARENT_ERROR);
	                				return;
                                }
                            }
							me.setValue(nodes[0].data.text+","+nodes[0].data.id);
							me.tree.hide();
						}
					},{
						text:'取消',
						handler:function(){
							me.tree.hide();
						}
					}]
			    }))
			});
			me.treepanel = me.tree.down('treepanel');
		}
		this.tree.show();
	},
	constructor : function(config) {
		this.config = config;
		this.callParent([config]);
	},
	myValidate: function(nodes) {
		return true;
	}
});