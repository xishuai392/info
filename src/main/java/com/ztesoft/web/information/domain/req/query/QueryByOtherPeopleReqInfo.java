package com.ztesoft.web.information.domain.req.query;
/**
 * 被查询人请求信息。包含对应的uuid及身份证信息
 * @author Ocean
 *
 */
public class QueryByOtherPeopleReqInfo {
	//查询日志表的id
	private String cxrzId;
	//被查询人的身份证信息
	private String idCardNum;
	public String getCxrzId() {
		return cxrzId;
	}
	public void setCxrzId(String cxrzId) {
		this.cxrzId = cxrzId;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	
	
}
