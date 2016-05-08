package com.ztesoft.web.operateRecord.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.ztesoft.web.domain.IConstants;
import com.ztesoft.web.information.controller.ReportController;
import com.ztesoft.web.operateRecord.db.po.TSqrxxPO;
import com.ztesoft.web.operateRecord.db.po.TSqrxxfjPO;
import com.ztesoft.web.operateRecord.service.ITSqrxxService;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * <Description>tsqrxx管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.operateRecord.controller <br>
 */

@Controller
@RequestMapping("/operateRecord/tsqrxx")
public class TSqrxxController1 {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TSqrxxController1.class);

    @Autowired
    private ITSqrxxService tSqrxxService;

    @Autowired
    private ReportController reportController;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/operateRecord/jsp/tSqrxx";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<TSqrxxPO> queryRecordByPage(TSqrxxPO record,
            Page<TSqrxxPO> resultPage, HttpServletRequest request)
            throws BaseAppException {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);
        AuditOrganizationPO orgInfo = (AuditOrganizationPO) session
                .getAttribute(IConstants.SESSIONUSERORG);

        if (orgInfo.getOrgId() > 1L) {
            String qryType = record.getQryType();// 查询类型，1：追加查询，其余值：普通查询

            // 只查询本登录用户所属的机构，及其所有子机构
            Long thizOrgId = auditUserPo.getOrgId();
            List<Long> allOrgIdList = new ArrayList<Long>();
            reportController.getChildrenOrgId(thizOrgId, allOrgIdList);

            String czdwSplitByComma = "";
            for (Long orgId : allOrgIdList) {
                czdwSplitByComma += String.valueOf(orgId) + ",";
            }
            if (czdwSplitByComma.length() > 0) {
                record.setCzdw(czdwSplitByComma.substring(0,
                        czdwSplitByComma.length() - 1));
            }
            else {
                record.setCzdw(czdwSplitByComma);
            }

        }
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
    public TSqrxxPO qryRecordInfo(
            @RequestParam(value = "id", required = true) String id)
            throws BaseAppException {
        TSqrxxPO record = tSqrxxService.selectByPrimaryKey(id);
        return record;
    }

    @RequestMapping("sqrxxDetail")
    @ResponseBody
    public List<TSqrxxfjPO> sqrxxDetail(@RequestParam(value = "id",
            required = true) String id) throws BaseAppException {
        List<TSqrxxfjPO> record = tSqrxxService.selectSqrxxfjBySqrId(id);
        return record;
    }

}
