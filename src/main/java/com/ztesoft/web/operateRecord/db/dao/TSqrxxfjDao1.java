package com.ztesoft.web.operateRecord.db.dao;

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

import com.ztesoft.web.operateRecord.db.arg.TSqrxxfjArg;
import com.ztesoft.web.operateRecord.db.arg.TSqrxxfjArg.TSqrxxfjCriteria;
import com.ztesoft.web.operateRecord.db.dao.mapper.ITSqrxxfjMapper;
import com.ztesoft.web.operateRecord.db.po.TSqrxxfjPO;

@Repository
public class TSqrxxfjDao1 extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<Integer> countByArg(TSqrxxfjArg arg) {
        return getMapper().countByArg(arg);
    }

    public int deleteByArg(TSqrxxfjArg arg) {
        return getMapper().deleteByArg(arg);
    }

    public List<TSqrxxfjPO> selectByArg(TSqrxxfjArg arg) {
        return getMapper().selectByArg(arg);
    }

    public int updateByArgSelective(TSqrxxfjPO record, TSqrxxfjArg arg) {
        return getMapper().updateByArgSelective(record, arg);
    }

    public int updateByArg(TSqrxxfjPO record, TSqrxxfjArg arg) {
        return getMapper().updateByArg(record, arg);
    }

    public Page<TSqrxxfjPO> selectByArgAndPage(TSqrxxfjArg arg,
            Page<TSqrxxfjPO> resultPage) {
        List<TSqrxxfjPO> resultList = getMapper().selectByArgAndPage(arg,
                resultPage);
        resultPage.setResultList(resultList);
        return resultPage;
    }

    public int insert(TSqrxxfjPO record) {
        return getMapper().insert(record);
    }

    public int insertSelective(TSqrxxfjPO record) {
        return getMapper().insertSelective(record);
    }

    public int insertBatch(List<TSqrxxfjPO> records) {
        return getMapper().insertBatch(records);
    }

    public int deleteByPrimaryKey(String key) {
        return getMapper().deleteByPrimaryKey(key);
    }

    public TSqrxxfjPO selectByPrimaryKey(String key) {
        return getMapper().selectByPrimaryKey(key);
    }
    
    /**
     * 通过申请人ID查询附件信息
     */
    public List<TSqrxxfjPO> selectBySqrId(String sqrId){
    	return getMapper().selectBySqrId(sqrId);
    }

    public int updateByPrimaryKeySelective(TSqrxxfjPO record) {
        return getMapper().updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSqrxxfjPO record) {
        return getMapper().updateByPrimaryKey(record);
    }

    /**
     * 根据传入的Map条件进行查询，当前仅支持所有Map中Key字段的EqualTo查询
     * @param params Map,Key=字段名，value=查询值
     * @return
     */
    public List<TSqrxxfjPO> selectByMap(Map<String, Object> params) {
        return (selectByArg(buildQueryObject(params)));
    }

    private TSqrxxfjArg buildQueryObject(Map<String, Object> params) {

        TSqrxxfjArg arg = new TSqrxxfjArg();
        TSqrxxfjCriteria criteria = arg.createCriteria();

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

    public ITSqrxxfjMapper getMapper() {
    	return getSqlSession().getMapper(ITSqrxxfjMapper.class);
    }

}
