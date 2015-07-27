package com.ztesoft.web.permission.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class AuditUserPO extends AbstractDto{
	private Integer  userId;
	private String  userName;
	private String  userCode;
	private String  telephone;
	private String  email;
	private String  password;
	private Integer  age;
	private String  state;
	private Date  createdDate;
	private Long  orgId;
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    public String getUserName() {
        return StringUtils.isBlank(userName) ? userName : userName.trim();
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public String getUserCode() {
        return StringUtils.isBlank(userCode) ? userCode : userCode.trim();
    }
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    
    
    public String getTelephone() {
        return StringUtils.isBlank(telephone) ? telephone : telephone.trim();
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    public String getEmail() {
        return StringUtils.isBlank(email) ? email : email.trim();
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getPassword() {
        return StringUtils.isBlank(password) ? password : password.trim();
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
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

    
    public Long getOrgId() {
        return orgId;
    }
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    
}