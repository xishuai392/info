package com.ztesoft.web.information.domain.req.query;
/**
 * 查询人请求对象信息
 * 
查询申请人信息
证件号：
证件类型：
查询申请人类型：
申请查询人单位：
姓名：
查询事由：
 * @author Ocean
 *
 */
public class QueryPeopleReqInfo {
	private String idCardNum;
	private String indentyType;
	private String name;
	private String applicantQueryType;
	private String applicantCompany;
	private String queryResult;
	private String cxbs;
	public String getIdCardNum() {
		return idCardNum;
	}
	public void  setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public String getIndentyType() {
		return indentyType;
	}
	public void setIndentyType(String indentyType) {
		this.indentyType = indentyType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApplicantQueryType() {
		return applicantQueryType;
	}
	public void setApplicantQueryType(String applicantQueryType) {
		this.applicantQueryType = applicantQueryType;
	}
	public String getApplicantCompany() {
		return applicantCompany;
	}
	public void setApplicantCompany(String applicantCompany) {
		this.applicantCompany = applicantCompany;
	}
	public String getQueryResult() {
		return queryResult;
	}
	public void setQueryResult(String queryResult) {
		this.queryResult = queryResult;
	}
	
}
