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

    // 定义时间初始时间为10秒
    var times = 10;
    // 该方法用于重置时间
    function defaultTimes() {
        // 测试弹出
        times = 10;
    }
    // 判断是否超过10秒无操作。
    function timesReduce() {
        times--;
        // alert(times);
        if (times <= 0) {
            // alert('跳转');
            // 执行跳转
            window.location.href = "login.html";
        }
    }
    window.setInterval('timesReduce()', 1000);
})();
