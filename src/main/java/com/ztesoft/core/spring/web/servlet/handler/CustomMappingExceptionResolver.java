package com.ztesoft.core.spring.web.servlet.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.exception.SystemErrorCode;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.framework.util.Utils;

/**
 * <Description>统一异常捕获 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年9月2日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.spring.web.servlet.handler <br>
 */
public class CustomMappingExceptionResolver extends
        SimpleMappingExceptionResolver {

    private final static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(CustomMappingExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) {

        // 记录所有异常日志
        logger.error(ex);

        String errCode;
        String msg;
        if (ex instanceof BaseAppException) {
            errCode = ((BaseAppException) ex).getCode();
            if (Utils.isEmpty(errCode)) {
                errCode = "";
                msg = ((BaseAppException) ex).getDesc();
            }
            else {
                msg = MessageResourceUtils.getMessage(errCode);
            }

        }
        else if (ex instanceof DuplicateKeyException) {
            errCode = SystemErrorCode.DUPLICATE_KEY_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof DataIntegrityViolationException) {
            errCode = SystemErrorCode.DATA_INTEGRITY_VIOLATION_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof BadSqlGrammarException) {
            errCode = SystemErrorCode.BAD_SQL_GRAMMAR_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof DataAccessException) {
            errCode = SystemErrorCode.DATABASE_ACCESS_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof CannotCreateTransactionException) {
            errCode = SystemErrorCode.DATABASE_ACCESS_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof MaxUploadSizeExceededException) {
            errCode = SystemErrorCode.MAX_UPLOAD_SIZE_EXCEEDED_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }

        // Spring DefaultHandlerExceptionResolver 处理的异常----begin
        else if (ex instanceof NoSuchRequestHandlingMethodException) {
            errCode = SystemErrorCode.NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof HttpRequestMethodNotSupportedException) {
            errCode = SystemErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof HttpMediaTypeNotSupportedException) {
            errCode = SystemErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof HttpMediaTypeNotAcceptableException) {
            errCode = SystemErrorCode.HTTP_MEDIATYPE_NOT_ACCEPTABLE_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof MissingServletRequestParameterException) {
            errCode = SystemErrorCode.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof ServletRequestBindingException) {
            errCode = SystemErrorCode.SERVLET_REQUEST_BINDING_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof ConversionNotSupportedException) {
            errCode = SystemErrorCode.CONVERSION_NOT_SUPPORTED_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof TypeMismatchException) {
            errCode = SystemErrorCode.TYPE_MISMATCH_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof HttpMessageNotReadableException) {
            errCode = SystemErrorCode.HTTP_MESSAGE_NOT_READABLE_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof HttpMessageNotWritableException) {
            errCode = SystemErrorCode.HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof MethodArgumentNotValidException) {
            errCode = SystemErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof MissingServletRequestPartException) {
            errCode = SystemErrorCode.MISSING_SERVLET_REQUESTPART_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else if (ex instanceof BindException) {
            errCode = SystemErrorCode.BIND_EXCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        // Spring DefaultHandlerExceptionResolver 处理的异常----end

        else if (ex instanceof SysRuntimeException) {
            errCode = ((SysRuntimeException) ex).getErrorCode();
            msg = (null == errCode ? MessageResourceUtils
                    .getMessage(SystemErrorCode.UNKNOW_RUNTIME_EXPCEPTION)
                    : MessageResourceUtils.getMessage(errCode));
        }
        else if (ex instanceof RuntimeException) {
            errCode = SystemErrorCode.UNKNOW_RUNTIME_EXPCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        else {
            errCode = SystemErrorCode.UNKNOW_EXPCEPTION;
            msg = MessageResourceUtils.getMessage(errCode);
        }
        String responseMsg = "{\"msg\":\"" + msg
                + "\",\"success\":false,\"errCode\":\"" + errCode + "\"}";

        // Expose ModelAndView for chosen error view.
        String viewName = determineViewName(ex, request);
        if (viewName != null) {// JSP格式返回
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                    .getHeader("X-Requested-With") != null && request
                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                // 如果不是异步请求
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            }
            else {// JSON格式返回
                try {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(responseMsg);
                    writer.flush();
                }
                catch (IOException e) {
                    logger.error(e);
                }
                return null;

            }
        }
        else {
            return null;
        }

    }
}
