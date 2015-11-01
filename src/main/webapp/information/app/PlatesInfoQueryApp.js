/**
 * 人口信息查询首页
 */
Ext.onReady(function() {
	
	Ext.util.CSS.swapStyleSheet('theme',webRoot+'common/jslibs/extjs/ext-4.2.1/resources/ext-theme-gray/ext-theme-gray-all.css');
	
	Ext.Ajax.timeout = 180000; //3分钟超时 
	
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
	var btnWidth = (parseInt(Ext.getBody().getWidth())/5);
	
	//弹出窗口宽高
	var winHeight = (parseInt(Ext.getBody().getHeight())*0.9);
	
	console.log("Ext.getBody().getHeight():"+Ext.getBody().getHeight());
	console.log("Ext.getBody().getWidth():"+Ext.getBody().getWidth());
	
	console.log("btnHeight:"+btnHeight);
	console.log("btnWidth:"+btnWidth);
	
	
	var populationType = 1;
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
            region : 'north',
            id : 'czQryBtn',
            text: '<span style="font-size:26px !important;font-family:microsoft yahei !important;">常住人口信息查询</span>',
            width : btnWidth,
            height : btnHeight,
            handler : function() {
                console.log('常住人口信息查询');
                populationType = 1;
                var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(1);//第2步：证件扫描
	            Ext.getCmp('titleBtn').setText("<span style='font-size:16px !important;font-family:microsoft yahei !important;color:blue;'>您正在进行常住人口信息查询...</span>");
            }

        },{
            xtype : 'button',
            region : 'center',
            id : 'zzQryBtn',
            cls : 'btnQueryCls',
            text: '<span style="font-size:26px !important;font-family:microsoft yahei !important;">暂住人口信息查询</span>',
            //cls : 'btntransparent',
            width : btnWidth,
            height : btnHeight,
            handler : function() {
                console.log('暂住人口信息查询');
                populationType = 2;
                var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(1);//第2步：证件扫描
	            Ext.getCmp('titleBtn').setText("<span style='font-size:16px !important;font-family:microsoft yahei !important;color:blue;'>您正在进行暂住人口信息查询...</span>");
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
            padding : 10
        },
        defaults : {
	        margins : '0 0 10 0'
	    },
	    items: [{
            xtype : 'button',
            region : 'center',
            id : 'idCardBtn',
            text: '<span style="font-size:26px !important;font-family:microsoft yahei !important;">开始读取身份证</span>',
            //cls : 'btntransparent',
            width : btnWidth,
            height : btnHeight,
            handler : function() {
                console.log('开始读取身份证');
                
                //TODO  惜帅  调试隐藏
//                var CVR_IDCard = document.getElementById("CVR_IDCard");					
//				var strReadResult = CVR_IDCard.ReadCard();
				
				strReadResult = "0";
				if(strReadResult == "0"){
	              var config = {
			            url : 'plates/queryByPlates.do',
			            params : {
			            	"name" : CVR_IDCard.Name,  //姓名
				            "sex" : CVR_IDCard.Sex,    //性别
				            "nation" : CVR_IDCard.Nation, //民族
				            "born" : CVR_IDCard.Born,     //出生日期
				            "address" : CVR_IDCard.Address, //地址
				            //TODO  惜帅  调试隐藏
//				            "cardNo" : CVR_IDCard.CardNo, //身份号码
//				            "cardNo" : CVR_IDCard.CardNo||"35020419811021103X", //身份号码
				            
				            "issuedAt" : CVR_IDCard.IssuedAt,  //签发机关
				            "effectedDate" : CVR_IDCard.EffectedDate,  //生效期限
				            "expiredDate" : CVR_IDCard.ExpiredDate,//失效时间
				            "samid" : CVR_IDCard.SAMID, //模块号码
				            "pic" : CVR_IDCard.Pic,  //照片名称
				            "picture" : CVR_IDCard.Picture,  //照片编码
				            "picturelen" : CVR_IDCard.PictureLen,//编码长度
			            	// 人口类型（1：户籍人口，2：暂住人口）
							"populationType" : populationType
			            },
			            callback : function(data){
			            	//返回被查询人信息
			            	
			            	//户籍人口
			            	if("1"==data.populationType){
				            	var config = {
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
						        ExtUtils.doAjax(config);
			            	}
			            	
			            	//暂住人口
			            	if("2"==data.populationType){
	                    		var config = {
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
						        ExtUtils.doAjax(config);
	                    	}
			            	
			            }
			        };
			        ExtUtils.doAjax(config);
	          }
	          else
	          {
	          	ExtUtils.error(strReadResult);
	          }
                
            }

        }],
	    tbar: [ {
	    	scale   : 'large',
	        text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">返回首页</span>', 
	        icon : ctx + '/common/images/Back_light_32px.png',
	        handler: function(){
	        	var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：首页
	        } 
	    },{
	    	xtype: 'tbtext',
	    	id : 'titleBtn',
	    	scale   : 'large',
	    	text : ''
	    }]
    });
    
    
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
	'				<td width=100>姓名</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.name]}</td>',
	'				<td>曾用名</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.aliaName]}</td>',
	'				<td>性别</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.sex]}</td>',
	'				<td colspan=2 rowspan=6 width=162px  height=199px>' ,
	'					<div style="width:160px; height:197px" >',
	'					<img alt="照片" style="width:100%; height:100%" ',
	'						src="'+ctx+"/personImages/"+'{[values.baseInfo.photoGif]}"></div></td>',
	'			</tr>',
	'			<tr>',
	'				<td>民族</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.nation]}</td>',
	'				<td>出生日期</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.birthDate]}</td>',
	'				<td>公民身份证号码</td>',
	'				<td class="textInfoLeft"  width=130>{[values.baseInfo.idCardNum]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>&nbsp;&nbsp;</td>',
	'				<td>国家(地区)</td>',
	'				<td colspan=2>省市县(区)</td>',
	'				<td colspan=2>详址</td>',
	'			</tr>',
	'			<tr>',
	'				<td>籍贯</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.nativePlaceNation]}</td>',
	'				<td class="textInfoLeft" colspan=2>{[values.baseInfo.nativePlaceProvince]}</td>',
	'				<td class="textInfoLeft" colspan=2>{[values.baseInfo.nativePlaceDetailAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>出生地</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.birthPlaceNation]}</td>',
	'				<td class="textInfoLeft" colspan=2>{[values.baseInfo.birthPlaceProvince]}</td>',
	'				<td class="textInfoLeft" colspan=2>{[values.baseInfo.birthPlaceDetailAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>身份证签发机关</td>',
	'				<td class="textInfoLeft" colspan=2>{[values.baseInfo.idCardIssuneOffice]}</td>',
	'				<td colspan=1>身份证有效期限</td>',
	'				<td class="textInfoLeft" colspan=2>{[values.baseInfo.idCardExciptyTime]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>住址</td>',
	'				<td class="textInfoLeft" colspan=7>{[values.baseInfo.liveAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>派出所</td>',
	'				<td class="textInfoLeft" colspan=7>{[values.baseInfo.policeStation]}</td>',
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
  '',
	'	<div id="part4Div">',
	'	<table class="tb2" width=100%>',
	'		<tr>',
	'			<td colspan=6  class="textInfoLeft">以上查询信息仅作为..............</td>',
	'			<td class="textInfoRight">操作单位：</td>',
	'			<td class="textInfoLeft">XXXX</td>',
	'			<td class="textInfoRight">操作人：</td>',
	'			<td class="textInfoLeft">XXXX</td>',
	'			<td class="textInfoRight">打印日期：</td>',
	'			<td class="textInfoLeft">{[new Date().toLocaleDateString()]}</td>',
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
        height : winHeight,
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
        buttons: [{
		        scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">返回首页</span>', 
	       		icon : ctx + '/common/images/Back_light_32px.png',
		        handler: function() {
		            changzhuWin.hide();
		            var layout = infoMainPanel.getLayout();
	            	layout.setActiveItem(0);//返回首页
		        }
		    },{ 
        		scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">打印</span>', 
        		icon : ctx + '/common/images/print_32px.png',
				name : 'printBtn',
				handler: function(btn) {
		            //console.log("dayin");
					
					//记录打印状态
					var params = {
		        		//被查询人信息主键，记录打印次数用
                    	bcxrxxId : bcxrxxId,
                    	//cxbs 10：终端，20：pc端
                    	cxbs : "20",
                    	//身份证编号
						idCardNum : grid.getStore().getAt(rowIndex).data.idCardNum
		        	};
	        		var config = {
	            		url : 'information/tbcxrxx/canPrint.do',
			            params : params,
			            callback : function(canPrintResult){
			            	if(canPrintResult.canPrint){
			            		//可以打印
			            		var html = preHtml + changzhuWin.down('panel').getEl().getById("changzhuDetailDiv").getHTML()+'</body></html>';
					            var printHtml = "";
					            var htmlArray = $.parseHTML(html);
					            //console.log(htmlArray);
					            $.each( htmlArray, function( i, item ) {
					            	var delEls = $(item).find("table tr[action=子女]");
					            	if(delEls.length>0){
					            		delEls.remove();
					            		printHtml = $(item).html();
					            	}
								    //console.log(delEls);
								    //console.log($(item));
								    
								});
					            console.log(printHtml);
					            /////console.log(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv").getHTML());
								
					            printHtml = preHtml +'<div class="frame_normal" id="allDiv">'+ printHtml+'</div></body></html>';
					            //console.log(html);
					            createPrintPage(printHtml);
					            LODOP.PREVIEW();
					            
			            	}else{
			            		//超过限制，不能打印
			            		
			            		ExtUtils.error(canPrintResult.message);
			            	}
			            }
			        };
			        ExtUtils.doAjax(config);
					
					
					
					
		            
		        }
        	},{ 
        		scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">取消</span>', 
				icon : ctx + '/common/images/arrow_bold_circle_32px.png',
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
	'		<span style="FONT-SIZE: 20px!important; ">本市暂住人口信息查询表</span>',
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
	'				<td>出生日期</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.birthDate]}</td>',
	'				<td>民族</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.nation]}</td>',
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
	'		</table>',
	'	</div>',
  '',
	'	<div class="div_second_title" id="part2Div">',
	'		暂住信息',
	'	</div>',
	'	<div id="part2Table">',
	'		<table class="tbl" width=100%>',
	'			<tr>',
	'				<td width=40>序号</td>',
	'				<td>暂住证编号</td>',
	'				<td>起始日期</td>',
	'				<td>截止日期</td>',
	'				<td>间隔时间</td>',
	'				<td>签发机构</td>',
	'				<td>登记单位</td>',
	'				<td>填报日期</td>',
	'				<td>暂住地址</td>',
	'			</tr>',
	'			<tpl for="trInfoList">',
	'			<tr>',
	'				<td>{#}</td>',	
	'				<td>{trNum}</td>',
	'				<td>{startDate}</td>',
	'				<td>{endDate}</td>',
	'				<td>{intervalTime}</td>',
	'				<td>{trCardIssuneOffice}</td>',
	'				<td>{trCardCompany}</td>',
	'				<td>{fillDate}</td>',
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
	'			<td colspan=6  class="textInfoLeft">以上查询信息仅作为..............</td>',
	'			<td class="textInfoRight">操作单位：</td>',
	'			<td class="textInfoLeft">XXXX</td>',
	'			<td class="textInfoRight">操作人：</td>',
	'			<td class="textInfoLeft">XXXX</td>',
	'			<td class="textInfoRight">打印日期：</td>',
	'			<td class="textInfoLeft">{[new Date().toLocaleDateString()]}</td>',
	'		</tr>',
	'	</table>',
	'	</div>',
	'</div>'
	);
	
	
	
	//7、暂住人口信息 
    zanzhuWin = Ext.create('ZTEsoft.window.Window',{
    	id : 'card7',
    	width : 800,
        height : winHeight,
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
        buttons: [{
		        scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">返回首页</span>', 
	        	icon : ctx + '/common/images/Back_light_32px.png',
		        handler: function() {
		            zanzhuWin.hide();
		            var layout = infoMainPanel.getLayout();
	            	layout.setActiveItem(0);//返回首页
		        }
		    },{ 
        		scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">打印</span>', 
        		icon : ctx + '/common/images/print_32px.png',
				name : 'printBtn',
				handler: function(btn) {
					//记录打印状态
					var params = {
		        		//被查询人信息主键，记录打印次数用
                    	bcxrxxId : bcxrxxId,
                    	//cxbs 10：终端，20：pc端
                    	cxbs : "20",
                    	//身份证编号
						idCardNum : grid.getStore().getAt(rowIndex).data.idCardNum
		        	};
	        		var config = {
	            		url : 'information/tbcxrxx/canPrint.do',
			            params : params,
			            callback : function(canPrintResult){
			            	if(canPrintResult.canPrint){
			            		//可以打印
			            		
					            //console.log("dayin");
					            var html = preHtml + zanzhuWin.down('panel').getEl().getById("zanzhuDetailDiv").getHTML()+'</body></html>';
					            //console.log(html);
					            createPrintPage(html);
					            LODOP.PREVIEW();
			            	}else{
			            		//超过限制，不能打印
			            		
			            		ExtUtils.error(canPrintResult.message);
			            	}
			            }
			        };
			        ExtUtils.doAjax(config);
					
					
		        }
        	},{ 
        		scale   : 'large',
	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">取消</span>', 
				icon : ctx + '/common/images/arrow_bold_circle_32px.png',
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
	    items: [indexPanel,zjPanel]
    });
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [infoMainPanel]
    });

});
