/**
 * 
 */
package com.ztesoft.core.db.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ztesoft.core.db.dao.mapper.IBaseMapper;
import com.ztesoft.framework.util.StringUtils;

@Repository("baseDao")
public class BaseDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
    
    public List<Map<String,Object>> selectList(String sqlKey,Map<String,Object> params){
    	List<Map<String,Object>> records = super.getSqlSession().selectList(sqlKey, params);
    	return StringUtils.toHump(records);
    }

    public IBaseMapper getMapper() {
        return getSqlSession().getMapper(IBaseMapper.class);
    }
    
    public Map<String,Object> selectOne(Map<String, Object> params){
    	return getMapper().selectOne(params);
    }
    
    public List<Map<String,Object>> selectList(Map<String, Object> params){
    	return getMapper().selectList(params);
    }
    
    public int insert(Map<String, Object> params){
    	return getMapper().insert(params);
    }
    
    public int update(Map<String, Object> params){
    	return getMapper().update(params);
    }
    
    public void delete(Map<String, Object> params){
    	getMapper().delete(params);
    }
}
