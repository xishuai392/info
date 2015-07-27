/**
 * 
 */
package com.ztesoft.core.db.plugin;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.db.plugin <br>
 */

public class InformixDialect extends Dialect {

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.db.plugin.Dialect#getLimitString(java.lang.String, int, int)
     */
    @Override
    public String getLimitString(String sql, int skipResults, int maxResults) {
        sql = sql.trim();
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

        pagingSelect.append(" SELECT SKIP ")
                .append(skipResults < 0 ? 0 : skipResults).append(" FIRST ")
                .append(maxResults).append(" * FROM ( ");
        pagingSelect.append(sql);
        pagingSelect.append(" ) ");
        return pagingSelect.toString();
    }

}
