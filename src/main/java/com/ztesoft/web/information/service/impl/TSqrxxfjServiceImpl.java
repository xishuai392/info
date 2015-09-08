/**
 * 
 */
package com.ztesoft.web.information.service.impl;

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
import com.ztesoft.framework.util.Utils;

import com.ztesoft.web.information.db.arg.TSqrxxfjArg;
import com.ztesoft.web.information.db.arg.TSqrxxfjArg.TSqrxxfjCriteria;
import com.ztesoft.web.information.db.dao.TSqrxxfjDao;
import com.ztesoft.web.information.db.po.TSqrxxfjPO;
import com.ztesoft.web.information.service.ITSqrxxfjService;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.service.impl <br>
 */

@Service("tSqrxxfjService")
public class TSqrxxfjServiceImpl implements ITSqrxxfjService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TSqrxxfjServiceImpl.class);

    @Autowired
    private TSqrxxfjDao tSqrxxfjDao;
    

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
    public TSqrxxfjPO selectByPrimaryKey(String key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return tSqrxxfjDao.selectByPrimaryKey(key);
    }

    @Override
    public List<TSqrxxfjPO> selectByArg(TSqrxxfjPO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //TSqrxxfjArg arg = new TSqrxxfjArg();
        //TSqrxxfjCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        TSqrxxfjArg arg = argConversionService.invokeArg(TSqrxxfjArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return tSqrxxfjDao.selectByArg(arg);
    }

    @Override
    public Page<TSqrxxfjPO> selectByArgAndPage(TSqrxxfjPO record, Page<TSqrxxfjPO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // TSqrxxfjArg arg = new TSqrxxfjArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // TSqrxxfjCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        TSqrxxfjArg arg = argConversionService.invokeArg(TSqrxxfjArg.class, record);

        resultPage = tSqrxxfjDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(TSqrxxfjPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return tSqrxxfjDao.insertSelective(record);
    }

    @Override
    public int update(TSqrxxfjPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return tSqrxxfjDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(TSqrxxfjPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return tSqrxxfjDao.deleteByPrimaryKey(record.getId());
    }

}
