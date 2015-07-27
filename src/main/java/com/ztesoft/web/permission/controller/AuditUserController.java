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
import com.ztesoft.web.permission.db.po.AuditUserPO;
import com.ztesoft.web.permission.service.IAuditUserService;

/**
 * <Description>audituser管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */

@Controller
@RequestMapping("//permission/audituser")
public class AuditUserController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AuditUserController.class);

    @Autowired
    private IAuditUserService auditUserService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/permission/jsp/auditUser";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AuditUserPO> queryRecordByPage(AuditUserPO record,
            Page<AuditUserPO> resultPage) throws BaseAppException {
        resultPage = auditUserService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AuditUserPO add(AuditUserPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        auditUserService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AuditUserPO update(AuditUserPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        auditUserService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AuditUserPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return auditUserService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AuditUserPO qryRecordInfo(@RequestParam(value = "userId",
            required = true) Integer userId) throws BaseAppException {
        AuditUserPO record = auditUserService.selectByPrimaryKey(userId);
        return record;
    }

}
