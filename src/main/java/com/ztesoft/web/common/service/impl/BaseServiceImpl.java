/**
 * 
 */
package com.ztesoft.web.common.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.core.common.QueryCondition;
import com.ztesoft.core.common.QueryCondition.ConditionOperation;
import com.ztesoft.core.common.TreeNode;
import com.ztesoft.core.common.TreePO;
import com.ztesoft.core.common.TreeQueryPO;
import com.ztesoft.core.common.TreeSortComparator;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.db.dao.BaseDao;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DBUtils;
import com.ztesoft.framework.util.JsonUtil;
import com.ztesoft.framework.util.StringUtils;
import com.ztesoft.web.common.db.arg.DbColumnArg;
import com.ztesoft.web.common.db.arg.DbMetaArg;
import com.ztesoft.web.common.db.arg.DbTableArg;
import com.ztesoft.web.common.db.dao.DbColumnDao;
import com.ztesoft.web.common.db.dao.DbMetaDao;
import com.ztesoft.web.common.db.dao.DbTableDao;
import com.ztesoft.web.common.db.po.DbColumnPO;
import com.ztesoft.web.common.db.po.DbMetaPO;
import com.ztesoft.web.common.db.po.DbTablePO;
import com.ztesoft.web.common.service.IBaseService;
import com.ztesoft.web.common.vo.DBColumn;
import com.ztesoft.web.common.vo.DBMeta;
import com.ztesoft.web.common.vo.DBTable;
import com.ztesoft.web.domain.TableInfoConstants;

@Service
public class BaseServiceImpl implements IBaseService {

	private static final ZTEsoftLogManager logger = ZTEsoftLogManager.getLogger(BaseServiceImpl.class);

	@Autowired
	private BaseDao baseDao;
	@Autowired
	private DbMetaDao dbMetaDao;
	@Autowired
	private DbTableDao dbTableDao;
	@Autowired
	private DbColumnDao dbColumnDao;

	/**
	 * 查询条件转换成Arg类的服务接口
	 */
	@Resource(name = "defaultArgConversionService")
	private IArgConversionService argConversionService;

	/**
	 * 主键生成器
	 */
	@Resource(name = "sequenceProcGenerator")
	private ISequenceGenerator sequenceGenerator;

	@Override
	public Map<String, Object> selectOne(String tableName, String idKey) {
		logger.debug("load table {0},by idKey[{1}]", tableName, idKey);
		return baseDao.selectOne(null);
	}

	@Override
	public List<Map<String, Object>> selectList(String tableName, Map<String, Object> conditions) {
		logger.debug("load table {0},by conditions[{1}]", tableName, conditions);
		conditions.put("sql", DBUtils.getSelectListSql(tableName.toUpperCase(), conditions.keySet()));
		return baseDao.selectList(conditions);
	}

	@Override
	public List<Map<String, Object>> selectList2(String sqlKey, Map<String, Object> paramMap) {
		logger.debug("load table {0},by conditions[{1}]", sqlKey, paramMap);
		return baseDao.selectList(sqlKey, paramMap);
	}

	public boolean testDBConnection(String driver, String dbName, String characterEncoding, String ip, String port,
			String params, String username, String password) throws BaseAppException {
		StringBuffer url = new StringBuffer("jdbc:");
		if (driver.toLowerCase().contains("mysql")) {
			url.append("mysql://").append(ip).append(":").append(port).append("/").append(dbName)
					.append("?characterEncoding=").append(characterEncoding).append("&").append(params);
		} else {
			url.append("oracle:thin:@").append(ip).append(":").append(port).append(":").append(dbName);
		}

		return DBUtils.testDBConnection(driver, url.toString(), username, password);
	}

	public DBMeta loadDBMeta(String driver, String dbName, String characterEncoding, String ip, String port,
			String params, String username, String password) {
		StringBuffer url = new StringBuffer("jdbc:");
		if (driver.toLowerCase().contains("mysql")) {
			url.append("mysql://").append(ip).append(":").append(port).append("/").append(dbName)
					.append("?characterEncoding=").append(characterEncoding).append("&").append(params);
		} else {
			url.append("oracle:thin:@").append(ip).append(":").append(port).append(":").append(dbName);
		}

		return DBUtils.loadDBMeta(driver, url.toString(), username, password);
	}

	public boolean saveDBMeta(String driver, String dbName, String characterEncoding, String ip, String port,
			String params, String username, String password) throws BaseAppException {
		StringBuffer url = new StringBuffer("jdbc:");
		if (driver.toLowerCase().contains("mysql")) {
			url.append("mysql://").append(ip).append(":").append(port).append("/").append(dbName)
					.append("?characterEncoding=").append(characterEncoding).append("&").append(params);
		} else {
			url.append("oracle:thin:@").append(ip).append(":").append(port).append(":").append(dbName);
		}

		return saveDBMeta(driver, url.toString(), username, password);
	}

	public boolean saveDBMeta(String driver, String url, String username, String password) throws BaseAppException {
		DBMeta meta = DBUtils.loadDBMeta(driver, url.toString(), username, password);

		int dbId = sequenceGenerator.sequenceIntValue(TableInfoConstants.DB_META, TableInfoConstants.DB_META_PKFIELD);

		DbMetaPO metaPo = new DbMetaPO();
		meta.convert(metaPo);
		metaPo.setId(dbId);
		dbMetaDao.deleteByArg(new DbMetaArg());
		dbTableDao.deleteByArg(new DbTableArg());
		dbColumnDao.deleteByArg(new DbColumnArg());

		dbMetaDao.insert(metaPo);
		List<DbTablePO> tables = new ArrayList<DbTablePO>();
		List<DbColumnPO> columns = new ArrayList<DbColumnPO>();
		for (DBTable table : meta.getTables()) {
			DbTablePO tablePo = new DbTablePO();
			table.convert(tablePo);
			tablePo.setDbId(dbId);
			int tableId = sequenceGenerator.sequenceIntValue(TableInfoConstants.DB_TABLE,
					TableInfoConstants.DB_TABLE_PKFIELD);
			tablePo.setId(tableId);
			tables.add(tablePo);
			for (DBColumn column : table.getColumns()) {
				DbColumnPO columnPo = new DbColumnPO();
				column.convert(columnPo);
				int columnId = sequenceGenerator.sequenceIntValue(TableInfoConstants.DB_COLUMN,
						TableInfoConstants.DB_COLUMN_PKFIELD);
				columnPo.setTableId(tableId);
				columnPo.setId(columnId);
				columns.add(columnPo);
			}
		}
		dbTableDao.insertBatch(tables);
		dbColumnDao.insertBatch(columns);
		return true;
	}

	public TreeNode getTreeAllData(TreePO params, Map<String, Object> obj, int path) {
		path++;
		Integer deep = params.getDeep();
		String checked = params.getChecked();
		String[] icons = params.getIcons();
		TreeNode node = new TreeNode();
		node.setText(obj.get(params.getDisplayField()) + "");
		node.setId(obj.get(params.getValueField()) + "");
		if (!StringUtils.isEmpty(params.getCheckField())) {
			boolean checkField = false;
			if (!StringUtils.isEmpty(obj.get(params.getCheckField()))) {
				checkField = true;
			}
			obj.put("fieldChecked", checkField);
		}
		node.setAttributeMap(obj);
		if (path >= deep) {
			if (obj.containsKey("expandable")) {
				node.setExpandable(Boolean.parseBoolean(obj.get("expandable") + ""));
			} else {
				node.setExpandable(true);
			}
			node.setExpanded(false);
		} else {
			List<TreeNode> childs = new ArrayList<TreeNode>();
			node.setChildren(childs);
			Map<String, Object> req = null;
			if (!StringUtils.isEmpty(params.getParamData())) {
				req = new HashMap<String, Object>();
				req.putAll(obj);
				req.putAll(params.getParamData());
			} else {
				req = obj;
			}
			List<Map<String, Object>> fields = baseDao.selectList(params.getSqlKey(), req);
			if (fields.size() == 0) {
				node.setLeaf(true);
			} else {
				node.setExpandable(true);
				node.setExpanded(true);
			}
			for (Map<String, Object> field : fields) {
				childs.add(getTreeAllData(params, field, path));
			}
		}
		if (!StringUtils.isEmpty(checked)) {
//			if (checked.indexOf(",") != -1) {
//				for (String d : checked.split(",")) {
//					if (path == Integer.parseInt(d))
//						node.setChecked(false);
//				}
//			} else {
//				node.setChecked(false);
//			}
			if (!StringUtils.isEmpty(params.getCheckField())) {
			    if (!StringUtils.isEmpty(obj.get(params.getCheckField()))) {
			        if(Boolean.TRUE==Boolean.valueOf(String.valueOf(obj.get(params.getCheckField())))){
			            node.setChecked(true);
			        }else{
			            node.setChecked(false);
			        }
			        
	            }else{
	                
	            }
			}
		}
		if (icons.length > path) {
			node.setIcon(icons[path]);
		}
		if (obj.containsKey("icon") && !StringUtils.isEmpty(obj.get("icon"))) {
			node.setIcon(obj.get("icon").toString());
		} else if (!StringUtils.isEmpty(params.getIcon())) {
			node.setIcon(params.getIcon());
		}
		return node;
	}

	public TreeNode queryTree(TreeQueryPO reqDto) {
		Map<String, List<Map<String, Object>>> parents = new HashMap<String, List<Map<String, Object>>>();
		List<String> ids = new ArrayList<String>();
		String queryConditions = reqDto.getQueryConditions();
		List<QueryCondition> queryConditionsList = JsonUtil.toList(queryConditions, QueryCondition.class);
		Map<String, Object> conditions = DBUtils.getSelectListSql(reqDto.getTableName(), queryConditionsList);
		TreeSortComparator comparator = null;
		String sql = (String) conditions.get("sql");
		// if(!StringUtils.isEmpty(reqDto.getGroupByClause())){
		// sql += " group by " + reqDto.getGroupByClause();
		// }
		String orderByClause = reqDto.getOrderByClause();
		if (!StringUtils.isEmpty(orderByClause)) {
			sql += " order by " + orderByClause;
			comparator = new TreeSortComparator();
			Map<String, Boolean> orderByClauses = comparator.getOrderByClauses();
			String[] orders = orderByClause.split(",");
			for (int i = 0; i < orders.length; i++) {
				String[] order = orders[i].trim().split("\\s+");
				String key = StringUtils.toHump(order[0]);
				boolean value = false;
				if (order.length == 2 && order[1].toLowerCase().equals("desc")) {
					value = true;
				}
				orderByClauses.put(key, value);
			}
		}
		conditions.put("sql", sql);
		List<Map<String, Object>> datas = baseDao.selectList(conditions);
		List<String> pks = new ArrayList<String>();
		setParentDatas(datas, parents, ids, pks, reqDto, true);
		if (ids.size() > 0) {
			queryParents(parents, ids, pks, reqDto);
		}
		TreeNode node = new TreeNode();
		node.setId(reqDto.getRootId());
		node.setText(reqDto.getRootText());
		node.setLeaf(true);
		if (!StringUtils.isEmpty(reqDto.getIcon())) {
			node.setIcon(reqDto.getIcon());
		}
		if (parents.size() > 0) {
			node.setLeaf(false);
			setChildren(node, parents, reqDto, comparator);
			return node;
		}
		return node;
	}

	public void queryParents(Map<String, List<Map<String, Object>>> parents, List<String> ids, List<String> pks,
			TreeQueryPO reqDto) {
		QueryCondition condition = new QueryCondition();
		condition.setParamName(reqDto.getValueField());
		condition.setParamValue(ids.toArray(new String[0]));
		condition.setOperation(ConditionOperation.In);
		List<QueryCondition> queryConditionsList = new ArrayList<QueryCondition>(1);
		queryConditionsList.add(condition);
		Map<String, Object> conditions = DBUtils.getSelectListSql(reqDto.getTableName(), queryConditionsList);
		List<Map<String, Object>> datas = baseDao.selectList(conditions);
		ids.clear();
		setParentDatas(datas, parents, ids, pks, reqDto, false);
		if (ids.size() > 0) {
			queryParents(parents, ids, pks, reqDto);
		}
	}

	private void setChildren(TreeNode node, Map<String, List<Map<String, Object>>> datas, TreeQueryPO reqDto,
			TreeSortComparator comparator) {
		String id = node.getId();
		List<Map<String, Object>> children = datas.get(id);
		if (children == null || children.size() == 0) {
			node.setExpandable(false);
			node.setLeaf(true);
			return;
		}
		List<TreeNode> childs = new ArrayList<TreeNode>();
		if (comparator != null) {
			Collections.sort(children, comparator);
		}
		int size = children.size();
		for (int i = 0; i < size; i++) {
			Map<String, Object> data = children.get(i);
			TreeNode nodeTemp = new TreeNode();
			nodeTemp.setId(data.get(reqDto.getValueField()) + "");
			nodeTemp.setText(data.get(reqDto.getDisplayField()) + "");
			nodeTemp.setAttributeMap(data);
			if (!StringUtils.isEmpty(reqDto.getIcon())) {
				nodeTemp.setIcon(reqDto.getIcon());
			}
			setChildren(nodeTemp, datas, reqDto, comparator);
			childs.add(nodeTemp);
		}
		node.setChildren(childs);
	}

	private void setParentDatas(List<Map<String, Object>> datas, Map<String, List<Map<String, Object>>> parents,
			List<String> ids, List<String> pks, TreeQueryPO reqDto, boolean isFirst) {
		for (int i = 0; i < datas.size(); i++) {
			Map<String, Object> data = datas.get(i);
			String id = data.get(reqDto.getParentField()).toString();
			if (isFirst) {
				String pk = data.get(reqDto.getValueField()).toString();
				pks.add(pk);
			}
			if (parents.containsKey(id)) {
				parents.get(id).add(data);
			} else {
				List<Map<String, Object>> temp = new ArrayList<Map<String, Object>>();
				temp.add(data);
				parents.put(id, temp);
				if (!id.equals(reqDto.getRootId())) {
					ids.add(id);
				}
			}
		}
		// 由于第一次查询时有可能会同时查到父节点和子节点，因此需要把已经找到的父节点去掉
		if (ids.size() > 0) {
			for (int i = 0; i < pks.size(); i++) {
				String pk = pks.get(i);
				if (ids.contains(pk)) {
					ids.remove(pk);
				}
			}
		}
	}
}
