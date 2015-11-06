package com.ztesoft.web.information.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.framework.exception.BaseAppException;
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

    @RequestMapping("index")
    public String index(Model model) {

        return "/information/jsp/infoQuery";
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
        reqInfo.setCzdw(String.valueOf(auditUserPo.getOrgId()));
        reqInfo.setCzr(String.valueOf(auditUserPo.getUserId()));
        reqInfo.setCxrq(DateUtils.date2String(new Date(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        // 记录查询日志，生成日志操作记录信息表
        sqrxxService.add(reqInfo);
        respInfo.setUuid(uuid);

//        System.out.println("MessageResourceUtils:"
//                + MessageResourceUtils.getMessage("senderId"));
//        System.out.println("======================");
//        System.out.println(request.getSession().getServletContext()
//                .getRealPath("/"));
//        System.out.println("======================");

        return respInfo;
    }

    /**
     * 被查询人信息列表
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

        /******************************* make data start ********************************/
        // List<QueryResultInfo> queryResultInfoList=new ArrayList<QueryResultInfo>();
        //
        // //暂时自己手工拼装
        // QueryResultInfo resultInfoOne=new QueryResultInfo();
        // resultInfoOne.setBcxrxxId("219237837932");
        // resultInfoOne.setAddress("中国厦门");
        // resultInfoOne.setBirthDate("19911999");
        // resultInfoOne.setIdCardNum("1589399399393999");
        // resultInfoOne.setIsHavingTR("已办证");
        // resultInfoOne.setName("徐鑫");
        // resultInfoOne.setPopulationType("户籍人口");
        // QueryResultInfo resultInfoTwo=new QueryResultInfo();
        // resultInfoTwo.setBcxrxxId("2380973294387");
        // resultInfoTwo.setAddress("中国厦门");
        // resultInfoTwo.setBirthDate("19911999");
        // resultInfoTwo.setIdCardNum("1589399399393999");
        // resultInfoTwo.setIsHavingTR("");
        // resultInfoTwo.setName("徐鑫");
        // resultInfoTwo.setPopulationType("暂住人口");
        // queryResultInfoList.add(resultInfoOne);
        // queryResultInfoList.add(resultInfoTwo);
        /******************************* make data end ********************************/

        /************************ Get drag data start ********************************/
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);
        // 被查询身份证号码
        String pid = reqInfo.getIdCardNum();
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }
        
        // 被查询者姓名
        String bcxrxm = "";

        String resultCZRK = InfoRbspClient.queryCZRKbaseInfo(auditUserPo, pid,
                "PID");
        InfoResultVO czrkVO = InfoXmlParser.parserXML(resultCZRK);
        List<Map<String, String>> czrkbaseInfoList = InfoXmlParser
                .parserResultVO(czrkVO);
        List<QueryResultInfo> queryResultInfoList = new ArrayList<QueryResultInfo>();
        if (czrkbaseInfoList.size() != 0) {
            for (Map<String, String> rowMap : czrkbaseInfoList) {
                QueryResultInfo resultInfo = new QueryResultInfo();
                String uuid = UuidUtils.generatorUUID();

                resultInfo.setBcxrxxId(uuid);
                //resultInfo.setIdCardNum(pid);
                //从接口数据获取，保证完全正确
                resultInfo.setIdCardNum(rowMap.get("PID"));
                resultInfo.setBirthDate(rowMap.get("DOB"));// 出生日期
                resultInfo.setAddress(rowMap.get("NATAL_XIANG"));// 出生地详址
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
                            DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));// 被查询日期
                    bcxrxxPO.setRklx("1");// 人口类型（1：户籍人口，2：暂住人口）
                    bcxrxxPO.setCxcs(0);// 查询次数
                    // 记录日志
                    bcxrxxService.add(bcxrxxPO);
                }
                catch (Exception e) {
                    logger.error("插入被查询人信息时发生错误", e);
                }
            }
        }
        String resultZZRK = InfoRbspClient.queryZZRKInfo(auditUserPo, pid);
        InfoResultVO zzrkVO = InfoXmlParser.parserXML(resultZZRK);
        List<Map<String, String>> zzrkBaseInfoList = InfoXmlParser
                .parserResultVO(zzrkVO);
        if (zzrkBaseInfoList.size() != 0) {
            for (Map<String, String> rowMap : zzrkBaseInfoList) {
                QueryResultInfo resultInfo = new QueryResultInfo();
                String uuid = UuidUtils.generatorUUID();

                resultInfo.setBcxrxxId(uuid);
                //resultInfo.setIdCardNum(pid);
                //从接口数据获取，保证完全正确
                resultInfo.setIdCardNum(rowMap.get("PID"));
                resultInfo.setBirthDate(rowMap.get("DOB"));// 出生日期
                resultInfo.setAddress(rowMap.get("ZZDZXZ"));// 暂住地址
                resultInfo.setIsHavingTR("已办证");
                resultInfo.setName(rowMap.get("NAME"));// 姓名
                if (StringUtils.isNotBlank(rowMap.get("NAME")))
                    bcxrxm = rowMap.get("NAME");// 姓名
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
                            DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));// 被查询日期
                    bcxrxxPO.setRklx("2");// 人口类型（1：户籍人口，2：暂住人口）
                    bcxrxxPO.setCxcs(0);// 查询次数
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
        permanentPopulationInfo.setDyrq(DateUtils.date2String(new Date(), 
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITH_SPLIT));
        
        String pid = reqInfo.getIdCardNum();
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }
        
        // 查询常住人口信息
        String czrkInfoResult = InfoRbspClient.queryCZRKbaseInfo(auditUserPo,
                pid, "PID");
        InfoResultVO czrkVO = InfoXmlParser.parserXML(czrkInfoResult);
        List<Map<String, String>> czrkInfoList = InfoXmlParser
                .parserResultVO(czrkVO);

        Map<String, String> czrkInfoMap = czrkInfoList.get(0);

        // 获取它的照片编号
        String photoId = czrkInfoMap.get("PHOTO_ID");
        // 查询photo信息并保存在服务器固定目录
        String photoInfoResult = InfoRbspClient.queryImageInfo(auditUserPo,
                photoId);
        InfoResultVO photoVO = InfoXmlParser.parserXML(photoInfoResult);
        List<Map<String, String>> photoInfoList = InfoXmlParser
                .parserResultVO(photoVO);
        if (photoInfoList.size() > 0) {
            String imageStr = photoInfoList.get(0).get("IMAGE");
            // TODO 按约定保存二进制到固定目录
            String imagePath = request.getSession().getServletContext()
                    .getRealPath("/")
                    + System.getProperty("file.separator")
                    + "personImages"
                    + System.getProperty("file.separator")
                    + pid
                    + MessageResourceUtils.getMessage("idCard.image.format");

            try {
                savePhoto(imagePath, imageStr);
            }
            catch (Exception e) {
                logger.error("保存身份证照片时发生异常", e);
            }
        }

        // 查询全量地址
        String allFullAddr = "";
        String huId = czrkInfoMap.get("HU_ID");
        String huInfoResult = InfoRbspClient.queryCZRKCensusInfo(auditUserPo,
                huId);
        InfoResultVO huInfoVO = InfoXmlParser.parserXML(huInfoResult);
        List<Map<String, String>> huInfoList = InfoXmlParser
                .parserResultVO(huInfoVO);
        if (huInfoList.size() > 0) {
            String metaAddrId = huInfoList.get(0).get("META_ADDR_ID");
            String dzInfoResult = InfoRbspClient.queryDZinfo(auditUserPo,
                    metaAddrId);
            InfoResultVO dzInfoVO = InfoXmlParser.parserXML(dzInfoResult);
            List<Map<String, String>> dzInfoList = InfoXmlParser
                    .parserResultVO(dzInfoVO);
            if (dzInfoList.size() > 0) {
                allFullAddr = dzInfoList.get(0).get("ALL_FULL_ADDR");
            }
        }

        // 拼装家庭关系及联系人信息
        List<FamilyInfo> familyInfoList = queryFamilyInfo(auditUserPo, pid,
                czrkInfoMap);

        // 拼装基本信息
        PopulationBaseInfo baseInfo = queryBasePopulation(czrkInfoMap,
                allFullAddr);

        // 拼装迁移信息
        MigrateInfo migrateInfo = queryMigrateInfo(auditUserPo, pid,
                czrkInfoMap);

        permanentPopulationInfo.setBaseInfo(baseInfo);
        permanentPopulationInfo.setFamilyInfoList(familyInfoList);
        permanentPopulationInfo.setMigrateInfo(migrateInfo);

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

        return permanentPopulationInfo;
    }

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
        trPopulationInfo.setDyrq(DateUtils.date2String(new Date(), 
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITH_SPLIT));
        
        String pid = reqInfo.getIdCardNum();
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }
        
        // 查流动人口信息
        String ldrkInfoResult = InfoRbspClient.queryLDRKInfo(auditUserPo, pid);

        InfoResultVO ldrkInfoVO = InfoXmlParser.parserXML(ldrkInfoResult);
        List<Map<String, String>> ldrkInfoList = InfoXmlParser
                .parserResultVO(ldrkInfoVO);

        Map<String, String> ldrkInfoMap = ldrkInfoList.get(0);

        String photoId = ldrkInfoMap.get("PHOTO_ID");
        // 查询photo信息并保存在服务器固定目录
        String photoInfoResult = InfoRbspClient.queryImageInfo(auditUserPo,
                photoId);

        InfoResultVO photoInfoVO = InfoXmlParser.parserXML(photoInfoResult);
        List<Map<String, String>> photoInfoList = InfoXmlParser
                .parserResultVO(photoInfoVO);

        if (photoInfoList.size() > 0) {
            String imageStr = photoInfoList.get(0).get("IMAGE");
            // TODO 按约定保存二进制到固定目录
            String imagePath = request.getSession().getServletContext()
                    .getRealPath("/")
                    + System.getProperty("file.separator")
                    + "personImages"
                    + System.getProperty("file.separator")
                    + pid
                    + MessageResourceUtils.getMessage("idCard.image.format");

            try {
                savePhoto(imagePath, imageStr);
            }
            catch (Exception e) {
                logger.error("保存身份证照片时发生异常", e);
            }

        }
        // 查询暂住人口信息
        String zzrkInfoResult = InfoRbspClient.queryZZRKInfo(auditUserPo, pid);

        InfoResultVO zzrkInfoVO = InfoXmlParser.parserXML(zzrkInfoResult);
        List<Map<String, String>> zzrkInfoList = InfoXmlParser
                .parserResultVO(zzrkInfoVO);

        Map<String, String> zzrkInfoMap = zzrkInfoList.get(0);

        // 拼装ZK基本信息
        trPopulationInfo.setBaseInfo(queryZZRKBasePopulation(ldrkInfoMap,
                zzrkInfoMap));
        // 拼装ZK暂住信息
        trPopulationInfo.setTrInfoList(queryTRInfoList(zzrkInfoList));

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

        return trPopulationInfo;
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
    public PopulationBaseInfo queryBasePopulation(
            Map<String, String> rowInfoMap, String allFullAddr) {
        PopulationBaseInfo baseInfo = new PopulationBaseInfo();
        // 暂时手工组装信息
        /***************************** start to make data *************************************/

        // baseInfo.setAliaName("smile");
        // baseInfo.setBirthDate("1991");
        // baseInfo.setBirthPlaceDetailAddress("益阳市沅江县");
        // baseInfo.setBirthPlaceNation("中国");
        // baseInfo.setBirthPlaceProvince("湖南省");
        // baseInfo.setHouseholdRegisterDetailAddress("沅江市");
        // baseInfo.setHouseholdRegisterProviceAddress("湖南省");
        // baseInfo.setIdCardExciptyTime("10");
        // baseInfo.setIdCardIssuneOffice("沅江市派出所");
        // baseInfo.setIdCardNum("1234342398732987398");
        // baseInfo.setLiveAddress("厦门双十");
        // baseInfo.setName("Mir.xu");
        // baseInfo.setNation("中国");
        // baseInfo.setNativePlace("厦门湖里区");
        // baseInfo.setNativePlaceDetailAddress("望海路108号");
        // baseInfo.setNativePlaceNation("中国");
        // baseInfo.setNativePlaceProvince("厦门");
        // baseInfo.setPhotoGif("a.jpg");
        // baseInfo.setPoliceStation("厦门思明派出所");
        // baseInfo.setSex("男");
        /***************************** end to make data *************************************/

        baseInfo.setAliaName(rowInfoMap.get("USED_NAME"));
        baseInfo.setBirthDate(rowInfoMap.get("DOB"));
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
        baseInfo.setNation(rowInfoMap.get("NATION"));
        baseInfo.setNativePlace("");
        baseInfo.setNativePlaceDetailAddress(rowInfoMap.get("NATIVE_XIANG"));
        baseInfo.setNativePlaceNation(rowInfoMap.get("NATIVE_COUNTRY"));
        baseInfo.setNativePlaceProvince(rowInfoMap.get("NATIVE_PLACE"));
        // TODO 身份证照片地址
        baseInfo.setPhotoGif(rowInfoMap.get("PID") + ".jpg");
        baseInfo.setPoliceStation(rowInfoMap.get("WHO_IN_UNIT_NAME"));
        baseInfo.setSex(TransUtils.transSex(rowInfoMap.get("GENDER")));
        return baseInfo;
    }

    /**
     * 拼装CK 家庭关系及联系人信息
     * 
     * @param auditUserPO
     * @param rowInfoMap
     * @return
     * @throws BaseAppException
     */
    public List<FamilyInfo> queryFamilyInfo(AuditUserPO auditUserPO,
            String pid, Map<String, String> rowInfoMap) throws BaseAppException {
        List<FamilyInfo> familyInfoList = new ArrayList<FamilyInfo>();
        /************************************ make data start **********************************/

        // 暂时自己手工拼装
        // FamilyInfo familyInfoFather=new FamilyInfo();
        // familyInfoFather.setRelationType("父母");
        // familyInfoFather.setRelationShip("父亲");
        // familyInfoFather.setIdCardNum("238732874923738287");
        // familyInfoFather.setCertificateType("身份证");
        // familyInfoFather.setCertificateNum("238732874923738287");
        // familyInfoFather.setForeignFirstName("x");
        // familyInfoFather.setForeignLastName("x");
        // familyInfoFather.setName("felicity");
        // familyInfoFather.setTelephoneNum("13283084732423");
        //
        // FamilyInfo familyInfoMother=new FamilyInfo();
        // familyInfoMother.setRelationType("父母");
        // familyInfoMother.setRelationShip("母亲");
        // familyInfoMother.setIdCardNum("238732874923738287");
        // familyInfoMother.setCertificateType("身份证");
        // familyInfoMother.setCertificateNum("238732874923738287");
        // familyInfoMother.setForeignFirstName("x");
        // familyInfoMother.setForeignLastName("x");
        // familyInfoMother.setName("felicity");
        // familyInfoMother.setTelephoneNum("13283084732423");
        //
        // FamilyInfo familyInfoSpouse=new FamilyInfo();
        // familyInfoSpouse.setRelationType("配偶");
        // familyInfoSpouse.setIdCardNum("238732874923738287");
        // familyInfoSpouse.setRelationShip("妻子");
        // familyInfoSpouse.setCertificateType("身份证");
        // familyInfoSpouse.setCertificateNum("238732874923738287");
        // familyInfoSpouse.setForeignFirstName("x");
        // familyInfoSpouse.setForeignLastName("x");
        // familyInfoSpouse.setName("felicity");
        // familyInfoSpouse.setTelephoneNum("13283084732423");
        //
        // FamilyInfo familyInfoKeeper=new FamilyInfo();
        // familyInfoKeeper.setRelationType("监护人");
        // familyInfoKeeper.setRelationShip("someOne");
        // familyInfoKeeper.setIdCardNum("238732874923738287");
        // familyInfoKeeper.setCertificateType("身份证");
        // familyInfoKeeper.setCertificateNum("238732874923738287");
        // familyInfoKeeper.setForeignFirstName("x");
        // familyInfoKeeper.setForeignLastName("x");
        // familyInfoKeeper.setName("felicity");
        // familyInfoKeeper.setTelephoneNum("13283084732423");
        //
        // FamilyInfo familyInfoSon=new FamilyInfo();
        // familyInfoSon.setRelationType("子女");
        // familyInfoSon.setRelationShip("儿子");
        // familyInfoSon.setIdCardNum("238732874923738287");
        // familyInfoSon.setCertificateType("身份证");
        // familyInfoSon.setCertificateNum("238732874923738287");
        // familyInfoSon.setForeignFirstName("x");
        // familyInfoSon.setForeignLastName("x");
        // familyInfoSon.setName("felicity");
        // familyInfoSon.setTelephoneNum("13283084732423");
        // familyInfoList.add(familyInfoFather);
        // familyInfoList.add(familyInfoMother);
        // familyInfoList.add(familyInfoSpouse);
        // familyInfoList.add(familyInfoKeeper);
        // familyInfoList.add(familyInfoSon);
        /************************************ make data end **********************************/
        // 暂时自己手工拼装
        FamilyInfo familyInfoFather = new FamilyInfo();
        familyInfoFather.setRelationType("父母");
        familyInfoFather.setRelationShip("父亲");
        familyInfoFather.setIdCardNum(rowInfoMap.get("FA_PID"));
        familyInfoFather.setCertificateType(rowInfoMap.get("FA_CARD_TYPE"));
        familyInfoFather.setCertificateNum(rowInfoMap.get("FA_CARD_NO"));
        familyInfoFather.setForeignFirstName(rowInfoMap.get("FA_WWX"));
        familyInfoFather.setForeignLastName(rowInfoMap.get("FA_WWM"));
        familyInfoFather.setName(rowInfoMap.get("FA_NAME"));
        familyInfoFather.setTelephoneNum("");

        FamilyInfo familyInfoMother = new FamilyInfo();
        familyInfoMother.setRelationType("父母");
        familyInfoMother.setRelationShip("母亲");
        familyInfoMother.setIdCardNum(rowInfoMap.get("MA_PID"));
        familyInfoMother.setCertificateType(rowInfoMap.get("MA_CARD_TYPE"));
        familyInfoMother.setCertificateNum(rowInfoMap.get("MA_CARD_NO"));
        familyInfoMother.setForeignFirstName(rowInfoMap.get("MA_WWX"));
        familyInfoMother.setForeignLastName(rowInfoMap.get("MA_WWM"));
        familyInfoMother.setName(rowInfoMap.get("MA_NAME"));
        familyInfoMother.setTelephoneNum("");

        FamilyInfo familyInfoSpouse = new FamilyInfo();
        familyInfoSpouse.setRelationType("配偶");
        familyInfoSpouse.setIdCardNum(rowInfoMap.get("PO_PID"));
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

        FamilyInfo familyInfoKeeper = new FamilyInfo();
        familyInfoKeeper.setRelationType("监护人");
        familyInfoKeeper.setRelationShip("监护人1");
        familyInfoKeeper.setIdCardNum(rowInfoMap.get("GURARDIAN_1_PID"));
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

        familyInfoList.add(familyInfoFather);
        familyInfoList.add(familyInfoMother);

        // 需要判断是否有配偶
        if (!StringUtils.isBlank(familyInfoSpouse.getName())) {
            familyInfoList.add(familyInfoSpouse);
        }

        // 需要判断是否有监护人
        if (!StringUtils.isBlank(familyInfoKeeper.getName())) {
            familyInfoList.add(familyInfoKeeper);
        }
        if (!StringUtils.isBlank(familyInfoKeeperTwo.getName())) {
            familyInfoList.add(familyInfoKeeperTwo);
        }

        // 查找该人的所有子女
        String whereFiled = "";
        if ("男".equals(TransUtils.transSex(rowInfoMap.get("GENDER")))) {
            whereFiled = "FA_PID";
        }
        if ("女".equals(TransUtils.transSex(rowInfoMap.get("GENDER")))) {
            whereFiled = "MA_PID";
        }
        String czrkInfoResult = InfoRbspClient.queryCZRKbaseInfo(auditUserPO,
                pid, whereFiled);
        InfoResultVO czrkVO = InfoXmlParser.parserXML(czrkInfoResult);
        List<Map<String, String>> czrkInfoList = InfoXmlParser
                .parserResultVO(czrkVO);

        if (null != czrkInfoList && czrkInfoList.size() > 0) {
            for (Map<String, String> oneChildMap : czrkInfoList) {
                FamilyInfo familyInfoChild = new FamilyInfo();
                familyInfoChild.setRelationType("子女");
                if ("男".equals(TransUtils.transSex(oneChildMap.get("GENDER")))) {
                    familyInfoSpouse.setRelationShip("儿子");
                }
                if ("女".equals(TransUtils.transSex(oneChildMap.get("GENDER")))) {
                    familyInfoSpouse.setRelationShip("女儿");
                }
                // TODO 子女信息
                familyInfoChild.setIdCardNum(oneChildMap.get("PID"));
                familyInfoChild.setCertificateType("身份证");
                familyInfoChild.setCertificateNum(oneChildMap.get("PID"));
                familyInfoChild.setForeignFirstName("");
                familyInfoChild.setForeignLastName("");
                familyInfoChild.setName(oneChildMap.get("NAME"));
                familyInfoChild.setTelephoneNum("");
                familyInfoList.add(familyInfoChild);
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
    public MigrateInfo queryMigrateInfo(AuditUserPO auditUserPO, String pid,
            Map<String, String> rowInfoMap) {
        MigrateInfo migrateInfo = new MigrateInfo();
        migrateInfo.setTimeAndResultForMigrateLocal(rowInfoMap.get(""));
        migrateInfo.setTimeAndResultForMigrateNative(rowInfoMap.get(""));
        migrateInfo.setTimeAndResultForMigrateOtherPlace(rowInfoMap.get(""));

        // migrateInfo.setTimeAndResultForMigrateLocal("smile forever,hhaha");
        // migrateInfo.setTimeAndResultForMigrateNative("xm");
        // migrateInfo.setTimeAndResultForMigrateOtherPlace(" 你猜");
        return migrateInfo;
    }

    /**
     * 拼装ZK基本信息
     * 
     * @param ldrkInfoMap
     * @param zzrkInfoMap
     * @return
     */
    public PopulationBaseInfo queryZZRKBasePopulation(
            Map<String, String> ldrkInfoMap, Map<String, String> zzrkInfoMap) {
        PopulationBaseInfo baseInfo = new PopulationBaseInfo();
        baseInfo.setName(zzrkInfoMap.get("NAME"));
        baseInfo.setAliaName(ldrkInfoMap.get("USED_NAME"));
        baseInfo.setIdCardNum(ldrkInfoMap.get("PID"));
        baseInfo.setBirthDate(zzrkInfoMap.get("DOB"));
        baseInfo.setHouseholdRegisterDetailAddress(ldrkInfoMap
                .get("HJD_FULL_ADDR"));
        baseInfo.setHouseholdRegisterProviceAddress(ldrkInfoMap.get("HJD_QU"));
        baseInfo.setNativePlace(ldrkInfoMap.get("NATIVE_PLACE"));
        // TODO 身份证照片地址
        baseInfo.setPhotoGif(ldrkInfoMap.get("PID") + ".jpg");
        baseInfo.setNation(zzrkInfoMap.get("NATION"));
        baseInfo.setSex(TransUtils.transSex(zzrkInfoMap.get("GENDER")));
        return baseInfo;
    }

    /**
     * 拼装ZK暂住信息
     * 
     * @param zzrkInfoList
     * @return
     */
    public List<TRinfo> queryTRInfoList(List<Map<String, String>> zzrkInfoList) {

        List<TRinfo> trInfoList = new ArrayList<TRinfo>();

        /********************************** make data start *********************************/
        // TRinfo infoOne=new TRinfo();
        // infoOne.setEndDate("20150903");
        // infoOne.setFillDate("1");
        // infoOne.setIntervalTime("10");
        // infoOne.setStartDate("20140101");
        // infoOne.setTrAddress("厦门市思明区软件园二期");
        // infoOne.setTrCardCompany("中兴");
        // infoOne.setTrCardIssuneOffice("思明区派出所");
        // infoOne.setTrNum("23424398778838");
        // trInfoList.add(infoOne);
        // TRinfo infoTwo=new TRinfo();
        // infoTwo.setEndDate("20150903");
        // infoTwo.setFillDate("1");
        // infoTwo.setIntervalTime("10");
        // infoTwo.setStartDate("20140101");
        // infoTwo.setTrAddress("厦门市思明区软件园二期");
        // infoTwo.setTrCardCompany("中兴");
        // infoTwo.setTrCardIssuneOffice("思明区派出所");
        // infoTwo.setTrNum("23424398778838");
        // trInfoList.add(infoTwo);

        /********************************** make data end *********************************/
        for (Map<String, String> zzrkInfoMap : zzrkInfoList) {
            TRinfo infoOne = new TRinfo();
            infoOne.setEndDate(zzrkInfoMap.get("YXQXJZRQ"));
            infoOne.setFillDate(zzrkInfoMap.get("LZRQ"));

            infoOne.setStartDate(zzrkInfoMap.get("YXQQSRQ"));
            infoOne.setTrAddress(zzrkInfoMap.get("ZZDZXZ"));
            infoOne.setTrCardCompany(zzrkInfoMap.get(""));
            infoOne.setTrCardIssuneOffice(zzrkInfoMap.get("FZJGJGMC"));
            infoOne.setTrNum(zzrkInfoMap.get("ZZZBH"));
            // TODO 根据确定的格式得到相差时间
            try {
                Date startDate = DateUtils.string2Date(zzrkInfoMap
                        .get("YXQQSRQ"), MessageResourceUtils
                        .getMessage("T_LDRK_ZJZZXX.date.format"));
                Date endDate = DateUtils.string2Date(zzrkInfoMap
                        .get("YXQXJZRQ"), MessageResourceUtils
                        .getMessage("T_LDRK_ZJZZXX.date.format"));
                // ArrayList<Date> list = DateUtils.getIntervalDay(startDate, endDate);
                infoOne.setIntervalTime(String.valueOf(DateUtils.compareDate(
                        endDate, startDate, 0)));
            }
            catch (Exception e) {
                logger.error(e);
            }

            trInfoList.add(infoOne);
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
    public void savePhoto(String imagePath, String imageStr) throws Exception {
        // TransUtils.hexString2Image(imagePath, imageStr);
        logger.info("身份证照片路径：" + imagePath);
        TransUtils.base64String2Image(imagePath, imageStr.trim());
    }

}
