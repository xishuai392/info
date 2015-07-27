package com.ztesoft.web.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.demo.db.po.AmUserPO;
import com.ztesoft.web.demo.service.IAmUserService;

/**
 * <Description>DEMO示例，用户信息管理 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.controller <br>
 */

@Controller
@RequestMapping("/demo/amuser")
public class AmUserController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(AmUserController.class);

    @Autowired
    private IAmUserService amUserService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "demo/jsp/amUser";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<AmUserPO> queryRecordByPage(AmUserPO record,
            Page<AmUserPO> resultPage) throws BaseAppException {
        resultPage = amUserService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public AmUserPO add(AmUserPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        amUserService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public AmUserPO update(AmUserPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        amUserService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(AmUserPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return amUserService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public AmUserPO qryRecordInfo(@RequestParam(value = "userId",
            required = true) Integer userId) throws BaseAppException {
        AmUserPO record = amUserService.selectByPrimaryKey(userId);
        return record;
    }

}
