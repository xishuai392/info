package com.ztesoft.web.permission.db.dao.mapper;

import com.ztesoft.web.permission.db.arg.AuditMenuArg;
import com.ztesoft.web.permission.db.po.AuditMenuPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IAuditMenuMapper {
    
    List<Integer> countByArg(AuditMenuArg arg);

    List<AuditMenuPO> selectByArg(AuditMenuArg arg);

    AuditMenuPO selectByPrimaryKey(Integer id);

    List<AuditMenuPO> selectByArgAndPage(AuditMenuArg arg, RowBounds rowBound);

    int insert(AuditMenuPO record);

    int insertSelective(AuditMenuPO record);

    int insertBatch(@Param("list") List<AuditMenuPO> records);

    int updateByArgSelective(@Param("record") AuditMenuPO record,
            @Param("arg") AuditMenuArg arg);

    int updateByArg(@Param("record") AuditMenuPO record,
            @Param("arg") AuditMenuArg arg);

    int updateByPrimaryKeySelective(AuditMenuPO record);

    int updateByPrimaryKey(AuditMenuPO record);
    
    int deleteByArg(AuditMenuArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}