/**
 * 
 */
package com.ztesoft.web.cache.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.cache.db.po.AmUserTmpPO;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.cache.service <br>
 */

public interface IAmUserTmpService {

    AmUserTmpPO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<AmUserTmpPO> selectByArg(AmUserTmpPO record) throws BaseAppException;

    Page<AmUserTmpPO> selectByArgAndPage(AmUserTmpPO record, Page<AmUserTmpPO> resultPage)
            throws BaseAppException;

    int add(AmUserTmpPO record) throws BaseAppException;

    int update(AmUserTmpPO record) throws BaseAppException;

    int delete(AmUserTmpPO record) throws BaseAppException;

}
