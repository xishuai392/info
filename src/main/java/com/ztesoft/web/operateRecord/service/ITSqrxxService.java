/**
 * 
 */
package com.ztesoft.web.operateRecord.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.operateRecord.db.po.TSqrxxPO;
import com.ztesoft.web.operateRecord.db.po.TSqrxxfjPO;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.operateRecord.service <br>
 */

public interface ITSqrxxService {

    TSqrxxPO selectByPrimaryKey(String key) throws BaseAppException;

    /**
     * 通过申请人ID查询附件信息
     * @param sqrId
     * @return
     * @throws BaseAppException
     */
    public List<TSqrxxfjPO> selectSqrxxfjBySqrId(String sqrId) throws BaseAppException;
    
    List<TSqrxxPO> selectByArg(TSqrxxPO record) throws BaseAppException;

    Page<TSqrxxPO> selectByArgAndPage(TSqrxxPO record, Page<TSqrxxPO> resultPage)
            throws BaseAppException;

    int add(TSqrxxPO record) throws BaseAppException;

    int update(TSqrxxPO record) throws BaseAppException;

    int delete(TSqrxxPO record) throws BaseAppException;

}
