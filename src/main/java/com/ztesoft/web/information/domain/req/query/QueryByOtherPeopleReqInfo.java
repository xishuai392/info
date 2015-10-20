package com.ztesoft.web.information.domain.req.query;

/**
 * 被查询人请求信息。包含对应的uuid及身份证信息
 * 
 * @author Ocean
 */
public class QueryByOtherPeopleReqInfo {
    // 申请人信息表主键uuid
    private String sqrxxId;

    // 被查询人信息主键
    private String bcxrxxId;

    // 被查询人的身份证信息
    private String idCardNum;

    // 人口类型
    private String populationType;
    

    /**
     * @return the bcxrxxId
     */
    public String getBcxrxxId() {
        return bcxrxxId;
    }

    /**
     * @param bcxrxxId the bcxrxxId to set
     */
    public void setBcxrxxId(String bcxrxxId) {
        this.bcxrxxId = bcxrxxId;
    }

    /**
     * @return the sqrxxId
     */
    public String getSqrxxId() {
        return sqrxxId;
    }

    /**
     * @param sqrxxId the sqrxxId to set
     */
    public void setSqrxxId(String sqrxxId) {
        this.sqrxxId = sqrxxId;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getPopulationType() {
        return populationType;
    }

    public void setPopulationType(String populationType) {
        this.populationType = populationType;
    }

}
