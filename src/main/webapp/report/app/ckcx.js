/**
 * 窗口信息查询服务统计报表
 */
Ext.onReady(function() {
    var reportStore,searchForm,reportGrid;
    var LODOP;
    
    var preHtml = '<!DOCTYPE html><html><head><meta charset="UTF-8"><title>统计报表</title><style type="text/css">html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,input	{	margin: 0;	padding: 0;	border: 0;	font-weight: inherit;	font-style: inherit;	font-size: 100%;	font-family: Arial, Microsoft Yahei;	/**vertical-align:baseline;*/}body {	line-height: 1;	font-size: 12px;}ol,ul {	list-style: none;}.color_red {	color: #ff0900;}.color_gray {	color: #9b9b9b;}.color_bule {	color: #015a9f;}.clear {	clear: both;}.font18 {	font-size: 18px;}.font14 {	font-size: 14px;}* {	font-size: 12px !important;}</style><link rel="stylesheet" type="text/css"	href="'+webRoot+'common/css/info.css"></head><body>';
	preHtml += '<div class="frame_normal" id="allDiv">'+
    '	<div class="div_title" id="titleDiv">'+
	'		<span style="FONT-SIZE: 20px!important; ">窗口信息查询服务统计报表<span>'+
	'	</div>';
	var part1TableHtml = 
    '	<div id="part1Table">'+
	'		<table class="tbl" width=100%>';
    
    
    var lastHtml = "</table></div></div></body></html>";
    //
	var createPrintPage = function (html) {
		LODOP = getLodop(document.getElementById('LODOP_OB'),
				document.getElementById('LODOP_EM'));
		LODOP.SET_PREVIEW_WINDOW(1,3,1,0,0, "预览查看.开始打印");
		
		LODOP.PRINT_INIT("窗口信息查询服务统计报表打印");
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
	
	reportStore = Ext.create('component.report.store.QueryCkcxStore');
	
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
            editable : false,
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            name : "startDate"
        }, {
            fieldLabel : "结束日期",
            xtype : "datefield",
            format : 'Y-m-d',
            vtype : "compare",
            target : 'startDate',
            value : Ext.get("endDateInitId").getValue(),
            editable : false,
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            name : "endDate"
        }, {
            fieldLabel : "默认操作单位",
            xtype : "textfield",
            value : Ext.get("defaultCzdwId").getValue(),
            editable : false,
            hidden : true,
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.EqualTo,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            name : "czdw"
        }
//        ,Ext.create('ZTEsoft.form.field.OrgTreeField',{
//            fieldLabel : '操作单位',
//            labelAlign : 'right',
//            allowBlank : false,
//            editable : false,
//            value : Ext.get("defaultCzdwId").getValue(),
//            validateOnBlur : false,
//            name : 'czdw'
//        })
        ]

    });
    
     var testTp = new Ext.XTemplate(
     '		<table class="tbl" width=100%>',
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
		'		</table>'
    );
    

    
    
    
    
    //2、显示报表结果
    reportGrid = Ext.create('Ext.grid.Panel', {
        id : 'reportGridId',
        region : 'center',
        //title : "报表结果",
        store : reportStore,
        isPage : false,
        tbar : [{
        	text: '打印',
        	iconCls : 'printer',
		  	handler: function(btn) {
	            printGrid();
		  	}
        }],
        columns : [{
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
    
    
    //打印报表 
	var printGrid = function () {

		var grid = reportGrid;
		var tableStr = '<tr>';
		
//		console.log(grid.columns);
		var cms = grid.columns;
		var colCount = cms.length;
		var temp_obj = new Array();
		// 只下载没有隐藏的列(isHidden()为true表示隐藏,其他都为显示)  
		// 临时数组,存放所有当前显示列的下标  
		for (var i = 0; i < colCount; i++) {//从第三列开始，因为我的第1、2列是分别是rownumber和selectmodel。  
			if (cms[i].isHidden(i) == true) {
				
			} else {
				temp_obj.push(cms[i]);
			}
		}
		//	        tableStr = tableStr + '<tr><td>序号</td>';  
		for (var i = 0; i < temp_obj.length; i++) {
			// 显示列的列标题  
			tableStr = tableStr + '<td>' + temp_obj[i].text
					+ '</td>';
		}
		tableStr = tableStr + '</tr>';
		var store = grid.getStore();
		var recordCount = store.getCount();
		if(recordCount==0){
			ExtUtils.info('请您先执行查询，再打印！');
			return false;
		}
		
		for (var i = 0; i < recordCount; i++) {
			var record = store.getAt(i);
			for (var j = 0; j < temp_obj.length; j++) {
				var dataIndex = temp_obj[j].dataIndex;
				var tdValue = record.get(dataIndex);
				var rendererFunc = temp_obj[j].renderer;
				if(Ext.isFunction(rendererFunc)){
					tdValue = rendererFunc(tdValue);
				}
				if (tdValue == null) {
					tdValue = '';
				}
				tableStr = tableStr + '<td>' + tdValue + '</td>';
			}
			tableStr = tableStr + '</tr>';
		}
		var conditionHtml = '	<div id="part3Div">'+
	'	<table class="tb2" width=100%>'+
	'		<tr>'+
	'			<td colspan=2  class="textInfoRight">起止时间：</td>'+
	'			<td colspan=4 class="textInfoLeft">'+searchForm.getForm().findField('startDate').getRawValue()+' 至 '+searchForm.getForm().findField('endDate').getRawValue()+'</td>'+
	'			<td class="textInfoLeft">&nbsp;</td>'+
	'			<td class="textInfoLeft">&nbsp;</td>'+
	'			<td class="textInfoLeft">&nbsp;</td>'+
	'			<td colspan=2 class="textInfoRight">操作单位：</td>'+
	'			<td colspan=4 class="textInfoLeft">'+searchForm.getForm().findField('czdw').getRawValue()+'</td>'+
	'		</tr>' +
	'	</table>' +
	'	</div>';
		var printHtml = preHtml + conditionHtml + part1TableHtml + tableStr + lastHtml;
		
		//console.log(printHtml);
		createPrintPage(printHtml);
		LODOP.PREVIEW();
	};
	
	var printGrid222 = function () {

		//var grid = Ext.getCmp('stat1_grid');
//		var grid = Ext.getCmp('reportGridId');
		var grid = reportGrid;
		var tableStr = '<table width="100%" border=1>';
		console.log(grid.columns);
		var cm = grid.getColumnModel();
		var colCount = cm.getColumnCount();
		
		
		var temp_obj = new Array();
		// 只下载没有隐藏的列(isHidden()为true表示隐藏,其他都为显示)  
		// 临时数组,存放所有当前显示列的下标  
		for (var i = 1; i < colCount; i++) {//从第三列开始，因为我的第1、2列是分别是rownumber和selectmodel。  
			if (cm.isHidden(i) == true) {
			} else {
				temp_obj.push(i);
			}
		}
		//	        tableStr = tableStr + '<tr><td>序号</td>';  
		for (var i = 0; i < temp_obj.length; i++) {
			// 显示列的列标题  
			tableStr = tableStr + '<td>' + cm.getColumnHeader(temp_obj[i])
					+ '</td>';
		}
		tableStr = tableStr + '</tr>';
		var store = grid.getStore();
		var recordCount = store.getCount();
		for (var i = 0; i < recordCount; i++) {
			var r = store.getAt(i);
			//	            tableStr = tableStr + '<tr><td>' + (i + 1) + '</td>';  
			for (var j = 0; j < temp_obj.length; j++) {
				var dataIndex = cm.getDataIndex(temp_obj[j]);
				var tdValue = r.get(dataIndex);
				var rendererFunc = cm.getRenderer(temp_obj[j]);
				if (rendererFunc != null) {
					tdValue = rendererFunc(tdValue);
				}
				if (tdValue == null) {
					tdValue = '';
				}
				tableStr = tableStr + '<td>' + tdValue + '</td>';
			}
			tableStr = tableStr + '</tr>';
		}
		tableStr = tableStr + '</table>';
		var titleHTML = tableStr;// document.getElementById("printGridfff").innerHTML;  
		console.log(titleHTML);
//		var newwin = window.open('printer.jsp', '', '');
//
//		newwin.document.write(titleHTML);
//		newwin.document.location.reload();
//		newwin.print();
//		newwin.close();
	};
	
    
	
    
	
    
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [searchForm,reportGrid]
    });

});
