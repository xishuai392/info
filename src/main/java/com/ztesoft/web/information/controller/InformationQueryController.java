package com.ztesoft.web.information.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.UuidUtils;
import com.ztesoft.web.information.db.po.TSqrxxPO;
import com.ztesoft.web.information.domain.req.query.QueryByOtherPeopleReqInfo;
import com.ztesoft.web.information.domain.req.query.QueryPeopleReqInfo;
import com.ztesoft.web.information.domain.resp.Address;
import com.ztesoft.web.information.domain.resp.FamilyInfo;
import com.ztesoft.web.information.domain.resp.MigrateInfo;
import com.ztesoft.web.information.domain.resp.PermanetPopulationInfo;
import com.ztesoft.web.information.domain.resp.PopulationBaseInfo;
import com.ztesoft.web.information.domain.resp.QueryRespInfo;
import com.ztesoft.web.information.domain.resp.QueryResultInfo;
import com.ztesoft.web.information.domain.resp.TRinfo;
import com.ztesoft.web.information.domain.resp.TRpopulationInfo;
import com.ztesoft.web.information.service.ITBcxrxxService;
import com.ztesoft.web.information.service.ITSqrxxService;
import com.ztesoft.web.information.service.ITSqrxxfjService;
import com.ztesoft.web.permission.controller.AuditMenuController;

/**
 * 人口信息查询总入口.分查询人控制模块及被查询控制模块
 * @author Ocean
 *
 */
@Controller
@RequestMapping(value="/information")
public class InformationQueryController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager.getLogger(InformationQueryController.class);
    
    @Autowired
    private ITBcxrxxService bcxrxxService;
    @Autowired
    private ITSqrxxService sqrxxService;
    @RequestMapping("index")
    public String index(Model model) {

        return "/information/jsp/infoQuery";
    }
    
    @RequestMapping("applicantQuery")
    @ResponseBody
    /**申请人请求查询界面
     * 记录查询日志，返回view
     * @param hello
     * @return
     */
    public QueryRespInfo applicantQuery(TSqrxxPO reqInfo) throws BaseAppException{
    	QueryRespInfo respInfo=new QueryRespInfo();
    	String uuid=UuidUtils.generatorUUID();
    	reqInfo.setId(uuid);
    	//记录查询日志，生成日志操作记录信息表
    	sqrxxService.add(reqInfo);
    	respInfo.setUuid(uuid);
    	return respInfo;
    }
    
    @RequestMapping("queryByOther")
    @ResponseBody
    public List<QueryResultInfo> queryByOtherPeople(QueryByOtherPeopleReqInfo reqInfo){
    	List<QueryResultInfo> queryResultInfoList=new ArrayList<QueryResultInfo>();
    	//暂时自己手工拼装
    	QueryResultInfo resultInfoOne=new QueryResultInfo();
    	resultInfoOne.setAddress("中国厦门");
    	resultInfoOne.setBirthDate("19911999");
    	resultInfoOne.setIdCardNum("1589399399393999");
    	resultInfoOne.setIsHavingTR("已办证");
    	resultInfoOne.setName("徐鑫");
    	resultInfoOne.setPopulationType("户籍人口");
    	QueryResultInfo resultInfoTwo=new QueryResultInfo();
    	resultInfoTwo.setAddress("中国厦门");
    	resultInfoTwo.setBirthDate("19911999");
    	resultInfoTwo.setIdCardNum("1589399399393999");
    	resultInfoTwo.setIsHavingTR("");
    	resultInfoTwo.setName("徐鑫");
    	resultInfoTwo.setPopulationType("暂住人口");
    	queryResultInfoList.add(resultInfoOne);
    	queryResultInfoList.add(resultInfoTwo);
    	return queryResultInfoList;  	
    }
  @RequestMapping("queryCZRKinfo")
  @ResponseBody
  public  PermanetPopulationInfo queryPermanetPopulationInfo(QueryByOtherPeopleReqInfo reqInfo){
  	PermanetPopulationInfo permanentPopulationInfo=new PermanetPopulationInfo();
  	List<FamilyInfo> familyInfoList=queryFamilyInfo(reqInfo);
  	PopulationBaseInfo baseInfo=queryBasePopulation(reqInfo);
  	MigrateInfo migrateInfo=queryMigrateInfo(reqInfo);
  	permanentPopulationInfo.setBaseInfo(baseInfo);
  	permanentPopulationInfo.setFamilyInfoList(familyInfoList);
  	permanentPopulationInfo.setMigrateInfo(migrateInfo);
  	return permanentPopulationInfo;
  }
  @RequestMapping("queryZZRKinfo")
  @ResponseBody
  public  TRpopulationInfo queryTRPopulationInfo(QueryByOtherPeopleReqInfo reqInfo){
  	TRpopulationInfo trPopulationInfo=new TRpopulationInfo();
  	trPopulationInfo.setBaseInfo(queryBasePopulation(reqInfo));
  	trPopulationInfo.setTrInfoList(queryTRInfoList(reqInfo));
  	return trPopulationInfo;
  }
    
    
    @RequestMapping("queryBasePopulation")
    @ResponseBody
    public PopulationBaseInfo queryBasePopulation(QueryByOtherPeopleReqInfo reqInfo){
    	//暂时手工组装信息
    	PopulationBaseInfo baseInfo=new PopulationBaseInfo();
    	baseInfo.setAliaName("smile");
    	baseInfo.setBirthDate("1991");
    	baseInfo.setBirthPlaceDetailAddress("益阳市沅江县");
    	baseInfo.setBirthPlaceNation("中国");
    	baseInfo.setBirthPlaceProvince("湖南省");
    	baseInfo.setHouseholdRegisterDetailAddress("沅江市");
    	baseInfo.setHouseholdRegisterProviceAddress("湖南省");
    	baseInfo.setIdCardExciptyTime("10");
    	baseInfo.setIdCardIssuneOffice("沅江市派出所");
    	baseInfo.setIdCardNum("1234342398732987398");
    	baseInfo.setLiveAddress("厦门双十");
    	baseInfo.setName("Mir.xu");
    	baseInfo.setNation("中国");
    	baseInfo.setNativePlace("厦门湖里区");
    	baseInfo.setNativePlaceDetailAddress("望海路108号");
    	baseInfo.setNativePlaceNation("中国");
    	baseInfo.setNativePlaceProvince("厦门");
    	baseInfo.setPhotoGif("a.jpg");
    	baseInfo.setPoliceStation("厦门思明派出所");
    	baseInfo.setSex("男");
    	return baseInfo;  	
    }
    
//    @RequestMapping("queryFamilyInfo")
//    @ResponseBody
    public List<FamilyInfo> queryFamilyInfo(QueryByOtherPeopleReqInfo reqInfo){
    	List<FamilyInfo> familyInfoList=new ArrayList<FamilyInfo>();
    	//暂时自己手工拼装
    	FamilyInfo familyInfoFather=new FamilyInfo();
    	familyInfoFather.setRelationType("父母");
    	familyInfoFather.setRelationShip("父亲");
    	familyInfoFather.setIdCardNum("238732874923738287");
    	familyInfoFather.setCertificateType("身份证");
    	familyInfoFather.setCertificateNum("238732874923738287");
    	familyInfoFather.setForeignFirstName("x");
    	familyInfoFather.setForeignLastName("x");
    	familyInfoFather.setName("felicity");
    	familyInfoFather.setTelephoneNum("13283084732423");
    	
    	FamilyInfo familyInfoMother=new FamilyInfo();
    	familyInfoMother.setRelationType("父母");
    	familyInfoMother.setRelationShip("母亲");
    	familyInfoMother.setIdCardNum("238732874923738287");
    	familyInfoMother.setCertificateType("身份证");
    	familyInfoMother.setCertificateNum("238732874923738287");
    	familyInfoMother.setForeignFirstName("x");
    	familyInfoMother.setForeignLastName("x");
    	familyInfoMother.setName("felicity");
    	familyInfoMother.setTelephoneNum("13283084732423");
    	
    	FamilyInfo familyInfoSpouse=new FamilyInfo();
    	familyInfoSpouse.setRelationType("配偶");
    	familyInfoSpouse.setIdCardNum("238732874923738287");
    	familyInfoSpouse.setRelationShip("妻子");
    	familyInfoSpouse.setCertificateType("身份证");
    	familyInfoSpouse.setCertificateNum("238732874923738287");
    	familyInfoSpouse.setForeignFirstName("x");
    	familyInfoSpouse.setForeignLastName("x");
    	familyInfoSpouse.setName("felicity");
    	familyInfoSpouse.setTelephoneNum("13283084732423");
    	
    	FamilyInfo familyInfoKeeper=new FamilyInfo();
    	familyInfoKeeper.setRelationType("监护人");
    	familyInfoKeeper.setRelationShip("someOne");
    	familyInfoKeeper.setIdCardNum("238732874923738287");
    	familyInfoKeeper.setCertificateType("身份证");
    	familyInfoKeeper.setCertificateNum("238732874923738287");
    	familyInfoKeeper.setForeignFirstName("x");
    	familyInfoKeeper.setForeignLastName("x");
    	familyInfoKeeper.setName("felicity");
    	familyInfoKeeper.setTelephoneNum("13283084732423");
    	
    	FamilyInfo familyInfoSon=new FamilyInfo();
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
    	familyInfoList.add(familyInfoSon);
    	
    	return familyInfoList;  	
    }
    
   
//    		"queryMigrateInfo")

    public MigrateInfo queryMigrateInfo(QueryByOtherPeopleReqInfo reqInfo){
    	MigrateInfo migrateInfo=new MigrateInfo();
    	migrateInfo.setTimeAndResultForMigrateLocal("smile forever,hhaha");
    	migrateInfo.setTimeAndResultForMigrateNative("xm");
    	migrateInfo.setTimeAndResultForMigrateOtherPlace(" 你猜");
    	return migrateInfo;  	
    }

    
    private List<TRinfo> queryTRInfoList(QueryByOtherPeopleReqInfo reqInfo){
    	List<TRinfo> trInfoList=new ArrayList<TRinfo>();
    	TRinfo infoOne=new TRinfo();
    	infoOne.setEndDate("20150903");
    	infoOne.setFillDate("1");
    	infoOne.setIntervalTime("10");
    	infoOne.setStartDate("20140101");
    	infoOne.setTrAddress("厦门市思明区软件园二期");
    	infoOne.setTrCardCompany("中兴");
    	infoOne.setTrCardIssuneOffice("思明区派出所");
    	infoOne.setTrNum("23424398778838");
    	trInfoList.add(infoOne);
    	TRinfo infoTwo=new TRinfo();
    	infoTwo.setEndDate("20150903");
    	infoTwo.setFillDate("1");
    	infoTwo.setIntervalTime("10");
    	infoTwo.setStartDate("20140101");
    	infoTwo.setTrAddress("厦门市思明区软件园二期");
    	infoTwo.setTrCardCompany("中兴");
    	infoTwo.setTrCardIssuneOffice("思明区派出所");
    	infoTwo.setTrNum("23424398778838");
    	trInfoList.add(infoTwo);
    	return trInfoList;
    }
    
}
