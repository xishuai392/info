package com.ztesoft.web.information.db.po;

import java.math.*;
import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.dto.AbstractDto;

public class TSqrxxPO extends AbstractDto{
	private String  id;
	private String  zjh;
	private String  zjlx;
	private String  xm;
	private String  cxsqrlx;
	private String  cxrdw;
	private String  cxsy;
	private String  cxrq;
	private String  czdw;
	private String  czr;
	private String  cxbs;
	private String zjmc;
    
    private String vdef1;//人口类型，用于查询打印次数用
    
    private String vdef2;
    
    private String lsh;//流水号
    
    
    
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
    public String getId() {
        return StringUtils.isBlank(id) ? id : id.trim();
    }
    public void setId(String id) {
        this.id = id;
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
    
    
    public String getCxsqrlx() {
        return StringUtils.isBlank(cxsqrlx) ? cxsqrlx : cxsqrlx.trim();
    }
    public void setCxsqrlx(String cxsqrlx) {
        this.cxsqrlx = cxsqrlx;
    }
    
    
    public String getCxrdw() {
        return StringUtils.isBlank(cxrdw) ? cxrdw : cxrdw.trim();
    }
    public void setCxrdw(String cxrdw) {
        this.cxrdw = cxrdw;
    }
    
    
    public String getCxsy() {
        return StringUtils.isBlank(cxsy) ? cxsy : cxsy.trim();
    }
    public void setCxsy(String cxsy) {
        this.cxsy = cxsy;
    }
    
    
    public String getCxrq() {
        return StringUtils.isBlank(cxrq) ? cxrq : cxrq.trim();
    }
    public void setCxrq(String cxrq) {
        this.cxrq = cxrq;
    }
    
    
    public String getCzdw() {
        return StringUtils.isBlank(czdw) ? czdw : czdw.trim();
    }
    public void setCzdw(String czdw) {
        this.czdw = czdw;
    }
    
    
    public String getCzr() {
        return StringUtils.isBlank(czr) ? czr : czr.trim();
    }
    public void setCzr(String czr) {
        this.czr = czr;
    }
    
    
    public String getCxbs() {
        return StringUtils.isBlank(cxbs) ? cxbs : cxbs.trim();
    }
    public void setCxbs(String cxbs) {
        this.cxbs = cxbs;
    }
    /**
     * @return the zjmc
     */
    public String getZjmc() {
        return zjmc;
    }
    /**
     * @param zjmc the zjmc to set
     */
    public void setZjmc(String zjmc) {
        this.zjmc = zjmc;
    }
    /**
     * @return the vdef1
     */
    public String getVdef1() {
        return vdef1;
    }
    /**
     * @param vdef1 the vdef1 to set
     */
    public void setVdef1(String vdef1) {
        this.vdef1 = vdef1;
    }
    /**
     * @return the vdef2
     */
    public String getVdef2() {
        return vdef2;
    }
    /**
     * @param vdef2 the vdef2 to set
     */
    public void setVdef2(String vdef2) {
        this.vdef2 = vdef2;
    }
    
    
}