package com.ztesoft.framework.dto;

import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ztesoft.framework.util.EqualsUtils;
import com.ztesoft.framework.util.HashCodeUtils;
import com.ztesoft.framework.util.StringUtils;

/**
 * <Description>PO、DTO、VO 基础类 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月14日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.framework.dto <br>
 */
public abstract class AbstractDto implements java.io.Serializable,
        java.lang.Cloneable {

    public AbstractDto() {

    }

    /**
     * 封装前台传入的查询参数对象（包含查询字段、查询操作、查询值）<br>
     * 形如：[{\"paramName\":\"userName\",\"operation\":\"Like\",\"paramValue\":[\"1\"]}...]
     */
    @JsonIgnore
    private String queryConditions;

    public AbstractDto copy() {
        try {
            return (AbstractDto) this.clone();
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /**
     * 提供默认的HashCode算法 当前对象上自己定义的Field才会参与Hash值计算，不包含父类的Field
     * 
     * @return int 返回哈希值<br>
     */
    @Override
    public int hashCode() {
        int result = 17;

        Field[] fieldList = this.getClass().getDeclaredFields();
        if (fieldList != null) {
            for (Field field : fieldList) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                try {
                    Object thisValue = field.get(this);
                    result = 37 * result + HashCodeUtils.hashCode(thisValue);
                }
                catch (IllegalArgumentException e) {
                    return super.hashCode();
                }
                catch (IllegalAccessException e) {
                    return super.hashCode();
                }
            }
        }

        return result;

    }

    /**
     * 判断两个对象是否相等 当前对象上自己定义的Field才会参与比较，不包含父类的Field
     * 
     * @param obj 要比较的对象
     * @return boolean 两个对象相等才会返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        Field[] fieldList = this.getClass().getDeclaredFields();
        if (fieldList != null) {
            for (Field field : fieldList) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                try {
                    Object thisValue = field.get(this);
                    Object thatValue = field.get(obj);
                    if (!EqualsUtils.equals(thisValue, thatValue)) {
                        return false;
                    }
                }
                catch (IllegalArgumentException e) {
                    super.equals(obj);
                }
                catch (IllegalAccessException e) {
                    super.equals(obj);
                }
            }
        }

        return true;
    }

    /**
     * 重载toString()函数 当前对象上自己定义的Field才会被输出，不包含父类的Field
     * 
     * @return String 返回字符串
     */
    @Override
    public String toString() {
        StringBuffer returnStr = new StringBuffer();
        Field[] fieldList = this.getClass().getDeclaredFields();
        if (fieldList != null) {
            returnStr.append("Ojbect Value List :").append(
                    System.getProperty("line.separator"));
            for (Field field : fieldList) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                returnStr.append(field.getName()).append(":[");
                String value;
                try {
                    value = StringUtils.toString(field.get(this));
                }
                catch (IllegalArgumentException e) {
                    value = "";
                }
                catch (IllegalAccessException e) {
                    value = "";
                }
                returnStr.append(value).append("]")
                        .append(System.getProperty("line.separator"));
            }
        }
        return returnStr.toString();
    }

    /**
     * @return the queryConditions
     */
    public String getQueryConditions() {
        return queryConditions;
    }

    /**
     * @param queryConditions the queryConditions to set
     */
    public void setQueryConditions(String queryConditions) {
        this.queryConditions = queryConditions;
    }

}
