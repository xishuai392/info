Ext.define('component.permission.view.UserRoleWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.userrolewindow',
    requires: ['Ext.ux.form.ItemSelector'],
    modal: true,
    config:{
    	
	},
    toValues: null,
    userId :null,
    title : null,
    iconCls : 'addRole',
    closeAction : 'destroy',
    initComponent: function() {
        var me = this;
        
        Ext.applyIf(me, {
            layout: 'fit',
            autoShow: true,
            width: 700,
            height: 360,
            
            items: [{
            	xtype: 'container',
            	layout: 'border',
                border: false
            }],
                        
			dockedItems: [{
                xtype: 'toolbar',
                dock: 'bottom',
                ui: 'footer',
                defaults: {minWidth: 75},
                items: ['->', {
                    icon : ctx + '/common/images/icons/accept.png',
                    itemId: 'save',
                    text: '保存',
                    action: 'save',
                    handler : function(btn ,eventObj){
                    	var win = btn.up('window');
						var itemSelector = btn.up('userrolewindow').down('itemselector');
						var newValue = itemSelector.getValue(),
							oldValue = [];
						
						Ext.LoadMask(win).show();
						ExtUtils.doAjax({
							url: 'permission/audituserrole/updateUserRole.do',
					        params: {
					        	userId	: win.userId,
					            addListJSON	: Ext.JSON.encode(newValue),
					            delListJSON	: Ext.JSON.encode(win.toValues)
					        },
					        callback: function (result) {
					        	ExtUtils.info('分配用户角色成功！');
				                Ext.LoadMask(win).close();
					        }
						});
                    }
                },{
                    icon : ctx + '/common/images/icons/arrow_undo.png',
                    text: '取消',
                    scope: this,
                    handler: this.close
                }]
            }]
        });
        
        me.callParent(arguments);
    },
    
    flushView: function () {
        this.doLayout();
    },

    loadView: function () {    	
    	var me = this;
    	var containerCmp = this.getComponent(0);
    	
	    var isForm = Ext.widget('form', {
	    	title : '分配用户角色',
	    	header : false,
	        width: 690,
	        bodyPadding: 10,
	        height: 300,
	        layout: 'fit',
	        items:[{
		        xtype: 'hiddenfield',
		        id: 'userRoleOldValue',
		        name: 'text_field'
		    }, {
	            xtype: 'itemselector',
	            name: 'itemselector',
	            id: 'itemselector-field',
	            anchor: '100%',
	            store: Ext.create('component.permission.store.AuditRoleStore',{
	            	autoLoad : true,
	            	proxy : {
		            	type: 'ajax',
			            url : webRoot + '/permission/auditrole/qryRecordList.do',
			            reader: {
			            	type: 'json'
			            }
				    }
	            }),
	            displayField: 'roleName',
	            valueField: 'roleId',
	            value: me.toValues,
	            buttons : ['add', 'remove'],
	            //buttons: ['top', 'up', 'add', 'remove', 'down', 'bottom'],
	            msgTarget: 'side',
	            fromTitle: '未选角色',
	            toTitle: '已选角色',
	            autoScroll : true,
	            listeners: {
			        click: {
			            element: 'el', //bind to the underlying el property on the panel
			            fn: function(){ console.log('click el'); }
			        },
			        dblclick: {
			            element: 'body', //bind to the underlying body property on the panel
			            fn: function(){ console.log('dblclick body'); }
			        }
			        ,
			        add: {
			            element: 'body', //bind to the underlying body property on the panel
			            fn: function(){ console.log('dblclick body'); }
			        }
			    }

	        }]
	        
	    });
    	
    	containerCmp.add(isForm);
    }
});
