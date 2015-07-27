package com.ztesoft.framework.exception;

/**
 * <Description>系统运行时异常 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月14日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.framework.exception <br>
 */
public class SysRuntimeException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8905824282709341010L;

    @Override
    public String toString() {
        return "SysException [message=" + getMessage() + "]";
    }

    private String errorCode;

    public SysRuntimeException(Throwable e) {
        super(e);
    }

    public SysRuntimeException(Throwable e, String message) {
        super(message, e);
    }

    public SysRuntimeException(String message) {
        super(message);
    }

    public SysRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public SysRuntimeException(String errorCode, Throwable e) {
        super(e);
        this.errorCode = errorCode;
    }

    public SysRuntimeException(String errorCode, String message, Throwable e) {
        super(message, e);
        this.errorCode = errorCode;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

}
