package com.ztesoft.core.db.plugin;

public class OracleDialect extends Dialect{     
    
	   /* (non-Javadoc)   
	     * @see org.mybatis.extend.interceptor.IDialect#getLimitString(java.lang.String, int, int)   
	    */     
	   @Override     
	    public String getLimitString(String sql, int offset, int limit) {     
	     
	          sql = sql.trim();     
	        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);         
	        pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");     
	        pagingSelect.append(" "+ sql).append(" ) row_  where rownum <= ").append((offset+1) * limit).append(") where rownum_ > ").append(offset*limit);     
	            
	       return pagingSelect.toString();   
	   }     
	     
	}   
