/**
 * 
 */
package com.ztesoft.core.spring.cache;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.cache.interceptor.DefaultKeyGenerator;

import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description> 针对Spring的cache缓存策略制定自定义的key生成策略<br/>
 * 会对所有非空值参数进行遍历，然后进行字符累加（如果为自定义对象，会累加对象的hashCode），最后对累加的字符串取hashCode<br/>
 * <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年6月4日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.spring.cache <br>
 */

public class HashCodeKeyGenerator extends DefaultKeyGenerator {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(HashCodeKeyGenerator.class);

    /*
     * (non-Javadoc)
     * @see org.springframework.cache.interceptor.DefaultKeyGenerator#generate(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuffer buffer = new StringBuffer();
        @SuppressWarnings("rawtypes")
        Class entityClass = target.getClass();
        buffer.append(entityClass.getName());
        if (params != null && params.length >= 1) {
            for (Object obj : params) {
                if (obj != null) {
                    if (obj instanceof AtomicInteger
                            || obj instanceof AtomicLong
                            || obj instanceof BigDecimal
                            || obj instanceof BigInteger || obj instanceof Byte
                            || obj instanceof Double || obj instanceof Float
                            || obj instanceof Integer || obj instanceof Long
                            || obj instanceof Short) {
                        buffer.append(obj);
                    }
                    else if (obj instanceof List || obj instanceof Set
                            || obj instanceof Map) {
                        buffer.append(obj);
                    }
                    else {
                        buffer.append(obj.hashCode());
                    }
                }
            }
        }

        int keyGenerator = buffer.toString().hashCode();

        logger.debug("HashCodeKeyGenerator created key:" + buffer.toString() + " -- " + keyGenerator);

        return keyGenerator;
    }

}
