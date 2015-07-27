package com.ztesoft.core.db.plugin;


public class SqlServerDialect extends Dialect {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mybatis.extend.interceptor.IDialect#getLimitString(java.lang.String,
	 * int, int)
	 */
	@Override
	public String getLimitString(String sql, int offset, int limit) {
		// order by 加排序字段部分定义
		String ord = "";
		// 字段
		String fields = " ";
		// 重构后sql
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		sql = sql.trim().replace("\n", " ");
		if (sql.toLowerCase().indexOf("order by") >= 0) {
			ord = sql.substring(sql.toLowerCase().indexOf("order by"));
		}
		fields+= sql
				.substring(sql.toLowerCase().indexOf("select"),
						sql.toLowerCase().indexOf(" from ")).toLowerCase()
				.replace(" from ", "");
		pagingSelect
				.append("select * from (SELECT Top (")
				.append(offset * limit)
				.append(" ) ")
				.append(fields.replace(" select ", ""))
				.append(",ROW_NUMBER() OVER  (")
				.append(ord)
				.append(") AS ROWNUMBER ")
				.append(sql.toLowerCase().replace(fields.trim(), ""))
				.append(")as bSysTable where RowNumBer > ")
				.append((offset - 1) * limit).append(" and RowNumBer<= ")
				.append(offset * limit);
		return pagingSelect.toString();
	}

}