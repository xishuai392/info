/**
 * 
 */
package com.ztesoft.web.information.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;

import com.ztesoft.web.information.db.po.TSqrxxPO;

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

public interface ITSqrxxService {

    TSqrxxPO selectByPrimaryKey(String key) throws BaseAppException;

    List<TSqrxxPO> selectByArg(TSqrxxPO record) throws BaseAppException;

    Page<TSqrxxPO> selectByArgAndPage(TSqrxxPO record, Page<TSqrxxPO> resultPage)
            throws BaseAppException;

    int add(TSqrxxPO record) throws BaseAppException;

    int update(TSqrxxPO record) throws BaseAppException;

    int delete(TSqrxxPO record) throws BaseAppException;

    /**
     * 按查询标示统计用户，打印次数
     * 
     * @param record
     * @return
     * @throws BaseAppException
     */
    int countPrintByZD(TSqrxxPO record) throws BaseAppException;
}
