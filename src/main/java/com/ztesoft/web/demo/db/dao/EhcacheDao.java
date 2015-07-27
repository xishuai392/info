package com.ztesoft.web.demo.db.dao;

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

import com.ztesoft.web.demo.db.arg.EhcacheArg;
import com.ztesoft.web.demo.db.arg.EhcacheArg.EhcacheCriteria;
import com.ztesoft.web.demo.db.dao.mapper.IEhcacheMapper;
import com.ztesoft.web.demo.db.po.EhcachePO;

@Repository
public class EhcacheDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(EhcacheArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(EhcacheArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<EhcachePO> selectByArg(EhcacheArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(EhcachePO record, EhcacheArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(EhcachePO record, EhcacheArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<EhcachePO> selectByArgAndPage(EhcacheArg arg,
            Page<EhcachePO> resultPage) {
        List<EhcachePO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(EhcachePO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(EhcachePO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<EhcachePO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public EhcachePO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(EhcachePO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(EhcachePO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<EhcachePO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private EhcacheArg buildQueryObject(Map<String, Object> params) {

        EhcacheArg arg = new EhcacheArg();
        EhcacheCriteria criteria = arg.createCriteria();

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

    public IEhcacheMapper getMapper() {
    	return getSqlSession().getMapper(IEhcacheMapper.class);
    }

}
