Ext.define('PM.view.mains.South',{
    extend: 'Ext.Toolbar',
    alias: 'widget.ztesouth',
    initComponent : function(){
        Ext.apply(this,{
            id:"bottom",
            //frame:true,
            region:"south",
            height:23,
            collapsed:true,
            items:["当前用户：Guest",'->',"版权所有...&nbsp;&nbsp;"]
        });
        this.callParent(arguments);
    }
});