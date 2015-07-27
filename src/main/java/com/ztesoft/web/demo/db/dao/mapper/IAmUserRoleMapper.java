package com.ztesoft.web.demo.db.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ztesoft.web.demo.db.arg.AmUserRoleArg;
import com.ztesoft.web.demo.db.po.AmUserRolePO;

public interface IAmUserRoleMapper {
    List<Integer> countByArg(AmUserRoleArg arg);

    int deleteByArg(AmUserRoleArg arg);

    List<AmUserRolePO> selectByArg(AmUserRoleArg arg);

    int updateByArgSelective(@Param("record") AmUserRolePO record,
            @Param("arg") AmUserRoleArg arg);

    int updateByArg(@Param("record") AmUserRolePO record,
            @Param("arg") AmUserRoleArg arg);

    List<AmUserRolePO> selectByArgAndPage(AmUserRoleArg arg, RowBounds rowBound);

    int insert(AmUserRolePO record);

    int insertSelective(AmUserRolePO record);

    int insertBatch(@Param("list") List<AmUserRolePO> records);

    int deleteByPrimaryKey(Integer USER_ROLE_ID);

    AmUserRolePO selectByPrimaryKey(Integer USER_ROLE_ID);

    int updateByPrimaryKeySelective(AmUserRolePO record);

    int updateByPrimaryKey(AmUserRolePO record);
}