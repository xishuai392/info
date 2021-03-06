package com.ztesoft.web.byTheQuery.controller;

import java.math.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.information.controller.ReportController;
import com.ztesoft.web.information.db.po.TBcxrxxPO;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;
import com.ztesoft.web.permission.db.po.AuditUserPO;
import com.ztesoft.web.byTheQuery.service.ITBcxrxxService;
import com.ztesoft.web.domain.IConstants;

/**
 * <Description>tbcxrxx管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.byTheQuery.controller <br>
 */

@Controller
@RequestMapping("/byTheQuery/tbcxrxx")
public class TBcxrxxController1 {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TBcxrxxController1.class);

    @Autowired
    private ITBcxrxxService tBcxrxxService;

    @Autowired
    private ReportController reportController;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/byTheQuery/jsp/tBcxrxx";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<TBcxrxxPO> queryRecordByPage(TBcxrxxPO record,
            Page<TBcxrxxPO> resultPage) throws BaseAppException {
        resultPage = tBcxrxxService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public TBcxrxxPO add(TBcxrxxPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        tBcxrxxService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public TBcxrxxPO update(TBcxrxxPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        tBcxrxxService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(TBcxrxxPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return tBcxrxxService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public TBcxrxxPO qryRecordInfo(
            @RequestParam(value = "id", required = true) String id)
            throws BaseAppException {
        TBcxrxxPO record = tBcxrxxService.selectByPrimaryKey(id);
        return record;
    }

    @RequestMapping("select4Page")
    @ResponseBody
    public Page<TBcxrxxPO> select4Page(TBcxrxxPO record,
            Page<TBcxrxxPO> resultPage, HttpServletRequest request)
            throws BaseAppException {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);
        AuditOrganizationPO orgInfo = (AuditOrganizationPO) session
                .getAttribute(IConstants.SESSIONUSERORG);

        if (orgInfo.getOrgId() > 1L) {

            // 只查询本登录用户所属的机构，及其所有子机构
            Long thizOrgId = auditUserPo.getOrgId();
            List<Long> allOrgIdList = new ArrayList<Long>();
            reportController.getChildrenOrgId(thizOrgId, allOrgIdList);

            String czdwSplitByComma = "";
            for (Long orgId : allOrgIdList) {
                czdwSplitByComma += String.valueOf(orgId) + ",";
            }
            if (czdwSplitByComma.length() > 0) {
                record.setSqrczdw(czdwSplitByComma.substring(0,
                        czdwSplitByComma.length() - 1));
            }
            else {
                record.setSqrczdw(czdwSplitByComma);
            }

        }

        resultPage = tBcxrxxService.select4Page(record, resultPage);
        return resultPage;
    }

}
