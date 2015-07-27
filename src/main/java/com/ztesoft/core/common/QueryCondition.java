/**
 * 
 */
package com.ztesoft.core.common;

/**
 * <Description>查询条件类，主要用于传递参数、参数操作符 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月14日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.common <br>
 */

public class QueryCondition {

    public String paramName;

    public String[] paramValue;

    // 查询所用到的运算操作符
    public ConditionOperation operation;

    /**
     * <Description>操作类型 <br>
     * 
     * @author pan.xiaobo<br>
     * @version 1.0<br>
     * @taskId <br>
     * @CreateDate 2014年11月17日 <br>
     * @since V1.0<br>
     * @see com.ztesoft.core.common <br>
     */
    public enum ConditionOperation {

        IsNull, // XXXX is null
        IsNotNull, // XXXX is not null
        EqualTo, // 等于 =
        NotEqualTo, // 不等于 <>
        GreaterThan, // 大于 >
        GreaterThanOrEqualTo, // 大于等于 >=
        LessThan, // 小于 <
        LessThanOrEqualTo, // 小于等于 <=
        Like, // 模糊查询 XXXX like %value%
        NotLike, // XXXX not like %value%
        LeftLike, // XXXX like %value
        NotLeftLike, // XXXX not like %value
        RightLike, // XXXX like value%
        NotRightLike, // XXXX not like value%
        In, // in ()
        NotIn, // not in ()
        Between, // 范围 between
        NotBetween;// not between

    }

    /**
     * @return the paramName
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * @param paramName the paramName to set
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * @return the paramValue
     */
    public String[] getParamValue() {
        return paramValue;
    }

    /**
     * @param paramValue the paramValue to set
     */
    public void setParamValue(String[] paramValue) {
        this.paramValue = paramValue;
    }

    /**
     * @return the operation
     */
    public ConditionOperation getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(ConditionOperation operation) {
        this.operation = operation;
    }

}
