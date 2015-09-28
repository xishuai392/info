Ext.onReady(function() {
    var win = Ext.create('Ext.window.Window', {
        title : 'Hello',
        height : 400,
        width : 1000,
        bodyStyle : {
            background : '#339999',
            padding : '2px'
        },
        layout : 'fit',
        items : {
            xtype : 'form',
            titleAlign : 'center',
            title : '<br><center><font size="24">testjjjjj</font></center>',
            // cls : 'shadowdiv', // 加入阴影效果
            layout : {
                type : 'table',
                columns : 4,
                tableAttrs : { // 在这儿控制table标签中的Attrs属性
                    border : 5,
                    cellpadding : 1,
                    cellspacing : 1,
                    width : '95%',
                    align : 'center',
                    style : "border:1px solid gray;border-collapse:collapse;margin:1 auto;text-align:center;"
                },
                tdAttrs : { // 控制td标签的属性，以上用法都是在ext的api中查到，同样的方式可以给tr添加属性
                    width : '100px',
                    height : '40px',
                    style : "padding:5px;border-right:1px solid;border-bottom:1px solid;",
                    valign : 'middle'
                }
            },
            defaults : {
                // applied to each contained panel
                xtype : 'label'
            },
            items : [{
                // width : 500,
                text : '单位账号'
            }, {
                // width : 250,
                xtype : 'textfield'
                // cls : 'mytextfild'
        	}, {
                text : '单位名称'
            }, {
                // width : 250,
                xtype : 'textfield',
                // rowspan : 2,
                colspan : 2
            }, {
                text : '缴纳单编号'
            }, {
                text : '中国',
                colspan : 2
            }, {
                text : '福建'
            }, {
                text : '厦门',
                colspan : 2
            }, {
                text : '暂存款'

            }, {
                text : 'ddddd',
                colspan : 3
            }]
        }
    });
    win.show();
});