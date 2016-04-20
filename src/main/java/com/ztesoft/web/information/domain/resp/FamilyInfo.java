package com.ztesoft.web.information.domain.resp;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * 家庭成员基本信息及与本人关系 成员信息：、、关系、 、 、、公民身份证号码、 、 、、姓名、 、 、、证件种类、 、 、、证件号码、 、 、、外文姓、 、 、、外文名、 、 、、联系电话、
 * 
 * @author Ocean
 */
public class FamilyInfo extends AbstractDto {

    // 与本人关系的类型。即是父母 配偶 监护人 子女
    // 用于终端前台隐藏子女时候用，子女填40，其他的不填或者小于40
    private String relationTypeNum = "0";

    // 与本人关系的类型。即是父母 子女 配偶 监护人 子女
    private String relationType;

    // 与本人关系
    private String relationShip;

    private String idCardNum;

    private String name;

    // 证件种类
    private String certificateType;

    private String certificateNum;

    // 外文姓
    private String foreignLastName;

    // 外文名
    private String foreignFirstName;

    // 联系电话
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

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    /**
     * @return the relationTypeNum
     */
    public String getRelationTypeNum() {
        return relationTypeNum;
    }

    /**
     * @param relationTypeNum the relationTypeNum to set
     */
    public void setRelationTypeNum(String relationTypeNum) {
        this.relationTypeNum = relationTypeNum;
    }

}
