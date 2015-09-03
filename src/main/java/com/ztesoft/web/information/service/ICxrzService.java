/**
 * 
 */
package com.ztesoft.web.information.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.information.db.po.CxrzPO;

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

public interface ICxrzService {

    CxrzPO selectByPrimaryKey(String key) throws BaseAppException;

    List<CxrzPO> selectByArg(CxrzPO record) throws BaseAppException;

    Page<CxrzPO> selectByArgAndPage(CxrzPO record, Page<CxrzPO> resultPage)
            throws BaseAppException;

    int add(CxrzPO record) throws BaseAppException;

    int update(CxrzPO record) throws BaseAppException;

    int delete(CxrzPO record) throws BaseAppException;

}
