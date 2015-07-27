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

import com.ztesoft.web.permission.db.arg.AuditMenuRoleArg;
import com.ztesoft.web.permission.db.arg.AuditMenuRoleArg.AuditMenuRoleCriteria;
import com.ztesoft.web.permission.db.dao.mapper.IAuditMenuRoleMapper;
import com.ztesoft.web.permission.db.po.AuditMenuRolePO;

@Repository
public class AuditMenuRoleDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(AuditMenuRoleArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(AuditMenuRoleArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<AuditMenuRolePO> selectByArg(AuditMenuRoleArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(AuditMenuRolePO record, AuditMenuRoleArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(AuditMenuRolePO record, AuditMenuRoleArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<AuditMenuRolePO> selectByArgAndPage(AuditMenuRoleArg arg,
            Page<AuditMenuRolePO> resultPage) {
        List<AuditMenuRolePO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(AuditMenuRolePO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(AuditMenuRolePO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<AuditMenuRolePO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public AuditMenuRolePO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(AuditMenuRolePO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AuditMenuRolePO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<AuditMenuRolePO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private AuditMenuRoleArg buildQueryObject(Map<String, Object> params) {

        AuditMenuRoleArg arg = new AuditMenuRoleArg();
        AuditMenuRoleCriteria criteria = arg.createCriteria();

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

    public IAuditMenuRoleMapper getMapper() {
    	return getSqlSession().getMapper(IAuditMenuRoleMapper.class);
    }

}
