package com.ztesoft.web.information.domain.resp;

import java.util.Date;

import com.ztesoft.framework.util.DateUtils;

/**
 * 暂住信息。包含 :序号 、暂住证编号 、起始日期、截止日期、间隔时间、签发机构、登记单位、填报日期、暂住地址<br>
 * 根据起始日期可排序
 * 
 * @author Ocean
 */
public class TRinfo implements Comparable<TRinfo> {
    // 暂住证编号
    private String trNum;

    // 起始日期
    private String startDate;

    // 起始日期——用于比较
    private Date startDate4Compar;

    // 截止日期
    private String endDate;

    // 起始日期——用于比较
    private Date endDate4Compar;

    // 间隔时间
    private String intervalTime;

    // 签发机构
    private String trCardIssuneOffice;

    // 登记单位
    private String trCardCompany;

    // 填报日期
    private String fillDate;

    // 暂住地址
    private String trAddress;

    
    
    /**
     * @return the endDate4Compar
     */
    public Date getEndDate4Compar() {
        return endDate4Compar;
    }

    /**
     * @param endDate4Compar the endDate4Compar to set
     */
    public void setEndDate4Compar(Date endDate4Compar) {
        this.endDate4Compar = endDate4Compar;
    }

    /**
     * @return the startDate4Compar
     */
    public Date getStartDate4Compar() {
        return startDate4Compar;
    }

    /**
     * @param startDate4Compar the startDate4Compar to set
     */
    public void setStartDate4Compar(Date startDate4Compar) {
        this.startDate4Compar = startDate4Compar;
    }

    public String getTrNum() {
        return trNum;
    }

    public void setTrNum(String trNum) {
        this.trNum = trNum;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getTrCardIssuneOffice() {
        return trCardIssuneOffice;
    }

    public void setTrCardIssuneOffice(String trCardIssuneOffice) {
        this.trCardIssuneOffice = trCardIssuneOffice;
    }

    public String getTrCardCompany() {
        return trCardCompany;
    }

    public void setTrCardCompany(String trCardCompany) {
        this.trCardCompany = trCardCompany;
    }

    public String getFillDate() {
        return fillDate;
    }

    public void setFillDate(String fillDate) {
        this.fillDate = fillDate;
    }

    public String getTrAddress() {
        return trAddress;
    }

    public void setTrAddress(String trAddress) {
        this.trAddress = trAddress;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TRinfo that) {
        // TODO Auto-generated method stub
        if (null == this.getStartDate4Compar()) {
            return -1;
        }
        if (null == that.getStartDate4Compar()) {
            return 1;
        }
        // 0-小于, 1-等于，2-大于
        int order = DateUtils.isCompare(this.getStartDate4Compar(),
                that.getStartDate4Compar());
        if (order == 0)
            return -1;
        if (order == 1)
            return 0;
        if (order == 2)
            return 1;

        return 0;
    }

}
