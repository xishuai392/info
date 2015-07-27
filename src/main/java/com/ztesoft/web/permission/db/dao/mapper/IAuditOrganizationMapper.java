package com.ztesoft.web.permission.db.dao.mapper;

import com.ztesoft.web.permission.db.arg.AuditOrganizationArg;
import com.ztesoft.web.permission.db.po.AuditOrganizationPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IAuditOrganizationMapper {
    
    List<Integer> countByArg(AuditOrganizationArg arg);

    List<AuditOrganizationPO> selectByArg(AuditOrganizationArg arg);

    AuditOrganizationPO selectByPrimaryKey(Long id);

    List<AuditOrganizationPO> selectByArgAndPage(AuditOrganizationArg arg, RowBounds rowBound);

    int insert(AuditOrganizationPO record);

    int insertSelective(AuditOrganizationPO record);

    int insertBatch(@Param("list") List<AuditOrganizationPO> records);

    int updateByArgSelective(@Param("record") AuditOrganizationPO record,
            @Param("arg") AuditOrganizationArg arg);

    int updateByArg(@Param("record") AuditOrganizationPO record,
            @Param("arg") AuditOrganizationArg arg);

    int updateByPrimaryKeySelective(AuditOrganizationPO record);

    int updateByPrimaryKey(AuditOrganizationPO record);
    
    int deleteByArg(AuditOrganizationArg arg);
    
    int deleteByPrimaryKey(Long id);
    
}