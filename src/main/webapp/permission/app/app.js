Ext.Loader.setConfig({
    enabled : true
});


ZTEsoft_Application = new Ext.application({
    name : 'PM',
    appFolder : webRoot + 'permission',
    requires : [
        'PM.view.mains.Header',
        'PM.view.mains.Menu',
        'PM.view.mains.TabPanel',
        'PM.view.mains.South'],
    controllers : ['MainCtrl', 'MenuCtrl']
});
