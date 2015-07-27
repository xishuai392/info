package com.ztesoft.web.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ztesoft.core.spring.context.CustomPropertyConfigurer;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.StringUtils;
import com.ztesoft.web.common.Configuration;

/**
 * <Description>自动生成代码 <br>
 * 
 * @author hu.bo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月11日 <br>
 * @since V1.0<br>
 */

@Controller
public class DownloadController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(DownloadController.class);
    private static String separator = System.getProperty("file.separator");
    @RequestMapping("download")
	public void sendRedirect(HttpServletRequest request,
            HttpServletResponse response) throws IOException{
//    	logger.debug("open url:{0}",strURL);
    	File resultFile = null ;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String fileName = request.getParameter("fileName");
        String filePath = request.getParameter("filePath");
        String fullPath = request.getParameter("fullPath");
        String relatePath = request.getParameter("relatePath");
        if(StringUtils.isNotEmpty(fullPath)){
        	String servletPath = request.getSession().getServletContext().getRealPath("/");
        	resultFile = new File(servletPath + fullPath);;
        }else if(StringUtils.isEmpty(filePath)){
            response.sendError(405, "filePath is null!");
            return;
        }
        if(StringUtils.isEmpty(fileName)){
            response.sendError(405, "fileName is null!");
            return;
        }
//        @SuppressWarnings("deprecation")
//        String WebRoot = request.getRealPath("");//获取项目的绝对路径
        if(StringUtils.isEmpty(fullPath)){
        	String annexPath = Configuration.getString("uploadPath");
        	resultFile = new File(annexPath + filePath);
        }
        FileInputStream resultFileFi = new FileInputStream(resultFile);
        long l = resultFile.length();
        int k = 0;
        byte abyte0[] = new byte[65000];
        response.setContentType("application/x-msdownload");
        response.setContentLength((int) l);
        if(StringUtils.isEmpty(fileName)){
            fileName = resultFile.getName();
        }else{
            fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
        }
        response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1") );
        while ((long) k < l) {
            int j;
            j = resultFileFi.read(abyte0, 0, 65000);
            k += j;
            response.getOutputStream().write(abyte0, 0, j);
        }
        resultFileFi.close();
//        resultFile.delete();
	}
    
}
