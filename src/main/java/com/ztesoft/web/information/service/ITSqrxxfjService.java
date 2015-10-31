/**
 * 
 */
package com.ztesoft.web.information.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.information.db.po.TSqrxxfjPO;

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

public interface ITSqrxxfjService {

    TSqrxxfjPO selectByPrimaryKey(String key) throws BaseAppException;

    List<TSqrxxfjPO> selectByArg(TSqrxxfjPO record) throws BaseAppException;

    Page<TSqrxxfjPO> selectByArgAndPage(TSqrxxfjPO record,
            Page<TSqrxxfjPO> resultPage) throws BaseAppException;

    int add(TSqrxxfjPO record) throws BaseAppException;

    int update(TSqrxxfjPO record) throws BaseAppException;

    int delete(TSqrxxfjPO record) throws BaseAppException;

    int deleteBatch(List<TSqrxxfjPO> listRecord) throws BaseAppException;

}
