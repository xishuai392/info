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

import com.ztesoft.web.information.db.arg.CxrzArg;
import com.ztesoft.web.information.db.arg.CxrzArg.CxrzCriteria;
import com.ztesoft.web.information.db.dao.mapper.ICxrzMapper;
import com.ztesoft.web.information.db.po.CxrzPO;

@Repository
public class CxrzDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(CxrzArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(CxrzArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<CxrzPO> selectByArg(CxrzArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(CxrzPO record, CxrzArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(CxrzPO record, CxrzArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<CxrzPO> selectByArgAndPage(CxrzArg arg,
            Page<CxrzPO> resultPage) {
        List<CxrzPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(CxrzPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(CxrzPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<CxrzPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(String key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public CxrzPO selectByPrimaryKey(String key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(CxrzPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(CxrzPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<CxrzPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private CxrzArg buildQueryObject(Map<String, Object> params) {

        CxrzArg arg = new CxrzArg();
        CxrzCriteria criteria = arg.createCriteria();

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

    public ICxrzMapper getMapper() {
    	return getSqlSession().getMapper(ICxrzMapper.class);
    }

}
