package com.ztesoft.web.permission.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class AuditUserRolePO extends AbstractDto{
	private Integer  userRoleId;
	private Integer  roleId;
	private Integer  userId;
	private String  state;
	private String  isNormal;
	private String  isBasic;
    public Integer getUserRoleId() {
        return userRoleId;
    }
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    public String getState() {
        return StringUtils.isBlank(state) ? state : state.trim();
    }
    public void setState(String state) {
        this.state = state;
    }
    
    
    public String getIsNormal() {
        return StringUtils.isBlank(isNormal) ? isNormal : isNormal.trim();
    }
    public void setIsNormal(String isNormal) {
        this.isNormal = isNormal;
    }
    
    
    public String getIsBasic() {
        return StringUtils.isBlank(isBasic) ? isBasic : isBasic.trim();
    }
    public void setIsBasic(String isBasic) {
        this.isBasic = isBasic;
    }
    
    
}