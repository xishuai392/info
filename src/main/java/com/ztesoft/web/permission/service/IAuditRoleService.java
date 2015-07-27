/**
 * 
 */
package com.ztesoft.web.permission.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.permission.db.po.AuditRolePO;

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

public interface IAuditRoleService {

    AuditRolePO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<AuditRolePO> selectByArg(AuditRolePO record) throws BaseAppException;

    Page<AuditRolePO> selectByArgAndPage(AuditRolePO record, Page<AuditRolePO> resultPage)
            throws BaseAppException;

    int add(AuditRolePO record) throws BaseAppException;

    int update(AuditRolePO record) throws BaseAppException;

    int delete(AuditRolePO record) throws BaseAppException;

}
