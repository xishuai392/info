/**
 * @description [新增、修改、删除] [保存、取消] 工具栏 在两组按钮组之间切换，<br>
 *              需要调用者： <br>
 *              ①自行控制各个按钮的显示与否：默认false(显示)，如果设置为true，则隐藏该按钮；<br>
 *              is_btn_add_hide/is_btn_edit_hide/is_btn_del_hide/is_btn_save_hide/is_btn_can_hide/<br>
 *              ②自行完成显示按钮的handler、callback函数<br>
 *              ③在handler、callback函数中自行控制toolbar的父组件(比如formpanel)的各个子组件的显示状态、显示值等；<br>
 *              ④在handler、callback函数中应先判断是否有选中数据（比如formpanel、gridpanel中是否有选择等）
 * 
 * @author pan.xiaobo
 */
Ext.define('ZTEsoft.toolbar.ButtonsToolbar', {
    extend : 'Ext.toolbar.Toolbar',
    alias : 'widget.ztebuttonstoolbar',
    requires : ['ZTEsoft.common.StrConstants'],
    renderTo : Ext.getBody(),

    is_btn_add_hide : false,
    is_btn_edit_hide : false,
    is_btn_del_hide : false,
    is_btn_save_hide : false,
    is_btn_reset_hide : false,
    is_btn_can_hide : false,

    onClickAdd : function() {
        this.showMsg('onClickAdd');
    },
    onClickEdit : function() {
        this.showMsg('onClickEdit');
    },

    /**
     * 删除之前的校验
     */
    onClickDelBefore : function() {
        this.showMsg('onClickDelBefore');
    },
    /**
     * 用户确认要删除后的调用函数，请在这里实现删除逻辑
     */
    onClickDel : function() {
        this.showMsg('onClickDel');
    },
    onClickSave : function() {
        this.showMsg('onClickSave');
    },
    onClickReset : function() {
    	this.showMsg('onClickReset');
    },
    onClickCancel : function() {
        this.showMsg('onClickCancel');
    },
    /**
     * 设置edit，del按钮不可用
     */
    disableButtons : function() {
        var me = this;
        if (!me.is_btn_edit_hide) {
            this.down("button[itemId=btnEdit]").disable();
        }
        if (!me.is_btn_del_hide) {
            this.down("button[itemId=btnDel]").disable();
        }

    },
    /**
     * 设置edit，del按钮可用
     */
    enableButtons : function() {
        var me = this;
        if (!me.is_btn_edit_hide) {
            this.down("button[itemId=btnEdit]").enable();
        }
        if (!me.is_btn_del_hide) {
            this.down("button[itemId=btnDel]").enable();
        }
    },
    showMsg : function(handler) {
        Ext.Msg.show({
            title : '操作提示',
            msg : '该方法[' + handler + ']一般需要被重写！',
            buttons : Ext.Msg.OK,
            icon : Ext.Msg.WARNING
        });
    },
    /**
     * 恢复到默认状态：显示增删改，隐藏保存，取消
     */
    resetButtons : function() {
        var me = this;
        if (!me.is_btn_add_hide) {
            this.down("button[itemId=btnAdd]").show();
            this.down("tbseparator[itemId=tbAdd]").show();
        }
        if (!me.is_btn_edit_hide) {
            this.down("button[itemId=btnEdit]").show();
            this.down("tbseparator[itemId=tbEdit]").show();
        }
        // 如果删除不隐藏
        if (!me.is_btn_del_hide) {
            this.down("button[itemId=btnDel]").show();
        }
        // 如果删除隐藏
        else {
            // 如果修改显示，需要将后面的|隐藏
            if (!me.is_btn_edit_hide) {
                this.down("tbseparator[itemId=tbEdit]").hide();
            }
            // 如果修改隐藏，需要把新增后面的|隐藏
            else {
                // 新增隐藏
                if (!me.is_btn_add_hide) {
                    this.down("tbseparator[itemId=tbAdd]").hide();
                }

            }

        }
        if (!me.is_btn_save_hide) {
            this.down("button[itemId=btnSave]").hide();
            this.down("tbseparator[itemId=tbSave]").hide();
        }
        if (!me.is_btn_reset_hide) {
        	this.down("button[itemId=btnReset]").hide();
        	this.down("tbseparator[itemId=tbReset]").hide();
        }
        if (!me.is_btn_can_hide) {
            this.down("button[itemId=btnCancel]").hide();
        }

    },

    constructor : function(config) {
        var me = this;
        me.superclass.constructor.call(this, config);
    },

    initComponent : function(config) {
        var me = this;

        Ext.apply(this, config);

        me.items = [
        // 使用右对齐容器
        // 等同 { xtype: 'tbfill' }
        '->', {
            xtype : 'button',
            text : '新增',
            iconCls : 'add',
            btnType : 1,
            itemId : "btnAdd",
            isHidden : me.is_btn_add_hide,
            hidden : me.is_btn_add_hide,
            listeners : {
                'click' : function() {
                    var layout = me.getLayout();
                    var items = layout.getLayoutItems();
                    for (var p in items) {
                        if (items[p].btnType == 1) {
                            items[p].hide();
                        }
                        if (items[p].btnType == 2) {
                            if (!items[p].isHidden)
                                items[p].show();
                        }
                    }
                    me.onClickAdd();
                }
            }
        }, {
            xtype : 'tbseparator',
            itemId : "tbAdd",
            btnType : 1,
            hidden : me.is_btn_add_hide
        }, {
            xtype : 'button',
            text : '修改',
            iconCls : 'edit',
            btnType : 1,
            itemId : "btnEdit",
            isHidden : me.is_btn_edit_hide,
            hidden : me.is_btn_edit_hide,
            listeners : {
                'click' : function() {
                    var layout = me.getLayout();
                    var items = layout.getLayoutItems();
                    var next = true;
                    for (var p in items) {
                        if (items[p].btnType == 1) {
                            items[p].hide();
                        }
                        if (items[p].btnType == 2) {
                            if (!items[p].isHidden && next){
                            	if(items[p].itemId != 'btnReset'){
                            		items[p].show();
                            	}else{
                            		next = false;
                            	}
                            }else{
                            	next = true;
                            }
                        }
                    }
                    me.onClickEdit();
                }
            }

        }, {
            xtype : 'tbseparator',
            hidden : me.is_btn_edit_hide,
            itemId : "tbEdit",
            btnType : 1
        }, {
            xtype : 'button',
            text : '删除',
            iconCls : 'delete',
            btnType : 1,
            itemId : "btnDel",
            isHidden : me.is_btn_del_hide,
            hidden : me.is_btn_del_hide,
            listeners : {
                'click' : function() {
                    if (me.onClickDelBefore()) {
                        Ext.MessageBox.confirm(StrConstants.HINT, StrConstants.HINT_DEL_CONFIRM, function(btn) {
                            if (btn == 'yes') {
                                me.onClickDel();
                            }

                        });
                    }

                }
            }
        }, {
            xtype : 'button',
            text : '确定',
            iconCls : 'accept',
            btnType : 2,
            itemId : "btnSave",
            hidden : true,
            isHidden : me.is_btn_save_hide,
            listeners : {
                'click' : function() {
                    me.onClickSave();
                }
            }
        }, {
            xtype : 'tbseparator',
            hidden : true,
            isHidden : me.is_btn_save_hide,
            itemId : "tbSave",
            btnType : 2
        }, {
            xtype : 'button',
            text : '重置',
            iconCls : 'arrow_rotate_anticlockwise',
            btnType : 2,
            itemId : "btnReset",
            hidden : true,
            isHidden : me.is_btn_reset_hide,
            listeners : {
                'click' : function() {
                    me.onClickReset();
                }
            }
        }, {
            xtype : 'tbseparator',
            hidden : true,
            isHidden : me.is_btn_reset_hide,
            itemId : "tbReset",
            btnType : 2
        }, {
            xtype : 'button',
            text : '取消',
            iconCls : 'arrow_undo',
            btnType : 2,
            itemId : "btnCancel",
            hidden : true,
            isHidden : me.is_btn_can_hide,
            listeners : {
                'click' : function() {
                	Ext.MessageBox.confirm(StrConstants.HINT,StrConstants.HINT_CANCEL_CONFIRM, function(btn) {
		                if (btn == 'yes') {
		                    var layout = me.getLayout();
		                    var items = layout.getLayoutItems();
		                    for (var p in items) {
		                        if (items[p].btnType == 1) {
		                            if (!items[p].isHidden)
		                                items[p].show();
		                        }
		                        if (items[p].btnType == 2) {
		                            items[p].hide();
		                        }
		                    }
		                    me.onClickCancel();
                    	}
		            });
                }
            }
        }

        ],
        me.callParent(arguments);
    }
});

/**
 * 调用示例
 */

/*
 * var fBar = Ext.create('ZTEsoft.component.AddEditDeleteOkCancelToolbar', {
 * renderTo : document.body, width : 500, is_btn_add_hide : false,
 * is_btn_edit_hide : false, is_btn_del_hide : true, is_btn_save_hide : false,
 * onClickAdd : function() { alert("添加按钮的响应函数"); }, onClickEdit : function() {
 * alert("修改按钮的响应函数"); }, onClickDelBefore : function() { alert("删除按钮的响应函数"); },
 * onClickSave : function() { alert("保存按钮的响应函数"); }, onClickCancel : function() {
 * alert("取消按钮的响应函数"); }, onClickDel : function() { alert("删除后的回调函数"); } });
 * 
 * 
 * var formPanel = Ext.create('Ext.form.Panel', { region : 'south', id :
 * 'detailForm', frame : true, title : '详情', width : '100%', fbar : fBar });
 */
