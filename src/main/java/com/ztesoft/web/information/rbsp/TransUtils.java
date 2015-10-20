/**
 * 
 */
package com.ztesoft.web.information.rbsp;

/** 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.rbsp <br>
 */

public class TransUtils {
    public static String transSex(String source){
        if("0".equals(source))
            return "男";
        return "女";
    }
}
