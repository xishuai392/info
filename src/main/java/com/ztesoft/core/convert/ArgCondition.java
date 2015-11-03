/**
 * 
 */
package com.ztesoft.core.convert;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description>Arg的拼装条件 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年11月2日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.convert <br>
 */

public class ArgCondition extends AbstractDto {

    private String paramName;

    private String operation;

    private String[] paramValue;

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
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
        this.operation = operation;
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


}
