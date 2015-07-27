package com.ztesoft.web.demo.customdb.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.ztesoft.web.demo.customdb.dao.dto.AmUserRoleDto;
import com.ztesoft.web.demo.db.po.AmUserPO;

/**
 * <Description> <br>
 * 
 * @author song.chenghao<br>
 * @CreateDate 2014年7月25日 <br>
 */
public interface IAmUserRoleMapper {

    /**
     * Description: 查询用户下所有的角色列表 <br>
     * 
     * @param userId
     * @return <br>
     */
    List<AmUserRoleDto> selectListByUserId(Integer userId);

    /**
     * Description: 查询角色下所有的用户列表<br>
     * 
     * @param roleId
     * @return <br>
     */
    List<AmUserRoleDto> qryAmUserListByRoleId(Integer roleId);

    /**
     * Description: 查询不在该角色下所有的用户列表<br>
     * 
     * @param roleId
     * @return <br>
     */
    List<AmUserPO> qryAmUserListExcludeRoleId(Integer roleId);

    /**
     * Description: 根据用户角色主键列表查询用户角色列表<br>
     * 
     * @taskId <br>
     * @param userRoleIdList
     * @return <br>
     */
    List<AmUserRoleDto> qryAmUserListByUserRoleIdList(
            List<Integer> userRoleIdList);

    /**
     * 测试分页，
     * 
     * @param dto
     * @param rowBound
     * @return
     */
    List<AmUserRoleDto> selectPageList(AmUserRoleDto dto, RowBounds rowBound);

    /**
     * 测试分页，传入Map，真正项目中，最好不要用Map
     * 
     * @param map
     * @param rowBound
     * @return
     */
    List<Map> selectPageListByMap(Map map, RowBounds rowBound);

    /**
     * 测试，传入Map，真正项目中，最好不要用Map
     * 
     * @param map
     * @return
     */
    List<Map> selectListByMap(Map map);
}
