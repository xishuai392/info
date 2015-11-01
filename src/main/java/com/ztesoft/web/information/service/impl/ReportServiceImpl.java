/**
 * 
 */
package com.ztesoft.web.information.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.information.db.dao.ReportDao;
import com.ztesoft.web.information.domain.req.ReportQueryDto;
import com.ztesoft.web.information.domain.resp.ReportResultDto;
import com.ztesoft.web.information.service.IReportService;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月12日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.service.impl <br>
 */
@Service("reportService")
public class ReportServiceImpl implements IReportService {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(ReportServiceImpl.class);

    @Autowired
    private ReportDao reportDao;

    /*
     * (non-Javadoc)
     * @see com.ztesoft.web.information.service.IReportService#queryCkcx(com.ztesoft.web.information.domain.req.ReportQueryDto)
     */
    @Override
    public List<ReportResultDto> queryCkcx(ReportQueryDto reqInfo) {
        ReportResultDto reportResultDto = new ReportResultDto();
        List<ReportResultDto> fwcsList = reportDao.queryFwcs(reqInfo);
        List<ReportResultDto> cxcsList = reportDao.queryCxcs(reqInfo);
        List<ReportResultDto> cxcgcsList = reportDao.queryCxcgcs(reqInfo);

        reportResultDto.setFwcs(fwcsList.get(0).getFwcs());
        reportResultDto.setCxcs(cxcsList.get(0).getCxcs());
        reportResultDto.setCxcgcs(cxcgcsList.get(0).getCxcgcs());

        List<ReportResultDto> result = new ArrayList<ReportResultDto>();
        result.add(reportResultDto);
        return result;
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.web.information.service.IReportService#queryPlatesQryPrint(com.ztesoft.web.information.domain.req.ReportQueryDto)
     */
    @Override
    public List<ReportResultDto> queryPlatesQryPrint(ReportQueryDto reqInfo) {
        // TODO Auto-generated method stub
        return reportDao.queryPlatesQryPrint(reqInfo);
    }

}
