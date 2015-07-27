package com.ztesoft.web.cache.db.dao;

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

import com.ztesoft.web.cache.db.arg.AmUserTmpArg;
import com.ztesoft.web.cache.db.arg.AmUserTmpArg.AmUserTmpCriteria;
import com.ztesoft.web.cache.db.dao.mapper.IAmUserTmpMapper;
import com.ztesoft.web.cache.db.po.AmUserTmpPO;

@Repository
public class AmUserTmpDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(AmUserTmpArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(AmUserTmpArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<AmUserTmpPO> selectByArg(AmUserTmpArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(AmUserTmpPO record, AmUserTmpArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(AmUserTmpPO record, AmUserTmpArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<AmUserTmpPO> selectByArgAndPage(AmUserTmpArg arg,
            Page<AmUserTmpPO> resultPage) {
        List<AmUserTmpPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(AmUserTmpPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(AmUserTmpPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<AmUserTmpPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public AmUserTmpPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(AmUserTmpPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AmUserTmpPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<AmUserTmpPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private AmUserTmpArg buildQueryObject(Map<String, Object> params) {

        AmUserTmpArg arg = new AmUserTmpArg();
        AmUserTmpCriteria criteria = arg.createCriteria();

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

    public IAmUserTmpMapper getMapper() {
    	return getSqlSession().getMapper(IAmUserTmpMapper.class);
    }

}
