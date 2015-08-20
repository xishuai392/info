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
import com.ztesoft.framework.util.AssertUtils;
import com.ztesoft.framework.util.MD5Utils;
import com.ztesoft.framework.util.Utils;
import com.ztesoft.web.domain.TableInfoConstants;
import com.ztesoft.web.permission.db.arg.AuditUserArg;
import com.ztesoft.web.permission.db.arg.AuditUserArg.AuditUserCriteria;
import com.ztesoft.web.permission.db.dao.AuditUserDao;
import com.ztesoft.web.permission.db.po.AuditUserPO;
import com.ztesoft.web.permission.service.IAuditUserService;

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

@Service("auditUserService")
public class AuditUserServiceImpl implements IAuditUserService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditUserServiceImpl.class);

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
    public AuditUserPO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return auditUserDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AuditUserPO> selectByArg(AuditUserPO record)
            throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditUserArg arg = new AuditUserArg();
        // AuditUserCriteria criteria = arg.createCriteria();

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditUserArg arg = argConversionService.invokeArg(AuditUserArg.class,
                record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return auditUserDao.selectByArg(arg);
    }

    @Override
    public Page<AuditUserPO> selectByArgAndPage(AuditUserPO record,
            Page<AuditUserPO> resultPage) throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditUserArg arg = new AuditUserArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AuditUserCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditUserArg arg = argConversionService.invokeArg(AuditUserArg.class,
                record);
        if (arg.getOredCriteria().size() == 0) {
            arg.createCriteria();
        }
        AuditUserCriteria criteria = arg.getOredCriteria().get(0);
        if (Utils.notEmpty(record.getOrgId())) {
            criteria.andOrgIdEqualTo(record.getOrgId());
        }

        resultPage = auditUserDao.selectByArgAndPage(arg, resultPage);

        return resultPage;
    }

    @Override
    public int add(AuditUserPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // 判断该用户编码是否已经存在
        AuditUserArg arg = new AuditUserArg();
        AuditUserCriteria criteria = arg.createCriteria();
        criteria.andUserCodeEqualTo(record.getUserCode());

        List<AuditUserPO> existList = auditUserDao.selectByArg(arg);
        if (existList.size() > 0)
            ExceptionHandler.publish("APP-01-0001", "用户名已经存在");

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        int pkId = sequenceGenerator.sequenceIntValue(
                TableInfoConstants.AUDIT_USER,
                TableInfoConstants.AUDIT_USER_PKFIELD);
        record.setUserId(pkId);
        record.setCreatedDate(new Date());

        // ///////

        return auditUserDao.insertSelective(record);
    }

    @Override
    public int update(AuditUserPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return auditUserDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AuditUserPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return auditUserDao.deleteByPrimaryKey(record.getUserId());
    }

    /* (non-Javadoc)
     * @see com.ztesoft.web.permission.service.IAuditUserService#updPassword(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean updPassword(String userCode, String newPassword,
            String oldPassword) throws BaseAppException {
        AssertUtils.isNotEmpty(userCode, "用户名不能为空！");
        AssertUtils.isNotEmpty(newPassword, "密码不能为空！");
        
        
        // 判断该用户密码是否正确
        AuditUserArg arg = new AuditUserArg();
        AuditUserCriteria criteria = arg.createCriteria();
        criteria.andUserCodeEqualTo(userCode);
        String pasEncode = MD5Utils.MD5(oldPassword).toLowerCase();
        criteria.andPasswordEqualTo(pasEncode);
        List<AuditUserPO> result = auditUserDao.selectByArg(arg);
        if(null==result||result.size()==0){
            throw ExceptionHandler.publish("APP-01-0004", "您输入的旧密码错误！");
        }
        
        AuditUserPO record = new AuditUserPO();
        record.setUserId(result.get(0).getUserId());
        record.setPassword(MD5Utils.MD5(newPassword).toLowerCase());
        auditUserDao.updateByPrimaryKeySelective(record);
        
        return true;
    }

}
