package com.ztesoft.web.common.service;

import java.util.List;
import java.util.Map;

import com.ztesoft.core.common.TreeNode;
import com.ztesoft.core.common.TreePO;
import com.ztesoft.core.common.TreeQueryPO;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.web.common.vo.DBMeta;


public interface IBaseService {
	Map<String,Object> selectOne(String tableName,String idKey);
	
	List<Map<String,Object>> selectList(String tableName,Map<String,Object> conditions);

    List<Map<String,Object>> selectList2(String sqlKey,Map<String,Object> paramMap);
    
	boolean testDBConnection(String driver,String dbName,String characterEncoding,String ip,String port,String params,String username,String password) throws BaseAppException;
	
	DBMeta loadDBMeta(String driver,String dbName,String characterEncoding,String ip,String port,String params,String username,String password);

	boolean saveDBMeta(String driver, String url, String username, String password) throws BaseAppException;

	boolean saveDBMeta(String driver,String dbName,String characterEncoding,String ip,String port,String params,String username,String password) throws BaseAppException;

	TreeNode getTreeAllData(TreePO params, Map<String, Object> root, int path);
	
	TreeNode queryTree(TreeQueryPO reqDto);
//	TreeNode getTreeAllData(String sqlKey, Map<String, Object> root,
//            String valueField, String displayField, int path, String checked,
//            String[] split,Integer deep);
}
