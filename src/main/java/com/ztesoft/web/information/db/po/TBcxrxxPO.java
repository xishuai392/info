package com.ztesoft.web.information.db.po;

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
    
    
}