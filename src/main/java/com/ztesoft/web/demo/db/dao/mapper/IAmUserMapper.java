package com.ztesoft.web.demo.db.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ztesoft.web.demo.db.arg.AmUserArg;
import com.ztesoft.web.demo.db.po.AmUserPO;

public interface IAmUserMapper {
    
    List<Integer> countByArg(AmUserArg arg);

    int deleteByArg(AmUserArg arg);

    List<AmUserPO> selectByArg(AmUserArg arg);

    int updateByArgSelective(@Param("record") AmUserPO record,
            @Param("arg") AmUserArg arg);

    int updateByArg(@Param("record") AmUserPO record,
            @Param("arg") AmUserArg arg);

    List<AmUserPO> selectByArgAndPage(AmUserArg arg, RowBounds rowBound);

    int insert(AmUserPO record);

    int insertSelective(AmUserPO record);

    int insertBatch(@Param("list") List<AmUserPO> records);

    int deleteByPrimaryKey(Integer USER_ID);

    AmUserPO selectByPrimaryKey(Integer USER_ID);

    int updateByPrimaryKeySelective(AmUserPO record);

    int updateByPrimaryKey(AmUserPO record);
}