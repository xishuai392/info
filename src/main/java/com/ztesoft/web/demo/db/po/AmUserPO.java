package com.ztesoft.web.demo.db.po;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.dto.AbstractDto;

public class AmUserPO extends AbstractDto {
    private Integer userId;

    private String userName;

    private String nickName;

    private String userCode;

    private String telephone;

    private String email;

    private String password;

    private Integer age;

    private String state;

    private Date createdDate;

    private BigDecimal testNumberOne;

    private BigDecimal testNumberTwo;

    private Double testDoubleOne;

    private Double testDoubleTwo;

    private byte[] photo;

    private String testText;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return StringUtils.isBlank(userName) ? userName : userName.trim();
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return StringUtils.isBlank(nickName) ? nickName : nickName.trim();
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return StringUtils.isBlank(userCode) ? userCode : userCode.trim();
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return StringUtils.isBlank(telephone) ? telephone : telephone.trim();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return StringUtils.isBlank(email) ? email : email.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return StringUtils.isBlank(password) ? password : password.trim();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return StringUtils.isBlank(state) ? state : state.trim();
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setTestNumberOne(BigDecimal testNumberOne) {
        this.testNumberOne = testNumberOne;
    }

    public BigDecimal getTestNumberOne() {
        return testNumberOne;
    }

    public void setTestNumberTwo(BigDecimal testNumberTwo) {
        this.testNumberTwo = testNumberTwo;
    }

    public BigDecimal getTestNumberTwo() {
        return testNumberTwo;
    }

    public void setTestDoubleOne(Double testDoubleOne) {
        this.testDoubleOne = testDoubleOne;
    }

    public Double getTestDoubleOne() {
        return testDoubleOne;
    }

    public void setTestDoubleTwo(Double testDoubleTwo) {
        this.testDoubleTwo = testDoubleTwo;
    }

    public Double getTestDoubleTwo() {
        return testDoubleTwo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setTestText(String testText) {
        this.testText = testText;
    }

    public String getTestText() {
        return StringUtils.isBlank(testText) ? testText : testText.trim();
    }

}