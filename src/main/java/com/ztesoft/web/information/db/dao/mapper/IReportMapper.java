package com.ztesoft.web.information.db.dao.mapper;

import java.util.List;

import com.ztesoft.web.information.domain.req.ReportQueryDto;
import com.ztesoft.web.information.domain.resp.ReportResultDto;

public interface IReportMapper {

    List<ReportResultDto> queryFwcs(ReportQueryDto dto);

    List<ReportResultDto> queryCxcs(ReportQueryDto dto);

    List<ReportResultDto> queryCxcgcs(ReportQueryDto dto);

    List<ReportResultDto> queryPlatesQryPrint(ReportQueryDto dto);
    
    List<ReportResultDto> queryGroupByCzdw(ReportQueryDto dto);
    
}