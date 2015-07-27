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

import com.ztesoft.web.permission.db.arg.AuditMenuArg;
import com.ztesoft.web.permission.db.arg.AuditMenuArg.AuditMenuCriteria;
import com.ztesoft.web.permission.db.dao.mapper.IAuditMenuMapper;
import com.ztesoft.web.permission.db.po.AuditMenuPO;

@Repository
public class AuditMenuDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(AuditMenuArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(AuditMenuArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<AuditMenuPO> selectByArg(AuditMenuArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(AuditMenuPO record, AuditMenuArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(AuditMenuPO record, AuditMenuArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<AuditMenuPO> selectByArgAndPage(AuditMenuArg arg,
            Page<AuditMenuPO> resultPage) {
        List<AuditMenuPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(AuditMenuPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(AuditMenuPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<AuditMenuPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public AuditMenuPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(AuditMenuPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AuditMenuPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<AuditMenuPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private AuditMenuArg buildQueryObject(Map<String, Object> params) {

        AuditMenuArg arg = new AuditMenuArg();
        AuditMenuCriteria criteria = arg.createCriteria();

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

    public IAuditMenuMapper getMapper() {
    	return getSqlSession().getMapper(IAuditMenuMapper.class);
    }

}
