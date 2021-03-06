package com.ztesoft.web.information.controller;

import java.text.MessageFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
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
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.web.information.db.po.TBcxrxxPO;
import com.ztesoft.web.information.db.po.TSqrxxPO;
import com.ztesoft.web.information.service.ITBcxrxxService;
import com.ztesoft.web.information.service.ITSqrxxService;

/**
 * <Description>修改操作记录 <br>
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

    @Autowired
    private ITSqrxxService tSqrxxService;

    @RequestMapping("modifyIndex")
    public String modifyIndex(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "information/jsp/tBcxrxx";
    }

    /**
     * 修改操作记录，查询分页
     */
    @RequestMapping("select4Page")
    @ResponseBody
    public Page<TBcxrxxPO> select4Page(TBcxrxxPO record,
            Page<TBcxrxxPO> resultPage) throws BaseAppException {
        resultPage = tBcxrxxService.select4Page(record, resultPage);
        return resultPage;
    }

    @RequestMapping("updateRecordState")
    @ResponseBody
    public String updateRecordState(String ids, String zfly, boolean isDisabled)
            throws BaseAppException {
        if (StringUtils.isBlank(ids)) {
            return "false";
        }
        String[] idAry = ids.split(",");
        for (String id : idAry) {
            TBcxrxxPO record = new TBcxrxxPO();
            record.setId(id.trim());
            record.setZfly(zfly);
            // 是否作废（1：是，0：否）默认为“否”
            if (isDisabled) {
                record.setSfzf("1");
            }
            else {
                record.setSfzf("0");
            }
            tBcxrxxService.update(record);
        }

        return "true";
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
     * @param rklx 人口类型（1：户籍人口，2：暂住人口）
     * @return
     * @throws BaseAppException
     */
    @RequestMapping("canPrint")
    @ResponseBody
    public CanPrintResult canPrintAndMark(String bcxrxxId, String cxbs,
            String idCardNum, String rklx) throws BaseAppException {
        // 20160330需求 终端常口打印10次 子女就学打印5次 分开计算
        CanPrintResult result = new CanPrintResult();
        // 先去捞库里的记录
        TBcxrxxPO record = tBcxrxxService.selectByPrimaryKey(bcxrxxId);
        if (null == record) {
            result.setCanPrint(false);
            result.setMessage("您查询的记录不存在，请重新查询");
            return result;
        }

        if (!"10".equals(cxbs)) {
            // pc端、网上查询，直接记录查询次数，不需要控制
            TBcxrxxPO newRecord = new TBcxrxxPO();
            newRecord.setSfdy("1");
            newRecord.setId(bcxrxxId);
            newRecord.setDycs(record.getDycs() + 1);
            tBcxrxxService.update(newRecord);
        }
        else {
            try {
                // 终端
                // 配置文件里设定的最多次数
                int maxPrint = Integer.parseInt(MessageResourceUtils
                        .getMessage("maxPrintByDay"));

                if ("1".equals(rklx)) {
                    maxPrint = Integer.parseInt(MessageResourceUtils
                            .getMessage("Plates.czrk.maxPrintByDay"));
                }
                else if ("2".equals(rklx)) {
                    maxPrint = Integer.parseInt(MessageResourceUtils
                            .getMessage("Plates.znrx.maxPrintByDay"));
                }
                else {

                }

                TSqrxxPO queryVO = new TSqrxxPO();
                queryVO.setCxbs("10");// 终端
                queryVO.setZjh(idCardNum);
                queryVO.setCxrq(DateUtils.date2String(new Date(),
                        DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
                queryVO.setVdef1(rklx);// 人口类型（1：户籍人口，2：暂住人口） 区分开终端的常口及子女上学

                int printTimes = tSqrxxService.countPrintByZD(queryVO);

                if (printTimes >= maxPrint) {
                    // 不可以打印了
                    result.setCanPrint(false);
                    result.setMessage(MessageResourceUtils
                            .getMessage("maxPrintByDay.errorMessage"));
                    return result;
                }
                else {
                    // 还可以打印
                    result.setCanPrint(true);
                    String parttern = MessageResourceUtils
                            .getMessage("Plates.PrintingMsg.format");
                    result.setMessage(String.format(parttern, printTimes + 1,
                            (maxPrint - printTimes - 1)));
                }
            }
            catch (Exception e) {
                logger.error("查询终端用户当天打印次数时发生错误。", e);
                result.setCanPrint(false);
                result.setMessage("系统繁忙，请稍后再试.");
            }
            TBcxrxxPO newRecord = new TBcxrxxPO();
            newRecord.setSfdy("1");
            newRecord.setId(bcxrxxId);
            newRecord.setDycs(record.getDycs() + 1);
            if ("2".equals(rklx)) {
                //人口类型（1：户籍人口，2：暂住人口）
                //20160803 对于暂住人口查询-外来务工子女入学的，需要更新查询次数+1
                newRecord.setCxcs(record.getCxcs()+1);
            }
            tBcxrxxService.update(newRecord);
        }

        return result;

    }

    /**
     * 仅判断是否可以打印
     * 
     * @param bcxrxxId
     * @param cxbs
     * @param idCardNum
     * @return
     * @throws BaseAppException
     */
    @RequestMapping("checkPrintMark")
    @ResponseBody
    @Deprecated
    public CanPrintResult checkPrintMark(String bcxrxxId, String cxbs,
            String idCardNum) throws BaseAppException {

        CanPrintResult result = new CanPrintResult();
        // 先去捞库里的记录
        TBcxrxxPO record = tBcxrxxService.selectByPrimaryKey(bcxrxxId);
        if (null == record) {
            result.setCanPrint(false);
            result.setMessage("您查询的记录不存在，请重新查询");
            return result;
        }

        try {
            // 配置文件里设定的最多次数
            int maxPrint = Integer.parseInt(MessageResourceUtils
                    .getMessage("maxPrintByDay"));

            TSqrxxPO queryVO = new TSqrxxPO();
            queryVO.setCxbs("10");// 终端
            queryVO.setZjh(idCardNum);
            queryVO.setCxrq(DateUtils.date2String(new Date(),
                    DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));

            int printTimes = tSqrxxService.countPrintByZD(queryVO);

            if (printTimes >= maxPrint) {
                // 不可以打印了
                result.setCanPrint(false);
                result.setMessage(MessageResourceUtils
                        .getMessage("maxPrintByDay.errorMessage"));
                return result;
            }
        }
        catch (Exception e) {
            logger.error("查询终端用户当天打印次数时发生错误。", e);
        }

        return result;

    }

    public class CanPrintResult extends AbstractDto {
        private boolean canPrint = true;// 是否能打印

        private String message = "";// 提示信息

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
