<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <%@include file="/common/common.inc.jsp"%>
        <html>

        <head>
            <title>人口信息查询</title>
            <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/common/css/info.css">
            
      <style type="text/css">
		.btnQueryCls {
			background-image: url(../common/images/btn_bg.jpg) !important;
			line-height: 17px;
			font-family:"Microsoft Yahei";
			font-size: 14px;
			font-style: normal;
			/*font-weight: bold;*/
			color: red;
		}
		
		/* 设置button透明 */
		.btntransparent {
			filter: alpha(opacity = 0);
			-moz-opacity: 0;
			-khtml-opacity: 0;
			opacity: 0.5;
			width: 76px;
			height: 32.8px;
			z-index: 11;
		}

		.bgbtn {
            background-image: url(../common/images/btn_bg.jpg) !important;
            width: 320px;
            height: 50px;
            border-width: 0;
            background-color: transparent;
        }
 
        .btnQueryCls .x-frame-ml, .btnQueryCls .x-frame-mc, .btnQueryCls .x-frame-mr,
        .btnQueryCls .x-frame-tl, .btnQueryCls .x-frame-tc, .btnQueryCls .x-frame-tr,
        .btnQueryCls .x-frame-bl, .btnQueryCls .x-frame-bc, .btnQueryCls .x-frame-br {
            background-image: none;
            background-color: transparent;
        }
        
        .tbarCls{
			background-image: none; 
			filter: alpha(opacity = 0);
			-moz-opacity: 0;
			-khtml-opacity: 0;
			opacity: 0.9;
		}
        
		.btnIndexCls{
			background-image: url(../../common/images/Back_light_48px.png)!important; 
		}
		
		.platesbgimage { 
		   background:url(../common/images/plates_bg.jpg ) no-repeat left top; 
		   position:absolute; 
		   height:282px; 
		   width:960px;
		} 
		.ex-panel{border-style:solid;border-color:transparent;border-width:0;} 
		
		</style>
            
            <script type="text/javascript" language="javascript">
            function iFrameHeight() {
                var ifm = document.getElementById("iframepage");
                var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
                if (ifm != null && subWeb != null) {
                    ifm.height = subWeb.body.scrollHeight;
                    ifm.width = subWeb.body.scrollWidth;
                }
            }
            </script>
            <script type="text/javascript">
            Ext.onReady(function() {

                var zzrkPanel,thirdPanel;
                Ext.util.CSS.swapStyleSheet('theme', webRoot + 'common/jslibs/extjs/ext-4.2.1/resources/ext-theme-gray/ext-theme-gray-all.css');

                //按钮高度、宽度
                var btnHeight = 80;
                var btnWidth = 130;
                
                var topTbar = Ext.create('Ext.toolbar.Toolbar', {
            	    //cls : 'tbarCls',
            	    items: ['->', {
                        id: 'showSeconds',
                        scale: 'large',
                        height: 50,
                        text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">&nbsp;</span>'
                    	}
            	    ]
            	});
                
                //本市人口信息 暂住
                zzrkPanel = Ext.create('Ext.panel.Panel', {
                    region : "north",
                    //title: '暂住信息',
                    layout: 'border',
                    height : 60,
                    cls : 'platesbgimage',//设置页面背景的CSS
                   	baseCls : 'ex-panel',//设置透明FORM 嵌入页面
                    tbar: topTbar
                });
                
                thirdPanel = Ext.create('Ext.panel.Panel', {
                    region : "center",
                    //title: '暂住信息',
                    layout: 'border',
                    cls : 'platesbgimage',//设置页面背景的CSS
                   	baseCls : 'ex-panel',//设置透明FORM 嵌入页面
                    items: [Ext.create(
                            'Ext.panel.Panel', {
                                overflowY: 'scroll',
                                region: "center",
                                fitToFrame: true, 
                                html: '<iframe id="zzrkIframe" src="'+Ext.get("thirdPartyZzrkUrl").dom.value+'" frameborder="0" width="100%" height="100%"></iframe>'
                            })
                    ],
                    buttonAlign : 'center',
                    buttons: [
                        { 
                    		scale   : 'large',
            	       		text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">关闭</span>', 
                    		icon : ctx + '/common/images/X_close_32px.png',
                    		//text : '关闭',
            				//iconCls : 'close',
            				height : btnHeight,
        					width : btnWidth,
            				name : 'closeBtn',
            				cls : 'btnQueryCls',
            				handler : function(){
            					window.close();
            				}
                    	}
                    ]
                });
                
                
                // 整体页面布局
                Ext.create('Ext.container.Viewport', {
                    layout : 'border',
                    items : [zzrkPanel,thirdPanel]
                });

                //TODO @惜帅  定义时间初始时间为60秒
                var intervalTimes = 60;
                var times = intervalTimes;
                // 该方法用于重置时间
                defaultTimes = function() {
                    // 测试弹出
                    times = intervalTimes;
                    Ext.getCmp('showSeconds').setText('<span style="font-size:20px !important;font-family:microsoft yahei !important;">距退出系统还有' + times + '秒</span>');
                };
                // 判断是否超过【intervalTimes】秒无操作。
                timesReduce = function() {
                    times--;
                    console.log(times);
                    if(times>=-1){
                    	Ext.getCmp('showSeconds').setText('<span style="font-size:20px !important;font-family:microsoft yahei !important;">距退出系统还有' + times + '秒</span>');
                    }
                    
                    //每5秒，主动释放一次内存
                    if(times%5==2){
                    	if(times <= 2){
                    		var frame = document.getElementById("zzrkIframe");
                    		frame.src = 'about:blank';
                    	}
                    	
                    	if (navigator.userAgent.indexOf('MSIE') >= 0) {
                        	if (CollectGarbage) {
                        	//alert(1)
                        	CollectGarbage(); //IE 特有 释放内存
                        	}
                        }
                    }
                    
                    // alert(times);
                    if (times <= 0) {
                        // alert('跳转');
                        // 执行跳转
                        if (Ext.Msg.isVisible()) {
                            Ext.Msg.hide();
                        }
                        
                        //window.close();
                        //CloseBrowser();
                        CloseWebPage();
                    }
                };
                window.setInterval('timesReduce()', 1000);

                // 整体页面布局
                //Ext.create('Ext.container.Viewport', {
                //    layout : 'border',
                //    items : [zzrkPanel]
                //});
            });
            </script>
            
            <script type="text/javascript"
				src="${ctx}/information/app/common.js">
			</script>
        </head>

        <body>
            <input id="thirdPartyZzrkUrl" type="hidden" value="${thirdPartyZzrkUrl}">
            <input id="idCardNum" type="hidden" value="${idCardNum}">
            <input id="bcxrxxId" type="hidden" value="${bcxrxxId}">
            <input id="populationType" type="hidden" value="${populationType}">
            <input id="sqrxxId" type="hidden" value="${sqrxxId}">
            <input id="cxbs" type="hidden" value="${cxbs}">
            <div id='tipDiv' style="width: 100%; height: 80"></div>
            <div id='thirdDiv' style="width: 100%; height: 90%">
            </div>
            <div id="doccameraOcx"></div>
        </body>

        </html>