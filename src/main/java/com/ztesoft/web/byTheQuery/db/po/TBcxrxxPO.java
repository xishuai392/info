package com.ztesoft.web.byTheQuery.db.po;

import java.math.*;
import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.dto.AbstractDto;

public class TBcxrxxPO extends AbstractDto{
	private String  id;
	private String  sqrId;
	private String  zjh;
	private String  zjlx;
	private String  xm;
	private String  sfzzp;
	private String  sfzf;
	private String  zfly;
	private String  sfdy;
	private String  bcxrq;
	private String  xgrq;
	private String  rklx;
	private Integer  cxcs;
	
    private String sqrXm;//申请人姓名

    private String sqrzjh;//申请人证件号
	private Date startDate;//查询开始时间
	private String startDateStr;// 开始日期
    private Date endDate;//查询结束时间
    private String endDateStr;// 结束日期
    
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

    
}