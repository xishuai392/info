package com.ztesoft.web.information.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.framework.util.UuidUtils;
import com.ztesoft.web.domain.IConstants;
import com.ztesoft.web.information.db.po.TBcxrxxPO;
import com.ztesoft.web.information.db.po.TSqrxxPO;
import com.ztesoft.web.information.domain.req.print.PrintReqInfo;
import com.ztesoft.web.information.domain.req.query.QueryByOtherPeopleReqInfo;
import com.ztesoft.web.information.domain.resp.FamilyInfo;
import com.ztesoft.web.information.domain.resp.MigrateInfo;
import com.ztesoft.web.information.domain.resp.PermanetPopulationInfo;
import com.ztesoft.web.information.domain.resp.PopulationBaseInfo;
import com.ztesoft.web.information.domain.resp.QueryRespInfo;
import com.ztesoft.web.information.domain.resp.QueryResultInfo;
import com.ztesoft.web.information.domain.resp.TRinfo;
import com.ztesoft.web.information.domain.resp.TRpopulationInfo;
import com.ztesoft.web.information.rbsp.IdentificationCodeUtil;
import com.ztesoft.web.information.rbsp.InfoRbspClient;
import com.ztesoft.web.information.rbsp.InfoResultVO;
import com.ztesoft.web.information.rbsp.InfoXmlParser;
import com.ztesoft.web.information.rbsp.TransUtils;
import com.ztesoft.web.information.service.ITBcxrxxService;
import com.ztesoft.web.information.service.ITSqrxxService;
import com.ztesoft.web.information.service.PrimaryGenerater;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * 人口信息查询总入口.分查询人控制模块及被查询控制模块
 * 
 * @author Ocean
 */
@Controller
@RequestMapping(value = "/information")
public class InformationQueryController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(InformationQueryController.class);

    private static final String[] czrkBaseInfoArr = new String[] {
            "NAME", "USED_NAME", "GENDER", "NATION", "DOB", "PID",
            "NATIVE_COUNTRY", "NATIVE_PLACE", "NATIVE_XIANG", "NATAL_COUNTRY",
            "NATAL_PLACE", "NATAL_XIANG", "WHO_IN_UNIT_NAME",
            "PID_ISSUE_UNIT_NAME", "PID_USEFUL_LIFE", "FA_PID", "FA_NAME",
            "FA_CARD_TYPE", "FA_CARD_NO", "FA_WWX", "FA_WWM", "MA_PID",
            "MA_NAME", "MA_CARD_TYPE", "MA_CARD_NO", "MA_WWX", "MA_WWM",
            "PO_PID", "PO_NAME", "PO_CARD_TYPE", "PO_CARD_NO", "PO_WWX",
            "PO_WWM", "GURARDIAN_1_PID", "GURARDIAN_1",
            "GURARDIAN_1_CARD_TYPE", "GURARDIAN_1_CARD_NO", "GURARDIAN_1_WWX",
            "GURARDIAN_1_WWM", "GURARDIAN_1_TEL", "GURARDIAN_2_PID",
            "GURARDIAN_2", "GURARDIAN_2_CARD_TYPE", "GURARDIAN_2_CARD_NO",
            "GURARDIAN_2_WWX", "GURARDIAN_2_WWM", "GURARDIAN_2_TEL",
            "INCITY_DATE", "INCITY_BDYY", "INCITY_DETAIL", "WHEN_OUT",
            "OUT_CATEGORY", "TO_ADDR", "PHOTO_ID", "HU_ID"
    };

    private static final String[] czrkCensusInfoArr = new String[] {
            "HU_ID", "META_ADDR_ID"
    };

    private static final String[] dzInfoArr = new String[] {
            "META_ADDR_ID", "ALL_FULL_ADDR"
    };

    private static final String[] zzrkInfoArr = new String[] {
            "PID", "NAME", "GENDER", "NATION", "DOB", "ZZZBH", "YXQQSRQ",
            "YXQXJZRQ", "FZJGJGMC", "LZRQ", "ZZDZXZ"
    };

    private static final String[] ldrkInfoArr = new String[] {
            "PID", "USED_NAME", "NATIVE_PLACE", "HJD_QU", "HJD_FULL_ADDR",
            "PHOTO_ID"
    };

    private static final String[] imageInfoArr = new String[] {
            "PHOTO_ID", "IMAGE"
    };

    @Autowired
    private ITBcxrxxService bcxrxxService;

    @Autowired
    private ITSqrxxService sqrxxService;
    
    @Autowired
    private PrimaryGenerater primaryGenerater;

    /**
     * PC端首页
     * 
     * @param model
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index(Model model) {
        ModelAndView view = new ModelAndView("/information/jsp/infoQuery");
        view.addObject("thirdPartyZzrkUrl",
                MessageResourceUtils.getMessage("ThirdParty.zzrk.url"));
        return view;
    }

    /**
     * 网上查询首页
     * 
     * @param model
     * @return
     */
    @RequestMapping("wscxIndex")
    public ModelAndView wscxIndex(Model model) {
        ModelAndView view = new ModelAndView("/information/jsp/wscxInfoQuery");
        view.addObject("thirdPartyZzrkUrl",
                MessageResourceUtils.getMessage("ThirdParty.zzrk.url"));
        return view;
    }

    /**
     * 常住人口详情页面（新开页面）兼容PC\网上查询\终端查询等
     * @param idCardNum
     * @param sqrxxId
     * @param bcxrxxId
     * @param cxbs
     * @param debug
     * @param relevance  关联查询
     * @param baseIdCardNum 关联查询时对应的本人身份证号
     * @return
     */
    @RequestMapping("czrkDetail")
    public ModelAndView czrkDetail(@RequestParam(value = "idCardNum",
            required = true) String idCardNum, @RequestParam(value = "sqrxxId",
            required = true) String sqrxxId, @RequestParam(value = "bcxrxxId",
            required = true) String bcxrxxId, @RequestParam(value = "cxbs",
            required = true) String cxbs,String debug,
            String relevance,String baseIdCardNum) {
        String populationType = "户籍人口";
        ModelAndView view = new ModelAndView("/information/jsp/czrkDetail");
        view.addObject("thirdPartyZzrkUrl",
                MessageResourceUtils.getMessage("ThirdParty.zzrk.url"));
        view.addObject("idCardNum", idCardNum);
        view.addObject("sqrxxId", sqrxxId);
        view.addObject("bcxrxxId", bcxrxxId);
        view.addObject("populationType", populationType);
        view.addObject("cxbs", cxbs);
        view.addObject("debug",debug);
        view.addObject("baseIdCardNum",baseIdCardNum);
        // 10：终端，20：pc端,30:网上查询
        if ("10".equals(cxbs)) {
            // 20160316需求：终端下，需要增加自动关闭页面功能
            view.setViewName("/information/jsp/czrkDetail_plates");
        }
        if(StringUtils.isNotBlank(relevance)){
            //是否关联查询
            view.setViewName("/information/jsp/czrkDetail_plates_relevance");
        }
        return view;
    }

    /**
     * 暂住人口详情页面（新开页面）兼容PC\网上查询等
     * 
     * @param idCardNum
     * @param sqrxxId
     * @param bcxrxxId
     * @param cxbs
     * @return
     */
    @RequestMapping("zzrkDetail")
    public ModelAndView zczrkDetail(@RequestParam(value = "idCardNum",
            required = true) String idCardNum, @RequestParam(value = "sqrxxId",
            required = true) String sqrxxId, @RequestParam(value = "bcxrxxId",
            required = true) String bcxrxxId, @RequestParam(value = "cxbs",
            required = true) String cxbs,String debug) {
        String populationType = "暂住人口";
        ModelAndView view = new ModelAndView("/information/jsp/zzrkDetail");
        view.addObject("thirdPartyZzrkUrl",
                MessageResourceUtils.getMessage("ThirdParty.zzrk.url"));
        view.addObject("idCardNum", idCardNum);
        view.addObject("sqrxxId", sqrxxId);
        view.addObject("bcxrxxId", bcxrxxId);
        view.addObject("populationType", populationType);
        view.addObject("cxbs", cxbs);
        view.addObject("debug",debug);
        // 10：终端，20：pc端,30:网上查询
        if ("10".equals(cxbs)) {
            // 20160316需求：终端下，需要增加自动关闭页面功能
            view.setViewName("/information/jsp/zzrkDetail_plates");
        }

        return view;
    }

    /**
     * 跳转到第三方系统
     * 
     * @param url
     * @return
     */
    @RequestMapping("jumpToThirdParty")
    public ModelAndView jumpToThirdParty(@RequestParam(value = "thirdPartyUrl",
            required = true) String url) {
        ModelAndView view = new ModelAndView(
                "/information/jsp/thirdPartyZzrk_plates");
        view.addObject("thirdPartyZzrkUrl", url);

        return view;
    }

    /**
     * 1、申请人请求查询界面 记录查询日志，返回view
     * 
     * @param hello
     * @return
     */
    @RequestMapping("applicantQuery")
    @ResponseBody
    public QueryRespInfo applicantQuery(TSqrxxPO reqInfo,
            HttpServletRequest request) throws BaseAppException {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);

        if (auditUserPo == null)
            auditUserPo = new AuditUserPO();

        QueryRespInfo respInfo = new QueryRespInfo();
        String uuid = UuidUtils.generatorUUID();
        reqInfo.setId(uuid);
        // 记录的是操作人组织ID
        reqInfo.setCzdw(String.valueOf(auditUserPo.getOrgId()));
        reqInfo.setCzr(String.valueOf(auditUserPo.getUserId()));
        reqInfo.setCxrq(DateUtils.date2String(new Date(),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));
        reqInfo.setLsh(primaryGenerater.getNextSqrLsh());
        // 记录查询日志，生成日志操作记录信息表
        sqrxxService.add(reqInfo);
        respInfo.setUuid(uuid);

        // System.out.println("MessageResourceUtils:"
        // + MessageResourceUtils.getMessage("senderId"));
        // System.out.println("======================");
        // System.out.println(request.getSession().getServletContext()
        // .getRealPath("/"));
        // System.out.println("======================");

        return respInfo;
    }

    /**
     * 被查询人信息列表，对应 《常暂住人口查询结果页面》的表格
     * 
     * @param reqInfo
     * @param request
     * @return
     * @throws BaseAppException
     */
    @RequestMapping("queryByOther")
    @ResponseBody
    public List<QueryResultInfo> queryByOtherPeople(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request)
            throws BaseAppException {

        /************************ Get drag data start ********************************/
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);
        // 被查询身份证号码
        String pid = reqInfo.getIdCardNum();
        if (StringUtils.isBlank(pid)) {
            ExceptionHandler.publish("APP-01-0030", "查询的身份证号不能为空！");
        }
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }
        
        //申请人流水号
        String srqLsh = "";
        TSqrxxPO sqrxxPO = sqrxxService.selectByPrimaryKey(reqInfo.getSqrxxId());
        srqLsh = sqrxxPO.getLsh();

        // 被查询者姓名
        String bcxrxm = "";

        String resultCZRK = InfoRbspClient.queryCZRKbaseInfo(auditUserPo, pid,
                "PID", null);
        InfoResultVO czrkVO = InfoXmlParser.parserXML(resultCZRK);
        List<Map<String, String>> czrkbaseInfoList = InfoXmlParser
                .parserResultVO(czrkVO);

        // 最终返回给前台的结果集
        List<QueryResultInfo> queryResultInfoList = new ArrayList<QueryResultInfo>();
        // 是否查到常住人口信息
        boolean hasCZRKBase = false;
        if (czrkbaseInfoList.size() > 0) {

            // TODO 20160309 @惜帅 常口的数据，需要进行筛选
            Map<String, String> rowMap = buildCZRKLastlyInfo(czrkbaseInfoList);
            if (null != rowMap)
            // for (Map<String, String> rowMap : czrkbaseInfoList) {
            {
                // 查到常口数据了
                hasCZRKBase = true;
                QueryResultInfo resultInfo = new QueryResultInfo();
                String uuid = UuidUtils.generatorUUID();

                resultInfo.setBcxrxxId(uuid);
                // resultInfo.setIdCardNum(pid);
                // 从接口数据获取，保证完全正确
                resultInfo.setIdCardNum(rowMap.get("PID"));
                // 出生日期
                String dobStr = rowMap.get("DOB");
                if (StringUtils.isNotBlank(dobStr)) {
                    if (dobStr.length() > 10) {
                        resultInfo.setBirthDate(dobStr.substring(0, 10));
                    }
                    else {
                        resultInfo.setBirthDate(dobStr);
                    }
                }
                // TODO 迁往地 住址
                // String huId = rowMap.get("HU_ID");
                // String allFullAddr = buildAllFullAddr(auditUserPo, pid, huId);
                // resultInfo.setAddress(allFullAddr);

                resultInfo.setAddress(rowMap.get("TO_ADDR"));

                resultInfo.setIsHavingTR("");
                resultInfo.setName(rowMap.get("NAME"));// 姓名
                if (StringUtils.isNotBlank(rowMap.get("NAME")))
                    bcxrxm = rowMap.get("NAME");// 姓名
                resultInfo.setPopulationType("户籍人口");
                queryResultInfoList.add(resultInfo);

                try {
                    // 被查询人信息
                    TBcxrxxPO bcxrxxPO = new TBcxrxxPO();
                    bcxrxxPO.setId(uuid);
                    bcxrxxPO.setSqrId(reqInfo.getSqrxxId());
                    bcxrxxPO.setZjlx("10");// 证件类型（10：身份证，20：其他）
                    bcxrxxPO.setZjh(pid);
                    bcxrxxPO.setXm(bcxrxm);
                    bcxrxxPO.setSfzf("0");// 是否作废（1：是，0：否）默认为“否”
                    bcxrxxPO.setSfdy("0");// 是否打印（1：是，0：否）默认为“否”
                    bcxrxxPO.setBcxrq(DateUtils.date2String(new Date(),
                            DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));// 被查询日期
                    bcxrxxPO.setRklx("1");// 人口类型（1：户籍人口，2：暂住人口）
                    bcxrxxPO.setCxcs(0);// 查询次数
                    bcxrxxPO.setDycs(0);// 打印次数
                    bcxrxxPO.setGldycs(0);//关联打印次数
                    //生成被查询人流水号
                    bcxrxxPO.setLsh(primaryGenerater.getNextBcxrLsh(srqLsh));
                    // 记录日志
                    bcxrxxService.add(bcxrxxPO);
                }
                catch (Exception e) {
                    logger.error("插入被查询人信息时发生错误", e);
                }
            }
            // }
        }

        /**
         * { QueryResultInfo resultInfo = new QueryResultInfo(); resultInfo.setAddress("");// 户籍详细地址 resultInfo.setIdCardNum(pid);
         * resultInfo.setIsHavingTR("已办证"); resultInfo.setName("");// 姓名 resultInfo.setPopulationType("暂住人口"); queryResultInfoList.add(resultInfo); }
         */

        /**
         * 20160225需求，如果有常口信息的，就不查暂口信息了，就只显示常口信息
         */
        if ("false".equals(MessageResourceUtils.getMessage("isBothQuery"))
                && czrkbaseInfoList.size() > 0 && hasCZRKBase) {
            logger.info(String.format("查到常口信息的，就不查暂口信息了，就只显示常口信息.身份证号=[%s]",
                    pid));
            return queryResultInfoList;
        }

        /**
         * 查询有办理过暂居住证的
         */
        String resultLDRK_JBXX = InfoRbspClient.queryLDRK_JBXXInfo(auditUserPo,
                pid, null);
        InfoResultVO ldrk_jbxxVO = InfoXmlParser.parserXML(resultLDRK_JBXX);
        List<Map<String, String>> ldrk_jbxxList = InfoXmlParser
                .parserResultVO(ldrk_jbxxVO);

        if (null != ldrk_jbxxList && ldrk_jbxxList.size() > 0) {
            // 流动人口基本信息展现最新的一条的基本信息，
            // 只显示一条信息，最新的记录
            Map<String, String> ldrk_jbxxLatelyMap = buildLDRK_JBXXLastlyInfo(ldrk_jbxxList);

            // 拼装信息到前台，并且记录日志
            {
                QueryResultInfo resultInfo = new QueryResultInfo();
                String uuid = UuidUtils.generatorUUID();

                resultInfo.setBcxrxxId(uuid);
                // resultInfo.setIdCardNum(pid);
                // 从接口数据获取，保证完全正确
                resultInfo.setIdCardNum(ldrk_jbxxLatelyMap.get("PID"));
                // 出生日期
                String dobStr = ldrk_jbxxLatelyMap.get("DOB");
                if (StringUtils.isNotBlank(dobStr)) {
                    if (dobStr.length() > 10) {
                        resultInfo.setBirthDate(dobStr.substring(0, 10));
                    }
                    else {
                        resultInfo.setBirthDate(dobStr);
                    }
                }
                resultInfo.setAddress(ldrk_jbxxLatelyMap.get("HJD_FULL_ADDR"));// 户籍详细地址
                resultInfo.setIsHavingTR("已办证");
                resultInfo.setName(ldrk_jbxxLatelyMap.get("NAME"));// 姓名
                if (StringUtils.isNotBlank(ldrk_jbxxLatelyMap.get("NAME")))
                    bcxrxm = ldrk_jbxxLatelyMap.get("NAME");// 姓名
                resultInfo.setPopulationType("暂住人口");
                queryResultInfoList.add(resultInfo);

                try {
                    // 被查询人信息
                    TBcxrxxPO bcxrxxPO = new TBcxrxxPO();
                    bcxrxxPO.setId(uuid);
                    bcxrxxPO.setSqrId(reqInfo.getSqrxxId());
                    bcxrxxPO.setZjlx("10");// 证件类型（10：身份证，20：其他）
                    bcxrxxPO.setZjh(pid);
                    bcxrxxPO.setXm(bcxrxm);
                    bcxrxxPO.setSfzf("0");// 是否作废（1：是，0：否）默认为“否”
                    bcxrxxPO.setSfdy("0");// 是否打印（1：是，0：否）默认为“否”
                    bcxrxxPO.setBcxrq(DateUtils.date2String(new Date(),
                            DateUtils.STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT));// 被查询日期
                    bcxrxxPO.setRklx("2");// 人口类型（1：户籍人口，2：暂住人口）
                    bcxrxxPO.setCxcs(0);// 查询次数
                    bcxrxxPO.setDycs(0);// 打印次数
                    bcxrxxPO.setGldycs(0);//关联打印次数
                    //生成被查询人流水号
                    bcxrxxPO.setLsh(primaryGenerater.getNextBcxrLsh(srqLsh));
                    // 记录日志
                    bcxrxxService.add(bcxrxxPO);
                }
                catch (Exception e) {
                    logger.error("插入被查询人信息时发生错误", e);
                }

            }
        }

        /************************ Get drag data end ********************************/

        return queryResultInfoList;
    }

    /**
     * 点《常住人口信息记录详情》展现的数据
     * 
     * @param reqInfo
     * @param request
     * @return
     * @throws BaseAppException
     */
    @RequestMapping("queryCZRKinfo")
    @ResponseBody
    public PermanetPopulationInfo queryPermanetPopulationInfo(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request)
            throws BaseAppException {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);

        PermanetPopulationInfo permanentPopulationInfo = new PermanetPopulationInfo();
        permanentPopulationInfo.setCzdw(auditUserPo.getOrgName());
        permanentPopulationInfo.setCzr(auditUserPo.getUserName());
        permanentPopulationInfo.setTipMessage(MessageResourceUtils
                .getMessage("Detail.tipMessage"));
        permanentPopulationInfo.setDyrq(DateUtils.date2String(new Date(),
                MessageResourceUtils.getMessage("Dyrq.format")));

        //申请人对象
        permanentPopulationInfo.setSqrxxPO(sqrxxService.selectByPrimaryKey(reqInfo.getSqrxxId()));
        //查询人对象
        permanentPopulationInfo.setBcxrxxPO(bcxrxxService.selectByPrimaryKey(reqInfo.getBcxrxxId()));
        
        // PC端查询 10：终端，20：pc端,30:网上查询
        buildCZRKInfo(reqInfo, request, auditUserPo, permanentPopulationInfo,
                "20");

        return permanentPopulationInfo;
    }

    /**
     * 构造《常住人口信息记录详情》展现的数据
     * 
     * @param reqInfo
     * @param request
     * @param auditUserPo
     * @param permanentPopulationInfo
     * @param cxbs
     * @throws BaseAppException
     */
    public void buildCZRKInfo(QueryByOtherPeopleReqInfo reqInfo,
            HttpServletRequest request, AuditUserPO auditUserPo,
            PermanetPopulationInfo permanentPopulationInfo, String cxbs)
            throws BaseAppException {
        String pid = reqInfo.getIdCardNum();
        if (StringUtils.isBlank(pid)) {
            ExceptionHandler.publish("APP-01-0030", "查询的身份证号不能为空！");
        }
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }

        // 查询常住人口信息
        String czrkInfoResult = InfoRbspClient.queryCZRKbaseInfo(auditUserPo,
                pid, "PID", null);
        InfoResultVO czrkVO = InfoXmlParser.parserXML(czrkInfoResult);
        List<Map<String, String>> czrkInfoList = InfoXmlParser
                .parserResultVO(czrkVO);

        if (null == czrkInfoList || czrkInfoList.size() == 0) {
            ExceptionHandler.publish("APP-01-0020", "该身份证查询不到常住人口信息！");
        }

        Map<String, String> czrkInfoMap = buildCZRKLastlyInfo(czrkInfoList);

        if (null == czrkInfoMap) {
            ExceptionHandler.publish("APP-01-0020", "该身份证查询不到常住人口信息！！");
        }

        // 获取它的照片编号
        String photoId = czrkInfoMap.get("PHOTO_ID");
        if (StringUtils.isNotBlank(photoId)) {
            // 查询photo信息并保存在服务器固定目录
            String photoInfoResult = InfoRbspClient.queryImageInfo(auditUserPo,
                    photoId);
            InfoResultVO photoVO = InfoXmlParser.parserXML(photoInfoResult);
            List<Map<String, String>> photoInfoList = InfoXmlParser
                    .parserResultVO(photoVO);
            if (photoInfoList.size() > 0) {
                String imageStr = photoInfoList.get(0).get("IMAGE");
                if (StringUtils.isNotBlank(imageStr)) {
                    try {
                        savePhoto(request, pid, imageStr);
                    }
                    catch (Exception e) {
                        logger.error("保存身份证照片时发生异常", e);
                    }
                }
                else {
                    logger.error(String.format(
                            "常住人口信息]报文信息中没有照片编码，无法保存.身份证号=[%s]", pid));
                }
            }
        }
        else {
            
            //没有照片
            saveBlankPhoto(request, pid);
            
            logger.error(String.format("常住人口信息]报文信息中没有照片编号.身份证号=[%s]", pid));
        }

        String huId = czrkInfoMap.get("HU_ID");
        // 查询全量地址
        String allFullAddr = buildAllFullAddr(auditUserPo, pid, huId);

        // 拼装家庭关系及联系人信息
        List<FamilyInfo> familyInfoList = bulidFamilyInfo(auditUserPo, pid,
                czrkInfoMap, cxbs);

        // 拼装基本信息
        PopulationBaseInfo baseInfo = buildBasePopulation(czrkInfoMap,
                allFullAddr);

        // 拼装迁移信息
        MigrateInfo migrateInfo = buildMigrateInfo(auditUserPo, pid,
                czrkInfoMap);

        permanentPopulationInfo.setBaseInfo(baseInfo);
        permanentPopulationInfo.setFamilyInfoList(familyInfoList);
        permanentPopulationInfo.setMigrateInfo(migrateInfo);

        try {
            /**
             * modify by 惜帅 2015-11-30 如果被查询人ID为空，那么是点击父亲/母亲的身份证关联查询的，则不记录日志
             */
            if (StringUtils.isBlank(reqInfo.getBcxrxxId())) {
                return;
            }

            // 更新日志
            // 被查询人信息
            TBcxrxxPO bcxrxxPO = bcxrxxService.selectByPrimaryKey(reqInfo
                    .getBcxrxxId());
            TBcxrxxPO nbcxrxxPO = new TBcxrxxPO();
            // 更新查询次数
            nbcxrxxPO.setId(bcxrxxPO.getId());
            nbcxrxxPO.setCxcs(bcxrxxPO.getCxcs() + 1);
            bcxrxxService.update(nbcxrxxPO);
        }
        catch (Exception e) {
            logger.error("更新被查询人信息（查询次数）时发生错误", e);
        }

    }

    /**
     * 构建全量地址
     * 
     * @param auditUserPo
     * @param pid
     * @param huId
     * @return
     * @throws BaseAppException
     */
    public String buildAllFullAddr(AuditUserPO auditUserPo, String pid,
            String huId) throws BaseAppException {
        String allFullAddr = "";
        if (StringUtils.isNotBlank(huId)) {
            String huInfoResult = InfoRbspClient.queryCZRKCensusInfo(
                    auditUserPo, huId);
            InfoResultVO huInfoVO = InfoXmlParser.parserXML(huInfoResult);
            List<Map<String, String>> huInfoList = InfoXmlParser
                    .parserResultVO(huInfoVO);
            if (huInfoList.size() > 0) {
                String metaAddrId = huInfoList.get(0).get("META_ADDR_ID");
                if (StringUtils.isNotBlank(metaAddrId)) {
                    String dzInfoResult = InfoRbspClient.queryDZinfo(
                            auditUserPo, metaAddrId);
                    InfoResultVO dzInfoVO = InfoXmlParser
                            .parserXML(dzInfoResult);
                    List<Map<String, String>> dzInfoList = InfoXmlParser
                            .parserResultVO(dzInfoVO);
                    if (dzInfoList.size() > 0) {
                        allFullAddr = dzInfoList.get(0).get("ALL_FULL_ADDR");
                    }
                }
                else {
                    logger.error(String.format(
                            "常住人口信息]报文信息中没有META_ADDR_ID.身份证号=[%s],HU_ID=[%s]",
                            pid, huId));
                }
            }
        }
        else {
            logger.error(String.format("常住人口信息]报文信息中没有HU_ID.身份证号=[%s]", pid));
        }
        return allFullAddr;
    }

    /**
     * 点《暂住人口信息记录详情》展现的数据
     * 
     * @param reqInfo
     * @param request
     * @return
     * @throws BaseAppException
     */
    @RequestMapping("queryZZRKinfo")
    @ResponseBody
    public TRpopulationInfo queryTRPopulationInfo(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request)
            throws BaseAppException {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);

        TRpopulationInfo trPopulationInfo = new TRpopulationInfo();
        trPopulationInfo.setCzdw(auditUserPo.getOrgName());
        trPopulationInfo.setCzr(auditUserPo.getUserName());
        trPopulationInfo.setTipMessage(MessageResourceUtils
                .getMessage("Detail.tipMessage"));
        trPopulationInfo.setDyrq(DateUtils.date2String(new Date(),
                MessageResourceUtils.getMessage("Dyrq.format")));

        //申请人对象
        trPopulationInfo.setSqrxxPO(sqrxxService.selectByPrimaryKey(reqInfo.getSqrxxId()));
        //查询人对象
        trPopulationInfo.setBcxrxxPO(bcxrxxService.selectByPrimaryKey(reqInfo.getBcxrxxId()));
        
        
        buildZZRKInfo(reqInfo, request, auditUserPo, trPopulationInfo);

        return trPopulationInfo;
    }

    /**
     * 拼装 《暂住人口信息记录详情》展现的数据
     * 
     * @param reqInfo
     * @param request
     * @param auditUserPo
     * @param trPopulationInfo
     * @throws BaseAppException
     */
    public void buildZZRKInfo(QueryByOtherPeopleReqInfo reqInfo,
            HttpServletRequest request, AuditUserPO auditUserPo,
            TRpopulationInfo trPopulationInfo) throws BaseAppException {

        String pid = reqInfo.getIdCardNum();
        if (StringUtils.isBlank(pid)) {
            ExceptionHandler.publish("APP-01-0030", "查询的身份证号不能为空！");
        }
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }

        // 查流动人口信息
        String resultLDRK_JBXX = InfoRbspClient.queryLDRK_JBXXInfo(auditUserPo,
                pid, null);
        InfoResultVO ldrk_jbxxVO = InfoXmlParser.parserXML(resultLDRK_JBXX);
        List<Map<String, String>> ldrk_jbxxList = InfoXmlParser
                .parserResultVO(ldrk_jbxxVO);

        if (null != ldrk_jbxxList && ldrk_jbxxList.size() > 0) {
            // 流动人口基本信息展现最新的一条的基本信息，
            // 只显示一条信息，最新的记录
            Map<String, String> ldrk_jbxxLatelyMap = buildLDRK_JBXXLastlyInfo(ldrk_jbxxList);

            String photoId = ldrk_jbxxLatelyMap.get("PHOTO_ID");

            if (StringUtils.isNotBlank(photoId)) {
                // 查询photo信息并保存在服务器固定目录
                String photoInfoResult = InfoRbspClient.queryImageInfo(
                        auditUserPo, photoId);

                InfoResultVO photoInfoVO = InfoXmlParser
                        .parserXML(photoInfoResult);
                List<Map<String, String>> photoInfoList = InfoXmlParser
                        .parserResultVO(photoInfoVO);

                if (photoInfoList.size() > 0) {
                    String imageStr = photoInfoList.get(0).get("IMAGE");
                    if (StringUtils.isNotBlank(imageStr)) {
                        try {
                            savePhoto(request, pid, imageStr);
                        }
                        catch (Exception e) {
                            logger.error("保存身份证照片时发生异常", e);
                        }
                    }
                    else {
                        logger.error(String.format(
                                "[流动人口基本信息]最后有效的报文信息中没有照片编码，无法保存.身份证号=[%s]",
                                pid));
                    }

                }
            }
            else {
                
                //没有照片
                saveBlankPhoto(request, pid);
                
                logger.error(String.format(
                        "[流动人口基本信息]最后有效的报文信息中没有照片编号.身份证号=[%s]", pid));
            }

            // 拼装ZK基本信息，流动人口基本信息数据查询服务
            trPopulationInfo
                    .setBaseInfo(buildZZRKBasePopulation(ldrk_jbxxLatelyMap));

            /**
             * 20160309更新，过滤掉暂住证编号为空的，然后在剩余数据中选出“登记时间“为最新的 基本信息，然后将登记时间填到”填报日期“里
             */

            /**
             * 查询 暂（居）住证信息数据查询服务 String resultLDRK_ZJZZ = InfoRbspClient.queryZJZZXXInfo( auditUserPo, pid); InfoResultVO ldrk_zjzzVO =
             * InfoXmlParser.parserXML(resultLDRK_ZJZZ); List<Map<String, String>> ldrk_zjzzList = InfoXmlParser .parserResultVO(ldrk_zjzzVO); if
             * (null != ldrk_zjzzList && ldrk_zjzzList.size() > 0) { // 拼装ZK暂住信息，暂（居）住证信息数据查询服务 List<TRinfo> zjzzList =
             * buildZjzzInfoList(ldrk_zjzzList); trPopulationInfo.setTrInfoList(zjzzList); // 取最新暂（居）住证信息的“填报日期”放置到基本信息中 TRinfo lastIRinfo =
             * zjzzList.get(zjzzList.size() - 1); trPopulationInfo.getBaseInfo().setFillDate( lastIRinfo.getFillDate()); }
             */

        }
        else {
            ExceptionHandler.publish("APP-01-0021", "该身份证查询不到暂（居）住证信息！");
        }

        try {
            // 更新日志
            // 被查询人信息
            TBcxrxxPO bcxrxxPO = bcxrxxService.selectByPrimaryKey(reqInfo
                    .getBcxrxxId());
            TBcxrxxPO nbcxrxxPO = new TBcxrxxPO();
            // 更新查询次数
            nbcxrxxPO.setId(bcxrxxPO.getId());
            nbcxrxxPO.setCxcs(bcxrxxPO.getCxcs() + 1);
            bcxrxxService.update(nbcxrxxPO);
        }
        catch (Exception e) {
            logger.error("更新被查询人信息（查询次数）时发生错误", e);
        }
    }

    @RequestMapping("printInfo")
    @ResponseBody
    public void printQueryInfo(PrintReqInfo reqInfo) {

    }

    /**
     * 拼装CK基本信息
     * 
     * @param rowInfoMap
     * @param allFullAddr
     * @return
     */
    public PopulationBaseInfo buildBasePopulation(
            Map<String, String> rowInfoMap, String allFullAddr) {
        PopulationBaseInfo baseInfo = new PopulationBaseInfo();

        baseInfo.setAliaName(rowInfoMap.get("USED_NAME"));
        // 出生日期
        String dobStr = rowInfoMap.get("DOB");
        if (StringUtils.isNotBlank(dobStr)) {
            if (dobStr.length() > 10) {
                baseInfo.setBirthDate(dobStr.substring(0, 10));
            }
            else {
                baseInfo.setBirthDate(dobStr);
            }
        }

        baseInfo.setBirthPlaceDetailAddress(rowInfoMap.get("NATAL_XIANG"));
        baseInfo.setBirthPlaceNation(rowInfoMap.get("NATAL_COUNTRY"));
        baseInfo.setBirthPlaceProvince(rowInfoMap.get("NATAL_PLACE"));
        baseInfo.setHouseholdRegisterDetailAddress("");
        baseInfo.setHouseholdRegisterProviceAddress("");
        baseInfo.setIdCardExciptyTime(rowInfoMap.get("PID_USEFUL_LIFE"));
        baseInfo.setIdCardIssuneOffice(rowInfoMap.get("PID_ISSUE_UNIT_NAME"));
        baseInfo.setIdCardNum(rowInfoMap.get("PID"));
        baseInfo.setLiveAddress(allFullAddr);
        baseInfo.setName(rowInfoMap.get("NAME"));
        String nation = rowInfoMap.get("NATION");
        baseInfo.setNation(nation==null?"":nation.replaceAll("/", ""));
        baseInfo.setNativePlace("");
        baseInfo.setNativePlaceDetailAddress(rowInfoMap.get("NATIVE_XIANG"));
        baseInfo.setNativePlaceNation(rowInfoMap.get("NATIVE_COUNTRY"));
        baseInfo.setNativePlaceProvince(rowInfoMap.get("NATIVE_PLACE"));
        // 身份证照片地址
        baseInfo.setPhotoGif(rowInfoMap.get("PID") + ".jpg");
        baseInfo.setPoliceStation(rowInfoMap.get("WHO_IN_UNIT_NAME"));
        baseInfo.setSex(TransUtils.transSex(rowInfoMap.get("GENDER")));
        return baseInfo;
    }

    /**
     * 拼装CK 家庭关系及联系人信息
     * 
     * @param auditUserPO
     * @param pid
     * @param rowInfoMap
     * @param cxbs
     * @return
     * @throws BaseAppException
     */
    public List<FamilyInfo> bulidFamilyInfo(AuditUserPO auditUserPO,
            String pid, Map<String, String> rowInfoMap, String cxbs)
            throws BaseAppException {
        List<FamilyInfo> familyInfoList = new ArrayList<FamilyInfo>();
        FamilyInfo familyInfoFather = new FamilyInfo();
        familyInfoFather.setRelationType("父母");
        familyInfoFather.setRelationShip("父亲");
        if (StringUtils.isNotBlank(rowInfoMap.get("FA_PID"))) {
            // 10：终端，20：pc端,30:网上查询
            if ("10".equals(cxbs) || "30".equals(cxbs)) {
                familyInfoFather.setIdCardNum(rowInfoMap.get("FA_PID"));
            }
            else {
                // familyInfoFather.setIdCardNum("<a href=\"javascript:openCZRKinfo("+rowInfoMap.get("FA_PID")+")\">"+rowInfoMap.get("FA_PID")+"</a>");
                familyInfoFather.setIdCardNum("<a href=\"#\" pid=\""
                        + rowInfoMap.get("FA_PID") + "\">"
                        + rowInfoMap.get("FA_PID") + "</a>");
            }

        }
        familyInfoFather.setCertificateType(rowInfoMap.get("FA_CARD_TYPE"));
        familyInfoFather.setCertificateNum(rowInfoMap.get("FA_CARD_NO"));
        familyInfoFather.setForeignFirstName(rowInfoMap.get("FA_WWX"));
        familyInfoFather.setForeignLastName(rowInfoMap.get("FA_WWM"));
        familyInfoFather.setName(rowInfoMap.get("FA_NAME"));
        familyInfoFather.setTelephoneNum("");
        // 添加
        familyInfoList.add(familyInfoFather);

        FamilyInfo familyInfoMother = new FamilyInfo();
        familyInfoMother.setRelationType("父母");
        familyInfoMother.setRelationShip("母亲");
        if (StringUtils.isNotBlank(rowInfoMap.get("MA_PID"))) {
            // 10：终端，20：pc端,30:网上查询
            if ("10".equals(cxbs) || "30".equals(cxbs)) {
                familyInfoMother.setIdCardNum(rowInfoMap.get("MA_PID"));
            }
            else {
                familyInfoMother.setIdCardNum("<a href=\"#\" pid=\""
                        + rowInfoMap.get("MA_PID") + "\">"
                        + rowInfoMap.get("MA_PID") + "</a>");
            }

        }
        familyInfoMother.setCertificateType(rowInfoMap.get("MA_CARD_TYPE"));
        familyInfoMother.setCertificateNum(rowInfoMap.get("MA_CARD_NO"));
        familyInfoMother.setForeignFirstName(rowInfoMap.get("MA_WWX"));
        familyInfoMother.setForeignLastName(rowInfoMap.get("MA_WWM"));
        familyInfoMother.setName(rowInfoMap.get("MA_NAME"));
        familyInfoMother.setTelephoneNum("");
        // 添加
        familyInfoList.add(familyInfoMother);

        FamilyInfo familyInfoSpouse = new FamilyInfo();
        familyInfoSpouse.setRelationType("配偶");
        familyInfoSpouse.setIdCardNum(rowInfoMap.get("PO_PID"));
        if (StringUtils.isNotBlank(rowInfoMap.get("PO_PID"))) {
            // 10：终端，20：pc端,30:网上查询
            if ("10".equals(cxbs) || "30".equals(cxbs)) {
                familyInfoSpouse.setIdCardNum(rowInfoMap.get("PO_PID"));
            }
            else {
                familyInfoSpouse.setIdCardNum("<a href=\"#\" pid=\""
                        + rowInfoMap.get("PO_PID") + "\">"
                        + rowInfoMap.get("PO_PID") + "</a>");
            }

        }
        if ("男".equals(TransUtils.transSex(rowInfoMap.get("GENDER")))) {
            familyInfoSpouse.setRelationShip("妻子");
        }
        if ("女".equals(TransUtils.transSex(rowInfoMap.get("GENDER")))) {
            familyInfoSpouse.setRelationShip("丈夫");
        }
        familyInfoSpouse.setCertificateType(rowInfoMap.get("PO_CARD_TYPE"));
        familyInfoSpouse.setCertificateNum(rowInfoMap.get("PO_CARD_NO"));
        familyInfoSpouse.setForeignFirstName(rowInfoMap.get("PO_WWX"));
        familyInfoSpouse.setForeignLastName(rowInfoMap.get("PO_WWM"));
        familyInfoSpouse.setName(rowInfoMap.get("PO_NAME"));
        familyInfoSpouse.setTelephoneNum("");
        // 需要判断是否有配偶
        if (!StringUtils.isBlank(familyInfoSpouse.getName())) {
            familyInfoList.add(familyInfoSpouse);
        }

        FamilyInfo familyInfoKeeper = new FamilyInfo();
        familyInfoKeeper.setRelationType("监护人");
        familyInfoKeeper.setRelationShip("监护人1");
        familyInfoKeeper.setIdCardNum(rowInfoMap.get("GURARDIAN_1_PID"));
        if (StringUtils.isNotBlank(rowInfoMap.get("GURARDIAN_1_PID"))) {
            // 10：终端，20：pc端,30:网上查询
            if ("10".equals(cxbs) || "30".equals(cxbs)) {
                familyInfoKeeper
                        .setIdCardNum(rowInfoMap.get("GURARDIAN_1_PID"));
            }
            else {
                familyInfoKeeper.setIdCardNum("<a href=\"#\" pid=\""
                        + rowInfoMap.get("GURARDIAN_1_PID") + "\">"
                        + rowInfoMap.get("GURARDIAN_1_PID") + "</a>");
            }
        }

        familyInfoKeeper.setCertificateType(rowInfoMap
                .get("GURARDIAN_1_CARD_TYPE"));
        familyInfoKeeper.setCertificateNum(rowInfoMap
                .get("GURARDIAN_1_CARD_NO"));

        familyInfoKeeper.setForeignFirstName(rowInfoMap.get("GURARDIAN_1_WWX"));
        familyInfoKeeper.setForeignLastName(rowInfoMap.get("GURARDIAN_1_WWM"));
        familyInfoKeeper.setName(rowInfoMap.get("GURARDIAN_1"));
        familyInfoKeeper.setTelephoneNum("GURARDIAN_1_TEL");

        FamilyInfo familyInfoKeeperTwo = new FamilyInfo();
        familyInfoKeeperTwo.setRelationType("监护人");
        familyInfoKeeperTwo.setRelationShip("监护人2");
        familyInfoKeeperTwo.setIdCardNum(rowInfoMap.get("GURARDIAN_2_PID"));
        if (StringUtils.isNotBlank(rowInfoMap.get("GURARDIAN_2_PID"))) {
            // 10：终端，20：pc端,30:网上查询
            if ("10".equals(cxbs) || "30".equals(cxbs)) {
                familyInfoKeeperTwo.setIdCardNum(rowInfoMap
                        .get("GURARDIAN_2_PID"));
            }
            else {
                familyInfoKeeperTwo.setIdCardNum("<a href=\"#\" pid=\""
                        + rowInfoMap.get("GURARDIAN_2_PID") + "\">"
                        + rowInfoMap.get("GURARDIAN_2_PID") + "</a>");
            }
        }

        familyInfoKeeperTwo.setCertificateType(rowInfoMap
                .get("GURARDIAN_2_CARD_TYPE"));
        familyInfoKeeperTwo.setCertificateNum(rowInfoMap
                .get("GURARDIAN_2_CARD_NO"));
        familyInfoKeeperTwo.setForeignFirstName(rowInfoMap
                .get("GURARDIAN_2_WWX"));
        familyInfoKeeperTwo.setForeignLastName(rowInfoMap
                .get("GURARDIAN_2_WWM"));
        familyInfoKeeperTwo.setName(rowInfoMap.get("GURARDIAN_2"));
        familyInfoKeeperTwo.setTelephoneNum("GURARDIAN_2_TEL");
        // 需要判断是否有监护人1
        if (!StringUtils.isBlank(familyInfoKeeper.getName())) {
            familyInfoList.add(familyInfoKeeper);
        }
        // 需要判断是否有监护人2
        if (!StringUtils.isBlank(familyInfoKeeperTwo.getName())) {
            familyInfoList.add(familyInfoKeeperTwo);
        }

        /**
         * 该逻辑，改成在前台处理
         */
        // 10：终端，20：pc端,30:网上查询
//        if ("10".equals(cxbs)) {
//            // 20160316需求：终端下查询，不查询子女信息
//            return familyInfoList;
//        }

        // 查找该人的所有子女
        String whereFiled = "";

        if ("男".equals(TransUtils.transSex(rowInfoMap.get("GENDER")))) {
            whereFiled = "FA_PID";
        }
        if ("女".equals(TransUtils.transSex(rowInfoMap.get("GENDER")))) {
            whereFiled = "MA_PID";
        }

        if (StringUtils.isNotBlank(whereFiled)) {
            String czrkInfoResult = InfoRbspClient.queryCZRKbaseInfo(
                    auditUserPO, pid, whereFiled, null);
            InfoResultVO czrkVO = InfoXmlParser.parserXML(czrkInfoResult);
            List<Map<String, String>> czrkInfoList = InfoXmlParser
                    .parserResultVO(czrkVO);

            if (null != czrkInfoList && czrkInfoList.size() > 0) {
                for (Map<String, String> oneChildMap : czrkInfoList) {
                    FamilyInfo familyInfoChild = new FamilyInfo();
                    familyInfoChild.setRelationType("子女");
                    familyInfoChild.setRelationTypeNum("40");
                    if ("男".equals(TransUtils.transSex(oneChildMap
                            .get("GENDER")))) {
                        familyInfoChild.setRelationShip("儿子");
                    }
                    if ("女".equals(TransUtils.transSex(oneChildMap
                            .get("GENDER")))) {
                        familyInfoChild.setRelationShip("女儿");
                    }
                    // TODO 惜帅 子女信息
                    familyInfoChild.setIdCardNum(oneChildMap.get("PID"));
                    if (StringUtils.isNotBlank(oneChildMap.get("PID"))) {
                        // 10：终端，20：pc端,30:网上查询
                        if ("10".equals(cxbs) || "30".equals(cxbs)) {
                            familyInfoChild
                                    .setIdCardNum(oneChildMap.get("PID"));
                        }
                        else {
                            familyInfoChild.setIdCardNum("<a href=\"#\" pid=\""
                                    + oneChildMap.get("PID") + "\">"
                                    + oneChildMap.get("PID") + "</a>");
                        }
                    }
                    familyInfoChild.setCertificateType("身份证");
                    familyInfoChild.setCertificateNum(oneChildMap.get("PID"));
                    familyInfoChild.setForeignFirstName("");
                    familyInfoChild.setForeignLastName("");
                    familyInfoChild.setName(oneChildMap.get("NAME"));
                    familyInfoChild.setTelephoneNum("");
                    familyInfoList.add(familyInfoChild);
                }
            }
        }
        return familyInfoList;
    }

    /**
     * 拼装CK 迁移信息
     * 
     * @param auditUserPO
     * @param pid
     * @param rowInfoMap
     * @return
     */
    public MigrateInfo buildMigrateInfo(AuditUserPO auditUserPO, String pid,
            Map<String, String> rowInfoMap) {
        // TODO 惜帅 迁移信息
        MigrateInfo migrateInfo = new MigrateInfo();
        // 何时何因由何地迁来本市(县)
        migrateInfo.setTimeAndResultForMigrateLocal(rowInfoMap.get(""));
        // 何时何因由何地迁来本址
        migrateInfo.setTimeAndResultForMigrateNative(rowInfoMap.get(""));

        // TODO 20160310 需要根据有效户籍/死亡户籍拼装不同的 何时何因迁往何地
        String hujiType = rowInfoMap.get("hujiType");// 自定义户籍类型：1-生效，2-死亡
        if ("1".equals(hujiType)) {
            // 何时何因迁往何地
            migrateInfo
                    .setTimeAndResultForMigrateOtherPlace(rowInfoMap.get(""));
            // 迁移信息的div的Style样式：style="display:none;" 或者 style="display:block;"
            migrateInfo.setQyxxDivStyleCSS("display:none;");
        }
        else if ("2".equals(hujiType)) {
            // “何时何因迁往何地” 显示 When_out+“因”+ OUT_CATEGORY +“死亡注销”

            String msg = "";
            String whenOut = rowInfoMap.get("WHEN_OUT");// 迁出时间
            if (StringUtils.isNotBlank(whenOut)) {
                if (whenOut.length() > 10) {
                    msg += whenOut.substring(0, 10);
                }
                else {
                    msg += whenOut;
                }
            }
            msg += "因" + rowInfoMap.get("OUT_CATEGORY") + "死亡注销";
            migrateInfo.setTimeAndResultForMigrateOtherPlace(msg);
            // 迁移信息的div的Style样式：style="display:none;" 或者 style="display:block;"
            migrateInfo.setQyxxDivStyleCSS("display:block;");
        }

        // migrateInfo.setTimeAndResultForMigrateLocal("smile forever,hhaha");
        // migrateInfo.setTimeAndResultForMigrateNative("xm");
        // migrateInfo.setTimeAndResultForMigrateOtherPlace(" 你猜");
        return migrateInfo;
    }

    /**
     * 获取最新的一条常住人口基本信息
     * 
     * @param czrkbaseInfoList
     * @return
     */
    public Map<String, String> buildCZRKLastlyInfo(
            List<Map<String, String>> czrkbaseInfoList) {
        // TODO 20160309 @惜帅 常口的数据，需要进行筛选
        /**
         * 去查巨龙的时候，带上NOW_SIGN=1，在我们这边过滤<br>
         * 先判断<br>
         * Zxbz=0：有效户籍人口，<br>
         * Zxbz=1：并且Out_kind_code(迁出类别)=21 的为死亡户籍<br>
         */
        return filterCZRKInfo(czrkbaseInfoList);
    }

    /**
     * 筛选常口基本信息，有效户籍或迁出或死亡人口(迁出的不需要展示)
     * 
     * @param czrkbaseInfoList
     * @return
     */
    private Map<String, String> filterCZRKInfo(
            List<Map<String, String>> czrkbaseInfoList) {
        boolean isActive = false;// 是否是有效户籍
        boolean isDeah = false;// 是否是死亡户籍
        Map<String, String> czrk_baseLatelyMap = null;
        for (Map<String, String> oneMap : czrkbaseInfoList) {
            String swsj = oneMap.get("DATE_OF_DEATH");// 死亡时间
            String zxbz = oneMap.get("ZXBZ");// 注销标识
            String nowSign = oneMap.get("NOW_SIGN");// 数据有效唯一标识
            String outKindCode = oneMap.get("OUT_KIND_CODE");// OUT_KIND_CODE(迁出类别) Out_kind_code(迁出类别) 死亡的Out_kind_code=21

            if ("0".equals(zxbz)) {
                // ZXBZ 有效 0 注销 1
                isActive = true;
                czrk_baseLatelyMap = oneMap;
                logger.info(String.format("查询常住人口基本信息，该记录是有效户籍！身份证号=[%s]",
                        oneMap.get("PID")));
                czrk_baseLatelyMap.put("hujiType", "1");// 自定义户籍类型：1-生效，2-死亡
                continue;
            }
            if ("1".equals(zxbz) && "21".equals(outKindCode)) {
                // OUT_KIND_CODE(迁出类别) Out_kind_code(迁出类别) 死亡的Out_kind_code=21
                isDeah = true;
                czrk_baseLatelyMap = oneMap;
                logger.info(String.format("查询常住人口基本信息，该记录是死亡户籍！身份证号=[%s]",
                        oneMap.get("PID")));
                czrk_baseLatelyMap.put("hujiType", "2");// 自定义户籍类型：1-生效，2-死亡
                continue;
            }
        }

        return czrk_baseLatelyMap;
    }

    /**
     * 获取最新的一条流动人口基本信息
     * 
     * @param
     * @return
     */
    public Map<String, String> buildLDRK_JBXXLastlyInfo(
            List<Map<String, String>> ldrk_jbxxList) {
        // TODO 惜帅 流动人口展现最新的一条的基本信息
        // 只显示一条信息，最新的记录
        // 记录生成时间 CREATETIME
        // 记录更新时间 UPDATETIME
        // 登记时间 DJSJ
        /**
         * 20160309更新，过滤掉暂住证编号为空的，然后在剩余数据中选出“登记时间“为最新的 基本信息，然后将登记时间填到”填报日期“里
         */

        Map<String, String> ldrk_jbxxLatelyMap = ldrk_jbxxList.get(0);
        // 用于比较的时间，初始化为1970-01-01
        Date latelyDate = DateUtils.string2Date("1970-01-01",
                DateUtils.STR_DATE_FORMAT_DAY_WITH_SPLIT);

        for (Map<String, String> rowMap : ldrk_jbxxList) {
            String zzzbh = rowMap.get("ZZZBH");// 暂住证编号
            // String jlscsj = rowMap.get("CREATETIME");// 记录生成时间
            // String jlgxsj = rowMap.get("UPDATETIME");// 记录更新时间
            String djsj = rowMap.get("DJSJ");// 登记时间
            if (StringUtils.isBlank(zzzbh)) {
                // 如果 暂住证编号为空，过滤
                logger.info("查询流动人口基本信息，该记录暂住证编号ZZZBH为空为空，跳过！");
                continue;
            }
            if (StringUtils.isBlank(djsj)) {
                logger.error("查询流动人口基本信息，该记录登记时间 DJSJ为空，跳过！");
                continue;
            }
            try {
                Date thizRq = DateUtils.string2Date(djsj, MessageResourceUtils
                        .getMessage("T_LDRK_ZJZZXX.date.format"));
                // 0-小于, 1-等于，2-大于
                if (DateUtils.isCompare(latelyDate, thizRq) < 2) {
                    ldrk_jbxxLatelyMap = rowMap;
                    latelyDate = thizRq;
                }
            }
            catch (Exception e) {
                logger.error("转换比较流动人口基本信息记录登记时间时，发生异常！", e);
            }
        }
        return ldrk_jbxxLatelyMap;
    }

    /**
     * 拼装ZK基本信息，基于流动人口基本信息数据查询服务的报文TC_RKXT.T_LDRK_JBXX
     * 
     * @param ldrkInfoMap
     * @param zzrkInfoMap
     * @return
     */
    public PopulationBaseInfo buildZZRKBasePopulation(
            Map<String, String> ldrk_jbxxLatelyMap) {
        PopulationBaseInfo baseInfo = new PopulationBaseInfo();
        baseInfo.setName(ldrk_jbxxLatelyMap.get("NAME"));
        baseInfo.setAliaName(ldrk_jbxxLatelyMap.get("USED_NAME"));
        baseInfo.setIdCardNum(ldrk_jbxxLatelyMap.get("PID"));
        // 出生日期
        String dobStr = ldrk_jbxxLatelyMap.get("DOB");
        if (StringUtils.isNotBlank(dobStr)) {
            if (dobStr.length() > 10) {
                baseInfo.setBirthDate(dobStr.substring(0, 10));
            }
            else {
                baseInfo.setBirthDate(dobStr);
            }
        }
        baseInfo.setHouseholdRegisterDetailAddress(ldrk_jbxxLatelyMap
                .get("HJD_FULL_ADDR"));// 户籍详细地址
        baseInfo.setHouseholdRegisterProviceAddress(ldrk_jbxxLatelyMap
                .get("HJD_QU"));// 户籍省市县
        baseInfo.setNativePlace(ldrk_jbxxLatelyMap.get("NATIVE_PLACE")); // 籍贯
        // 身份证照片地址
        baseInfo.setPhotoGif(ldrk_jbxxLatelyMap.get("PID") + ".jpg");
        String nation = ldrk_jbxxLatelyMap.get("NATION");
        baseInfo.setNation(nation==null? "" :nation.replaceAll("/", ""));// 民族(GB/T 3304)
        baseInfo.setSex(TransUtils.transSex(ldrk_jbxxLatelyMap.get("GENDER")));// 性别(GB/T 2261.1)

        /**
         * 20160309更新，过滤掉暂住证编号为空的，然后在剩余数据中选出“登记时间“为最新的 基本信息，然后将登记时间填到”填报日期“里
         */
        String djsj = ldrk_jbxxLatelyMap.get("DJSJ");// 登记时间
        if (StringUtils.isNotBlank(djsj)) {
            try {
                baseInfo.setFillDate(djsj.substring(0, 10));
            }
            catch (Exception e) {
                logger.error("截取流动人口基本信息记录登记时间日期格式时，发生异常！身份证号="
                        + ldrk_jbxxLatelyMap.get("PID"), e);
            }
        }
        else {
            baseInfo.setFillDate("");
        }

        return baseInfo;
    }

    /**
     * 拼装ZK暂住信息,基于暂（居）住证信息数据查询服务
     * 
     * @param ldrk_zjzzList
     * @return
     */
    public List<TRinfo> buildZjzzInfoList(
            List<Map<String, String>> ldrk_zjzzList) {

        List<TRinfo> trInfoList = new ArrayList<TRinfo>();

        for (Map<String, String> zzrkInfoMap : ldrk_zjzzList) {
            TRinfo infoOne = new TRinfo();

            // 起始日期
            String qsrqStr = zzrkInfoMap.get("YXQQSRQ");
            if (StringUtils.isNotBlank(qsrqStr)) {
                if (qsrqStr.length() > 10) {
                    infoOne.setStartDate(qsrqStr.substring(0, 10));
                }
                else {
                    infoOne.setStartDate(qsrqStr);
                }
            }

            // 截止日期
            String jzrqStr = zzrkInfoMap.get("YXQXJZRQ");
            if (StringUtils.isNotBlank(jzrqStr)) {
                if (jzrqStr.length() > 10) {
                    infoOne.setEndDate(jzrqStr.substring(0, 10));
                }
                else {
                    infoOne.setEndDate(jzrqStr);
                }
            }

            // 填报日期日期
            String tbrqStr = zzrkInfoMap.get("LZRQ");
            if (StringUtils.isNotBlank(tbrqStr)) {
                if (tbrqStr.length() > 10) {
                    infoOne.setFillDate(tbrqStr.substring(0, 10));
                }
                else {
                    infoOne.setFillDate(tbrqStr);
                }
            }

            infoOne.setTrAddress(zzrkInfoMap.get("ZZDZXZ"));
            infoOne.setTrCardCompany(zzrkInfoMap.get(""));
            infoOne.setTrCardIssuneOffice(zzrkInfoMap.get("FZJGJGMC"));
            infoOne.setTrNum(zzrkInfoMap.get("ZZZBH"));

            try {
                if (StringUtils.isNotBlank(zzrkInfoMap.get("YXQQSRQ"))) {
                    Date startDate = DateUtils.string2Date(zzrkInfoMap
                            .get("YXQQSRQ"), MessageResourceUtils
                            .getMessage("T_LDRK_ZJZZXX.date.format"));

                    infoOne.setStartDate4Compar(startDate);

                }
                else {
                    // 设置初始化日期，用于比较排序
                }

                if (StringUtils.isNotBlank(zzrkInfoMap.get("YXQXJZRQ"))) {
                    Date endDate = DateUtils.string2Date(zzrkInfoMap
                            .get("YXQXJZRQ"), MessageResourceUtils
                            .getMessage("T_LDRK_ZJZZXX.date.format"));
                    infoOne.setEndDate4Compar(endDate);

                }

            }
            catch (Exception e) {
                logger.error("将暂（居）住证信息起始日期/结束日期转换为Date时发生异常", e);
            }

            trInfoList.add(infoOne);
        }
        Collections.sort(trInfoList);

        // TODO 惜帅 根据确定的格式得到相差时间
        // 拿到已经排好序的列表，两两比较，计算时间间隔
        Date preStartDate4Compar = null;// 上一条记录的 起始日期
        Date preEndDate4Compar = null;// 上一条记录的 截止日期
        for (TRinfo oneTRInfo : trInfoList) {
            try {
                if (null == preStartDate4Compar || null == preEndDate4Compar
                        || null == oneTRInfo.getStartDate4Compar()
                        || null == oneTRInfo.getEndDate4Compar()) {
                    oneTRInfo
                            .setIntervalTime(MessageResourceUtils
                                    .getMessage("T_LDRK_ZJZZXX.date.defaultIntervalTime"));

                }
                else {
                    int s2s = DateUtils.compareDate(
                            oneTRInfo.getStartDate4Compar(),
                            preStartDate4Compar, 0);
                    int s2e = DateUtils.compareDate(
                            oneTRInfo.getStartDate4Compar(), preEndDate4Compar,
                            0);
                    if (s2e <= 1) {// 为啥是s2e <= 1而不是s2e <= 0呢？因为是算间隔
                        // 如果当前StartDate4Compar落在preStartDate4Compar与preEndDate4Compar之间
                        oneTRInfo.setIntervalTime("0天");
                    }
                    else {
                        // oneTRInfo.setIntervalTime(String.valueOf(s2e) + "天");
                        oneTRInfo
                                .setIntervalTime(String.valueOf(s2e - 1) + "天");
                    }

                }
            }
            catch (Exception e) {
                logger.error("将暂（居）住证信息起始日期/结束日期进行计算间隔时间时发生异常", e);
            }

            // 设置比较游标
            preStartDate4Compar = oneTRInfo.getStartDate4Compar();
            preEndDate4Compar = oneTRInfo.getEndDate4Compar();
        }

        return trInfoList;
    }

    /**
     * 保存身份证照片
     * 
     * @param imagePath
     * @param imageStr
     * @throws Exception
     */
    public void savePhoto(HttpServletRequest request, String pid,
            String imageStr) throws Exception {
        // 按约定保存二进制到固定目录
        String imagePath = request.getSession().getServletContext()
                .getRealPath("/")
                + System.getProperty("file.separator")
                + "personImages"
                + System.getProperty("file.separator")
                + pid
                + MessageResourceUtils.getMessage("idCard.image.format");
        // TransUtils.hexString2Image(imagePath, imageStr);
        logger.info("身份证照片路径：" + imagePath);
        TransUtils.base64String2Image(imagePath, imageStr.trim());
    }

    public void saveBlankPhoto(HttpServletRequest request, String pid) {
        try{
            // 空白照片存储的位置
            String blankImgPath = request.getSession().getServletContext()
                    .getRealPath("/")
                    + System.getProperty("file.separator") 
                    + "blank.jpg";
            
            String targetPath = request.getSession().getServletContext()
                    .getRealPath("/")
                    + System.getProperty("file.separator")
                    + "personImages"
                    + System.getProperty("file.separator")
                    + pid
                    + MessageResourceUtils.getMessage("idCard.image.format");
            
            com.ztesoft.framework.util.FileUtils fileUtils = new com.ztesoft.framework.util.FileUtils();
            
            fileUtils.copyFile(blankImgPath,targetPath);
        }catch (Exception e){
            logger.error("复制空白身份证头像时发生异常:" + e.getMessage(),e);
        }
        
    }
}
