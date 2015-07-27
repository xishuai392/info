/**
 * 提供原生javascript对象的扩展方法
 */
/**
 * 扩展String，提供replaceAll方法
 * 
 * @param {}
 *            reallyDo
 * @param {}
 *            replaceWith
 * @param {}
 *            ignoreCase
 * @return {}
 */
String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi" : "g")), replaceWith);
    } else {
        return this.replace(reallyDo, replaceWith);
    }
};

/**
 * 转换html标签
 * 
 * @return {}
 */
String.prototype.replaceHtml = function() {
    var temp = this.replaceAll('<', '&lt;');
    temp = temp.replaceAll('>', '&gt;');
    return temp;
};

/**
 * 获取字符串长度
 * 
 * @return {}
 */
String.prototype.getLength = function strlen() {
    var s = 0;
    var str = this;
    for (var i = 0; i < str.length; i++) {
        if (str.charAt(i).match(/[\u4E00-\u9FA5]/)) {
            s += 2;
        } else {
            s++;
        }
    }
    return s;
};