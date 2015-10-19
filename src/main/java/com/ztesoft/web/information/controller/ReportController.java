package com.ztesoft.web.information.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.web.information.domain.req.ReportQueryDto;
import com.ztesoft.web.information.domain.resp.ReportResultDto;
import com.ztesoft.web.information.service.IReportService;

/**
 * 人口信息查询总入口.报表查询
 * 
 * @author Ocean
 */
@Controller
@RequestMapping(value = "/report")
public class ReportController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(ReportController.class);

    @Autowired
    private IReportService reportService;

    @RequestMapping("index")
    public String index(Model model) {

        return "/report/jsp/infoQuery";
    }

    /**
     * 窗口信息查询服务统计报表
     * 
     * @param model
     * @return
     */
    @RequestMapping("queryCkcx")
    public ModelAndView queryCkcx(Model model) {
        ModelAndView view = new ModelAndView("/report/jsp/ckcx");
        view.addObject("startDateInit", DateUtils.date2StringDay(DateUtils
                .getMonthBeginday(new Date())));
        view.addObject("endDateInit",
                DateUtils.date2StringDay(DateUtils.getMonthLastday(new Date())));
        System.out.println(DateUtils.date2StringDay(DateUtils
                .getMonthBeginday(new Date())));
        System.out.println(DateUtils.date2StringDay(DateUtils.getMonthLastday(new Date())));
        return view;
    }

    /**
     * 窗口信息查询服务统计报表
     * 
     * @param reqInfo
     * @return
     */
    @RequestMapping("queryCkcxData")
    @ResponseBody
    public List<ReportResultDto> queryCkcxData(ReportQueryDto reqInfo) {
        reqInfo.setCxbs("20");// pc端
        reqInfo.setStartDateStr(DateUtils.date2String(reqInfo.getStartDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        reqInfo.setEndDateStr(DateUtils.date2String(reqInfo.getEndDate(),
                DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));
        return reportService.queryCkcx(reqInfo);
    }

}
