package com.ztesoft.web.common.vo;

import com.ztesoft.web.common.db.po.DbColumnPO;

public class DBColumn {
	private Integer id;
	private String keyType;
	private String name;
	private String type;
	private Integer size;
	private Integer nullAble;
	private String defaultValue;
	private String remarks;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getNullAble() {
		return nullAble;
	}
	public void setNullAble(Integer nullAble) {
		this.nullAble = nullAble;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public void convert(DbColumnPO po){
		po.setDefaultValue(defaultValue);
		po.setKeyType(keyType);
		po.setName(name);
		po.setNullAble(nullAble+"");
		po.setRemarks(remarks);
		po.setSize(size);
		po.setType(keyType);
	}
}