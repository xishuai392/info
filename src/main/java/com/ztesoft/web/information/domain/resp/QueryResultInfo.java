package com.ztesoft.web.information.domain.resp;

/**
 * 身份证查询返回结果对象类
 * 姓名  身份证号码 出生日期  住址 人口类型 是否办理暂住证
 * @author Ocean
 *
 */
public class QueryResultInfo {
  private String  name;
  private String  idCardNum;
  private String  birthDate;
  private String  address;
  private String  populationType;
  private String  isHavingTR;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIdCardNum() {
	return idCardNum;
}
public void setIdCardNum(String idCardNum) {
	this.idCardNum = idCardNum;
}
public String getBirthDate() {
	return birthDate;
}
public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPopulationType() {
	return populationType;
}
public void setPopulationType(String populationType) {
	this.populationType = populationType;
}
public String getIsHavingTR() {
	return isHavingTR;
}
public void setIsHavingTR(String isHavingTR) {
	this.isHavingTR = isHavingTR;
}
  
}
