Ext.define('ZTEsoft.layout.AutoLayout',{
	doAutoLayout:function(items,flags,width){
		var form= {width:width},fields = [];
		var me = this,config = this.config,w = width-20,offseth=0,offsetw=0,step=200,row_max_height=32;
		Ext.each(items,function(item,index){
			if(flags[index]&&flags[index]>0){
				for(var i=0;i<flags[index];i++){
					offsetw=0;offseth+=row_max_height;
					row_max_height = 32;
				}
			}
			if(item.xtype!='hidden'&&item.xtype!='hide'&&item.autoLayout){
				var width = item.width,height = item.height;
				if(item.graphInfo){
					width = item.graphInfo.width;
					height = item.graphInfo.height;
				}
				if(!width)
					width = step;
				if(offsetw+width>w){
					offsetw=0;offseth+=32;
				}
				fields.push({x:offsetw,y:offseth});
				if(height&&height>row_max_height)row_max_height = height;
				offsetw+=width+8;
			}
		});
		form.height = offseth+row_max_height+16;
		form.fields = fields.reverse();
		return form;
	}
});