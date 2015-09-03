package com.ztesoft.web.information.domain.resp;
import java.util.List;
/**
 * 暂住人口信息
 * @author Ocean
 *
 */

public class TRpopulationInfo {
	//人口基本信息
	private PopulationBaseInfo baseInfo;
	//暂住信息集
	private List<TRinfo> trInfoList;
	public PopulationBaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(PopulationBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	public List<TRinfo> getTrInfoList() {
		return trInfoList;
	}
	public void setTrInfoList(List<TRinfo> trInfoList) {
		this.trInfoList = trInfoList;
	}
	
}
