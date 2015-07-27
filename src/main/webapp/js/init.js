Ext.BLANK_IMAGE_URL = (Ext.isIE6 || Ext.isIE7) ? 'images/s.gif' : Ext.BLANK_IMAGE_URL;
Ext.Loader.setConfig({
    enabled: true,
    disableCaching: false,
    paths: {
        'ZTEsoft': 'app',
        'ZTEsoft.business': 'component',
        'ZTEsoft.extend': 'jslibs/extend',
        'ZTEsoft.component': 'jslibs/component',
        'ZTEsoft.common': 'jslibs/common',
        'ZTEsoft.cluster': 'component/cluster',
        'ZTEsoft.srv': 'component/srv',
        'ZTEsoft.group': 'component/group',
        'ZTEsoft.host': 'component/host',
        'ZTEsoft.js': 'component/js',
        'ZTEsoft.permission': 'component/permission',
        'ZTEsoft.plugin': 'jslibs/plugin',
        'Ext.ux': 'jslibs/ext-4.2.1/examples/ux'
    }
});

// 分页数据结构
var g_pageReader = {
    // 数据格式为json
    type: 'json', // 记录属性
    root: WEBConstants.PAGE_ROOT, // 获取数据总数
    totalProperty: WEBConstants.PAGE_TOTAL
};

//ie 搓
var console = console || {
        log: function() {
            return false;
        }
    };

// 引入xtype
Ext.require([
    'ZTEsoft.component.ZTEsoftButton',
    'ZTEsoft.component.ZTEsoftForm',
    'ZTEsoft.component.ZTEsoftCollapsibleForm',
    'ZTEsoft.component.ZTEsoftCombo',
    'ZTEsoft.component.ZTEsoftDataGrid',
    'ZTEsoft.business.common.AmDomainCombo'
]);
