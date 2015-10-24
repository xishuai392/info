/**
 * 
 */
package com.ztesoft.web.information.domain.req.query;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月24日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.domain.req.query <br>
 */

public class QueryByPlatesReqInfo extends AbstractDto {

    // document.all['Name'].value = CVR_IDCard.Name; //姓名
    // document.all['Sex'].value = CVR_IDCard.Sex; //性别
    // document.all['Nation'].value = CVR_IDCard.Nation; //民族
    // document.all['Born'].value = CVR_IDCard.Born; //出生日期
    // document.all['Address'].value = CVR_IDCard.Address; //地址
    // document.all['CardNo'].value = CVR_IDCard.CardNo; //身份号码
    // document.all['IssuedAt'].value = CVR_IDCard.IssuedAt; //签发机关
    // document.all['EffectedDate'].value = CVR_IDCard.EffectedDate; //生效期限
    // document.all['ExpiredDate'].value = CVR_IDCard.ExpiredDate;//失效时间
    // document.all['SAMID'].value = CVR_IDCard.SAMID; //模块号码
    // document.all['pic'].src = CVR_IDCard.Pic; //照片名称
    // document.all['Picture'].value = CVR_IDCard.Picture; //照片编码
    // document.all['PictureLen'].value = CVR_IDCard.PictureLen ;//编码长度
    private String name;

    private String sex;

    private String nation;

    private String born;

    private String address;

    private String cardNo;

    private String issuedAt;

    private String effectedDate;

    private String expiredDate;

    private String samid;

    private String pic;

    private String picture;

    private String picturelen;

    private String populationType;// 人口类型（1：户籍人口，2：暂住人口）

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @param nation the nation to set
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * @return the born
     */
    public String getBorn() {
        return born;
    }

    /**
     * @param born the born to set
     */
    public void setBorn(String born) {
        this.born = born;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the cardNo
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * @param cardNo the cardNo to set
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * @return the issuedAt
     */
    public String getIssuedAt() {
        return issuedAt;
    }

    /**
     * @param issuedAt the issuedAt to set
     */
    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    /**
     * @return the effectedDate
     */
    public String getEffectedDate() {
        return effectedDate;
    }

    /**
     * @param effectedDate the effectedDate to set
     */
    public void setEffectedDate(String effectedDate) {
        this.effectedDate = effectedDate;
    }

    /**
     * @return the expiredDate
     */
    public String getExpiredDate() {
        return expiredDate;
    }

    /**
     * @param expiredDate the expiredDate to set
     */
    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    /**
     * @return the samid
     */
    public String getSamid() {
        return samid;
    }

    /**
     * @param samid the samid to set
     */
    public void setSamid(String samid) {
        this.samid = samid;
    }

    /**
     * @return the pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic the pic to set
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @return the picturelen
     */
    public String getPicturelen() {
        return picturelen;
    }

    /**
     * @param picturelen the picturelen to set
     */
    public void setPicturelen(String picturelen) {
        this.picturelen = picturelen;
    }

    /**
     * @return the populationType
     */
    public String getPopulationType() {
        return populationType;
    }

    /**
     * @param populationType the populationType to set
     */
    public void setPopulationType(String populationType) {
        this.populationType = populationType;
    }

}
