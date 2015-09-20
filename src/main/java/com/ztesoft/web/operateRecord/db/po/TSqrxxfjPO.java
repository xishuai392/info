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
    
    
}