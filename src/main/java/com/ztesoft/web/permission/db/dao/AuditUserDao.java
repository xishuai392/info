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

import com.ztesoft.web.permission.db.arg.AuditUserArg;
import com.ztesoft.web.permission.db.arg.AuditUserArg.AuditUserCriteria;
import com.ztesoft.web.permission.db.dao.mapper.IAuditUserMapper;
import com.ztesoft.web.permission.db.po.AuditUserPO;

@Repository
public class AuditUserDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(AuditUserArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(AuditUserArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<AuditUserPO> selectByArg(AuditUserArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(AuditUserPO record, AuditUserArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(AuditUserPO record, AuditUserArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<AuditUserPO> selectByArgAndPage(AuditUserArg arg,
            Page<AuditUserPO> resultPage) {
        List<AuditUserPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(AuditUserPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(AuditUserPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<AuditUserPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public AuditUserPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(AuditUserPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AuditUserPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<AuditUserPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private AuditUserArg buildQueryObject(Map<String, Object> params) {

        AuditUserArg arg = new AuditUserArg();
        AuditUserCriteria criteria = arg.createCriteria();

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

    public IAuditUserMapper getMapper() {
    	return getSqlSession().getMapper(IAuditUserMapper.class);
    }

}
