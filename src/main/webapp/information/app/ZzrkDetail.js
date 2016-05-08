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
    
    var reqOjb = {};
    reqOjb.idCardNum = Ext.get("idCardNum").getValue();
    reqOjb.bcxrxxId = Ext.get("bcxrxxId").getValue();
    reqOjb.populationType = Ext.get("populationType").getValue();
    reqOjb.sqrxxId = Ext.get("sqrxxId").getValue();
    reqOjb.cxbs = Ext.get("cxbs").getValue();
    
    
    //需要的附件类型组合
    var needFjlxStr = "1";
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
	
	
	
	
    
    
    
    
 

    
    
    var x = 22;
	var y = 20;
						
    
    
    
    function openZZRKinfo(idCard,bcxrxxId,populationType){
    	var config = {
    			url : '10'==reqOjb.cxbs?'plates/queryZZRKinfo.do':'information/queryZZRKinfo.do',
	            params : {
	            	//申请人信息表主键uuid
					sqrxxId : reqOjb.sqrxxId,
					//身份证编号
					idCardNum : idCard,
	            	//被查询人信息主键
	            	bcxrxxId : bcxrxxId||'',
	            	populationType : populationType||'暂住人口'
	            },
	            callback : function(data){
	            	//把页面的查询标识，塞到数据项中，为了展示用
	            	data.page_cxbs=reqOjb.cxbs;
	            	//重写绑定模板 
	            	zanzhuWinTp.overwrite(zzrkPanel.down('panel').getEl().getById("zanzhuDetailDiv"), data);
	            	//单击查看暂住证信息，第三方系统
	            	$("#part2Div a").on('click',function(){
//	            		console.log(arguments);
	            		
	            		
	            		//终端，才需要记录打印状态，并判断是否能打印
	            		if('10'==reqOjb.cxbs){
		            		//记录打印状态
							var params = {
				        		//被查询人信息主键，记录打印次数用
		                    	bcxrxxId : reqOjb.bcxrxxId,
		                    	//cxbs 10：终端，20：pc端,30:网上查询
		                    	cxbs : reqOjb.cxbs,
		                    	//身份证编号
								idCardNum : reqOjb.idCardNum
								
				        	};
			        		var config = {
			            		url : 'information/tbcxrxx/canPrint.do',
					            params : params,
					            callback : function(canPrintResult){
					            	if(canPrintResult.canPrint){
					            		//可以打开连接
					            		openNewPage(reqOjb.idCardNum);
					            		
			            			}else{
					            		ExtUtils.error(canPrintResult.message);
					            	}
					            }
					        };
					        ExtUtils.doAjax(config);
	            		}else{
	            			//其他的状态，都可以直接打开,只要后面记录下打印即可
	            			openNewPage(reqOjb.idCardNum);
	            			
	            			
	            			//记录打印状态
							var params = {
				        		//被查询人信息主键，记录打印次数用
		                    	bcxrxxId : reqOjb.bcxrxxId,
		                    	//cxbs 10：终端，20：pc端,30:网上查询
		                    	cxbs : reqOjb.cxbs,
		                    	//身份证编号
								idCardNum : reqOjb.idCardNum
								
				        	};
			        		var config = {
			            		url : 'information/tbcxrxx/canPrint.do',
					            params : params,
					            callback : function(canPrintResult){
					            	if(canPrintResult.canPrint){
					            		//可以打开连接
					            		
			            			}else{
			            				
					            	}
					            }
					        };
					        ExtUtils.doAjax(config);
					        
	            		}
	            		
	            		
	            		
	            		
	            	});
	            }
	        };
	        ExtUtils.doAjax(config);
    }
    
    function openNewPage(idCardTmp){
    	//TODO @惜帅，20151230 调用外部接口，打开新页面
		var width = screen.availWidth-3;
		var height = screen.availHeight-20;
		var left = -4;
		var top = -4;  
		
		var url = baseUrl + idCardTmp+"&a="+new Date();
		var zankouMainWin = window.open(url,"",'toolbar=no,menubar=no,status=no,location=no,scrollbars=yes,resizable=no,width='+width+',height='+height+',top=0,left=0');
		zankouMainWin.moveTo(left, top);
		zankouMainWin.focus();
		
		
    	/**
    	var width = screen.availWidth-3;
		var height = screen.availHeight-20;
		var left = -4;
		var top = -4; 
    	var url = ctx + '/information/czrkDetail.do?idCardNum='+idCard;
		url += "&bcxrxxId="+reqOjb.bcxrxxId;
		url += "&sqrxxId="+reqOjb.sqrxxId;
		url += "&cxbs="+reqOjb.cxbs;
		url += "&a="+ new Date();
		var changkouMainWin = window.open(url,"",'toolbar=no,status=no,location=no,scrollbars=yes,resizable=no,width='+width+',height='+height+',top=0,left=0');
		changkouMainWin.moveTo(left, top);
		changkouMainWin.focus();
		*/
    }
    
    
    ////创建暂住人口模板  //本市暂住人口信息查询表
    var zanzhuWinTp = new Ext.XTemplate(
	'<div class="frame_normal" id="allDiv">',
	'	<div class="div_title" id="titleDiv">',
	'		<span style="FONT-SIZE: 20px!important; ">暂住人口基本信息表<span>',
	'	</div>',
	'	<div class="div_second_title" id="part1Div">',
	'		<table class="tb2" width=100%>',
	'			<tr>',
	'			    <td colspan=4 class="textInfoLeft">人员基本信息</td>',
	'			    <td colspan=4 class="textInfoRight">流水号:{[values.bcxrxxPO.lsh]} &nbsp;&nbsp;</td>',
	'			</tr>',
	'		</table>',
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
//	'			<tr>',
//	'				<td>籍贯</td>',
//	'				<td class="textInfoLeft" colspan=3>{[values.baseInfo.nativePlace]}</td>',
//	'			</tr>',
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
	'				<td class="textInfoLeft" colspan=3>{[values.baseInfo.fillDate]}</td>',
	'			</tr>',
	'		</table>',
	'	</div>',
  '',
	'	<div class="div_second_title" replaceString id="part2Div">',
	'		<a href="#">查看暂住信息</a>',
	'	</div>',
/**
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
**/
  '',
  '',
	'	<div id="part3Div">',
	'	<table class="tb2" width=100%>',
/**
	'		<tr>',
	'			<td colspan=18  class="textInfoLeft">{[values.tipMessage]}</td>',
	'		</tr>',
**/
	'<tpl if="page_cxbs &lt; 15"> ',
	'		<tr>',
	'			<td colspan=4 class="textInfoRight">&nbsp;</td>',
	'			<td colspan=2 class="textInfoRight">&nbsp;</td>',
	'			<td colspan=4 class="textInfoLeft">&nbsp;</td>',
	'			<td colspan=2 class="textInfoRight">&nbsp;</td>',
	'			<td colspan=2 class="textInfoLeft">&nbsp;</td>',
	'			<td colspan=2 class="textInfoRight">打印日期：</td>',
	'			<td colspan=2 class="textInfoLeft">{[values.dyrq]}</td>',
	'		</tr>',
	'</tpl> ',
	'<tpl if="page_cxbs &gt; 15"> ',
	'		<tr>',
	'			<td colspan=18 class="textInfoLeft">&nbsp;&nbsp;申请人类型：{[this.formater(values.sqrxxPO.cxsqrlx)]} &nbsp;&nbsp;  申请人：{[values.sqrxxPO.xm]} &nbsp;&nbsp; {[this.getCzdw(values.sqrxxPO.cxsqrlx,values.sqrxxPO.cxrdw)]} &nbsp;&nbsp;事由：{[values.sqrxxPO.cxsy]}</td>',
	'		</tr>',
	'</tpl> ',
	'<tpl if="page_cxbs &gt; 15"> ',
	'		<tr>',
	'			<td colspan=2 class="textInfoRight">&nbsp;</td>',
	'			<td colspan=2 class="textInfoRight">操作单位：</td>',
	'			<td colspan=4 class="textInfoLeft">{[values.czdw]}</td>',
	'			<td colspan=2 class="textInfoRight">操作人：</td>',
	'			<td colspan=2 class="textInfoLeft">{[values.czr]}</td>',
	'			<td colspan=2 class="textInfoRight">打印日期：</td>',
	'			<td colspan=4 class="textInfoLeft">{[values.dyrq]}</td>',
	'		</tr>',
	'</tpl> ',
	'	</table>',
	'	</div>',
	'</div>',{
			//['10', '律师'],['20', '党政军机关'],['30', '司法机关'],['40', '企事业单位'],['50', '个人'], ['60', '人民团体']
			formater : function(value) {
	            	if(value == '10'){
	            		return'律师';
	            	}else if(value == '20'){
	            		return'党政军机关';
	            	}else if(value == '30'){
	            		return'司法机关';
	            	}else if(value == '40'){
	            		return'企事业单位';
	            	}else if(value == '50'){
	            		return'个人';
	            	}else if(value == '60'){
	            		return'人民团体';
	            	}else if(value == '70'){
	            		return'其他';
	            	}
	            },
	       getCzdw : function(cxsqrlx,czdw){
	       		//申请人查询类型为个人时，查询单位 直接隐藏掉
	       		if(cxsqrlx == '50'){
	       			return "";
	       		}else{
	       			return "单位："+czdw;
	       		}
	       			
	       }
		}
	);
	
    
	//本市户籍人口信息 暂住
	zzrkPanel = Ext.create('Ext.Panel', { 
		region : "center",
		layout : 'border',
		items : [Ext.create('Ext.panel.Panel',{
	        	overflowY :'scroll',
	        	region : "center",
	        	html : '<div id="zanzhuDetailDiv"></div>'
        	}
        )],
        listeners : {
        	'afterrender' : function( thiz, eOpts ){
        		console.log("panel afterrender");
        		openZZRKinfo(reqOjb.idCardNum,reqOjb.bcxrxxId,reqOjb.populationType);
        	}
        },
        buttons: [{ 
        		scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">打印</span>', 
        		icon : ctx + '/common/images/print_32px.png',
        		//text: '打印' ,
        		//icon : ctx + '/common/images/icons/printer.png',
				name : 'printBtn',
				handler: function(btn) {
					
					//记录打印状态
					var params = {
		        		//被查询人信息主键，记录打印次数用
                    	bcxrxxId : reqOjb.bcxrxxId,
                    	//cxbs 10：终端，20：pc端,30:网上查询
                    	cxbs : reqOjb.cxbs,
                    	//身份证编号
						idCardNum : reqOjb.idCardNum
						
		        	};
	        		var config = {
	            		url : 'information/tbcxrxx/canPrint.do',
			            params : params,
			            callback : function(canPrintResult){
			            	if(canPrintResult.canPrint){
			            		//可以打印
			            		//console.log("dayin");
					            var html = preHtml + zzrkPanel.down('panel').getEl().getById("zanzhuDetailDiv").getHTML()+'</body></html>';
					            var printHtml = "";
					            var htmlArray = $.parseHTML(html);
					            console.log("htmlArray");
					            console.log(htmlArray);
					            try{
						            $.each( htmlArray, function( i, item ) {
						            	
						            	/**
						            	var aEls = $(item).find("#part2Div a");
						            	
						            	if(aEls.length>0){
						            		console.log(aEls);
						            		aEls.remove();
						            	}
						            	*/
						            	//设置div隐藏  
										//$("#part2Div").hide();  
						            	
						            	var divEls = $(item).find("div");
						            	if(divEls.length>0){
						            		printHtml += $(item).html();
						            	}
						            	
						            	//设置div隐藏  
						            	//$("#part2Div").show();
						            	
									});
								}catch (e){
									console.log(e);
									alert(e);
					            }
					            printHtml += "";
					            //alert(typeof printHtml);
					            //alert(printHtml);
					            //printHtml.replace(/replaceString/,'style="display:none"');
					            //<div class="div_second_title" id="part2Div"><a href="#">查看暂住信息</a>	</div>	
					            //printHtml.replaceAll(/查看暂住信息/,"",false);
					            printHtml = printHtml.replace(/查看暂住信息/,"");
								//console.log("printHtml");console.log(printHtml);
								//alert(printHtml);
								
					            //console.log(printHtml);
					            /////console.log(zzrkPanel.down('panel').getEl().getById("zanzhuDetailDiv").getHTML());
								
					            printHtml = preHtml +'<div class="frame_normal" id="allDiv">'+ printHtml+'</div></body></html>';
					            //console.log(html);
					            createPrintPage(printHtml);
					            LODOP.PREVIEW();
			            	}else{
			            		ExtUtils.error(canPrintResult.message);
			            	}
			            }
			        };
			        ExtUtils.doAjax(config);
					
					
		            
		        }
        	},'-',{ 
        		scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">关闭</span>', 
        		icon : ctx + '/common/images/X_close_32px.png',
        		//text : '关闭',
				//iconCls : 'close',
				name : 'closeBtn',
				handler : function(){
					//window.close();
					CloseWebPage();
				}
        	}
		]
	});
	
    
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [zzrkPanel]
    });
    

});
