package com.ztesoft.web.demo.db.dao.mapper;

import com.ztesoft.web.demo.db.arg.EhcacheArg;
import com.ztesoft.web.demo.db.po.EhcachePO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface IEhcacheMapper {
    
    List<Integer> countByArg(EhcacheArg arg);

    List<EhcachePO> selectByArg(EhcacheArg arg);

    EhcachePO selectByPrimaryKey(Integer id);

    List<EhcachePO> selectByArgAndPage(EhcacheArg arg, RowBounds rowBound);

    int insert(EhcachePO record);

    int insertSelective(EhcachePO record);

    int insertBatch(@Param("list") List<EhcachePO> records);

    int updateByArgSelective(@Param("record") EhcachePO record,
            @Param("arg") EhcacheArg arg);

    int updateByArg(@Param("record") EhcachePO record,
            @Param("arg") EhcacheArg arg);

    int updateByPrimaryKeySelective(EhcachePO record);

    int updateByPrimaryKey(EhcachePO record);
    
    int deleteByArg(EhcacheArg arg);
    
    int deleteByPrimaryKey(Integer id);
    
}