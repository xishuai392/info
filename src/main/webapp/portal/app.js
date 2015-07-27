constans={};//全局常量声明
requirejs.config({
    baseUrl:webRoot+'portal',
    paths: {
        app: webRoot+'portal/app'
    }
});
requirejs(['app/main']);
