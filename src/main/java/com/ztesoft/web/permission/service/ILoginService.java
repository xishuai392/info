/**
 * 
 */
package com.ztesoft.web.permission.service;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年7月28日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.service <br>
 */

public interface ILoginService {

    AuditUserPO selectUserInfo(String userCode, String password)
            throws BaseAppException;
}
