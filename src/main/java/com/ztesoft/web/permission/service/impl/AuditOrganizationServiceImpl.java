/**
 * 
 */
package com.ztesoft.web.permission.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.FrameWorkConstants;
import com.ztesoft.web.domain.TableInfoConstants;
import com.ztesoft.web.permission.db.arg.AuditOrganizationArg;
import com.ztesoft.web.permission.db.arg.AuditOrganizationArg.AuditOrganizationCriteria;
import com.ztesoft.web.permission.db.arg.AuditUserArg;
import com.ztesoft.web.permission.db.arg.AuditUserArg.AuditUserCriteria;
import com.ztesoft.web.permission.db.dao.AuditOrganizationDao;
import com.ztesoft.web.permission.db.dao.AuditUserDao;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;
import com.ztesoft.web.permission.db.po.AuditUserPO;
import com.ztesoft.web.permission.service.IAuditOrganizationService;

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

@Service("auditOrganizationService")
public class AuditOrganizationServiceImpl implements IAuditOrganizationService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditOrganizationServiceImpl.class);

    @Autowired
    private AuditOrganizationDao auditOrganizationDao;
    
    @Autowired
    private AuditUserDao auditUserDao;

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
    public AuditOrganizationPO selectByPrimaryKey(Long key)
            throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return auditOrganizationDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AuditOrganizationPO> selectByArg(AuditOrganizationPO record)
            throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditOrganizationArg arg = new AuditOrganizationArg();
        // AuditOrganizationCriteria criteria = arg.createCriteria();

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditOrganizationArg arg = argConversionService.invokeArg(
                AuditOrganizationArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return auditOrganizationDao.selectByArg(arg);
    }

    @Override
    public Page<AuditOrganizationPO> selectByArgAndPage(
            AuditOrganizationPO record, Page<AuditOrganizationPO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditOrganizationArg arg = new AuditOrganizationArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AuditOrganizationCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditOrganizationArg arg = argConversionService.invokeArg(
                AuditOrganizationArg.class, record);

        resultPage = auditOrganizationDao.selectByArgAndPage(arg, resultPage);

        return resultPage;
    }

    @Override
    public int add(AuditOrganizationPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        Long pkId = sequenceGenerator.sequenceLongValue(
                TableInfoConstants.AUDIT_ORGANIZATION,
                TableInfoConstants.AUDIT_ORGANIZATION_PKFIELD);
        record.setOrgId(pkId);
        record.setState(FrameWorkConstants.STATUS_EFF);
        record.setCreatedTime(new Date());
        record.setStateTime(new Date());
        record.setOrgLevel(2L);
        // ///////

        return auditOrganizationDao.insertSelective(record);
    }

    @Override
    public int update(AuditOrganizationPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////
        

        return auditOrganizationDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AuditOrganizationPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////
        //查询是否有下级组织
        AuditOrganizationArg orgArg = new AuditOrganizationArg();
        AuditOrganizationCriteria orgCriteria = orgArg.createCriteria();
        orgCriteria.andParentOrgIdEqualTo(record.getOrgId());
        List<AuditOrganizationPO>  orgResult = auditOrganizationDao.selectByArg(orgArg);
        if(null!=orgResult&&orgResult.size()>0){
            throw ExceptionHandler.publish("APP-01-0002", "本组织架构存在下级组织，不能删除！");
        }
        
        //查询是否有用户挂在该组织下
        AuditUserArg userArg = new AuditUserArg();
        AuditUserCriteria userCriteria = userArg.createCriteria();
        userCriteria.andOrgIdEqualTo(record.getOrgId());
        List<AuditUserPO> userResult = auditUserDao.selectByArg(userArg);
        if(null!=userResult&&userResult.size()>0){
            throw ExceptionHandler.publish("APP-01-0003", "本组织架构存在用户，不能删除！");
        }

        return auditOrganizationDao.deleteByPrimaryKey(record.getOrgId());
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.web.permission.service.IAuditOrganizationService#changeOrgParent(java.lang.Long, java.lang.Long)
     */
    @Override
    public boolean changeOrgParent(Long orgId, Long newParentId)
            throws BaseAppException {
        AuditOrganizationPO record = new AuditOrganizationPO();
        record.setParentOrgId(newParentId);
        record.setOrgId(orgId);
        auditOrganizationDao.updateByPrimaryKeySelective(record);
        return true;
    }

}
