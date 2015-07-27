/**
 * 
 */
package com.ztesoft.core.idproduce;

import com.ztesoft.framework.exception.BaseAppException;

/**
 * <Description>序列号生成器抽象类 ：用于生成其他数据库表的主键 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月27日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.idproduce <br>
 */

public abstract class AbstractSequenceGenerator implements ISequenceGenerator {

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceIntValue(java.lang.String, java.lang.String)
     */
    @Override
    public Integer sequenceIntValue(String tableName, String columnName)
            throws BaseAppException {
        return sequenceIntValue(tableName, columnName, DEFAULT_SCHEMA);
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceLongValue(java.lang.String, java.lang.String)
     */
    @Override
    public Long sequenceLongValue(String tableName, String columnName)
            throws BaseAppException {
        return sequenceLongValue(tableName, columnName, DEFAULT_SCHEMA);
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceIntValue(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Integer sequenceIntValue(String tableName, String columnName,
            String schemaName) throws BaseAppException {
        return sequenceBatchIntValue(tableName, columnName, schemaName, 1)[0];
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceLongValue(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Long sequenceLongValue(String tableName, String columnName,
            String schemaName) throws BaseAppException {
        return sequenceBatchLongValue(tableName, columnName, schemaName, 1)[0];
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceBatchIntValue(java.lang.String, java.lang.String, java.lang.Integer)
     */
    @Override
    public Integer[] sequenceBatchIntValue(String tableName, String columnName,
            Integer count) throws BaseAppException {
        return sequenceBatchIntValue(tableName, columnName, DEFAULT_SCHEMA,
                count);
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceBatchLongValue(java.lang.String, java.lang.String, java.lang.Integer)
     */
    @Override
    public Long[] sequenceBatchLongValue(String tableName, String columnName,
            Integer count) throws BaseAppException {
        return sequenceBatchLongValue(tableName, columnName, DEFAULT_SCHEMA,
                count);
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceBatchIntValue(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.Integer)
     */
    @Override
    public Integer[] sequenceBatchIntValue(String tableName, String columnName,
            String schemaName, Integer count) throws BaseAppException {
        Long[] longSeqs = sequenceBatchLongValue(tableName, columnName,
                schemaName, count);
        Integer[] intSeqs = new Integer[longSeqs.length];
        int i = 0;
        for (long l : longSeqs) {
            intSeqs[i] = new Long(l).intValue();
            i++;
        }
        return intSeqs;
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.idproduce.ISequenceGenerator#sequenceBatchLongValue(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.Integer)
     */
    @Override
    public abstract Long[] sequenceBatchLongValue(String tableName,
            String columnName, String schemaName, Integer count)
            throws BaseAppException;

}
