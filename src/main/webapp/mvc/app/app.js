Ext.application({
    name : 'AM',
    appFolder : webRoot + "/mvc",// 应用的目录,必须以这样的形式配置
    // automatically create an instance of AM.view.Viewport
    autoCreateViewport : true,

    controllers : ['Users']
});
