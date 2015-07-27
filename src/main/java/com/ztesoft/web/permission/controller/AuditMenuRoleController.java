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
import com.ztesoft.web.permission.db.po.AuditMenuRolePO;
import com.ztesoft.web.permission.service.IAuditMenuRoleService;

/**
 * <Description>auditmenurole管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */

@Controller
@RequestMapping("//permission/auditmenurole")
public class AuditMenuRoleController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditMenuRoleController.class);

    @Autowired
    private IAuditMenuRoleService auditMenuRoleService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/permission/jsp/auditMenuRole";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AuditMenuRolePO> queryRecordByPage(AuditMenuRolePO record,
            Page<AuditMenuRolePO> resultPage) throws BaseAppException {
        resultPage = auditMenuRoleService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AuditMenuRolePO add(AuditMenuRolePO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        auditMenuRoleService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AuditMenuRolePO update(AuditMenuRolePO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        auditMenuRoleService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AuditMenuRolePO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return auditMenuRoleService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AuditMenuRolePO qryRecordInfo(@RequestParam(value = "menuRoleId",
            required = true) Integer menuRoleId) throws BaseAppException {
        AuditMenuRolePO record = auditMenuRoleService.selectByPrimaryKey(menuRoleId);
        return record;
    }

}
