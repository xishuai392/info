package com.ztesoft.web.permission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.permission.db.po.AuditRolePO;
import com.ztesoft.web.permission.service.IAuditRoleService;

/**
 * <Description>auditrole管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */

@Controller
@RequestMapping("//permission/auditrole")
public class AuditRoleController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditRoleController.class);

    @Autowired
    private IAuditRoleService auditRoleService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/permission/jsp/auditRole";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AuditRolePO> queryRecordByPage(AuditRolePO record,
            Page<AuditRolePO> resultPage) throws BaseAppException {
        resultPage = auditRoleService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AuditRolePO add(AuditRolePO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        auditRoleService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AuditRolePO update(AuditRolePO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        auditRoleService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AuditRolePO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return auditRoleService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AuditRolePO qryRecordInfo(@RequestParam(value = "roleId",
            required = true) Integer roleId) throws BaseAppException {
        AuditRolePO record = auditRoleService.selectByPrimaryKey(roleId);
        return record;
    }
    
    @RequestMapping("qryRecordList")
    @ResponseBody
    public List<AuditRolePO> qryRecordList(AuditRolePO record) throws BaseAppException {
        return auditRoleService.selectByArg(record);
    }

}
