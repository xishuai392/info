package com.ztesoft.web.information.controller;

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
    	
    	return null;
    	
    }
    
}
