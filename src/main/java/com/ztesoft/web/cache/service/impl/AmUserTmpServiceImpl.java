/**
 * 
 */
package com.ztesoft.web.cache.service.impl;

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

import com.ztesoft.web.cache.db.arg.AmUserTmpArg;
import com.ztesoft.web.cache.db.arg.AmUserTmpArg.AmUserTmpCriteria;
import com.ztesoft.web.cache.db.dao.AmUserTmpDao;
import com.ztesoft.web.cache.db.po.AmUserTmpPO;
import com.ztesoft.web.cache.service.IAmUserTmpService;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.cache.service.impl <br>
 */

@Service("amUserTmpService")
public class AmUserTmpServiceImpl implements IAmUserTmpService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AmUserTmpServiceImpl.class);

    @Autowired
    private AmUserTmpDao amUserTmpDao;
    

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
    public AmUserTmpPO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return amUserTmpDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AmUserTmpPO> selectByArg(AmUserTmpPO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //AmUserTmpArg arg = new AmUserTmpArg();
        //AmUserTmpCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AmUserTmpArg arg = argConversionService.invokeArg(AmUserTmpArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return amUserTmpDao.selectByArg(arg);
    }

    @Override
    public Page<AmUserTmpPO> selectByArgAndPage(AmUserTmpPO record, Page<AmUserTmpPO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AmUserTmpArg arg = new AmUserTmpArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AmUserTmpCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AmUserTmpArg arg = argConversionService.invokeArg(AmUserTmpArg.class, record);

        resultPage = amUserTmpDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(AmUserTmpPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
         int pkId = sequenceGenerator.sequenceIntValue("AM_USER_TMP","USER_ID");
         record.setUserId(pkId);
         record.setCreatedDate(new Date());
        // ///////

        return amUserTmpDao.insertSelective(record);
    }

    @Override
    public int update(AmUserTmpPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return amUserTmpDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AmUserTmpPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return amUserTmpDao.deleteByPrimaryKey(record.getUserId());
    }

}
