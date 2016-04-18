/**
 * 
 */
package com.ztesoft.core.excel;

/**
 * <Description>自定义注解 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.excel <br>
 */

public @interface PropertyAnnotation {
    /**
     * 属性名称描述 （默认值为 "Unknown"）
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:40:20
     * @return
     */
    String PropertyName() default "Unknown";

    /**
     * 属性索引键 （默认值为 "-1"）
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:40:29
     * @return
     */
    int PropertySortKey() default -1;
}
