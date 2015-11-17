Ext.define('ZTEsoft.window.TopWindow', {
	extend:'Ext.window.Window',
	alias:'widget.ztetopwindow',
	constructor : function(config) {
		var me = this;
		config=config||{};
		if(config.width){
			var width=config.width.toString();
			if(width.indexOf('%')>-1){
				config.width=width.substr(0,width.indexOf("%"));
				config.width=Ext.getBody().getWidth()*Number(config.width)/100;
			}
		}else{
				config.width=Ext.getBody().getWidth()*0.7;
		}
		if(config.height){
			var height=config.height.toString();
			if(height.indexOf('%')>-1){
				config.height=height.substr(0,height.indexOf("%"));
				config.height=Ext.getBody().getHeight()*Number(config.height)/100;
			}
		}else{
			config.height=Ext.getBody().getHeight();
		}
		Ext.applyIf(config,{
			closeAction:'hide',
			modal:true,
			title : '弹出窗口',
			resizable:false,
			frame : true,
			plain : true, // 背景
            constrain : true, // 限制窗口不超出浏览器边界
            modal : true,
            border : false
		});
		var iframeId = Ext.id();
		var src = '';
		if(config.src){
			src = 'src="' +config.src+ '"';
		}
		config.html = '<iframe id="'+iframeId+'" '+src+' frameborder="0" width="100%" height="100%"></iframe>';
		config.iframeId = iframeId;
		this.callParent([config]);
	}
});
