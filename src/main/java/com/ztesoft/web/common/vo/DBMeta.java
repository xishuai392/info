package com.ztesoft.web.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.ztesoft.web.common.db.po.DbMetaPO;

public class DBMeta {
	private Integer id;
	private String dbName;
	private String type;
	private List<DBTable> tables = new ArrayList<DBTable>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<DBTable> getTables() {
		return tables;
	}
	public void setTables(List<DBTable> tables) {
		this.tables = tables;
	}
	
	public void convert(DbMetaPO po){
		po.setDbName(this.getDbName());
		po.setType(this.getType());
	}
}
