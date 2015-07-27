package com.ztesoft.web.common.cache;

import java.util.HashMap;
import java.util.Map;

import com.ztesoft.core.spring.context.CustomPropertyConfigurer;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.util.DBUtils;
import com.ztesoft.web.common.vo.DBMeta;
import com.ztesoft.web.common.vo.DBTable;

public class DBMetaCache {
	
	private static DBMeta meta;
	
	private static Map<String,DBTable> tables = new HashMap<String,DBTable>();
	
	public void init() throws BaseAppException{
		String driver = CustomPropertyConfigurer.getContextProperty("framework.jdbc.driverClassName").toString();
		String url = CustomPropertyConfigurer.getContextProperty("framework.jdbc.url").toString();
		String username = CustomPropertyConfigurer.getContextProperty("framework.jdbc.username").toString();
		String password = CustomPropertyConfigurer.getContextProperty("framework.jdbc.password").toString();
		meta =  DBUtils.loadDBMeta(driver, url, username, password);
		for(DBTable table : meta.getTables()){
			tables.put(table.getTableName().toUpperCase(), table);
		}
	}

	public static DBMeta getMeta() {
		return meta;
	}
	
	public static DBTable getTable(String tableName) {
		return tables.get(tableName);
	}

	public static void setMeta(DBMeta meta) {
		DBMetaCache.meta = meta;
	}
	
}
