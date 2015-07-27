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

import com.ztesoft.web.common.db.arg.DbMetaArg;
import com.ztesoft.web.common.db.arg.DbMetaArg.DbMetaCriteria;
import com.ztesoft.web.common.db.dao.mapper.IDbMetaMapper;
import com.ztesoft.web.common.db.po.DbMetaPO;

@Repository
public class DbMetaDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(DbMetaArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(DbMetaArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<DbMetaPO> selectByArg(DbMetaArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(DbMetaPO record, DbMetaArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(DbMetaPO record, DbMetaArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<DbMetaPO> selectByArgAndPage(DbMetaArg arg,
            Page<DbMetaPO> resultPage) {
        List<DbMetaPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(DbMetaPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(DbMetaPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<DbMetaPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public DbMetaPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(DbMetaPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DbMetaPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<DbMetaPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private DbMetaArg buildQueryObject(Map<String, Object> params) {

        DbMetaArg arg = new DbMetaArg();
        DbMetaCriteria criteria = arg.createCriteria();

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

    public IDbMetaMapper getMapper() {
    	return getSqlSession().getMapper(IDbMetaMapper.class);
    }

}
