/**
 * @description
 * @author Administrator
 * @date 2015年11月1日
 */

/*
 * nobody.js @author Yimo
 * 
 * @version v1.0
 */
(function() {
    // 人为操作事件支持，以下事件触发将被认定为当前页面存在人为操作
    var events = ['mousemove', 'keypress', 'mousedown', 'mousewheel'];

    // 添加事件
    function addEvent(type, handler) {
        if (window.addEventListener) {
            window.addEventListener(type, handler, false);
        } else if (window.attachEvent) {
            window.attachEvent("on" + type, handler);//IE5+
        } else {
        	console.log("addEvent else "+type);
            window["on" + type] = handler;
        }
    }

    // 移除事件
    function removeEvent(type, handler) {
        if (window.removeEventListener) {
            window.removeEventListener(type, handler, false);
        } else if (window.detachEvent) {
            window.detachEvent("on" + type, handler);
        } else {
            window["on" + type] = null;
        }
    }
    // 按ID缓存对应nobody事件的内部对象用于后续事件销毁
    var cache = {};

    /*
     * 无人操作事件
     * 
     * @param func 事件触发时的回调函数 
     * @param timeout 无人操作事件触发延迟时间 
     * @param onlyonce 是否仅触发一次
     * 
     * @return 事件定时器ID
     */
    window.onNobody = function(func, timeout, onlyonce) {
        // 域内独立对象，保证onNobody每次调用都有一个属于自己的detail对象
        var detail = {
            counter : 0,
            lastTime : new Date().getTime(),
            reset : function() {
                detail.counter = 0;
                alert(detail.counter);
                console.log(detail.counter);
            }
        };
        for (var i = 0; i < events.length; i++) {
            addEvent(events[i], (function(){
            	alert(events[i]);
            	detail.reset();
            }));
        };
        var id = setInterval(function() {
            if (detail.counter >= timeout) {
                func();
                if (!onlyonce) {
                    detail.counter = 0;
                } else {
                    window.clearNobody(id);
                }
            }
            var time = new Date().getTime();
            detail.counter += time - detail.lastTime;
            detail.lastTime = time;
        }, 1);
        cache[id] = detail;
        return id;
    };

    /*
     * 移除无人操作事件
     * 
     * @param id 添加无人操作事件时返回的ID
     */
    window.offNobody = function(id) {
        clearInterval(id);
        for (var i = 0; i < events.length; i++) {
            removeEvent(events[i], cache[id].reset);
        };
    };
})();
