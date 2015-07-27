
/**
 * 1、因后台已经统一捕获了异常，封装成特定的JSON格式的异常字符串抛给前台，前台通过ExtUtils.doAjax进行请求，会封装异常信息；
 * 2、但是如果前台如果是通过store.load()，则无法识别异常字符串，故扩展了Ext.data.proxy，统一捕获异常，弹出提示框。
 * 
 * @author pan.xiaobo
 */
Ext.override(Ext.data.proxy.Server, {
    processResponse : function(success, operation, request, response, callback, scope) {
        var me = this, reader, result;

        // 捕获异常 begin add by song.chenghao
        // 判断返回是否有错误代码，如果有就认为是业务异常直接提示
        if (response) {
            var responseText = response.responseText;
            if (!Ext.isEmpty(responseText)) {
                var jsonData = Ext.isString(responseText)?Ext.JSON.decode(responseText):responseText;
                if (jsonData.errCode) {
                    var msg = jsonData.msg || jsonData.exception || jsonData.desc;
                    ExtUtils.error(msg);

                    // 继续抛出异常
                    me.fireEvent('exception', this, response, operation);
                }
            }
        }
        // 捕获异常end...

        if (success === true) {
            reader = me.getReader();

            // Apply defaults to incoming data only for read operations.
            // For create and update, there will already be a client-side record
            // to match with which will contain any defaulted in values.
            reader.applyDefaults = operation.action === 'read';

            result = reader.read(me.extractResponseData(response));

            if (result.success !== false) {
                // see comment in buildRequest for why we include the response
                // object here
                Ext.apply(operation, {
                    response : response,
                    resultSet : result
                });

                operation.commitRecords(result.records);
                operation.setCompleted();
                operation.setSuccessful();
            } else {
                operation.setException(result.message);
                me.fireEvent('exception', this, response, operation);
            }
        } else {
            me.setException(operation, response);
            me.fireEvent('exception', this, response, operation);
        }

        // this callback is the one that was passed to the 'read' or 'write'
        // function above
        if (typeof callback == 'function') {
            callback.call(scope || me, operation);
        }

        me.afterRequest(request, success);
    }

});
