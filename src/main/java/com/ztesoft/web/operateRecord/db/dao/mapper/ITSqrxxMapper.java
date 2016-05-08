package com.ztesoft.web.operateRecord.db.dao.mapper;

import com.ztesoft.web.operateRecord.db.arg.TSqrxxArg;
import com.ztesoft.web.operateRecord.db.po.TSqrxxPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ITSqrxxMapper {
    
    List<Integer> countByArg(TSqrxxArg arg);

    List<TSqrxxPO> selectByArg(TSqrxxArg arg);

    TSqrxxPO selectByPrimaryKey(String id);

    List<TSqrxxPO> selectByArgAndPage(TSqrxxArg arg, RowBounds rowBound);
    
    List<TSqrxxPO> selectByArgAndPage4AppendQry(TSqrxxArg arg, RowBounds rowBound);

    int insert(TSqrxxPO record);

    int insertSelective(TSqrxxPO record);

    int insertBatch(@Param("list") List<TSqrxxPO> records);

    int updateByArgSelective(@Param("record") TSqrxxPO record,
            @Param("arg") TSqrxxArg arg);

    int updateByArg(@Param("record") TSqrxxPO record,
            @Param("arg") TSqrxxArg arg);

    int updateByPrimaryKeySelective(TSqrxxPO record);

    int updateByPrimaryKey(TSqrxxPO record);
    
    int deleteByArg(TSqrxxArg arg);
    
    int deleteByPrimaryKey(String id);
    
}