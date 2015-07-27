package com.ztesoft.web.permission.db.dao.mapper;

import com.ztesoft.web.permission.db.arg.AuditUserArg;
import com.ztesoft.web.permission.db.po.AuditUserPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IAuditUserMapper {
    
    List<Integer> countByArg(AuditUserArg arg);

    List<AuditUserPO> selectByArg(AuditUserArg arg);

    AuditUserPO selectByPrimaryKey(Integer id);

    List<AuditUserPO> selectByArgAndPage(AuditUserArg arg, RowBounds rowBound);

    int insert(AuditUserPO record);

    int insertSelective(AuditUserPO record);

    int insertBatch(@Param("list") List<AuditUserPO> records);

    int updateByArgSelective(@Param("record") AuditUserPO record,
            @Param("arg") AuditUserArg arg);

    int updateByArg(@Param("record") AuditUserPO record,
            @Param("arg") AuditUserArg arg);

    int updateByPrimaryKeySelective(AuditUserPO record);

    int updateByPrimaryKey(AuditUserPO record);
    
    int deleteByArg(AuditUserArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}