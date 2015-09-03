package com.ztesoft.web.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ztesoft.framework.log.ZTEsoftLogManager;
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
    
    @RequestMapping("query")
    public String index(String hello){
    	
    	System.out.println(hello);
    	return null;
    }
    
}
