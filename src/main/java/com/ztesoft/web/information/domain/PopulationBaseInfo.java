package com.ztesoft.web.information.domain;
/**
 * 人口基本信息。常驻人口信息和暂住人口信息包含
 * 
姓名
曾用名
性别
民族
出生日期
公民身份证号码
照片
籍贯
出生地
户籍
身份证签发机关
身份证有效期限
住址
派出所
 * 
 *其中籍贯，出生地，户籍都是adrress实例
 * 
 * @author Ocean
 *
 */
public class PopulationBaseInfo {
	private String name;
	private String aliaName;
	private String sex;
	private String nation;
	private String birthDate;
	private String idCardNum;
	private String photoGif;
	private Address nativePlace;
	private Address birthPlace;
	//户籍
	private Address householdRegister;
	//身份证签发机关
	private String  idCardIssuneOffice;
	//身份证有效期限
	private String  idCardExciptyTime;
	private Address liveAddress;
	//分发暂住证派出所
	private String  policeStation;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAliaName() {
		return aliaName;
	}
	public void setAliaName(String aliaName) {
		this.aliaName = aliaName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public String getPhotoGif() {
		return photoGif;
	}
	public void setPhotoGif(String photoGif) {
		this.photoGif = photoGif;
	}
	public Address getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(Address nativePlace) {
		this.nativePlace = nativePlace;
	}
	public Address getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(Address birthPlace) {
		this.birthPlace = birthPlace;
	}
	public Address getHouseholdRegister() {
		return householdRegister;
	}
	public void setHouseholdRegister(Address householdRegister) {
		this.householdRegister = householdRegister;
	}
	public String getIdCardIssuneOffice() {
		return idCardIssuneOffice;
	}
	public void setIdCardIssuneOffice(String idCardIssuneOffice) {
		this.idCardIssuneOffice = idCardIssuneOffice;
	}
	public String getIdCardExciptyTime() {
		return idCardExciptyTime;
	}
	public void setIdCardExciptyTime(String idCardExciptyTime) {
		this.idCardExciptyTime = idCardExciptyTime;
	}
	public Address getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(Address liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}
	
	
	
	
}
