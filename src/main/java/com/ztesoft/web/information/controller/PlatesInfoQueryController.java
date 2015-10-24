/**
 * 
 */
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
import com.ztesoft.web.information.domain.req.query.QueryByOtherPeopleReqInfo;
import com.ztesoft.web.information.domain.req.query.QueryByPlatesReqInfo;
import com.ztesoft.web.information.domain.resp.FamilyInfo;
import com.ztesoft.web.information.domain.resp.MigrateInfo;
import com.ztesoft.web.information.domain.resp.PermanetPopulationInfo;
import com.ztesoft.web.information.domain.resp.PopulationBaseInfo;
import com.ztesoft.web.information.domain.resp.QueryResultInfo;
import com.ztesoft.web.information.domain.resp.TRpopulationInfo;
import com.ztesoft.web.information.rbsp.InfoRbspClient;
import com.ztesoft.web.information.rbsp.InfoResultVO;
import com.ztesoft.web.information.rbsp.InfoXmlParser;
import com.ztesoft.web.information.rbsp.TransUtils;
import com.ztesoft.web.information.service.ITBcxrxxService;
import com.ztesoft.web.information.service.ITSqrxxService;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/** 
 * <Description>人口信息查询，平板查询 <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月23日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.controller <br>
 */
@Controller
@RequestMapping(value = "/plates")
public class PlatesInfoQueryController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(PlatesInfoQueryController.class);
    
    @Autowired
    private ITBcxrxxService bcxrxxService;

    @Autowired
    private ITSqrxxService sqrxxService;
    
    InformationQueryController informationQueryController = new InformationQueryController();

    @RequestMapping("index")
    public String index(Model model) {

        return "/information/jsp/platesInfoQuery";
    }
    
    private AuditUserPO defaultUser(){
        AuditUserPO auditUserPo =  new AuditUserPO();
        // 设置用户身份编号
        auditUserPo.setUserCardId(MessageResourceUtils.getMessage("Plates.UserCardId"));
        // 设置用户单位
        auditUserPo.setOrgId(Long.parseLong(MessageResourceUtils.getMessage("Plates.UserDeptId")));
        // 设置用户名
        auditUserPo.setUserName(MessageResourceUtils.getMessage("Plates.UserName"));
        // 设置PKI编号
        auditUserPo.setUserPkiId(MessageResourceUtils.getMessage("Plates.PkiId"));
        
        return auditUserPo;
    }
    
    /**
     * 终端查询 
     * 
     * @param reqInfo
     * @param request
     * @return
     * @throws BaseAppException 
     */
    @RequestMapping("queryByPlates")
    @ResponseBody
    public QueryByOtherPeopleReqInfo queryByPlates(
            QueryByPlatesReqInfo reqInfo, HttpServletRequest request) throws BaseAppException {
        QueryByOtherPeopleReqInfo bcxrInfo = new QueryByOtherPeopleReqInfo();
        bcxrInfo.setPopulationType(reqInfo.getPopulationType());
        bcxrInfo.setIdCardNum(reqInfo.getCardNo());
        
        logger.debug(reqInfo.toString());
        
        AuditUserPO auditUserPo =  defaultUser();
        //查询身份证号码
        String pid = reqInfo.getCardNo();
        //查询者姓名
        String bcxrxm = "";
        
        try{
            //TODO 记录 申请人日志
            String sqrxxId = UuidUtils.generatorUUID();
            bcxrInfo.setSqrxxId(sqrxxId);
            
            TSqrxxPO sqrxxRecord = new TSqrxxPO();
            sqrxxRecord.setId(sqrxxId);
            sqrxxRecord.setZjh(reqInfo.getCardNo());
            sqrxxRecord.setZjlx("10");
            sqrxxRecord.setXm(reqInfo.getName());
            sqrxxRecord.setCxsqrlx("50");//查询申请人类型（10：律师，20：党政军机关，30：司法机关，40：企事业单位，50：个人，60：人民团体，70：其他）
            sqrxxRecord.setCxbs("10");//10：终端，20：pc端
            
            sqrxxRecord.setCzdw(MessageResourceUtils.getMessage("Plates.UserDeptId"));
            sqrxxRecord.setCzr(MessageResourceUtils.getMessage("Plates.UserCode"));
            sqrxxRecord.setCxrq(DateUtils.date2String(new Date(),
                    DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
            
            // 记录查询日志，申请人信息表
            sqrxxService.add(sqrxxRecord);
            
            
            
            //TODO 记录被查询人日志
            String bcxrxxId = UuidUtils.generatorUUID();
            bcxrInfo.setBcxrxxId(bcxrxxId);
            TBcxrxxPO bcxrxxRecord = new TBcxrxxPO();
            bcxrxxRecord.setId(bcxrxxId);
            bcxrxxRecord.setSqrId(sqrxxId);
            bcxrxxRecord.setZjh(reqInfo.getCardNo());
            bcxrxxRecord.setZjlx("10");
            bcxrxxRecord.setXm(reqInfo.getName());
            bcxrxxRecord.setSfzf("0");// 是否作废（1：是，0：否）默认为“否”
            bcxrxxRecord.setSfdy("0");// 是否打印（1：是，0：否）默认为“否”
            bcxrxxRecord.setBcxrq(DateUtils.date2String(new Date(),
                    DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));// 被查询日期
            bcxrxxRecord.setRklx(reqInfo.getPopulationType());// 人口类型（1：户籍人口，2：暂住人口）
            bcxrxxRecord.setCxcs(1);// 查询次数
            
            
            // 记录日志,被查询人信息表
            bcxrxxService.add(bcxrxxRecord);
        }catch (Exception e){
            logger.error("终端查询，记录申请人信息、被查询人信息时发生错误", e);
        }
        
        return bcxrInfo;
    }
    
    

    @RequestMapping("queryCZRKinfo")
    @ResponseBody
    public PermanetPopulationInfo queryPermanetPopulationInfo(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request) throws BaseAppException {
        AuditUserPO auditUserPo = defaultUser();

        PermanetPopulationInfo permanentPopulationInfo = new PermanetPopulationInfo();
        String pid = reqInfo.getIdCardNum();
        // 查询常住人口信息
        String czrkInfoResult = InfoRbspClient.queryCZRKbaseInfo(auditUserPo,pid,"PID");
        InfoResultVO czrkVO = InfoXmlParser.parserXML(czrkInfoResult);
        List<Map<String, String>> czrkInfoList = InfoXmlParser.parserResultVO(czrkVO);
        
        
        Map<String, String> czrkInfoMap = czrkInfoList.get(0);

        //获取它的照片编号
        String photoId = czrkInfoMap.get("PHOTO_ID");
        // 查询photo信息并保存在服务器固定目录
        String photoInfoResult = InfoRbspClient.queryImageInfo(auditUserPo, photoId);
        InfoResultVO photoVO = InfoXmlParser.parserXML(photoInfoResult);
        List<Map<String, String>> photoInfoList = InfoXmlParser.parserResultVO(photoVO);
        if (photoInfoList.size() > 0) {
            String imageStr = photoInfoList.get(0).get("IMAGE");
            //TODO 按约定保存二进制到固定目录
            String imagePath = request.getSession().getServletContext().getRealPath("/") 
                    + System.getProperty("file.separator") + "personImages"
                    + System.getProperty("file.separator") + pid 
                    + MessageResourceUtils.getMessage("idCard.image.format");
            
            try {
                informationQueryController.savePhoto(imagePath, imageStr);
            }
            catch (Exception e) {
                logger.error("保存身份证照片时发生异常", e);
            }
        }
        
        // 查询全量地址
        String allFullAddr = "";
        String huId = czrkInfoMap.get("HU_ID");
        String huInfoResult = InfoRbspClient.queryCZRKCensusInfo(auditUserPo, huId);
        InfoResultVO huInfoVO = InfoXmlParser.parserXML(huInfoResult);
        List<Map<String, String>> huInfoList = InfoXmlParser.parserResultVO(huInfoVO);
        if (huInfoList.size() > 0) {
            String metaAddrId = huInfoList.get(0).get("META_ADDR_ID");
            String dzInfoResult = InfoRbspClient.queryDZinfo(auditUserPo, metaAddrId);
            InfoResultVO dzInfoVO = InfoXmlParser.parserXML(dzInfoResult);
            List<Map<String, String>> dzInfoList = InfoXmlParser.parserResultVO(dzInfoVO);
            if (dzInfoList.size() > 0) {
                allFullAddr = dzInfoList.get(0).get("ALL_FULL_ADDR");
            }
        }
        
        //拼装家庭关系及联系人信息
        List<FamilyInfo> familyInfoList = informationQueryController.queryFamilyInfo(auditUserPo,pid,czrkInfoMap);
        
        //拼装基本信息
        PopulationBaseInfo baseInfo = informationQueryController.queryBasePopulation(czrkInfoMap,
                allFullAddr);
        
        //拼装迁移信息
        MigrateInfo migrateInfo = informationQueryController.queryMigrateInfo(auditUserPo,pid,czrkInfoMap);
        
        permanentPopulationInfo.setBaseInfo(baseInfo);
        permanentPopulationInfo.setFamilyInfoList(familyInfoList);
        permanentPopulationInfo.setMigrateInfo(migrateInfo);
        
        
        
        try {
            //更新日志
            //被查询人信息
            TBcxrxxPO bcxrxxPO = bcxrxxService.selectByPrimaryKey(reqInfo.getBcxrxxId());
            TBcxrxxPO nbcxrxxPO = new TBcxrxxPO();
            //更新查询次数
            nbcxrxxPO.setId(bcxrxxPO.getId());
            nbcxrxxPO.setCxcs(bcxrxxPO.getCxcs()+1);
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
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request) throws BaseAppException {
        AuditUserPO auditUserPo = defaultUser();

        TRpopulationInfo trPopulationInfo = new TRpopulationInfo();
        String pid = reqInfo.getIdCardNum();
        // 查流动人口信息
        String ldrkInfoResult = InfoRbspClient.queryLDRKInfo(auditUserPo, pid);
        
        InfoResultVO ldrkInfoVO = InfoXmlParser.parserXML(ldrkInfoResult);
        List<Map<String, String>> ldrkInfoList = InfoXmlParser.parserResultVO(ldrkInfoVO);
        
        Map<String, String> ldrkInfoMap = ldrkInfoList.get(0);

        String photoId = ldrkInfoMap.get("PHOTO_ID");
        // 查询photo信息并保存在服务器固定目录
        String photoInfoResult = InfoRbspClient.queryImageInfo(auditUserPo, photoId);
        
        InfoResultVO photoInfoVO = InfoXmlParser.parserXML(photoInfoResult);
        List<Map<String, String>> photoInfoList = InfoXmlParser.parserResultVO(photoInfoVO);
        
        if (photoInfoList.size() > 0) {
            String imageStr = photoInfoList.get(0).get("IMAGE");
            //TODO 按约定保存二进制到固定目录
            String imagePath = request.getSession().getServletContext().getRealPath("/") 
                    + System.getProperty("file.separator") + "personImages"
                    + System.getProperty("file.separator") + pid 
                    + MessageResourceUtils.getMessage("idCard.image.format");
            
            try {
                informationQueryController.savePhoto(imagePath, imageStr);
            }
            catch (Exception e) {
                logger.error("保存身份证照片时发生异常", e);
            }
            
        }
        // 查询暂住人口信息
        String zzrkInfoResult = InfoRbspClient.queryZZRKInfo(auditUserPo, pid);
        
        InfoResultVO zzrkInfoVO = InfoXmlParser.parserXML(zzrkInfoResult);
        List<Map<String, String>> zzrkInfoList = InfoXmlParser.parserResultVO(zzrkInfoVO);
        
        Map<String, String> zzrkInfoMap = zzrkInfoList.get(0);

        //拼装ZK基本信息
        trPopulationInfo.setBaseInfo(informationQueryController.queryZZRKBasePopulation(ldrkInfoMap,
                zzrkInfoMap));
        //拼装ZK暂住信息
        trPopulationInfo.setTrInfoList(informationQueryController.queryTRInfoList(zzrkInfoList));
        
        try {
            //更新日志
            //被查询人信息
            TBcxrxxPO bcxrxxPO = bcxrxxService.selectByPrimaryKey(reqInfo.getBcxrxxId());
            TBcxrxxPO nbcxrxxPO = new TBcxrxxPO();
            //更新查询次数
            nbcxrxxPO.setId(bcxrxxPO.getId());
            nbcxrxxPO.setCxcs(bcxrxxPO.getCxcs()+1);
            bcxrxxService.update(nbcxrxxPO);
        }
        catch (Exception e) {
            logger.error("更新被查询人信息（查询次数）时发生错误", e);
        }
        
        return trPopulationInfo;
    }
    
}
