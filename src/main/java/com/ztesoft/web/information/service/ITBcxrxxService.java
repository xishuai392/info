/**
 * 
 */
package com.ztesoft.web.information.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.information.db.po.TBcxrxxPO;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.service <br>
 */

public interface ITBcxrxxService {

    TBcxrxxPO selectByPrimaryKey(String key) throws BaseAppException;

    List<TBcxrxxPO> selectByArg(TBcxrxxPO record) throws BaseAppException;

    Page<TBcxrxxPO> selectByArgAndPage(TBcxrxxPO record, Page<TBcxrxxPO> resultPage)
            throws BaseAppException;

    int add(TBcxrxxPO record) throws BaseAppException;

    int update(TBcxrxxPO record) throws BaseAppException;

    int delete(TBcxrxxPO record) throws BaseAppException;

}
