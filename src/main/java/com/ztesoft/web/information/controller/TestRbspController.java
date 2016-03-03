/**
 * 
 */
package com.ztesoft.web.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.web.information.rbsp.InfoRbspClient;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月28日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.controller <br>
 */
@Controller
@RequestMapping(value = "/test")
public class TestRbspController {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TestRbspController.class);

    @RequestMapping("czrk")
    @ResponseBody
    public String queryCZRKbaseInfo(String pid, String whereField) {
        AuditUserPO auditUserPo = defaultUser();
        // 查询常住人口信息
        String czrkInfoResult = InfoRbspClient.queryCZRKbaseInfo(auditUserPo,
                pid, whereField, null);
        logger.info("查询常住人口信息返回：" + czrkInfoResult);
        return czrkInfoResult;
    }

    @RequestMapping("hu")
    @ResponseBody
    public String queryCZRKCensusInfo(String huId) {
        AuditUserPO auditUserPo = defaultUser();
        // 查询TC_RKXT.T_HU信息
        String huInfoResult = InfoRbspClient.queryCZRKCensusInfo(auditUserPo,
                huId);
        logger.info("查询TC_RKXT.T_HU返回：" + huInfoResult);
        return huInfoResult;
    }

    @RequestMapping("dz")
    @ResponseBody
    public String queryDZinfo(String metaAddrId) {
        AuditUserPO auditUserPo = defaultUser();
        // 查询TC_JCYW.T_META_ADDR信息
        String dzInfoResult = InfoRbspClient.queryDZinfo(auditUserPo,
                metaAddrId);
        logger.info("查询TC_JCYW.T_META_ADDRU返回：" + dzInfoResult);
        return dzInfoResult;
    }

    @RequestMapping("zjzzxx")
    @ResponseBody
    public String queryZJZZXXInfo(String pid) {
        AuditUserPO auditUserPo = defaultUser();
        // 查询暂住人口信息
        String zzrkInfoResult = InfoRbspClient.queryZJZZXXInfo(auditUserPo, pid);
        logger.info("查询暂住人口信息返回：" + zzrkInfoResult);
        return zzrkInfoResult;
    }

    @RequestMapping("ldrkjbxx")
    @ResponseBody
    public String queryLDRK_JBXXInfo(String pid) {
        AuditUserPO auditUserPo = defaultUser();
        // 查流动人口信息
        String ldrkInfoResult = InfoRbspClient.queryLDRK_JBXXInfo(auditUserPo,
                pid, null);
        logger.info("查询流动人口基本信息返回：" + ldrkInfoResult);
        return ldrkInfoResult;
    }

    @RequestMapping("ldrk")
    @ResponseBody
    public String queryLDRKInfo(String pid) {
        AuditUserPO auditUserPo = defaultUser();
        // 查流动人口信息
        String ldrkInfoResult = InfoRbspClient.queryLDRKInfo(auditUserPo, pid);
        logger.info("查询流动人口信息返回：" + ldrkInfoResult);
        return ldrkInfoResult;
    }

    @RequestMapping("image")
    @ResponseBody
    public String queryImageInfo(String photoId) {
        AuditUserPO auditUserPo = defaultUser();
        // 查询photo信息并保存在服务器固定目录
        String photoInfoResult = InfoRbspClient.queryImageInfo(auditUserPo,
                photoId);
        logger.info("查询photo信息返回：" + photoInfoResult);
        return photoInfoResult;
    }

    private AuditUserPO defaultUser() {
        AuditUserPO auditUserPo = new AuditUserPO();
        // 设置用户身份编号
        auditUserPo.setUserCardId(MessageResourceUtils
                .getMessage("Plates.UserCardId"));
        // 设置用户单位
        auditUserPo.setOrgCode(MessageResourceUtils
                .getMessage("Plates.UserDeptId"));
        // 设置用户名
        auditUserPo.setUserName(MessageResourceUtils
                .getMessage("Plates.UserName"));
        // 设置PKI编号
        auditUserPo.setUserPkiId(MessageResourceUtils
                .getMessage("Plates.PkiId"));

        return auditUserPo;
    }

}
