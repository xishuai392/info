/**
 * 
 */
package com.ztesoft.web.permission.service.impl;

import java.math.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;

import com.ztesoft.web.permission.db.arg.AuditRoleArg;
import com.ztesoft.web.permission.db.arg.AuditRoleArg.AuditRoleCriteria;
import com.ztesoft.web.permission.db.dao.AuditRoleDao;
import com.ztesoft.web.permission.db.po.AuditRolePO;
import com.ztesoft.web.permission.service.IAuditRoleService;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.service.impl <br>
 */

@Service("auditRoleService")
public class AuditRoleServiceImpl implements IAuditRoleService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditRoleServiceImpl.class);

    @Autowired
    private AuditRoleDao auditRoleDao;
    

    /**
     * 查询条件转换成Arg类的服务接口
     */
    @Resource(name = "defaultArgConversionService")
    private IArgConversionService argConversionService;

    /**
     * 主键生成器
     */
    @Resource(name = "sequenceProcGenerator")
    private ISequenceGenerator sequenceGenerator;
    

    @Override
    public AuditRolePO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return auditRoleDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AuditRolePO> selectByArg(AuditRolePO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //AuditRoleArg arg = new AuditRoleArg();
        //AuditRoleCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditRoleArg arg = argConversionService.invokeArg(AuditRoleArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return auditRoleDao.selectByArg(arg);
    }

    @Override
    public Page<AuditRolePO> selectByArgAndPage(AuditRolePO record, Page<AuditRolePO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditRoleArg arg = new AuditRoleArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AuditRoleCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditRoleArg arg = argConversionService.invokeArg(AuditRoleArg.class, record);

        resultPage = auditRoleDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(AuditRolePO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return auditRoleDao.insertSelective(record);
    }

    @Override
    public int update(AuditRolePO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return auditRoleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AuditRolePO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return auditRoleDao.deleteByPrimaryKey(record.getRoleId());
    }

}
