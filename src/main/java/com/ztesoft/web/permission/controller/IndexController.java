package com.ztesoft.web.permission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description>主界面 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年7月28日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */
@Controller
public class IndexController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(IndexController.class);

    @RequestMapping(value = "/index.do")
    public String index(Model model) {
        return "permission/jsp/main";
    }

}
