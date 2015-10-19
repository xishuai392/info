package com.ztesoft.web.information.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspConsts;
import com.dragonsoft.node.adapter.comm.RbspService;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.framework.util.UuidUtils;
import com.ztesoft.web.domain.IConstants;
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
import com.ztesoft.web.information.rbsp.RBSPResponseParser;
import com.ztesoft.web.information.rbsp.InfoRbspClient;
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

        System.out.println("MessageResourceUtils:"
                + MessageResourceUtils.getMessage("senderId"));

        return respInfo;
    }

    /**
     * 被查询人信息列表
     * 
     * @param reqInfo
     * @param request
     * @return
     */
    @RequestMapping("queryByOther")
    @ResponseBody
    public List<QueryResultInfo> queryByOtherPeople(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request) {

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
        // 查询身份证号码
        String pid = reqInfo.getIdCardNum();
        InfoRbspClient service = new InfoRbspClient();
        String resultCZRK = service.queryCZRKbaseInfo(auditUserPo, pid);
        List<Map<String, String>> czrkbaseInfoList = new RBSPResponseParser(
                resultCZRK).parserXML(czrkBaseInfoArr);
        List<QueryResultInfo> queryResultInfoList = new ArrayList<QueryResultInfo>();
        if (czrkbaseInfoList.size() != 0) {
            for (Map<String, String> rowMap : czrkbaseInfoList) {
                QueryResultInfo resultInfo = new QueryResultInfo();
                resultInfo.setIdCardNum(pid);
                resultInfo.setBirthDate(rowMap.get("DOB"));
                resultInfo.setAddress(rowMap.get("NATAL_XIANG"));
                resultInfo.setIsHavingTR("");
                resultInfo.setName(rowMap.get("NAME"));
                resultInfo.setPopulationType("户籍人口");
                queryResultInfoList.add(resultInfo);
            }
        }
        String resultZZRK = service.queryZZRKInfo(auditUserPo, pid);
        List<Map<String, String>> zzrkBaseInfoList = new RBSPResponseParser(
                resultZZRK).parserXML(zzrkInfoArr);
        if (zzrkBaseInfoList.size() != 0) {
            for (Map<String, String> rowMap : zzrkBaseInfoList) {
                QueryResultInfo resultInfo = new QueryResultInfo();
                resultInfo.setIdCardNum(pid);
                resultInfo.setBirthDate(rowMap.get("DOB"));
                resultInfo.setAddress(rowMap.get("ZZDZXZ"));
                resultInfo.setIsHavingTR("已办证");
                resultInfo.setName(rowMap.get("NAME"));
                resultInfo.setPopulationType("户籍人口");
                queryResultInfoList.add(resultInfo);
            }
        }

        /************************ Get drag data start ********************************/

        return queryResultInfoList;
    }

    @RequestMapping("queryCZRKinfo")
    @ResponseBody
    public PermanetPopulationInfo queryPermanetPopulationInfo(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);

        PermanetPopulationInfo permanentPopulationInfo = new PermanetPopulationInfo();
        InfoRbspClient service = new InfoRbspClient();
        String pid = reqInfo.getIdCardNum();
        // 查询常住人口信息
        String czrkInfoResult = service.queryCZRKbaseInfo(auditUserPo, pid);
        List<Map<String, String>> czrkInfoList = new RBSPResponseParser(
                czrkInfoResult).parserXML(czrkBaseInfoArr);
        Map<String, String> czrkInfoMap = czrkInfoList.get(0);

        String photoId = czrkInfoMap.get("PHOTO_ID");
        // 查询photo信息并保存在服务器固定目录
        String photoInfoResult = service.queryImageInfo(auditUserPo, photoId);
        List<Map<String, String>> photoInfoList = new RBSPResponseParser(
                photoInfoResult).parserXML(imageInfoArr);
        if (photoInfoList.size() > 0) {
            String image = photoInfoList.get(0).get("IMAGE");
            // 按约定保存二进制到固定目录
        }
        // 查询全量地址
        String allFullAddr = "";
        String huId = czrkInfoMap.get("HU_ID");
        String huInfoResult = service.queryCZRKCensusInfo(auditUserPo, huId);
        List<Map<String, String>> huInfoList = new RBSPResponseParser(
                huInfoResult).parserXML(czrkCensusInfoArr);
        if (huInfoList.size() > 0) {
            String metaAddrId = huInfoList.get(0).get("META_ADDR_ID");
            String dzInfoResult = service.queryDZinfo(auditUserPo, metaAddrId);
            List<Map<String, String>> dzInfoList = new RBSPResponseParser(
                    dzInfoResult).parserXML(dzInfoArr);
            if (dzInfoList.size() > 0) {
                allFullAddr = dzInfoList.get(0).get("ALL_FULL_ADDR");
            }
        }

        List<FamilyInfo> familyInfoList = queryFamilyInfo(czrkInfoMap);
        PopulationBaseInfo baseInfo = queryBasePopulation(czrkInfoMap,
                allFullAddr);
        MigrateInfo migrateInfo = queryMigrateInfo(czrkInfoMap);
        permanentPopulationInfo.setBaseInfo(baseInfo);
        permanentPopulationInfo.setFamilyInfoList(familyInfoList);
        permanentPopulationInfo.setMigrateInfo(migrateInfo);
        return permanentPopulationInfo;
    }

    @RequestMapping("queryZZRKinfo")
    @ResponseBody
    public TRpopulationInfo queryTRPopulationInfo(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        AuditUserPO auditUserPo = (AuditUserPO) session
                .getAttribute(IConstants.SESSIONUSER);

        TRpopulationInfo trPopulationInfo = new TRpopulationInfo();
        InfoRbspClient service = new InfoRbspClient();
        String pid = reqInfo.getIdCardNum();
        // 查流动人口信息
        String ldrkInfoResult = service.queryLDRKInfo(auditUserPo, pid);
        List<Map<String, String>> ldrkInfoList = new RBSPResponseParser(
                ldrkInfoResult).parserXML(ldrkInfoArr);
        Map<String, String> ldrkInfoMap = ldrkInfoList.get(0);

        String photoId = ldrkInfoMap.get("PHOTO_ID");
        // 查询photo信息并保存在服务器固定目录
        String photoInfoResult = service.queryImageInfo(auditUserPo, photoId);
        List<Map<String, String>> photoInfoList = new RBSPResponseParser(
                photoInfoResult).parserXML(imageInfoArr);
        if (photoInfoList.size() > 0) {
            String image = photoInfoList.get(0).get("IMAGE");
            // 按约定保存二进制到固定目录
        }
        // 查询暂住人口信息
        String zzrkInfoResult = service.queryLDRKInfo(auditUserPo, pid);
        List<Map<String, String>> zzrkInfoList = new RBSPResponseParser(
                zzrkInfoResult).parserXML(zzrkInfoArr);
        Map<String, String> zzrkInfoMap = zzrkInfoList.get(0);

        trPopulationInfo.setBaseInfo(queryZZRKBasePopulation(ldrkInfoMap,
                zzrkInfoMap));
        trPopulationInfo.setTrInfoList(queryTRInfoList(zzrkInfoList));
        return trPopulationInfo;
    }

    @RequestMapping("printInfo")
    @ResponseBody
    public void printQueryInfo(PrintReqInfo reqInfo) {

    }

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
        baseInfo.setPhotoGif("a.jpg");
        baseInfo.setSex(zzrkInfoMap.get("GENDER"));
        return baseInfo;

    }

    // @RequestMapping("queryBasePopulation")
    // @ResponseBody
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
        baseInfo.setPhotoGif("a.jpg");
        baseInfo.setPoliceStation(rowInfoMap.get("WHO_IN_UNIT_NAME"));
        baseInfo.setSex(rowInfoMap.get("GENDER"));
        return baseInfo;
    }

    // @RequestMapping("queryFamilyInfo")
    // @ResponseBody
    public List<FamilyInfo> queryFamilyInfo(Map<String, String> rowInfoMap) {
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
        familyInfoSpouse.setRelationShip("妻子");
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

        FamilyInfo familyInfoSon = new FamilyInfo();
        familyInfoSon.setRelationType("子女");
        familyInfoSon.setRelationShip("儿子");
        familyInfoSon.setIdCardNum("238732874923738287");
        familyInfoSon.setCertificateType("身份证");
        familyInfoSon.setCertificateNum("238732874923738287");
        familyInfoSon.setForeignFirstName("x");
        familyInfoSon.setForeignLastName("x");
        familyInfoSon.setName("felicity");
        familyInfoSon.setTelephoneNum("13283084732423");
        familyInfoList.add(familyInfoFather);
        familyInfoList.add(familyInfoMother);
        familyInfoList.add(familyInfoSpouse);
        familyInfoList.add(familyInfoKeeper);
        familyInfoList.add(familyInfoKeeperTwo);
        familyInfoList.add(familyInfoSon);
        return familyInfoList;
    }

    // "queryMigrateInfo")

    public MigrateInfo queryMigrateInfo(Map<String, String> rowInfoMap) {
        MigrateInfo migrateInfo = new MigrateInfo();
        migrateInfo.setTimeAndResultForMigrateLocal(rowInfoMap.get(""));
        migrateInfo.setTimeAndResultForMigrateNative(rowInfoMap.get(""));
        migrateInfo.setTimeAndResultForMigrateOtherPlace(rowInfoMap.get(""));

        // migrateInfo.setTimeAndResultForMigrateLocal("smile forever,hhaha");
        // migrateInfo.setTimeAndResultForMigrateNative("xm");
        // migrateInfo.setTimeAndResultForMigrateOtherPlace(" 你猜");
        return migrateInfo;
    }

    private List<TRinfo> queryTRInfoList(List<Map<String, String>> zzrkInfoList) {

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
            // 根据确定的格式得到相差时间
            infoOne.setIntervalTime(zzrkInfoMap.get(""));
            infoOne.setStartDate(zzrkInfoMap.get("YXQQSRQ"));
            infoOne.setTrAddress(zzrkInfoMap.get("ZZDZXZ"));
            infoOne.setTrCardCompany(zzrkInfoMap.get("FZJGJGMC"));
            infoOne.setTrCardIssuneOffice(zzrkInfoMap.get(""));
            infoOne.setTrNum(zzrkInfoMap.get("ZZZBH"));
            trInfoList.add(infoOne);
        }
        return trInfoList;
    }

}
