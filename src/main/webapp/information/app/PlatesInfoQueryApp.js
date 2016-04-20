/**
 * 人口信息查询首页
 */
Ext.onReady(function() {
	
	Ext.util.CSS.swapStyleSheet('theme',webRoot+'common/jslibs/extjs/ext-4.2.1/resources/ext-theme-gray/ext-theme-gray-all.css');
	
	Ext.Ajax.timeout = 180000; //3分钟超时 
	
	//被查询人信息主键、身份证号——统计打印次数需要
    var bcxrxxId,sqrIdCardNum;
    
    //按钮名称
    var btnTitle1="厦门户籍人口基本信息查询";
    var btnTitle2="厦门暂（居）住人口基本信息查询";
    var btnTitle3="外来务工子女就学-暂住人口信息查询表";
	
    //暂口信息查询外部第三方接口的URL
    var baseUrl = Ext.get("thirdPartyZzrkUrl").getValue();
    //是否测试状态，是则打开预览打印
    var isDebug = Ext.get("isDebugId").getValue()+"";
    
    var sqrxxPanel,zjPanel,ssxzlPanel,bcxrxxPanel,bcxrStore,bcxrGrid,changzhuWin,zanzhuWin,infoMainPanel;
    var LODOP;
    
    var preHtml = '<!DOCTYPE html><html><head><meta charset="UTF-8"><title>人口信息打印</title><style type="text/css">html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,input	{	margin: 0;	padding: 0;	border: 0;	font-weight: inherit;	font-style: inherit;	font-size: 100%;	font-family: Arial, Microsoft Yahei;	/**vertical-align:baseline;*/}body {	line-height: 1;	font-size: 12px;}ol,ul {	list-style: none;}.color_red {	color: #ff0900;}.color_gray {	color: #9b9b9b;}.color_bule {	color: #015a9f;}.clear {	clear: both;}.font18 {	font-size: 18px;}.font14 {	font-size: 14px;}* {	font-size: 12px !important;}</style><link rel="stylesheet" type="text/css"	href="'+webRoot+'common/css/info.css"></head><body>';
    

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
	
	var sqrxxPanelFieldWidth = 350;
	
	function Button1_onclick() {
        var CVR_IDCard = document.getElementById("CVR_IDCard");					
		var strReadResult = CVR_IDCard.ReadCard();
		if(strReadResult == "0")
		{
			ClearForm();
		      document.all['Name'].value = CVR_IDCard.Name;  //姓名
              document.all['Sex'].value = CVR_IDCard.Sex;    //性别
              document.all['Nation'].value = CVR_IDCard.Nation; //民族
              document.all['Born'].value = CVR_IDCard.Born;     //出生日期
              document.all['Address'].value = CVR_IDCard.Address; //地址
              document.all['CardNo'].value = CVR_IDCard.CardNo; //身份号码
              document.all['IssuedAt'].value = CVR_IDCard.IssuedAt;  //签发机关
              document.all['EffectedDate'].value = CVR_IDCard.EffectedDate;  //生效期限
              document.all['ExpiredDate'].value = CVR_IDCard.ExpiredDate;//失效时间
              document.all['SAMID'].value = CVR_IDCard.SAMID; //模块号码
              document.all['pic'].src = CVR_IDCard.Pic;  //照片名称
              document.all['Picture'].value = CVR_IDCard.Picture;  //照片编码
              document.all['PictureLen'].value = CVR_IDCard.PictureLen  ;//编码长度
          }
          else
          {
            ClearForm();
            alert(strReadResult);
          }
					
	}

	//首页按钮宽高
	var btnHeight = (parseInt(Ext.getBody().getHeight())/5);
	var btnWidth = (parseInt(Ext.getBody().getWidth())/2);
	
	//弹出窗口宽高
	var winHeight = (parseInt(Ext.getBody().getHeight())*1);
	
	console.log("Ext.getBody().getHeight():"+Ext.getBody().getHeight());
	console.log("Ext.getBody().getWidth():"+Ext.getBody().getWidth());
	
	console.log("btnHeight:"+btnHeight);
	console.log("btnWidth:"+btnWidth);
	
	
	var queryType = 1;
	//1、首页
	indexPanel = Ext.create('Ext.panel.Panel', {
        region : 'center',
        //layout : 'border',
        layout : {
            type : 'vbox',
            pack : 'center',
            align : 'center',
            padding : 10
        },
        defaults : {
	        margins : '0 0 10 0'
	    },
        id : 'card0', 
        items : [{
            xtype : 'button',
            //region : 'north',
            id : 'czQryBtn',
            text: '<span style="font-size:26px !important;font-family:microsoft yahei !important;">'+btnTitle1+'</span>',
            width : btnWidth,
            height : btnHeight,
            handler : function() {
                console.log('厦门户籍人口基本信息查询');
                queryType = 1;
                var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(1);//第2步：证件扫描
	            Ext.getCmp('titleBtn').setText("<span style='font-size:16px !important;font-family:microsoft yahei !important;color:blue;'>您正在进行"+btnTitle1+"...</span>");
	            defaultTimes();
//	            var dom= Ext.getDom(Ext.getCmp("backIndexBtn").btnEl);
//              	dom.style.width=200;
//              	dom.style.height=100;
//	            console.log(dom);
            }

        },{
            xtype : 'button',
            //region : 'center',
            id : 'zzQryBtn',
            cls : 'btnQueryCls',
            text: '<span style="font-size:26px !important;font-family:microsoft yahei !important;">'+btnTitle2+'</span>',
            //cls : 'btntransparent',
            width : btnWidth,
            height : btnHeight,
            hidden : true,
            handler : function() {
                console.log('厦门暂（居）住人口基本信息查询');
                queryType = 2;
                var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(1);//第2步：证件扫描
	            Ext.getCmp('titleBtn').setText("<span style='font-size:16px !important;font-family:microsoft yahei !important;color:blue;'>您正在进行"+btnTitle2+"...</span>");
            	defaultTimes();
            }

        },{
            xtype : 'button',
            //region : 'south',
            id : 'wlzzQryBtn',
            cls : 'btnQueryCls',
            text: '<span style="font-size:26px !important;font-family:microsoft yahei !important;">外来务工子女就学</span><br><span style="font-size:16px !important;font-family:microsoft yahei !important;">暂住人口信息查询表打印</span>',
            //cls : 'btntransparent',
            width : btnWidth,
            height : btnHeight,
            handler : function() {
                console.log('外来务工子女就学-暂住人口信息查询表');
                queryType = 3;
                var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(1);//第2步：证件扫描
	            Ext.getCmp('titleBtn').setText("<span style='font-size:16px !important;font-family:microsoft yahei !important;color:blue;'>您正在进行"+btnTitle3+"...</span>");
            	defaultTimes();
            }

        }]
	});
	
	//背景色方式1，使用渐变色
	//Ext.getCmp('czQryBtn').el.setStyle('background-image','-webkit-linear-gradient(top,red,yellow 40%,yellow 30%,red)');
	//背景色方式2
	//Ext.getCmp('mine').btnEl.setStyle('background-color',"yellow");
	//字体颜色
	//Ext.getCmp('czQryBtn').btnInnerEl.setStyle('color',"green");
	//Ext.getCmp('czQryBtn').btnInnerEl.setStyle('font-family',"microsoft yahei");
	//Ext.getCmp('czQryBtn').el.setStyle('font-family','Microsoft Yahei');
    
    //2、证件扫描
    zjPanel = Ext.create('Ext.Panel', { 
	    //title: '当前进行', 
	    id : 'card1', 
	    frame : true,
	    layout : {
            type : 'vbox',
            pack : 'center',
            align : 'center',
            padding : 2
        },
        defaults : {
	        margins : '0 0 10 0'
	    },
	    items: [{
	    	xtype : 'label',
	    	html: '<span style="font-size:25px !important;font-family:microsoft yahei !important;">请将身份证放入读卡区，然后点击查询。</span><br>'
            	+'<span style="font-size:25px !important;font-family:microsoft yahei !important;">为保护您的个人隐私，请操作完成后点击“关闭”退出操作界面。</span>',
            //cls : 'btntransparent',
            width : btnWidth+5,
            height : 60
	    },{
            xtype : 'button',
            region : 'center',
            id : 'idCardBtn',
            text: '<span style="font-size:36px !important;font-family:microsoft yahei !important;">查询</span><br>',
            	//+'<span style="font-size:16px !important;font-family:microsoft yahei !important;">请将身份证放入读卡区，然后点击查询。</span><br>'
            	//+'<span style="font-size:16px !important;font-family:microsoft yahei !important;">为保护您的个人隐私，请操作完成后点击“关闭”退出操作界面。</span>',
            //cls : 'btntransparent',
            width : btnWidth,
            height : btnHeight,
            handler : function() {
                console.log('开始读取身份证');
                
                
                
                //TODO  @惜帅  调试隐藏
                //TODO
                //TODO
                //TODO
                //TODO
                var CVR_IDCard = document.getElementById("CVR_IDCard");		
                //设置超时时间
                //CVR_IDCard.TimeOut=3;
				var strReadResult = CVR_IDCard.ReadCard();
				
				//TODO  @惜帅  调试隐藏
//				strReadResult = "0";
				
				if(strReadResult == "0"){
	              var config = {
			            url : 'plates/queryByPlates.do',
			            params : {
			            	"name" : CVR_IDCard.Name,  //姓名
				            "sex" : CVR_IDCard.Sex,    //性别
				            "nation" : CVR_IDCard.Nation, //民族
				            "born" : CVR_IDCard.Born,     //出生日期
				            "address" : CVR_IDCard.Address, //地址
				            //TODO  @惜帅  调试隐藏
				            "cardNo" : CVR_IDCard.CardNo, //身份号码
//				            "cardNo" : CVR_IDCard.CardNo||"35020419811021103X", //身份号码
				            
				            "issuedAt" : CVR_IDCard.IssuedAt,  //签发机关
				            "effectedDate" : CVR_IDCard.EffectedDate,  //生效期限
				            "expiredDate" : CVR_IDCard.ExpiredDate,//失效时间
				            "samid" : CVR_IDCard.SAMID, //模块号码
				            "pic" : CVR_IDCard.Pic,  //照片名称
				            "picture" : CVR_IDCard.Picture,  //照片编码
				            "picturelen" : CVR_IDCard.PictureLen,//编码长度
			            	// 人口类型（1：户籍人口，2：暂住人口）
							"populationType" : 1==queryType ? 1:2
			            },
			            callback : function(data){
			            	//返回被查询人信息
			            	
			            	//被查询人信息主键，记录打印次数用
                    		bcxrxxId = data.bcxrxxId;
                    		sqrIdCardNum = data.idCardNum;
                    		
			            	//户籍人口
			            	if(1==queryType){
			            		
			            		var width = screen.availWidth-3;
								var height = screen.availHeight-20;
								var left = -4;
								var top = -4; 
			
	                    		var url = ctx + '/information/czrkDetail.do?idCardNum='+data.idCardNum;// 身份证号码
	                    		url += "&bcxrxxId="+data.bcxrxxId;//被查询人信息主键
	                    		url += "&sqrxxId="+data.sqrxxId;//申请人信息表主键uuid
	                    		url += "&cxbs=10";
	                    		url += "&debug="+isDebug;
	                    		url += "&a="+ new Date();
	                    		var changkouMainWin = window.open(url,"",'toolbar=no,menubar=no,status=no,location=no,scrollbars=yes,resizable=no,fullscreen=1,width='+width+',height='+height+',top=0,left=0');
								//changkouMainWin.moveTo(left, top);
								changkouMainWin.focus();
			            		
			            		
			            		
			            		/**
				            	var configTmp = {
						            url : 'plates/queryCZRKinfo.do',
						            params : {
						            	//申请人信息表主键uuid
										sqrxxId : data.sqrxxId,
						            	//被查询人信息主键
						            	bcxrxxId : data.bcxrxxId,
						            	// 身份证号码
						            	idCardNum : data.idCardNum,
						            	//人口类型（1：户籍人口，2：暂住人口）
						            	populationType : data.populationType
						            },
						            callback : function(populationInfo){
						            	changzhuWin.show();
						            	//console.log("changzhuWin");
						            	//重写绑定模板 
		    							//changzhuWinTp.overwrite(changzhuWin.down('panel').getEl(), tpData);
						            	changzhuWinTp.overwrite(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv"), populationInfo);
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
						        ExtUtils.doAjax(configTmp);
						        */
			            	}
			            	
			            	//暂住人口
			            	if(2==queryType){
			            		var width = screen.availWidth-3;
								var height = screen.availHeight-20;
								var left = -4;
								var top = -4; 
			
	                    		var url = ctx + '/information/zzrkDetail.do?idCardNum='+data.idCardNum;// 身份证号码
	                    		url += "&bcxrxxId="+data.bcxrxxId;//被查询人信息主键
	                    		url += "&sqrxxId="+data.sqrxxId;//申请人信息表主键uuid
	                    		url += "&cxbs=10";
	                    		url += "&debug="+isDebug;
	                    		url += "&a="+ new Date();
	                    		var zanzhuMainWin = window.open(url,"",'toolbar=no,menubar=no,status=no,location=no,scrollbars=yes,resizable=no,fullscreen=1,width='+width+',height='+height+',top=0,left=0');
								//zanzhuMainWin.moveTo(left, top);
								zanzhuMainWin.focus();
			            	}
			            	
			            	//暂住人口-外来务工子女就学-暂住人口信息查询表
			            	if(3==queryType){
			            		
			            		//记录打印状态
								var params = {
					        		//被查询人信息主键，记录打印次数用
			                    	bcxrxxId : data.bcxrxxId,
			                    	//cxbs 10：终端，20：pc端,30:网上查询
			                    	cxbs : '10',
			                    	//身份证编号
									idCardNum : data.idCardNum,
									//人口类型（1：户籍人口，2：暂住人口）
									rklx : 2
									
					        	};
				        		var config = {
				            		url : 'information/tbcxrxx/canPrint.do',
						            params : params,
						            callback : function(canPrintResult){
						            	if(canPrintResult.canPrint){
						            		ExtUtils.tip("提示",canPrintResult.message);
						            		//可以打开连接
						            		//TODO @惜帅，20151230 调用外部接口，打开新页面
				                    		var width = screen.availWidth-3;
											var height = screen.availHeight-20;
											var left = -4;
											var top = -4;  
											
											var url = baseUrl + data.idCardNum+"&a="+new Date();
											//var zankouMainWin = window.open(url,"",'toolbar=no,status=no,location=no,scrollbars=yes,resizable=no,width='+width+',height='+height+',top=0,left=0');
											var zankouMainWin = window.open(webRoot + "information/jumpToThirdParty.do?thirdPartyUrl=" + url,"",'toolbar=no,menubar=no,status=no,location=no,scrollbars=yes,resizable=no,fullscreen=1,width='+width+',height='+height+',top=0,left=0');
											//zankouMainWin.moveTo(left, top);
											zankouMainWin.focus();
						            		
				            			}else{
						            		ExtUtils.error(canPrintResult.message);
						            	}
						            }
						        };
						        ExtUtils.doAjax(config);
			            		
			            		
			            		
			            		
			            		
			            	}
			            	
			            	/**
			            	//暂住人口
			            	if("2"==data.populationType){
	                    		var configTmp = {
						            url : 'plates/queryZZRKinfo.do',
						            params : {
						            	//申请人信息表主键uuid
										sqrxxId : data.sqrxxId,
						            	//被查询人信息主键
						            	bcxrxxId : data.bcxrxxId,
						            	// 身份证号码
						            	idCardNum : data.idCardNum,
						            	//人口类型（1：户籍人口，2：暂住人口）
						            	populationType : data.populationType
						            },
						            callback : function(data){
						            	zanzhuWin.show();
						            	//console.log("zanzhuWin");
						            	//重写绑定模板 
						            	zanzhuWinTp.overwrite(zanzhuWin.down('panel').getEl().getById("zanzhuDetailDiv"), data);
						            	//console.log(zanzhuWin.down('panel').getEl().getById("zanzhuDetailDiv").getHTML());
						            }
						        };
						        ExtUtils.doAjax(configTmp);
	                    	}
	                    	*/
			            	
			            }
			        };
			        ExtUtils.doAjax(config);
	          }
	          else
	          {
	          	ExtUtils.error(strReadResult);
	          }
                
	          
	          //关闭读卡器
	          //CVR_IDCard.DoStopRead; 
            }

        }],
	    tbar: [ {
	    	id : 'backIndexBtn',
	    	scale   : 'large',
	    	height : 60,
	    	width : 200,
	        text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;"><<<返回首页</span>', 
	        //icon : ctx + '/common/images/back_48px.png',
	        //iconCls : 'btnIndexCls',
	        handler: function(){
	        	var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：首页
	            defaultTimes();
	        } 
	    },{
	    	xtype: 'tbtext',
	    	id : 'titleBtn',
	    	scale   : 'large',
	    	text : ''
	    },'->',{
    		id : 'showSeconds',
    		scale   : 'large',
    		text : ''
    	}]
    });
    
	
    
    //人口信息查询主要面板
    infoMainPanel = Ext.create('Ext.Panel', { 
	    //title: '厦门市人口信息查询', 
//    	tbar : ['->',{
//    		id : 'showSeconds',
//    		text : ''
//    	}],
	    layout: 'card', 
	    region : "center",
	    activeItem: 0,    //默认活动项 
	    id: 'cardPanel', 
	    items: [indexPanel,zjPanel]
    });
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [infoMainPanel]
    });

    
    
    
    
    //TODO @惜帅  定义时间初始时间为60秒
    var intervalTimes = 60;
    var times = intervalTimes;
    // 该方法用于重置时间
    defaultTimes = function () {
        // 测试弹出
        times = intervalTimes;
        Ext.getCmp('showSeconds').setText('<span style="font-size:20px !important;font-family:microsoft yahei !important;">'+times+'S</span>');
    };
    // 判断是否超过【intervalTimes】秒无操作。
    timesReduce = function () {
        times--;
        if(times>=-1){
        	Ext.getCmp('showSeconds').setText('<span style="font-size:20px !important;font-family:microsoft yahei !important;">'+times+'S</span>');
        }
        // alert(times);
        if (times <= 0) {
            // alert('跳转');
            // 执行跳转
            if(Ext.Msg.isVisible()){
	    		Ext.Msg.hide();
	    	}
	    	
	    	if(Ext.isObject(changzhuWin)&&changzhuWin.isVisible()){
	    		changzhuWin.hide();
	    	}
	    	
	    	if(Ext.isObject(zanzhuWin)&&zanzhuWin.isVisible()){
	    		zanzhuWin.hide();
	    	}
	    	
	    	if(Ext.isObject(infoMainPanel)){
	    		var layout = infoMainPanel.getLayout();
		        layout.setActiveItem(0);//返回首页
	    	}
        }
    };
    window.setInterval('timesReduce()', 1000);
    
    
    //键盘事件
	//document.onkeydown=defaultTimes;
	//document.onkeypress=defaultTimes;
	//鼠标事件
	//document.onmousedown=defaultTimes;
	//document.onmousewheel=defaultTimes;
	//document.onmouseover=defaultTimes;
    
    /**
    window.onNobody(function(){
    	console.log("onNobody");
    	if(Ext.Msg.isVisible()){
    		Ext.Msg.hide();
    	}
    	
    	if(Ext.isObject(changzhuWin)&&changzhuWin.isVisible()){
    		changzhuWin.hide();
    	}
    	
    	if(Ext.isObject(zanzhuWin)&&zanzhuWin.isVisible()){
    		zanzhuWin.hide();
    	}
    	
    	if(Ext.isObject(infoMainPanel)){
    		var layout = infoMainPanel.getLayout();
	        layout.setActiveItem(0);//返回首页
    	}
    },5000,false);
    **/
});
