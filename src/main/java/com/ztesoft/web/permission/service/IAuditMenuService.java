/**
 * 
 */
package com.ztesoft.web.permission.service;

import java.util.List;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.permission.db.po.AuditMenuPO;
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

public interface IAuditMenuService {

    AuditMenuPO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<AuditMenuPO> selectByArg(AuditMenuPO record) throws BaseAppException;

    Page<AuditMenuPO> selectByArgAndPage(AuditMenuPO record, Page<AuditMenuPO> resultPage)
            throws BaseAppException;

    int add(AuditMenuPO record) throws BaseAppException;

    int update(AuditMenuPO record) throws BaseAppException;

    int delete(AuditMenuPO record) throws BaseAppException;

    List<AuditMenuPO> selectMenuTree4User(AuditUserPO sessionUserPO,AuditMenuPO qryRecord);
}
