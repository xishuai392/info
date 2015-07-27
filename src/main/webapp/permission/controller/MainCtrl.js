Ext.define('PM.controller.MainCtrl', {
    extend : 'Ext.app.Controller',
    views : ['PM.view.mains.Viewport'],
    init : function() {
        Ext.create('PM.view.mains.Viewport').show();
    }
});