/**
 * 
 */
package com.ztesoft.web.demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.demo.db.arg.AmUserArg;
import com.ztesoft.web.demo.db.dao.AmUserDao;
import com.ztesoft.web.demo.db.po.AmUserPO;
import com.ztesoft.web.demo.service.IAmUserService;
import com.ztesoft.web.domain.TableInfoConstants;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service.impl <br>
 */

@Service("amUserService")
public class AmUserServiceImpl implements IAmUserService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AmUserServiceImpl.class);

    @Autowired
    private AmUserDao amUserDao;

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
    public AmUserPO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return amUserDao.selectByPrimaryKey(key);
    }

    @Override
    public List<AmUserPO> selectByArg(AmUserPO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        AmUserArg arg = argConversionService.invokeArg(AmUserArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return amUserDao.selectByArg(arg);
    }

    @Override
    public Page<AmUserPO> selectByArgAndPage(AmUserPO record,
            Page<AmUserPO> resultPage) throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // AmUserArg arg = new AmUserArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // AmUserCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        AmUserArg arg = argConversionService.invokeArg(AmUserArg.class, record);

        resultPage = amUserDao.selectByArgAndPage(arg, resultPage);

        return resultPage;
    }

    @Override
    public int add(AmUserPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // record.setUserId(2);
        // record.setCreatedDate(new Date());
        // ///////

        // 获取主键
        int userId = sequenceGenerator.sequenceIntValue(
                TableInfoConstants.AM_USER, TableInfoConstants.AM_USER_PKFIELD);

        record.setUserId(userId);
        record.setCreatedDate(new Date());
        return amUserDao.insertSelective(record);
    }

    @Override
    public int update(AmUserPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return amUserDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(AmUserPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return amUserDao.deleteByPrimaryKey(record.getUserId());
    }

}
