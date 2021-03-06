/**
 * 
 */
package com.ztesoft.web.permission.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.FrameWorkConstants;
import com.ztesoft.web.domain.TableInfoConstants;
import com.ztesoft.web.permission.db.arg.AuditUserRoleArg;
import com.ztesoft.web.permission.db.arg.AuditUserRoleArg.AuditUserRoleCriteria;
import com.ztesoft.web.permission.db.dao.AuditUserRoleDao;
import com.ztesoft.web.permission.db.po.AuditUserRolePO;
import com.ztesoft.web.permission.service.IAuditUserRoleService;

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

@Service("auditUserRoleService")
public class AuditUserRoleServiceImpl implements IAuditUserRoleService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditUserRoleServiceImpl.class);

    @Autowired
    private AuditUserRoleDao auditUserRoleDao;

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
    public AuditUserRolePO selectByPrimaryKey(Integer key)
            throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return auditUserRoleDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AuditUserRolePO> selectByArg(AuditUserRolePO record)
            throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditUserRoleArg arg = new AuditUserRoleArg();
        // AuditUserRoleCriteria criteria = arg.createCriteria();

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditUserRoleArg arg = argConversionService.invokeArg(
                AuditUserRoleArg.class, record);

        if (arg.getOredCriteria().size() == 0) {
            arg.createCriteria();
        }
        AuditUserRoleCriteria criteria = arg.getOredCriteria().get(0);
        criteria.andUserIdEqualTo(record.getUserId());

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return auditUserRoleDao.selectByArg(arg);
    }

    @Override
    public Page<AuditUserRolePO> selectByArgAndPage(AuditUserRolePO record,
            Page<AuditUserRolePO> resultPage) throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditUserRoleArg arg = new AuditUserRoleArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AuditUserRoleCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditUserRoleArg arg = argConversionService.invokeArg(
                AuditUserRoleArg.class, record);

        resultPage = auditUserRoleDao.selectByArgAndPage(arg, resultPage);

        return resultPage;
    }

    @Override
    public int add(AuditUserRolePO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return auditUserRoleDao.insertSelective(record);
    }

    @Override
    public int update(AuditUserRolePO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return auditUserRoleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AuditUserRolePO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return auditUserRoleDao.deleteByPrimaryKey(record.getUserRoleId());
    }

    @Override
    public boolean insertBatch(int userId, String[] roleIds)
            throws BaseAppException {
        AuditUserRoleArg arg = new AuditUserRoleArg();
        AuditUserRoleCriteria criteria = arg.createCriteria();
        criteria.andUserIdEqualTo(userId);
        auditUserRoleDao.deleteByArg(arg);

        if (null == roleIds || roleIds.length == 0)
            return true;
        List<AuditUserRolePO> newRecords = new ArrayList<AuditUserRolePO>();
        Integer[] keys = sequenceGenerator.sequenceBatchIntValue(
                TableInfoConstants.AUDIT_USER_ROLE,
                TableInfoConstants.AUDIT_USER_ROLE_PKFIELD, roleIds.length);
        int i = 0;
        for (String roleId : roleIds) {
            if (StringUtils.isNotBlank(roleId)) {
                AuditUserRolePO tmp = new AuditUserRolePO();
                tmp.setUserId(userId);
                tmp.setRoleId(Integer.valueOf(roleId.trim()));
                tmp.setUserRoleId(keys[i++]);
                tmp.setState(FrameWorkConstants.STATUS_EFF);
                newRecords.add(tmp);
            }
        }
        auditUserRoleDao.insertBatch(newRecords);

        return true;
    }

}
