package com.ztesoft.web.information.domain.resp;

import java.util.List;

/**
 * 常住人口信息.返回给前台迭代展示类
 * @author Ocean
 *
 */
public class PermanetPopulationInfo {
	//人口基本信息
	private PopulationBaseInfo baseInfo;
	//家庭成员信息
	private List<FamilyInfo> familyInfoList;
	//迁移信息
	private MigrateInfo migrateInfo;
	public PopulationBaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(PopulationBaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}
	public List<FamilyInfo> getFamilyInfoList() {
		return familyInfoList;
	}
	public void setFamilyInfoList(List<FamilyInfo> familyInfoList) {
		this.familyInfoList = familyInfoList;
	}
	public MigrateInfo getMigrateInfo() {
		return migrateInfo;
	}
	public void setMigrateInfo(MigrateInfo migrateInfo) {
		this.migrateInfo = migrateInfo;
	}
	
	
}
