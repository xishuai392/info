package com.ztesoft.framework.exception;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * 系统异常编码
 */
public class SystemErrorCode {

    /** 未知异常 */
    public final static String UNKNOW_EXPCEPTION = "APP-00-0000";

    /** 数据库操作异常 */
    public final static String DB_OPER_EXPCEPTION = "APP-00-0001";

    /** 主键冲突 */
    public final static String DUPLICATE_KEY_EXCEPTION = "APP-00-0002";

    /** 违反数据完整性异常！ */
    public final static String DATA_INTEGRITY_VIOLATION_EXCEPTION = "APP-00-0003";

    /** sql语句错误 */
    public final static String BAD_SQL_GRAMMAR_EXCEPTION = "APP-00-0004";

    /** 数据库连接错误 */
    public static final String DATABASE_ACCESS_EXCEPTION = "APP-00-0005";

    /** 数据库连接池繁忙 */
    public static final String DB_POOL_BUSY = "APP-00-0006";

    /** 释放数据库连接错误！ */
    public static final String RELEASE_DATABASE_CONNECTION_ERROR = "APP-00-0007";

    /** 查找不到数据源 */
    public static final String LOOKUP_DATASOURCE_ERROR = "APP-00-0008";

    /** 属性配置空异常 */
    public static final String CONFIG_PROPERTIES_NULL = "APP-00-0009";

    /** 文件访问错误 ！ */
    public static final String FILE_ACCESS_ERROR = "APP-00-0010";

    /** 解压文件名警告 */
    public static final String UNZIP_FILE_NAME_ALARM = "APP-00-0011";

    /** 错误的配置属性值 */
    public static final String ERROR_CONFIG_PARAM_VALUE = "APP-00-0012";

    /** 接口文件为空异常 */
    public static final String NULL_INTERFACE_FILE = "APP-00-0013";

    /** 没有找到接口文件 */
    public static final String NO_FIND_INTERFACE_FILE = "APP-00-0014";

    /** 接口文件读取失败 */
    public static final String READ_INTERFACE_FILE_FAIL = "APP-00-0015";

    /** 没有找到日志 */
    public static final String NO_FIND_LOG = "APP-00-0016";

    /** 打开日志失败 */
    public static final String OPEN_LOG_FAIL = "APP-00-0017";

    /** FTP参数错误 */
    public static final String FTP_PARAM_ERR = "APP-00-0018";

    /** FTP发生IO异常 */
    public static final String FTP_IO_ERR = "APP-00-0019";

    /** FTP连接已断开 */
    public static final String FTP_IS_DISCONNECTED = "APP-00-0020";

    /** 未查询到有效的记录！ */
    public static final String NO_VALIDE_RESULT = "APP-00-0021";

    /** 参数不正确异常！ */
    public static final String NO_VALIDE_PARAM = "APP-00-0022";

    /** 无此操作类型！ */
    public static final String NO_THIS_OPER_TYPE = "APP-00-0023";
    
    /**超过授权最大用户数  */
    public static final String OVER_LICENSE_USER_NUM = "APP-00-0024";

    /** Lincense失效 */
    public static final String INVALID_LICENSE = "APP-00-0025";


    /** 证书到期 */
    public static final String EXPIRE_LICENSE = "APP-00-0026";
    
    
    
   

    /** 文件大小超过限制 */
    public static final String MAX_UPLOAD_SIZE_EXCEEDED_EXCEPTION = "APP-00-0030";

    /** 文件[{0}]不存在 <br> */
    public static final String SYS_FILE_NOT_EXIST = "APP-00-0031";

    /** 文件读写异常 <br> */
    public static final String SYS_FILE_IO_EXCEPTION = "APP-00-0032";

    /** 插入异常 */
    public static final String INSERT_EXCEPTION = "APP-00-0040";
    
    /** 更新异常 */
    public static final String UPDATE_EXCEPTION = "APP-00-0041";

    /** 删除异常  */
    public static final String DELETE_EXCEPTION = "APP-00-0042";
    
    /** 获取的序列值为空！  */
    public static final String SQUENCE_IS_NULL = "APP-00-0048";
    
    /** 该类型的主键未初始化！  */
    public static final String SQUENCE_TYPE_NO_INITIALIZE = "APP-00-0049";
    
    
    /** 实例化类异常 */
    public static final String INSTANCE_EXCEPTION = "APP-00-0050";

    /** 反射异常 */
    public static final String INVOKE_EXCEPTION = "APP-00-0051";

    public static final String NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION = "APP-00-0060";

    public static final String HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION = "APP-00-0061";

    public static final String HTTP_MEDIATYPE_NOT_SUPPORTED_EXCEPTION = "APP-00-0062";

    public static final String HTTP_MEDIATYPE_NOT_ACCEPTABLE_EXCEPTION = "APP-00-0063";

    public static final String MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION = "APP-00-0064";

    public static final String SERVLET_REQUEST_BINDING_EXCEPTION = "APP-00-0065";

    public static final String CONVERSION_NOT_SUPPORTED_EXCEPTION = "APP-00-0066";

    public static final String TYPE_MISMATCH_EXCEPTION = "APP-00-0067";

    public static final String HTTP_MESSAGE_NOT_READABLE_EXCEPTION = "APP-00-0068";

    public static final String HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION = "APP-00-0069";

    public static final String METHOD_ARGUMENT_NOT_VALID_EXCEPTION = "APP-00-0070";

    public static final String MISSING_SERVLET_REQUESTPART_EXCEPTION = "APP-00-0071";

    public static final String BIND_EXCEPTION = "APP-00-0072";

    /** 未知运行时异常 <br> */
    public static final String UNKNOW_RUNTIME_EXPCEPTION = "APP-00-0100";
}
