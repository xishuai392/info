package com.ztesoft.web.information.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.UuidUtils;
import com.ztesoft.web.information.domain.req.query.QueryByOtherPeopleReqInfo;
import com.ztesoft.web.information.domain.req.query.QueryPeopleReqInfo;
import com.ztesoft.web.information.domain.resp.Address;
import com.ztesoft.web.information.domain.resp.FamilyInfo;
import com.ztesoft.web.information.domain.resp.MigrateInfo;
import com.ztesoft.web.information.domain.resp.PopulationBaseInfo;
import com.ztesoft.web.information.domain.resp.QueryResultInfo;
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
    public String applicantQuery(QueryPeopleReqInfo reqInfo){
    	String uuid=UuidUtils.generatorUUID();
    	//记录查询日志，生成日志操作记录信息表
    	return uuid;
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
    	resultInfoOne.setPopulationType("暂住人口");
    	QueryResultInfo resultInfoTwo=new QueryResultInfo();
    	resultInfoTwo.setAddress("中国厦门");
    	resultInfoTwo.setBirthDate("19911999");
    	resultInfoTwo.setIdCardNum("1589399399393999");
    	resultInfoTwo.setIsHavingTR("");
    	resultInfoTwo.setName("徐鑫");
    	resultInfoTwo.setPopulationType("常住人口");
    	queryResultInfoList.add(resultInfoOne);
    	queryResultInfoList.add(resultInfoTwo);
    	return queryResultInfoList;  	
    }
    
    
    
    @RequestMapping("queryBasePopulation")
    @ResponseBody
    public PopulationBaseInfo queryBasePopulation(QueryByOtherPeopleReqInfo reqInfo){
    	//暂时手工组装信息
    	PopulationBaseInfo baseInfo=new PopulationBaseInfo();
    	baseInfo.setAliaName("smile");
    	baseInfo.setBirthDate("1991");
    	return baseInfo;  	
    }
    
    @RequestMapping("queryFamilyInfo")
    @ResponseBody
    public List<FamilyInfo> queryFamilyInfo(QueryByOtherPeopleReqInfo reqInfo){
    	List<FamilyInfo> familyInfoList=new ArrayList<FamilyInfo>();
    	//暂时自己手工拼装
    	FamilyInfo familyInfoFather=new FamilyInfo();
 
    	return familyInfoList;  	
    }
    
    @RequestMapping("queryMigrateInfo")
    @ResponseBody
    public MigrateInfo queryMigrateInfo(QueryByOtherPeopleReqInfo reqInfo){
    	MigrateInfo migrateInfo=new MigrateInfo();
    	migrateInfo.setTimeAndResultForMigrateLocal("smile forever,hhaha");
    	migrateInfo.setTimeAndResultForMigrateOtherPlace(" 你猜");
    	return migrateInfo;  	
    }
}
