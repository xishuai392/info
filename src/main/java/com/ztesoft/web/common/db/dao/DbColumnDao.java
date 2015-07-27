package com.ztesoft.web.common.db.dao;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.util.StringUtils;

import com.ztesoft.web.common.db.arg.DbColumnArg;
import com.ztesoft.web.common.db.arg.DbColumnArg.DbColumnCriteria;
import com.ztesoft.web.common.db.dao.mapper.IDbColumnMapper;
import com.ztesoft.web.common.db.po.DbColumnPO;

@Repository
public class DbColumnDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(DbColumnArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(DbColumnArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<DbColumnPO> selectByArg(DbColumnArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(DbColumnPO record, DbColumnArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(DbColumnPO record, DbColumnArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<DbColumnPO> selectByArgAndPage(DbColumnArg arg,
            Page<DbColumnPO> resultPage) {
        List<DbColumnPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(DbColumnPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(DbColumnPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<DbColumnPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public DbColumnPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(DbColumnPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DbColumnPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<DbColumnPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private DbColumnArg buildQueryObject(Map<String, Object> params) {

        DbColumnArg arg = new DbColumnArg();
        DbColumnCriteria criteria = arg.createCriteria();

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

    public IDbColumnMapper getMapper() {
    	return getSqlSession().getMapper(IDbColumnMapper.class);
    }

}
