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

import com.ztesoft.web.common.db.arg.DbTableArg;
import com.ztesoft.web.common.db.arg.DbTableArg.DbTableCriteria;
import com.ztesoft.web.common.db.dao.mapper.IDbTableMapper;
import com.ztesoft.web.common.db.po.DbTablePO;

@Repository
public class DbTableDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(DbTableArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(DbTableArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<DbTablePO> selectByArg(DbTableArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(DbTablePO record, DbTableArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(DbTablePO record, DbTableArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<DbTablePO> selectByArgAndPage(DbTableArg arg,
            Page<DbTablePO> resultPage) {
        List<DbTablePO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(DbTablePO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(DbTablePO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<DbTablePO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public DbTablePO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(DbTablePO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DbTablePO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<DbTablePO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private DbTableArg buildQueryObject(Map<String, Object> params) {

        DbTableArg arg = new DbTableArg();
        DbTableCriteria criteria = arg.createCriteria();

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

    public IDbTableMapper getMapper() {
    	return getSqlSession().getMapper(IDbTableMapper.class);
    }

}
