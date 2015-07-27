package com.ztesoft.web.permission.db.dao.mapper;

import com.ztesoft.web.permission.db.arg.AuditRoleArg;
import com.ztesoft.web.permission.db.po.AuditRolePO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IAuditRoleMapper {
    
    List<Integer> countByArg(AuditRoleArg arg);

    List<AuditRolePO> selectByArg(AuditRoleArg arg);

    AuditRolePO selectByPrimaryKey(Integer id);

    List<AuditRolePO> selectByArgAndPage(AuditRoleArg arg, RowBounds rowBound);

    int insert(AuditRolePO record);

    int insertSelective(AuditRolePO record);

    int insertBatch(@Param("list") List<AuditRolePO> records);

    int updateByArgSelective(@Param("record") AuditRolePO record,
            @Param("arg") AuditRoleArg arg);

    int updateByArg(@Param("record") AuditRolePO record,
            @Param("arg") AuditRoleArg arg);

    int updateByPrimaryKeySelective(AuditRolePO record);

    int updateByPrimaryKey(AuditRolePO record);
    
    int deleteByArg(AuditRoleArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}