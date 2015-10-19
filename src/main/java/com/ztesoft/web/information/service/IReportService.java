/**
 * 
 */
package com.ztesoft.web.information.service;

import java.util.List;

import com.ztesoft.web.information.domain.req.ReportQueryDto;
import com.ztesoft.web.information.domain.resp.ReportResultDto;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月12日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.service <br>
 */

public interface IReportService {
    /**
     * 窗口信息查询服务统计报表
     * 
     * @param reqInfo
     * @return
     */
    public List<ReportResultDto> queryCkcx(ReportQueryDto reqInfo);

}
