package com.ztesoft.web.permission.controller;

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
import com.ztesoft.web.permission.db.po.AuditMenuPO;
import com.ztesoft.web.permission.service.IAuditMenuService;

/**
 * <Description>auditmenu管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */

@Controller
@RequestMapping("//permission/auditmenu")
public class AuditMenuController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditMenuController.class);

    @Autowired
    private IAuditMenuService auditMenuService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/permission/jsp/auditMenu";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AuditMenuPO> queryRecordByPage(AuditMenuPO record,
            Page<AuditMenuPO> resultPage) throws BaseAppException {
        resultPage = auditMenuService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AuditMenuPO add(AuditMenuPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        auditMenuService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AuditMenuPO update(AuditMenuPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        auditMenuService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AuditMenuPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return auditMenuService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AuditMenuPO qryRecordInfo(@RequestParam(value = "menuId",
            required = true) Integer menuId) throws BaseAppException {
        AuditMenuPO record = auditMenuService.selectByPrimaryKey(menuId);
        return record;
    }

}
