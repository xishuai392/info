/**
 * 
 */
package com.ztesoft.core.excel;

import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * <Description> <br> 
 *  
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.excel <br>
 */

public interface IExcelService {
    /**
     * 获取Excel
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:30:50
     * @param clazz
     * @param datas
     * @param title
     * @param fieldsName
     * @return
     * @throws Exception
     */
    public InputStream getExcelInputStream(String clazz, List<?> datas,
            String title, List<String> fieldsName) throws Exception;

    /**
     * 创建Excel
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:31:04
     * @param clazz
     * @param datas
     * @param title
     * @param fieldsName
     * @return
     * @throws Exception
     */
    public HSSFWorkbook createExcel(String clazz, List<?> datas, String title,
            List<String> fieldsName) throws Exception;
}
