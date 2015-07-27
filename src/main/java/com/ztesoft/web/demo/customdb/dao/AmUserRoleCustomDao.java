package com.ztesoft.web.demo.customdb.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ztesoft.web.demo.customdb.dao.dto.AmUserRoleDto;
import com.ztesoft.web.demo.customdb.dao.mapper.IAmUserRoleMapper;
import com.ztesoft.web.demo.db.po.AmUserPO;

/**
 * <Description> 自定义的Dao，AM_USER_ROLE<br>
 * 
 * @author <br>
 * @CreateDate 2014年11月12日 <br>
 * @see com.ztesoft.web.demo.customdb.dao <br>
 */
@Repository
public class AmUserRoleCustomDao extends SqlSessionDaoSupport {

    @Resource(name = "majorSqlSessionTemplate")
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public List<AmUserRoleDto> selectListByUserId(Integer userId) {
        return getMapper().selectListByUserId(userId);
    }

    public List<AmUserRoleDto> qryAmUserListByRoleId(Integer roleId) {
        return getMapper().qryAmUserListByRoleId(roleId);
    }

    public List<AmUserPO> qryAmUserListExcludeRoleId(Integer roleId) {
        return getMapper().qryAmUserListExcludeRoleId(roleId);
    }

    public List<AmUserRoleDto> qryAmUserListByUserRoleIdList(
            List<Integer> userRoleIdList) {
        return getMapper().qryAmUserListByUserRoleIdList(userRoleIdList);
    }

    public List<AmUserRoleDto> selectPageList(AmUserRoleDto dto,
            RowBounds rowBound) {

        return getMapper().selectPageList(dto, rowBound);
    }

    /**
     * 测试分页，传入Map，真正项目中，最好不要用Map
     * 
     * @param map
     * @param rowBound
     * @return
     */
    public List<Map> selectPageListByMap(Map map, RowBounds rowBound) {
        return getMapper().selectPageListByMap(map, rowBound);
    }

    /**
     * 测试，传入Map，真正项目中，最好不要用Map
     * 
     * @param map
     * @return
     */
    public List<Map> selectListByMap(Map map) {
        return getMapper().selectListByMap(map);
    }


    public IAmUserRoleMapper getMapper() {
        return getSqlSession().getMapper(IAmUserRoleMapper.class);
    }

}
