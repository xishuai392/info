package com.ztesoft.web.common.db.dao.mapper;

import com.ztesoft.web.common.db.arg.DbMetaArg;
import com.ztesoft.web.common.db.po.DbMetaPO;

import java.util.*;
import java.math.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IDbMetaMapper {
    List<Integer> countByArg(DbMetaArg arg);

    int deleteByArg(DbMetaArg arg);

    List<DbMetaPO> selectByArg(DbMetaArg arg);

    int updateByArgSelective(@Param("record") DbMetaPO record,
            @Param("arg") DbMetaArg arg);

    int updateByArg(@Param("record") DbMetaPO record,
            @Param("arg") DbMetaArg arg);

    List<DbMetaPO> selectByArgAndPage(DbMetaArg arg, RowBounds rowBound);

    int insert(DbMetaPO record);

    int insertSelective(DbMetaPO record);

    int insertBatch(@Param("list") List<DbMetaPO> records);

    int deleteByPrimaryKey(Integer id);

    DbMetaPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DbMetaPO record);

    int updateByPrimaryKey(DbMetaPO record);
}