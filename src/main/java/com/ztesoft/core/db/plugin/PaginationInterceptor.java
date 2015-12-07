package com.ztesoft.core.db.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
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
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.log.ZTEsoftLogManager;

@Intercepts({
    @Signature(type = StatementHandler.class, method = "prepare", args = {
        Connection.class
    })
})
public class PaginationInterceptor<K, V> implements Interceptor {
    // 日志对象
    private final static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(PaginationInterceptor.class);

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    private String dialect = null;

    /*
     * (non-Javadoc)
     * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin .Invocation)
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation
                .getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(
                statementHandler, DEFAULT_OBJECT_FACTORY,
                DEFAULT_OBJECT_WRAPPER_FACTORY);

        RowBounds rowBounds = (RowBounds) metaStatementHandler
                .getValue("delegate.rowBounds");

        if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
            return invocation.proceed();
        }
        else {

            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
                    .getValue("delegate.mappedStatement");
            BoundSql boundSql = (BoundSql) metaStatementHandler
                    .getValue("delegate.boundSql");

            Object additionalParameters = metaStatementHandler
                    .getValue("delegate.boundSql.additionalParameters");
            Object parameterObject = getParameterObject(boundSql,
                    additionalParameters);

            Connection connection = (Connection) invocation.getArgs()[0];

            Page<?> page = (Page<?>) rowBounds;

            // 设置查询总条数的sql
            setTotalSql(boundSql.getSql(), connection, mappedStatement,
                    boundSql, parameterObject, page);

            // 重设分页参数里的总页数等
            setPageParameter(boundSql, metaStatementHandler, page);
            return invocation.proceed();
        }

    }

    /**
     * 构造查询参数
     * 
     * @param parameterObject
     * @param boundSql
     * @return
     */
    public Map getParameterObject(BoundSql boundSql, Object additionalParameters) {
        Object parameterObject = boundSql.getParameterObject();
        Map paramMap = null;
        if (parameterObject == null) {
            paramMap = new HashMap();
        }
        else if (parameterObject instanceof Map) {
            paramMap = (Map) parameterObject;
        }
        else {
            paramMap = new HashMap();
            // 这里以及下面使用的地方，主要解决一个参数时的问题，例如使用一个参数Country使用id属性时，不这样处理会导致id=Country
            MetaObject metaObject = MetaObject.forObject(parameterObject,
                    DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
            if (boundSql.getParameterMappings() != null
                    && boundSql.getParameterMappings().size() > 0) {
                for (ParameterMapping parameterMapping : boundSql
                        .getParameterMappings()) {
                    String name = parameterMapping.getProperty();
                    if (parameterMapping.getJavaType().isAssignableFrom(
                            parameterObject.getClass())) {
                        paramMap.put(name, parameterObject);
                    }
                    else {
                        //paramMap.put(name, metaObject.getValue(name));
                    }
                }
            }
            
            //fixed by pan.xiaobo 20151207 解决分页查询中，查询总数的SQL语句会丢失变量值问题
            String[] metaParamsNames = metaObject.getGetterNames();
            if (null != metaParamsNames) {
                for (String paramName : metaParamsNames) {
                    paramMap.put(paramName, metaObject.getValue(paramName));
                }
            }
        }
        if (null != additionalParameters)
            paramMap.putAll((Map) additionalParameters);
        return paramMap;
    }

    /**
     * 设置分页查询语句
     * 
     * @param boundSql
     * @param metaStatementHandler
     * @param page
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public void setPageParameter(BoundSql boundSql,
            MetaObject metaStatementHandler, Page<?> page)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        Dialect dialect = (Dialect) Class.forName(this.dialect).newInstance();
        metaStatementHandler.setValue(
                "delegate.boundSql.sql",
                dialect.getLimitString(boundSql.getSql(), page.getStart(),
                        page.getLimit()));
        metaStatementHandler.setValue("delegate.rowBounds.offset",
                RowBounds.NO_ROW_OFFSET);
        metaStatementHandler.setValue("delegate.rowBounds.limit",
                RowBounds.NO_ROW_LIMIT);
        // logger.debug("生成分页SQL : " + boundSql.getSql());
    }

    /*
     * (non-Javadoc)
     * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用者就可用通过 分页参数 <code>PageParameter</code>获得相关信息。
     * 
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @param page
     */
    private void setTotalSql(String sql, Connection connection,
            MappedStatement mappedStatement, BoundSql boundSql,
            Object parameterObject, Page<?> page) {
        // 记录总记录数
        String countSql = "select count(0) total from (" + sql + ") b";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),
                    countSql, boundSql.getParameterMappings(), parameterObject);
            setParameters(countStmt, mappedStatement, countBS, parameterObject);
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            page.setTotalRecords(totalCount);

        }
        catch (SQLException e) {
            logger.error("paging on exception", e);
        }
        finally {
            try {
                if (null != rs)
                    rs.close();
            }
            catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
            try {
                if (null != countStmt)
                    countStmt.close();
            }
            catch (SQLException e) {
                logger.error("Ignore this exception", e);
            }
        }

    }

    /**
     * 对SQL参数(?)设值
     * 
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param parameterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps,
            MappedStatement mappedStatement, BoundSql boundSql,
            Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(
                mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }

    /*
     * (non-Javadoc)
     * @see org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
     */
    /**
     * 设置注册拦截器时设定的属性
     */
    public void setProperties(Properties properties) {
        this.dialect = properties.getProperty("dialect");
    }

}
