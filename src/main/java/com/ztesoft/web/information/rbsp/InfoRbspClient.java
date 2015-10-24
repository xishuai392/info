package com.ztesoft.web.information.rbsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

import com.dragonsoft.node.adapter.comm.RbspCall;
import com.dragonsoft.node.adapter.comm.RbspConsts;
import com.dragonsoft.node.adapter.comm.RbspService;
import com.ztesoft.framework.log.ZTEsoftLogManager;
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
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(InfoRbspClient.class);

    /**
     * 常住人口基本信息数据查询服务方 <br>
     * TC_RKXT.T_HUJI
     * 
     * @param userPO
     * @param pid
     * @param whereField 例如： PID
     * @return
     */
    public static String queryCZRKbaseInfo(AuditUserPO userPO, String pid,
            String whereField) {
        String result = null;
        try {
            logger.info("调用接口开始[常住人口基本信息数据查询服务方TC_RKXT.T_HUJI]");
            if ("true".equals(MessageResourceUtils.getMessage("isDebug"))) {
                return getXml("T_HUJI.xml");
            }

            // 创建RbspService
            RbspService service = new RbspService(
                    MessageResourceUtils.getMessage("T_HUJI.senderId"),
                    MessageResourceUtils.getMessage("T_HUJI.serviceId"));
            // 设置用户身份编号
            service.setUserCardId(userPO.getUserCardId());
            // 设置用户单位
            service.setUserDept(String.valueOf(userPO.getOrgId()));
            // 设置用户名
            service.setUserName(userPO.getUserName());
            // 设置PKI编号
            service.setPkiId(userPO.getUserPkiId());
            // 设置超时
            service.setTimeOut(MessageResourceUtils
                    .getMessage("TimeOut.second"));
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
            String condition = whereField + "=" + pid;
            // String condition = "ZJHM='"+pid+"'";

            params.put("Condition", condition);

            params.put("RequiredItems", new String[] {
                // "ZHSJC", "ZZXZ", "ZZSSX", "CSRQ", "MZ", "XB", "XM", "ZJHM"
                    MessageResourceUtils.getMessage("T_HUJI.RequiredItems")
                });
            // 调用返回结果
            result = call.invoke(params);

            logger.info("调用接口返回[常住人口基本信息数据查询服务方TC_RKXT.T_HUJI],xmlResult="
                    + result);
        }
        catch (Exception e) {
            logger.info("调用接口[常住人口基本信息数据查询服务方TC_RKXT.T_HUJI],发生异常.", e);
        }
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
        logger.info("调用接口开始[常住人口户信息数据查询服务方TC_RKXT.T_HU]");
        if ("true".equals(MessageResourceUtils.getMessage("isDebug"))) {
            return getXml("T_HU.xml");
        }

        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_HU.senderId"),
                MessageResourceUtils.getMessage("T_HU.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(String.valueOf(userPO.getOrgId()));
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 设置超时
        service.setTimeOut(MessageResourceUtils.getMessage("TimeOut.second"));
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
        logger.info("调用接口返回[常住人口户信息数据查询服务方TC_RKXT.T_HU],xmlResult=" + result);
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
        logger.info("调用接口开始[地址信息数据查询服务方TC_JCYW.T_META_ADDR]");
        if ("true".equals(MessageResourceUtils.getMessage("isDebug"))) {
            return getXml("T_META_ADDR.xml");
        }

        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_META_ADDR.senderId"),
                MessageResourceUtils.getMessage("T_META_ADDR.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(String.valueOf(userPO.getOrgId()));
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 设置超时
        service.setTimeOut(MessageResourceUtils.getMessage("TimeOut.second"));
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
        logger.info("调用接口返回[地址信息数据查询服务方TC_JCYW.T_META_ADDR],xmlResult="
                + result);
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
        logger.info("调用接口开始[暂（居）住证信息数据查询服务方TC_RKXT.T_LDRK_ZJZZXX]");
        if ("true".equals(MessageResourceUtils.getMessage("isDebug"))) {
            return getXml("T_LDRK_ZJZZXX.xml");
        }

        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.senderId"),
                MessageResourceUtils.getMessage("T_LDRK_ZJZZXX.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(String.valueOf(userPO.getOrgId()));
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 设置超时
        service.setTimeOut(MessageResourceUtils.getMessage("TimeOut.second"));
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
        logger.info("调用接口返回[暂（居）住证信息数据查询服务方TC_RKXT.T_LDRK_ZJZZXX],xmlResult="
                + result);
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
        logger.info("调用接口开始[流动人口登记信息数据查询服务方TC_RKXT.T_LDRK_DJXX]");
        if ("true".equals(MessageResourceUtils.getMessage("isDebug"))) {
            return getXml("T_LDRK_DJXX.xml");
        }

        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_LDRK_DJXX.senderId"),
                MessageResourceUtils.getMessage("T_LDRK_DJXX.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(String.valueOf(userPO.getOrgId()));
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 设置超时
        service.setTimeOut(MessageResourceUtils.getMessage("TimeOut.second"));
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
        logger.info("调用接口返回[流动人口登记信息数据查询服务方TC_RKXT.T_LDRK_DJXX],xmlResult="
                + result);
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
        logger.info("调用接口开始[实有人口相片信息数据查询服务方TC_PHOTO.T_PHOTO]");
        if ("true".equals(MessageResourceUtils.getMessage("isDebug"))) {
            return getXml("T_PHOTO.xml");
        }

        // 创建RbspService
        RbspService service = new RbspService(
                MessageResourceUtils.getMessage("T_PHOTO.senderId"),
                MessageResourceUtils.getMessage("T_PHOTO.serviceId"));
        // 设置用户身份编号
        service.setUserCardId(userPO.getUserCardId());
        // 设置用户单位
        service.setUserDept(String.valueOf(userPO.getOrgId()));
        // 设置用户名
        service.setUserName(userPO.getUserName());
        // 设置PKI编号
        service.setPkiId(userPO.getUserPkiId());
        // 设置超时
        service.setTimeOut(MessageResourceUtils.getMessage("TimeOut.second"));
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
        logger.info("调用接口返回[实有人口相片信息数据查询服务方TC_PHOTO.T_PHOTO],xmlResult="
                + result);
        return result;
    }

    private static String getXml(String fileName) {
        String filePath = "C://mvnLib//exampleXml//" + fileName;
        StringBuffer stbXml = new StringBuffer();
        // String filePath="C://mvnLib//suc.xml";
        try{
            File file = new File(filePath);
            InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                stbXml.append(lineTxt);
            }
            bufferedReader.close();
            read.close();
        }catch(Exception e){
            logger.error(e);
        }
        return stbXml.toString();
    }
}
