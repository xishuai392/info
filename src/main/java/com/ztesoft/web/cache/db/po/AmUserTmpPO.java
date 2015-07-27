package com.ztesoft.web.cache.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;

public class AmUserTmpPO extends AbstractDto{
	private Integer  userId;
	private String  userName;
	private String  nickName;
	private String  userCode;
	private String  telephone;
	private String  email;
	private String  password;
	private Integer  age;
	private String  state;
	private Date  createdDate;
	private BigDecimal  testNumberOne;
	private BigDecimal  testNumberTwo;
	private Double  testDoubleOne;
	private Double  testDoubleTwo;
	private String  photo;
	private String  testText;
	private BigDecimal  acctItemId;
	private BigDecimal  servId;
	private BigDecimal  amount;
	private BigDecimal  feeCycleId;
	private Date  stateDate;
	private BigDecimal  balancePaid;
	private Integer  dealSource;
	private BigDecimal  meterReading;
	private String  pseudoFlag;
	private BigDecimal  partitionCharge;
	private String  cpid;
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
    
    
    public String getNickName() {
        return StringUtils.isBlank(nickName) ? nickName : nickName.trim();
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    
    public BigDecimal getTestNumberOne() {
        return testNumberOne;
    }
    public void setTestNumberOne(BigDecimal testNumberOne) {
        this.testNumberOne = testNumberOne;
    }

    
    public BigDecimal getTestNumberTwo() {
        return testNumberTwo;
    }
    public void setTestNumberTwo(BigDecimal testNumberTwo) {
        this.testNumberTwo = testNumberTwo;
    }

    
    public Double getTestDoubleOne() {
        return testDoubleOne;
    }
    public void setTestDoubleOne(Double testDoubleOne) {
        this.testDoubleOne = testDoubleOne;
    }

    
    public Double getTestDoubleTwo() {
        return testDoubleTwo;
    }
    public void setTestDoubleTwo(Double testDoubleTwo) {
        this.testDoubleTwo = testDoubleTwo;
    }

    
    public String getPhoto() {
        return StringUtils.isBlank(photo) ? photo : photo.trim();
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
    public String getTestText() {
        return StringUtils.isBlank(testText) ? testText : testText.trim();
    }
    public void setTestText(String testText) {
        this.testText = testText;
    }
    
    
    public BigDecimal getAcctItemId() {
        return acctItemId;
    }
    public void setAcctItemId(BigDecimal acctItemId) {
        this.acctItemId = acctItemId;
    }

    
    public BigDecimal getServId() {
        return servId;
    }
    public void setServId(BigDecimal servId) {
        this.servId = servId;
    }

    
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    
    public BigDecimal getFeeCycleId() {
        return feeCycleId;
    }
    public void setFeeCycleId(BigDecimal feeCycleId) {
        this.feeCycleId = feeCycleId;
    }

    
    public Date getStateDate() {
        return stateDate;
    }
    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    
    public BigDecimal getBalancePaid() {
        return balancePaid;
    }
    public void setBalancePaid(BigDecimal balancePaid) {
        this.balancePaid = balancePaid;
    }

    
    public Integer getDealSource() {
        return dealSource;
    }
    public void setDealSource(Integer dealSource) {
        this.dealSource = dealSource;
    }

    
    public BigDecimal getMeterReading() {
        return meterReading;
    }
    public void setMeterReading(BigDecimal meterReading) {
        this.meterReading = meterReading;
    }

    
    public String getPseudoFlag() {
        return StringUtils.isBlank(pseudoFlag) ? pseudoFlag : pseudoFlag.trim();
    }
    public void setPseudoFlag(String pseudoFlag) {
        this.pseudoFlag = pseudoFlag;
    }
    
    
    public BigDecimal getPartitionCharge() {
        return partitionCharge;
    }
    public void setPartitionCharge(BigDecimal partitionCharge) {
        this.partitionCharge = partitionCharge;
    }

    
    public String getCpid() {
        return StringUtils.isBlank(cpid) ? cpid : cpid.trim();
    }
    public void setCpid(String cpid) {
        this.cpid = cpid;
    }
    
    
}