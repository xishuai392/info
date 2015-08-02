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
import com.ztesoft.web.permission.db.arg.AuditMenuArg;
import com.ztesoft.web.permission.db.arg.AuditMenuArg.AuditMenuCriteria;
import com.ztesoft.web.permission.db.dao.AuditMenuDao;
import com.ztesoft.web.permission.db.po.AuditMenuPO;
import com.ztesoft.web.permission.db.po.AuditUserPO;
import com.ztesoft.web.permission.service.IAuditMenuService;

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

@Service("auditMenuService")
public class AuditMenuServiceImpl implements IAuditMenuService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditMenuServiceImpl.class);

    @Autowired
    private AuditMenuDao auditMenuDao;
    

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
    public AuditMenuPO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return auditMenuDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AuditMenuPO> selectByArg(AuditMenuPO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //AuditMenuArg arg = new AuditMenuArg();
        //AuditMenuCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditMenuArg arg = argConversionService.invokeArg(AuditMenuArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return auditMenuDao.selectByArg(arg);
    }

    @Override
    public Page<AuditMenuPO> selectByArgAndPage(AuditMenuPO record, Page<AuditMenuPO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AuditMenuArg arg = new AuditMenuArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AuditMenuCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AuditMenuArg arg = argConversionService.invokeArg(AuditMenuArg.class, record);

        resultPage = auditMenuDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(AuditMenuPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return auditMenuDao.insertSelective(record);
    }

    @Override
    public int update(AuditMenuPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return auditMenuDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AuditMenuPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return auditMenuDao.deleteByPrimaryKey(record.getMenuId());
    }

    /* (non-Javadoc)
     * @see com.ztesoft.web.permission.service.IAuditMenuService#selectMenuTree4User(com.ztesoft.web.permission.db.po.AuditUserPO, com.ztesoft.web.permission.db.po.AuditMenuPO)
     */
    @Override
    public List<AuditMenuPO> selectMenuTree4User(AuditUserPO sessionUserPO,
            AuditMenuPO qryRecord) {
        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userCode", sessionUserPO.getUserCode());
        paramMap.put("parentMenuId", qryRecord.getParentMenuId());
        return auditMenuDao.selectMenuTree4User(paramMap);
    }

}
