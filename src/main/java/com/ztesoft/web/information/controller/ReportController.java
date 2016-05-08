package com.ztesoft.web.information.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ztesoft.core.convert.ArgCondition;
import com.ztesoft.core.excel.ExcelUtils;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.web.domain.IConstants;
import com.ztesoft.web.information.domain.req.ReportQueryDto;
import com.ztesoft.web.information.domain.resp.ReportFullResultDto;
import com.ztesoft.web.information.domain.resp.ReportResultDto;
import com.ztesoft.web.information.service.IReportService;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;
import com.ztesoft.web.permission.db.po.AuditUserPO;
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
    public ModelAndView queryCkcx(Model model, HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/report/jsp/ckcx");
        view.addObject("startDateInit", DateUtils.date2StringDay(DateUtils
                .getMonthBeginday(new Date())));
        view.addObject("endDateInit",
                DateUtils.date2StringDay(DateUtils.getMonthLastday(new Date())));
        // System.out.println(DateUtils.date2StringDay(DateUtils
        // .getMonthBeginday(new Date())));
        // System.out.println(DateUtils.date2StringDay(DateUtils
        // .getMonthLastday(new Date())));
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);
        view.addObject("defaultCzdw", auditUserPo.getOrgId());

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
        // reqInfo.setStartDateStr(DateUtils.date2String(reqInfo.getStartDate(),
        // DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        // reqInfo.setEndDateStr(DateUtils.date2String(reqInfo.getEndDate(),
        // DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        reqInfo.setStartDateStr(DateUtils.date2String(
                DateUtils.getDayStartTime(reqInfo.getStartDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(
                DateUtils.getDayEndTime(reqInfo.getEndDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));
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
        reqInfo.setCxbs("10");// 10：终端，20：pc端,30:网上查询
        // reqInfo.setStartDateStr(DateUtils.date2String(reqInfo.getStartDate(),
        // DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        // reqInfo.setEndDateStr(DateUtils.date2String(reqInfo.getEndDate(),
        // DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        reqInfo.setStartDateStr(DateUtils.date2String(
                DateUtils.getDayStartTime(reqInfo.getStartDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(
                DateUtils.getDayEndTime(reqInfo.getEndDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));
        return reportService.queryPlatesQryPrint(reqInfo);
    }

    /**
     * 按单位分组查询(传入的单位ID进行查询) ： 服务次数、查询次数、查询成功次数
     * 
     * @param model
     * @return
     */
    @RequestMapping("queryReportGroupByCzdw_old")
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
        // reqInfo.setStartDateStr(DateUtils.date2String(reqInfo.getStartDate(),
        // DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        // reqInfo.setEndDateStr(DateUtils.date2String(reqInfo.getEndDate(),
        // DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));

        reqInfo.setStartDateStr(DateUtils.date2String(
                DateUtils.getDayStartTime(reqInfo.getStartDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(
                DateUtils.getDayEndTime(reqInfo.getEndDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));

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

        // 加入本节点
        allOrgIdList.add(parentOrgId);

        // 加入其所有子节点
        List<AuditOrganizationPO> childrenOrg = auditOrganizationService
                .selectByArg(record);
        if (null != childrenOrg && childrenOrg.size() > 0) {
            for (AuditOrganizationPO oneChild : childrenOrg) {
                allOrgIdList.add(oneChild.getOrgId());
                getChildrenOrgId(oneChild.getOrgId(), allOrgIdList);
            }
        }

    }

    /**
     * 全局窗口信息查询： 查询次数（原服务次数） 查询人数（原查询次数） 查询成功数
     * 
     * @param model
     * @return
     */
    @RequestMapping("queryReportGroupByCzdw")
    public ModelAndView queryReportGroupByCzdwNew(Model model,
            HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);

        ModelAndView view = new ModelAndView("/report/jsp/czdwByGroupNew");
        view.addObject("startDateInit", DateUtils.date2StringDay(DateUtils
                .getMonthBeginday(new Date())));
        view.addObject("endDateInit",
                DateUtils.date2StringDay(DateUtils.getMonthLastday(new Date())));
        view.addObject("orgName", auditUserPo.getOrgName());// 部门名称
        view.addObject("orgCode", auditUserPo.getOrgCode());// 部门编码，用于传递到接口服务
        view.addObject("orgId", auditUserPo.getOrgId());// 部门编码，用于传递到接口服务
        return view;
    }

    /**
     * 全局窗口信息查询： 查询次数（原服务次数） 查询人数（原查询次数） 查询成功数----数据
     * 
     * @param reqInfo
     * @return
     * @throws NumberFormatException
     * @throws BaseAppException
     */
    @RequestMapping("queryReportGroupByCzdwDataNew")
    @ResponseBody
    public List<ReportFullResultDto> queryReportGroupByCzdwDataNew(
            ReportQueryDto reqInfo) throws NumberFormatException,
            BaseAppException {
        reqInfo.setCxbs("20");// 20：pc端
        reqInfo.setStartDateStr(DateUtils.date2String(
                DateUtils.getDayStartTime(reqInfo.getStartDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(
                DateUtils.getDayEndTime(reqInfo.getEndDate()),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));

        String qryCzdw = reqInfo.getCzdw();
        if (StringUtils.isBlank(qryCzdw)) {
            qryCzdw = "0";
        }

        // 获取当前单位
        AuditOrganizationPO thizOrg = auditOrganizationService
                .selectByPrimaryKey(Long.parseLong(qryCzdw));
        // 当前查询的根节点，以防没有数据时填充
        ReportFullResultDto rootResult = new ReportFullResultDto(
                String.valueOf(thizOrg.getOrgId()), thizOrg.getOrgName());

        // 上下级的单位信息
        Map<String, List<AuditOrganizationPO>> orgRelShip = new HashMap<String, List<AuditOrganizationPO>>();
        // 每个单位信息
        Map<String, AuditOrganizationPO> orgInfoMap = new HashMap<String, AuditOrganizationPO>();

        // 捞当前单位的所有子单位，以逗号分隔，拼装成一个字符串
        List<Long> allOrgIdList = new ArrayList<Long>();
        // 加入本节点
        allOrgIdList.add(Long.parseLong(qryCzdw));
        //加入本节点的信息
        orgInfoMap.put(qryCzdw, thizOrg);
        getChildrenOrgIdNew(thizOrg, allOrgIdList, orgRelShip, orgInfoMap);
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

        // 查询的所有结果
        List<ReportResultDto> qryResultList = reportService
                .queryGroupByCzdwNew(reqInfo);

        // 把查询结果转换成Map
        Map<String, ReportFullResultDto> resultMap = convertRowToCell(qryResultList);
        sumPerRow(resultMap);// 对每行进行合计

        //最终结果
        List<ReportFullResultDto> resultList = new ArrayList<ReportFullResultDto>();
        //已经存在的结果
        Map<String,String> existMap = new HashMap<String, String>();

        ReportFullResultDto hejiResult = new ReportFullResultDto("合计", "合计");

        // 判断rootResult是否有数据
        if (resultMap.containsKey(rootResult.getCzdw())) {
            if (orgRelShip.containsKey(rootResult.getCzdw())) {
                // 如果关系 map中包含了，就先不处理
            }
            else {
                resultList.add(resultMap.get(rootResult.getCzdw()));
                existMap.put(rootResult.getCzdw(), "exist");
                sumToGroup(hejiResult, resultMap.get(rootResult.getCzdw()));
            }

        }
        else {
            resultList.add(rootResult);
            existMap.put(rootResult.getCzdw(), "exist");
        }

        buildAll(orgInfoMap, orgRelShip, resultMap, resultList, hejiResult, existMap);

        return resultList;
    }

    /**
     * 根据Org_id查找包含该节点的所有子孙节点
     * 
     * @param parentOrgId
     * @param allOrgIdList
     * @param orgRelShip
     * @param orgInfoMap
     * @throws BaseAppException
     */
    public void getChildrenOrgIdNew(AuditOrganizationPO thizOrg,
            List<Long> allOrgIdList,
            Map<String, List<AuditOrganizationPO>> orgRelShip,
            Map<String, AuditOrganizationPO> orgInfoMap)
            throws BaseAppException {
        AuditOrganizationPO record = new AuditOrganizationPO();
        ArgCondition conditon = new ArgCondition();
        conditon.setParamName("parentOrgId");
        conditon.setOperation("EqualTo");
        conditon.setParamValue(new String[] {
            String.valueOf(thizOrg.getOrgId())
        });
        ArgCondition[] conditionAry = new ArgCondition[1];
        conditionAry[0] = conditon;

        String condition = JsonUtil.toJson(conditionAry);
        record.setQueryConditions(condition);

        // 加入本节点
        // allOrgIdList.add(parentOrgId);

        // 判断本节点是否是分局，如果是，需要把子节点需要加入Map中
        boolean isFenjuOrg = false;

        // 加入其所有子节点
        List<AuditOrganizationPO> childrenOrg = auditOrganizationService
                .selectByArg(record);

        // 判断该节点是不是分局——1
        if (1L == thizOrg.getOrgLevel()) {
            // 说明父节点是分局
            isFenjuOrg = true;
        }

        if (null != childrenOrg && childrenOrg.size() > 0) {

            for (AuditOrganizationPO oneChild : childrenOrg) {
                allOrgIdList.add(oneChild.getOrgId());

                orgInfoMap.put(String.valueOf(oneChild.getOrgId()), oneChild);

                getChildrenOrgIdNew(oneChild, allOrgIdList, orgRelShip,
                        orgInfoMap);
            }
        }

        // 是分局，则把该分局加入
        if (isFenjuOrg) {
            orgRelShip.put(String.valueOf(thizOrg.getOrgId()), childrenOrg);
        }

    }

    /**
     * 把查询结果行汇总成列
     * 
     * @param qryResultList
     * @return
     */
    private Map<String, ReportFullResultDto> convertRowToCell(
            List<ReportResultDto> qryResultList) {
        Map<String, ReportFullResultDto> resultMap = new HashMap<String, ReportFullResultDto>();
        if (null == qryResultList || qryResultList.size() == 0) {
            return resultMap;
        }
        for (ReportResultDto resultDto : qryResultList) {
            String czdw = resultDto.getCzdw();
            ReportFullResultDto tmp = null;
            if (null == resultMap.get(czdw)) {
                tmp = new ReportFullResultDto(czdw, resultDto.getDwmc());
                resultMap.put(czdw, tmp);
            }
            else {
                tmp = resultMap.get(czdw);
            }

            if ("10".equals(resultDto.getCxsqrlx())) {
                tmp.setFwcs10(resultDto.getFwcs());
                tmp.setCxcs10(resultDto.getCxcs());
                tmp.setCxcgcs10(resultDto.getCxcgcs());
            }

            if ("20".equals(resultDto.getCxsqrlx())) {
                tmp.setFwcs20(resultDto.getFwcs());
                tmp.setCxcs20(resultDto.getCxcs());
                tmp.setCxcgcs20(resultDto.getCxcgcs());
            }

            if ("30".equals(resultDto.getCxsqrlx())) {
                tmp.setFwcs30(resultDto.getFwcs());
                tmp.setCxcs30(resultDto.getCxcs());
                tmp.setCxcgcs30(resultDto.getCxcgcs());
            }

            if ("40".equals(resultDto.getCxsqrlx())) {
                tmp.setFwcs40(resultDto.getFwcs());
                tmp.setCxcs40(resultDto.getCxcs());
                tmp.setCxcgcs40(resultDto.getCxcgcs());
            }

            if ("50".equals(resultDto.getCxsqrlx())) {
                tmp.setFwcs50(resultDto.getFwcs());
                tmp.setCxcs50(resultDto.getCxcs());
                tmp.setCxcgcs50(resultDto.getCxcgcs());
            }

            if ("60".equals(resultDto.getCxsqrlx())) {
                tmp.setFwcs60(resultDto.getFwcs());
                tmp.setCxcs60(resultDto.getCxcs());
                tmp.setCxcgcs60(resultDto.getCxcgcs());
            }

            if ("70".equals(resultDto.getCxsqrlx())) {
                tmp.setFwcs70(resultDto.getFwcs());
                tmp.setCxcs70(resultDto.getCxcs());
                tmp.setCxcgcs70(resultDto.getCxcgcs());
            }
        }

        return resultMap;
    }

    /**
     * 对每行进行合计
     * 
     * @param resultMap
     */
    private void sumPerRow(Map<String, ReportFullResultDto> resultMap) {
        if (resultMap.isEmpty())
            return;
        Iterator<Map.Entry<String, ReportFullResultDto>> iter = resultMap
                .entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, ReportFullResultDto> entry = iter.next();
            ReportFullResultDto dto = entry.getValue();
            // 服务次数合计
            dto.setFwcssum(dto.getFwcs10() + dto.getFwcs20() + dto.getFwcs30()
                    + dto.getFwcs40() + dto.getFwcs50() + dto.getFwcs60()
                    + dto.getFwcs70());
            // 查询次数合计
            dto.setCxcssum(dto.getCxcs10() + dto.getCxcs20() + dto.getCxcs30()
                    + dto.getCxcs40() + dto.getCxcs50() + dto.getCxcs60()
                    + dto.getCxcs70());
            // 查询成功次数合计
            dto.setCxcgcssum(dto.getCxcgcs10() + dto.getCxcgcs20()
                    + dto.getCxcgcs30() + dto.getCxcgcs40() + dto.getCxcgcs50()
                    + dto.getCxcgcs60() + dto.getCxcgcs70());
        }
    }

    /**
     * 构建最终结果
     * 
     * @param orgInfoMap 每个单位信息
     * @param orgRelShip 上下级的单位信息
     * @param resultMap 查询结果
     * @param resultList 最终结果
     * @param hejiResult 最终合计项
     * @param existMap 已经存在的结果
        
     */
    private void buildAll(Map<String, AuditOrganizationPO> orgInfoMap,
            Map<String, List<AuditOrganizationPO>> orgRelShip,
            Map<String, ReportFullResultDto> resultMap,
            List<ReportFullResultDto> resultList, ReportFullResultDto hejiResult,
            Map<String,String> existMap ) {

        List<Map.Entry<String, List<AuditOrganizationPO>>> orgRelShipKeys = new ArrayList<Map.Entry<String, List<AuditOrganizationPO>>>(
                orgRelShip.entrySet());
        // 排序
        Collections.sort(orgRelShipKeys,
                new Comparator<Map.Entry<String, List<AuditOrganizationPO>>>() {
                    public int compare(
                            Map.Entry<String, List<AuditOrganizationPO>> o1,
                            Map.Entry<String, List<AuditOrganizationPO>> o2) {
                        // return (o2.getValue() - o1.getValue());
                        return Integer.parseInt(o1.getKey())
                                - (Integer.parseInt(o2.getKey()));
                    }
                });

        // 排序后
        for (int i = 0; i < orgRelShipKeys.size(); i++) {
            String parentOrg = orgRelShipKeys.get(i).getKey();
            ReportFullResultDto parentResult = null;
            ReportFullResultDto xiaojiResult = new ReportFullResultDto(
                    parentOrg + "_小计", "小计");
            if (resultMap.containsKey(parentOrg)) {
                parentResult = resultMap.get(parentOrg);
                sumToGroup(xiaojiResult, parentResult);
            }
            else {
                parentResult = new ReportFullResultDto(
                        String.valueOf(orgInfoMap.get(parentOrg).getOrgId()),
                        orgInfoMap.get(parentOrg).getOrgName());
            }
            if(existMap.containsKey(parentResult.getCzdw())){
                //如果已经存在了，就不加入了
                
            }else{
                resultList.add(parentResult);
                existMap.put(parentResult.getCzdw(), "exist");
            }
           

            List<AuditOrganizationPO> chidlOrg = orgRelShipKeys.get(i)
                    .getValue();

            for (AuditOrganizationPO oneOrg : chidlOrg) {
                String thizOneOrgId = String.valueOf(oneOrg.getOrgId());
                if (!resultMap.containsKey(thizOneOrgId)) {
                    continue;
                }
                ReportFullResultDto thizOneOrgResult = resultMap
                        .get(thizOneOrgId);
                sumToGroup(xiaojiResult, thizOneOrgResult);
                
                
                if(existMap.containsKey(thizOneOrgResult.getCzdw())){
                    //如果已经存在了，就不加入了
                    
                }else{
                    resultList.add(thizOneOrgResult);
                    existMap.put(thizOneOrgResult.getCzdw(), "exist");
                }
                
            }
            // 本组循环后，再把小计项加入
            resultList.add(xiaojiResult);
            // 汇总到合计
            sumToGroup(hejiResult, xiaojiResult);
        }

        // 最终加上合计项
        resultList.add(hejiResult);

    }

    private void sumToGroup(ReportFullResultDto sum, ReportFullResultDto per) {
        sum.setFwcs10(sum.getFwcs10() + per.getFwcs10());
        sum.setFwcs20(sum.getFwcs20() + per.getFwcs20());
        sum.setFwcs30(sum.getFwcs30() + per.getFwcs30());
        sum.setFwcs40(sum.getFwcs40() + per.getFwcs40());
        sum.setFwcs50(sum.getFwcs50() + per.getFwcs50());
        sum.setFwcs60(sum.getFwcs60() + per.getFwcs60());
        sum.setFwcs70(sum.getFwcs70() + per.getFwcs70());

        sum.setCxcs10(sum.getCxcs10() + per.getCxcs10());
        sum.setCxcs20(sum.getCxcs20() + per.getCxcs20());
        sum.setCxcs30(sum.getCxcs30() + per.getCxcs30());
        sum.setCxcs40(sum.getCxcs40() + per.getCxcs40());
        sum.setCxcs50(sum.getCxcs50() + per.getCxcs50());
        sum.setCxcs60(sum.getCxcs60() + per.getCxcs60());
        sum.setCxcs70(sum.getCxcs70() + per.getCxcs70());

        sum.setCxcgcs10(sum.getCxcgcs10() + per.getCxcgcs10());
        sum.setCxcgcs20(sum.getCxcgcs20() + per.getCxcgcs20());
        sum.setCxcgcs30(sum.getCxcgcs30() + per.getCxcgcs30());
        sum.setCxcgcs40(sum.getCxcgcs40() + per.getCxcgcs40());
        sum.setCxcgcs50(sum.getCxcgcs50() + per.getCxcgcs50());
        sum.setCxcgcs60(sum.getCxcgcs60() + per.getCxcgcs60());
        sum.setCxcgcs70(sum.getCxcgcs70() + per.getCxcgcs70());

        sum.setFwcssum(sum.getFwcssum() + per.getFwcssum());
        sum.setCxcssum(sum.getCxcssum() + per.getCxcssum());
        sum.setCxcgcssum(sum.getCxcgcssum() + per.getCxcgcssum());
    }

    /**
     * 通过EXTJS 导出，全局窗口信息查询统计报表
     * 
     * @author: panxb
     * @date: 2012-6-27 上午09:17:51
     * @return
     * @throws Exception
     */
    @RequestMapping("doExcelExport4EXTJS")
    public String doExcelExport4EXTJS(HttpServletResponse response,
            ReportQueryDto reqInfo) throws Exception {
        List<ReportFullResultDto> resultList = queryReportGroupByCzdwDataNew(reqInfo);

        // 数据中的key
        String keys[] = {
                "dwmc", "fwcs10", "fwcs20", "fwcs30", "fwcs40", "fwcs50",
                "fwcs60", "fwcs70", "fwcssum", "cxcs10", "cxcs20", "cxcs30",
                "cxcs40", "cxcs50", "cxcs60", "cxcs70", "cxcssum", "cxcgcs10",
                "cxcgcs20", "cxcgcs30", "cxcgcs40", "cxcgcs50", "cxcgcs60",
                "cxcgcs70", "cxcgcssum",
        };

        Workbook wb = null;
        OutputStream ouputStream = null;
        try {
            
            String tplPath = ReportController.class.getClassLoader().getResource("").getPath()
                    + "quanju_ck.xls";
            logger.info(""+ReportController.class.getClassLoader().getResource("").getPath());
            logger.info("excel模板路径：" + tplPath);
            wb = ExcelUtils.createWorkBookByTpl(new File(tplPath), 2, 0,
                    resultList, keys, keys);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename="
                  + new String(("report_"+DateUtils.getCurrentDate() + ".xls").getBytes(), "iso-8859-1"));
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
//            ouputStream.close();
        }
        catch (Exception e) {
            logger.error("导出Excel时发生异常：" + e.getMessage(), e);
        }finally{
            try {
              if (ouputStream != null )
                  ouputStream.close();
          }
          catch (Exception e) {
              logger.error("导出Excel关闭流抛异常：", e);
          }
        }

        return null;
        
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            String tplPath = ReportController.class.getResource("qujuck.xls")
//                    .getPath();
//            logger.info("excel模板路径：" + tplPath);
//            ExcelUtils.createWorkBookByTpl(new File(tplPath), 2, 0, resultList,
//                    keys, keys).write(os);
//        }
//        catch (Exception e) {
//            logger.error("导出Excel时发生异常：" + e.getMessage(), e);
//        }
//        byte[] content = os.toByteArray();
//        InputStream is = new ByteArrayInputStream(content);
//        // 设置response参数，可以打开下载页面
//        response.reset();
//        response.setContentType("application/vnd.ms-excel;charset=utf-8");
//        response.setHeader("Content-Disposition", "attachment;filename="
//                + new String(("excel模板路径" + ".xls").getBytes(), "iso-8859-1"));
//        ServletOutputStream out = response.getOutputStream();
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            bis = new BufferedInputStream(is);
//            bos = new BufferedOutputStream(out);
//            byte[] buff = new byte[2048];
//            int bytesRead;
//            // Simple read/write loop.
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//            }
//        }
//        catch (final IOException e) {
//            throw e;
//        }
//        finally {
//            try {
//                if (bis != null)
//                    bis.close();
//                if (bos != null)
//                    bos.close();
//            }
//            catch (Exception e) {
//                logger.error("导出Excel关闭流抛异常：", e);
//            }
//        }
//        return null;
    }

    
    public static void main(String[] args){
          try {
            //InputStream  fs =   new FileInputStream("config/logback.xml");
              //config/quanju_ck.xls
            File f = new File("config/logback.xml");
            File ff = new File(ReportController.class.getClassLoader().getResource("").getPath());
            System.out.println(ff.getParentFile().getPath());
            System.out.println(ReportController.class.getClassLoader().getResource(""));
            System.out.println(ReportController.class.getResource(""));
            System.out.println(f.getPath());
            System.out.println(f.getCanonicalPath());
            System.out.println(f.getAbsolutePath());
            
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }
    
    /**
     * 
     * @param response
     * @param reqInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("doPlatesExcelExport4EXTJS")
    public String doPlatesExcelExport4EXTJS(HttpServletResponse response,
            ReportQueryDto reqInfo) throws Exception {
        
        List<ReportResultDto> resultList = queryPlatesQryPrintData(reqInfo);

        // 数据中的key
        String keys[] = {
                "czr", "cxcs", "dycs"
        };

        Workbook wb = null;
        OutputStream ouputStream = null;
        try {
            
            String tplPath = ReportController.class.getClassLoader().getResource("").getPath()
                    + "zhongduan.xls";
            logger.info(""+ReportController.class.getClassLoader().getResource("").getPath());
            logger.info("excel模板路径：" + tplPath);
            wb = ExcelUtils.createWorkBookByTpl(new File(tplPath), 1, 0,
                    resultList, keys, keys);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename="
                  + new String(("report_Plates_"+DateUtils.getCurrentDate() + ".xls").getBytes(), "iso-8859-1"));
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
//            ouputStream.close();
        }
        catch (Exception e) {
            logger.error("导出Excel时发生异常：" + e.getMessage(), e);
        }finally{
            try {
              if (ouputStream != null )
                  ouputStream.close();
          }
          catch (Exception e) {
              logger.error("导出Excel关闭流抛异常：", e);
          }
        }

        return null;
    }
    
}
