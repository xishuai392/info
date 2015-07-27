/**
 * 
 */
package com.ztesoft.core.mybatis.cache;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.cache.TransactionalCacheManager;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.jdbc.SqlBuilder;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description>本拦截器会拦截CachingExecutor的query方法，在创建cacheKey时将分页参数page包含其中。 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年6月3日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.cache <br>
 */

@Intercepts({
    @Signature(type = Executor.class, method = "query", args = {
            MappedStatement.class, Object.class, RowBounds.class,
            ResultHandler.class
    })
})
public class CacheInterceptor implements Interceptor {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(CacheInterceptor.class);

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    private static String defaultPageSqlId = ".*Page$"; // 需要拦截的ID(正则匹配)

    private static String pageSqlId = ""; // 需要拦截的ID(正则匹配)

    public static final String CACHEPAGE = "cachePage";// 分页Page的缓存key

    public static final String RESULTLIST = "resultList";// 分页结果的缓存key

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Executor executorProxy = (Executor) invocation.getTarget();
        MetaObject metaExecutor = MetaObject.forObject(executorProxy,
                DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        // 分离代理对象链
        while (metaExecutor.hasGetter("h")) {
            Object object = metaExecutor.getValue("h");
            metaExecutor = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
                    DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        // 分离最后一个代理对象的目标类
        while (metaExecutor.hasGetter("target")) {
            Object object = metaExecutor.getValue("target");
            metaExecutor = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
                    DEFAULT_OBJECT_WRAPPER_FACTORY);
        }
        Object[] args = invocation.getArgs();
        return this.query(metaExecutor, args);
    }

    public <E> List<E> query(MetaObject metaExecutor, Object[] args)
            throws SQLException {
        MappedStatement ms = (MappedStatement) args[0];
        Object parameterObject = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];
        BoundSql boundSql = ms.getBoundSql(parameterObject);
        CacheKey cacheKey = createCacheKey(ms, parameterObject, rowBounds,
                boundSql);
        return this.query(metaExecutor, ms, cacheKey, parameterObject,
                rowBounds, resultHandler, boundSql);
    }

    @SuppressWarnings("unchecked")
    private <E> List<E> query(MetaObject metaExecutor, MappedStatement ms,
            CacheKey cacheKey, Object parameterObject, RowBounds rowBounds,
            ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        MetaObject metaParameter = MetaObject.forObject(parameterObject,
                DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
        // 当需要分页查询时，缓存里加入page信息
        if (rowBounds instanceof Page || ms.getId().matches(pageSqlId)) {
            Cache cache = ms.getCache();
            if (cache != null) {
                if (ms.isUseCache() && resultHandler == null) {
                    if (!(Boolean) metaExecutor.getValue("dirty")) {
                        cache.getReadWriteLock().readLock().lock();
                        try {
                            Object value = cache.getObject(cacheKey);
                            if (value != null) {
                                HashMap<String, Object> cachedMap = (HashMap<String, Object>) value;
                                Page cachedPage = (Page) cachedMap
                                        .get(CACHEPAGE);
                                Page originalPage = (Page) rowBounds;
                                if (null != originalPage) {
                                    int totalRecords = cachedPage
                                            .getTotalRecords();
                                    originalPage.setTotalRecords(totalRecords);
                                    int totalPages = totalRecords
                                            / originalPage.getLimit()
                                            + ((totalRecords
                                                    % originalPage.getLimit() == 0) ? 0
                                                    : 1);
                                    originalPage.setTotalPages(totalPages);
                                    return (List<E>) cachedMap.get(RESULTLIST);
                                }
                            }
                        }
                        finally {
                            cache.getReadWriteLock().readLock().unlock();
                        }
                    }
                }
                Executor delegate = (Executor) metaExecutor
                        .getValue("delegate");
                List<E> list = delegate.query(ms, parameterObject, rowBounds,
                        resultHandler, cacheKey, boundSql);
                TransactionalCacheManager tcm = (TransactionalCacheManager) metaExecutor
                        .getValue("tcm");
                HashMap<String, Object> cachedMap = new HashMap<String, Object>();
                cachedMap.put(CACHEPAGE, rowBounds);
                cachedMap.put(RESULTLIST, list);
                tcm.putObject(cache, cacheKey, cachedMap);
                return list;
            }
        }
        Executor executor = (Executor) metaExecutor.getOriginalObject();
        return executor.query(ms, parameterObject, rowBounds, resultHandler,
                cacheKey, boundSql);
    }

    private CacheKey createCacheKey(MappedStatement ms, Object parameterObject,
            RowBounds rowBounds, BoundSql boundSql) {
        Configuration configuration = ms.getConfiguration();
        pageSqlId = configuration.getVariables().getProperty("pageSqlId");
        if (null == pageSqlId || "".equals(pageSqlId)) {
            logger.warn("Property pageSqlId is not setted,use default '.*Page$' ");
            pageSqlId = defaultPageSqlId;
        }
        CacheKey cacheKey = new CacheKey();
        cacheKey.update(ms.getId());
        cacheKey.update(rowBounds.getOffset());
        cacheKey.update(rowBounds.getLimit());
        List<ParameterMapping> parameterMappings = boundSql
                .getParameterMappings();

        logger.debug("boundSql.getSql():[%s]", boundSql.getSql());

        cacheKey.update(boundSql.getSql());

        MetaObject metaObject = MetaObject.forObject(parameterObject,
                DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);

        if (parameterMappings.size() > 0 && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = ms.getConfiguration()
                    .getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                cacheKey.update(parameterObject);
            }
            else {
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        cacheKey.update(metaObject.getValue(propertyName));
                    }
                    else if (boundSql.hasAdditionalParameter(propertyName)) {
                        cacheKey.update(boundSql
                                .getAdditionalParameter(propertyName));
                    }
                }
            }
        }
        // 当需要分页查询时，将page参数里的当前页和每页数加到cachekey里
        if (rowBounds instanceof Page || ms.getId().matches(pageSqlId)) {
            Page page = (Page) rowBounds;
            if (null != page) {
                cacheKey.update(page.getPage());
                cacheKey.update(page.getLimit());
            }
        }
        return cacheKey;
    }

    /**
     * 只拦截CachingExecutor，其他的直接返回目标本身
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof CachingExecutor) {
            return Plugin.wrap(target, this);
        }
        else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

    private SqlSource buildSqlSource(Configuration configuration,
            String originalSql, Class<?> parameterType) {
        SqlSourceBuilder builder = new SqlSourceBuilder(configuration);
        return builder.parse(originalSql, parameterType, null);
    }
}
