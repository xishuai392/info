package com.ztesoft.web.information.db.po;

import java.math.*;
import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.dto.AbstractDto;

public class TBcxrxxPO extends AbstractDto {
    private String id;

    private String sqrId;

    private String zjh;

    private String zjlx;

    private String xm;

    private String sfzzp;

    private String sfzf;

    private String zfly;

    private String sfdy;

    private String bcxrq;

    private String xgrq;

    private String rklx;

    private Integer cxcs;

    private Integer dycs;

    private String lsh;// 流水号

    private Integer gldycs;// 关联打印次数

    private String sqrXm;// 申请人姓名

    private String sqrzjh;// 申请人证件号

    private Date startDate;// 查询开始时间

    private String startDateStr;// 开始日期

    private Date endDate;// 查询结束时间

    private String endDateStr;// 结束日期

    private String sqrczdw;// 操作单位

    private String sqrczr;// 操作人

    private String sqrcxbs;// 10：终端，20：pc端,30:网上查询

    private String sqrzjlx;// 证件类型（10：身份证，20：其他）

    private String sqrlsh;// 申请人流水号

    /**
     * @return the sqrlsh
     */
    public String getSqrlsh() {
        return sqrlsh;
    }

    /**
     * @param sqrlsh the sqrlsh to set
     */
    public void setSqrlsh(String sqrlsh) {
        this.sqrlsh = sqrlsh;
    }

    public String getId() {
        return StringUtils.isBlank(id) ? id : id.trim();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSqrId() {
        return StringUtils.isBlank(sqrId) ? sqrId : sqrId.trim();
    }

    public void setSqrId(String sqrId) {
        this.sqrId = sqrId;
    }

    public String getZjh() {
        return StringUtils.isBlank(zjh) ? zjh : zjh.trim();
    }

    public void setZjh(String zjh) {
        this.zjh = zjh;
    }

    public String getZjlx() {
        return StringUtils.isBlank(zjlx) ? zjlx : zjlx.trim();
    }

    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }

    public String getXm() {
        return StringUtils.isBlank(xm) ? xm : xm.trim();
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getSfzzp() {
        return StringUtils.isBlank(sfzzp) ? sfzzp : sfzzp.trim();
    }

    public void setSfzzp(String sfzzp) {
        this.sfzzp = sfzzp;
    }

    public String getSfzf() {
        return StringUtils.isBlank(sfzf) ? sfzf : sfzf.trim();
    }

    public void setSfzf(String sfzf) {
        this.sfzf = sfzf;
    }

    public String getZfly() {
        return StringUtils.isBlank(zfly) ? zfly : zfly.trim();
    }

    public void setZfly(String zfly) {
        this.zfly = zfly;
    }

    public String getSfdy() {
        return StringUtils.isBlank(sfdy) ? sfdy : sfdy.trim();
    }

    public void setSfdy(String sfdy) {
        this.sfdy = sfdy;
    }

    public String getBcxrq() {
        return StringUtils.isBlank(bcxrq) ? bcxrq : bcxrq.trim();
    }

    public void setBcxrq(String bcxrq) {
        this.bcxrq = bcxrq;
    }

    public String getXgrq() {
        return StringUtils.isBlank(xgrq) ? xgrq : xgrq.trim();
    }

    public void setXgrq(String xgrq) {
        this.xgrq = xgrq;
    }

    public String getRklx() {
        return StringUtils.isBlank(rklx) ? rklx : rklx.trim();
    }

    public void setRklx(String rklx) {
        this.rklx = rklx;
    }

    public Integer getCxcs() {
        return cxcs;
    }

    public void setCxcs(Integer cxcs) {
        this.cxcs = cxcs;
    }

    public Integer getDycs() {
        return dycs;
    }

    public void setDycs(Integer dycs) {
        this.dycs = dycs;
    }

    /**
     * @return the sqrXm
     */
    public String getSqrXm() {
        return sqrXm;
    }

    /**
     * @param sqrXm the sqrXm to set
     */
    public void setSqrXm(String sqrXm) {
        this.sqrXm = sqrXm;
    }

    /**
     * @return the sqrzjh
     */
    public String getSqrzjh() {
        return sqrzjh;
    }

    /**
     * @param sqrzjh the sqrzjh to set
     */
    public void setSqrzjh(String sqrzjh) {
        this.sqrzjh = sqrzjh;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the startDateStr
     */
    public String getStartDateStr() {
        return startDateStr;
    }

    /**
     * @param startDateStr the startDateStr to set
     */
    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endDateStr
     */
    public String getEndDateStr() {
        return endDateStr;
    }

    /**
     * @param endDateStr the endDateStr to set
     */
    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    /**
     * @return the sqrczdw
     */
    public String getSqrczdw() {
        return sqrczdw;
    }

    /**
     * @param sqrczdw the sqrczdw to set
     */
    public void setSqrczdw(String sqrczdw) {
        this.sqrczdw = sqrczdw;
    }

    /**
     * @return the sqrczr
     */
    public String getSqrczr() {
        return sqrczr;
    }

    /**
     * @param sqrczr the sqrczr to set
     */
    public void setSqrczr(String sqrczr) {
        this.sqrczr = sqrczr;
    }

    /**
     * @return the sqrcxbs
     */
    public String getSqrcxbs() {
        return sqrcxbs;
    }

    /**
     * @param sqrcxbs the sqrcxbs to set
     */
    public void setSqrcxbs(String sqrcxbs) {
        this.sqrcxbs = sqrcxbs;
    }

    /**
     * @return the sqrzjlx
     */
    public String getSqrzjlx() {
        return sqrzjlx;
    }

    /**
     * @param sqrzjlx the sqrzjlx to set
     */
    public void setSqrzjlx(String sqrzjlx) {
        this.sqrzjlx = sqrzjlx;
    }

    /**
     * @return the lsh
     */
    public String getLsh() {
        return lsh;
    }

    /**
     * @param lsh the lsh to set
     */
    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    /**
     * @return the gldycs
     */
    public Integer getGldycs() {
        return gldycs;
    }

    /**
     * @param gldycs the gldycs to set
     */
    public void setGldycs(Integer gldycs) {
        this.gldycs = gldycs;
    }

}