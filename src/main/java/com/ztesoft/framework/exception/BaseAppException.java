package com.ztesoft.framework.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ztesoft.framework.util.ExceptionUtils;
import com.ztesoft.framework.util.MessageResourceUtils;

/**
 * <Description> 基本异常信息 <br>
 */
public final class BaseAppException extends Exception implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2630051619397959471L;

    private int id;

    private String code;

    private String desc;

    private String localeMessage;

    private Date time;

    private int type;

    public BaseAppException() {
        super();
    }

    public BaseAppException(String code) {
        this(code, null, ExceptionHandler.SYS_ERROR_TYPE, null, null, null,
                null);
    }

    public BaseAppException(String code, String msg) {
        this(code, msg, ExceptionHandler.SYS_ERROR_TYPE, null, null, null, null);
    }

    public BaseAppException(String code, String msg, String arg0) {
        this(code, msg, ExceptionHandler.SYS_ERROR_TYPE, null, arg0, null, null);
    }

    public BaseAppException(String code, Throwable cause) {
        this(code, null, ExceptionHandler.SYS_ERROR_TYPE, cause, null, null,
                null);
    }

    public BaseAppException(String code, int errorType, Throwable cause) {
        this(code, null, errorType, cause, null, null, null);
    }

    public BaseAppException(String code, String msg, int errorType) {
        this(code, msg, errorType, null, null, null, null);
    }

    public BaseAppException(String code, String param1, Throwable cause) {
        this(code, null, ExceptionHandler.SYS_ERROR_TYPE, cause, param1, null,
                null);
    }

    public BaseAppException(String code, String param1, String param2,
            Throwable cause) {
        this(code, null, ExceptionHandler.SYS_ERROR_TYPE, cause, param1,
                param2, null);
    }

    /**
     * 为了可对异常信息进行参数替换，扩展了String arg0,String arg1,String arg2 三个参数
     * 
     * @param errorCode
     * @param message
     * @param errorType
     * @param cause
     * @param arg0
     * @param arg1
     * @param arg2
     */
    public BaseAppException(String errorCode, String message, int errorType,
            Throwable cause, String arg0, String arg1, String arg2) {
        /** @todo* */
        super(message, cause);

        List<String> list = new ArrayList<String>(3);
        if (arg0 != null) {
            list.add(arg0);
        }
        if (arg1 != null) {
            list.add(arg1);
        }
        if (arg2 != null) {
            list.add(arg2);
        }
        String[] args = null;

        if (list.size() > 0) {
            args = new String[list.size()];
            int i = 0;
            for (String s : list) {
                args[i++] = s;
            }
        }

        this.code = errorCode;
        this.desc = message;
        BaseAppException beCause = ExceptionUtils
                .getFirstBaseAppException(cause);
        if (beCause == null) {
            this.type = errorType;
        }
        else {
            this.type = beCause.getType();
        }

        this.localeMessage = (code == null ? "" : MessageResourceUtils
                .getMessage(code));

        if (args != null && args.length > 0) {
            this.localeMessage = this.replaceArgs(localeMessage, args);
        }
    }

    /**
     * @param s
     * @param args
     * @return
     */
    private String replaceArgs(String s, String args[]) {
        int i = 0;
        if (s != null && args != null && args.length > 0) {
            StringBuilder sb = new StringBuilder();
            Pattern p = Pattern.compile("\\{(.*?)\\}");
            Matcher m = p.matcher(s);
            while (m.find()) {
                s = s.replaceFirst("\\{(.*?)\\}", args[i++]);
            }
            sb.append(s);
            return sb.toString();
        }

        return "";
    }

    /**
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param code String
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @param desc String
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @param time Date
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @param type int
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * @return String
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @return Date
     */
    public Date getTime() {
        if (time == null) {
            time = new Date();
        }
        return time;
    }

    public int getType() {
        return type;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("errorCode = [");
        sb.append(code);
        sb.append("] errorDesc = [");
        if (localeMessage != null) {
            sb.append(localeMessage);
        }
        sb.append("]");
        if (desc != null) {
            sb.append("  Describing= [");
            sb.append(desc);
            sb.append("]");
        }

        return sb.toString();
    }

    public String toStringNonTrace() {
        StringBuilder sb = new StringBuilder();

        sb.append("errorCode = [");
        sb.append(code);
        sb.append("] errorDesc = [");
        if (localeMessage != null) {
            sb.append(localeMessage);
        }
        sb.append("]");
        if (desc != null) {
            sb.append("  Describing= [");
            sb.append(desc);
            sb.append("]");
        }

        Throwable cause = getCause();
        if (cause != null) {
            while (true) {
                if (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                else {
                    break;
                }
            }
        }
        if (cause != null) {
            sb.append(" cause = [");
            sb.append(cause.getClass().getName());
            sb.append(":");
            sb.append(cause.getMessage());
            sb.append("]");
        }
        return sb.toString();
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = getLocaleMessage();
            if (code != null) {
                message = new StringBuilder().append('[').append(code)
                        .append("] ").append(message).toString();
            }
        }
        else if (code != null) {
            message = new StringBuilder().append('[').append(code).append("] ")
                    .append(message).toString();
        }
        return message;
    }

    public String getLocaleMessage() {
        return localeMessage;
    }

    public void setLocaleMessage(String localeMessage) {
        this.localeMessage = localeMessage;
    }

    public String getDetailMessage() {
        StringBuilder content = new StringBuilder();
        if (code != null) {
            content.append('[').append(code).append("] ");
        }
        if (localeMessage != null) {
            content.append('[').append(localeMessage.trim()).append("] ");
        }
        String message = super.getMessage();
        if (message != null) {
            content.append('[').append(message.trim()).append("] ");
        }
        return content.toString();
    }
}
