package com.ztesoft.web.permission.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class AuditRolePO extends AbstractDto{
	private Integer  roleId;
	private String  roleName;
	private String  comments;
	private Date  stateDate;
	private String  state;
	private Date  createdDate;
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    
    public String getRoleName() {
        return StringUtils.isBlank(roleName) ? roleName : roleName.trim();
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
    public String getComments() {
        return StringUtils.isBlank(comments) ? comments : comments.trim();
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
    public Date getStateDate() {
        return stateDate;
    }
    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    
    public String getState() {
        return StringUtils.isBlank(state) ? state : state.trim();
    }
    public void setState(String state) {
        this.state = state;
    }
    
    
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
}