package com.ztesoft.web.operateRecord.db.dao.mapper;

import com.ztesoft.web.operateRecord.db.arg.TSqrxxfjArg;
import com.ztesoft.web.operateRecord.db.po.TSqrxxfjPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ITSqrxxfjMapper {
    
    List<Integer> countByArg(TSqrxxfjArg arg);

    List<TSqrxxfjPO> selectByArg(TSqrxxfjArg arg);

    TSqrxxfjPO selectByPrimaryKey(String id);

    List<TSqrxxfjPO> selectByArgAndPage(TSqrxxfjArg arg, RowBounds rowBound);

    List<TSqrxxfjPO> selectBySqrId(String sqrId);
    
    int insert(TSqrxxfjPO record);

    int insertSelective(TSqrxxfjPO record);

    int insertBatch(@Param("list") List<TSqrxxfjPO> records);

    int updateByArgSelective(@Param("record") TSqrxxfjPO record,
            @Param("arg") TSqrxxfjArg arg);

    int updateByArg(@Param("record") TSqrxxfjPO record,
            @Param("arg") TSqrxxfjArg arg);

    int updateByPrimaryKeySelective(TSqrxxfjPO record);

    int updateByPrimaryKey(TSqrxxfjPO record);
    
    int deleteByArg(TSqrxxfjArg arg);
    
    int deleteByPrimaryKey(String id);
    
}