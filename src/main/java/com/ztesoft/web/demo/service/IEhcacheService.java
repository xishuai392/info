/**
 * 
 */
package com.ztesoft.web.demo.service;

import java.math.*;
import java.util.*;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.demo.db.arg.EhcacheArg;
import com.ztesoft.web.demo.db.po.EhcachePO;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service <br>
 */

public interface IEhcacheService {

    EhcachePO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<EhcachePO> selectByArg(EhcachePO record) throws BaseAppException;

    Page<EhcachePO> selectByArgAndPage(EhcachePO record,
            Page<EhcachePO> resultPage) throws BaseAppException;

    List<Integer> countByArg(EhcachePO record) throws BaseAppException;

    int add(EhcachePO record) throws BaseAppException;

    int update(EhcachePO record) throws BaseAppException;

    int delete(EhcachePO record) throws BaseAppException;

    int updateByArgSelective(EhcachePO valueRecord, EhcachePO queryRecord)
            throws BaseAppException;

}
