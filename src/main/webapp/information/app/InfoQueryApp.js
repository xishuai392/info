/**
 * 人口信息查询首页
 */
Ext.onReady(function() {
    var sqrxxPanel,zjPanel,ssxzlPanel,bcxrxxPanel,bcxrStore,bcxrGrid,changzhuWin,zanzhuWin,infoMainPanel;
    var LODOP;
    
    var preHtml = '<!DOCTYPE html><html><head><meta charset="UTF-8"><title>人口信息打印</title><style type="text/css">html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,input	{	margin: 0;	padding: 0;	border: 0;	font-weight: inherit;	font-style: inherit;	font-size: 100%;	font-family: Arial, Microsoft Yahei;	/**vertical-align:baseline;*/}body {	line-height: 1;	font-size: 12px;}ol,ul {	list-style: none;}.color_red {	color: #ff0900;}.color_gray {	color: #9b9b9b;}.color_bule {	color: #015a9f;}.clear {	clear: both;}.font18 {	font-size: 18px;}.font14 {	font-size: 14px;}* {	font-size: 12px !important;}</style><link rel="stylesheet" type="text/css"	href="'+webRoot+'common/css/info.css"></head><body>';
    
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
            afterSubTpl : WEBConstants.REQUIRED,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            allowBlank : false,
            width: 500,
            name : "zjh"
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
            store : new Ext.data.ArrayStore({
                fields : ['value', 'text'],
                data : [['10', '身份证'], ['20', '其他']]
            })
        },{
            fieldLabel : "姓名",
            xtype : "textfield",
            allowBlank : false,
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
            value : '50',
            store : new Ext.data.ArrayStore({
                fields : ['value', 'text'],
                data : [['10', '律师'],['20', '党政军机关'],['30', '司法机关'],
                	['40', '企事业单位'],['50', '个人'], ['60', '人民团体'],
                	['70', '其他']]
            })
        },{
            fieldLabel : "申请查询人单位",
            xtype : "textfield",
            name : "cxrdw"
        },{
            fieldLabel : "查询事由",
            xtype : "textfield",
            grow      : true,
            width: 500,
            name : "cxsy"
        },{
            fieldLabel : "cxbs",//查询标示
            xtype : "textfield",
            value : '20',
            hidden : true,
            name : "cxbs"
        },{
            fieldLabel : "mainId",//申请人信息表主键
            xtype : "textfield",
            width: 500,
            hidden : true,
            name : "mainId"
        }],
        // 重置 和下一步 按钮.
	    buttons: [{
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
				            		sqrxxPanel.getForm().findField('mainId').setValue(uuid);
					            	var layout = infoMainPanel.getLayout();
					            	//layout.setActiveItem(1);//下一步：证件扫描
					            	layout.setActiveItem(1);
				            	}
			            }
			        };
			        ExtUtils.doAjax(config);
	            }
	        }
	    }]

    });
    
    //2、证件扫描
    zjPanel = Ext.create('Ext.Panel', { 
	    title: '证件扫描', 
	    id : 'card1', 
	    frame : true,
	    items: [],
	    tbar: [ {
	        text: '开始扫描', 
	        handler: function(){
	        	ExtUtils.info('开始扫描证件');
	        } 
	    }],
	    buttons: [{
	        text: '第一步',
	        iconCls: "x-tbar-page-first",
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：填写申请人信息
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
	        	var params = {
	        		//查询日志表的id
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
	        }
	    }]
    });
    
    //3、介绍信及相关资料扫描
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
					//TODO
					
	        	};
            	var config = {
		            //TODO 
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
        title : '被申请人信息',
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
            afterSubTpl : WEBConstants.REQUIRED,
            allowBlank : false,
            width: 500,
            name : "idCardNum"
        }],
        // 重置 和下一步 按钮.
	    buttons: [{
	        text: '第一步',
	        iconCls: "x-tbar-page-first",
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：填写申请人信息
	        }
	    },{
	        text: '上一步',
	        iconCls : 'x-btn-icon-el x-tbar-page-prev',
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(2);//上一步：介绍信及相关资料扫描
	        }
	    },{
	        text: '重置',
	        icon : ctx + '/common/images/icons/arrow_rotate_anticlockwise.png',
	        handler: function() {
	            this.up('form').getForm().reset();
	        }
	    },{
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
			        	//查询日志表的id
						cxrzId : sqrxxPanel.getForm().findField('mainId').getValue(),
						//被查询人的身份证信息
						idCardNum : bcxrxxPanel.getForm().findField("idCardNum").getValue()
				
			        };
			        bcxrStore.load();
	            }
	        }
	    }]
    });
    
    bcxrStore = Ext.create('component.information.store.QueryResultInfoStore');
    
    //5、显示被查询人表格信息
    bcxrGrid = Ext.create('Ext.grid.Panel', {
        id : 'card4',
        title : "被查询人信息",
        store : bcxrStore,
        isPage : false,
        columns : [{
            text : "被查询人ID",
            dataIndex : "bcxrxxId",
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
                    	if('户籍人口'==grid.getStore().getAt(rowIndex).data.populationType){
	                    	var config = {
					            url : 'information/queryCZRKinfo.do',
					            params : {
					            	//查询日志表的id
									sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
					            	bcxrxxId :grid.getStore().getAt(rowIndex).data.bcxrxxId,
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
					            	console.log(changzhuWin.down('panel').getEl().getById("changzhuDetailDiv").getHTML());
					            	//changzhuWin.down('panel').doComponentLayout();
					            	//console.log("getSize:"+Ext.encode(changzhuWin.down('panel').getSize( )) );
					            	//console.log("getHeight:"+changzhuWin.down('panel').getHeight( ) );
					            	//console.log("getPosition:"+changzhuWin.down('panel').getPosition( ) );
					            	//changzhuWin.down('panel').fireEvent('resize');
					            }
					        };
					        ExtUtils.doAjax(config);
                    	}
                    	
                    	if('暂住人口'==grid.getStore().getAt(rowIndex).data.populationType){
                    		var config = {
					            url : 'information/queryZZRKinfo.do',
					            params : {
					            	//查询日志表的id
									sqrxxId : sqrxxPanel.getForm().findField('mainId').getValue(),
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
                    	
        
                    	
                    } 
                }
            ]  
        } 
        ],
        buttons: [{
	        text: '第一步',
	        iconCls: "x-tbar-page-first",
	        handler: function() {
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(0);//第一步：填写申请人信息
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
	        text: '« 上一步', 
	        disabled : true,
	        handler: Ext.Function.bind(cardNav, this, [-1]) 
	    }, { 
	        id: 'cardNext', 
	        text: '下一步 »', 
	        handler: Ext.Function.bind(cardNav, this, [1]) 
	    }]
	    */
    });
    
    // 整体页面布局
    Ext.create('Ext.container.Viewport', {
        layout : 'border',
        items : [infoMainPanel]
    });

});
