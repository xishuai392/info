/**
 * 
 */
package com.ztesoft.web.information.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.web.information.db.po.TBcxrxxPO;
import com.ztesoft.web.information.db.po.TSqrxxPO;

/**
 * <Description>申请人、被查询人流水号生成器 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月6日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.service <br>
 */
@Component("primaryGenerater")
public class PrimaryGenerater {

    // 申请人流水号
    private static ConcurrentHashMap<String, String> sqrLsh = new ConcurrentHashMap<String, String>();

    // 被查询人流水号
    private static ConcurrentHashMap<String, String> bcxrLsh = new ConcurrentHashMap<String, String>();

    @Autowired
    private ITSqrxxService tSqrxxService;

    @Autowired
    private ITBcxrxxService tBcxrxxService;

    public PrimaryGenerater() {

    }

    /**
     * 申请人生成下一个编号
     * 
     * @throws BaseAppException
     */
    public synchronized String getNextSqrLsh() throws BaseAppException {
        String baseKey = DateUtils.date2String(new Date(), "yyyyMMddHH");
        String preVal = sqrLsh.get(baseKey);
        if (null == preVal) {
            TSqrxxPO qryPO = new TSqrxxPO();
            qryPO.setLsh(baseKey);

            TSqrxxPO result = tSqrxxService.getLatestRecord(qryPO);
            if (null == result) {
                preVal = baseKey + "000001";
            }
            else {
                preVal = String.valueOf(new BigDecimal(result.getLsh())
                        .add(new BigDecimal("1")));
            }

            sqrLsh.put(baseKey, preVal);
            return preVal;
        }
        else {
            preVal = String.valueOf(new BigDecimal(preVal).add(new BigDecimal(
                    "1")));
            sqrLsh.put(baseKey, preVal);
            return preVal;
        }
    }

    /**
     * 被查询人生成下一个编号
     * 
     * @throws BaseAppException
     */
    public synchronized String getNextBcxrLsh(String baseSqrKey)
            throws BaseAppException {
        String preVal = bcxrLsh.get(baseSqrKey);
        if (null == preVal) {
            TBcxrxxPO qryPO = new TBcxrxxPO();
            qryPO.setLsh(baseSqrKey);

            TBcxrxxPO result = tBcxrxxService.getLatestRecord(qryPO);
            if (null == result) {
                preVal = baseSqrKey + "000001";
            }
            else {
                preVal = String.valueOf(new BigDecimal(result.getLsh())
                        .add(new BigDecimal("1")));
            }

            bcxrLsh.put(baseSqrKey, preVal);
            return preVal;
        }
        else {
            preVal = String.valueOf(new BigDecimal(preVal).add(new BigDecimal(
                    "1")));
            bcxrLsh.put(baseSqrKey, preVal);
            return preVal;
        }
    }

    public static void main(String[] args) {
        Double t = Double.parseDouble("2016040721000002000001");
        BigDecimal b = new BigDecimal("2016040721000002000001");
        b.add(new BigDecimal("1"));
        System.out.println("Double:" + t);
        System.out.println("BigDecimal:"
                + b.add(new BigDecimal("1")).toString());
    }
}
