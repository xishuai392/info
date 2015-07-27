package com.ztesoft.framework.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import com.ztesoft.framework.exception.BaseAppException;

/**
 * <Description> 异常栈信息提取工具类<br>
 */
public class ExceptionUtils {

    public static final int SQLException_ORA = 1;

    public static final int SQLException_TT = 2;

    public static final int SQLException_ABD = 3;

    public static final int SQLException_QDB = 4;

    /** ZSmart类型异常,name以“com.ztesoft”开头 */
    public static final int SQLException_ZSMART = 10;

    /** Mysql类型异常 */
    public static final int SQLException_MYSQL = 11;

    /** 未知异常 */
    public static final int SQLException_UNKNOWN = 1000;

    public static Throwable findMostUsefulInner(Throwable t) {
        if (t == null) {
            return null;
        }
        Throwable target = t;
        while (target.getCause() != null) {
            target = target.getCause();
            if (target instanceof Error) {
                return target;
            }
            if (target instanceof SQLException) {
                int type = getSQLExceptionVernderType(target);
                switch (type) {
                    case SQLException_ORA:
                    case SQLException_TT:
                    case SQLException_ZSMART:
                        return target;
                }
            }
        }
        return target;
    }

    public static Throwable getMostInnerException(Throwable t) {
        if (t == null) {
            return null;
        }

        Throwable target = t;
        while (target.getCause() != null) {
            target = target.getCause();
        }
        return target;
    }

    public static BaseAppException getFirstBaseAppException(Throwable t) {
        Throwable cause = t;
        while (cause != null) {
            if (cause instanceof BaseAppException) {
                return (BaseAppException) cause;
            }
            cause = cause.getCause();
        }
        return null;
    }

    public static Object exCheck(Object arg) {
        if (arg instanceof Throwable) {
            arg = exToString((Throwable) arg);
        }
        return arg;
    }

    public static String exToString(Throwable t) {
        StringWriter sw = new StringWriter(5 * 1024);
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            // pw.flush();
            return sw.toString();
        }
        finally {
            pw.close();
        }
    }

    /**
     * 提取所有的异常信息
     * 
     * @param e
     * @return
     */
    public static String getExceptionStackTrace(Throwable e) {
        String exception = "";
        exception = e.getMessage() + "\n\t";
        for (StackTraceElement stack : e.getStackTrace()) {
            exception += stack.toString() + "\n\t";
        }
        while (!(e.getCause() == null)) {
            e = e.getCause();
            exception = e.getMessage() + "\n\t";
            for (StackTraceElement stack : e.getStackTrace()) {
                exception += stack.toString() + "\n\t";
            }
        }
        return exception;
    }

    public static int getSQLExceptionVernderType(Throwable t) {
        StackTraceElement[] steList = t.getStackTrace();
        if (steList == null || steList.length <= 0) {
            return SQLException_UNKNOWN;
        }
        String name = steList[0].getClassName();
        if (name == null) {
            return SQLException_UNKNOWN;
        }
        name = name.toLowerCase();
        if (name.startsWith("oracle")) {
            return SQLException_ORA;
        }
        if (name.startsWith("mysql")) {
            return SQLException_MYSQL;
        }
        if (name.startsWith("com.timesten")) {
            return SQLException_TT;
        }
        if (name.startsWith("altibase")) {
            return SQLException_ABD;
        }
        if (name.startsWith("com.ztesoft.zsmart.core.jdbc.qdbdriver")) {
            return SQLException_QDB;
        }
        if (name.startsWith("com.ztesoft")) {
            return SQLException_ZSMART;
        }
        return SQLException_UNKNOWN;
    }
}
