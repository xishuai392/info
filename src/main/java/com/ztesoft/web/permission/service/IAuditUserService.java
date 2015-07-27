/**
 * 
 */
package com.ztesoft.web.permission.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.service <br>
 */

public interface IAuditUserService {

    AuditUserPO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<AuditUserPO> selectByArg(AuditUserPO record) throws BaseAppException;

    Page<AuditUserPO> selectByArgAndPage(AuditUserPO record, Page<AuditUserPO> resultPage)
            throws BaseAppException;

    int add(AuditUserPO record) throws BaseAppException;

    int update(AuditUserPO record) throws BaseAppException;

    int delete(AuditUserPO record) throws BaseAppException;

}
