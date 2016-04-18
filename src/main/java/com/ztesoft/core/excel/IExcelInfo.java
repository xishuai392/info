/**
 * 
 */
package com.ztesoft.core.excel;

import java.util.List;

/**
 * <Description>获取Excel信息的接口 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.excel <br>
 */

public interface IExcelInfo {
    /**
     * 获取表头数据
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:28:50
     * @return
     */

    public List<String> getHeaders();

    /**
     * 获取有效属性所对应的值
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:28:58
     * @param obj
     * @param methodName
     * @return
     * @throws Exception
     */
    public String getContent(Object obj, String methodName) throws Exception;
}
