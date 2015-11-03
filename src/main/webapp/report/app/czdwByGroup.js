/**
 * 窗口信息查询服务统计报表
 */
Ext.onReady(function() {
    var reportStore,searchForm,reportGrid;
    var LODOP;
    
    var preHtml = '<!DOCTYPE html><html><head><meta charset="UTF-8"><title>全局窗口信息查询统计报表</title><style type="text/css">html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,input	{	margin: 0;	padding: 0;	border: 0;	font-weight: inherit;	font-style: inherit;	font-size: 100%;	font-family: Arial, Microsoft Yahei;	/**vertical-align:baseline;*/}body {	line-height: 1;	font-size: 12px;}ol,ul {	list-style: none;}.color_red {	color: #ff0900;}.color_gray {	color: #9b9b9b;}.color_bule {	color: #015a9f;}.clear {	clear: both;}.font18 {	font-size: 18px;}.font14 {	font-size: 14px;}* {	font-size: 12px !important;}</style><link rel="stylesheet" type="text/css"	href="'+webRoot+'common/css/info.css"></head><body>';
	//
	var createPrintPage = function (html) {
		LODOP = getLodop(document.getElementById('LODOP_OB'),
				document.getElementById('LODOP_EM'));
		LODOP.PRINT_INIT("人口信息打印");
		LODOP.SET_PRINT_STYLE("FontSize", 12);
		LODOP.SET_PRINT_STYLE("Bold", 1);
		LODOP.SET_PRINT_PAGESIZE(1,0,0,"A4") ; //A4纸张纵向打印
		LODOP.ADD_PRINT_HTM("0%", "0%", "100%", "100%", html);
	};
	
	reportStore = Ext.create('component.report.store.QueryCzdwByGroupStore');
	
	var orgField = Ext.create('ZTEsoft.form.field.OrgTreeField');
	
    // 1、查询框
    searchForm = Ext.create("ZTEsoft.form.SearchForm", {
    	id : 'searchFormId',
        layout : 'column',
        region : 'north',
        store : reportStore,
        frame : true,
        title : '查询条件',
        defaults : {
            labelAlign : 'right',
            labelWidth : 100,
            //xtype : 'textfield',
            style : 'margin-left:5px;margin-top:2px;margin-bottom:2px;'
        },
        items : [
        {
            fieldLabel : "开始日期",
            xtype : "datefield",
            format : 'Y-m-d',
            value : Ext.get("startDateInitId").getValue(),
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            name : "startDate"
        }, {
            fieldLabel : "结束日期",
            xtype : "datefield",
            format : 'Y-m-d',
            value : Ext.get("endDateInitId").getValue(),
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            name : "endDate"
        }, Ext.create('ZTEsoft.form.field.OrgTreeField',{
            fieldLabel : '上级单位',
            labelAlign : 'right',
            allowBlank : false,
            editable : false,
            validateOnBlur : false,
            name : 'czdw'
        })]

    });
    
    //2、显示报表结果
    reportGrid = Ext.create('Ext.grid.Panel', {
        id : 'card4',
        region : 'center',
        title : "报表结果",
        store : reportStore,
        isPage : false,
        columns : [{
            text : "单位名称",
            dataIndex : "dwmc",
            flex : 1
        },{
            text : "服务次数",
            dataIndex : "fwcs",
            flex : 1
        },{
            text : "查询次数",
            dataIndex : "cxcs",
            flex : 1
        }, {
            text : "查询成功次数",
            dataIndex : "cxcgcs",
            flex : 1
        }
        ]
    });
    
    ////创建常住人口模板
    var changzhuWinTp = new Ext.XTemplate(
	'<div class="frame_normal" id="allDiv">',
	'	<div class="div_title" id="titleDiv">',
	'		本市户籍人口信息',
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
        height : 600,
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
		            //console.log("dayin");
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
		            console.log(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv").getHTML());
					
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
	'		本市暂住人口信息查询表',
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
        height : 600,
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
    
	
    
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [searchForm,reportGrid]
    });

});
