package com.ztesoft.framework.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author wsmp@zte.com.cn
 * 
 */
public final class Utils {

    private Utils() {}
    
    /**
     * 判断对象数组是否为空
     * 
     * @param objs
     *            Object[]
     * @return boolean
     */
    public static boolean notEmpty(Object[] objs) {
        return !isEmpty(objs);
    };

    public static boolean isRunningOnWindows() {
        String OS = System.getenv("OS");
        return (OS != null && OS.toLowerCase().contains("win"));
    }

    public static boolean isEmpty(Object[] objs) {
        if (objs == null || objs.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空
     * 
     * @param str
     *            String
     * @return boolean
     */
    public static boolean notEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        return false;
    }

    /**
     * 判断集合]是否为空
     * 
     * @param coll
     *            Collection
     * @return boolean
     */
    public static boolean notEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static boolean isEmpty(Collection<?> coll) {
        if (coll == null || coll.size() == 0) {
            return true;
        }

        return false;
    }

    /**
     * 判断int数组是否为空
     * 
     * @param intArr
     *            int[]
     * @return boolean
     */
    public static boolean notEmpty(int[] arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(int[] intArr) {
        if (intArr == null || intArr.length == 0) {
            return true;
        }

        return false;
    }

    /**
     * 判断long数组是否为空
     * 
     * @param longArr
     *            long[]
     * @return boolean
     */
    public static boolean notEmpty(long[] arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(long[] longArr) {
        if (longArr == null || longArr.length == 0) {
            return true;
        }

        return false;
    }

    /**
     * 判断Map是否为空
     * 
     * @param map
     *            Map
     * @return boolean
     */
    public static boolean notEmpty(Map<?, ?> arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map == null || map.size() == 0) {
            return true;
        }

        return false;
    }

    public static boolean notEmpty(Object arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }


    /**
     * 判断int值是否空值
     * 
     * @param val
     *            int
     * @return boolean
     */
    public static boolean notEmpty(int arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(int val) {
        return (val == FrameWorkConstants.NULL_INT);
    }

    /**
     * 判断long值是否空值
     * 
     * @param val
     *            long
     * @return boolean
     */
    public static boolean notEmpty(long arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(long val) {
        return (val == FrameWorkConstants.NULL_LONG);
    }

    /**
     * 判断float值是否空值
     * 
     * @param val
     *            float
     * @return boolean
     */
    public static boolean notEmpty(float arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(float val) {
        return (val == FrameWorkConstants.NULL_FLOAT);
    }

    /**
     * 判断double值是否空值
     * 
     * @param val
     *            double
     * @return boolean
     */
    public static boolean notEmpty(double arg) {
        return !isEmpty(arg);
    }

    public static boolean isEmpty(double val) {
        return (val == FrameWorkConstants.NULL_DOUBLE);
    }

    /**
     * 判断一个字符串是否数字
     * 
     * @param val
     *            String
     * @return boolean
     */
    public static boolean notNumber(String arg) {
        return !isNumber(arg);
    }

    public static boolean isNumber(String val) {
        try {
            Double.parseDouble(val);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 除数
     */
    public static long DIV = 10000;

    /**
     * 得到float数据
     * 
     * @param value
     *            long
     * @return float
     */
    public static float divLongToFloat(long value) {
        float ret = ((float) value) / DIV;
        return ret;
    }

    public static double divLongToDouble(long value) {
        double ret = ((double) value) / DIV;
        return ret;
    }

    /**
     * 换成字符串插入数据库
     * 
     * @param value
     *            long
     * @return String
     */
    public static String divLongToString(long value) {
        String ret = Double.toString(((double) value) / DIV);
        return ret;
    }

    /**
     * 小数点处理
     * 
     * @param ll
     *            long
     * @param deciLen
     *            int
     * @return String
     */
    public static String fomartLong(long ll, int deciLen) {
        // 小数点后位数
        String strMoney = Long.toString(ll);
        StringBuffer retSb = new StringBuffer();
        // 如果为负数

        if (strMoney.substring(0, 1).equals("-")) {
            // 第一个为负号
            retSb.append("-");
            // 实际数字长度，去掉负号的
            strMoney = strMoney.substring(1);
        }
        // 字符串长度

        int len = strMoney.length();
        // 验证长度，不满或者4位数前补零

        if (len <= deciLen) {
            // 补零的位数

            int iRex = deciLen - len;
            retSb.append("0").append(".");
            for (int i = 0; i < iRex; i++) {
                retSb.append("0");
            }
            retSb.append(strMoney.substring(0));
        } else {
            // 超过4位的，移小数点

            int offset = len - deciLen;
            retSb.append(strMoney.substring(0, offset)).append(".").append(strMoney.substring(offset));
        }
        // 去掉最后几位

        String ret = retSb.toString();
        for (int i = 0; i < 4; i++) {
            if (!ret.substring(ret.length() - 1).equals("0")) {
                break;
            }
            ret = ret.substring(0, ret.length() - 1);
            if (i == 3) {
                ret = ret.substring(0, ret.length() - 1);
            }
        }
        return ret;
    }

    /**
     * 得到long数据
     * 
     * @param value
     *            long
     * @return float
     */
    public static long mulFloatToLong(float value) {
        return (long) (value * 10000);
    }

    /**
     * 去掉字符串的空格
     * 
     * @param str
     *            String
     * @return String
     */
    public static String trim(String str) {
        return (str == null) ? str : str.trim();
    }

    /**
     * 字符串是否在字符传集合中被找到
     * 
     * @param str
     *            String
     * @param collArr
     *            String[]
     * @return boolean true-找到, false-未找到
     */
    public static boolean exists(String str, String[] collArr) {
        if (isEmpty(str) || isEmpty(collArr)) {
            return false;
        }

        for (int i = 0; i < collArr.length; i++) {
            if (str.equals(collArr[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 某数字是否在数组里面
     * 
     * @param j
     *            int
     * @param collArr
     *            int[]
     * @return boolean true-找到, false-未找到
     */
    public static boolean exists(int j, int[] collArr) {
        if (Utils.isEmpty(collArr)) {
            return false;
        }
        for (int i = 0; i < collArr.length; i++) {
            if (j == collArr[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否在列表中被找到
     * 
     * @param str
     *            String 要查找的字符串
     * 
     * @param list
     *            List 字符串列表, 将调用list.get(index).toString()方法和str比较
     * @return boolean
     */
    public static boolean exists(String str, List<?> list) {
        if (isEmpty(str) || isEmpty(list)) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            if (str.equals(list.get(i).toString())) {
                return true;
            }
        }

        return false;
    }

    /**
     * 
     * <把id标识数组转换为以','分割的字符串>
     * 
     * @param idArr
     * @return
     */
    public static String convertIdArr2StringByComma(int[] idArr) {
        StringBuffer retStr = new StringBuffer();
        if (isEmpty(idArr)) {
            return retStr.toString();
        }

        for (int i = 0; i < idArr.length; i++) {
            retStr.append(String.valueOf(idArr[i])).append(",");
        }

        return retStr.substring(0, retStr.length() - 1);
    }

    /**
     * 
     * <把id标识数组转换为以','分割的字符串>
     * 
     * @param idArr
     * @return
     */
    public static String convertIdArr2StringByComma(long[] idArr) {
        StringBuffer retStr = new StringBuffer();
        if (isEmpty(idArr)) {
            return retStr.toString();
        }

        for (int i = 0; i < idArr.length; i++) {
            retStr.append(String.valueOf(idArr[i])).append(",");
        }

        return retStr.substring(0, retStr.length() - 1);
    }

    /**
     * 
     * <把id标识数组转换为以','分割的字符串>
     * 
     * @param idArr
     * @return
     */
    public static String convertIdArr2StringByComma(String[] idArr) {
        StringBuffer retStr = new StringBuffer();
        if (isEmpty(idArr)) {
            return retStr.toString();
        }

        for (int i = 0; i < idArr.length; i++) {
            retStr.append(String.valueOf(idArr[i])).append(",");
        }

        return retStr.substring(0, retStr.length() - 1);
    }

    /**
     * 字符串数组转换为LONG数组</br> 不对入参进行非空判断
     * 
     * @param strArr
     *            字符串数组
     * 
     * @return Long[]
     * 
     * @author xu.yang22@zte.com.cn 2011-8-25
     * @see [类、类#方法、类#成员]
     */
    public static Long[] stringArr2longArr(String[] strArr) {
        Long[] longArr = new Long[strArr.length];

        for (int i = 0, n = strArr.length; i < n; i++) {
            longArr[i] = Long.parseLong(strArr[i]);
        }

        return longArr;
    }

    /**
     * @param map
     * @param key
     * @return
     */
    public static String getString(Map<?, ?> map, String key) {
        String retStr = "";
        Object object = map.get(key);
        if (null != object) {
            retStr = object.toString();
        }
        return retStr;
    }

    /**
     * @param map
     * @param key
     * @return
     */
    public static Long getLong(Map<?, ?> map, String key) {
        Long ret = 0l;
        Object object = map.get(key);
        if (null != object) {
            ret = Long.parseLong(object.toString());
        }
        return ret;
    }

}
