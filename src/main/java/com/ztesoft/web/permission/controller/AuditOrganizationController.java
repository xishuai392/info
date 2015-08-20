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
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;
import com.ztesoft.web.permission.service.IAuditOrganizationService;

/**
 * <Description>auditorganization管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */

@Controller
@RequestMapping("/permission/auditorganization")
public class AuditOrganizationController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditOrganizationController.class);

    @Autowired
    private IAuditOrganizationService auditOrganizationService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/permission/jsp/auditOrganization";
    }

    @RequestMapping("managerAuditOrgUser")
    public String managerAuditOrgUser(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/permission/jsp/managerAuditOrgUser";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AuditOrganizationPO> queryRecordByPage(
            AuditOrganizationPO record, Page<AuditOrganizationPO> resultPage)
            throws BaseAppException {
        resultPage = auditOrganizationService.selectByArgAndPage(record,
                resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AuditOrganizationPO add(AuditOrganizationPO record)
            throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        auditOrganizationService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AuditOrganizationPO update(AuditOrganizationPO record)
            throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        auditOrganizationService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AuditOrganizationPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return auditOrganizationService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AuditOrganizationPO qryRecordInfo(@RequestParam(value = "orgId",
            required = true) Long orgId) throws BaseAppException {
        AuditOrganizationPO record = auditOrganizationService
                .selectByPrimaryKey(orgId);
        return record;
    }

    @RequestMapping("changeOrgParent")
    @ResponseBody
    public boolean changeOrgParent(@RequestParam(value = "fromId",
            required = true) Long orgId, @RequestParam(value = "toId",
            required = true) Long newParentId) throws BaseAppException {
        
        return auditOrganizationService.changeOrgParent(orgId, newParentId);
    }

}
