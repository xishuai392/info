/**
 * 
 */
package com.ztesoft.web.information.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.framework.util.UuidUtils;
import com.ztesoft.web.domain.IConstants;
import com.ztesoft.web.information.db.po.TBcxrxxPO;
import com.ztesoft.web.information.db.po.TSqrxxPO;
import com.ztesoft.web.information.domain.req.query.QueryByOtherPeopleReqInfo;
import com.ztesoft.web.information.domain.req.query.QueryByPlatesReqInfo;
import com.ztesoft.web.information.domain.resp.FamilyInfo;
import com.ztesoft.web.information.domain.resp.MigrateInfo;
import com.ztesoft.web.information.domain.resp.PermanetPopulationInfo;
import com.ztesoft.web.information.domain.resp.PopulationBaseInfo;
import com.ztesoft.web.information.domain.resp.QueryResultInfo;
import com.ztesoft.web.information.domain.resp.TRpopulationInfo;
import com.ztesoft.web.information.rbsp.IdentificationCodeUtil;
import com.ztesoft.web.information.rbsp.InfoRbspClient;
import com.ztesoft.web.information.rbsp.InfoResultVO;
import com.ztesoft.web.information.rbsp.InfoXmlParser;
import com.ztesoft.web.information.rbsp.TransUtils;
import com.ztesoft.web.information.service.ITBcxrxxService;
import com.ztesoft.web.information.service.ITSqrxxService;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * <Description>人口信息查询，平板查询 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月23日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.controller <br>
 */
@Controller
@RequestMapping(value = "/plates")
public class PlatesInfoQueryController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(PlatesInfoQueryController.class);

    @Autowired
    private ITBcxrxxService bcxrxxService;

    @Autowired
    private ITSqrxxService sqrxxService;

    @Autowired
    InformationQueryController informationQueryController ;

    @RequestMapping("index")
    public String index(Model model) {

        return "/information/jsp/platesInfoQuery";
    }

    private AuditUserPO defaultUser() {
        AuditUserPO auditUserPo = new AuditUserPO();
        // 设置用户身份编号
        auditUserPo.setUserCardId(MessageResourceUtils
                .getMessage("Plates.UserCardId"));
        // 设置用户单位
        auditUserPo.setOrgId(Long.parseLong(MessageResourceUtils
                .getMessage("Plates.UserDeptId")));
        // 设置用户名
        auditUserPo.setUserName(MessageResourceUtils
                .getMessage("Plates.UserName"));
        // 设置PKI编号
        auditUserPo.setUserPkiId(MessageResourceUtils
                .getMessage("Plates.PkiId"));

        return auditUserPo;
    }

    /**
     * 终端查询
     * 
     * @param reqInfo
     * @param request
     * @return
     * @throws BaseAppException
     */
    @RequestMapping("queryByPlates")
    @ResponseBody
    public QueryByOtherPeopleReqInfo queryByPlates(
            QueryByPlatesReqInfo reqInfo, HttpServletRequest request)
            throws BaseAppException {
        QueryByOtherPeopleReqInfo bcxrInfo = new QueryByOtherPeopleReqInfo();
        bcxrInfo.setPopulationType(reqInfo.getPopulationType());

        logger.debug(reqInfo.toString());

        AuditUserPO auditUserPo = defaultUser();
        // 查询身份证号码
        String pid = reqInfo.getCardNo();
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }

        bcxrInfo.setIdCardNum(reqInfo.getCardNo());

        // 查询者姓名
        String bcxrxm = "";

        try {
            // 记录 申请人日志
            String sqrxxId = UuidUtils.generatorUUID();
            bcxrInfo.setSqrxxId(sqrxxId);

            TSqrxxPO sqrxxRecord = new TSqrxxPO();
            sqrxxRecord.setId(sqrxxId);
            sqrxxRecord.setZjh(reqInfo.getCardNo());
            sqrxxRecord.setZjlx("10");
            sqrxxRecord.setXm(reqInfo.getName());
            sqrxxRecord.setCxsqrlx("50");// 查询申请人类型（10：律师，20：党政军机关，30：司法机关，40：企事业单位，50：个人，60：人民团体，70：其他）
            sqrxxRecord.setCxbs("10");// 10：终端，20：pc端

            // sqrxxRecord.setCzdw(MessageResourceUtils
            // .getMessage("Plates.UserDeptId"));
            sqrxxRecord.setCzr(getHostName(request) + "[" + getIpAddr(request)
                    + "]");
            sqrxxRecord.setCxrq(DateUtils.date2String(new Date(),
                    DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));

            // 记录查询日志，申请人信息表
            sqrxxService.add(sqrxxRecord);

            // 记录被查询人日志
            String bcxrxxId = UuidUtils.generatorUUID();
            bcxrInfo.setBcxrxxId(bcxrxxId);
            TBcxrxxPO bcxrxxRecord = new TBcxrxxPO();
            bcxrxxRecord.setId(bcxrxxId);
            bcxrxxRecord.setSqrId(sqrxxId);
            bcxrxxRecord.setZjh(reqInfo.getCardNo());
            bcxrxxRecord.setZjlx("10");
            bcxrxxRecord.setXm(reqInfo.getName());
            bcxrxxRecord.setSfzf("0");// 是否作废（1：是，0：否）默认为“否”
            bcxrxxRecord.setSfdy("0");// 是否打印（1：是，0：否）默认为“否”
            bcxrxxRecord.setBcxrq(DateUtils.date2String(new Date(),
                    DateUtils.STR_DATE_FORMAT_DAY_WITHOUT_SPLIT));// 被查询日期
            bcxrxxRecord.setRklx(reqInfo.getPopulationType());// 人口类型（1：户籍人口，2：暂住人口）
            bcxrxxRecord.setCxcs(0);// 查询次数

            // 记录日志,被查询人信息表
            bcxrxxService.add(bcxrxxRecord);
        }
        catch (Exception e) {
            logger.error("终端查询，记录申请人信息、被查询人信息时发生错误", e);
        }

        return bcxrInfo;
    }

    @RequestMapping("queryCZRKinfo")
    @ResponseBody
    public PermanetPopulationInfo queryPermanetPopulationInfo(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request)
            throws BaseAppException {
        AuditUserPO auditUserPo = defaultUser();

        PermanetPopulationInfo permanentPopulationInfo = new PermanetPopulationInfo();
        permanentPopulationInfo.setTipMessage(MessageResourceUtils
                .getMessage("Detail.tipMessage"));
        permanentPopulationInfo.setDyrq(DateUtils.date2String(new Date(),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITH_SPLIT));
        informationQueryController.buildCZRKInfo(reqInfo, request, auditUserPo,
                permanentPopulationInfo);
        return permanentPopulationInfo;
    }

    @RequestMapping("queryZZRKinfo")
    @ResponseBody
    public TRpopulationInfo queryTRPopulationInfo(
            QueryByOtherPeopleReqInfo reqInfo, HttpServletRequest request)
            throws BaseAppException {
        AuditUserPO auditUserPo = defaultUser();
        TRpopulationInfo trPopulationInfo = new TRpopulationInfo();
        trPopulationInfo.setTipMessage(MessageResourceUtils
                .getMessage("Detail.tipMessage"));
        trPopulationInfo.setDyrq(DateUtils.date2String(new Date(),
                DateUtils.STR_DEFAULT_DATE_FORMAT_WITH_SPLIT));

        informationQueryController.buildZZRKInfo(reqInfo, request, auditUserPo,
                trPopulationInfo);
        return trPopulationInfo;
    }

    /**
     * 获取客户端的IP
     * 
     * @param request
     * @return
     */
    protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.length() > 16) {
            ip = ip.substring(0, 16);
        }
        return ip;
    }

    /**
     * 获取客户端的主机名
     * 
     * @param request
     * @return
     */
    protected String getHostName(HttpServletRequest request) {
        String hostName = "";
        try {
            hostName = request.getRemoteHost();
        }
        catch (Exception e1) {
            logger.error("获取客户端主机名称出错：", e1);
        }
        return hostName;
    }
}
