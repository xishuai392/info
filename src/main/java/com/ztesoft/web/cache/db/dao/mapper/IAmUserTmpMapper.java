package com.ztesoft.web.cache.db.dao.mapper;

import com.ztesoft.web.cache.db.arg.AmUserTmpArg;
import com.ztesoft.web.cache.db.po.AmUserTmpPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IAmUserTmpMapper {
    
    List<Integer> countByArg(AmUserTmpArg arg);

    List<AmUserTmpPO> selectByArg(AmUserTmpArg arg);

    AmUserTmpPO selectByPrimaryKey(Integer id);

    List<AmUserTmpPO> selectByArgAndPage(AmUserTmpArg arg, RowBounds rowBound);

    int insert(AmUserTmpPO record);

    int insertSelective(AmUserTmpPO record);

    int insertBatch(@Param("list") List<AmUserTmpPO> records);

    int updateByArgSelective(@Param("record") AmUserTmpPO record,
            @Param("arg") AmUserTmpArg arg);

    int updateByArg(@Param("record") AmUserTmpPO record,
            @Param("arg") AmUserTmpArg arg);

    int updateByPrimaryKeySelective(AmUserTmpPO record);

    int updateByPrimaryKey(AmUserTmpPO record);
    
    int deleteByArg(AmUserTmpArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}