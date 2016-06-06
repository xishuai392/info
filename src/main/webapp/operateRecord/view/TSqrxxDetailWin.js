/**
 * @description 新增修改共用弹出窗口，嵌入一个EditForm，实现对TSqrxx的新增、修改
 * @author codeCreater
 * @date 2014年11月20日
 */

Ext.define('component.operateRecord.view.TSqrxxDetailWin', {
    extend : 'ZTEsoft.window.PopWindow',
//    formPanel : null,
//    tsqrxxfjStore : null,
//    imagePanel : null,
    config : {
        formPanel : null,
        tsqrxxfjStore : null,
        imagePanel : null,
        action : Ext.create("component.operateRecord.action.TSqrxxAction")
    },
    closeAction : 'hide',
    
    /**
     * 构造函数，用于初始化界面
     * 
     * @param {}
     *            config
     */
    constructor : function(config) {
    	console.log("TSqrxxDetailWin constructor");
        config = config || {};

        var me = this;

        // TODO 设置额外的参数
        me.pkFiledId = config.pkFiledId;

        me.winType = config.winType;

        if(null==me.formPanel){
        	// 创建表单
        	me.formPanel = me.createFormPanel();
        }
        
        if(null==me.getTsqrxxfjStore()){
        	//图片store
        	me.setTsqrxxfjStore( me.createImageStore());
        	console.log("TSqrxxDetailWin.tsqrxxfjStore is null");
        }

        if(null==me.imagePanel){
        	// 创建附件展示
        	me.imagePanel = me.createImagePanel();
        	console.log("TSqrxxDetailWin.imagePanel is null");
        }
        

        if (me.winType == WEBConstants.ACTIONTYPE.VIEW) {
            config.title = '详情';
        }
        if (me.winType == WEBConstants.ACTIONTYPE.NEW) {
            config.title = '新增';
        }
        if (me.winType == WEBConstants.ACTIONTYPE.EDIT) {
            config.title = '编辑';
        }
        Ext.applyIf(config, {
            width : 600,
            height : 400,
            layout : 'border',
            maximizable : true,
            items : [me.formPanel, me.imagePanel],
            resizable : true
        });
        this.callParent([config]);
    },
    // 初始化界面
    initComponent : function() {
    	console.log("TSqrxxDetailWin initComponent");
        var me = this;

        // 编辑
        if (me.winType == WEBConstants.ACTIONTYPE.EDIT) {

            // TODO 隐藏或显示某些字段
            // me.formPanel.getForm().findField("createdDate").setVisible(false);
            me.getAction().qryRecord(me.pkFiledId, function(result) {
                var model = Ext.create("component.operateRecord.model.TSqrxxModel");
                model.data = result;
                me.formPanel.getForm().loadRecord(model);
            });
        }
        // 新增
        if (me.winType == WEBConstants.ACTIONTYPE.NEW) {

            // TODO 隐藏或显示某些字段，或设定默认值等
            // me.formPanel.getForm().findField("createdDate").setVisible(false);
        }
        // 详情
        if (me.winType == WEBConstants.ACTIONTYPE.VIEW) {
            me.getAction().qryRecord(me.pkFiledId, function(result) {
                var model = Ext.create("component.operateRecord.model.TSqrxxModel");
                model.data = result;
                me.formPanel.getForm().loadRecord(model);
                me.formPanel.disableFields();
                // 获取附件信息
//                var config = {
//                    url : '/operateRecord/tsqrxx/sqrxxDetail.do',
//                    params : {
//                        id : model.data.id
//                    },
//                    callback : function(detailData) {
//                        // for(var i=0; i<detailData.length; i++){
//                        // alert(i+"="+detailData[i]['mc']);
//                        // }
//                    }
//                };
//                ExtUtils.doAjax(config);
            });
            
            me.getTsqrxxfjStore().getProxy().extraParams = {
	            // TODO 自定义业务条件：带业务条件查询
	            sqrId : me.pkFiledId
	        };
	        
	         me.getTsqrxxfjStore().load();
        }
        this.callParent();
    },

    // 创建编辑表单
    createFormPanel : function() {
        var me = this;
        var formPanel = Ext.create('ZTEsoft.form.EditForm', {
            itemId : 'editForm',
            region : 'north',
            columnNum : 2,
            labelWidth:100,
            items : [{
                fieldLabel : "id",
                xtype : "textfield",
                hidden : true,
                name : "id"
            },{
                fieldLabel : "姓名",
                xtype : "textfield",
                name : "xm"
            }, {
                fieldLabel : "证件号",
                xtype : "textfield",
                name : "zjh"
            }, {
                fieldLabel : "证件类型",
                xtype : "combo",
                name : "zjlx",
                displayField : 'text',
                valueField : 'value',
                editable : false,
                store : new Ext.data.ArrayStore({
                    fields : ['value', 'text'],
                    data : [['10', '身份证'],['30', '军官证'], ['20', '其他']]
                })
            }, {
                fieldLabel : "查询类型",
                xtype : "combo",
                name : "cxsqrlx",
                displayField : 'text',
                valueField : 'value',
                editable : false,
                store : new Ext.data.ArrayStore({
                    fields : ['value', 'text'],
                    data : [['10', '律师'], ['20', '党政军机关'], ['30', '司法机关'], ['40', '企事业单位'], ['50', '个人'], ['60', '人民团体'], ['70', '其他']]
                })
            }, {
                fieldLabel : "日期",
                xtype : "textfield",
                name : "cxrq"
            }, {
                fieldLabel : "查询类型",
                xtype : "combo",
                name : "cxbs",
                displayField : 'text',
                valueField : 'value',
                store : new Ext.data.ArrayStore({
                    fields : ['value', 'text'],
                    data : [['10', '终端查询'], ['20', '窗口查询']]
                })
            }, {
                fieldLabel : "cxrdw",
                xtype : "textfield",
                hidden : true,
                name : "cxrdw"
            }, {
                fieldLabel : "cxsy",
                xtype : "textfield",
                hidden : true,
                name : "cxsy"
            }, {
                fieldLabel : "操作单位",
                xtype : "textfield",
                name : "czdwmc"
            }, {
                fieldLabel : "操作人",
                xtype : "textfield",
                name : "czrmc"
            }, {
	            fieldLabel : "申请人流水号",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "lsh"
        	}]
        });
        return formPanel;
    },

    // 确定按钮回调函数，在此处理新增、修改操作
    okHandler : function() {
        var me = this;
        if (!me.formPanel.getForm().isValid()) {
            return;
        }
        var params = me.formPanel.getForm().getValues();
        // TODO 设置或清除不传递到后台的值
        // delete params.createdDate;
        // params.xxxx = xxxx;

        // 新增
        if (me.winType == WEBConstants.ACTIONTYPE.NEW) {

            me.getAction().addRecord(params, function(result) {
                // 再回调父组件（Grid）的响应函数，用于更新父组件的记录
                me.callback(result);
                me.close();
            });
        }
        // 修改
        if (me.winType == WEBConstants.ACTIONTYPE.EDIT) {
            params.userId = me.pkFiledId;
            me.getAction().modRecord(params, function(result) {
                // 再回调父组件（Grid）的响应函数，用于更新父组件的记录
                me.callback(result);
                me.close();
            });
        }

        // 详情
        if (me.winType == WEBConstants.ACTIONTYPE.VIEW) {
            me.close();
        }

    },
    
    createImageStore : function(){
    	var tsqrxxfjStore = Ext.create('component.information.store.TsqrxxfjStore');
    	return tsqrxxfjStore;
    },

    // 展示图片
    createImagePanel : function() {
        var me = this;
        
        var imagePanel = Ext.create('Ext.Panel', {
            id : 'images-view_detail',
            region : 'center',
            layout : 'fit',
            frame : false,
            tbar : [{
                text : '刷新',
                iconCls : 'arrow_refresh',
                handler : function() {
                    Ext.getCmp('scanImagesView_detail').getStore().load();
                }
            },'->','<span style="color:red">提示：双击可以打开原始图片.</span>'],
            items : Ext.create('Ext.view.View', {
	            id : 'scanImagesView_detail',
	            store : me.tsqrxxfjStore,
	            tpl : ['<tpl for=".">', '<div class="thumb-wrap" id="{id}_detail_div">', '<div class="thumb"><img src="',ctx+'/scanImages{dz}" id="{id}_detail_img" title="{mc}"></div>',
	                '<div style="padding-left: 3px;"><span class="x-editable">{mc}</span></div>', '</div>', '</tpl>', '<div class="x-clear"></div>'],
	            multiSelect : true,
	            height : 310,
	            autoScroll : true,
	            trackOver : false,
	            overItemCls : 'x-item-over',
	            itemSelector : 'div.thumb-wrap',
	            emptyText : '没有找到相关的扫描图片...',
	            plugins : [Ext.create('Ext.ux.DataView.DragSelector', {}), Ext.create('Ext.ux.DataView.LabelEditor', {
	                    dataIndex : 'mc',
	                    grow : true,
	                    selectOnFocus : false,
	                    listeners :{
	                    	beforestartedit : function(){
	                    		return false;
	                    	}
	                    }
	                    
	                })],
	            /**
	             * prepareData: function(data) { Ext.apply(data, { mc:
	             * Ext.util.Format.ellipsis(data.mc, 15), id:
	             * Ext.util.Format.fileSize(data.id) }); return data; },
	             */
	            listeners : {
	                selectionchange : function(dv, nodes) {
	
//	                    var l = nodes.length, s = l !== 1 ? 's' : '';
	                    // console.log(l);
	                    // this.up('panel').setTitle('Simple DataView (' + l + '
	                    // item' + s + ' selected)');
	                },
	                itemdblclick : function(dv, record, item, index, e, eOpts) {
	                    console.log('dataview dbclick');
	                    // console.log(record);
	                    // console.log(item);
	                    var id = record.data.id;
	
	                    window.open(Ext.getDom(id + '_detail_img').src);
	
	                }
	            }
            })
        });
        return imagePanel;
    },
    
    //加载数据
    loadData : function(){
    	var me = this;
	    me.getAction().qryRecord(me.pkFiledId, function(result) {
            var model = Ext.create("component.operateRecord.model.TSqrxxModel");
            model.data = result;
            me.formPanel.getForm().loadRecord(model);
            me.formPanel.disableFields();
        });
        
        me.tsqrxxfjStore.getProxy().extraParams = {
            // TODO 自定义业务条件：带业务条件查询
            sqrId : me.pkFiledId
        };
        
        me.tsqrxxfjStore.load();
    }

});