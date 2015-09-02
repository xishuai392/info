package com.ztesoft.web.information.domain;
/**
 * 家庭成员基本信息及与本人关系
 * 成员信息：、、关系、 、  、、公民身份证号码、 、  、、姓名、 、  、、证件种类、 、  、、证件号码、 、  、、外文姓、 、  、、外文名、 、  、、联系电话、
 * @author Ocean
 *
 */
public class FamilyInfo {
	//与本人关系
	private String relationShip;
	private String idCardNum;
	private String name;
	//证件种类
	private String certificateType;
	private String certificateNum;
	//外文姓
	private String foreignLastName;
	//外文名
	private String foreignFirstName;
    //联系电话
	private String telephoneNum;
	public String getRelationShip() {
		return relationShip;
	}
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNum() {
		return certificateNum;
	}
	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}
	public String getForeignLastName() {
		return foreignLastName;
	}
	public void setForeignLastName(String foreignLastName) {
		this.foreignLastName = foreignLastName;
	}
	public String getForeignFirstName() {
		return foreignFirstName;
	}
	public void setForeignFirstName(String foreignFirstName) {
		this.foreignFirstName = foreignFirstName;
	}
	public String getTelephoneNum() {
		return telephoneNum;
	}
	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}
	

	

}
