/**
 * T_BCXRXX管理<br>
 * 布局方式：上（north，查询Form）、中（center，带分页数据Grid）、下（south，操作Form）
 * 
 * @author codeCreater
 */
Ext.require(['Ext.selection.CheckboxModel']);
Ext.onReady(function() {
    var thizStore, thizGrid, thizDetailForm, thizSearchForm;
    var actionType = WEBConstants.ACTIONTYPE.VIEW;// 动作标记
    var thizAction = Ext.create("component.information.action.TBcxrxxAction");

    // 数据源
    thizStore = Ext.create('component.information.store.TBcxrxxStore', {

        // 定义分页大小
        pageSize : WEBConstants.DEFAULT_PAGE_SIZE,
        listeners : {
            // 载入的时候默认选中第一条；如果没有任何记录，则处理按钮灰化
            "load" : function(thiz, records) {
//                if (Ext.isEmpty(records)) {
//                    var items = thizGrid.getSelectedItems();
//                    thizGrid.getSelectionModel().fireEvent('selectionchange', null, items);
//                } else {
//                    thizGrid.select(0);
//                }
            }
        }
    });

    // 查询条件框
    thizSearchForm = Ext.create("ZTEsoft.form.SearchForm", {
        region : "north",
        store : thizStore,
        items : [
	      	{
	            fieldLabel : "id",
	            xtype : "textfield",
	            hidden : true,
	            name : "id"
        	},
        	{
	            fieldLabel : "查询人流水号",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "sqrlsh"
        	},
        	{
	            fieldLabel : "查询人姓名",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "sqrXm"
        	},
        	{
	            fieldLabel : "被查询人流水号",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "lsh"
        	},
	      	{
	            fieldLabel : "被查询人姓名",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "xm"
        	},
        	{
	            fieldLabel : "被查询人证件号",
	            xtype : "textfield",
	            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
	            name : "zjh"
        	},
        	{
	            fieldLabel : "查询起始日期",
	            xtype : "datefield",
	            format : 'Y-m-d',
	            value : new Date(),
	            afterSubTpl : WEBConstants.REQUIRED,
	            editable : false,
	            name : "startDate"
	        }, {
	            fieldLabel : "查询结束日期",
	            xtype : "datefield",
	            format : 'Y-m-d',
	            value : new Date(),
	            vtype : "compare",
	            target : 'startDate',
	            editable : false,
	            name : "endDate"
	        },
	        {
	            fieldLabel : "查询标识",
	            xtype : "combo",
	            name : "sqrcxbs",
	            displayField : 'text',
	            valueField : 'value',
	            value : '',
	            editable : false,
	            store : new Ext.data.ArrayStore({
	                fields : ['value', 'text'],
	                data : [['', '全部'], ['10', '终端'], ['20', 'PC端'], ['30', '网上查询']]//10：终端，20：pc端,30:网上查询
	            })
        	},
	        {
	            fieldLabel : "是否作废",
	            xtype : "combo",
	            name : "sfzf",
	            displayField : 'text',
	            valueField : 'value',
	            value : '',
	            editable : false,
	            store : new Ext.data.ArrayStore({
	                fields : ['value', 'text'],
	                data : [['', '全部'], ['1', '是'], ['0', '否']]
	            })
        	},
	      	{
	            fieldLabel : "cxcs",
	            xtype : "textfield",
	            hidden : true,
	            name : "cxcs"
        	}	       
        ]
    });

    //创建多选框  
    var selModel = Ext.create('Ext.selection.CheckboxModel', {
        checkOnly: true,
        mode: 'MULTI'
    });
    
    //真正执行远程更新状态
    var doUpdateState = function(isDisabled, zfly){
    	Ext.Msg.show({
            title : '请稍等',
            msg : '正在处理,请稍等...',
            wait : true
        });
        
        var record = thizGrid.getSelectionModel().getSelection(); 
    	var ids = "";   
        for(var i = 0; i < record.length; i++){   
            ids += record[i].get("id");
            if(i<record.length-1){   
                ids = ids + ",";   
            }   
        }
    	var params = {
    		//被查询人主键，待作废记录
			ids : ids,
			isDisabled : isDisabled,
			zfly : zfly//作废理由
    	};
    	var config = {
    		url : 'information/tbcxrxx/updateRecordState.do',
            params : params,
            timeout : 1200000, // 超时：20分钟
            callback : function(result){
            	ExtUtils.tip("提示","操作成功...");
            	//重新查询一次
            	thizGrid.getStore().load();
            }
        };
        ExtUtils.doAjax(config);
    	
    }
    
    //作废记录
    var disabledFn = function(btn, thizText){
    	if('ok'==btn){
			doUpdateState(true,thizText);
    	}
    };
    
    //生效记录
    var enabledFn = function(btn) {
        if (btn == 'yes') {
            doUpdateState(false,null);
        }
    };
    
             
    // 记录表格
    thizGrid = Ext.create('ZTEsoft.grid.Panel', {
        region : "center",
        title : "人口信息查询操作列表",
        store : thizStore,
        selModel: selModel,
        disableSelection: false,
        isPage : true,
        tbar : [
        	{
		        text: '作废记录', 
		        icon : ctx + '/common/images/icons/cog_delete.png',
		        handler: function(){
		        	var record = thizGrid.getSelectionModel().getSelection();   
                    if(record.length==0){  
                    	ExtUtils.tip("提示","请先选择您要操作的记录...");
                        return;  
                    }else{  
                    	Ext.MessageBox.prompt('作废记录', '请输入作废理由:', disabledFn);
                        
                    }  
		        } 
		    },{
		        text: '生效记录', 
		        icon : ctx + '/common/images/icons/cog_go.png',
		        handler: function(){
		        	var record = thizGrid.getSelectionModel().getSelection();   
                    if(record.length==0){  
                    	ExtUtils.tip("提示","请先选择您要操作的记录...");
                        return;  
                    }else{  
                    	Ext.MessageBox.confirm('生效记录', "您确定要把选中的记录设置为生效状态吗？", enabledFn);
                    }  
		        } 
		    }
        ],
        columns : [
	        
	        {
	        	text : "申请人姓名",
	            dataIndex : "sqrXm",
	            flex : 1
	        },
	        {
	        	text : "申请人证件号",
	            dataIndex : "sqrzjh",
	            flex : 1
	        },
	        {
	        	text : "被查询人流水号",
	            dataIndex : "lsh",
	            flex : 1
	        },
	        {
	        	text : "被查询人姓名",
	            dataIndex : "xm",
	            flex : 1
	        },
	        {
	        	text : "被查询人证件号",
	            dataIndex : "zjh",
	            flex : 1
	        },
	        {
	        	text : "查询日期",
	            dataIndex : "bcxrq",
	            renderer : function(value) {
	            	return value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8)+" "+value.substring(8,10)+":"+value.substring(10,12)+":"+value.substring(12,14);
	            },
	            flex : 1
	        },
	        {
	            text : "是否作废",//是否作废（1：是，0：否）默认为“否”
	            dataIndex : "sfzf",
	            renderer : function(value) {
	            	if('1'==value){
	            		return '<span style="color:red">是</span>';
	            	}else{
	            		return '否';
	            	}
	            },
	            flex : 0.5
	        },
	        {
	            text : "作废理由",
	            dataIndex : "zfly",
	            flex : 1
	        },
	        {
	            text : "是否打印",//是否打印（1：是，0：否）默认为“否”
	            dataIndex : "sfdy",
	            renderer : function(value) {
	            	if('1'==value){
	            		return '是';
	            	}else{
	            		return '否';
	            	}
	            },
	            flex : 0.5
	        },
	        
	        
	        {
	            text : "人口类型",//人口类型（1：户籍人口，2：暂住人口）
	            dataIndex : "rklx",
	            renderer : function(value) {
	            	if('1'==value){
	            		return '户籍人口';
	            	}else{
	            		return '暂住人口';
	            	}
	            },
	            flex : 0.5
	        },
	        {
	            text : "查询标识",//10：终端，20：pc端,30:网上查询
	            dataIndex : "sqrcxbs",
	            renderer : function(value) {
	            	if('10'==value){
	            		return '终端';
	            	}else if('20'==value){
	            		return 'PC端';
	            	}{
	            		return '网上查询';
	            	}
	            },
	            flex : 0.5
	        },
	        {
	        	text : "申请人流水号",
	            dataIndex : "sqrlsh",
	            hidden : true,
	            flex : 1
	        },
	        {
	            text : "修改日期",
	            dataIndex : "xgrq",
	            hidden : true,
	            renderer : function(value) {
	            	if(null!=value&&value.length>0){
	            		return value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8);
	            	}else{
	            		return "";
	            	}
	            	
	            },
	            flex : 1
	        },
	      	{
	            text : "查询次数",
	            dataIndex : "cxcs",
	            hidden : true,
	            flex : 1
        	},
        	{
	            text : "id",
	            dataIndex : "id",
	            hidden : true,
	            flex : 1
	        },
	        {
	        	text : "申请人ID",
	            dataIndex : "sqrId",
	            hidden : true,
	            flex : 1
	        },
	        {
	            text : "zjlx",
	            dataIndex : "zjlx",
	            hidden : true,
	            flex : 1
	        },
	        {
	            text : "sfzzp",
	            hidden : true,
	            dataIndex : "sfzzp",
	            flex : 1
	        }
		]
    });



    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [thizSearchForm, thizGrid]
    });

    // 开始查询
    //thizGrid.getStore().load();

});
