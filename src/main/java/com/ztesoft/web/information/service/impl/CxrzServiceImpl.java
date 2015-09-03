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

import com.ztesoft.web.information.db.arg.CxrzArg;
import com.ztesoft.web.information.db.arg.CxrzArg.CxrzCriteria;
import com.ztesoft.web.information.db.dao.CxrzDao;
import com.ztesoft.web.information.db.po.CxrzPO;
import com.ztesoft.web.information.service.ICxrzService;

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

@Service("cxrzService")
public class CxrzServiceImpl  implements ICxrzService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(CxrzServiceImpl.class);

    @Autowired
    private CxrzDao cxrzDao;
    

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
    public CxrzPO selectByPrimaryKey(String key) throws BaseAppException {
        // ///////
        // TODO 根据业务场景，设置查询条件、数据校验等

        // ///////
        return cxrzDao.selectByPrimaryKey(key);
    }

    @Override
    public List<CxrzPO> selectByArg(CxrzPO record) throws BaseAppException {
        logger.debug("selectByArg begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        //CxrzArg arg = new CxrzArg();
        //CxrzCriteria criteria = arg.createCriteria();
        
        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        CxrzArg arg = argConversionService.invokeArg(CxrzArg.class, record);

        // ///////
        // TODO 根据业务场景，设置查询条件，示例
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }
        // ///////

        return cxrzDao.selectByArg(arg);
    }

    @Override
    public Page<CxrzPO> selectByArgAndPage(CxrzPO record, Page<CxrzPO> resultPage)
            throws BaseAppException {
        logger.debug("selectByArgAndPage begin...record={0}", record);

        // 第一种方式：自己创建arg，自行设置查询条件及操作符
        // CxrzArg arg = new CxrzArg();
        // //TODO 根据业务场景，设置查询条件，示例
        // CxrzCriteria criteria = arg.createCriteria();
        // if (Utils.notEmpty(record.getUserName())) {
        // criteria.andUserNameLike(record.getUserName());
        // }

        // 第二种方式：利用arg转换服务，转换出arg，带上查询条件及操作符，
        // 转换后，还可以自行对arg进行设置修改
        CxrzArg arg = argConversionService.invokeArg(CxrzArg.class, record);

        resultPage = cxrzDao.selectByArgAndPage(arg, resultPage);


        return resultPage;
    }

    @Override
    public int add(CxrzPO record) throws BaseAppException {
        logger.debug("add begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、设置主键、设置属性默认值等
        // 获取主键
        // int pkId = sequenceGenerator.sequenceIntValue("表名","主键名");
        // record.setUserId(pkId);
        // record.setCreatedDate(new Date());
        // ///////

        return cxrzDao.insertSelective(record);
    }

    @Override
    public int update(CxrzPO record) throws BaseAppException {
        logger.debug("update begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行重名校验、数据有效性校验、设置属性默认值等

        // ///////

        return cxrzDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(CxrzPO record) throws BaseAppException {
        logger.debug("delete begin...record={0}", record);

        // ///////
        // TODO 根据业务场景，进行关联性校验、关联删除等

        // ///////

        return cxrzDao.deleteByPrimaryKey(record.getId());
    }

}
