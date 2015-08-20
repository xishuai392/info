/**
 * 
 */
package com.ztesoft.web.permission.service;

import java.util.List;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;

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

public interface IAuditOrganizationService {

    AuditOrganizationPO selectByPrimaryKey(Long key) throws BaseAppException;

    List<AuditOrganizationPO> selectByArg(AuditOrganizationPO record)
            throws BaseAppException;

    Page<AuditOrganizationPO> selectByArgAndPage(AuditOrganizationPO record,
            Page<AuditOrganizationPO> resultPage) throws BaseAppException;

    int add(AuditOrganizationPO record) throws BaseAppException;

    int update(AuditOrganizationPO record) throws BaseAppException;

    int delete(AuditOrganizationPO record) throws BaseAppException;

    boolean changeOrgParent(Long orgId, Long newParentId)
            throws BaseAppException;

}
