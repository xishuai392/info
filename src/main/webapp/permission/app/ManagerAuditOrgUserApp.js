/**
 * 组织架构人员管理<br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */

Ext.onReady(function() {
    var thizStore, thizGrid, thizDetailForm, thizSearchForm,orgTree,pswChanged=false;
    var actionType = WEBConstants.ACTIONTYPE.VIEW;// 动作标记
    var thizAction = Ext.create("component.permission.action.AuditUserAction");

    
    
    
    // 数据源
    thizStore = Ext.create('component.permission.store.AuditUserStore', {
        // 定义分页大小
        pageSize : WEBConstants.DEFAULT_PAGE_SIZE,
        listeners : {
            // 载入的时候默认选中第一条；如果没有任何记录，则处理按钮灰化
            "load" : function(thiz, records) {
                if (Ext.isEmpty(records)) {
                    var items = thizGrid.getSelectedItems();
                    thizGrid.getSelectionModel().fireEvent('selectionchange', null, items);
                } else {
                    thizGrid.select(0);
                }
                pswChanged = true;
            },
            "beforeload" : function(thiz, records) {
            	var models = orgTree.getSelectionModel().getSelection();
            	if(null==models || models === undefined || models.length==0){
            		ExtUtils.error("请先选择所属组织！");
            		return false;
            	}else{
	            	var thizOrgId = models[0].data.attributeMap['orgId'];
	    			// 开始查询
	    			Ext.getCmp('userGridId').getStore().getProxy().setExtraParam('orgId',thizOrgId);
            	}
            	
            	
            }
            
        }
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizStore,
        items : [
	      	{
	            fieldLabel : "用户名称",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "userName"
        	},
	      	{
	            fieldLabel : "用户编码",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "userCode"
        	},
	      	{
	            fieldLabel : "状态",
	            xtype : "combo",
	            name : "state",
	            displayField : 'text',
	            valueField : 'value',
	            editable : false,
	            store : new Ext.data.ArrayStore({
	                fields : ['value', 'text'],
	                data : [['00A', '有效'], ['00X', '无效']]
	            })
	        }
        ]
    });

    // 记录表格
    thizGrid = Ext.create('ZTEsoft.grid.Panel', {
        region : "center",
        id : 'userGridId',
        title : "系统用户列表",
        store : thizStore,
        isPage : true,
        tbar : Ext.create('Ext.toolbar.Toolbar', {
        	items: ['->',
	        {
	            // xtype: 'button', // 默认的工具栏类型
	            text: '分配角色',
	            iconCls : 'addRole',
	            listeners: {
			        click: function() {
			            var items = thizGrid.getSelectedItems();
			            if (Ext.isEmpty(items)) {
			                ExtUtils.info(StrConstants.HINT_SELECT_FIRST);
			                return false;
			            }
			
			            var item = items[0];
			        }
			    }
	        }]
        }),
        columns : [
	        {
	            text : "用户名称",
	            dataIndex : "userName",
	            flex : 1
	        },
	        {
	            text : "用户编码",
	            dataIndex : "userCode",
	            flex : 1
	        },
	        {
	            text : "电话",
	            dataIndex : "telephone",
	            flex : 1
	        },
	        {
	            text : "邮箱",
	            dataIndex : "email",
	            flex : 1
	        },
	        {
	            text : "年龄",
	            dataIndex : "age",
	            flex : 1
	        },
	        {
	            text : "状态",
	            dataIndex : "state",
	            renderer : function(value, meta, record) {
	                return value == '00A' ? '有效' : '无效';
	            },
	            flex : 0.5
	        },
	        {
	            text : "创建时间",
	            dataIndex : "createdDate",
	            flex : 1
	        }	       
		]
    });

    // [新增、修改、删除] [保存、取消] 工具栏 在两组按钮组之间切换
    var fbar = Ext.create("ZTEsoft.toolbar.ButtonsToolbar", {
        /**
         * 新增 1、初始化所有输入框 2、光标默认选中第一个输入框
         */
        onClickAdd : function() {
            actionType = WEBConstants.ACTIONTYPE.NEW;
            pswChanged = false;
            thizDetailForm.enableFields();
            thizDetailForm.getForm().reset();
            thizDetailForm.getForm().findField("userId").selectText();
        },

        /**
         * 修改： 1、设置所有输入框可用 2、光标默认选中第一个输入框
         */
        onClickEdit : function() {
            actionType = WEBConstants.ACTIONTYPE.EDIT;
            pswChanged = false;
            thizDetailForm.enableFields();
            thizDetailForm.getForm().findField("userId").selectText();
        },

        /**
         * 删除校验： 1、校验是否选中了对象或者其他 <BR>
         * 2、根据业务需要，进行一些删除的判断 <BR>
         */
        onClickDelBefore : function() {
            var items = thizGrid.getSelectedItems();
            if (Ext.isEmpty(items)) {
                ExtUtils.info(StrConstants.HINT_SELECT_FIRST);
                return false;
            }

            var item = items[0];
            // 根据业务需要，进行一些删除的判断
            // 比如：当前登录用户不能删除自身
            // if (item.get("userId") == userSession.userId) {
            // ExtUtils.info(StrConstants.HINT_DEL_USER_SELF);
            // return false;
            // }

            return true;
        },

        /**
         * 删除： 1、提交后台数据 2、回调函数里面要把删除的记录动态从当前页去掉，并且选中下一条记录
         */
        onClickDel : function() {
            var item = thizGrid.getSelectedItem();
            pswChanged = false;

            // 获取当前选中条目在store中的index，删除之后要选中当前记录的上一条记录
            var index = thizStore.indexOf(item);
            var fieldPK = item.get('userId');// TODO 获取记录的主键，后台根据主键删除该记录
            thizAction.delRecord(fieldPK, function(result) {
                ExtUtils.info(StrConstants.HINT_DEL_SUCCESS);
                thizGrid.removeItemToNext(item);
            });

        },

        /**
         * 保存：
         */
        onClickSave : function() {
            if (!thizDetailForm.getForm().isValid()) {
                return;
            }
            var params = thizDetailForm.getForm().getValues();

            // TODO 自定义校验

            // 新增：保存到数据库；动态加载数据到store不刷新界面；后台要返回当前新增的对象（包括主键ID）
            if (actionType == WEBConstants.ACTIONTYPE.NEW) {
            	var models = orgTree.getSelectionModel().getSelection();
            	if(null==models || models === undefined || models.length==0){
            		ExtUtils.error("请先选择所属组织！");
            		return false;
            	}else{
	            	var thizOrgId = models[0].data.attributeMap['orgId'];
	    			params.orgId = thizOrgId;
            	}
            	
                thizAction.addRecord(params, function(result) {
                    ExtUtils.info(StrConstants.HINT_ADD_SUCCESS);
                    var thizModel = Ext.create("component.permission.model.AuditUserModel");
                    pswChanged = false;
                    thizModel.data = result;
                    thizGrid.getStore().add(thizModel);
                    thizGrid.select(thizModel);
                });
            }
            /**
             * 修改保存： 1、存库 2、动态刷新当前store的当前选择记录
             */
            else if (actionType == WEBConstants.ACTIONTYPE.EDIT) {
                var item = thizGrid.getSelectedItem();
                params.userId = item.get("userId");
                thizAction.modRecord(params, function(result) {
                    ExtUtils.info(StrConstants.HINT_MOD_SUCCESS);
                    // TODO  设置要更新的字段
                    var changedColumns = ['userName' ,'userCode' ,'telephone' ,'email' ,'password' ,'age' ,'state' ,'createdDate' ,'orgId' ];
                    for (var colKey in changedColumns) {
                        var colValue = changedColumns[colKey];
                        item.set(colValue, result[colValue]);
                    }
                    // TODO  如果还有其他字段要更新（比如从其他地方获取到的值）
                    // item.set("XXXX", others.XXXX);
                    thizGrid.getStore().commitChanges();

                    var items = thizGrid.getSelectedItems();
                    thizGrid.getSelectionModel().fireEvent('selectionchange', null, items);
                });
            }
        },

        /**
         * 取消： 触发selectionchange事件，还原到选中记录的详情界面
         */
        onClickCancel : function() {
            var items = thizGrid.getSelectedItems();
            thizGrid.getSelectionModel().fireEvent('selectionchange', thizGrid.getSelectionModel(), items);
        }
    });

    // 详情Form
    thizDetailForm = Ext.create('ZTEsoft.form.EditForm', {
        title : "详情",
        region : 'south',
        border : false,
        columnNum : 4,// 每行的列数，如果没设置，默认为4
        items : [
	        {
	            fieldLabel : "userId",
	            hidden : true,
	            xtype : "textfield",
	            name : "userId"
	        },
	        {
	            fieldLabel : "用户名称",
	            xtype : "textfield",
	            allowBlank : false,
	            name : "userName"
	        },
	        {
	            fieldLabel : "用户编码",
	            xtype : "textfield",
	            allowBlank : false,
	            name : "userCode"
	        },
	        {
	            fieldLabel : "电话",
	            xtype : "textfield",
	            vtype : "phone",
	            name : "telephone"
	        },
	        {
	            fieldLabel : "邮箱",
	            xtype : "textfield",
	            vtype : "email",
	            name : "email"
	        },
	        {
	            fieldLabel : "密码",
	            xtype : "textfield",
	            allowBlank : false,
	            name : "password",
	            trigger1Cls : Ext.baseCSSPrefix + 'form-setting-trigger',
				name:'password',
				minLength : 6,
				maxLength : 32,
				//value:'*******',
				inputType:'password',
				onTrigger1Click:function(){
					console.log("onTrigger1Click");
				},
				enableKeyEvents : true,
				listeners: {
			        'focus': function(thiz,event,opts){
			        	//console.log("focus");
			        	thiz.selectText();
			        },
			        'keypress' : function(thiz,event,opts){
			        	console.log("keypress");
			        	pswChanged = true;
			        },
			        'blur' : function(thiz,event,opts){
			        	//console.log("blur"+pswChanged);
			        	if(!pswChanged)return;
			        	if(thiz.isDisabled( ))return;
			        	var val = thiz.getValue();
			        	if(val == '' || val==null){
			        		return ;
			        	}
			        	if(val.length<6)return;
			        	thiz.setValue(MD5(val));
			        	pswChanged = false;
			        }
			    }
	        },
	        {
	            fieldLabel : "年龄",
	            xtype : "numberfield",
	            vtype : 'age',
	            name : "age"
	        },
	        {
	            fieldLabel : "状态",
	            xtype : "combo",
	            name : "state",
	            displayField : 'text',
	            valueField : 'value',
	            editable : false,
	            allowBlank : false,
	            store : new Ext.data.ArrayStore({
	                fields : ['value', 'text'],
	                data : [['00A', '有效'], ['00X', '无效']]
	            })
	        }
		],
        fbar : fbar
    });

    /**
     * 表格选中变化事件 <br>
     * 1、设置所有输入框不可用,清空所有输入框（以防删除到最后一条记录的时候清空不了） <br>
     * 2、根据是否选择记录来设置按钮状态(edit,delete buttons) <br>
     * 3、加载表单详情 <br>
     */
    thizGrid.getSelectionModel().on("selectionchange", function(sm, items) {
    	pswChanged = false;
        actionType = WEBConstants.ACTIONTYPE.VIEW;
        thizDetailForm.disableFields();
        thizDetailForm.getForm().reset();
        fbar.resetButtons();
        if (Ext.isEmpty(items)) {
            fbar.disableButtons();
            return;
        }

        fbar.enableButtons();
        thizDetailForm.getForm().loadRecord(items[0]);

    });
    
    //机构树
    orgTree = Ext.create('ZTEsoft.tree.GeneralTree', {
        region : 'west',
        // split:false,
        // width:treeWidth,
        title : '组织架构',
        renderTo : Ext.getBody(),
        border : true,
        showSearch : false,
        displayName : "组织名称",
        nodeParam : 'parentOrgId',
        paramMap : {
            sqlKey : 'com.ztesoft.web.common.db.dao.mapper.GeneralTreeMapper.orgTree',
            // stateField : 'staffState',
            // searchField : 'staffName',
            valueField : 'orgId',
            parentField : 'parentOrgId',
            //parentField : 'parentOrgId',
            //nodeParam : 'parentOrgId',
            displayField : 'orgName'
        },
        listeners : {
        	afterrender : function(){
        		this.getSelectionModel().select(1);
        	},
    		select : function(dataview, record, index, e){
    			Ext.getCmp('userGridId').getStore().removeAll();
    			var thizOrgId = record.data.attributeMap['orgId'];
    			// 开始查询
    			Ext.getCmp('userGridId').getStore().getProxy().setExtraParam('orgId',thizOrgId);
    			Ext.getCmp('userGridId').getStore().load();
    		}
    	}
    });

    var userPanel = Ext.create('Ext.panel.Panel', {
    	region : 'center',
        layout : 'border',
        items : [thizSearchForm, thizGrid, thizDetailForm]
    });

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [userPanel,orgTree]
    });

});
