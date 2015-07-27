/**
 * 
 */
package com.ztesoft.web.common.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.db.dao.BaseDao;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.common.service.IQuartzService;


@Service
public class QuartzServiceImpl implements IQuartzService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(QuartzServiceImpl.class);

    @Autowired
    private BaseDao baseDao;

    /**
     * 主键生成器
     */
    @Resource(name = "sequenceProcGenerator")
    private ISequenceGenerator sequenceGenerator;
    
    public void addTask(Object task){
    	logger.debug("add Task :{0}",task);
    }

}
