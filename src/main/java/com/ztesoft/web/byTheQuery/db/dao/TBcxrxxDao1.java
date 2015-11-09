package com.ztesoft.web.byTheQuery.db.dao;

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

import com.ztesoft.web.byTheQuery.db.arg.TBcxrxxArg;
import com.ztesoft.web.byTheQuery.db.arg.TBcxrxxArg.TBcxrxxCriteria;
import com.ztesoft.web.byTheQuery.db.dao.mapper.ITBcxrxxMapper;
import com.ztesoft.web.byTheQuery.db.po.TBcxrxxPO;

@Repository
public class TBcxrxxDao1 extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(TBcxrxxArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(TBcxrxxArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<TBcxrxxPO> selectByArg(TBcxrxxArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(TBcxrxxPO record, TBcxrxxArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(TBcxrxxPO record, TBcxrxxArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<TBcxrxxPO> selectByArgAndPage(TBcxrxxArg arg,
            Page<TBcxrxxPO> resultPage) {
        List<TBcxrxxPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }
    
    public Page<TBcxrxxPO> select4Page(TBcxrxxPO record,
            Page<TBcxrxxPO> resultPage) {
        List<TBcxrxxPO> resultList = getMapper().select4Page(record,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(TBcxrxxPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(TBcxrxxPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<TBcxrxxPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(String key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public TBcxrxxPO selectByPrimaryKey(String key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(TBcxrxxPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TBcxrxxPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<TBcxrxxPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private TBcxrxxArg buildQueryObject(Map<String, Object> params) {

        TBcxrxxArg arg = new TBcxrxxArg();
        TBcxrxxCriteria criteria = arg.createCriteria();

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

    public ITBcxrxxMapper getMapper() {
    	return getSqlSession().getMapper(ITBcxrxxMapper.class);
    }

}
