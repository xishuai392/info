package com.ztesoft.web.information.controller;

import java.math.*;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.ArgCondition;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.web.information.db.po.TSqrxxfjPO;
import com.ztesoft.web.information.service.ITSqrxxfjService;

/**
 * <Description>tsqrxxfj管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.controller <br>
 */

@Controller
@RequestMapping("/information/tsqrxxfj")
public class TSqrxxfjController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TSqrxxfjController.class);

    @Autowired
    private ITSqrxxfjService tSqrxxfjService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "information/jsp/tSqrxxfj";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<TSqrxxfjPO> queryRecordByPage(TSqrxxfjPO record,
            Page<TSqrxxfjPO> resultPage) throws BaseAppException {
        resultPage = tSqrxxfjService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public TSqrxxfjPO add(TSqrxxfjPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        tSqrxxfjService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public TSqrxxfjPO update(TSqrxxfjPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        tSqrxxfjService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(TSqrxxfjPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return tSqrxxfjService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public TSqrxxfjPO qryRecordInfo(
            @RequestParam(value = "id", required = true) String id)
            throws BaseAppException {
        TSqrxxfjPO record = tSqrxxfjService.selectByPrimaryKey(id);
        return record;
    }

    @RequestMapping("deleteBatch")
    @ResponseBody
    public int deleteBatch(String delIds) throws BaseAppException {
        if (StringUtils.isBlank(delIds))
            return 0;
        List<TSqrxxfjPO> listRecord = new ArrayList<TSqrxxfjPO>();
        String[] delIdAry = delIds.split(",");
        for (String id : delIdAry) {
            if (!StringUtils.isBlank(id)) {
                TSqrxxfjPO record = new TSqrxxfjPO();
                record.setId(id.trim());
                listRecord.add(record);
            }
        }

        return tSqrxxfjService.deleteBatch(listRecord);
    }

    @RequestMapping("qryList")
    @ResponseBody
    public List<TSqrxxfjPO> qryList(TSqrxxfjPO record) throws BaseAppException {
        ArgCondition conditon = new ArgCondition();
        conditon.setParamName("sqrId");
        conditon.setOperation("EqualTo");
        conditon.setParamValue(new String[] {
            String.valueOf(record.getSqrId())
        });
        ArgCondition[] conditionAry = new ArgCondition[1];
        conditionAry[0] = conditon;

        String condition = JsonUtil.toJson(conditionAry);
        record.setQueryConditions(condition);
        
        return tSqrxxfjService.selectByArg(record);
    }

}
