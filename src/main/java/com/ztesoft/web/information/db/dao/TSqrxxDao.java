package com.ztesoft.web.information.db.dao;

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

import com.ztesoft.web.information.db.arg.TSqrxxArg;
import com.ztesoft.web.information.db.arg.TSqrxxArg.TSqrxxCriteria;
import com.ztesoft.web.information.db.dao.mapper.ITSqrxxMapper;
import com.ztesoft.web.information.db.po.TSqrxxPO;

@Repository
public class TSqrxxDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(TSqrxxArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(TSqrxxArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<TSqrxxPO> selectByArg(TSqrxxArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(TSqrxxPO record, TSqrxxArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(TSqrxxPO record, TSqrxxArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<TSqrxxPO> selectByArgAndPage(TSqrxxArg arg,
            Page<TSqrxxPO> resultPage) {
        List<TSqrxxPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(TSqrxxPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(TSqrxxPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<TSqrxxPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(String key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public TSqrxxPO selectByPrimaryKey(String key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(TSqrxxPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSqrxxPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<TSqrxxPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private TSqrxxArg buildQueryObject(Map<String, Object> params) {

        TSqrxxArg arg = new TSqrxxArg();
        TSqrxxCriteria criteria = arg.createCriteria();

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

    public ITSqrxxMapper getMapper() {
    	return getSqlSession().getMapper(ITSqrxxMapper.class);
    }

}
