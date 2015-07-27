package com.ztesoft.framework.exception;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;
import com.ztesoft.framework.util.MessageResourceUtils;

/**
 * <Description>异常处理类, 将所有的异常做统一处理,要求所有的业务服务方法都 用该类来处理, 统一抛出BaseAppException异常, 便于管理. <br>
 */
public final class ExceptionHandler {

    /** 系统错误类型. */
    public static final int SYS_ERROR_TYPE = 1;

    /** 业务错误类型. */
    public static final int BUSI_ERROR_TYPE = 2;

    // 错误类型定义在这而不是在Constants里定义,是减少错误处理这个模块和其他模块的藕合性

    public static final String ENCODE_CONFIG_NODE = "ExceptionHandler";

    private static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(ExceptionHandler.class);

    private static long appExceptionCount = 0;

    public static synchronized long getAppExceptionCount() {

        return appExceptionCount;
    }

    public static synchronized void increaseAppExceptionCount() {
        appExceptionCount++;
    }

    private ExceptionHandler() {
    }

    /**
     * @param errorCode
     * @param t Throwable
     * @return BaseAppException
     * @throws BaseAppException
     */
    public static BaseAppException publish(String errorCode, Throwable t)
            throws BaseAppException {
        return publish(errorCode, null, SYS_ERROR_TYPE, t, null, null, null);
    }

    /**
     * @param errorCode String ����
     * @param t Throwable
     * @return BaseAppException
     * @throws BaseAppException
     */
    public static BaseAppException publish(String errorCode, int errorType,
            Throwable t) throws BaseAppException {
        return publish(errorCode, null, errorType, t, null, null, null);
    }

    /**
     * @param errorCode String
     * @return BaseAppException
     * @throws BaseAppException
     */
    public static BaseAppException publish(String errorCode)
            throws BaseAppException {
        return publish(errorCode, null, SYS_ERROR_TYPE, null, null, null, null);
    }

    public static BaseAppException publish(String errorCode, int errorType)
            throws BaseAppException {
        return publish(errorCode, null, errorType, null, null, null, null);
    }

    /**
     * @param errorCode String ������ￄ
     * @param msg String
     * @return BaseAppException
     * @throws BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg)
            throws BaseAppException {
        return publish(errorCode, msg, SYS_ERROR_TYPE, null, null, null, null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            int errorType) throws BaseAppException {
        return publish(errorCode, msg, errorType, null, null, null, null);
    }

    /**
     * @param errorCode String
     * @param msg String
     * @param t Throwable ����
     * @return BaseAppException
     * @throws BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg,
            Throwable t) throws BaseAppException {
        return publish(errorCode, msg, SYS_ERROR_TYPE, t, null, null, null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            int errorType, Throwable t) throws BaseAppException {
        return publish(errorCode, msg, errorType, t, null, null, null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            Throwable t, String param) throws BaseAppException {
        return publish(errorCode, msg, SYS_ERROR_TYPE, t, param, null, null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            int errorType, Throwable t, String param) throws BaseAppException {
        return publish(errorCode, msg, errorType, t, param, null, null);
    }

    /**
     * 实现变量可替换，增加了三个构造函数
     * 
     * @param errorCode
     * @param msg
     * @param param1
     * @return
     * @throws BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg,
            String param1) throws BaseAppException {
        return publish(errorCode, msg, SYS_ERROR_TYPE, null, param1, null, null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            int errorType, String param1) throws BaseAppException {
        return publish(errorCode, msg, errorType, null, param1, null, null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            String param1, String param2) throws BaseAppException {
        return publish(errorCode, msg, SYS_ERROR_TYPE, null, param1, param2,
                null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            int errorType, String param1, String param2)
            throws BaseAppException {
        return publish(errorCode, msg, errorType, null, param1, param2, null);
    }

    public static BaseAppException publish(String errorCode, String msg,
            String param1, String param2, String param3)
            throws BaseAppException {
        return publish(errorCode, msg, SYS_ERROR_TYPE, null, param1, param2,
                param3);
    }

    public static BaseAppException publish(String errorCode, String msg,
            int errorType, String param1, String param2, String param3)
            throws BaseAppException {
        return publish(errorCode, msg, errorType, null, param1, param2, param3);
    }

    public static BaseAppException publish(String errorCode, int errorType,
            String param1) throws BaseAppException {
        return publish(errorCode, null, errorType, null, param1, null, null);
    }

    public static BaseAppException publish(String errorCode, int errorType,
            String param1, String param2) throws BaseAppException {
        return publish(errorCode, null, errorType, null, param1, param2, null);
    }

    public static BaseAppException publish(String errorCode, int errorType,
            String param1, String param2, String param3)
            throws BaseAppException {
        return publish(errorCode, null, errorType, null, param1, param2, param3);
    }

    /**
     * @param errorCode String ������ￄ
     * @param msg String �����
     * @param errorType int ��������
     * @param t Throwable
     * @return BaseAppException
     * @throws BaseAppException
     */
    public static BaseAppException publish(String errorCode, String msg,
            int errorType, Throwable t, String param1, String param2,
            String param3) throws BaseAppException {
        /**
         * when t instance of BaseAppException, we only need cast t into BaseAppException as we don't need wrapp t into BaseAppException again
         * modified by chenyong 2007-4-18
         */

        BaseAppException baseAppException;
        if (t instanceof BaseAppException) {
            baseAppException = (BaseAppException) t;
        }
        else if (t instanceof InvocationTargetException) {
            // 仅仅对此情况进行处理，不能进行深层检查！
            Throwable cause = t.getCause();
            if (cause instanceof BaseAppException) {
                baseAppException = (BaseAppException) cause;
            }
            else {
                baseAppException = new BaseAppException(errorCode, msg,
                        errorType, t, param1, param2, param3);
            }
        }
        else {
            baseAppException = new BaseAppException(errorCode, msg, errorType,
                    t, param1, param2, param3);
        }

        // 记录日志,统一由callService记录日志
        // logErrorInfo(baseAppException);
        throw baseAppException;
    }

    /**
     * 获得最底层异常信息
     * 
     * @param ex
     */
    public static BaseAppExceptionDto getMostExactException(Throwable ex) {
        AssertUtils.isNotNull(ex, "Exception");

        BaseAppExceptionDto bae = new BaseAppExceptionDto();

        Throwable cause = ex;

        while (cause.getCause() != null) {
            cause = cause.getCause();
        }

        if (cause instanceof BaseAppException) {
            bae.setErrorCode(((BaseAppException) cause).getCode());
            bae.setErrorMessage(((BaseAppException) cause).getLocaleMessage());
        }
        else if (cause instanceof SQLException) {
            // 数据访问异常
            bae.setErrorCode(SystemErrorCode.DB_OPER_EXPCEPTION);
            bae.setErrorMessage(MessageResourceUtils
                    .getMessage(SystemErrorCode.DB_OPER_EXPCEPTION)
                    + " :"
                    + cause.getMessage() == null ? "" : cause.getMessage());

        }
        else {
            bae.setErrorCode(SystemErrorCode.UNKNOW_EXPCEPTION);
            bae.setErrorMessage(MessageResourceUtils
                    .getMessage(SystemErrorCode.UNKNOW_EXPCEPTION)
                    + " :"
                    + cause.getMessage() == null ? "" : cause.getMessage());
        }

        return bae;
    }

    public static void logErrorInfo(String m, Throwable ex) {

        increaseAppExceptionCount();
        logger.error(m, ex);
    }

    private static void logErrorInfo(BaseAppException baseAppException) {

        increaseAppExceptionCount();
        StringBuilder sb = new StringBuilder();

        sb.append(baseAppException.toString());
        // add by chen.weizheng task CCB-3246 (ID:6368)
        if (baseAppException.getDesc() != null) {
            sb.append("\r\n").append(baseAppException.getDesc());
        }

        Throwable cause = baseAppException.getCause();

        while (cause != null) {
            sb.append("\r\nCause by: ");

            sb.append(cause.toString());

            for (int i = 0; i < cause.getStackTrace().length; i++) {
                sb.append("\r\n\tat ");
                sb.append(cause.getStackTrace()[i]);
            }

            cause = cause.getCause();

            if (cause != null) {
                sb.append("\r\nCaused by: ");
            }
        }

        logger.error(sb.toString());
    }
}
