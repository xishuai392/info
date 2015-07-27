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
import com.ztesoft.web.permission.db.po.AuditUserRolePO;
import com.ztesoft.web.permission.service.IAuditUserRoleService;

/**
 * <Description>audituserrole管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */

@Controller
@RequestMapping("//permission/audituserrole")
public class AuditUserRoleController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditUserRoleController.class);

    @Autowired
    private IAuditUserRoleService auditUserRoleService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/permission/jsp/auditUserRole";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AuditUserRolePO> queryRecordByPage(AuditUserRolePO record,
            Page<AuditUserRolePO> resultPage) throws BaseAppException {
        resultPage = auditUserRoleService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AuditUserRolePO add(AuditUserRolePO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        auditUserRoleService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AuditUserRolePO update(AuditUserRolePO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        auditUserRoleService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AuditUserRolePO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return auditUserRoleService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AuditUserRolePO qryRecordInfo(@RequestParam(value = "userRoleId",
            required = true) Integer userRoleId) throws BaseAppException {
        AuditUserRolePO record = auditUserRoleService.selectByPrimaryKey(userRoleId);
        return record;
    }

}
