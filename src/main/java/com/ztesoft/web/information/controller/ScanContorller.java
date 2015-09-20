package com.ztesoft.web.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.UuidUtils;
import com.ztesoft.web.information.db.po.TSqrxxfjPO;
import com.ztesoft.web.information.domain.req.scan.FileScanReqInfo;
import com.ztesoft.web.information.domain.req.scan.ScanReqInfo;
import com.ztesoft.web.information.service.ITSqrxxfjService;

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
	  
	     @Autowired
	  private ITSqrxxfjService sqrxxfjService;
	   /**
	    * 调用第三方接口扫描身份证信息。并将图片保存到本地制定位置后同时上传到前台
	    * 与此同时接受uuid值
	 * @throws BaseAppException 
	    * 
	    */
	  @RequestMapping("/idCardScan")
	  @ResponseBody
      public String  idCardScan(ScanReqInfo reqInfo) throws BaseAppException{
		  //更新文件操作日志
		  String uuid=UuidUtils.generatorUUID();
	      TSqrxxfjPO sqrxxfjDto=new TSqrxxfjPO();
	      sqrxxfjDto.setId(uuid);
	      sqrxxfjDto.setDz(reqInfo.getFilePath());
	      sqrxxfjDto.setMc(reqInfo.getFileName());
	      sqrxxfjDto.setSqrId(reqInfo.getSqrxxId());
	       sqrxxfjService.add(sqrxxfjDto);
		  return "true";
		   
	  }
      /**
       * 调用第三方接口扫描文件信息。并将图片保存到本地制定位置后同时上传到前台
     * @throws BaseAppException 
       * 
       */
	  @RequestMapping("/fileScan")
	  @ResponseBody
      public String fileScan(ScanReqInfo reqInfo) throws BaseAppException{
		  //更新文件操作日志
		  //更新文件操作日志
		  String uuid=UuidUtils.generatorUUID();
	      TSqrxxfjPO sqrxxfjDto=new TSqrxxfjPO();
	      sqrxxfjDto.setId(uuid);
	      sqrxxfjDto.setDz(reqInfo.getFilePath());
	      sqrxxfjDto.setMc(reqInfo.getFileName());
	      sqrxxfjDto.setSqrId(reqInfo.getSqrxxId());
	      sqrxxfjService.add(sqrxxfjDto);
		  return "true";
    	  
      }

}
