/**
 * 人口信息查询首页
 */
 
 
Ext.onReady(function() {
    var sqrxxPanel,zjPanel,ssxzlPanel,bcxrxxPanel,bcxrStore,bcxrGrid,changzhuWin,zanzhuWin,infoMainPanel;
    var isClickFjlxBtn1 = false;
    var isClickFjlxBtn2 = false;
    var isClickFjlxBtn3 = false;
    
    //暂口信息查询外部第三方接口的URL
    var baseUrl = Ext.get("thirdPartyZzrkUrl").getValue();
    
    //需要的附件类型组合，默认是律师、、20160316需求
    var needFjlxStr = "1,2,3";
    var LODOP;
    
    //被查询人信息主键——统计打印次数需要
    var bcxrxxId;
    //图片的store
    var imageStore;
    
    var preHtml = '<!DOCTYPE html><html><head><meta charset="UTF-8"><title>人口信息打印</title><style type="text/css">html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,input	{	margin: 0;	padding: 0;	border: 0;	font-weight: inherit;	font-style: inherit;	font-size: 100%;	font-family: Arial, Microsoft Yahei;	/**vertical-align:baseline;*/}body {	line-height: 1;	font-size: 12px;}ol,ul {	list-style: none;}.color_red {	color: #ff0900;}.color_gray {	color: #9b9b9b;}.color_bule {	color: #015a9f;}.clear {	clear: both;}.font18 {	font-size: 18px;}.font14 {	font-size: 14px;}* {	font-size: 12px !important;}</style><link rel="stylesheet" type="text/css"	href="'+webRoot+'common/css/info.css"></head><body>';
    
    //打开下载界面
    var downLoadFn = function(btn){
 		if (btn == 'yes') {
 			window.open(ctx + '/thirdplugins/DoccameraOcx.rar');
 		}
 	};
 	
 	//先校验高拍仪插件有没有安装
 	var checkCaptrue = function(){
 		try{
    		//alert(typeof captrue);
	 		if( typeof captrue == "object"){
	 			
	 		}else{
	 			Ext.MessageBox.confirm("提示", "您还未安装扫描仪驱动！点击确认下载驱动包后执行安装。", downLoadFn);
	 			return false;
	 		}
	 		var stopResult = captrue.bStopPlay();
	 	}catch(e){
	 		Ext.MessageBox.confirm("提示", "您还未安装扫描仪驱动！点击确认下载驱动包后执行安装。", downLoadFn);
	 		return false;
	 	}
 		return true;
 	}
 	
    var cardNav = function (incr) { 
    	
    	console.log(infoMainPanel.getLayout().getPrev());
    	console.log(infoMainPanel.getLayout().getNext());
    	var layout = infoMainPanel.getLayout();
	    //layout[incr]();
	    Ext.getCmp('cardPrev').setDisabled(!layout.getPrev());
	    Ext.getCmp('cardNext').setDisabled(!layout.getNext());
    
	    var thizId = layout.activeItem.id.split('card')[1]; 
	    thizId = parseInt(thizId);
	    var nextId = parseInt(thizId, 10) + incr; 
	    
	    switch(thizId){
	    	case 0 : 
	    		//填写申请人信息
	    		console.log('当前是填写申请人信息');
	    		if(sqrxxPanel.getForm().isValid()){
	    			ExtUtils.info('通过表单校验');
	    			Ext.getCmp('cardPrev').setDisabled(false);
	   				Ext.getCmp('cardNext').setDisabled(false);
	   				layout.setActiveItem(nextId);
	    		}
	    		break;
	    	case 1 :
	    		console.log('当前是扫描身份证');
	    		//扫描身份证
	    		if(incr<0){
	    			//返回到填写申请人信息
	    			Ext.getCmp('cardPrev').setDisabled(true);
	   				Ext.getCmp('cardNext').setDisabled(false);
	    		}else{
	    			
	    		}
	    		layout.setActiveItem(nextId);
	    		break;
	    		
	    }
	    
	    console.log("thizId:"+thizId);
	    console.log("incr:"+incr);
	    
	    console.log("parseInt(thizId, 10):"+parseInt(thizId, 10));
	    console.log("nextId:"+nextId);
	     
	    //Ext.getCmp('cardPrev').setDisabled(next === 0); 
	    //Ext.getCmp('cardNext').setDisabled(next === 2); 
	}; 

	Ext.require([
	    'Ext.data.*',
	    'Ext.util.*',
	    'Ext.view.View',
	    'Ext.ux.DataView.DragSelector',
	    'Ext.ux.DataView.LabelEditor'
	]);

	//
	var createPrintPage = function (html) {
		LODOP = getLodop(document.getElementById('LODOP_OB'),
				document.getElementById('LODOP_EM'));
		LODOP.SET_PREVIEW_WINDOW(1,3,1,0,0, "预览查看.开始打印");
		
		LODOP.PRINT_INIT("人口信息打印");
		LODOP.SET_PRINT_STYLE("FontSize", 12);
		LODOP.SET_PRINT_STYLE("Bold", 1);
		LODOP.SET_PRINT_PAGESIZE(1,0,0,"A4") ; //A4纸张纵向打印
		LODOP.ADD_PRINT_HTM("0%", "0%", "100%", "100%", html);
		LODOP.SET_SHOW_MODE("HIDE_SBUTTIN_PREVIEW",true);
		//LODOP.SET_SHOW_MODE("HIDE_QBUTTIN_PREVIEW",true);
		LODOP.SET_SHOW_MODE("HIDE_PAGE_PERCENT",true);
		LODOP.SET_SHOW_MODE("HIDE_DISBUTTIN_SETUP",true);
		LODOP.SET_SHOW_MODE("PREVIEW_NO_MINIMIZE",true);
		LODOP.SET_SHOW_MODE("HIDE_PBUTTIN_SETUP",true);
		LODOP.SET_SHOW_MODE("HIDE_VBUTTIN_SETUP",true);
		LODOP.SET_SHOW_MODE("HIDE_ABUTTIN_SETUP",true);
		LODOP.SET_SHOW_MODE("HIDE_RBUTTIN_SETUP",true);
	};
	
	//申请人输入框统一宽度
	var sqrxxPanelFieldWidth = 350;
	
	//弹出窗口宽高
	var winHeight = (parseInt(Ext.getBody().getHeight())*0.8);
	
	
	
	
    // 1、申请人信息填写
    sqrxxPanel = Ext.create("ZTEsoft.form.SearchForm", {
    	id : 'card0',
        layout : 'column',
        hiddenBtns : true,
        frame : true,
        title : '填写申请人信息',
        defaults : {
            labelAlign : 'right',
            labelWidth : 100,
            //xtype : 'textfield',
            style : 'margin-left:5px;margin-top:2px;margin-bottom:2px;'
        },
        items : [
        {
            fieldLabel : "证件号",
            xtype : "textfield",
            //vtype : 'identityCard',
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            width: sqrxxPanelFieldWidth,
            name : "zjh",
            listeners:{
		         //scope: yourScope,
		         'change': function(thiz,newValue ,oldValue ,eOpts ){
            			// 申请查询人身份证号码校验
		         		if('10'==sqrxxPanel.getForm().findField('zjlx').getValue()){
		         			sqrxxPanel.getForm().findField('zjh').vtype = 'identityCard';
		         		}else{
		         			sqrxxPanel.getForm().findField('zjh').vtype = null;
		         		}
		         	
		         }
		    }
        }, {
            fieldLabel : "证件类型",
            xtype : "combo",
            name : "zjlx",
            displayField : 'text',
            valueField : 'value',
            afterSubTpl : WEBConstants.REQUIRED,
            editable : false,
            allowBlank : false,
            value : '10',
            width: sqrxxPanelFieldWidth,
            store : new Ext.data.ArrayStore({
                fields : ['value', 'text'],
                data : [['10', '身份证'],['30', '军官证'], ['20', '其他']]
            }),
            listeners:{
		         //scope: yourScope,
		         'change': function(thiz,newValue ,oldValue ,eOpts ){
		         		console.log('证件类型change');
		         		//console.log(thiz);console.log(newValue);console.log(oldValue);console.log(eOpts);
		         		//如果选择“其他”，则显示证件类型（必填），否则隐藏
		         		if('20'==newValue){
		         			Ext.getCmp('sqr_zjmc').allowBlank = false;
		         			Ext.getCmp('sqr_zjmc').show();
		         		}else{
		         			Ext.getCmp('sqr_zjmc').setValue('');
		         			Ext.getCmp('sqr_zjmc').hide();
		         			Ext.getCmp('sqr_zjmc').allowBlank = true;
		         		}
		         		
		         		// 申请查询人身份证号码校验
		         		if('10'==newValue){
		         			sqrxxPanel.getForm().findField('zjh').vtype = 'identityCard';
		         			
		         		}else{
		         			sqrxxPanel.getForm().findField('zjh').vtype = null;
		         		}
		         		
		         		var form = Ext.getCmp('card0').getForm();
		         		//form.checkValidity();
		         		form.isValid();
		         }
		    }
        },{
            fieldLabel : "姓名",
            xtype : "textfield",
            allowBlank : false,
            width: sqrxxPanelFieldWidth,
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            name : "xm"
        },{
            fieldLabel : "查询申请人类型",
            xtype : "combo",
            name : "cxsqrlx",
            displayField : 'text',
            valueField : 'value',
            editable : false,
            allowBlank : false,
            value : '10',
            width: sqrxxPanelFieldWidth,
            store : new Ext.data.ArrayStore({
                fields : ['value', 'text'],
                data : [['10', '律师'],['20', '党政军机关'],['30', '司法机关'],
                	['40', '企事业单位'],['50', '个人'], ['60', '人民团体']]
            }),
            listeners:{
		         //scope: yourScope,
		         'change': function(thiz,newValue ,oldValue ,eOpts ){
		         		//console.log(thiz);console.log(newValue);console.log(oldValue);console.log(eOpts);
		         		console.log('查询申请人类型change');
		         		//console.log(Ext.getCmp('sqr_cxrdw').getSubTplMarkup());
		         		//console.log(Ext.getCmp('sqr_cxsy').getSubTplMarkup());
		         	
		         		//除“个人”外，申请查询人单位、查询事由 必填
		         		if('50'==newValue){
		         			Ext.getCmp('sqr_cxrdw').allowBlank = true;
		         			Ext.getCmp('sqr_cxsy').allowBlank = true;
		         			Ext.getCmp('sqr_cxrdw').afterSubTpl='';
		         			Ext.getCmp('sqr_cxsy').afterSubTpl='';
		         			//申请人查询类型为个人时，查询单位这个输入项 直接隐藏掉
		         			Ext.getCmp('sqr_cxrdw').hide();
		         			Ext.getCmp('sqr_cxrdw').setValue('');
		         			
		         		}else{
		         			Ext.getCmp('sqr_cxrdw').allowBlank = false;
		         			Ext.getCmp('sqr_cxsy').allowBlank = false;
		         			Ext.getCmp('sqr_cxrdw').afterSubTpl=WEBConstants.REQUIRED;
		         			Ext.getCmp('sqr_cxsy').afterSubTpl=WEBConstants.REQUIRED;
		         			//申请人查询类型为个人时，查询单位这个输入项 直接隐藏掉
		         			Ext.getCmp('sqr_cxrdw').show();
		         			
		         		}
		         		
		         		//根据不同申请人类型，需要上传不同的附件，展示不同的按钮
		         		if('20'==newValue||'40'==newValue||'60'==newValue){
		         			//大类1
		         			needFjlxStr = "1,2";
		         			Ext.getCmp('fjlxBtn2').show();
		         			Ext.getCmp('fjlxBtn3').hide();
		         		}
		         		if('30'==newValue){
		         			//大类2
		         			needFjlxStr = "1,2";
		         			Ext.getCmp('fjlxBtn2').show();
		         			Ext.getCmp('fjlxBtn3').hide();
		         		}
		         		if('10'==newValue){
		         			//大类3
		         			needFjlxStr = "1,2,3";
		         			Ext.getCmp('fjlxBtn2').show();
		         			Ext.getCmp('fjlxBtn3').show();
		         		}
		         		
		         		if('50'==newValue){
		         			//大类4
		         			needFjlxStr = "1";
		         			Ext.getCmp('fjlxBtn2').hide();
		         			Ext.getCmp('fjlxBtn3').hide();
		         		}
		         		
		         		var form = Ext.getCmp('card0').getForm();
		         		//form.checkValidity();
		         		form.isValid();
		         }
		    }
        },{
            fieldLabel : "申请查询人单位",
            xtype : "textfield",
            id : 'sqr_cxrdw',
            width: sqrxxPanelFieldWidth,
            allowBlank : false,
            afterSubTpl : WEBConstants.REQUIRED,
            name : "cxrdw"
        },{
            fieldLabel : "查询事由",
            xtype : "textfield",
            grow      : true,
            id : 'sqr_cxsy',
            width: sqrxxPanelFieldWidth,
            allowBlank : false,
            afterSubTpl : WEBConstants.REQUIRED,
            name : "cxsy"
        },{
            fieldLabel : "证件名称",
            xtype : "textfield",
            id : 'sqr_zjmc',
            grow      : true,
            hidden : true,
            afterSubTpl : WEBConstants.REQUIRED,
            width: sqrxxPanelFieldWidth,
            name : "zjmc"
        },{
            fieldLabel : "cxbs",//查询标示  10：终端，20：pc端,30:网上查询
            xtype : "textfield",
            value : '30',
            width: sqrxxPanelFieldWidth,
            hidden : true,
            name : "cxbs"
        },{
            fieldLabel : "mainId",//申请人信息表主键
            xtype : "textfield",
            //width: 500,
            width: sqrxxPanelFieldWidth,
            hidden : true,
            name : "mainId"
        },{
            fieldLabel : "sqrlsh",//申请人流水号
            xtype : "textfield",
            width: sqrxxPanelFieldWidth,
            hidden : true,
            name : "sqrlsh"
        },{
        	xtype : 'textfield',
        	name : 'fjlx',
        	fieldLabel : "附件类型",
        	hidden : true,
        	id : 'fjlxId'
        }],
        // 重置 和下一步 按钮.
	    tbar: [{
	        text: '重置',
	        icon : ctx + '/common/images/icons/arrow_rotate_anticlockwise.png',
	        handler: function() {
	            this.up('form').getForm().reset();
	        }
	    }, {
	        text: '下一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-next',
	        formBind: true, //only enabled once the form is valid
	        handler: function() {
	            var form = this.up('form').getForm();
	            if (form.isValid()) {
	            	var params = {};
	            	Ext.apply(params,form.getValues());
	            	//this.setParams(this.store.proxy.extraParams,this.getForm().getValues());
	            	var config = {
			            url : 'information/applicantQuery.do',
			            params : params,
			            callback : function(jsonData){
			            		var uuid = jsonData.uuid;
				            	if(uuid.length==32){
				            		//ExtUtils.info('通过表单校验');
				            		sqrxxPanel.getForm().findField('mainId').setValue(uuid);//申请人主键
				            		sqrxxPanel.getForm().findField('sqrlsh').setValue(jsonData.lsh);//申请人流水号
				            		
					            	var layout = infoMainPanel.getLayout();
					            	//layout.setActiveItem(1);//下一步：证件扫描
					            	layout.setActiveItem(1);
					            	
					            	
					            	var cxsqrlx = sqrxxPanel.getForm().findField('cxsqrlx').getValue();
					            	if('50'==cxsqrlx){
					            		//“个人”类型查询时 在输入身份证查询页面直接把第一步查询申请人的身份证号码带过来
					            		if('10'==sqrxxPanel.getForm().findField('zjlx').getValue()){
					            			var zjh = sqrxxPanel.getForm().findField('zjh').getValue();
					            			bcxrxxPanel.getForm().findField('idCardNum').setValue(zjh);
					            		}
					            		
					            	}
					            	
				            	}
			            }
			        };
			        ExtUtils.doAjax(config);
	            }
	        }
	    }]

    });
    
    
    
    //文件上传
    var fileUploadForm = Ext.create('Ext.form.Panel',{
    	//fileUpload : true,  
//        layout : "column",  
//        region : 'east',
        //width : 400,
        frame : true,
        id : "fileUploadForm", 
        items : [{  
            id : 'upload',  
            name : 'upload',
            xtype: 'filefield',
            columnWidth : .7,
            //inputType : "file",
            fieldLabel : '选择图片',
            labelAlign : 'right',
            emptyText: '请选择一张照片...',
            allowBlank: false,
            frame : true,
            clear : true,
            buttonText: '浏览',
            buttonConfig: {
                icon: ctx + '/common/images/icons/image_add.png'
            },
            listeners : {
            	change : function(thiz, text , eOpts){
            		//alert(thiz.up('form').getForm().findField('upload').getValue());
            		if(''==text){
            			return ;
            		}
            		
            		var start = text.lastIndexOf('\\');
            		var sub = text.substring(start<0?0:(start+1),text.lastIndexOf('.'));
            		if(Ext.isEmpty(thiz.up('form').getForm().findField('mc').getValue())){
            			thiz.up('form').getForm().findField('mc').setValue(sub);
            		}
            		
            	}
            },
            anchor : '90%'  
        },{
        	xtype: 'textfield',
        	labelAlign : 'right',
        	fieldLabel : "扫描件名称",
        	name : 'mc',
        	allowBlank: false,
        	anchor : '90%' 
        },{
        	xtype : 'textfield',
        	name : 'sqrxxId',
        	hidden : true,
        	id : 'fileUpload_sqrxxId'
        },{
        	xtype : 'textfield',
        	name : 'fjlx',
        	fieldLabel : "附件类型",
        	hidden : true
        }],
        buttons : [
        	{
                text : '确定',
                iconCls : 'accept',
                name : 'okBtn',
                handler: function() {  
	               var form = this.up('form').getForm();  
	               //申请人信息表主键
	               var sqrxxId = sqrxxPanel.getForm().findField('mainId').getValue();
	               //附件类型
	               var fjlx = sqrxxPanel.getForm().findField('fjlx').getValue();
	               if(Ext.isEmpty(fjlx)){
	               		ExtUtils.tip("错误","请先点击按钮选择附件类型..."); 
	               		return ;
	               }
	               form.findField('sqrxxId').setValue(sqrxxId);
	               form.findField('fjlx').setValue(fjlx);
							
	               if (form.isValid()) {  
	                    form.submit({
		                   	url :  ctx+"/scan/upload.do",  
		                   	method : "POST",
		                    waitMsg: '正在上传...',  
		                    success: function(thizform, action) {  
		                    	//console.log(action.result);console.log(action);
		                    	//加载图片
				            	var thizImageModel = Ext.create("component.information.model.ImageModel");
				            	thizImageModel.data.id = action.result.id;
				            	thizImageModel.data.mc = form.findField('mc').getValue();
				            	thizImageModel.data.fjlx = action.result.fjlx;
				            	thizImageModel.data.url = ctx+'/scanImages'+action.result.dz;
				            	
								//console.log(thizImageModel);
	                    
								imageStore.add(thizImageModel);
								//imageStore.add(tmp);
				            	ExtUtils.tip("提示","扫描图片已上传服务器..."); 
				            	fileUploadForm.getForm().reset();
				            	fileUploadWindow.close();
		                    },  
			                failure : function(form, action) {  
			                    ExtUtils.tip("错误","扫描图片上传失败...");  
			                }  
	                   });  
	               }  
	           }
            }, {
                text : '取消',
                iconCls : 'arrow_undo',
                name : 'cancelBtn',
                handler : function(){
                	this.up('window').close();
                }
            }
        ]
    });
    
    //上传的窗口
    var fileUploadWindow = Ext.create('Ext.window.Window',{
    	title : '上传图片',
    	width : 400,
        height : 150,
        modal : true,
        layout : 'fit',
        closeAction : 'hide',
        items : [fileUploadForm],
        buttons : {
        	
        }
    });
 

    imageStore = Ext.create('Ext.data.Store', {
        model: 'component.information.model.ImageModel',
        proxy: {
            type: 'memory'
        }
    });
    
    //20160323 文件名自动生成
    //执行保存图片的方法，并显示在界面上
    var saveImagesFn = function(){
		if(Ext.isEmpty(sqrxxPanel.getForm().findField('fjlx').getValue())){
       		ExtUtils.tip("错误","请先点击按钮选择附件类型..."); 
       		return ;
        }
	
		Ext.Msg.show({
            title : '请稍等',
            msg : '正在扫描,请稍等...',
            wait : true
        });
			var localPath = "c:\\";
        	var picName = "JPG";
        	
        	//TODO  @惜帅  调试隐藏
        	//TODO
            //TODO
            //TODO
            //TODO
        	//先校验高拍仪插件有没有安装
			if(!checkCaptrue()){
				return false;
			};
			
        	var stopResult = captrue.bStopPlay();  	
    		var stsrtResult = captrue.bStartPlay();
    		var saveJPGResult = captrue.bSaveJPG(localPath,picName);
        	//获取图片 base64编码
        	var imageBase64Str = captrue.sGetBase64();
        	stopResult=captrue.bStopPlay();  

        	//var imageBase64Str = "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";
//		        	var imageBase64Str = "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";
        	
//		        	alert(imageBase64Str.length);
        	if((null!=imageBase64Str)&&(imageBase64Str.length>10)){
	        	var params = {
	        		//申请人信息表主键
					sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
					fileName : "",
					//附件类型
					fjlx : sqrxxPanel.getForm().findField('fjlx').getValue(),
					imageBase64Str : imageBase64Str
	        	};
	        	var config = {
            		url : 'scan/saveScanImages.do',
		            params : params,
		            timeout : 1200000, // 超时：20分钟
		            callback : function(sqrxxfjDto){
		            	//console.log(sqrxxfjDto);
		            	//加载图片
		            	var thizImageModel = Ext.create("component.information.model.ImageModel");
		            	thizImageModel.data.id = sqrxxfjDto.id;
		            	thizImageModel.data.mc = sqrxxfjDto.mc;
		            	thizImageModel.data.fjlx = sqrxxfjDto.fjlx;
		            	thizImageModel.data.url = ctx+'/scanImages'+sqrxxfjDto.dz;
		            	
						//console.log(thizImageModel);
                
						imageStore.add(thizImageModel);
						//imageStore.add(tmp);
		            	ExtUtils.tip("提示","扫描图片已上传服务器...");
		            	
		            	// 去掉鼠标移到图片上的预览功能
					
		            }
		        };
		        ExtUtils.doAjax(config);
        	}else{
        		Ext.Msg.hide();
        		ExtUtils.tip("提示","请确认您已正确连接扫描仪...");
        	}
    };
    
    
    //20160323 现在改成不需要输入文件名——本方法废弃
    //执行保存图片的方法，并显示在界面上
    var saveImagesFn_Deprecated = function(btn, thizText){
    	//console.log(btn);console.log(thizText);
    	if('ok'==btn){
    			if(Ext.isEmpty(sqrxxPanel.getForm().findField('fjlx').getValue())){
               		ExtUtils.tip("错误","请先点击按钮选择附件类型..."); 
               		return ;
	            }
    		
				Ext.Msg.show({
		            title : '请稍等',
		            msg : '正在扫描,请稍等...',
		            wait : true
		        });
    				var localPath = "c:\\";
		        	var picName = "JPG";
		        	
		        	//TODO  @惜帅  调试隐藏
		        	//TODO
	                //TODO
	                //TODO
	                //TODO
		        	//先校验高拍仪插件有没有安装
 					if(!checkCaptrue()){
 						return false;
 					};
 					
		        	var stopResult = captrue.bStopPlay();  	
	        		var stsrtResult = captrue.bStartPlay();
	        		var saveJPGResult = captrue.bSaveJPG(localPath,picName);
		        	//获取图片 base64编码
		        	var imageBase64Str = captrue.sGetBase64();
		        	stopResult=captrue.bStopPlay();  

		        	//var imageBase64Str = "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";
//		        	var imageBase64Str = "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";
		        	
//		        	alert(imageBase64Str.length);
		        	if((null!=imageBase64Str)&&(imageBase64Str.length>10)){
			        	var params = {
			        		//申请人信息表主键
							sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
							fileName : thizText,
							//附件类型
							fjlx : sqrxxPanel.getForm().findField('fjlx').getValue(),
							imageBase64Str : imageBase64Str
			        	};
			        	var config = {
		            		url : 'scan/saveScanImages.do',
				            params : params,
				            timeout : 1200000, // 超时：20分钟
				            callback : function(sqrxxfjDto){
				            	//console.log(sqrxxfjDto);
				            	//加载图片
				            	var thizImageModel = Ext.create("component.information.model.ImageModel");
				            	thizImageModel.data.id = sqrxxfjDto.id;
				            	thizImageModel.data.mc = sqrxxfjDto.mc;
				            	thizImageModel.data.fjlx = sqrxxfjDto.fjlx;
				            	thizImageModel.data.url = ctx+'/scanImages'+sqrxxfjDto.dz;
				            	/**
				            		{
								    "id"   : sqrxxfjDto.id,
								    "mc" : sqrxxfjDto.mc,
								    //"url" : "http://localhost:8080/info/scanImages/201510/26/988e7516761f4115bb39b6702eb8fe55.jpg"
								    "url": ctx+'/scanImages/'+sqrxxfjDto.dz
								});
								**/
				            	
								//console.log(thizImageModel);
	                    
								imageStore.add(thizImageModel);
								//imageStore.add(tmp);
				            	ExtUtils.tip("提示","扫描图片已上传服务器...");
				            	
				            	// 去掉鼠标移到图片上的预览功能
				            	/**
					            $("#"+sqrxxfjDto.id+"_img").hover(function(e){
									$("body").append('<p id="bigimage"><img src="'+ this.src + '" alt="" /></p>');
							        $(this).find('img').stop().fadeTo('slow',0.5);		
									widthJudge(e);
								    $("#bigimage").fadeIn('fast');
								},function(){
								    $(this).find('img').stop().fadeTo('slow',1);
									$("#bigimage").remove();
							    });	
								
								$("#"+sqrxxfjDto.id+"_img").mousemove(function(e){
									widthJudge(e);
								});	
								*/
							
				            }
				        };
				        ExtUtils.doAjax(config);
		        	}else{
		        		Ext.Msg.hide();
		        		ExtUtils.tip("提示","请确认您已正确连接扫描仪...");
		        	}
	        		/**
	        		var sqrxxId = sqrxxPanel.getForm().findField('mainId').getValue();
	        		console.log(sqrxxId);
	        		
	        		Ext.get('upload').dom.value=localPath + picName+".jpg";
	        		console.log(fileUploadForm.getForm().findField('upload').getValue());
	        		fileUploadForm.getForm().findField('sqrxxId').setValue(sqrxxId);
	        		if (fileUploadForm.getForm().isValid()) {
		        		fileUploadForm.getForm().submit({
			                url :  ctx+"/scan/upload.do",  
			                method : "POST",  
			                success : function(form, action) {  
			                	console.log("form:"+form);
			                	console.log("action:"+action);
			                    alert("success");  
			                },  
			                failure : function(form, action) {  
			                    alert("failure");  
			                }  
			            });  
	        		}
		        	//var uploadPicResult = captrue.bUpLoadImage(localPath+picName,serverName, serverPort,"/scan/upload.do?sqrxxId="+sqrxxId);
		        	//console.log("uploadPicResult:"+uploadPicResult);
		        	*/
    	}
    };
    
    var x = 22;
	var y = 20;
						
    var widthJudge = function (e){
		var marginRight = document.documentElement.clientWidth - e.pageX; 
		var imageWidth = $("#bigimage").width()||400;
		//alert(document.documentElement.clientWidth +"   "+e.pageX+"  "+marginRight+"  "+imageWidth);
		if(marginRight < imageWidth)
		{
		    x = imageWidth + 22;
			$("#bigimage").css({top:(e.pageY - y ) + 'px',left:(e.pageX - x ) + 'px'});	
		}else{
		    x = 22;
		    $("#bigimage").css({top:(e.pageY - y ) + 'px',left:(e.pageX + x ) + 'px'});
        };	
	};
    
    //2、证件扫描
    zjPanel = Ext.create('Ext.Panel', { 
	    title: '证件、介绍信及相关资料扫描', 
	    id : 'card1', 
	    frame : true,
	    layout : 'border',
	    items: [{ 
	    	xtype : 'panel',
	    	region : 'center',
	    	layout : 'border',
	    	tbar: ['<span style="color:red">请先点击按钮选择附件类型（红色字体为选择状态） -> </span>',
	    		'-',{
			        text: '工作证/身份证', 
			        id : "fjlxBtn1",
			        scale   : 'large',
			        icon: ctx + '/common/images/Folder_Images_32px.png',
			        handler: function(){
			        	//工作证/身份证
			        	if(!isClickFjlxBtn1){
			        		//还没有选中
			        		sqrxxPanel.getForm().findField('fjlx').setValue('1');
			        		Ext.getCmp('fjlxBtn1').addCls('index-redFlag-btn-custom');
			        		isClickFjlxBtn1 = true;
			        		Ext.getCmp('fjlxBtn2').removeCls('index-redFlag-btn-custom');
			        		Ext.getCmp('fjlxBtn3').removeCls('index-redFlag-btn-custom');
			        	}else{
			        		//已经选中过了，取消
			        		sqrxxPanel.getForm().findField('fjlx').setValue('');
			        		Ext.getCmp('fjlxBtn1').removeCls('index-redFlag-btn-custom');
			        		isClickFjlxBtn1 = false;
			        	}
			        } 
			    },'-',{
			    	text: '介绍信', 
			    	id : "fjlxBtn2",
			    	hidden : false,
			    	scale   : 'large',
			    	icon: ctx + '/common/images/Folder_Images_32px.png',
			    	handler: function(){
			        	//介绍信
			    		
			    		if(!isClickFjlxBtn2){
			        		//还没有选中
			    			sqrxxPanel.getForm().findField('fjlx').setValue('2');
			        		Ext.getCmp('fjlxBtn2').addCls('index-redFlag-btn-custom');
			        		isClickFjlxBtn2 = true;
			        		Ext.getCmp('fjlxBtn1').removeCls('index-redFlag-btn-custom');
			        		Ext.getCmp('fjlxBtn3').removeCls('index-redFlag-btn-custom');
			        	}else{
			        		//已经选中过了，取消
			        		sqrxxPanel.getForm().findField('fjlx').setValue('');
			        		Ext.getCmp('fjlxBtn2').removeCls('index-redFlag-btn-custom');
			        		isClickFjlxBtn2 = false;
			        	}
			        }
			    },'-',{
			    	text: '委托协议/受理通知书', 
			    	id : "fjlxBtn3",
			    	hidden : false,
			    	scale   : 'large',
			    	icon: ctx + '/common/images/Folder_Images_32px.png',
			    	handler: function(){
			        	//委托协议/受理通知书
			    		
			    		if(!isClickFjlxBtn3){
			        		//还没有选中
			    			sqrxxPanel.getForm().findField('fjlx').setValue('3');
			        		Ext.getCmp('fjlxBtn3').addCls('index-redFlag-btn-custom');
			        		isClickFjlxBtn3 = true;
			        		Ext.getCmp('fjlxBtn1').removeCls('index-redFlag-btn-custom');
			        		Ext.getCmp('fjlxBtn2').removeCls('index-redFlag-btn-custom');
			        	}else{
			        		//已经选中过了，取消
			        		sqrxxPanel.getForm().findField('fjlx').setValue('');
			        		Ext.getCmp('fjlxBtn3').removeCls('index-redFlag-btn-custom');
			        		isClickFjlxBtn3 = false;
			        	}
			        }
			    }
	    	],
	    	items : [{ 
		    	xtype : 'panel',
		    	id: 'images-view',
		    	region : 'center',
		    	layout: 'fit',
	    		frame : false,
	    		items : Ext.create('Ext.view.View', {
	    			id : 'scanImagesView',
		            store: imageStore,
		            tpl: [
		                '<tpl for=".">',
		                    '<div class="thumb-wrap" id="{id}_div">',
		                        '<div class="thumb"><img src="{url}" id="{id}_img" title="{mc}"></div>',
		                        '<div style="padding-left: 3px;"><span class="x-editable">{mc}</span></div>',
		                    '</div>',
		                '</tpl>',
		                '<div class="x-clear"></div>'
		            ],
		            multiSelect: true,
		            height: 310,
		            autoScroll : true,
		            trackOver: false,
		            overItemCls: 'x-item-over',
		            itemSelector: 'div.thumb-wrap',
		            emptyText: '请点击<开始扫描>按钮扫描图片...',
		            plugins: [
		                Ext.create('Ext.ux.DataView.DragSelector', {}),
		                Ext.create('Ext.ux.DataView.LabelEditor', {
		                	dataIndex: 'mc',
		                	grow: true,
	            			selectOnFocus: true,
		                	listeners: {
						        complete : function(thiz, newValue, startValue, eOpts){
						        	console.log("complete");
						        	if(newValue !=startValue){
						        		var params = {
							        		//申请人信息附件表主键
											id : thiz.activeRecord.data.id,
											mc : newValue
							        	};
						        		var config = {
						            		url : 'information/tsqrxxfj/update.do',
								            params : params,
								            timeout : 1200000, // 超时：20分钟
								            callback : function(sqrxxfjDto){
								            	//console.log(sqrxxfjDto);
								            	ExtUtils.tip("提示","修改名称成功...");
								            }
								        };
								        ExtUtils.doAjax(config);
						        	}
						        	//console.log(thiz.activeRecord);
						        },
						        staterestore : function( thiz, state, eOpts ){
						        	console.log("staterestore");
						        },
						        statesave : function( thiz, state, eOpts ){
						        	console.log("statesave");
						        }
						    }
		                	})
		            ],
		            /**
		            prepareData: function(data) {
		                Ext.apply(data, {
		                    mc: Ext.util.Format.ellipsis(data.mc, 15),
		                    id: Ext.util.Format.fileSize(data.id)
		                });
		                return data;
		            },
		            **/
		            listeners: {
		                selectionchange: function(dv, nodes ){
		                	
		                    var l = nodes.length,
		                        s = l !== 1 ? 's' : '';
		                    //console.log(l);
		                    //this.up('panel').setTitle('Simple DataView (' + l + ' item' + s + ' selected)');
		                },
		                itemdblclick : function(dv, record, item, index, e, eOpts){
		                	console.log('dataview dbclick');
		                	//console.log(record);
		                	//console.log(item);
		                	var id = record.data.id;
		                	
		                	
		                	window.open(Ext.getDom(id+'_img').src);
								
	
		                	
	//	                	var custom = Ext.create('Ext.resizer.Resizer', {
	//					        target: id+"_img",
	//					        pinned:true,
	//					        minWidth:50,
	//					        minHeight: 50,
	//					        preserveRatio: true,
	//					        handles: 'all',
	//					        dynamic: true
	//					    });
	//					
	//					    var customEl = custom.getEl();
	//					    // move to the body to prevent overlap on my blog
	//					    document.body.insertBefore(customEl.dom, document.body.firstChild);
	//					
	//					    customEl.on('dblclick', function(){
	//					        customEl.hide(true);
	//					    });
	//	                	
	//					    customEl.center();
		                	
		                	
		                	
		                	
	//	                	Ext.create('Ext.resizer.Resizer', {
	//						    el: id+"_img",
	//						    handles: 'all',
	//						    minWidth: 200,
	//						    minHeight: 100,
	//						    maxWidth: 500,
	//						    maxHeight: 400,
	//						    pinned: true
	//						});
		                	
		                }
		            }
		        }),
	    		tbar: [ {
			        text: '扫描仪上传', 
			        scale   : 'medium',
			        icon : ctx + '/common/images/barcode_scanner_24px.png',
			        handler: function(){
			        	//附件类型
		                var fjlx = sqrxxPanel.getForm().findField('fjlx').getValue();
		                if(Ext.isEmpty(fjlx)){
		               		ExtUtils.tip("错误","请先点击按钮选择附件类型..."); 
		               		return ;
		                }
			        	//Ext.MessageBox.prompt('扫描件', '请输入该扫描件的名称:', saveImagesFn);
		                saveImagesFn();
			        } 
			    },'-',{
			    	text: '本地图片上传', 
			    	scale   : 'large',
			    	icon: ctx + '/common/images/cloud_upload_32.png',
			    	handler: function(){
			    		//附件类型
		                var fjlx = sqrxxPanel.getForm().findField('fjlx').getValue();
		                if(Ext.isEmpty(fjlx)){
		               		ExtUtils.tip("错误","请先点击按钮选择附件类型..."); 
		               		return ;
		                }
			        	fileUploadWindow.show();
			        }
			    },'->',
			    /**
			    '<span style="color:red">提示：鼠标移动到图片上可以放大预览，双击可以打开原始图片.</span>',
			    */
			    '<span style="color:red">提示：双击可以打开原始图片.</span>',
			    '-',{
			    	text : '删除',
			    	icon : ctx + '/common/images/icons/delete.png',
			        handler: function(){
			        	Ext.MessageBox.confirm(StrConstants.HINT, StrConstants.HINT_DEL_CONFIRM, function(btn) {
	                        if (btn == 'yes') {
	                            var scanImagesView = Ext.getCmp('scanImagesView');
					        	if(Ext.isObject(scanImagesView)){
						        	var els = scanImagesView.getSelectedNodes();
						        	if(els.length>0){
						        		var records = scanImagesView.getRecords(els);
						        		//console.log(records);
						        		if(records.length>0){
						        			var delIds = "" ;
						        			Ext.Array.each(records, function(record, index, countriesItSelf) {
											    //console.log(record);
											    delIds += record.data.id+",";
											});
						        			var params = {
						        				delIds : delIds
						        			};
							            	var config = {
									            url : 'information/tsqrxxfj/deleteBatch.do',
									            params : params,
									            callback : function(jsonData){
									            	imageStore.remove(records);
									            	ExtUtils.tip("提示","删除成功...");
									            }
									        };
									        ExtUtils.doAjax(config);
						        			
						        		}else{
						        			ExtUtils.tip("提示","您还未选中扫描的图片...");
						        		}
						        	}else{
						        		ExtUtils.tip("提示","您还未选中扫描的图片...");
						        	}
						        	//console.log(els);
						        	
					        	}else{
					        		ExtUtils.tip("提示","扫描图片展示区域异常...");
					        	}
	                        	
	                        }
	
	                    });
	                        
			        	
			        } 
			    }]
		    }]
	    },{ 
	    	xtype : 'panel',
	    	region : 'west',
	    	id : 'doccameraPanel',
	    	title : '高拍仪预览',
	    	layout : 'border',
	    	width : 500,
    		frame : true,
    		collapsible : true,
    		collapsed : true,
    		split : true,
			tbar:{
                xtype:"panel",
                border:false,
                items:[{
                    //tbar第一行工具栏
                    xtype:"toolbar",
                    items:[{
			        text: '启动摄像头', 
			        icon : ctx + '/common/images/icons/camera.png',
			        handler: function(){
			        	//先校验高拍仪插件有没有安装
	 					if(!checkCaptrue()){
	 						return false;
	 					};
			        	var stopResult = captrue.bStopPlay();  	
		        		var stsrtResult = captrue.bStartPlay();
			        } 
			    },{
			        text: '停止摄像头', 
			        icon : ctx + '/common/images/icons/camera_delete.png',
			        handler: function(){
			        	//先校验高拍仪插件有没有安装
	 					if(!checkCaptrue()){
	 						return false;
	 					};
			        	var stopResult = captrue.bStopPlay();  	
			        } 
			    }]
                },{
                    //tbar第二行工具栏
                    xtype:"toolbar",
                    items:['亮度:',{
						xtype : 'numberfield',
						id : 'BrightnessValue',
						width : 50,
						value: 20,
						maxLength : 3,
				        maxValue: 100,
				        minValue: 0
				 	},'对比度:',{
						xtype : 'numberfield',
						id : 'ContrastValue',
						width : 50,
						value: 20,
						maxLength : 3,
				        maxValue: 100,
				        minValue: 0
				 	},'曝光度:',{
						xtype : 'numberfield',
						id : 'ExposureValue',
						width : 50,
						value: 50,
						maxLength : 3,
				        maxValue: 100,
				        minValue: 0
				 	},'-', {
			 			text:'设置',
			 			icon : ctx + '/common/images/icons/cog.png',
			 			handler: function(){
			 				//先校验高拍仪插件有没有安装
		 					if(!checkCaptrue()){
		 						return false;
		 					};
	 					
				        	var BrightnessValue = Ext.getCmp("BrightnessValue").value;
				        	var ContrastValue = Ext.getCmp("ContrastValue").value;
				        	var ExposureValue = Ext.getCmp("ExposureValue").value;
				        	//console.log(BrightnessValue);console.log(ContrastValue);console.log(ExposureValue);
							captrue.vSetBrightness(BrightnessValue);	
							captrue.vSetContrast(ContrastValue);
							captrue.vSetExposure(ExposureValue);
				        }
			 		}] 
                }]
			},
			items : [{
				xtype:"component",
                border:false,
                /**
                renderTpl: [
			        '<div id="preview_doccamera" style="text-align:center;width:100%;height:100%" >',
					'<object classid="clsid:454C18E2-8B7D-43C6-8C17-B1825B49D7DE" id="captrue"  width="480" height="360" ></object>',
					'</div>'
			    ],
			    **/
                /**
                autoEl: {
	                tag: 'object',
	                width : 480,
					height: 360,
	                classid: 'clsid:454C18E2-8B7D-43C6-8C17-B1825B49D7DE',
					id : 'captrue'
	            }
	            */
                autoEl: {
                	html : '<div id="preview_doccamera" style="text-align:center;width:100%;height:100%" >'
					+ '<object classid="clsid:454C18E2-8B7D-43C6-8C17-B1825B49D7DE" id="captrue"  width="480" height="360" ></object>'
					+ '</div>'
                }
                
				//renderTo : 'preview_doccamera'
			
			}]
	    }
	    ],
	    tbar: [{
	        text: '第一步',
	        iconCls: "x-tbar-page-first",
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：填写申请人信息
	            clearAll();
	        }
	    },{
	        text: '上一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-prev',
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//上一步：填写申请人信息
	        }
	    }, {
	        text: '下一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-next',
	        formBind: true, //only enabled once the form is valid
	        
	        handler: function() {
	        	/**网上查询，不必要求必须上传附件
	        	//判断是否该上传的附件都上传了=====
	        	if(imageStore.getCount()==0){
	        		ExtUtils.tip("错误","按要求上传相应的附件..."); 
	        		return ;
	        	}
	        	
	        	
	        	var needFjlxAry = needFjlxStr.split(',');
	        	console.log(needFjlxAry.length);
	        	var hasFjlxAry = new Array();
	        	for(var j=0;j<needFjlxAry.length;j++){ 
	        		hasFjlxAry[j]="false";
	        	}
	        	
	        	for(var i =0;i<imageStore.getCount();i++){
					var model = imageStore.getAt(i); //遍历每一行
					console.log(model);
					console.log(i+':'+model.data.fjlx);
					hasFjlxAry[parseInt(model.data.fjlx)-1]="true";
				}
				console.log(hasFjlxAry);
	        	
				var valid = true;
				var msg = "按要求上传[工作证/身份证]...";
				for(var k=0;k<needFjlxAry.length;k++){ 
					if("false"==hasFjlxAry[k]){
						valid = false;
						if(k==1){
							msg = "按要求上传[介绍信]...";
						}
						if(k==2){
							msg = "按要求上传[委托协议/受理通知书]...";
						}
						break;
					}
	        	}
	        	
	        	if(!valid){
	        		ExtUtils.tip("错误",msg); 
					return false;
	        	}
	        	**/
	        	
	        	
	        	var layout = infoMainPanel.getLayout();
	        	
	        	layout.setActiveItem(3);//下一步：被查询人信息
	        	
	        	/** 证件扫描与介绍信及相关资料扫描合并
			    var cxsqrlx = sqrxxPanel.getForm().findField('cxsqrlx').getValue();
	        	if("50"==cxsqrlx){
	        		//个人查询，跳过 介绍信及相关资料扫描
	        		layout.setActiveItem(3);//下一步：被查询人信息
	        	}else{
	        		 //ExtUtils.info('介绍信及相关资料扫描');
	        		layout.setActiveItem(2);//下一步：介绍信及相关资料扫描
	        	}
	        	*/
	        	
	        	/**
	        	var params = {
	        		//申请人信息表主键
					sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue()
					//TODO
	        	};
            	var config = {
		            //TODO 
            		url : 'scan/idCardScan.do',
		            params : params,
		            timeout : 1200000, // 超时：20分钟
		            callback : function(jsonData){
		            	var layout = infoMainPanel.getLayout();
			        	var cxsqrlx = sqrxxPanel.getForm().findField('cxsqrlx').getValue();
			        	//console.log(cxsqrlx);
			        	if("50"==cxsqrlx){
			        		//个人查询，跳过 介绍信及相关资料扫描
			        		layout.setActiveItem(3);//下一步：被查询人信息
			        	}else{
			        		 //ExtUtils.info('介绍信及相关资料扫描');
			        		layout.setActiveItem(2);//下一步：介绍信及相关资料扫描
			        	}
		            }
		        };
		        ExtUtils.doAjax(config);
		        */
	        }
	    }]
    });
    
    
    //3、介绍信及相关资料扫描===没用
    ssxzlPanel = Ext.create('Ext.Panel', { 
	    title: '介绍信及相关资料扫描', 
	    id : 'card2', 
	    frame : true,
	    items: [],
	    tbar: [ {
	        text: '开始扫描', 
	        handler: function(){
	        	ExtUtils.info('开始扫描介绍信及相关资料');
	        } 
	    }],
	    buttons: [{
	        text: '第一步',
	        iconCls: "x-tbar-page-first",
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：填写申请人信息
	            clearAll();
	        }
	    },{
	        text: '上一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-prev',
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(1);//上一步：证件扫描
	        }
	    }, {
	        text: '下一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-next',
	        formBind: true, //only enabled once the form is valid
	        handler: function() {
	        	var params = {
	        		//查询日志表的id
					sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue()
					
	        	};
            	var config = {
            		url : 'scan/fileScan.do',
            		timeout : 1200000, // 超时：20分钟
		            params : params,
		            callback : function(jsonData){
		            	//ExtUtils.info('被查询人信息');
			            var layout = infoMainPanel.getLayout();
			            layout.setActiveItem(3);//下一步：被查询人信息
		            }
		        };
		        ExtUtils.doAjax(config);
	            
	        }
	    }]
    });
    
    
     // 4、被查询人信息填写 
    bcxrxxPanel = Ext.create("ZTEsoft.form.SearchForm", {
    	id : 'card3',
        layout : 'column',
        hiddenBtns : true,
        frame : true,
        title : '被查询人信息',
        defaults : {
            labelAlign : 'right',
            labelWidth : 100,
            //xtype : 'textfield',
            style : 'margin-left:5px;margin-top:2px;margin-bottom:2px;'
        },
        items : [
        {
            fieldLabel : "身份证号码",
            xtype : "textfield",
            vtype : 'identityCard',
            afterSubTpl : WEBConstants.REQUIRED,
            allowBlank : false,
            width: 500,
            name : "idCardNum",
            listeners: {
                specialkey: function(field, e){
                    // e.HOME, e.END, e.PAGE_UP, e.PAGE_DOWN,
                    // e.TAB, e.ESC, arrow keys: e.LEFT, e.RIGHT, e.UP, e.DOWN
                    if (e.getKey() == e.ENTER) {
                    	//触发查询按钮事件
                    	//console.log(field.up('form').down('button[name=query]'));
                        field.up('form').down('button[name=query]').fireEvent('click');
                        console.log("触发查询按钮事件");
                    }
                },
                'focus':function(){  
                	//console.log("focus ..");
                    this.selectText();  
                    //console.log("focus .....");
                } 
            }
        },{
			xtype : 'tbspacer',
			width : 5
		}, {
			xtype : 'button',
			icon : ctx + '/common/images/icons/magnifier.png',
			name : 'query',
			text : '&nbsp;&nbsp;查&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;&nbsp;',
			formBind: true,
			listeners : {
				"click": function() {
					var form = this.up('form').getForm();
		            if (form.isValid()) {
		            	
		            	//通过表单校验
		            	//20160507修改，不展示grid表格，直接打开第一条记录
		            	//var layout = infoMainPanel.getLayout();
		            	//layout.setActiveItem(4);//下一步：显示查询结果
		            	
		            	bcxrStore.getProxy().extraParams = {
				        	//申请人信息表主键uuid
							sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
							//被查询人的身份证信息
							idCardNum : bcxrxxPanel.getForm().findField("idCardNum").getValue()
					
				        };
				        bcxrStore.load();
		            }
				}
			}
			/**
			handler : function() {
	            var form = this.up('form').getForm();
	            if (form.isValid()) {
	            	
	            	//通过表单校验
	            	var layout = infoMainPanel.getLayout();
	            	layout.setActiveItem(4);//下一步：显示查询结果
	            	
	            	bcxrStore.getProxy().extraParams = {
			        	//申请人信息表主键uuid
						sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
						//被查询人的身份证信息
						idCardNum : bcxrxxPanel.getForm().findField("idCardNum").getValue()
				
			        };
			        bcxrStore.load();
	            }
	        }
	        **/
		}],
        // 重置 和下一步 按钮.
	    tbar: [{
	        text: '第一步',
	        iconCls: "x-tbar-page-first",
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：填写申请人信息
	            clearAll();
	        }
	    },{
	        text: '上一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-prev',
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            
	            layout.setActiveItem(1);//上一步：证件、介绍信及相关资料扫描
	            /** 证件扫描与介绍信及相关资料扫描合并
	            layout.setActiveItem(2);//上一步：介绍信及相关资料扫描
	            */
	        }
	    },{
	        text: '重置',
	        icon : ctx + '/common/images/icons/arrow_rotate_anticlockwise.png',
	        handler: function() {
	            this.up('form').getForm().reset();
	        }
	    }
	    /**,{
	        text: '查询',
	        icon : ctx + '/common/images/icons/magnifier.png',
	        formBind: true, //only enabled once the form is valid
	        handler: function() {
	            var form = this.up('form').getForm();
	            if (form.isValid()) {
	            	
	            	//通过表单校验
	            	var layout = infoMainPanel.getLayout();
	            	layout.setActiveItem(4);//下一步：显示查询结果
	            	
	            	bcxrStore.getProxy().extraParams = {
			        	//申请人信息表主键uuid
						sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
						//被查询人的身份证信息
						idCardNum : bcxrxxPanel.getForm().findField("idCardNum").getValue()
				
			        };
			        bcxrStore.load();
	            }
	        }
	    }**/
	    ]
    });
    
    bcxrStore = Ext.create('component.information.store.QueryResultInfoStore',{
        listeners : {
            // 载入的时候默认选中第一条；触发查看操作，如果没有任何记录，则不处理
            "load" : function(thiz, records) {
                if (Ext.isEmpty(records)) {
                	ExtUtils.error("无法查询到数据...");
                } else {
                	bcxrGrid.getSelectionModel().select(0);
                	//bcxrGrid.getSelectionModel().fireEvent('selectionchange', null, items);
                    // 已经获取的grid的对象是 grid  
			        var selModel = bcxrGrid.getSelectionModel() ;  
			        var isGridSelected = selModel.hasSelection() ;  
			        //console.log(isGridSelected);
			        operateColumnClick(bcxrGrid,0,6);
                }
            }
        }
    });
    
    //5、显示被查询人表格信息
    bcxrGrid = Ext.create('Ext.grid.Panel', {
        id : 'card4',
        title : "被查询人信息",
        store : bcxrStore,
        isPage : false,
        columns : [{
            text : "被查询人ID",
            dataIndex : "bcxrxxId",
            hidden : true,
            flex : 1
        },{
            text : "姓名",
            dataIndex : "name",
            flex : 1
        }, {
            text : "身份证号码",
            dataIndex : "idCardNum",
            flex : 1
        }, {
            text : "出生日期",
            dataIndex : "birthDate",
            flex : 1
        }, {
            text : "住址",
            dataIndex : "address",
            flex : 1.5
        }, {
            text : "人口类型",
            dataIndex : "populationType",
            renderer : function(value, meta, record) {
                //return value == 'A' ? '户籍人口' : '暂住人口';
            	return value;
            },
            flex : 1
        },{
            text : "是否办理暂住证",
            dataIndex : "isHavingTR",
//            renderer : function(value, meta, record) {
//            	var viewMsg = "";
//            	if(value == 'A'){
//            		viewMsg = '已办理';
//            	}
//            	
//                return  viewMsg;
//            },
            flex : 1
        },
        {  
            text: '操作',  
            xtype:'actioncolumn',  
            width: 100,  
            items: [  
                {  
                    icon: ctx + '/common/images/icons/application_view_detail.png', // 指定图标  
                    tooltip: '查看',  
                    handler: function(grid, rowIndex, colIndex){
                    	// 指定单击“查看”按钮的事件处理函数  
                    	
                    	//console.log("rowIndex:"+rowIndex);
                    	//console.log("colIndex:"+colIndex);
                    	//console.log(grid.getStore().getAt(rowIndex).data.populationType);
                    	
                    	operateColumnClick(grid, rowIndex, colIndex);
                    	
                    } 
                }
            ]  
        } 
        ],
        tbar: [{
	        text: '第一步',
	        iconCls: "x-tbar-page-first",
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：填写申请人信息
	            clearAll();
	        }
	    },{
	        text: '上一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-prev',
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(3);//上一步：被查询人信息
	        }
	    }]
    });
    
    
    //被查询人操作列点击
    var operateColumnClick = function (grid, rowIndex, colIndex){
    	//console.log(rowIndex);
    	//console.log(colIndex);
    	//被查询人信息主键，记录打印次数用
                    	bcxrxxId = grid.getStore().getAt(rowIndex).data.bcxrxxId;
                    	if('户籍人口'==grid.getStore().getAt(rowIndex).data.populationType){
                    		
                    		var width = screen.availWidth-3;
							var height = screen.availHeight-20;
							var left = -4;
							var top = -4; 
		
                    		var url = ctx + '/information/czrkDetail.do?idCardNum='+grid.getStore().getAt(rowIndex).data.idCardNum;
                    		url += "&bcxrxxId="+grid.getStore().getAt(rowIndex).data.bcxrxxId;
                    		url += "&sqrxxId="+sqrxxPanel.getForm().findField('mainId').getValue();
                    		url += "&cxbs=30";
                    		url += "&a="+ new Date();
                    		var changkouMainWin = window.open(url,"",'toolbar=no,status=no,location=no,scrollbars=yes,resizable=no,width='+width+',height='+height+',top=0,left=0');
							//changkouMainWin.moveTo(left, top);
							changkouMainWin.focus();
                    		//openCZRKinfo(grid.getStore().getAt(rowIndex).data.idCardNum,grid.getStore().getAt(rowIndex).data.bcxrxxId,grid.getStore().getAt(rowIndex).data.populationType);
                    		/**
	                    	var config = {
					            url : 'information/queryCZRKinfo.do',
					            params : {
					            	//申请人信息表主键uuid
									sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
									//身份证编号
									idCardNum : grid.getStore().getAt(rowIndex).data.idCardNum,
					            	//被查询人信息主键
					            	bcxrxxId : grid.getStore().getAt(rowIndex).data.bcxrxxId,
					            	populationType : grid.getStore().getAt(rowIndex).data.populationType
					            },
					            callback : function(data){
					            	changzhuWin.show();
					            	//console.log("changzhuWin");
					            	//重写绑定模板 
	    							//changzhuWinTp.overwrite(changzhuWin.down('panel').getEl(), tpData);
					            	changzhuWinTp.overwrite(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv"), data);
					            	//合并单元格
					            	$("#familyInfoTable").rowspan({td:1}); 
					            	//console.log("bbbbb");
					            	/////console.log(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv").getHTML());
					            	//changzhuWin.down('panel').doComponentLayout();
					            	//console.log("getSize:"+Ext.encode(changzhuWin.down('panel').getSize( )) );
					            	//console.log("getHeight:"+changzhuWin.down('panel').getHeight( ) );
					            	//console.log("getPosition:"+changzhuWin.down('panel').getPosition( ) );
					            	//changzhuWin.down('panel').fireEvent('resize');
					            }
					        };
					        ExtUtils.doAjax(config);
					        */
                    	}
                    	
                    	if('暂住人口'==grid.getStore().getAt(rowIndex).data.populationType){
                    		var width = screen.availWidth-3;
							var height = screen.availHeight-20;
							var left = -4;
							var top = -4; 
		
                    		var url = ctx + '/information/zzrkDetail.do?idCardNum='+grid.getStore().getAt(rowIndex).data.idCardNum;
                    		url += "&bcxrxxId="+grid.getStore().getAt(rowIndex).data.bcxrxxId;
                    		url += "&sqrxxId="+sqrxxPanel.getForm().findField('mainId').getValue();
                    		url += "&cxbs=20";
                    		url += "&a="+ new Date();
                    		var zanzhuMainWin = window.open(url,"",'toolbar=no,status=no,location=no,scrollbars=yes,resizable=no,width='+width+',height='+height+',top=0,left=0');
							zanzhuMainWin.focus();
                    		
                    	}
                    	
                    	/**
                    	if('暂住人口'==grid.getStore().getAt(rowIndex).data.populationType){
                    		//TODO @惜帅，20151230 调用外部接口，打开新页面
                    		var width = screen.availWidth-3;
							var height = screen.availHeight-20;
							var left = -4;
							var top = -4;  
							
							var url = baseUrl + grid.getStore().getAt(rowIndex).data.idCardNum+"&a="+new Date();
							var zankouMainWin = window.open(url,"",'toolbar=no,status=no,location=no,scrollbars=yes,resizable=no,width='+width+',height='+height+',top=0,left=0');
							//zankouMainWin.moveTo(left, top);
							zankouMainWin.focus();
							//self.blur();
							//window.onfocus=function (){zankouMainWin.focus();};
      						//window.onclick=function (){zankouMainWin.focus();};
                    	}
                    	**/
                    	
                    	/**
                    	if('暂住人口'==grid.getStore().getAt(rowIndex).data.populationType){
                    		var config = {
					            url : 'information/queryZZRKinfo.do',
					            params : {
					            	//申请人信息表主键uuid
									sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
									//身份证编号
									idCardNum : grid.getStore().getAt(rowIndex).data.idCardNum,
					            	//被查询人信息主键
					            	bcxrxxId :grid.getStore().getAt(rowIndex).data.bcxrxxId,
					            	populationType : grid.getStore().getAt(rowIndex).data.populationType
					            },
					            callback : function(data){
					            	zanzhuWin.show();
					            	//console.log("zanzhuWin");
					            	//重写绑定模板 
					            	zanzhuWinTp.overwrite(zanzhuWin.down('panel').getEl().getById("zanzhuDetailDiv"), data);
					            	//console.log(zanzhuWin.down('panel').getEl().getById("zanzhuDetailDiv").getHTML());
					            }
					        };
					        ExtUtils.doAjax(config);
                    	}
                    	**/
        
    };
    
    function openCZRKinfo(idCard,bcxrxxId,populationType){
    	var config = {
	            url : 'information/queryCZRKinfo.do',
	            params : {
	            	//申请人信息表主键uuid
					sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
					//身份证编号
					idCardNum : idCard,
	            	//被查询人信息主键
	            	bcxrxxId : bcxrxxId||'',
	            	populationType : populationType||'户籍人口'
	            },
	            callback : function(data){
	            	changzhuWin.show();
	            	//重写绑定模板 
	            	changzhuWinTp.overwrite(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv"), data);
	            	//合并单元格
	            	$("#familyInfoTable").rowspan({td:1}); 
	            	$("#part2TableCZ a").on('click',function(){
//	            		console.log(arguments);
//	            		alert($(this).attr("pid"));
	            		console.log($(this).attr("pid"));
	            		openCZRKinfo($(this).attr("pid"));
	            	});
	            }
	        };
	        ExtUtils.doAjax(config);
    };
    
    
    
    ////创建常住人口模板
    var changzhuWinTp = new Ext.XTemplate(
	'<div class="frame_normal" id="allDiv">',
	'	<div class="div_title" id="titleDiv">',
	'		<span style="FONT-SIZE: 20px!important; ">本市户籍人口信息</span>',
	'	</div>',
	'	<div class="div_second_title" id="part1Div">',
	'		人员基本信息',
	'	</div>',
	'	<div id="part1TableCZ">',
	'		<table class="tbl" width=100%>',
	'			<tr>',
	'				<td colspan=1 width=100 class="NoNewline">公民身份证号码</td>',
	'				<td colspan=2 class="textInfoLeft NoNewline"  >{[values.baseInfo.idCardNum]}</td>',
	'				<td colspan=1 >姓名</td>',
	'				<td colspan=2 class="textInfoLeft NoNewline">{[values.baseInfo.name]}</td>',
	'				<td colspan=2 rowspan=6 width=162px  height=199px>' ,
	'					<div style="width:160px; height:197px" >',
	'					<img alt="照片" style="width:100%; height:100%" ',
	'						src="'+ctx+"/personImages/"+'{[values.baseInfo.photoGif]}"></div></td>',
	'			</tr>',
	'			<tr>',
	'				<td>曾用名</td>',
	'				<td colspan=2 class="textInfoLeft">{[values.baseInfo.aliaName]}</td>',
	'				<td>性别</td>',
	'				<td colspan=2 class="textInfoLeft">{[values.baseInfo.sex]}</td>',

	'			</tr>',
	'			<tr>',
	'				<td>民族</td>',
	'				<td colspan=2 class="textInfoLeft">{[values.baseInfo.nation]}</td>',
	'				<td>出生日期</td>',
	'				<td colspan=2 class="textInfoLeft">{[values.baseInfo.birthDate]}</td>',

	'			</tr>',
	'			<tr>',
	'				<td class="NoNewline">身份证签发机关</td>',
	'				<td colspan=2 class="textInfoLeft">{[values.baseInfo.idCardIssuneOffice]}</td>',
	'				<td colspan=2>身份证有效期限</td>',
	'				<td colspan=1 class="textInfoLeft" colspan=2>{[values.baseInfo.idCardExciptyTime]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>住址</td>',
	'				<td class="textInfoLeft" colspan=5>{[values.baseInfo.liveAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>派出所</td>',
	'				<td class="textInfoLeft" colspan=5>{[values.baseInfo.policeStation]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>&nbsp;&nbsp;</td>',
	'				<td colspan=2>国家(地区)</td>',
	'				<td colspan=2>省市县(区)</td>',
	'				<td colspan=3>详址</td>',
	'			</tr>',
	'			<tr>',
	'				<td>籍贯</td>',
	'				<td colspan=2 class="textInfoLeft NoNewline">{[values.baseInfo.nativePlaceNation]}</td>',
	'				<td colspan=2 class="textInfoLeft NoNewline">{[values.baseInfo.nativePlaceProvince]}</td>',
	'				<td colspan=3 class="textInfoLeft NoNewline" >{[values.baseInfo.nativePlaceDetailAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>出生地</td>',
	'				<td colspan=2 class="textInfoLeft NoNewline">{[values.baseInfo.birthPlaceNation]}</td>',
	'				<td colspan=2 class="textInfoLeft NoNewline" >{[values.baseInfo.birthPlaceProvince]}</td>',
	'				<td colspan=3 class="textInfoLeft NoNewline" >{[values.baseInfo.birthPlaceDetailAddress]}</td>',
	'			</tr>',

	'		</table>',
	'	</div>',
  '',
	'	<div class="div_second_title" id="part2Div">',
	'		家庭关系及联系人信息',
	'	</div>',
	'	<div id="part2TableCZ">',
	'		<table class="tbl" width=100% id="familyInfoTable">',
	'			<tr>',
	'				<td  width=60>&nbsp;&nbsp;</td>',
	'				<td>关系</td>',
	'				<td width=130>公民身份证号码</td>',
	'				<td>姓名</td>',
	'				<td>证件种类</td>',
	'				<td width=130>证件号码</td>',
	'				<td>外文姓</td>',
	'				<td>外文名</td>',
	//'				<td>联系电话</td>',
	'			</tr>',
	'			<tpl for="familyInfoList">',
	'			<tr action="{relationType}">',
	'				<td>{relationType}</td>',
	'				<td>{relationShip}</td>',
	'				<td>{idCardNum}</td>',
	'				<td>{name}</td>',
	'				<td>{certificateType}</td>',
	'				<td>{certificateNum}</td>',
	'				<td>{foreignLastName}</td>',
	'				<td>{foreignFirstName}</td>',
	//'				<td>{telephoneNum}</td>',
	'			</tr>',
	'			</tpl>',
	'		</table>',
	'	</div>',
  '',
/** TODO @惜帅 隐藏迁移信息  
	'	<div class="div_second_title" id="part3Div">',
	'		迁移信息',
	'	</div>',
	'	<div id="part3TableCZ">',
	'		<table class="tbl" width=100%>',
	'			<tr>',
	'				<td width=170>何时何因由何地迁来本市(县)</td>',
	'				<td colspan=7 class="textInfoLeft">{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td width=170>何时何因由何地迁来本址</td>',
	'				<td colspan=7 class="textInfoLeft">{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td width=170>何时何因迁往何地</td>',
	'				<td colspan=7 class="textInfoLeft">{[values.migrateInfo.timeAndResultForMigrateOtherPlace]}</td>',
	'			</tr>',
	'		</table>',
	'	</div>',
**/
  '',
	'	<div id="part4Div">',
	'	<table class="tb2" width=100%>',
	'		<tr>',
	'			<td colspan=18  class="textInfoLeft">{[values.tipMessage]}</td>',
	'		</tr>',
	'		<tr>',
	'			<td colspan=4 class="textInfoRight">&nbsp;</td>',
	'			<td colspan=2 class="textInfoRight">操作单位：</td>',
	'			<td colspan=4 class="textInfoLeft">{[values.czdw]}</td>',
	'			<td colspan=2 class="textInfoRight">操作人：</td>',
	'			<td colspan=2 class="textInfoLeft">{[values.czr]}</td>',
	'			<td colspan=2 class="textInfoRight">打印日期：</td>',
	'			<td colspan=2 class="textInfoLeft">{[values.dyrq]}</td>',
	'		</tr>',
	'	</table>',
	'	</div>',
	'</div>'
	);
	//changzhuWinTp.compile() ;
    
	
	
	
	//6、本市户籍人口信息 常住
    changzhuWin = Ext.create('ZTEsoft.window.Window',{
    	id : 'card5',
    	width : 800,
        height : 400,
        layout : 'fit',
        closeAction : 'hide',
        //overflowY :'scroll',
        //maximized : true,
        maximizable : true,
        items : [Ext.create('Ext.panel.Panel',{
	        	overflowY :'scroll',
	        	html : '<div id="changzhuDetailDiv"></div>'
        	}
        )],
        resizable : true,
        listeners : {
        	'show' : function( thiz, eOpts ){
        		var winH = 400>parseInt(Ext.getBody().getHeight())?400:parseInt(Ext.getBody().getHeight());
        		changzhuWin.setHeight(winH);
        		console.log('setHeight'+winH);
        	}
        },
        buttons: [{
		        text: '继续查询',
		        icon : ctx + '/common/images/icons/magnifier.png',
		        handler: function() {
		            changzhuWin.hide();
		            var layout = infoMainPanel.getLayout();
	            	layout.setActiveItem(3);//被查询人信息
	            	//bcxrxxPanel.getForm().reset();
	            	bcxrxxPanel.getForm().findField("idCardNum").focus(true,100);
		        }
		    },{ 
        		text: '打印' ,
        		icon : ctx + '/common/images/icons/printer.png',
				name : 'printBtn',
				handler: function(btn) {
					
					//记录打印状态
					var params = {
		        		//被查询人信息主键，记录打印次数用
                    	bcxrxxId : bcxrxxId,
                    	//cxbs 查询标示  10：终端，20：pc端,30:网上查询
                    	cxbs : "30",
                    	//身份证编号
						idCardNum : bcxrxxPanel.getForm().findField('idCardNum').getValue()
						
		        	};
	        		var config = {
	            		url : 'information/tbcxrxx/canPrint.do',
			            params : params,
			            callback : function(canPrintResult){
			            	if(canPrintResult.canPrint){
			            		//可以打印
			            	}
			            }
			        };
			        ExtUtils.doAjax(config);
					
					
		            //console.log("dayin");
		            var html = preHtml + changzhuWin.down('panel').getEl().getById("changzhuDetailDiv").getHTML()+'</body></html>';
		            var printHtml = "";
		            var htmlArray = $.parseHTML(html);
//		            console.log("htmlArray");
//		            console.log(htmlArray);
		            try{
			            $.each( htmlArray, function( i, item ) {
			            	
						    
			            	var aEls = $(item).find("#part2TableCZ a");
			            	
			            	if(aEls.length>0){
			            		console.log(aEls);
			            		$.each( aEls, function( j, aItem ) {
			            			var pid = $(aItem).attr('pid');
				            		$(aItem).after('<span>'+pid+'</span>');
				            		$(aItem).remove();
	//			            		console.log(aEls);console.log("pid:"+pid);
			            			
			            		});
			            		
			            	}
			            	
			            	var delEls = $(item).find("table tr[action=子女]");
			            	if(delEls.length>0){
			            		delEls.remove();
			            		printHtml = $(item).html();
			            	}
			            	//console.log(delEls);
						    //console.log($(item));
						});
					}catch (e){
		            	console.log(e);
		            }
					
					console.log("printHtml");console.log(printHtml);
					
					
		            //console.log(printHtml);
		            /////console.log(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv").getHTML());
					
		            printHtml = preHtml +'<div class="frame_normal" id="allDiv">'+ printHtml+'</div></body></html>';
		            //console.log(html);
		            createPrintPage(printHtml);
		            LODOP.PREVIEW();
		        }
        	},{ 
        		text : '取消',
				iconCls : 'arrow_undo',
				name : 'canceltBtn',
				handler : function(){
					changzhuWin.hide();
				}
        	}
		]
    });
    
    
    
    ////创建暂住人口模板
    var zanzhuWinTp = new Ext.XTemplate(
	'<div class="frame_normal" id="allDiv">',
	'	<div class="div_title" id="titleDiv">',
	'		<span style="FONT-SIZE: 20px!important; ">本市暂住人口信息查询表<span>',
	'	</div>',
	'	<div class="div_second_title" id="part1Div">',
	'		人员基本信息',
	'	</div>',
	'	<div id="part1Table">',
	'		<table class="tbl" width=100%>',
	'			<tr>',
	'				<td>公民身份证号码</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.idCardNum]}</td>',
	'				<td width=100>姓名</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.name]}</td>',
	'				<td colspan=2 rowspan=6 width=162px  height=199px> ',
	'					<div style="width:160px; height:197px" >',
	'						<img alt="照片" style="width:100%; height:100%" ',
	'							src="'+ctx+"/personImages/"+'{[values.baseInfo.photoGif]}"></div> </td>',
	'			</tr>',
	'			<tr>',
	'				<td>曾用名</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.aliaName]}</td>',
	'				<td>性别</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.sex]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>民族</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.nation]}</td>',
	'				<td>出生日期</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.birthDate]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>籍贯</td>',
	'				<td class="textInfoLeft" colspan=3>{[values.baseInfo.nativePlace]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>户籍地址省市县（区）</td>',
	'				<td class="textInfoLeft" colspan=3>{[values.baseInfo.householdRegisterProviceAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>户籍详细地址</td>',
	'				<td class="textInfoLeft" colspan=3>{[values.baseInfo.householdRegisterDetailAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>填报日期</td>',
	'				<td class="textInfoLeft" colspan=5>{[values.baseInfo.fillDate]}</td>',
	'			</tr>',
	'		</table>',
	'	</div>',
  '',
	'	<div class="div_second_title" id="part2Div">',
	'		暂住信息',
	'	</div>',
	'	<div id="part2Table">',
	'		<table class="tbl" width=100%>',
	'			<tr>',
	'				<td width=35>序号</td>',
	'				<td width=125>暂住证编号</td>',
	'				<td width=70>起始日期</td>',
	'				<td width=70>截止日期</td>',
	'				<td width=60>间隔时间</td>',
	'				<td>签发机构</td>',
	'				<td>登记单位</td>',
	'				<td>暂住地址</td>',
	'			</tr>',
	'			<tpl for="trInfoList">',
	'			<tr>',
	'				<td>{#}</td>',	
	'				<td class="NoNewline">{trNum}</td>',
	'				<td>{startDate}</td>',
	'				<td>{endDate}</td>',
	'				<td>{intervalTime}</td>',
	'				<td>{trCardIssuneOffice}</td>',
	'				<td>{trCardCompany}</td>',
	'				<td>{trAddress}</td>',
	'			</tr>',
	'			</tpl>',
	'		</table>',
	'	</div>',
  '',
  '',
	'	<div id="part3Div">',
	'	<table class="tb2" width=100%>',
	'		<tr>',
	'			<td colspan=18  class="textInfoLeft">{[values.tipMessage]}</td>',
	'		</tr>',
	'		<tr>',
	'			<td colspan=4 class="textInfoRight">&nbsp;</td>',
	'			<td colspan=2 class="textInfoRight">操作单位：</td>',
	'			<td colspan=4 class="textInfoLeft">{[values.czdw]}</td>',
	'			<td colspan=2 class="textInfoRight">操作人：</td>',
	'			<td colspan=2 class="textInfoLeft">{[values.czr]}</td>',
	'			<td colspan=2 class="textInfoRight">打印日期：</td>',
	'			<td colspan=2 class="textInfoLeft">{[values.dyrq]}</td>',
	'		</tr>',
	'	</table>',
	'	</div>',
	'</div>'
	);
	
	
	
	//7、暂住人口信息 
    zanzhuWin = Ext.create('ZTEsoft.window.Window',{
    	id : 'card7',
    	width : 800,
        height : 400,
        layout : 'fit',
        //maximized : true,
        maximizable : true,
        closeAction : 'hide',
        items : [Ext.create('Ext.panel.Panel',{
	        	overflowY :'scroll',
	        	html : '<div id="zanzhuDetailDiv"></div>'
        	}
        )],
        resizable : true,
        listeners : {
        	'show' : function( thiz, eOpts ){
        		var winH = 400>parseInt(Ext.getBody().getHeight())?400:parseInt(Ext.getBody().getHeight());
        		thiz.setHeight(winH);
        		console.log('setHeight');
        	}
        },
        buttons: [{
		        text: '继续查询',
		        icon : ctx + '/common/images/icons/magnifier.png',
		        handler: function() {
		            zanzhuWin.hide();
		            var layout = infoMainPanel.getLayout();
	            	layout.setActiveItem(3);//被查询人信息
	            	//bcxrxxPanel.getForm().reset();
	            	bcxrxxPanel.getForm().findField("idCardNum").focus(true,100);
		        }
		    },{ 
        		text: '打印' ,
        		icon : ctx + '/common/images/icons/printer.png',
				name : 'printBtn',
				handler: function(btn) {
					//记录打印状态
					var params = {
		        		//被查询人信息主键，记录打印次数用
                    	bcxrxxId : bcxrxxId,
                    	//cxbs 查询标示  10：终端，20：pc端,30:网上查询
                    	cxbs : "30",
                    	//身份证编号
						idCardNum : bcxrxxPanel.getForm().findField('idCardNum').getValue()
		        	};
	        		var config = {
	            		url : 'information/tbcxrxx/canPrint.do',
			            params : params,
			            callback : function(canPrintResult){
			            	if(canPrintResult.canPrint){
			            		//可以打印
			            	}
			            }
			        };
			        ExtUtils.doAjax(config);
			        
					
		            //console.log("dayin");
		            var html = preHtml + zanzhuWin.down('panel').getEl().getById("zanzhuDetailDiv").getHTML()+'</body></html>';
		            //console.log(html);
		            createPrintPage(html);
		            LODOP.PREVIEW();
		        }
        	},{ 
        		text : '取消',
				iconCls : 'arrow_undo',
				name : 'canceltBtn',
				handler : function(){
					zanzhuWin.hide();
				}
        	}
		]
    });
    
	
    
    //人口信息查询主要面板
    infoMainPanel = Ext.create('Ext.Panel', { 
	    //title: '人口信息查询', 
	    layout: 'card', 
	    region : "center",
	    activeItem: 0,    //默认活动项 
	    id: 'cardPanel', 
	    items: [sqrxxPanel,zjPanel,ssxzlPanel,bcxrxxPanel,bcxrGrid]
	    /**
	    tbar: ['->', { 
	        id: 'cardPrev', 
	        text: '? 上一步', 
	        disabled : true,
	        handler: Ext.Function.bind(cardNav, this, [-1]) 
	    }, { 
	        id: 'cardNext', 
	        text: '下一步 ?', 
	        handler: Ext.Function.bind(cardNav, this, [1]) 
	    }]
	    */
    });
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [infoMainPanel]
    });
    
    /**
     * 清理所有值，初始化
     */
    var clearAll = function(){
    	sqrxxPanel.getForm().reset();
    	bcxrxxPanel.getForm().reset();
    	imageStore.removeAll();
    	bcxrStore.removeAll();
    	bcxrxxId = "";
    	needFjlxStr = "1,2,3";
    	isClickFjlxBtn1 = false;
    	isClickFjlxBtn2 = false;
    	isClickFjlxBtn3 = false;
    	
//    	Ext.getCmp('fjlxBtn2').hide();
//		Ext.getCmp('fjlxBtn3').hide();
		Ext.getCmp('fjlxBtn1').removeCls('index-redFlag-btn-custom');
		Ext.getCmp('fjlxBtn2').removeCls('index-redFlag-btn-custom');
		Ext.getCmp('fjlxBtn3').removeCls('index-redFlag-btn-custom');
//		Ext.getCmp('fjlxBtn2').hide();
//		Ext.getCmp('fjlxBtn3').hide();
    };

});
