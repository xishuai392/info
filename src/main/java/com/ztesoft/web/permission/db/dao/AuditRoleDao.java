package com.ztesoft.web.permission.db.dao;

import java.lang.reflect.Method;
import java.math.*;
import java.util.*;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.util.StringUtils;

import com.ztesoft.web.permission.db.arg.AuditRoleArg;
import com.ztesoft.web.permission.db.arg.AuditRoleArg.AuditRoleCriteria;
import com.ztesoft.web.permission.db.dao.mapper.IAuditRoleMapper;
import com.ztesoft.web.permission.db.po.AuditRolePO;

@Repository
public class AuditRoleDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(AuditRoleArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(AuditRoleArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<AuditRolePO> selectByArg(AuditRoleArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(AuditRolePO record, AuditRoleArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(AuditRolePO record, AuditRoleArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<AuditRolePO> selectByArgAndPage(AuditRoleArg arg,
            Page<AuditRolePO> resultPage) {
        List<AuditRolePO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(AuditRolePO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(AuditRolePO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<AuditRolePO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public AuditRolePO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(AuditRolePO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AuditRolePO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<AuditRolePO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private AuditRoleArg buildQueryObject(Map<String, Object> params) {

        AuditRoleArg arg = new AuditRoleArg();
        AuditRoleCriteria criteria = arg.createCriteria();

        Class criteriaClass = criteria.getClass();
        Set keys = params.keySet();

        if (keys != null) {

            Iterator iterator = keys.iterator();

            while (iterator.hasNext()) {

                Object key = iterator.next();
                Object value = params.get(key);
                for (Method method : criteriaClass.getMethods()) {
                    if (method.getName().equals(
                            "and"+ StringUtils.toUpperCaseFirstOne(key.toString()) + "EqualTo")) {
                        try {
                            method.invoke(criteria, value);
                        }
                        catch (Exception e) {
                            throw new SysRuntimeException(e);
                        }
                        break;
                    }
                }
            }
        }
        return arg;
    }

    public IAuditRoleMapper getMapper() {
    	return getSqlSession().getMapper(IAuditRoleMapper.class);
    }

}
