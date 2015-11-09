package com.ztesoft.web.byTheQuery.db.dao.mapper;

import com.ztesoft.web.byTheQuery.db.arg.TBcxrxxArg;
import com.ztesoft.web.byTheQuery.db.po.TBcxrxxPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ITBcxrxxMapper {
    
    List<Integer> countByArg(TBcxrxxArg arg);

    List<TBcxrxxPO> selectByArg(TBcxrxxArg arg);

    TBcxrxxPO selectByPrimaryKey(String id);

    List<TBcxrxxPO> selectByArgAndPage(TBcxrxxArg arg, RowBounds rowBound);

    int insert(TBcxrxxPO record);

    int insertSelective(TBcxrxxPO record);

    int insertBatch(@Param("list") List<TBcxrxxPO> records);

    int updateByArgSelective(@Param("record") TBcxrxxPO record,
            @Param("arg") TBcxrxxArg arg);

    int updateByArg(@Param("record") TBcxrxxPO record,
            @Param("arg") TBcxrxxArg arg);

    int updateByPrimaryKeySelective(TBcxrxxPO record);

    int updateByPrimaryKey(TBcxrxxPO record);
    
    int deleteByArg(TBcxrxxArg arg);
    
    int deleteByPrimaryKey(String id);
    
    
    List<TBcxrxxPO> select4Page( TBcxrxxPO record, RowBounds rowBound);
    
}