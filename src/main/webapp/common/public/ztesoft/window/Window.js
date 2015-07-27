/**
 * @description 窗口，设置一些通用属性
 */

Ext.define("ZTEsoft.window.Window", {
    extend : "Ext.window.Window",
    alias : "widget.ztewindow",
    constructor : function(config) {
        config = config || {};
        // default config
        var defaultConfig = {
            plain : true, // 背景
            constrain : true, // 限制窗口不超出浏览器边界
            modal : true,
            border : false
        };

        Ext.apply(config, defaultConfig);

        this.callParent([config]);
    }
});
