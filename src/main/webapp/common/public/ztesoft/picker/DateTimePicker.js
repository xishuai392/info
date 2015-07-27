//Ext.define("Ext.locale.en.ux.picker.DateTimePicker", {
//	  override: "Ext.ux.DateTimePicker",
//	  todayText: "Now",
//	  timeLabel: 'Time'
//  });

Ext.define('ZTEsoft.picker.DateTimePicker', {
	  extend: 'Ext.picker.Date',
	  alias: 'widget.ztedatetimepicker',
	  todayText: '现在',
	  todayTip : '选择当前时间',
	  timeLabel: '时间',
	  okText:'确定',
	  okTip:'点击确定按钮选择时间',
	  requires: ['ZTEsoft.form.field.TimePickerField'],
	  renderTpl: [
	        '<div id="{id}-innerEl" role="grid">',
	            '<div role="presentation" class="{baseCls}-header">',
	                 // the href attribute is required for the :hover selector to work in IE6/7/quirks
	                '<a id="{id}-prevEl" class="{baseCls}-prev {baseCls}-arrow" href="#" role="button" title="{prevText}" hidefocus="on" ></a>',
	                '<div class="{baseCls}-month" id="{id}-middleBtnEl">{%this.renderMonthBtn(values, out)%}</div>',
	                 // the href attribute is required for the :hover selector to work in IE6/7/quirks
	                '<a id="{id}-nextEl" class="{baseCls}-next {baseCls}-arrow" href="#" role="button" title="{nextText}" hidefocus="on" ></a>',
	            '</div>',
	            '<table id="{id}-eventEl" class="{baseCls}-inner" cellspacing="0" role="grid">',
	                '<thead role="presentation"><tr role="row">',
	                    '<tpl for="dayNames">',
	                        '<th role="columnheader" class="{parent.baseCls}-column-header" title="{.}">',
	                            '<div class="{parent.baseCls}-column-header-inner">{.:this.firstInitial}</div>',
	                        '</th>',
	                    '</tpl>',
	                '</tr></thead>',
	                '<tbody role="presentation"><tr role="row">',
	                    '<tpl for="days">',
	                        '{#:this.isEndOfWeek}',
	                        '<td role="gridcell" id="{[Ext.id()]}">',
	                            // the href attribute is required for the :hover selector to work in IE6/7/quirks
	                            '<a role="presentation" hidefocus="on" class="{parent.baseCls}-date" href="#"></a>',
	                        '</td>',
	                    '</tpl>',
	                '</tr></tbody>',
	            '</table>',
	            '<tpl if="showToday">',
	                '<div id="{id}-footerEl" role="presentation" class="{baseCls}-footer">{%this.renderTodayBtn(values, out)%}{%this.renderOkBtn(values, out)%}</div>',
	            '</tpl>',
	        '</div>',
	        {
	            firstInitial: function(value) {
	                return Ext.picker.Date.prototype.getDayInitial(value);
	            },
	            isEndOfWeek: function(value) {
	                // convert from 1 based index to 0 based
	                // by decrementing value once.
	                value--;
	                var end = value % 7 === 0 && value !== 0;
	                return end ? '</tr><tr role="row">' : '';
	            },
	            renderTodayBtn: function(values, out) {
	                Ext.DomHelper.generateMarkup(values.$comp.todayBtn.getRenderTree(), out);
	            },
	            renderMonthBtn: function(values, out) {
	                Ext.DomHelper.generateMarkup(values.$comp.monthBtn.getRenderTree(), out);
	            },
	            renderOkBtn: function(values, out) {
	                Ext.DomHelper.generateMarkup(values.$comp.okBtn.getRenderTree(), out);
	            }
	        }
	  ],
	  initComponent: function() {
		  // keep time part for value
		  var value = this.value || new Date();
		  this.callParent();
		  this.value = value;
	  },
	  beforeRender: function () {
        var me = this;
        me.okBtn = new Ext.button.Button({
            ownerCt: me,
            ownerLayout: me.getComponentLayout(),
            text: me.okText,
            tooltip: me.okTip,
            tooltipType:'title',
            handler:me.okHandler,//确认按钮的事件委托
            scope: me
        });
        me.callParent();
    },

	  onRender: function(container, position) {
		  if(!this.timefield) {
			  this.timefield = Ext.create('ZTEsoft.form.field.TimePickerField', {
				    fieldLabel: this.timeLabel,
				    labelWidth: 35,
				    labelStyle:'margin-left:5px;',
				    value: Ext.Date.format(this.value, 'H:i:s')
			    });
		  }
		  this.timefield.ownerCt = this;
		  this.timefield.on('change', this.timeChange, this);
		  this.callParent(arguments);

		  var table = Ext.get(Ext.DomQuery.selectNode('table.x-datepicker-inner', this.el.dom));
		  Ext.core.DomHelper.insertAfter(table, {
			    tag: 'div',
			    style: 'border:0px;',
			    children: [{
				      tag: 'div',
				      cls: 'x-datepicker-footer ux-timefield'
			      }]
		    }, true);
		  this.timefield.render(this.el.child('div div.ux-timefield'));

		  var p = this.getEl().parent('div.x-layer');
		  if(p) {
			  p.setStyle("height", p.getHeight() + 31);
		  }
	  },
	  // listener 时间域修改, timefield change
	  timeChange: function(tf, time, rawtime) {
		  // if(!this.todayKeyListener) { // before render
		  this.value = this.fillDateTime(this.value);
		  // } else {
		  // this.setValue(this.value);
		  // }
	  },
	  // @private
	  fillDateTime: function(value) {
		  if(this.timefield) {
			  var rawtime = this.timefield.getRawValue();
			  value.setHours(rawtime.h);
			  value.setMinutes(rawtime.m);
			  value.setSeconds(rawtime.s);
		  }
		  return value;
	  },
	  // @private
	  changeTimeFiledValue: function(value) {
		  this.timefield.un('change', this.timeChange, this);
		  this.timefield.setValue(this.value);
		  this.timefield.on('change', this.timeChange, this);
	  },

	  /* TODO 时间值与输入框绑定, 考虑: 创建this.timeValue 将日期和时间分开保存. */
	  // overwrite
	  setValue: function(value) {
		  this.value = value;
		  this.changeTimeFiledValue(value);
		  return this.update(this.value);
	  },
	  // overwrite
	  getValue: function() {
		  return this.fillDateTime(this.value);
	  },

	  // overwrite : fill time before setValue
	  handleDateClick: function(e, t) {
		  var me = this;
//			  handler = me.handler;

		  e.stopEvent();
		  if(!me.disabled && t.dateValue && !Ext.fly(t.parentNode).hasCls(me.disabledCellCls)) {
			  me.doCancelFocus = me.focusOnSelect === false;
			  me.setValue(this.fillDateTime(new Date(t.dateValue))); // overwrite: fill time before setValue
			  delete me.doCancelFocus;
			  me.selectedUpdate(new Date(t.dateValue));
//			  me.fireEvent('select', me, me.value);
//			  if(handler) {
//				  handler.call(me.scope || me, me, me.value);
//			  }
			  me.onSelect();
		  }
	  },
	  finishRenderChildren: function () {
	        var me = this;
	        //组件渲染完成后，需要调用子元素的finishRender，从而获得事件绑定
	        me.okBtn.finishRender();
	        me.callParent();
	  },
		/**
	     * 确认 按钮触发的调用
	     */
	  okHandler : function(){
	        var me = this,
	            btn = me.okBtn,
			    handler = me.handler;
			if(!me.timefield.isValid()) return;
	        if(btn && !btn.disabled){
	            me.setValue(this.getValue());
	            me.fireEvent('select', me, me.value);
	            me.onSelect();
	            if(handler) {
				  	handler.call(me.scope || me, me, me.value);
			  	}
	        }
	        return me;
	  },
	  // overwrite : fill time before setValue
	  selectToday: function() {
		  var me = this,
			  btn = me.todayBtn,
			  handler = me.handler;
		  if(btn && !btn.disabled) {
			  // me.setValue(Ext.Date.clearTime(new Date())); //src
			  me.setValue(new Date());// overwrite: fill time before setValue
			  me.fireEvent('select', me, me.value);
			  if(handler) {
				  handler.call(me.scope || me, me, me.value);
			  }
			  me.onSelect();
		  }
		  return me;
	  },
	  // @private
    // @inheritdoc
    beforeDestroy : function() {
        var me = this;

        if (me.rendered) {
            //销毁组件时，也需要销毁自定义的控件
            Ext.destroy(
                me.okBtn
            );
        }
        me.callParent();
    }
  });