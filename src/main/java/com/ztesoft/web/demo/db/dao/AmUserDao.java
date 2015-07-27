package com.ztesoft.web.demo.db.dao;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ztesoft.core.common.Page;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.util.StringUtils;
import com.ztesoft.web.demo.db.arg.AmUserArg;
import com.ztesoft.web.demo.db.arg.AmUserArg.AmUserCriteria;
import com.ztesoft.web.demo.db.dao.mapper.IAmUserMapper;
import com.ztesoft.web.demo.db.po.AmUserPO;

@Repository
public class AmUserDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(AmUserArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(AmUserArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<AmUserPO> selectByArg(AmUserArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(AmUserPO record, AmUserArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(AmUserPO record, AmUserArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<AmUserPO> selectByArgAndPage(AmUserArg arg,
            Page<AmUserPO> resultPage) {
        List<AmUserPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(AmUserPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(AmUserPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<AmUserPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(Integer key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public AmUserPO selectByPrimaryKey(Integer key) {
        return getMapper().selectByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(AmUserPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(AmUserPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<AmUserPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private AmUserArg buildQueryObject(Map<String, Object> params) {

        AmUserArg arg = new AmUserArg();
        AmUserCriteria criteria = arg.createCriteria();

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

    public IAmUserMapper getMapper() {
        return getSqlSession().getMapper(IAmUserMapper.class);
    }

}
