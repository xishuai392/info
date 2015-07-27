/**
 * 
 */
package com.ztesoft.web.demo.service;

import java.util.List;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.demo.db.po.AmUserPO;

/**
 * <Description>DEMO示例，用户信息管理 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service <br>
 */

public interface IAmUserService {

    AmUserPO selectByPrimaryKey(Integer key) throws BaseAppException;

    List<AmUserPO> selectByArg(AmUserPO record) throws BaseAppException;

    Page<AmUserPO> selectByArgAndPage(AmUserPO record, Page<AmUserPO> resultPage)
            throws BaseAppException;

    int add(AmUserPO record) throws BaseAppException;

    int update(AmUserPO record) throws BaseAppException;

    int delete(AmUserPO record) throws BaseAppException;

}
