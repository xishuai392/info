package com.ztesoft.web.information.domain;

import com.ztesoft.framework.dto.AbstractDto;


/**
 * 人口地址信息。包含国家，市区。详细地址
 * @author Ocean
 *
 */
public class Address extends AbstractDto{
	private String  nation;
	private String  provinces;
	private String  detailAddress;
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getProvinces() {
		return provinces;
	}
	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String toString(){
		String empty="";
		StringBuilder sb=new StringBuilder();
//		(nation!=null) ? empty:nation;
		sb.append(nation).append(provinces).append(detailAddress);
		return sb.toString();
    }
}
