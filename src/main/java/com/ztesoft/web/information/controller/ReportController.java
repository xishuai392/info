package com.ztesoft.web.information.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ztesoft.core.convert.ArgCondition;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.web.information.domain.req.ReportQueryDto;
import com.ztesoft.web.information.domain.resp.ReportResultDto;
import com.ztesoft.web.information.service.IReportService;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;
import com.ztesoft.web.permission.service.IAuditOrganizationService;

/**
 * 人口信息查询总入口.报表查询
 * 
 * @author Ocean
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(ReportController.class);

    @Autowired
    private IReportService reportService;

    @Autowired
    private IAuditOrganizationService auditOrganizationService;

    @RequestMapping("index")
    public String index(Model model) {

        return "/report/jsp/infoQuery";
    }

    /**
     * 窗口信息查询服务统计报表
     * 
     * @param model
     * @return
     */
    @RequestMapping("queryCkcx")
    public ModelAndView queryCkcx(Model model) {
        ModelAndView view = new ModelAndView("/report/jsp/ckcx");
        view.addObject("startDateInit", DateUtils.date2StringDay(DateUtils
                .getMonthBeginday(new Date())));
        view.addObject("endDateInit",
                DateUtils.date2StringDay(DateUtils.getMonthLastday(new Date())));
//        System.out.println(DateUtils.date2StringDay(DateUtils
//                .getMonthBeginday(new Date())));
//        System.out.println(DateUtils.date2StringDay(DateUtils
//                .getMonthLastday(new Date())));
        return view;
    }

    /**
     * 窗口信息查询服务统计报表--请求数据
     * 
     * @param reqInfo
     * @return
     */
    @RequestMapping("queryCkcxData")
    @ResponseBody
    public List<ReportResultDto> queryCkcxData(ReportQueryDto reqInfo) {
        reqInfo.setCxbs("20");// pc端
        reqInfo.setStartDateStr(DateUtils.date2String(reqInfo.getStartDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(reqInfo.getEndDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        return reportService.queryCkcx(reqInfo);
    }

    /**
     * 自助终端查询报表
     * 
     * @param model
     * @return
     */
    @RequestMapping("queryPlatesQryPrint")
    public ModelAndView queryPlatesQryPrint(Model model) {
        ModelAndView view = new ModelAndView("/report/jsp/zdcx");
        view.addObject("startDateInit", DateUtils.date2StringDay(DateUtils
                .getMonthBeginday(new Date())));
        view.addObject("endDateInit",
                DateUtils.date2StringDay(DateUtils.getMonthLastday(new Date())));
        return view;
    }

    /**
     * 自助终端查询报表--数据
     * 
     * @param reqInfo
     * @return
     */
    @RequestMapping("queryPlatesQryPrintData")
    @ResponseBody
    public List<ReportResultDto> queryPlatesQryPrintData(ReportQueryDto reqInfo) {
        reqInfo.setCxbs("10");// 10：终端
        reqInfo.setStartDateStr(DateUtils.date2String(reqInfo.getStartDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(reqInfo.getEndDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        return reportService.queryPlatesQryPrint(reqInfo);
    }

    /**
     * 按单位分组查询(传入的单位ID进行查询) ： 服务次数、查询次数、查询成功次数
     * 
     * @param model
     * @return
     */
    @RequestMapping("queryReportGroupByCzdw")
    public ModelAndView queryReportGroupByCzdw(Model model) {
        ModelAndView view = new ModelAndView("/report/jsp/czdwByGroup");
        view.addObject("startDateInit", DateUtils.date2StringDay(DateUtils
                .getMonthBeginday(new Date())));
        view.addObject("endDateInit",
                DateUtils.date2StringDay(DateUtils.getMonthLastday(new Date())));
        return view;
    }

    /**
     * 按单位分组查询(传入的单位ID进行查询) ： 服务次数、查询次数、查询成功次数--数据
     * 
     * @param model
     * @return
     * @throws BaseAppException
     * @throws NumberFormatException
     */
    @RequestMapping("queryReportGroupByCzdwData")
    @ResponseBody
    public List<ReportResultDto> queryReportGroupByCzdwData(
            ReportQueryDto reqInfo) throws NumberFormatException,
            BaseAppException {
        reqInfo.setCxbs("20");// 20：pc端
        reqInfo.setStartDateStr(DateUtils.date2String(reqInfo.getStartDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(reqInfo.getEndDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));

        String qryCzdw = reqInfo.getCzdw();
        if (StringUtils.isBlank(qryCzdw)) {
            qryCzdw = "0";
        }
        // 捞当前单位的所有子单位，以逗号分隔，拼装成一个字符串
        List<Long> allOrgIdList = new ArrayList<Long>();
        getChildrenOrgId(Long.parseLong(qryCzdw), allOrgIdList);
        String czdwSplitByComma = "";
        for (Long orgId : allOrgIdList) {
            czdwSplitByComma += String.valueOf(orgId) + ",";
        }
        if (czdwSplitByComma.length() > 0) {
            reqInfo.setCzdwSplitByComma(czdwSplitByComma.substring(0,
                    czdwSplitByComma.length() - 1));
        }
        else {
            reqInfo.setCzdwSplitByComma(czdwSplitByComma);
        }

        return reportService.queryGroupByCzdw(reqInfo);
    }

    /**
     * 根据Org_id查找包含该节点的所有子孙节点
     * 
     * @param parentOrgId
     * @param allOrgIdList
     * @throws BaseAppException
     */
    public void getChildrenOrgId(Long parentOrgId, List<Long> allOrgIdList)
            throws BaseAppException {
        AuditOrganizationPO record = new AuditOrganizationPO();
        ArgCondition conditon = new ArgCondition();
        conditon.setParamName("parentOrgId");
        conditon.setOperation("EqualTo");
        conditon.setParamValue(new String[] {
            String.valueOf(parentOrgId)
        });
        ArgCondition[] conditionAry = new ArgCondition[1];
        conditionAry[0] = conditon;

        String condition = JsonUtil.toJson(conditionAry);
        record.setQueryConditions(condition);

        //加入本节点
        allOrgIdList.add(parentOrgId);
        
        //加入其所有子节点
        List<AuditOrganizationPO> childrenOrg = auditOrganizationService
                .selectByArg(record);
        if (null != childrenOrg && childrenOrg.size() > 0) {
            for (AuditOrganizationPO oneChild : childrenOrg) {
                allOrgIdList.add(oneChild.getOrgId());
                getChildrenOrgId(oneChild.getOrgId(), allOrgIdList);
            }
        }

    }
}
