/**
 * @description ExtJs 校验类型
 * 
 * @author pan.xiaobo
 */


Ext.apply(Ext.form.VTypes, {
    password : function(val, field) {
        if (field.initialPassField) {
            var pwd = field.up('form').down('[name=' + field.initialPassField + ']');
            return (val == pwd.getValue());
        }
        return true;
    },
    passwordText : '两次输入的密码不一致！',

    age : function(val, field) {
        try {
            if (parseInt(val) >= 18 && parseInt(val) <= 100)
                return true;
            return false;
        } catch (err) {
            return false;
        }
    },
    ageText : '请输入正确的年龄！',

    max : function(val, field) {
        try {
            if (parseFloat(val) <= parseFloat(field.max))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    maxText : '超过最大值！',

    min : function(val, field) {
        try {
            if (parseFloat(val) >= parseFloat(field.min))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    minText : '小于最小值！',

    /**
     * 数值类型的范围校验
     * @param {} val
     * @param {} field
     * @return {Boolean}
     */
    range : function(val, field) {
        try {
        	var me = this;
            if (!Ext.isNumeric(val)) {
                return false;
            }
            var myLabel = arguments[1].fieldLabel;
            me.rangeText = myLabel + '必须在' + field.min + '和' + field.max + '之间，请重新输入！';
            val = parseFloat(val);
            if (Ext.isEmpty(field.min) && !Ext.isEmpty(field.max)) {
                if (val <= parseFloat(field.max)) {
                    return true;
                }
            } else if (!Ext.isEmpty(field.min) && Ext.isEmpty(field.max)) {
                if (val >= parseFloat(field.min)) {
                    return true;
                }
            } else if (!Ext.isEmpty(field.min) && !Ext.isEmpty(field.max)) {
                if (val >= parseFloat(field.min) && val <= parseFloat(field.max)) {
                    return true;
                }
            }
            return false;
        } catch (e) {
            return false;
        }
    },
    rangeText : '必须在最小值和最大值之间，请重新输入！',

    /**
     * 
     * 自定义比较：接收参数如下： numberic：boolean 是否是数字类型的比较。默认为false target
     * ：目标对象id。用于从该对象获取值 operation ： 比较类型：>,>=,<,<=,=,!=
     * 
     * @param {}
     *            val
     * @param {}
     *            field
     * @return {Boolean}
     */
    compare : function(val, field) {
        try {
        	var me = this;
            var target = Ext.getCmp(field.target);
            if (Ext.isEmpty(target)) {
                return true;
            }
            
            
            // 比较类型
            var operation = field.operation;
            if (Ext.isEmpty(operation)) {
                return true;
            }

            // 日期格式的时候获取的是：Mon Jul 28 2014 00:00:00 GMT+08类似的
            var targetValue = target.getValue();
            // 是否数字
            if (field.numberic) {
                val = parseFloat(val);
                targetValue = parseFloat(targetValue);
            }
            
            /*if (field.getXType() == "datefield" && target.getXType() == "datefield") {
                val = Ext.Date.parseDate(val, WEBConstants.DEFAULT_DATE_FORMAT).getTime();
                targetValue = target.getRawValue(); // 获取输入框的值 类似2014-07-28
                targetValue = Ext.Date.parseDate(targetValue, WEBConstants.DEFAULT_DATE_FORMAT).getTime();
            }*/

            if (field.getXType().indexOf("date") > 0  && target.getXType().indexOf("date") > 0) {
                targetValue = target.getRawValue(); // 获取输入框的值 类似2014-07-28
            }
            var myLabel = arguments[1].fieldLabel;
            var targetLabel = target.fieldLabel;
            
            var flag = true;
            switch (operation) {
                case "lt" : // less than 小于
                    if (val >= targetValue) {
                        flag = false;
                        me.compareText = myLabel + '不能大于' + targetLabel + '，请重新输入！';
                    }
                    break;
                case "gt" : // great than 大于
                    if (val <= targetValue) {
                        flag = false;
                        me.compareText = myLabel + '不能小于' + targetLabel + '，请重新输入！';
                    }
                    break;
                case "eq" : // equals 等于
                    if (val != targetValue) {
                        flag = false;
                        me.compareText = myLabel + '与' + targetLabel + '不相等' + '，请重新输入！';
                    }
                    break;
                case "ne" : // not equals 不等于
                    if (val == targetValue) {
                        flag = false;
                        me.compareText = myLabel + '与' + targetLabel + '相等' + '，请重新输入！';
                    }
                    break;
                case "le" : // less equals 小于等于
                    if (val > targetValue) {
                        flag = false;
                        me.compareText = myLabel + '不能大于' + targetLabel + '，请重新输入！';
                    }
                    break;
                case "ge" : // great equals 大于等于
                    if (val < targetValue) {
                        flag = false;
                        me.compareText = myLabel + '不能小于' + targetLabel + '，请重新输入！';
                    }
                    break;
                default :
                    break;
            }

            return flag;

        } catch (e) {
            return false;
        }
    },
    compareText : '输入值校验不通过，请重新输入！',

    integer : function(val, field) {
        try {
            if (/^[0-9]*[1-9][0-9]*$/.test(val))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    integerText : '请输入正确的正整数！',

    minlength : function(val, field) {
        try {
            if (val.length >= parseInt(field.minlength))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    minlengthText : '长度过小！',

    maxlength : function(val, field) {
        try {
            if (val.length <= parseInt(field.maxlength))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    maxlengthText : '长度过大！',

    ip : function(val, field) {
        try {
            if ((/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/.test(val)))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    ipText : '请输入正确的IP地址！',
    ipMask : /[0-9.]/i,

    phone : function(val, field) {
        try {
            if (/^((0[1-9]{3})?(0[12][0-9])?[-])?\d{6,8}$/.test(val))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    phoneText : '请输入正确的电话号码，如:0920-29392929！',
    phoneMask :  /[0-9-]/i,

    mobilephone : function(val, field) {
        try {
            if (/(^0?[1][0-9]{10}$)/.test(val))
                return true;
            return false;
        } catch (e) {
            return false;
        }
    },
    mobilephoneText : '请输入正确的手机号码！',
    mobilephoneMask :  /[0-9]/i,
    
    idcard:function(value,field){
    	var re=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    	return re.test(value);
    },
    idcardText:'请输入正确的身份证号码,如:42220219912121234',
    idcardMask: /[0-9x]/i,
    
    noChinese:function(val,field){
    	return (/^[\u4e00-\u9fa5]+$/i).test(val);
    },
    noChineseText:'不允许填写中文!',
    noChineseMask:/[\u4e00-\u9fa5]/i,
    
    xssStr : function(val, field){
    	var me=this;
    	var xssStrText = "请勿在表单中输入敏感词汇:";
    	try {
            // alert
            if(/.*[A|a][L|l][E|e][R|r][T|t]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "alert";
            	return false;
            }
            // String.fromCharCode
            else if(/.*[S|s][T|t][R|r][I|i][N|n][G|g]\.[F|f][R|r][O|o][M|m][C|c][H|h][A|a][R|r][C|c][O|o][D|d][E|e]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "String.fromCharCode";
            	return false;
            }
            // window.location =
            else if(/.*[W|w][I|i][N|n][D|d][O|o][W|w]\.[L|l][O|o][C|c][A|a][T|t][I|i][O|o][N|n]\s*=.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "window.location=";
            	return false;
            }
            // location.href =
            else if(/.*[L|l][O|o][C|c][A|a][T|t][I|i][O|o][N|n]\.[H|h][R|r][E|e][F|f]\s*=.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "location.href=";
            	return false;
            }
            // style = x:ex pression
            else if(/.*[S|s][T|t][Y|y][L|l][E|e]\s*=.*[X|x]:[E|e][X|x].*[P|p][R|r][E|e][S|s]{1,2}[I|i][O|o][N|n]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "style = x:ex pression";
            	return false;
            }
            // document.cookie
            else if(/.*[D|d][O|o][C|c][U|u][M|m][E|e][N|n][T|t]\.[C|c][O|o]{2}[K|k][I|i][E|e].*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "document.cookie";
            	return false;
            }
            //  eval
            else if(/.*\s*[E|e][V|v][A|a][L|l]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "eval";
            	return false;
            }
            //  unescape
            else if(/.*[U|u][N|n][E|e][S|s][C|c][A|a][P|p][E|e]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "unescape";
            	return false;
            }
            // execscript
            else if(/.*[E|e][X|x][E|e][C|c][S|s][C|c][R|r][I|i][P|p][T|t]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "execscript";
            	return false;
            }
            // msgbox
            else if(/.*[M|m][S|s][G|g][B|b][O|o][X|x]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "msgbox";
            	return false;
            }
            // confirm
            else if(/.*[C|c][O|o][N|n][F|f][I|i][R|r][M|m]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "confirm";
            	return false;
            }
            // prompt
            else if(/.*[P|p][R|r][O|o][M|m][P|p][T|t]\s*.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "prompt";
            	return false;
            }
            // <script>
            else if(/.*<[S|s][C|c][R|r][I|i][P|p][T|t]>.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "html标签";
            	return false;
            }
            // </script>
            else if(/.*<\/[S|s][C|c][R|r][I|i][P|p][T|t]>.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "html标签";
            	return false;
            }
            // 含有回车换行 和 <a
            else if(/.*<[A|a].*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "html标签";
            	return false;
            }
            // <img
            else if(/.*<[I|i][M|m][G|g].*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "html标签";
            	return false;
            }
            
			
            // exec
            else if(/.*[E|e][X|x][E|e][C|c]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "exec";
            	return false;
            }
            // execute
            else if(/.*[E|e][X|x][E|e][C|c][U|u][T|t][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "execute";
            	return false;
            }
            // insert
            else if(/.*[I|i][N|n][S|s][E|e][R|r][T|t]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "insert";
            	return false;
            }
            // select
            else if(/.*[S|s][E|e][L|l][E|e][C|c][T|t]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "select";
            	return false;
            }
            // delete
            else if(/.*[D|d][E|e][L|l][E|e][T|t][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "delete";
            	return false;
            }
            // update
            else if(/.*[U|u][P|p][D|d][A|a][T|t][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "update";
            	return false;
            }
            // count
            else if(/.*[C|c][O|o][U|u][N|n][T|t]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "count";
            	return false;
            }
            // drop
            else if(/.*[D|d][R|r][O|o][P|p]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "drop";
            	return false;
            }
            // master
            else if(/.*[M|m][A|a][S|s][T|t][E|e][R|r]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "master";
            	return false;
            }
            // truncate
            else if(/.*[T|t][R|r][U|u][N|n][C|c][A|a][T|t][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "truncate";
            	return false;
            }
            // declare
            else if(/.*[D|d][E|e][C|c][L|l][A|a][R|r][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "declare";
            	return false;
            }
            // sitename
            else if(/.*[S|s][I|i][T|t][E|e][N|n][A|a][M|m][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "sitename";
            	return false;
            }
            // net user
            else if(/.*[N|n][E|e][T|t]\s[U|u][S|s][E|e][R|r]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "net user";
            	return false;
            }
            // xp_cmdshell
            else if(/.*[X|x][P|p]_[C|c][M|m][D|d][S|s][H|h][E|e][L|l][L|l]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "xp_cmdshell";
            	return false;
            }
            // like'
            else if(/.*[L|l][I|i][K|k][E|e]'.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "like'";
            	return false;
            }
            // create
            else if(/.*[C|c][R|r][E|e][A|a][T|t][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "create";
            	return false;
            }
            // from
            else if(/.*[F|f][R|r][O|o][M|m]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "from";
            	return false;
            }
            // grant
            else if(/.*[G|g][R|r][A|a][N|n][T|t]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "grant";
            	return false;
            }
            // group_concat
            else if(/.*[G|g][R|r][O|o][U|u][P|p]_[C|c][O|o][N|n][C|c][A|a][T|t]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "group_concat";
            	return false;
            }
            // column_name
            else if(/.*[C|c][O|o][L|l][U|u][M|m][N|n]_[N|n][A|a][M|m][E|e].*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "column_name";
            	return false;
            }
            // information_schema.columns
            else if(/.*[I|i][N|n][F|f][O|o][R|r][M|m][A|a][T|t][I|i][O|o][N|n]_[S|s][C|c][H|h][E|e][M|m][A|a]\.[C|c][O|o][L|l][U|u][M|m][N|n][S|s].*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "information_schema.columns";
            	return false;
            }
            // table_schema
            else if(/.*[T|t][A|a][B|b][L|l][E|e]_[S|s][C|c][H|h][E|e][M|m][A|a]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "table_schema";
            	return false;
            }
            // union
            else if(/.*[U|u][N|n][I|i][O|o][N|n]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "union";
            	return false;
            }
            // where
            else if(/.*[W|w][H|h][E|e][R|r][E|e]\s.*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "where";
            	return false;
            }
            // order by
            else if(/.*[O|o][R|r][D|d][E|e][R|r]\s[B|b][Y|y].*/.test(val)){
            	Ext.form.VTypes.xssStrText = xssStrText + "order by";
            	return false;
            }
            
            return true;
        } catch (e) {
            return true;
        }
    },
    xssStrText:''
    
});