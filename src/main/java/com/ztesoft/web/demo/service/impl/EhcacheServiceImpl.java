/**
 * 
 */
package com.ztesoft.web.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.demo.db.arg.EhcacheArg;
import com.ztesoft.web.demo.db.arg.EhcacheArg.EhcacheCriteria;
import com.ztesoft.web.demo.db.dao.EhcacheDao;
import com.ztesoft.web.demo.db.po.EhcachePO;
import com.ztesoft.web.demo.service.IEhcacheService;

/**
 * <Description> <br>
 * 
 * @author codeCreater<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service.impl <br>
 */

@Service("ehcacheService")
public class EhcacheServiceImpl implements IEhcacheService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(EhcacheServiceImpl.class);

    @Autowired
    private EhcacheDao ehcacheDao;

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
    public EhcachePO selectByPrimaryKey(Integer key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return ehcacheDao.selectByPrimaryKey(key);
    }

    @Override
    public List<EhcachePO> selectByArg(EhcachePO record)
            throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // EhcacheArg arg = new EhcacheArg();
        // EhcacheCriteria criteria = arg.createCriteria();

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                record);

        EhcacheCriteria criteria = arg.createCriteria();
        criteria.andEmpNameLike(record.getEmpName());

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return ehcacheDao.selectByArg(arg);
    }

    public List<Integer> countByArg(EhcachePO record) throws BaseAppException {
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                record);

        EhcacheCriteria criteria = arg.createCriteria();
        criteria.andEmpNameLike(record.getEmpName());

        return ehcacheDao.countByArg(arg);
    }

    @Override
    @Cacheable(value = {
        "frameworkCache"
    })
    public Page<EhcachePO> selectByArgAndPage(EhcachePO record,
            Page<EhcachePO> resultPage) throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // EhcacheArg arg = new EhcacheArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // EhcacheCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                record);

        resultPage = ehcacheDao.selectByArgAndPage(arg, resultPage);

        return resultPage;
    }

    @Override
    public int add(EhcachePO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        int pkId = sequenceGenerator.sequenceIntValue("EHCACHE", "EMP_ID");
        record.setEmpId(pkId);
        // ///////

        return ehcacheDao.insertSelective(record);
    }

    @Override
    public int update(EhcachePO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return ehcacheDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(EhcachePO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return ehcacheDao.deleteByPrimaryKey(record.getEmpId());
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.web.demo.service.IEhcacheService#updateByArg(com.ztesoft.web.demo.db.po.EhcachePO, com.ztesoft.web.demo.db.po.EhcachePO)
     */
    @Override
    public int updateByArgSelective(EhcachePO valueRecord, EhcachePO queryRecord)
            throws BaseAppException {
        EhcacheArg arg = argConversionService.invokeArg(EhcacheArg.class,
                queryRecord);

        EhcacheCriteria criteria = arg.createCriteria();
        criteria.andEmpNameLike(queryRecord.getEmpName());

        ehcacheDao.updateByArgSelective(valueRecord, arg);
        return 0;
    }

}
