package com.ztesoft.framework.util;

/**
 * <Description>断言工具 <br>
 * 
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年8月28日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.framework.util <br>
 */
public class AssertUtils {
    public static <T> void isNotNull(T obj, String msg) {
        if (obj == null) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static <T> void isNotNull(T obj) {
        isNotNull(obj, "The value is null.");
    }

    public static void isNotEmpty(String str, String msg) {
        if ((str == null) || (str.length() == 0)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isNotEmpty(String str) {
        isNotEmpty(str, "The value is null.");
    }

    public static void isFalse(boolean blVal, String msg) {
        if (blVal) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isFalse(boolean blVal) {
        isFalse(blVal, "The value is not false.");
    }

    public static void isTrue(boolean blVal, String msg) {
        if (!blVal) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isTrue(boolean blVal) {
        isTrue(blVal, "The value is not true.");
    }

    public static <T, V> void areEqual(T obj1, V obj2, String msg) {
        if (!obj1.equals(obj2)) {
            throw new IllegalArgumentException(msg);
        }
    }

    public static <T, V> void areEqual(T obj1, V obj2) {
        areEqual(obj1, obj2, "The object is not equal.");
    }

    public static <T> void isNotEmpty(T[] array, String message) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> boolean isEmpty(T[] array) {
        return (array == null || array.length == 0);
    }

    public static boolean isEmpty(byte[] array) {
        return (array == null || array.length == 0);
    }

    public static void isNotEmpty(byte[] array, String message) {
        if (isEmpty(array)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(byte[] array) {
        isNotEmpty(
                array,
                "[Assertion failed] - this byte array must not be empty: it must contain at least 1 element");
    }

    public static <T> void notEmpty(T[] array) {
        isNotEmpty(
                array,
                "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void main(String[] argsw) {
        byte[] l = null;
        AssertUtils.isNotEmpty(l);
    }

    public static void hasLength(String str, String string) {
        if (str.length() == 0) {
            throw new IllegalArgumentException(string);
        }
    }

}
