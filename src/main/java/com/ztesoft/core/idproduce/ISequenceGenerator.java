/**
 * 
 */
package com.ztesoft.core.idproduce;

import com.ztesoft.framework.exception.BaseAppException;

/**
 * <Description>（主键）序列号生成器接口 ：用于生成其他数据库表的主键<br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月27日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.db.dao <br>
 */

public interface ISequenceGenerator {
    /**
     * 默认的数据库Schema名
     */
    static final String DEFAULT_SCHEMA = "DEF";

    /**
     * 根据表名、字段名，默认的schema名，获取一个Integer类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 字段名
     * @return
     * @throws BaseAppException
     */
    Integer sequenceIntValue(String tableName, String columnName)
            throws BaseAppException;

    /**
     * 根据表名、字段名，默认的schema名，获取一个Long类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 字段名
     * @return
     * @throws BaseAppException
     */
    Long sequenceLongValue(String tableName, String columnName)
            throws BaseAppException;

    /**
     * 根据表名、字段名，schema名，获取一个Integer类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 字段名
     * @param schemaName 数据库实例名
     * @return
     * @throws BaseAppException
     */
    Integer sequenceIntValue(String tableName, String columnName,
            String schemaName) throws BaseAppException;

    /**
     * 根据表名、字段名，schema名，获取一个Long类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 字段名
     * @param schemaName 数据库实例名
     * @return
     * @throws BaseAppException
     */
    Long sequenceLongValue(String tableName, String columnName,
            String schemaName) throws BaseAppException;

    /**
     * 根据表名、字段名，默认的schema名，获取count个Integer类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 字段名
     * @param count 获取的个数
     * @return
     * @throws BaseAppException
     */
    Integer[] sequenceBatchIntValue(String tableName, String columnName,
            Integer count) throws BaseAppException;

    /**
     * 根据表名、字段名，默认的schema名，获取count个Long类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 字段名
     * @param count 获取的个数
     * @return
     * @throws BaseAppException
     */
    Long[] sequenceBatchLongValue(String tableName, String columnName,
            Integer count) throws BaseAppException;

    /**
     * 根据表名、字段名，schema名，获取count个Integer类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 表名
     * @param schemaName 数据库实例名
     * @param count 获取的个数
     * @return
     * @throws BaseAppException
     */
    Integer[] sequenceBatchIntValue(String tableName, String columnName,
            String schemaName, Integer count) throws BaseAppException;

    /**
     * 根据表名、字段名，schema名，获取count个Long类型的sequence值
     * 
     * @param tableName 表名
     * @param columnName 表名
     * @param schemaName 数据库实例名
     * @param count 获取的个数
     * @return
     * @throws BaseAppException
     */
    Long[] sequenceBatchLongValue(String tableName, String columnName,
            String schemaName, Integer count) throws BaseAppException;

}
