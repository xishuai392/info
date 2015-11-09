/**
 * 
 */
package com.ztesoft.web.byTheQuery.service.impl;

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
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.Utils;
import com.ztesoft.web.byTheQuery.db.arg.TBcxrxxArg;
import com.ztesoft.web.byTheQuery.db.arg.TBcxrxxArg.TBcxrxxCriteria;
import com.ztesoft.web.byTheQuery.db.dao.TBcxrxxDao1;
import com.ztesoft.web.byTheQuery.db.po.TBcxrxxPO;
import com.ztesoft.web.byTheQuery.service.ITBcxrxxService;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.byTheQuery.service.impl <br>
 */

@Service("tBcxrxxService1")
public class TBcxrxxServiceImpl1 implements ITBcxrxxService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TBcxrxxServiceImpl1.class);

    @Autowired
    private TBcxrxxDao1 tBcxrxxDao;
    

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
    public TBcxrxxPO selectByPrimaryKey(String key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return tBcxrxxDao.selectByPrimaryKey(key);
    }

    @Override
    public List<TBcxrxxPO> selectByArg(TBcxrxxPO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //TBcxrxxArg arg = new TBcxrxxArg();
        //TBcxrxxCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        TBcxrxxArg arg = argConversionService.invokeArg(TBcxrxxArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return tBcxrxxDao.selectByArg(arg);
    }

    @Override
    public Page<TBcxrxxPO> selectByArgAndPage(TBcxrxxPO record, Page<TBcxrxxPO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // TBcxrxxArg arg = new TBcxrxxArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // TBcxrxxCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        TBcxrxxArg arg = argConversionService.invokeArg(TBcxrxxArg.class, record);

        resultPage = tBcxrxxDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(TBcxrxxPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return tBcxrxxDao.insertSelective(record);
    }

    @Override
    public int update(TBcxrxxPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return tBcxrxxDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(TBcxrxxPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return tBcxrxxDao.deleteByPrimaryKey(record.getId());
    }

    /* (non-Javadoc)
     * @see com.ztesoft.web.byTheQuery.service.ITBcxrxxService#select4Page(com.ztesoft.web.byTheQuery.db.po.TBcxrxxPO, com.ztesoft.core.common.Page)
     */
    @Override
    public Page<TBcxrxxPO> select4Page(TBcxrxxPO record,
            Page<TBcxrxxPO> resultPage) throws BaseAppException {
        
        record.setStartDateStr(DateUtils.date2String(record.getStartDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        record.setEndDateStr(DateUtils.date2String(record.getEndDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        return tBcxrxxDao.select4Page(record, resultPage);
    }

}
