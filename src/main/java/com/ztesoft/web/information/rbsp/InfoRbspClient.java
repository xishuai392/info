package com.ztesoft.web.information.rbsp;

import java.util.HashMap;
import java.util.Map;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspConsts;
import com.dragonsoft.node.adapter.comm.RbspService;
import com.ztesoft.framework.util.MessageResourceUtils;
import com.ztesoft.web.permission.db.po.AuditUserPO;

/**
 * 常住人口基本信息数据查询服务方 常住人口户信息数据查询服务方 地址信息数据查询服务方 暂（居）住证信息数据查询服务方 流动人口登记信息数据查询服务方 实有人口相片信息数据查询服务方 挂接节点URL： http://10.130.142.193:8585/node 各类服务方
 * 常住人口基本信息数据查询服务方 S35-02000010 A0001 常住人口户信息数据查询服务方 S35-02000011 XM00001 地址信息数据查询服务方 S35-02000012 XM00003 暂（居）住证信息数据查询服务方 S35-02000013 XM00004
 * 流动人口登记信息数据查询服务方 S35-02000014 XM00005 实有人口相片信息数据查询服务方 S35-02000015 XM00006
 * 
 * @author Ocean
 */
public class InfoRbspClient {

    /**
     * 常住人口基本信息数据查询服务方 <br>
     * TC_RKXT.T_HUJI
     * 
     * @param userPO
     * @param pid
     * @return
     */
    public static String queryCZRKbaseInfo(AuditUserPO userPO, String pid) {
        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_HUJI.senderId"),
                MessageResourceUtils.getMessage("T_HUJI.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(userPO.getOrgName());
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 创建RbspCall
        RbspCall call = service.createCall();
        // 设置总线地址
        call.setUrl(MessageResourceUtils.getMessage("T_HUJI.url"));
        // 设置WebService接口方法
        call.setMethod(RbspConsts.METHOD_QUERY);
        // 设置接口方法参数<参数名,值>
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("DataObjectCode",
                MessageResourceUtils.getMessage("T_HUJI.DataObjectCode"));
        // params.put("DataObjectCode", "M001");
        params.put("InfoCodeMode", "1");
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }
        String condition = "PID=" + pid;
        // String condition = "ZJHM='"+pid+"'";

        params.put("Condition", condition);

        params.put("RequiredItems", new String[] {
            // "ZHSJC", "ZZXZ", "ZZSSX", "CSRQ", "MZ", "XB", "XM", "ZJHM"
                MessageResourceUtils.getMessage("T_HUJI.RequiredItems")
            });
        // 调用返回结果
        String result = call.invoke(params);
        return result;
    }

    /**
     * 常住人口户信息数据查询服务方.根据户编号查询地址id <br>
     * TC_RKXT.T_HU
     * 
     * @param userPO
     * @param huId
     * @return
     */
    public static String queryCZRKCensusInfo(AuditUserPO userPO, String huId) {

        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_HU.senderId"),
                MessageResourceUtils.getMessage("T_HU.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(userPO.getOrgName());
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 创建RbspCall
        RbspCall call = service.createCall();
        // 设置总线地址
        call.setUrl(MessageResourceUtils.getMessage("T_HU.url"));
        // 设置WebService接口方法
        call.setMethod(RbspConsts.METHOD_QUERY);
        // 设置接口方法参数<参数名,值>
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("DataObjectCode",
                MessageResourceUtils.getMessage("T_HU.DataObjectCode"));
        params.put("InfoCodeMode", "1");
        String condition = "HU_ID=" + huId;
        params.put("Condition", condition);
        params.put("RequiredItems", new String[] {
            // "HU_ID", "META_ADDR_ID"
                MessageResourceUtils.getMessage("T_HU.RequiredItems")
            });
        // 调用返回结果
        String result = call.invoke(params);
        return result;
    }

    /**
     * 地址信息数据查询服务方.根据地址id查询具体地址信息 <br>
     * TC_JCYW.T_META_ADDR
     * 
     * @param userPO
     * @param metaAddrId
     * @return
     */
    public static String queryDZinfo(AuditUserPO userPO, String metaAddrId) {
        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_META_ADDR.senderId"),
                MessageResourceUtils.getMessage("T_META_ADDR.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(userPO.getOrgName());
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 创建RbspCall
        RbspCall call = service.createCall();
        // 设置总线地址
        call.setUrl(MessageResourceUtils.getMessage("T_META_ADDR.url"));
        // 设置WebService接口方法
        call.setMethod(RbspConsts.METHOD_QUERY);
        // 设置接口方法参数<参数名,值>
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("DataObjectCode",
                MessageResourceUtils.getMessage("T_META_ADDR.DataObjectCode"));
        params.put("InfoCodeMode", "1");
        String condition = "META_ADDR_ID=" + metaAddrId;
        params.put("Condition", condition);
        params.put("RequiredItems", new String[] {
            // "META_ADDR_ID", "ALL_FULL_ADDR"
                MessageResourceUtils.getMessage("T_META_ADDR.RequiredItems")
            });
        // 调用返回结果
        String result = call.invoke(params);
        return result;

    }

    /**
     * 暂（居）住证信息数据查询服务方. S35-02000013 XM00004 <br>
     * TC_RKXT.T_LDRK_ZJZZXX
     * 
     * @param userPO
     * @param pid
     * @return
     */
    public static String queryZZRKInfo(AuditUserPO userPO, String pid) {
        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.senderId"),
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(userPO.getOrgName());
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 创建RbspCall
        RbspCall call = service.createCall();
        // 设置总线地址
        call.setUrl(MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.url"));
        // 设置WebService接口方法
        call.setMethod(RbspConsts.METHOD_QUERY);
        // 设置接口方法参数<参数名,值>
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("DataObjectCode",
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.DataObjectCode"));
        params.put("InfoCodeMode", "1");
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }
        String condition = "PID=" + pid;
        params.put("Condition", condition);
        params.put("RequiredItems", new String[] {
            // "PID", "NAME", "GENDER", "NATION", "DOB", "ZZZBH", "YXQQSRQ","YXQXJZRQ", "FZJGJGMC", "LZRQ", "ZZDZXZ"
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.RequiredItems")
            });
        // 调用返回结果
        String result = call.invoke(params);
        return result;
    }

    /**
     * 流动人口登记信息数据查询服务方 S35-02000014 XM00005 <br>
     * TC_RKXT.T_LDRK_DJXX
     * 
     * @param userPO
     * @param pid
     * @return
     */
    public static String queryLDRKInfo(AuditUserPO userPO, String pid) {
        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_LDRK_DJXX.senderId"),
                MessageResourceUtils.getMessage("T_LDRK_DJXX.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(userPO.getOrgName());
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 创建RbspCall
        RbspCall call = service.createCall();
        // 设置总线地址
        call.setUrl(MessageResourceUtils.getMessage("T_LDRK_DJXX.url"));
        // 设置WebService接口方法
        call.setMethod(RbspConsts.METHOD_QUERY);
        // 设置接口方法参数<参数名,值>
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("DataObjectCode",
                MessageResourceUtils.getMessage("T_LDRK_DJXX.DataObjectCode"));
        params.put("InfoCodeMode", "1");
        if (pid.length() == 15) {
            pid = IdentificationCodeUtil.update2eighteen(pid);
        }
        String condition = "PID=" + pid;
        params.put("Condition", condition);
        params.put("RequiredItems", new String[] {
            // "PID", "USED_NAME", "NATIVE_PLACE", "HJD_QU", "HJD_FULL_ADDR","PHOTO_ID"
                MessageResourceUtils.getMessage("T_LDRK_DJXX.RequiredItems")
            });
        // 调用返回结果
        String result = call.invoke(params);
        return result;
    }

    /**
     * 实有人口相片信息数据查询服务方 S35-02000015 XM00006 <br>
     * TC_PHOTO.T_PHOTO
     * 
     * @param userPO
     * @param photoId
     * @return
     */
    public static String queryImageInfo(AuditUserPO userPO, String photoId) {
        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_PHOTO.senderId"),
                MessageResourceUtils.getMessage("T_PHOTO.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(userPO.getOrgName());
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 创建RbspCall
        RbspCall call = service.createCall();
        // 设置总线地址
        call.setUrl(MessageResourceUtils.getMessage("T_PHOTO.url"));
        // 设置WebService接口方法
        call.setMethod(RbspConsts.METHOD_QUERY);
        // 设置接口方法参数<参数名,值>
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("DataObjectCode",
                MessageResourceUtils.getMessage("T_PHOTO.DataObjectCode"));
        params.put("InfoCodeMode", "1");
        String condition = "PHOTO_ID=" + photoId;
        params.put("Condition", condition);
        params.put("RequiredItems", new String[] {
            // "PHOTO_ID", "IMAGE"
                MessageResourceUtils.getMessage("T_PHOTO.RequiredItems")
            });
        // 调用返回结果PHOTO_ID
        String result = call.invoke(params);
        return result;
    }
}