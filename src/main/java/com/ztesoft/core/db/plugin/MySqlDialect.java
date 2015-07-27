package com.ztesoft.core.db.plugin;

public class MySqlDialect extends Dialect {

    /*
     * (non-Javadoc)
     * @see org.mybatis.extend.interceptor.IDialect#getLimitString(java.lang.String, int, int)
     */
    @Override
    public String getLimitString(String sql, int offset, int limit) {

        sql = sql.trim();
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

        pagingSelect.append(sql);
        /**
         * 直接用service传过来的 start,limit <br>
         * modify by pan.xiaobo <br>
         * // pagingSelect.append(" limit ").append((offset-1)*limit).append(",").append(limit);
         */
        pagingSelect.append(" limit ").append(offset < 0 ? 0 : offset).append(",").append(limit);
        /**
         * end modify
         */

        return pagingSelect.toString();
    }

}