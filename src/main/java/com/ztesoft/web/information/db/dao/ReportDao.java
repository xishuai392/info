/**
 * 
 */
package com.ztesoft.web.information.db.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ztesoft.web.information.db.dao.mapper.IReportMapper;
import com.ztesoft.web.information.domain.req.ReportQueryDto;
import com.ztesoft.web.information.domain.resp.ReportResultDto;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月12日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.db.dao <br>
 */
@Repository
public class ReportDao extends SqlSessionDaoSupport {
    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public IReportMapper getMapper() {
        return getSqlSession().getMapper(IReportMapper.class);
    }

    public List<ReportResultDto> queryFwcs(ReportQueryDto dto) {
        return getMapper().queryFwcs(dto);
    }

    public List<ReportResultDto> queryCxcs(ReportQueryDto dto) {
        return getMapper().queryCxcs(dto);
    }

    public List<ReportResultDto> queryCxcgcs(ReportQueryDto dto) {
        return getMapper().queryCxcgcs(dto);
    }

}
