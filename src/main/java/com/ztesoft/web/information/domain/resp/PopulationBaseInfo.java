package com.ztesoft.web.information.domain.resp;

/**
 * 人口基本信息。常驻人口信息和暂住人口信息包含 姓名 曾用名 性别 民族 出生日期 公民身份证号码 照片 籍贯 出生地 户籍 身份证签发机关 身份证有效期限 住址 派出所 其中籍贯，出生地，户籍都是adrress实例
 * 
 * @author Ocean
 */
public class PopulationBaseInfo {
    private String name;

    private String aliaName;

    private String sex;

    private String nation;

    private String birthDate;

    private String idCardNum;

    private String photoGif;

    // 籍贯国家
    private String nativePlaceNation;

    // 籍贯省市县
    private String nativePlaceProvince;

    // 籍贯详细地址
    private String nativePlaceDetailAddress;

    // 出生地国家
    private String birthPlaceNation;

    // 出生地省市县
    private String birthPlaceProvince;

    // 出生地详细地址
    private String birthPlaceDetailAddress;

    // 身份证签发机关
    private String idCardIssuneOffice;

    // 身份证有效期限
    private String idCardExciptyTime;

    // 住址
    private String liveAddress;

    // 分发暂住证派出所
    private String policeStation;

    /** 暂住人口信息展示字段 *****/
    // 籍贯
    private String nativePlace;

    // 户籍省市县
    private String householdRegisterProviceAddress;

    // 户籍详细地址
    private String householdRegisterDetailAddress;

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

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public String getNativePlaceNation() {
        return nativePlaceNation;
    }

    public void setNativePlaceNation(String nativePlaceNation) {
        this.nativePlaceNation = nativePlaceNation;
    }

    public String getNativePlaceProvince() {
        return nativePlaceProvince;
    }

    public void setNativePlaceProvince(String nativePlaceProvince) {
        this.nativePlaceProvince = nativePlaceProvince;
    }

    public String getNativePlaceDetailAddress() {
        return nativePlaceDetailAddress;
    }

    public void setNativePlaceDetailAddress(String nativePlaceDetailAddress) {
        this.nativePlaceDetailAddress = nativePlaceDetailAddress;
    }

    public String getBirthPlaceNation() {
        return birthPlaceNation;
    }

    public void setBirthPlaceNation(String birthPlaceNation) {
        this.birthPlaceNation = birthPlaceNation;
    }

    public String getBirthPlaceProvince() {
        return birthPlaceProvince;
    }

    public void setBirthPlaceProvince(String birthPlaceProvince) {
        this.birthPlaceProvince = birthPlaceProvince;
    }

    public String getBirthPlaceDetailAddress() {
        return birthPlaceDetailAddress;
    }

    public void setBirthPlaceDetailAddress(String birthPlaceDetailAddress) {
        this.birthPlaceDetailAddress = birthPlaceDetailAddress;
    }

    public String getHouseholdRegisterProviceAddress() {
        return householdRegisterProviceAddress;
    }

    public void setHouseholdRegisterProviceAddress(
            String householdRegisterProviceAddress) {
        this.householdRegisterProviceAddress = householdRegisterProviceAddress;
    }

    public String getHouseholdRegisterDetailAddress() {
        return householdRegisterDetailAddress;
    }

    public void setHouseholdRegisterDetailAddress(
            String householdRegisterDetailAddress) {
        this.householdRegisterDetailAddress = householdRegisterDetailAddress;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

}
