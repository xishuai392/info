/**
 * 人口信息查询首页
 */
Ext.onReady(function() {
    var sqrxxPanel,zjPanel,ssxzlPanel,bcxrxxPanel,bcxrStore,bcxrGrid,changzhuWin,zanzhuWin,infoMainPanel;
    
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
            name : "idCardNum"
        }, {
            fieldLabel : "证件类型",
            xtype : "combo",
            name : "indentyType",
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
            name : "name"
        },{
            fieldLabel : "查询申请人类型",
            xtype : "combo",
            name : "applicantQueryType",
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
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            name : "applicantCompany"
        },{
            fieldLabel : "查询事由",
            xtype : "textfield",
            grow      : true,
            width: 500,
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
            name : "queryResult"
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
			            callback : function(uuid){
				            	console.log("uuid:"+uuid);
				            	if(uuid.length==32){
				            		//ExtUtils.info('通过表单校验');
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
	        	
	        	var applicantQueryType = sqrxxPanel.findField('applicantQueryType').getValue();
	        	console.log(applicantQueryType);
	        	
	            //ExtUtils.info('介绍信及相关资料扫描');
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(2);//下一步：介绍信及相关资料扫描
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
	            //ExtUtils.info('被查询人信息');
	            var layout = infoMainPanel.getLayout();
	            layout.setActiveItem(3);//下一步：被查询人信息
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
            operation : WEBConstants.OPERATION.Like,// 操作类型，如果不设置，默认等于(EqualTo)
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
	            	//ExtUtils.info('通过表单校验');
	            	var layout = infoMainPanel.getLayout();
	            	layout.setActiveItem(4);//下一步：显示查询结果
	            	
	            	bcxrStore.getProxy().extraParams = {
			        	//查询日志表的id
						cxrzId : '',
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
                    	
                    	console.log("rowIndex:"+rowIndex);
                    	console.log("colIndex:"+colIndex);
                    	console.log(grid.getStore().getAt(rowIndex).data.populationType);
                    	if('户籍人口'==grid.getStore().getAt(rowIndex).data.populationType){
	                    	var config = {
					            url : '/information/queryCZRKinfo.do',
					            params : {
					            
					            },
					            callback : function(data){
					            	changzhuWin.show();
					            	console.log("changzhuWin");
					            	//重写绑定模板 
	    							//changzhuWinTp.overwrite(changzhuWin.down('panel').getEl(), tpData);
					            	changzhuWinTp.overwrite(changzhuWin.down('panel').getEl().getById("detailDiv"), data);
					            	console.log("bbbbb");
					            	console.log(changzhuWin.down('panel').getEl().getHTML());
					            	changzhuWin.down('panel').doComponentLayout();
					            	//changzhuWin.down('panel').fireEvent('resize');
					            }
					        };
					        ExtUtils.doAjax(config);
                    	}
                    	
                    	if('暂住人口'==grid.getStore().getAt(rowIndex).data.populationType){
                    		var config = {
					            url : '/information/queryZZRKinfo.do',
					            params : {
					            
					            },
					            callback : function(data){
					            	zanzhuWin.show();
					            	console.log("zanzhuWin");
					            	//重写绑定模板 
	    							//changzhuWinTp.overwrite(changzhuWin.down('panel').getEl(), tpData);
					            	zanzhuWinTp.overwrite(zanzhuWin.down('panel').getEl().getById("detailDiv"), data);
					            	console.log(zanhuWin.down('panel').getEl().getHTML());
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
	            layout.setActiveItem(3);//上一步：证件扫描
	        }
	    }]
    });
    
    
    
    
    
    ////创建常住人口模板
    var changzhuWinTp = new Ext.XTemplate(
	'<div class="frame_normal" id="allDiv">',
	'	<div class="div_title" id="titleDiv">',
	'		<h1>本市户籍人口信息</h1>',
	'	</div>',
	'	<div class="div_second_title" id="part1Div">',
	'		<h1>人员基本信息</h1>',
	'	</div>',
	'	<div id="part1Table">',
	'		<table class="tbl" width=1024>',
	'			<tr>',
	'				<td width=100>姓名</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.name]}</td>',
	'				<td>曾用名</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.aliaName]}</td>',
	'				<td>性别</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.sex]}</td>',
	'				<td colspan=2 rowspan=6 width=160><img alt="照片" ',
	'					src="{[values.baseInfo.photoGif]}"></td>',
	'			</tr>',
	'			<tr>',
	'				<td>民族</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.nation]}</td>',
	'				<td>出生日期</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.birthDate]}</td>',
	'				<td>公民身份证号码</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.idCardNum]}</td>',
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
	'		<h1>家庭关系及联系人信息</h1>',
	'	</div>',
	'	<div id="part2Table">',
	'		<table class="tbl" width=1024>',
	'			<tr>',
	'				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>',
	'				<td>关系</td>',
	'				<td>公民身份证号码</td>',
	'				<td>姓名</td>',
	'				<td>证件种类</td>',
	'				<td>证件号码</td>',
	'				<td>外文姓</td>',
	'				<td>外文名</td>',
	'				<td>联系电话</td>',
	'			</tr>',
	'			<tpl for="familyInfoList">',
	'			<tr>',
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
	'		<h1>迁移信息</h1>',
	'	</div>',
	'	<div id="part3Table">',
	'		<table class="tbl" width=1024>',
	'			<tr>',
	'				<td width=150>何时何因由何地迁来本市(县)</td>',
	'				<td colspan=7 class="textInfoLeft">{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td width=150>何时何因由何地迁来本址</td>',
	'				<td colspan=7 class="textInfoLeft">{[values.migrateInfo.timeAndResultForMigrateLocal]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td width=150>何时何因迁往何地</td>',
	'				<td colspan=7 class="textInfoLeft">{[values.migrateInfo.timeAndResultForMigrateOtherPlace]}</td>',
	'			</tr>',
	'		</table>',
	'	</div>',
  '',
	'	<div id="part4Div">',
	'	<table class="tb2" width=1024>',
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
	changzhuWinTp.compile( ) ;
    
	
	//6、本市户籍人口信息 常住
    changzhuWin = Ext.create('ZTEsoft.window.Window',{
    	id : 'card5',
    	width : '900',
        height : '700',
        layout : 'fit',
        closeAction : 'hide',
        maximized : true,
        maximizable : true,
        items : [Ext.create('Ext.panel.Panel',{
        		tpl : changzhuWinTp,
	        	overflowY :'scroll',
	        	html : '<div id="detailDiv"></div>'
        	}
        )],
        resizable : true,
        buttons: [{ 
        		text: '打印' ,
        		icon : ctx + '/common/images/icons/printer.png',
				name : 'printBtn',
				handler: function(btn) {
		            console.log("dayin");
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
    
    
    
    ////创建常住人口模板
    var zanzhuWinTp = new Ext.XTemplate(
	'<div class="frame_normal" id="allDiv">',
	'	<div class="div_title" id="titleDiv">',
	'		<h1>本市暂住人口信息查询表</h1>',
	'	</div>',
	'	<div class="div_second_title" id="part1Div">',
	'		<h1>人员基本信息</h1>',
	'	</div>',
	'	<div id="part1Table">',
	'		<table class="tbl" width=1024>',
	'			<tr>',
	'				<td>公民身份证号码</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.idCardNum]}</td>',
	'				<td width=100>姓名</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.name]}</td>',
	'				<td colspan=2 rowspan=6 width=160><img alt="照片" ',
	'					src="{[values.baseInfo.photoGif]}"></td>',
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
	'				<td>&nbsp;&nbsp;</td>',
	'				<td>国家(地区)</td>',
	'				<td colspan=2>省市县(区)</td>',
	'				<td colspan=2>详址</td>',
	'			</tr>',
	'			<tr>',
	'				<td>籍贯</td>',
	'				<td class="textInfoLeft">{[values.baseInfo.nativePlace]}</td>',
	'				<td class="textInfoLeft" >&nbsp;</td>',
	'				<td class="textInfoLeft" >&nbsp;</td>',
	'			</tr>',
	'			<tr>',
	'				<td>户籍地址省市县（区）</td>',
	'				<td class="textInfoLeft" colspan=3>{[values.baseInfo.householdRegisterProviceAddress]}</td>',
	'			</tr>',
	'			<tr>',
	'				<td>户籍详细地址</td>',
	'				<td class="textInfoLeft" colspan=1>{[values.baseInfo.householdRegisterDetailAddress]}</td>',
	'			</tr>',
	'		</table>',
	'	</div>',
  '',
	'	<div class="div_second_title" id="part2Div">',
	'		<h1>暂住信息</h1>',
	'	</div>',
	'	<div id="part2Table">',
	'		<table class="tbl" width=1024>',
	'			<tr>',
	'				<td>序号</td>',
	'				<td>暂住证编号</td>',
	'				<td>起始日期</td>',
	'				<td>截止日期</td>',
	'				<td>间隔时间</td>',
	'				<td>签发机构</td>',
	'				<td>登记单位</td>',
	'				<td>填报日期</td>',
	'				<td>暂住地址</td>',
	'			</tr>',
	'			<tpl for="familyInfoList">',
	'			<tr>',
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
  '',
	'	<div id="part3Div">',
	'	<table class="tb2" width=1024>',
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
	
	
	
	//7、本市户籍人口信息 暂住
    zanzhuWin = Ext.create('ZTEsoft.window.Window',{
    	id : 'card7',
    	width : '900',
        height : '700',
        layout : 'fit',
        maximized : true,
        maximizable : true,
        items : [Ext.create('Ext.panel.Panel',{
	        	overflowY :'scroll',
	        	html : '<div id="detailDiv"></div>'
        	}
        )],
        resizable : true,
        buttons: [{ 
        		text: '打印' ,
        		icon : ctx + '/common/images/icons/printer.png',
				name : 'printBtn',
				handler: function(btn) {
		            console.log("dayin");
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
