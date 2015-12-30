package com.ztesoft.web.information.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONUtils;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.DateUtils;
import com.ztesoft.framework.util.UuidUtils;
import com.ztesoft.web.information.db.po.TSqrxxfjPO;
import com.ztesoft.web.information.domain.req.scan.ScanReqInfo;
import com.ztesoft.web.information.rbsp.TransUtils;
import com.ztesoft.web.information.service.ITSqrxxfjService;

/**
 * 证件扫描控制类 包含证件 扫描和文件扫描
 * 
 * @author Ocean
 */
@Controller
@RequestMapping(value = "/scan")
public class ScanContorller {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(ScanContorller.class);

    @Autowired
    private ITSqrxxfjService sqrxxfjService;

    @RequestMapping("index")
    public String index(Model model) {

        return "/information/jsp/upload";
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public ResponseEntity<String> upload(@RequestParam(value = "upload",
            required = true) MultipartFile file, @RequestParam(
            value = "sqrxxId", required = true) String sqrxxId, @RequestParam(
            value = "mc", required = true) String mc, @RequestParam(
            value = "fjlx", required = true) String fjlx,
            HttpServletRequest request, ModelMap model) throws Exception {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_HTML);

        logger.debug("上传文件名：" + file.getOriginalFilename());
        String pathRoot = request.getSession().getServletContext()
                .getRealPath("scanImages");// 跟路径

        String subPath = getSubPath();// 子路径

        String path = pathRoot + File.separator + subPath;// 总路径

        String uuid = UuidUtils.generatorUUID();

        String fileName = uuid + ".jpg";
        // String fileName = file.getOriginalFilename();

        Map<String, Object> outmap = new HashMap<String, Object>();

        logger.debug("上传文件路径：" + path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        TSqrxxfjPO sqrxxfjDto = new TSqrxxfjPO();
        // 保存
        try {

            file.transferTo(targetFile);

            // 更新文件操作日志

            sqrxxfjDto.setId(uuid);
            String imagePath = new File(path + File.separator + fileName)
                    .toURI().toString();
            sqrxxfjDto.setDz(imagePath.substring(imagePath
                    .indexOf("scanImages") + 10));
            sqrxxfjDto.setMc(mc);
            sqrxxfjDto.setFjlx(fjlx);
            sqrxxfjDto.setSqrId(sqrxxId);
            sqrxxfjService.add(sqrxxfjDto);
        }
        catch (Exception e) {
            logger.error("保存上传文件时发生异常：", e);
            ExceptionHandler.publish("APP-00-0010", e);
        }
        model.addAttribute("fileUrl", path + File.separator + fileName);
        model.addAttribute("fjId", uuid);

        outmap.put("success", true);
        outmap.put("id", uuid);
        outmap.put("fjlx", fjlx);
        outmap.put("mc", sqrxxfjDto.getMc());
        outmap.put("dz", sqrxxfjDto.getDz());
        return new ResponseEntity<String>(JSONUtils.toJSONString(outmap),
                responseHeaders, HttpStatus.OK);

        // return "{\"success\":true,\"id\":\"" + uuid + "\",\"mc\":\""
        // + sqrxxfjDto.getMc() + "\",\"dz\":\"" + sqrxxfjDto.getDz()
        // + "\"}";
    }

    private String getSubPath() {
        Date thizDate = new Date();
        String subPath = DateUtils.date2String(thizDate,
                DateUtils.STR_DATE_FORMAT_MONTH_WITHOUT_SPLIT);
        subPath += File.separator
                + DateUtils.date2String(thizDate,
                        DateUtils.STR_DATE_FORMAT_DAY_SPLIT);
        return subPath;
    }

    private void createFilePath(String filePath) {

    }

    /**
     * 保存扫描图片，并记录
     * 
     * @param reqInfo
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveScanImages")
    @ResponseBody
    public TSqrxxfjPO saveScanImages(HttpServletRequest request,
            ScanReqInfo reqInfo) throws Exception {
        String pathRoot = request.getSession().getServletContext()
                .getRealPath("scanImages");// 跟路径

        String subPath = getSubPath();// 子路径

        String path = pathRoot + File.separator + subPath;// 总路径

        String uuid = UuidUtils.generatorUUID();
        String fileName = uuid + ".jpg";

        File targetFile = new File(path);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        boolean isSave = TransUtils.base64String2Image(path + File.separator
                + fileName, reqInfo.getImageBase64Str());

        String imagePath = new File(path + File.separator + fileName).toURI()
                .toString();

        TSqrxxfjPO sqrxxfjDto = new TSqrxxfjPO();
        sqrxxfjDto.setId(uuid);
        sqrxxfjDto.setFjlx(reqInfo.getFjlx());
        sqrxxfjDto
                .setDz(imagePath.substring(imagePath.indexOf("scanImages") + 10));
        sqrxxfjDto.setMc(reqInfo.getFileName());
        sqrxxfjDto.setSqrId(reqInfo.getSqrxxId());

        // 更新附件日志
        sqrxxfjService.add(sqrxxfjDto);
        return sqrxxfjDto;

    }

    /**
     * 调用第三方接口扫描身份证信息。并将图片保存到本地制定位置后同时上传到前台 与此同时接受uuid值
     * 
     * @throws BaseAppException
     */
    @RequestMapping("/idCardScan")
    @ResponseBody
    public String idCardScan(ScanReqInfo reqInfo) throws BaseAppException {
        // 更新文件操作日志
        String uuid = UuidUtils.generatorUUID();
        TSqrxxfjPO sqrxxfjDto = new TSqrxxfjPO();
        sqrxxfjDto.setId(uuid);
        sqrxxfjDto.setDz(reqInfo.getFilePath());
        sqrxxfjDto.setMc(reqInfo.getFileName());
        sqrxxfjDto.setSqrId(reqInfo.getSqrxxId());
        sqrxxfjService.add(sqrxxfjDto);
        return "true";

    }

    /**
     * 调用第三方接口扫描文件信息。并将图片保存到本地制定位置后同时上传到前台
     * 
     * @throws BaseAppException
     */
    @RequestMapping("/fileScan")
    @ResponseBody
    public String fileScan(ScanReqInfo reqInfo) throws BaseAppException {
        // 更新文件操作日志
        // 更新文件操作日志
        String uuid = UuidUtils.generatorUUID();
        TSqrxxfjPO sqrxxfjDto = new TSqrxxfjPO();
        sqrxxfjDto.setId(uuid);
        sqrxxfjDto.setDz(reqInfo.getFilePath());
        sqrxxfjDto.setMc(reqInfo.getFileName());
        sqrxxfjDto.setSqrId(reqInfo.getSqrxxId());
        sqrxxfjService.add(sqrxxfjDto);
        return "true";

    }

}
