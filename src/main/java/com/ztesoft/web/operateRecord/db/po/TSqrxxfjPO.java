package com.ztesoft.web.operateRecord.db.po;

import java.math.*;
import java.util.*;

import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.dto.AbstractDto;

public class TSqrxxfjPO extends AbstractDto{
	private String  id;
	private String  sqrId;
	private String  mc;
	private String  dz;
	private String fjlx;//附件类型：1=工作证/身份证；2=介绍信；3=委托协议/受理通知书
    
    private String vdef1;
    
    private String vdef2;
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
    
    
    public String getMc() {
        return StringUtils.isBlank(mc) ? mc : mc.trim();
    }
    public void setMc(String mc) {
        this.mc = mc;
    }
    
    
    public String getDz() {
        return StringUtils.isBlank(dz) ? dz : dz.trim();
    }
    public void setDz(String dz) {
        this.dz = dz;
    }
    /**
     * @return the fjlx
     */
    public String getFjlx() {
        return fjlx;
    }
    /**
     * @param fjlx the fjlx to set
     */
    public void setFjlx(String fjlx) {
        this.fjlx = fjlx;
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