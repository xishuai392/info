/**
 * 
 * @description 表单控件，设置一些通用属性 colspan : 设置占用列
 * 
 * @author pan.xiaobo
 */
Ext.define("ZTEsoft.form.EditForm", {
    extend : "Ext.form.Panel",
    alias : "widget.zteeditform",
    constructor : function(config) {
        var me = this;
        config = config || {};
        // default config
        var defaultConfig = {
            layout : "column",
            defaults : {
                xtype : 'textfield'
            },
            fieldDefaults : {
                style : 'margin-top:2px;margin-bottom:2px;',
                labelAlign : "right", // formField的Label居右
                // msgTarget: "side", //
                // 校验不过提示信息方式,放到head.ext4.inc.jsp设置
                labelWidth : config.labelWidth || 75
                // Label与控件之间的空隙
                // readOnlyCls : "readOnlyCls"
            }
        };

        // 格式化items
        me.formatItems(config);
        Ext.applyIf(config, defaultConfig);
        me.callParent([config]);
    },

    /**
     * 格式化条目items
     * 
     * @param {}
     *            autoColumnWidth
     * @param {}
     *            items
     * @return {}
     */
    formatItems : function(config) {
        var panelColumns = [];
        var autoColumnWidth = true;
        if (config.autoColumnWidth === false) {
            autoColumnWidth = false;
        }

        if (Ext.isEmpty(config.items)) {
            return panelColumns;
        }
        // 行属性设置
        var columnNum = config.columnNum || 4;
        config.columnNum = columnNum;
        // 所有的id-fieldLabel对应集合
        var idMap = {};

        var columnWidthNum = (1 / columnNum).toFixed(2);
        for (var indexChild in config.items) {
            var childItem = config.items[indexChild];
            // if(indexChild<=columnWidthNum){
            // childItem.style="";
            // }
            // 列宽百分比：设置每一列宽度百分比：改造支持colspan属性，自动计算列宽
            if (autoColumnWidth && !childItem.columnWidth) {
                if (childItem.colspan) {
                    var colspanWidth = columnWidthNum * childItem.colspan;
                    childItem.columnWidth = colspanWidth;
                } else {
                    childItem.columnWidth = columnWidthNum;
                }
            }

            // 不能为空的提示
            if (childItem.allowBlank === false) {
                childItem.blankText = childItem.fieldLabel + "不能为空！";
                childItem.afterSubTpl = WEBConstants.REQUIRED;
            } else {
                childItem.afterSubTpl = WEBConstants.BLANK;
            }

            // 最大字符数提示
            if (childItem.maxLength) {
                childItem.maxLengthText = childItem.fieldLabel + "不能超过" + childItem.maxLength + "个字符！";
            }
            // 最小字符数提示
            if (childItem.minLength) {
                childItem.minLengthText = childItem.fieldLabel + "不能小于" + childItem.minLength + "个字符！";
            }

            // 自定义校验提示符
            if (childItem.vtype) {
                if ("max" == childItem.vtype && childItem.max) {
                    childItem.vtypeText = childItem.fieldLabel + "不能大于" + childItem.max + "，请重新输入！";
                } else if ("min" == childItem.vtype && childItem.min) {
                    childItem.vtypeText = childItem.fieldLabel + "不能小于" + childItem.min + "，请重新输入！";
                } else if ("range" == childItem.vtype) {
                    if (childItem.min && childItem.max) {
                        childItem.vtypeText = childItem.fieldLabel + "必须在" + childItem.min + "和" + childItem.max + "之间，请重新输入！";
                    } else if (childItem.min && !childItem.max) {
                        childItem.vtypeText = childItem.fieldLabel + "必须大于等于" + childItem.min + "，请重新输入！";
                    } else if (!childItem.min && childItem.max) {
                        childItem.vtypeText = childItem.fieldLabel + "必须小于等于" + childItem.max + "，请重新输入！";
                    }
                } else if ("compare") {
                    if (childItem.target && childItem.operation && idMap[childItem.target]) {
                        var targetFieldLabel = idMap[childItem.target];
                        var operation = childItem.operation;
                        var operDesc = "";
                        switch (operation) {
                            case "lt" : // less than 小于
                                operDesc = "小于";
                                break;
                            case "gt" : // great than 大于
                                operDesc = "大于";
                                break;
                            case "eq" : // equals 等于
                                operDesc = "等于";
                                break;
                            case "ne" : // not equals 不等于
                                operDesc = "不等于";
                                break;
                            case "le" : // less equals 小于等于
                                operDesc = "小于等于";
                                break;
                            case "ge" : // great equals 大于等于
                                operDesc = "大于等于";
                                break;
                            default :
                                break;
                        }
                        childItem.vtypeText = childItem.fieldLabel + "必须" + operDesc + targetFieldLabel + "，请重新输入！";
                    }
                }
            }

            // 不显示底部提示语
            // childItem.emptyText = "";

        } // for item.items
    },

    /**
     * 设置所有输入框不可用
     */
    disableFields : function() {
        var fields = this.getForm().getFields();
        fields.each(function(field) {
            field.setReadOnly(true);
            field.validateOnChange = false;
            field.validateOnBlur = false;
            field.clearInvalid();

            // 背景灰化
            if (!field.isXType('displayfield')) {
                field.setFieldStyle('background:#E6E6E6');
            }
        });
    },
    /**
     * 设置所有输入框可用
     */
    enableFields : function() {
        var fields = this.getForm().getFields();
        fields.each(function(field) {
            field.setReadOnly(false);
            field.validateOnChange = true;
            field.validateOnBlur = true;
            field.isValid();

            // 背景还原
            if (!field.isXType('displayfield')) {
                field.setFieldStyle('background:;');
                // field.setFieldStyle('background:white repeat-x 0 0;background-image: url('+webRoot+'/common/images/text-bg.gif)');
            }
        });
    }
});
