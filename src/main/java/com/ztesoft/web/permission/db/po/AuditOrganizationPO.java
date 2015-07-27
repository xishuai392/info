package com.ztesoft.web.permission.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class AuditOrganizationPO extends AbstractDto{
	private Long  orgId;
	private Long  parentOrgId;
	private String  orgCode;
	private String  orgName;
	private Long  orgLevel;
	private Date  createdTime;
	private String  orgDesc;
	private String  state;
	private Date  stateTime;
    public Long getOrgId() {
        return orgId;
    }
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    
    public Long getParentOrgId() {
        return parentOrgId;
    }
    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    
    public String getOrgCode() {
        return StringUtils.isBlank(orgCode) ? orgCode : orgCode.trim();
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    
    
    public String getOrgName() {
        return StringUtils.isBlank(orgName) ? orgName : orgName.trim();
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    
    public Long getOrgLevel() {
        return orgLevel;
    }
    public void setOrgLevel(Long orgLevel) {
        this.orgLevel = orgLevel;
    }

    
    public Date getCreatedTime() {
        return createdTime;
    }
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    
    public String getOrgDesc() {
        return StringUtils.isBlank(orgDesc) ? orgDesc : orgDesc.trim();
    }
    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }
    
    
    public String getState() {
        return StringUtils.isBlank(state) ? state : state.trim();
    }
    public void setState(String state) {
        this.state = state;
    }
    
    
    public Date getStateTime() {
        return stateTime;
    }
    public void setStateTime(Date stateTime) {
        this.stateTime = stateTime;
    }

    
}