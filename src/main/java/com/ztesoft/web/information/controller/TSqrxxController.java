package com.ztesoft.web.information.controller;

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
import com.ztesoft.web.information.db.po.TSqrxxPO;
import com.ztesoft.web.information.service.ITSqrxxService;

/**
 * <Description>tsqrxx管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.controller <br>
 */

@Controller
@RequestMapping("/information/information/tsqrxx")
public class TSqrxxController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TSqrxxController.class);

    @Autowired
    private ITSqrxxService tSqrxxService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "information/information/jsp/tSqrxx";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<TSqrxxPO> queryRecordByPage(TSqrxxPO record,
            Page<TSqrxxPO> resultPage) throws BaseAppException {
        resultPage = tSqrxxService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public TSqrxxPO add(TSqrxxPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        tSqrxxService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public TSqrxxPO update(TSqrxxPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        tSqrxxService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(TSqrxxPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return tSqrxxService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public TSqrxxPO qryRecordInfo(@RequestParam(value = "id",
            required = true) String id) throws BaseAppException {
        TSqrxxPO record = tSqrxxService.selectByPrimaryKey(id);
        return record;
    }

}
