/**
 * 
 */
package com.ztesoft.core.excel.impl;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Component;

import com.ztesoft.core.excel.ICreateExcel;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.excel.impl <br>
 */
public class CreateExcelImpl implements ICreateExcel {
    private HSSFWorkbook wb = null;

    private HSSFSheet sheet = null;

    private HSSFRow row = null;

    private HSSFCell cell = null;

    private ExcelInfoImpl excelInfo = null;

    private int rowNum = 0; // 当前需要创建的行数，初始化为0

    /**
     * 初始化HSSFWorkbook，并默认创建一个sheet
     * 
     * @param className
     * @param fieldsName
     */
    public CreateExcelImpl(String className, List<String> fieldsName) {
        wb = new HSSFWorkbook();
        createSheet("sheet1");
        excelInfo = new ExcelInfoImpl(className, fieldsName);
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.ICreateExcel#createSheet(java.lang.String)
     */
    @Override
    public void createSheet(String sheetName) {
        sheet = wb.createSheet(sheetName);

    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.ICreateExcel#createRow()
     */
    @Override
    public void createRow() {
        row = sheet.createRow(rowNum);
        rowNum++;

    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.ICreateExcel#createCell(int)
     */
    @Override
    public void createCell(int cellNum) {
        cell = row.createCell(cellNum);

    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.ICreateExcel#setCell(java.lang.String, int)
     */
    @Override
    public void setCell(String data, int cellNum) {
        createCell(cellNum);
        // cell.setEncoding(HSSFCell.ENCODING_UTF_16);
        cell.setCellValue(data);

    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.ICreateExcel#setTitle(java.lang.String)
     */
    @Override
    public ICreateExcel setTitle(String title) {
        this.createRow();
        this.createCell(0);

        HSSFFont titlefont = wb.createFont();
        titlefont.setFontName("Arial");
        titlefont.setBoldweight(titlefont.BOLDWEIGHT_BOLD);
        titlefont.setFontHeight((short) 320);
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFont(titlefont);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell.setCellStyle(titleStyle);
        // cell.setEncoding(HSSFCell.ENCODING_UTF_16);

        cell.setCellValue(title);
        sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0,
                (short) (excelInfo.getNum() - 1)));
        // rowNum++;

        this.createRow();
        this.createCell(0);
        // cell.setCellStyle(titleStyle);
        cell.setCellValue("生成时间：" + DateUtil.getExcelDate(new Date()));
        // System.out.println(rowNum);
        sheet.addMergedRegion(new CellRangeAddress(rowNum - 1,
                (short) (rowNum - 1), 0, (short) (excelInfo.getNum() - 1)));
        return this;
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.ICreateExcel#setHead()
     */
    @Override
    public ICreateExcel setHead() {
        List<String> datas = excelInfo.getPropertyNames();
        if (datas.size() == 0) {
            datas = excelInfo.getHeaders();
        }
        createRow();
        for (int i = 0; i < datas.size(); i++) {
            setCell((String) datas.get(i), i);
        }
        return this;
    }

    /*
     * (non-Javadoc)
     * @see com.ztesoft.core.excel.ICreateExcel#setCellData(java.util.List)
     */
    @Override
    public ICreateExcel setCellData(List<?> datas) throws Exception {
        List<String> list = excelInfo.getPropertys();

        for (int j = 0; j < datas.size(); j++) {
            Object obj = datas.get(j);
            createRow();
            for (int i = 0; i < list.size(); i++) {
                setCell(excelInfo.getContent(obj, list.get(i)), i);
            }
        }
        return this;
    }

    /**
     * 获取HSSFWorkbook
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:36:26
     * @return
     */
    public HSSFWorkbook getWb() {
        return wb;
    }
}
