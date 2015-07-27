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

import com.ztesoft.web.permission.db.arg.AuditMenuRoleArg;
import com.ztesoft.web.permission.db.arg.AuditMenuRoleArg.AuditMenuRoleCriteria;
import com.ztesoft.web.permission.db.dao.AuditMenuRoleDao;
import com.ztesoft.web.permission.db.po.AuditMenuRolePO;
import com.ztesoft.web.permission.service.IAuditMenuRoleService;

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

@Service("auditMenuRoleService")
public class AuditMenuRoleServiceImpl implements IAuditMenuRoleService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditMenuRoleServiceImpl.class);

    @Autowired
    private AuditMenuRoleDao auditMenuRoleDao;
    

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
    public AuditMenuRolePO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return auditMenuRoleDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AuditMenuRolePO> selectByArg(AuditMenuRolePO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //AuditMenuRoleArg arg = new AuditMenuRoleArg();
        //AuditMenuRoleCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditMenuRoleArg arg = argConversionService.invokeArg(AuditMenuRoleArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return auditMenuRoleDao.selectByArg(arg);
    }

    @Override
    public Page<AuditMenuRolePO> selectByArgAndPage(AuditMenuRolePO record, Page<AuditMenuRolePO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditMenuRoleArg arg = new AuditMenuRoleArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AuditMenuRoleCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditMenuRoleArg arg = argConversionService.invokeArg(AuditMenuRoleArg.class, record);

        resultPage = auditMenuRoleDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(AuditMenuRolePO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return auditMenuRoleDao.insertSelective(record);
    }

    @Override
    public int update(AuditMenuRolePO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return auditMenuRoleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AuditMenuRolePO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return auditMenuRoleDao.deleteByPrimaryKey(record.getMenuRoleId());
    }

}
