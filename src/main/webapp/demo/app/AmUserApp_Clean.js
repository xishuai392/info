/**
 * 用户管理，DEMO， <br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author pan.xiaobo
 */

Ext.onReady(function() {
    var thizStore, thizGrid, thizDetailForm, thizSearchForm;
    var actionType = WEBConstants.ACTIONTYPE.VIEW;// 动作标记
    var thizAction = Ext.create("component.demo.action.AmUserAction");

    // 数据源
    thizStore = Ext.create('component.demo.store.AmUserStore', {
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
            }
        }
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizStore,
        items : [{
            fieldLabel : "用户名",
            xtype : "textfield",
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            name : "userName"
        }, {
            fieldLabel : "用户昵称",
            xtype : "textfield",
            name : "nickName"
        }]

    });

    // 记录表格
    thizGrid = Ext.create('ZTEsoft.grid.Panel', {
        region : "center",
        title : "用户列表",
        store : thizStore,
        isPage : true,
        columns : [{
            text : "用户名",
            dataIndex : "userName",
            flex : 1
        }, {
            text : "昵称",
            dataIndex : "nickName",
            flex : 1
        }, {
            text : "状态",
            dataIndex : "state",
            flex : 1
        }, {
            text : "邮箱",
            dataIndex : "email",
            flex : 1
        }, {
            text : "电话",
            dataIndex : "telephone",
            flex : 1
        }, {
            text : "年龄",
            dataIndex : "age",
            flex : 1
        }, {
            text : "创建时间",
            dataIndex : "createdDate",
            flex : 1
        }]
    });

    // [新增、修改、删除] [保存、取消] 工具栏 在两组按钮组之间切换
    var fbar = Ext.create("ZTEsoft.toolbar.ButtonsToolbar", {
        /**
         * 新增 1、初始化所有输入框 2、光标默认选中第一个输入框
         */
        onClickAdd : function() {
            actionType = WEBConstants.ACTIONTYPE.NEW;
            thizDetailForm.enableFields();
            thizDetailForm.getForm().reset();
            thizDetailForm.getForm().findField("userName").selectText();
        },

        /**
         * 修改： 1、设置所有输入框可用 2、光标默认选中第一个输入框
         */
        onClickEdit : function() {
            actionType = WEBConstants.ACTIONTYPE.EDIT;
            thizDetailForm.enableFields();
            thizDetailForm.getForm().findField("userName").selectText();
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
                thizAction.addRecord(params, function(result) {
                    ExtUtils.info(StrConstants.HINT_ADD_SUCCESS);
                    var thizModel = Ext.create("component.demo.model.AmUserModel");
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
                    var changedColumns = ['telephone', 'email', 'nickName', 'userName', 'age', 'state'];
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
        items : [{
            fieldLabel : "用户名",
            xtype : "textfield",
            name : "userName",
            allowBlank : false,
            maxLength : 60
        }, {
            fieldLabel : "昵称",
            xtype : "textfield",
            name : "nickName"
        }, {
            fieldLabel : "状态",
            xtype : "combo",
            name : "state",
            displayField : 'text',
            valueField : 'value',
            editable : false,
            store : new Ext.data.ArrayStore({
                fields : ['value', 'text'],
                data : [['A', '有效'], ['X', '无效']]
            })
        }, {
            fieldLabel : "邮箱",
            name : "email",
            xtype : "textfield",
            allowBlank : false,
            vtype : "email"
        }, {
            fieldLabel : "电话号码",
            name : "telephone",
            xtype : "textfield"
        }, {
            fieldLabel : "年龄",
            name : "age",
            xtype : "numberfield"
        }, {
            fieldLabel : "触发器",
            name : "test",
            xtype : "ztetextbutton",
            handler : function() {
                ExtUtils.info("触发器被点击");
            }
        }],

        fbar : fbar
    });

    /**
     * 表格选中变化事件 <br>
     * 1、设置所有输入框不可用,清空所有输入框（以防删除到最后一条记录的时候清空不了） <br>
     * 2、根据是否选择记录来设置按钮状态(edit,delete buttons) <br>
     * 3、加载表单详情 <br>
     */
    thizGrid.getSelectionModel().on("selectionchange", function(sm, items) {
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

    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizGrid, thizDetailForm]
    });

    // 开始查询
    thizGrid.getStore().load();

});
