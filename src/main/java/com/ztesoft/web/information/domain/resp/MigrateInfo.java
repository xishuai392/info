package com.ztesoft.web.information.domain.resp;
/**
 * 迁移信息
 * @author Ocean
 *
 */
public class MigrateInfo {
	//何时何因由何地迁来本市(县)
	private String timeAndResultForMigrateLocal;
	//何时何因迁往何地
	private String timeAndResultForMigrateOtherPlace;
	public String getTimeAndResultForMigrateLocal() {
		return timeAndResultForMigrateLocal;
	}
	public void setTimeAndResultForMigrateLocal(String timeAndResultForMigrateLocal) {
		this.timeAndResultForMigrateLocal = timeAndResultForMigrateLocal;
	}
	public String getTimeAndResultForMigrateOtherPlace() {
		return timeAndResultForMigrateOtherPlace;
	}
	public void setTimeAndResultForMigrateOtherPlace(String timeAndResultForMigrateOtherPlace) {
		this.timeAndResultForMigrateOtherPlace = timeAndResultForMigrateOtherPlace;
	}
	
	
	

}
