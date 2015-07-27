/**
 * 
 */
package com.ztesoft.web.permission.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.permission.db.po.AuditUserRolePO;

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

public interface IAuditUserRoleService {

    AuditUserRolePO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<AuditUserRolePO> selectByArg(AuditUserRolePO record) throws BaseAppException;

    Page<AuditUserRolePO> selectByArgAndPage(AuditUserRolePO record, Page<AuditUserRolePO> resultPage)
            throws BaseAppException;

    int add(AuditUserRolePO record) throws BaseAppException;

    int update(AuditUserRolePO record) throws BaseAppException;

    int delete(AuditUserRolePO record) throws BaseAppException;

}
