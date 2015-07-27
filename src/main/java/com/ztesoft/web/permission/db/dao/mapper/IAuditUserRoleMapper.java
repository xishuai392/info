package com.ztesoft.web.permission.db.dao.mapper;

import com.ztesoft.web.permission.db.arg.AuditUserRoleArg;
import com.ztesoft.web.permission.db.po.AuditUserRolePO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IAuditUserRoleMapper {
    
    List<Integer> countByArg(AuditUserRoleArg arg);

    List<AuditUserRolePO> selectByArg(AuditUserRoleArg arg);

    AuditUserRolePO selectByPrimaryKey(Integer id);

    List<AuditUserRolePO> selectByArgAndPage(AuditUserRoleArg arg, RowBounds rowBound);

    int insert(AuditUserRolePO record);

    int insertSelective(AuditUserRolePO record);

    int insertBatch(@Param("list") List<AuditUserRolePO> records);

    int updateByArgSelective(@Param("record") AuditUserRolePO record,
            @Param("arg") AuditUserRoleArg arg);

    int updateByArg(@Param("record") AuditUserRolePO record,
            @Param("arg") AuditUserRoleArg arg);

    int updateByPrimaryKeySelective(AuditUserRolePO record);

    int updateByPrimaryKey(AuditUserRolePO record);
    
    int deleteByArg(AuditUserRoleArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}