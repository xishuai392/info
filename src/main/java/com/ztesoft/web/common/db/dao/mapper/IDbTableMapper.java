package com.ztesoft.web.common.db.dao.mapper;

import com.ztesoft.web.common.db.arg.DbTableArg;
import com.ztesoft.web.common.db.po.DbTablePO;

import java.util.*;
import java.math.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IDbTableMapper {
    List<Integer> countByArg(DbTableArg arg);

    int deleteByArg(DbTableArg arg);

    List<DbTablePO> selectByArg(DbTableArg arg);

    int updateByArgSelective(@Param("record") DbTablePO record,
            @Param("arg") DbTableArg arg);

    int updateByArg(@Param("record") DbTablePO record,
            @Param("arg") DbTableArg arg);

    List<DbTablePO> selectByArgAndPage(DbTableArg arg, RowBounds rowBound);

    int insert(DbTablePO record);

    int insertSelective(DbTablePO record);

    int insertBatch(@Param("list") List<DbTablePO> records);

    int deleteByPrimaryKey(Integer id);

    DbTablePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DbTablePO record);

    int updateByPrimaryKey(DbTablePO record);
}