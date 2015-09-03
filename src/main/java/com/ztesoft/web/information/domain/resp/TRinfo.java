package com.ztesoft.web.information.domain.resp;
/**
 * 暂住信息。包含 :序号 、暂住证编号  、起始日期、截止日期、间隔时间、签发机构、登记单位、填报日期、暂住地址
 * @author Ocean
 *
 */
public class TRinfo {
//	暂住证编号 
	private String trNum;
//	起始日期
	private String startDate;
//	截止日期
	private String endDate;
//	间隔时间
	private String intervalTime;
//	签发机构
	private String trCardIssuneOffice;
//	登记单位
	private String trCardCompany;
//	填报日期
	private String fillDate;
//	暂住地址
	private String trAddress;
	public String getTrNum() {
		return trNum;
	}
	public void setTrNum(String trNum) {
		this.trNum = trNum;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}
	public String getTrCardIssuneOffice() {
		return trCardIssuneOffice;
	}
	public void setTrCardIssuneOffice(String trCardIssuneOffice) {
		this.trCardIssuneOffice = trCardIssuneOffice;
	}
	public String getTrCardCompany() {
		return trCardCompany;
	}
	public void setTrCardCompany(String trCardCompany) {
		this.trCardCompany = trCardCompany;
	}
	public String getFillDate() {
		return fillDate;
	}
	public void setFillDate(String fillDate) {
		this.fillDate = fillDate;
	}
	public String getTrAddress() {
		return trAddress;
	}
	public void setTrAddress(String trAddress) {
		this.trAddress = trAddress;
	}
	
}
