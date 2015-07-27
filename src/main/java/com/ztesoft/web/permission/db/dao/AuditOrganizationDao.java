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

import com.ztesoft.web.permission.db.arg.AuditOrganizationArg;
import com.ztesoft.web.permission.db.arg.AuditOrganizationArg.AuditOrganizationCriteria;
import com.ztesoft.web.permission.db.dao.mapper.IAuditOrganizationMapper;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;

@Repository
public class AuditOrganizationDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(AuditOrganizationArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(AuditOrganizationArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<AuditOrganizationPO> selectByArg(AuditOrganizationArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(AuditOrganizationPO record, AuditOrganizationArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(AuditOrganizationPO record, AuditOrganizationArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<AuditOrganizationPO> selectByArgAndPage(AuditOrganizationArg arg,
            Page<AuditOrganizationPO> resultPage) {
        List<AuditOrganizationPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(AuditOrganizationPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(AuditOrganizationPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<AuditOrganizationPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Long key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public AuditOrganizationPO selectByPrimaryKey(Long key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(AuditOrganizationPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AuditOrganizationPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<AuditOrganizationPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private AuditOrganizationArg buildQueryObject(Map<String, Object> params) {

        AuditOrganizationArg arg = new AuditOrganizationArg();
        AuditOrganizationCriteria criteria = arg.createCriteria();

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

    public IAuditOrganizationMapper getMapper() {
    	return getSqlSession().getMapper(IAuditOrganizationMapper.class);
    }

}
