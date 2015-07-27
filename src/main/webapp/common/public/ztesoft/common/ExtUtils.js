/**
 * @description ExtJs 工具类，所有的提示框、警告框、doAjax都以该工具调用
 * 
 * 
 * @author pan.xiaobo
 */

Ext.define('ZTEsoft.common.ExtUtils', {
    alternateClassName : 'ExtUtils',
    singleton : true,
    // 判断是否登录超时，如果超时,respoonseheads必须设置timeout，则跳转到登录界面。
    constructor : function() {
        Ext.Ajax.on('requestcomplete', function(conn, response, options, eOpts) {
            if (Ext.isFunction(response.getAllResponseHeaders) && response.getAllResponseHeaders().sessionstatus == WEBConstants.SESSION_STATUS_TIMEOUT) {
                window.top.location.href = ctx + WEBConstants.LOGIN_JSP_PATH;
            }
        });
    },

    /**
     * 错误提示框
     */
    error : function(sErrorMsg, fn, scope) {
        Ext.Msg.alert({
            title : '提示',
            msg : sErrorMsg,
            fn : fn,
            scope : scope,
            buttons : Ext.Msg.OK,
            icon : Ext.Msg.ERROR
        });
    },

    /**
     * 提醒提示框
     */
    info : function(sINFOMsg, fn, scope) {
        Ext.Msg.show({
            title : '提示',
            msg : sINFOMsg,
            fn : fn,
            scope : scope,
            buttons : Ext.Msg.OK,
            icon : Ext.Msg.INFO
        });
    },

    /**
     * 警告提示框
     */
    warn : function(sWRANMsg, fn, scope) {
        Ext.Msg.show({
            title : '提示',
            msg : sWRANMsg,
            fn : fn,
            scope : scope,
            buttons : Ext.Msg.OK,
            icon : Ext.Msg.WARNING
        });
    },

    /**
     * 确认提示框
     * 
     * @param {}
     *            sINFOMsg
     * @param {}
     *            fn
     * @param {}
     *            scope
     */
    confirm : function(sINFOMsg, cancelFn, scope) {
        Ext.Msg.show({
            title : '提示',
            msg : sINFOMsg,
            fn : function(btn, text) {
                if (btn == Ext.Msg.buttonIds[1]) {
                    cancelFn.apply(scope);
                }
            },
            scope : scope,
            buttons : Ext.Msg.YESNO,
            icon : Ext.Msg.QUESTION
        });
    },

    /**
     * 悬浮层提示窗口 ExtUtils.tip('测试','测试{0}','test');
     * 
     * @param {}
     *            title 标题
     * @param {}
     *            format 可格式化的字符串
     */
    tip : function(title, format) {
        if (!this.msgCt) {
            this.msgCt = Ext.DomHelper.insertFirst(document.body, {
                style : ' position:absolute;left:50%; top:10px;width:400px; margin-left:-200px;z-index:20000;'
            }, true);
        }
        var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
        title = title || StrConstants.HINT;
        var m = Ext.DomHelper
            .append(this.msgCt, '<div style="border-radius: 8px; -moz-border-radius: 8px;background: #F6F6F6; border: 2px solid #ccc;margin-top: 2px; padding: 10px 15px; color: #555;"><h3 style="margin: 0 0 8px; font-weight: bold; font-size: 15px;">'
                    + title + '</h3><p style="margin: 0;">' + s + '</p></div>', true);
        m.hide();
        m.show();
        // m.slideIn('t').ghost("t", { delay: 100, remove: true});
        m.on('mouseover', function() {
            m.remove();
        });
        m.fadeOut({
            duration : 5,
            delay : 2000,
            remove : true
        });
    },

    /**
     * ajax异步请求数据
     * 
     * @param {}
     *            config
     */
    doAjax : function(config) {
        this.callService(config, false, false);
    },

    /**
     * ajax异步查询数据
     * 
     * @param {}
     *            config
     */
    doAjaxQuery : function(config) {
        this.callService(config, true, false);
    },

    /**
     * ajax同步请求数据
     * 
     * @param {}
     *            config 默认是同步的查询方式
     */
    doAjaxSync : function(config) {
        this.callService(config, true, true);
    },

    /**
     * ajax同步查询数据
     * 
     * @param {}
     *            config
     */
    doAjaxQuerySync : function(config) {
        this.callService(config, true, true);
    },

    /**
     * 前后台ajax交互的请求方法
     * 
     * @param {}
     *            config
     * @param {}
     *            queryFlag 是否是查询
     * @param {}
     *            syncFlag 是否同步
     */
    callService : function(config, queryFlag, syncFlag) {
        // 查询类，同步类操作不需要这个提示框
        if (!queryFlag) {
            Ext.Msg.show({
                title : '请稍等',
                msg : '正在提交数据,请稍等...',
                wait : true
            });
        }

        if (config.el) {
            config.el.mask();
        }

        var defaultConfig = {};

        if (config.hasOwnProperty('jsonData')) {
            defaultConfig.jsonData = config.jsonData;
        } else if (config.hasOwnProperty('params')) {
            defaultConfig.params = config.params;
        } else {
            defaultConfig.params = {};
        }

        // 是否异步
        var asyncFlag = syncFlag ? false : true;

        Ext.Ajax.request(Ext.apply({
            scope : config.scope || this,
            url : webRoot + config.url,
            async : asyncFlag,
            method : config.method || 'POST',
            timeout : 1200000, // 超时：20分钟
            success : function(response) {
                if (!queryFlag) {
                    Ext.Msg.hide();
                }
                var responseText = response.responseText;
                // 没有返回数据，直接直行回调方法
                if (Ext.isEmpty(responseText)) {
                    if (Ext.isFunction(config.callback)) {
                        config.callback.call(this, "");
                    }
                    return;
                }

                try {
                    var jsonData = Ext.JSON.decode(responseText);

                    // 判断java后台返回是否包含errCode字段，有就证明是有异常的情况
                    if (jsonData.errCode) {
                        var msg = jsonData.msg || jsonData.exception || jsonData.desc;
                        this.error(msg, function() {
                            if (Ext.isFunction(config.exceptionCallback)) {
                                config.exceptionCallback.call(this, jsonData);
                            }
                        });

                        return responseText;
                    }

                    // 后台设置success的值推荐使用boolean，这是为了兼容表单submit的情况，判断表单是否成功提交就是使用success的true/false
                    if (jsonData.success == true || jsonData.success == false || jsonData.success == "true" || jsonData.success == "false") {
                        if (jsonData.success.toString() == "true") {
                            if (config.el) {
                                config.el.unmask();
                            }
                            var msg = jsonData.msg || jsonData.exception || jsonData.desc;

                            this.info(msg, function() {
                                if (Ext.isFunction(config.callback)) {
                                    config.callback.call(this, jsonData);
                                }
                            });

                        } else {
                            var msg = jsonData.msg || jsonData.exception || jsonData.desc;
                            this.warn(msg);
                        }
                    } else {
                        if (Ext.isFunction(config.callback)) {
                            config.callback.call(this, jsonData);
                        }
                    }
                } catch (e) {
                    // 如果上面执行回调报错，则会第二次执行callback，这里有问题所以注释掉
                    /*
                     * if (Ext.isFunction(config.callback)) {
                     * config.callback.call(this, responseText); } return
                     * responseText;
                     */
                }
            },

            failure : function(response) {
                if (!queryFlag) {
                    Ext.Msg.hide();
                }
                var json = null;
                try {
                    json = eval("(" + response.responseText + ")");
                } catch (e) {
                    json = {};
                }

                var msg;
                if (json && json.msg) {
                    msg = json.msg;
                } else {
                    msg = "请求超时,网络异常!";
                }

                this.error(msg);

                if (config.el) {
                    config.el.unmask();
                }

                if (Ext.isFunction(config.failureCallback)) {
                    config.failureCallback.call(this);
                }
            }
        }, defaultConfig));
    },
    /**
     * 检查view是否有选中记录
     * 
     * @param {}
     *            view 要检查的组件
     * @param {}
     *            multiRecord 是否允许选择多条记录
     * @param {}
     *            showAlarm 没有选中时是否弹出警告提示
     * @return {Boolean}
     */
    gridSelectCheck : function(view, multiRecord, showAlarm) {
        var records = view.getSelectionModel().getSelection();
        if (Ext.isEmpty(records)) {
            if (showAlarm === undefined || showAlarm === true) {
                this.error('请选择记录!');
            }
            return false;
        } else if (records.length > 1 & !multiRecord) {
            if (showAlarm === undefined || showAlarm === true) {
                this.error('只能选择一条记录!');
            }
            return false;
        } else {
            return multiRecord ? records : records[0];
        }
    },
    
    
    /**
     * 获取node节点的所有父节点
     * 
     * @param {}
     *            node
     * @param {}
     *            parents 父节点
     * @return {}
     */
    getParentNodes : function(node,parents) {
        var me = this;
        if(!parents){
            parents = {};
        }
        parents[Number(node.data.id)] = node.data.text;
        if (node.parentNode != null) {
            me.getParentNodes(node.parentNode,parents);
        }else{
            return parents;
        }
    },
    
    /**
     * 数组随机排序，用于打乱已有数组的顺序<br>
     * 用法：arr.sort(ExtUtils.randomSort)
     * 
     * @param {}
     *            a
     * @param {}
     *            b
     * @return {}
     */
    randomSort : function (a, b) {
    	// 用Math.random()函数生成0~1之间的随机数与0.5比较，返回-1或1
        return Math.random()>.5 ? -1 : 1;
	}
});