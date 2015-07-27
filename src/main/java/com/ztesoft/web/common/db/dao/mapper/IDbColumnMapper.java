package com.ztesoft.web.common.db.dao.mapper;

import com.ztesoft.web.common.db.arg.DbColumnArg;
import com.ztesoft.web.common.db.po.DbColumnPO;

import java.util.*;
import java.math.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IDbColumnMapper {
    List<Integer> countByArg(DbColumnArg arg);

    int deleteByArg(DbColumnArg arg);

    List<DbColumnPO> selectByArg(DbColumnArg arg);

    int updateByArgSelective(@Param("record") DbColumnPO record,
            @Param("arg") DbColumnArg arg);

    int updateByArg(@Param("record") DbColumnPO record,
            @Param("arg") DbColumnArg arg);

    List<DbColumnPO> selectByArgAndPage(DbColumnArg arg, RowBounds rowBound);

    int insert(DbColumnPO record);

    int insertSelective(DbColumnPO record);

    int insertBatch(@Param("list") List<DbColumnPO> records);

    int deleteByPrimaryKey(Integer id);

    DbColumnPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DbColumnPO record);

    int updateByPrimaryKey(DbColumnPO record);
}