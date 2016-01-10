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
						
    
    
    
    
    
    
    
    //5、显示被查询人表格信息
    
    
    function openCZRKinfo(idCard,bcxrxxId,populationType){
    	var config = {
	            url : 'information/queryCZRKinfo.do',
	            params : {
	            	//申请人信息表主键uuid
					sqrxxId : reqOjb.sqrxxId,
					//身份证编号
					idCardNum : idCard,
	            	//被查询人信息主键
	            	bcxrxxId : bcxrxxId||'',
	            	populationType : populationType||'户籍人口'
	            },
	            callback : function(data){
	            	//重写绑定模板 
	            	changzhuWinTp.overwrite(czrkPanel.down('panel').getEl().getById("changzhuDetailDiv"), data);
	            	//合并单元格
	            	$("#familyInfoTable").rowspan({td:1}); 
	            	$("#part2TableCZ a").on('click',function(){
//	            		console.log(arguments);
//	            		alert($(this).attr("pid"));
	            		console.log($(this).attr("pid"));
	            		//openCZRKinfo($(this).attr("pid"));
	            		openNewPage($(this).attr("pid"));
	            	});
	            }
	        };
	        ExtUtils.doAjax(config);
    }
    
    function openNewPage(idCard){
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
    }
    
    
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
	'				<td>联系电话</td>',
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
	'				<td>{telephoneNum}</td>',
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
    
	//本市户籍人口信息 常住
	czrkPanel = Ext.create('Ext.Panel', { 
		region : "center",
		layout : 'border',
		items : [Ext.create('Ext.panel.Panel',{
	        	overflowY :'scroll',
	        	region : "center",
	        	html : '<div id="changzhuDetailDiv"></div>'
        	}
        )],
        listeners : {
        	'afterrender' : function( thiz, eOpts ){
        		console.log("panel afterrender");
        		openCZRKinfo(reqOjb.idCardNum,reqOjb.bcxrxxId,reqOjb.populationType);
        	}
        },
        buttons: [{ 
        		text: '打印' ,
        		icon : ctx + '/common/images/icons/printer.png',
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
			            	}
			            }
			        };
			        ExtUtils.doAjax(config);
					
					
		            //console.log("dayin");
		            var html = preHtml + czrkPanel.down('panel').getEl().getById("changzhuDetailDiv").getHTML()+'</body></html>';
		            var printHtml = "";
		            var htmlArray = $.parseHTML(html);
//		            console.log("htmlArray");
//		            console.log(htmlArray);
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
					
					console.log("printHtml");console.log(printHtml);
					
					
		            //console.log(printHtml);
		            /////console.log(czrkPanel.down('panel').getEl().getById("changzhuDetailDiv").getHTML());
					
		            printHtml = preHtml +'<div class="frame_normal" id="allDiv">'+ printHtml+'</div></body></html>';
		            //console.log(html);
		            createPrintPage(printHtml);
		            LODOP.PREVIEW();
		        }
        	},{ 
        		text : '关闭',
				iconCls : 'close',
				name : 'closeBtn',
				handler : function(){
					window.close();
				}
        	}
		]
	});
	
    
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [czrkPanel]
    });
    

});
