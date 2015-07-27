package com.ztesoft.framework.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ztesoft.core.common.QueryCondition;
import com.ztesoft.core.common.QueryCondition.ConditionOperation;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.common.cache.DBMetaCache;
import com.ztesoft.web.common.vo.DBColumn;
import com.ztesoft.web.common.vo.DBMeta;
import com.ztesoft.web.common.vo.DBTable;

public class DBUtils {
    public static Pattern pattern = Pattern.compile("(\\{.*?\\})");
    public static Pattern wordPattern=Pattern.compile(":(\\$*\\w+)",Pattern.CASE_INSENSITIVE);//java变量
//    public static Pattern optPattern=Pattern.compile(":(\\$*\\w+Opt)",Pattern.CASE_INSENSITIVE);//以Opt结尾的变量
    public static String split=":";
    public static Map<String, String> filterMap=new HashMap<String,String>();
    static{
        filterMap.put("YYYY-MM-DD HH:MM:SS", "");
        filterMap.put("YYYY-MM-DD HH12:MM:SS", "");
        filterMap.put("YYYY-MM-DD HH24:MM:SS", "");
    }
//	private static String getPageSql(String sql,Page page){
//		String dbType=Constants.getContextProperty("dbType").toString();
//		StringBuffer paginationSQL=new StringBuffer(sql.length()+100);
//		if(dbType.equals("oracle")){
//			paginationSQL.append(" SELECT * FROM ( ");
//			paginationSQL.append(" SELECT TEMP.* ,ROWNUM NUM FROM ( ");
//			paginationSQL.append(sql);
//			paginationSQL.append(") TEMP)");
//			paginationSQL.append("  WHERE NUM > " + page.getStart()+" AND NUM<="+(page.getLimit()+page.getStart()));
//		}else if(dbType.equals("mysql")){
//			paginationSQL.append("SELECT " +sql.substring(6) +" LIMIT "+ page.getStart()+" , " +page.getLimit());
//		}else{
//			paginationSQL.append("SELECT "+" SKIP "+page.getStart()+" FIRST " +page.getLimit()+sql.substring(6));
//		}
//		return paginationSQL.toString();
//	}
//	private static String getCountSql(String sql){
//		return "select count(*) count from ("+sql+") t";
//	}
	
	public static String getSelectListSql(String tableName,Set<String> conditions){
		DBTable table = DBMetaCache.getTable(tableName);
		StringBuffer sb = new StringBuffer("select ");
		for(DBColumn column : table.getColumns()){
			sb.append(column.getName()+" as \""+StringUtils.toHump(column.getName())).append("\"");
			if(table.getColumns().indexOf(column)<table.getColumns().size()-1){
				sb.append(",");
			}
			else{
				sb.append(" ");
			}
		}
		sb.append(" from "+tableName);
		
		if(conditions.size()>0){
			sb.append(" where ");
			int index = 0;
			for(String field : conditions){
				sb.append(StringUtils.toDBString(field)+"=#{"+field+"} ");
				if(index++<conditions.size()-1){
					sb.append(" and ");
				}
			}
		}
		return sb.toString();
	}
	
	public static Map<String,Object> getSelectListSql(String tableName,List<QueryCondition> conditions){
	    Map<String,Object> params = new HashMap<String, Object>();
        DBTable table = DBMetaCache.getTable(tableName);
        StringBuffer sb = new StringBuffer("select ");
        for(DBColumn column : table.getColumns()){
            sb.append(column.getName()+" as \""+StringUtils.toHump(column.getName())).append("\"");
            if(table.getColumns().indexOf(column)<table.getColumns().size()-1){
                sb.append(",");
            }
            else{
                sb.append(" ");
            }
        }
        sb.append(" from "+tableName+" A ");
        
        int size = conditions.size();
        if(size>0){
            sb.append(" where ");
            for (int i = 0; i < size; i++) {
                QueryCondition condition = conditions.get(i);
                sb.append(StringUtils.toDBString(condition.getParamName())).append(paraseParamValue(condition,params));
                if(i < size-1){
                    sb.append(" and ");
                }
            }
        }
        params.put("sql", sb.toString());
        return params;
    }
	
	public static String paraseParamValue(QueryCondition condition,Map<String,Object> params){
	    ConditionOperation operation = condition.getOperation();
	    StringBuffer sb = new StringBuffer();
	    switch (operation) {
            case IsNull:
                sb.append(" is null ");
                break;
            case IsNotNull:
                sb.append(" is not null ");
                break;
            case EqualTo:
                sb.append(" =#{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), condition.getParamValue()[0]);
                break;
            case NotEqualTo:
                sb.append(" <>#{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), condition.getParamValue()[0]);
                break;
            case GreaterThan:
                sb.append(" >#{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), condition.getParamValue()[0]);
                break;
            case GreaterThanOrEqualTo:
                sb.append(" >=#{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), condition.getParamValue()[0]);
                break;
            case LessThan:
                sb.append(" <#{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), condition.getParamValue()[0]);
                break;
            case LessThanOrEqualTo:
                sb.append(" <=#{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), condition.getParamValue()[0]);
                break;
            case Like:
                sb.append(" like #{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), "%" + condition.getParamValue()[0] + "%");
                break;
            case NotLike:
                sb.append(" not like #{").append(condition.getParamName()).append("} ");
                params.put(condition.getParamName(), "%" + condition.getParamValue()[0] + "%");
                break;
            case In:
                sb.append(" in ").append(StringUtils.getQryCondtion(condition.getParamValue(), false)).append(" ");
                break;
            case NotIn:
                sb.append(" not in ").append(StringUtils.getQryCondtion(condition.getParamValue(), false)).append(" ");
                break;
            default:
                sb.append(condition.getParamName());
                break;
        }
	    return sb.toString();
	}
	public static boolean testDBConnection(String driver,String url,String username,String password) throws BaseAppException{
		Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseAppException("数据库连接异常");
        } finally {
            try {
                if (null != conn) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
	}
	
	public static DBMeta loadDBMeta(String driver,String url,String username,String password){
		DBMeta meta = new DBMeta();
		Map<String, String> fkTableNamesAndPk = new HashMap<String, String>();
		Connection conn = null;
        DatabaseMetaData metaData = null;
        ResultSet rs = null;
        ResultSet crs = null;
        try {
            Class.forName(driver);
            Properties props =new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);
            props.setProperty("remarks", "true"); //设置可以获取remarks信息 
            props.setProperty("useInformationSchema", "true");//设置可以获取tables remarks信息
            conn = DriverManager.getConnection(url,props);
            String catalog = conn.getCatalog(); // catalog 其实也就是数据库名
            metaData = conn.getMetaData();
            meta.setDbName(catalog);
            // 获取表
            rs = metaData.getTables(null, username.toUpperCase(), "%", new String[] { "TABLE" });
            while (rs.next()) {
            	DBTable table = new DBTable();
            	meta.getTables().add(table);
                String tablename = rs.getString("TABLE_NAME");
                String tremarks = rs.getString("REMARKS");
                table.setTableName(tablename);
                table.setRemarks(tremarks);
                // 获取当前表的列
                crs = metaData.getColumns(null, "%", tablename, "%");
                ResultSet pks = metaData.getPrimaryKeys(catalog, null, tablename);
                while(pks.next()){
                	table.getPks().add(pks.getString("COLUMN_NAME"));
                }
                // 获取被引用的表，它的主键就是当前表的外键 
                fkTableNamesAndPk.clear();
                ResultSet foreignKeyResultSet = metaData.getImportedKeys(catalog, null, tablename);
                while (foreignKeyResultSet.next()) {
                    String pkTablenName = foreignKeyResultSet.getString("PKTABLE_NAME"); // 外键表
                    String fkColumnName = foreignKeyResultSet.getString("FKCOLUMN_NAME"); // 外键
                    if (!fkTableNamesAndPk.containsKey(fkColumnName))
                        fkTableNamesAndPk.put(fkColumnName, pkTablenName);
                    table.getFks().add(fkColumnName);
                }
                while (crs.next()) {
                	DBColumn column = new DBColumn();
                	table.getColumns().add(column);
                    String columnname = crs.getString("COLUMN_NAME");
                    String columntype = crs.getString("TYPE_NAME");
                    String remarks = crs.getString("REMARKS");
                    for(String key : table.getPks()){
                    	if(columnname.equals(key)){
                    		column.setKeyType("pk");
                    	}
                    }
                    for(String key : table.getFks()){
                    	if(columnname.equals(key)){
                    		column.setKeyType("fk");
                    	}
                    }
                    int nullAble = crs.getInt("NULLABLE");
                    int size = crs.getInt("COLUMN_SIZE");
                    String defaultValue = crs.getString("COLUMN_DEF");
                    column.setName(columnname);
                    column.setType(columntype);
                    column.setRemarks(remarks);
                    column.setDefaultValue(defaultValue);
                    column.setSize(size);
                    column.setNullAble(nullAble);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }
                if (null != conn) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
		return meta;
	}

    public static String getFormatSql(String originalSql,Map<String,Object> paramMap){
        List<String> paramList=new ArrayList<String>();
        Pattern filterPattern;
        Matcher matcher=pattern.matcher(originalSql);
        String returnSql=null;
        returnSql=originalSql;
        while(matcher.find()){
            paramList.add(matcher.group(1));
        }
        for (int i = 0; i < paramList.size(); i++) {//空变量替换
            Iterator<String> keyIt=filterMap.keySet().iterator();
            String matchStr=paramList.get(i);
            while (keyIt.hasNext()) {
                String key = (String) keyIt.next();
                if(matchStr.toUpperCase().contains(key.toUpperCase())){
                    filterPattern=Pattern.compile("("+key+")",Pattern.CASE_INSENSITIVE);
                    Matcher filterMatcher=filterPattern.matcher(matchStr);
                    while(filterMatcher.find()){
                        String matchWord=filterMatcher.group(1);
                        matchStr=matchStr.replace(matchWord, "");
                    }
                }
            }
            if(paramMap == null || paramMap.isEmpty()){
                returnSql=returnSql.replace(paramList.get(i), "");
            }else{
                Matcher wordMatcher=wordPattern.matcher(matchStr);
                while(wordMatcher.find()){
                    String matchWord=wordMatcher.group(1);
                    if(StringUtils.isEmpty(paramMap.get(matchWord))){
                        returnSql=returnSql.replace(paramList.get(i), "");
                    }else{
                        returnSql=returnSql.replace(split+matchWord, "'"+paramMap.get(matchWord).toString()+"'");
                    }
                }
            }
        }
//        Matcher optMatcher=optPattern.matcher(returnSql);//操作符变量替换
//        while(optMatcher.find()){
//            String matchWord=optMatcher.group(1);
//            returnSql=returnSql.replace(split+matchWord, paramMap.get(matchWord).toString());
//        }
        returnSql=returnSql.replaceAll("\\{", "");
        returnSql=returnSql.replaceAll("\\}", "");
        return returnSql;
    }
    
}
