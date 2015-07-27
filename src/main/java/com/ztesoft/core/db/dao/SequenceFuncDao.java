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

import com.ztesoft.core.db.dao.mapper.ISequenceFuncMapper;

/**
 * <Description> 调用 数据库函数 生成主键序列号<br>
 * 已废弃，发现实现中有BUG
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月1日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.db.dao <br>
 */
@Repository("sequenceFuncDao_Deprecated")
@Deprecated
public class SequenceFuncDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public ISequenceFuncMapper getMapper() {
        return getSqlSession().getMapper(ISequenceFuncMapper.class);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public synchronized String selectSequence(Map<String, Object> params) {
        return getMapper().selectSequence(params);
    }
}
