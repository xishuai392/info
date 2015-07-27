package com.ztesoft.web.permission.db.dao.mapper;

import com.ztesoft.web.permission.db.arg.AuditMenuRoleArg;
import com.ztesoft.web.permission.db.po.AuditMenuRolePO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IAuditMenuRoleMapper {
    
    List<Integer> countByArg(AuditMenuRoleArg arg);

    List<AuditMenuRolePO> selectByArg(AuditMenuRoleArg arg);

    AuditMenuRolePO selectByPrimaryKey(Integer id);

    List<AuditMenuRolePO> selectByArgAndPage(AuditMenuRoleArg arg, RowBounds rowBound);

    int insert(AuditMenuRolePO record);

    int insertSelective(AuditMenuRolePO record);

    int insertBatch(@Param("list") List<AuditMenuRolePO> records);

    int updateByArgSelective(@Param("record") AuditMenuRolePO record,
            @Param("arg") AuditMenuRoleArg arg);

    int updateByArg(@Param("record") AuditMenuRolePO record,
            @Param("arg") AuditMenuRoleArg arg);

    int updateByPrimaryKeySelective(AuditMenuRolePO record);

    int updateByPrimaryKey(AuditMenuRolePO record);
    
    int deleteByArg(AuditMenuRoleArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}