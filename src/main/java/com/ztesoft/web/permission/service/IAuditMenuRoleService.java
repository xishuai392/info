/**
 * 
 */
package com.ztesoft.web.permission.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.permission.db.po.AuditMenuRolePO;

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

public interface IAuditMenuRoleService {

    AuditMenuRolePO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<AuditMenuRolePO> selectByArg(AuditMenuRolePO record) throws BaseAppException;

    Page<AuditMenuRolePO> selectByArgAndPage(AuditMenuRolePO record, Page<AuditMenuRolePO> resultPage)
            throws BaseAppException;

    int add(AuditMenuRolePO record) throws BaseAppException;

    int update(AuditMenuRolePO record) throws BaseAppException;

    int delete(AuditMenuRolePO record) throws BaseAppException;
    
    boolean saveMenuIdsByRoleId(int roleId,Integer[]menuIds) throws BaseAppException;

}
