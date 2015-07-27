package com.ztesoft.framework.util;

import org.apache.commons.lang.StringUtils;

/**
 * <Description> StringBuffer工具<br>
 */
public class StringBufferUtils {

    /**
     * 从左侧对字符串指定长度补0 <br>
     * 调用 org.apache.commons.lang.StringUtils的leftPad()方法
     * 
     * <pre>
     * StringUtils.leftPad(null, *, *)     = null
     * StringUtils.leftPad("", 3, 'z')     = "zzz"
     * StringUtils.leftPad("bat", 3, 'z')  = "bat"
     * StringUtils.leftPad("bat", 5, 'z')  = "zzbat"
     * StringUtils.leftPad("bat", 1, 'z')  = "bat"
     * StringUtils.leftPad("bat", -1, 'z') = "bat"
     * </pre>
     * 
     * @param str
     * @param strLength
     * @return
     */
    public static String addZeroForNum(String str, int strLength) {
        str = StringUtils.leftPad(str, strLength, '0');
        return str;
    }
}
