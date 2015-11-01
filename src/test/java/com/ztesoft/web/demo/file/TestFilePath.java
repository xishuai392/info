/**
 * 
 */
package com.ztesoft.web.demo.file;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.print.DocFlavor.URL;

import com.ztesoft.framework.util.DateUtils;

/** 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月26日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.file <br>
 */

public class TestFilePath {

    public static String getSubPath() {
        Date thizDate = new Date();
        String subPath = DateUtils.date2String(thizDate,
                DateUtils.STR_DATE_FORMAT_MONTH_WITHOUT_SPLIT);
        subPath += File.separator
                + DateUtils.date2String(thizDate,
                        DateUtils.STR_DATE_FORMAT_DAY_SPLIT);
        return subPath;
    }
    
    /**
     * @param args
     * @throws URISyntaxException 
     */
    public static void main(String[] args) throws URISyntaxException {

        File targetFile = new File(TestFilePath.getSubPath());
        System.out.println(targetFile.toPath().toString());
        System.out.println(targetFile.toURI().getRawPath());
        System.out.println(targetFile.toString());
        System.out.println(new URI(TestFilePath.getSubPath()));
    }

}
