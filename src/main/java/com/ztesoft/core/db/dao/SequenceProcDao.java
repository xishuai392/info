/**
 * 
 */
package com.ztesoft.core.db.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ztesoft.core.db.dao.mapper.ISequenceProcMapper;

/**
 * <Description> 调用 数据库存储过程 生成主键序列号<br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月1日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.db.dao <br>
 */
@Repository("sequenceProcDao")
public class SequenceProcDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public ISequenceProcMapper getMapper() {
        return getSqlSession().getMapper(ISequenceProcMapper.class);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public synchronized String selectSequence(Map<String, Object> params) {
        return getMapper().selectSequence(params);
    }
}
