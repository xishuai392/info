/**
 * @description 文本框+按钮组件<br>
 *              调用方法setTextAndValue会触发事件'setChange'，响应函数为function(String
 *              thizText,String thizValue,Event thizEvent)
 */
Ext.define('ZTEsoft.form.field.TextButtonField', {
    extend : 'Ext.form.field.Trigger',
    alias : 'widget.ztetextbutton',
    trigger1Cls : Ext.baseCSSPrefix + 'form-search-trigger',
    trigger2Cls : Ext.baseCSSPrefix + 'form-clear-trigger',
    initComponent : function() {
        var me = this;
        me.hiddenValue = me.value;
        me.value = me.text;
        if (me.value == null || me.hiddenValue == null) {
            me.clear();
        }
        me.addEvents('click');
        me.callParent(arguments);
    },
    afterRender : function() {
        var me = this;
        me.callParent();
        if (!me.editable) {
            me.inputEl.on('click', Ext.bind(me.onTrigger1Click, me));
        }
    },
    clear : function() {
        this.setTextAndValue(null, null);
    },
    reset : function() {
        this.setTextAndValue(null, null);
    },
    setTextAndValue : function(text, value) {
        this.setValue(text, true);
        this.hiddenValue = value;
        if (!Ext.isEmpty(value)) {
            this.clearInvalid();
        }
        // 自定义事件setChange
        this.fireEvent('setChange', text, value);
    },
    getTextAndValue : function() {
        return [this.getRawValue(), this.hiddenValue];
    },
    setValue : function(value, flag) {
        if (flag) {// 有flag表示要直接设置不要再加判断了
            this.callParent([Ext.isEmpty(value) ? '' : value]);
        } else if (!Ext.isEmpty(value) && value.toString().indexOf('@@') > -1) {
            if (value.toString() == "@@") {
                this.setValue("");
            } else {
                this.setTextAndValue(value.toString().split('@@')[0], value.split('@@')[1]);
            }
        } else if (!Ext.isEmpty(value) && value.toString().indexOf(',') > 0) {
            this.setTextAndValue(value.toString().split(',')[0], value.toString().split(',')[1]);
        } else {
            this.callParent([Ext.isEmpty(value) ? '' : value]);
        }
    },
    getValue : function() {
        return this.hiddenValue||this.callParent(arguments);
    },
    getSubmitValue : function() {// 提交form需要
        return this.hiddenValue||this.callParent(arguments);
    },
    onTrigger1Click : function() {
        var me = this;
        if (!me.readOnly) {
            if (this.handler) {
                this.handler.apply(me.scope || me, arguments);
            }
            me.fireEvent('click', arguments);
        }
    },
    onTrigger2Click : function() {
        this.clear();
    }
});