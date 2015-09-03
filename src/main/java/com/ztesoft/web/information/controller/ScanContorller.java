package com.ztesoft.web.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.information.domain.req.scan.FileScanReqInfo;
import com.ztesoft.web.information.domain.req.scan.IdScanReqInfo;

/**
 * 证件扫描控制类
 * 包含证件扫描和文件扫描
 * @author Ocean
 *
 */
@Controller
@RequestMapping(value="/scan")
public class ScanContorller {
	  private static final ZTEsoftLogManager logger = ZTEsoftLogManager
	            .getLogger(ScanContorller.class);
	  
	  
	   /**
	    * 调用第三方接口扫描身份证信息。并将图片保存到本地制定位置后同时上传到前台
	    * 与此同时接受uuid值
	    * 
	    */
	  @RequestMapping("/idCardScan")
	  @ResponseBody
      public String  idCardScan(IdScanReqInfo reqInfo){
		  //更新文件操作日志
		  
		  return "true";
		   
	  }
      /**
       * 调用第三方接口扫描文件信息。并将图片保存到本地制定位置后同时上传到前台
       * 
       */
	  @RequestMapping("/fileScan")
	  @ResponseBody
      public String fileScan(FileScanReqInfo reqInfo){
		  //更新文件操作日志
		  
		  return "true";
    	  
      }

}
