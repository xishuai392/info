<%@ page language="java" import="java.text.*,java.util.*"
	pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <%@include file="/common/common.inc.jsp"%>
        <html>

        <head>
            <title>人口信息查询</title>
            <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/common/css/info.css">
            <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/common/css/data-view.css">
            <!-- 插入jatoolsPrinter打印控件 -->
            <OBJECT ID="jatoolsPrinter" CLASSID="CLSID:B43D3361-D075-4BE2-87FE-057188254255" codebase="jatoolsPrinter.cab#version=8,6,0,0"></OBJECT>
            <!-- 华视电子BS控件V4.0 身份证读卡器 -->
            <OBJECT classid="clsid:10946843-7507-44FE-ACE8-2B3483D179B7" id="CVR_IDCard" name="CVR_IDCard" width="0" height="0"> </OBJECT>
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
                
                //本市人口信息 暂住
                zzrkPanel = Ext.create('Ext.panel.Panel', {
                    region : "north",
                    //title: '暂住信息',
                    layout: 'border',
                    height : 50,
                    tbar: [
                        '->', {
                            id: 'showSeconds',
                            scale: 'large',
                            height: 50,
                            text: '<span style="font-size:20px !important;font-family:microsoft yahei !important;">&nbsp;</span>'
                        }
                    ]
                });
                
                thirdPanel = Ext.create('Ext.panel.Panel', {
                    region : "center",
                    title: '暂住信息',
                    layout: 'border',
                    items: [Ext.create(
                            'Ext.panel.Panel', {
                                overflowY: 'scroll',
                                region: "center",
                                fitToFrame: true, 
                                html: '<iframe id="frame1" src="'+Ext.get("thirdPartyZzrkUrl").dom.value+'" frameborder="0" width="100%" height="100%"></iframe>'
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
                    Ext.getCmp('showSeconds').setText('<span style="font-size:20px !important;font-family:microsoft yahei !important;">' + times + 'S</span>');
                };
                // 判断是否超过【intervalTimes】秒无操作。
                timesReduce = function() {
                    times--;
                    console.log(times);
                    if(times>=-1){
                    	Ext.getCmp('showSeconds').setText('<span style="font-size:20px !important;font-family:microsoft yahei !important;">' + times + 'S</span>');
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