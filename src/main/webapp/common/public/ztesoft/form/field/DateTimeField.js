Ext.define('ZTEsoft.form.field.DateTimeField', {
	  extend: 'Ext.form.field.Date',
	  alias: ['widget.ztedatetimefield', 'widget.datetimefield'],
	  requires: ['ZTEsoft.picker.DateTimePicker'],
	
	  constructor:function(config){
	  	config=config||{};
	  	Ext.applyIf(config,{
	  		format:'Y-m-d H:i:s',
//	  		width:150,
	  		editable:false
	  	});
	  	if(config.clear){
	  		config.trigger2Cls=Ext.baseCSSPrefix + 'form-clear-trigger';
	  	}
		this.callParent([config]);
	  },
	  onTrigger2Click : function() {
		    this.setValue(null);
	  },
	  // overwrite
	  createPicker: function() {
		  var me = this,
			  format = Ext.String.format;

		  return Ext.create('ZTEsoft.picker.DateTimePicker', {
			    ownerCt: me.ownerCt,
			    renderTo: document.body,
			    floating: true,
			    hidden: true,
			    focusOnShow: true,
			    minDate: me.minValue,
			    maxDate: me.maxValue,
			    disabledDatesRE: me.disabledDatesRE,
			    disabledDatesText: me.disabledDatesText,
			    disabledDays: me.disabledDays,
			    disabledDaysText: me.disabledDaysText,
			    format: me.format,
			    showToday: me.showToday,
			    startDay: me.startDay,
			    minText: format(me.minText, me.formatDate(me.minValue)),
			    maxText: format(me.maxText, me.formatDate(me.maxValue)),
			    listeners: {
				    scope: me,
				    select: me.onSelect
			    },
			    keyNavConfig: {
				    esc: function() {
					    me.collapse();
				    }
			    }
		    });
	  },
	  setValue:function(value){
	  	if(Ext.isString(value)){
	  		value = Ext.Date.parse(value,'Y-m-d H:i:s');
	  	}
	  	this.callParent([value]);
	  }
  });