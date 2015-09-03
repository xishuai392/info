package com.ztesoft.web.information.db.dao.mapper;

import com.ztesoft.web.information.db.arg.CxrzArg;
import com.ztesoft.web.information.db.po.CxrzPO;

import java.math.*;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface  ICxrzMapper {
    
    List<Integer> countByArg(CxrzArg arg);

    List<CxrzPO> selectByArg(CxrzArg arg);

    CxrzPO selectByPrimaryKey(String id);

    List<CxrzPO> selectByArgAndPage(CxrzArg arg, RowBounds rowBound);

    int insert(CxrzPO record);

    int insertSelective(CxrzPO record);

    int insertBatch(@Param("list") List<CxrzPO> records);

    int updateByArgSelective(@Param("record") CxrzPO record,
            @Param("arg") CxrzArg arg);

    int updateByArg(@Param("record") CxrzPO record,
            @Param("arg") CxrzArg arg);

    int updateByPrimaryKeySelective(CxrzPO record);

    int updateByPrimaryKey(CxrzPO record);
    
    int deleteByArg(CxrzArg arg);
    
    int deleteByPrimaryKey(String id);
    
}