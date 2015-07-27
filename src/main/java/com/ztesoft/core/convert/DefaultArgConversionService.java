/**
 * 
 */
package com.ztesoft.core.convert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.ztesoft.core.common.QueryCondition;
import com.ztesoft.core.common.QueryCondition.ConditionOperation;
import com.ztesoft.framework.dto.AbstractDto;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.exception.SystemErrorCode;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;
import com.ztesoft.framework.util.JsonUtil;

/**
 * <Description>默认的接口实现，根据PO，转换出Arg类 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月17日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.convert <br>
 */

@Service("defaultArgConversionService")
public class DefaultArgConversionService implements IArgConversionService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(DefaultArgConversionService.class);

    /**
     * 使用配置好的类型转换器工厂
     */
    @Autowired
    private FormattingConversionServiceFactoryBean conversionService;

    /**
     * 根据传入的Arg类型，及参数VO，构造出查询参数封装Arg
     * 
     * @param argClass Arg类
     * @param vo 前台到后台查询参数封装的VO
     * @param ignoredUnmatchedMethod 是否忽略不匹配的查询条件（默认不忽略，如果不匹配，抛异常）
     * @return
     * @throws BaseAppException
     */
    @Override
    public <T> T invokeArg(Class<T> argClass, AbstractDto vo)
            throws BaseAppException {
        AssertUtils.isNotNull(argClass, "this argClass not allow null!");
        // 查询条件
        String queryConditions = vo.getQueryConditions();

        T arg = null;
        try {
            arg = argClass.newInstance();
        }
        catch (Exception ex) {
            ExceptionHandler.publish(SystemErrorCode.INSTANCE_EXCEPTION, ex);
        }
        if (null == queryConditions || queryConditions.trim().length() == 0) {
            // 没有查询条件直接返回
            return arg;
        }

        List<QueryCondition> queryConditionsList = JsonUtil.toList(
                queryConditions, QueryCondition.class);
        if (null == queryConditionsList) {
            return arg;
        }

        Method argMethod;
        Object criteria = null;
        Method[] criteriaMethods = null;
        try {
            argMethod = argClass.getMethod("createCriteria");
            criteria = argMethod.invoke(arg);
            criteriaMethods = criteria.getClass().getDeclaredMethods();
        }
        catch (Exception ex) {
            logger.error(ex);
            ExceptionHandler.publish(SystemErrorCode.INVOKE_EXCEPTION, ex);
        }

        Iterator<QueryCondition> iter = queryConditionsList.iterator();

        while (iter.hasNext()) {
            QueryCondition thizondition = (QueryCondition) iter.next();
            try {
                String paramName = thizondition.getParamName();
                String operation = thizondition.getOperation().toString();
                String[] paramValue = thizondition.getParamValue();
                String methodName = "and"
                        + paramName.replaceFirst(paramName.substring(0, 1),
                                paramName.substring(0, 1).toUpperCase())
                        + operation;

                for (Method criteriamethod : criteriaMethods) {
                    // 方法名相等
                    if (criteriamethod.getName().equals(methodName)) {
                        Class<?>[] paramsType = criteriamethod
                                .getParameterTypes();
                        if (ConditionOperation.Between.toString().equals(
                                operation)
                                || ConditionOperation.NotBetween.toString()
                                        .equals(operation)) {
                            // 如果是Between或者NotBetween操作的，取两个值
                            ReflectionUtils.invokeMethod(
                                    criteriamethod,
                                    criteria,
                                    conversionService.getObject().convert(
                                            paramValue[0], paramsType[0]),
                                    conversionService.getObject().convert(
                                            paramValue[1], paramsType[1]));
                        }
                        else if (ConditionOperation.In.toString().equals(
                                operation)
                                || ConditionOperation.NotIn.toString().equals(
                                        operation)) {
                            // 如果是In或者NotIn操作的，取所有值
                            List invokeArgs = new ArrayList();
                            // Object[] invokeArgs = new Object[paramValue.length];
                            for (int i = 0; i < paramValue.length; i++) {
                                invokeArgs.add(conversionService.getObject()
                                        .convert(paramValue[i], Object.class));
                                // invokeArgs[i] = defaultConversionService
                                // .convert(paramValue[i], paramsType[i]);
                            }
                            ReflectionUtils.invokeMethod(criteriamethod,
                                    criteria, invokeArgs);
                        }
                        else {
                            // 其他的操作，只有一种值的情况
                            ReflectionUtils.invokeMethod(
                                    criteriamethod,
                                    criteria,
                                    conversionService.getObject().convert(
                                            thizondition.getParamValue()[0],
                                            paramsType[0]));
                        }

                    }
                }

            }
            catch (Exception ex) {
                logger.error(ex);
                ExceptionHandler.publish(SystemErrorCode.INVOKE_EXCEPTION, ex);
            }
        }

        return arg;
    }

    public static void main(String[] args) throws BaseAppException {
        // DefaultArgConversionService defaultArgConversionService = new DefaultArgConversionService();
        // String jsonStr =
        // "[{\"paramName\":\"userId\",\"operation\":\"EqualTo\",\"paramValue\":[\"1\"]},{\"paramName\":\"userId\",\"operation\":\"GreaterThan\",\"paramValue\":[\"1\"]},{\"paramName\":\"userName\",\"operation\":\"In\",\"paramValue\":[\"1\",\"2\"]}]";
        // AmUserPO po = new AmUserPO();
        // po.setQueryConditions(null);
        // po.setQueryConditions("");
        // po.setQueryConditions("[]");
        // po.setQueryConditions(jsonStr);
        // defalultArgConversionService.invokeArg(AmUserArg.class, po);

    }
}
