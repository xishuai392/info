package com.ztesoft.web.cache.controller;

import java.math.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.cache.db.po.AmUserTmpPO;
import com.ztesoft.web.cache.service.IAmUserTmpService;

/**
 * <Description>amusertmp管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.cache.controller <br>
 */

@Controller
@RequestMapping("/cache/cache/amusertmp")
public class AmUserTmpController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AmUserTmpController.class);

    @Autowired
    private IAmUserTmpService amUserTmpService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "cache/cache/jsp/amUserTmp";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AmUserTmpPO> queryRecordByPage(AmUserTmpPO record,
            Page<AmUserTmpPO> resultPage) throws BaseAppException {
        resultPage = amUserTmpService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AmUserTmpPO add(AmUserTmpPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        amUserTmpService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AmUserTmpPO update(AmUserTmpPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        amUserTmpService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AmUserTmpPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return amUserTmpService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AmUserTmpPO qryRecordInfo(@RequestParam(value = "userId",
            required = true) Integer userId) throws BaseAppException {
        AmUserTmpPO record = amUserTmpService.selectByPrimaryKey(userId);
        return record;
    }

}
