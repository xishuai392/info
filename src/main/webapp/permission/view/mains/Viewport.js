Ext.define('PM.view.mains.Viewport', {
    extend : 'Ext.Viewport',
    layout : 'fit',
    id : 'vp',
    hideBorders : true,
    requires : ['PM.view.mains.Header', 'PM.view.mains.Menu', 'PM.view.mains.TabPanel', 'PM.view.mains.South'],
    initComponent : function() {
        var me = this;

        // 基本布局
        var topHTML1 = '<div class="top-banner">' + '<div class="user-info"></div>' + '<div class="title"></div>' + '<span class="show-time" id="show_time"></span>'
                + '<div class="slice"></div>' + '<div class="top-tool-bar" id="topToolBar">' + '<a id="tool-a"></a>' + '<a id="tool-b"></a>' + '<a id="tool-c"></a>' + '</div>'
                + '</div>' + '<h1>阳光计费稽核系统</h1>';

        var topHTML = '<Div class="login_contact">'
                + '<div class="main_head">'
                + '<div class="main_logo"></div>'
                + '<div class="main_rightnav">'
                + ' <div class="main_esc">用户名：'
                + '<a  href="#" class="main_esc_ico"></a>退出</div>'
                + ' <div class="main_right_nav"> <a href="#" class="main_right_nav1"></a> <a href="#" class="main_right_nav2"></a> <a href="#" class="main_right_nav3"></a> <a href="#" class="main_right_nav4"></a> </div>'
                + ' <div class="clear"></div>' + ' </div>' + '</div>' + '</div>'

        var mainHTML = '<div class="main-block" id="main_content">' + '<div class="top-bg"></div>' + '<div class="btm-bg"></div>' + '<div class="bg-btm-left"></div>'
                + '<div class="bg-btm-right"></div>' + '<div class="bg-left"></div>' + '<div class="bg-right"></div>' + '</div>';

        var footerHTML = '<div class="footer"></div>';

        Ext.apply(me, {
            items : [{
                id : 'desk',
                layout : 'border',
                frame : true,
                items : [{
                    xtype : 'zteheader'
                    // region : 'north',
                // height : 59,
                // bodyStyle : 'border-bottom:0',
                // html : '<iframe scrolling="auto" frameborder="0" width="100%"
                // height="100%" src="' + webRoot +
                // '/permission/jsp/top.jsp"></iframe>'
            }   , {
                    xtype : 'ztemenu',
                    region : 'west'
                }, {
                    xtype : 'ztetabpanel',
                    id : 'main_center_region',
                    region : 'center'
                }
                // ,
                // {
                // xtype : 'ztesouth',
                // region : 'south',
                // height : 31,
                // html : footerHTML
                // }

                ]
            }]
        });
        me.callParent(arguments);
    },
    showWin : function() {
        var myProfileWin = Ext.create('PM.view.permission.AmUserPersonalWin');
        myProfileWin.show();
    }
});