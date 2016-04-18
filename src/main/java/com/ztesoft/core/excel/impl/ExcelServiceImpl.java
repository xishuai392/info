/**
 * 
 */
package com.ztesoft.core.excel.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import com.ztesoft.core.excel.IExcelService;

/**
 * <Description>创建并获取Excel的服务类 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.excel.impl <br>
 */
public class ExcelServiceImpl implements IExcelService {

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.IExcelService#getExcelInputStream(java.lang.String, java.util.List, java.lang.String, java.util.List)
     */
    @Override
    public InputStream getExcelInputStream(String clazz, List<?> datas,
            String title, List<String> fieldsName) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            createExcel(clazz, datas, title, fieldsName).write(os);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        return is;
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.IExcelService#createExcel(java.lang.String, java.util.List, java.lang.String, java.util.List)
     */
    @Override
    public HSSFWorkbook createExcel(String clazz, List<?> datas, String title,
            List<String> fieldsName) throws Exception {
        CreateExcelImpl createExcel = new CreateExcelImpl(clazz, fieldsName);
        // 创建标题、表头、以及单元格数据
        createExcel.setTitle(title).setHead().setCellData(datas);
        return createExcel.getWb();
    }

}
