package com.ztesoft.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式辅助类
 */
public class RegexUtils {
    public static boolean isMatch(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
