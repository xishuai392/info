package com.ztesoft.web.information.controller;

import java.math.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.dto.AbstractDto;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.web.information.db.po.TBcxrxxPO;
import com.ztesoft.web.information.service.ITBcxrxxService;

/**
 * <Description>tbcxrxx管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.controller <br>
 */

@Controller
@RequestMapping("/information/tbcxrxx")
public class TBcxrxxController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TBcxrxxController.class);

    @Autowired
    private ITBcxrxxService tBcxrxxService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "information/jsp/tBcxrxx";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<TBcxrxxPO> queryRecordByPage(TBcxrxxPO record,
            Page<TBcxrxxPO> resultPage) throws BaseAppException {
        resultPage = tBcxrxxService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public TBcxrxxPO add(TBcxrxxPO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        tBcxrxxService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public TBcxrxxPO update(TBcxrxxPO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        tBcxrxxService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(TBcxrxxPO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return tBcxrxxService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public TBcxrxxPO qryRecordInfo(
            @RequestParam(value = "id", required = true) String id)
            throws BaseAppException {
        TBcxrxxPO record = tBcxrxxService.selectByPrimaryKey(id);
        return record;
    }

    /**
     * 判断是否可以打印，如果可以则设置为已打印
     * 
     * @param bcxrxxId
     * @param cxbs
     * @param idCardNum
     * @return
     * @throws BaseAppException
     */
    @RequestMapping("canPrint")
    @ResponseBody
    public CanPrintResult canPrint(String bcxrxxId, String cxbs,
            String idCardNum) throws BaseAppException {

        CanPrintResult result = new CanPrintResult();
        // 先去捞库里的记录
        TBcxrxxPO record = tBcxrxxService.selectByPrimaryKey(bcxrxxId);
        if (null == record) {
            result.setCanPrint(false);
            result.setMessage("您查询的记录不存在，请重新查询");
            return result;
        }

        if ("20".equals(cxbs)) {
            // pc端，直接记录查询次数，不需要控制
            TBcxrxxPO newRecord = new TBcxrxxPO();
            newRecord.setSfdy("1");
            newRecord.setId(bcxrxxId);
            tBcxrxxService.update(newRecord);
        }else{
            //终端
            // 配置文件里设定的最多次数
            int maxPrint = Integer.parseInt(MessageResourceUtils
                    .getMessage("maxPrintByDay"));
            
            
            
            TBcxrxxPO newRecord = new TBcxrxxPO();
            newRecord.setSfdy("1");
            newRecord.setId(bcxrxxId);
            tBcxrxxService.update(newRecord);
        }

        return result;

    }

    public class CanPrintResult extends AbstractDto {
        private boolean canPrint = true;

        private String message = "";

        /**
         * @return the canPrint
         */
        public boolean isCanPrint() {
            return canPrint;
        }

        /**
         * @param canPrint the canPrint to set
         */
        public void setCanPrint(boolean canPrint) {
            this.canPrint = canPrint;
        }

        /**
         * @return the message
         */
        public String getMessage() {
            return message;
        }

        /**
         * @param message the message to set
         */
        public void setMessage(String message) {
            this.message = message;
        }

    }
}
