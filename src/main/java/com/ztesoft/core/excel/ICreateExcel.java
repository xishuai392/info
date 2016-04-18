/**
 * 
 */
package com.ztesoft.core.excel;

import java.util.List;

/**
 * <Description>创建Excel接口 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年4月10日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.excel <br>
 */

public interface ICreateExcel {

    /**
     * 创建一个sheet
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:25:30
     * @param sheetName
     */
    public void createSheet(String sheetName);

    /**
     * 创建一行
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:25:38
     */
    public void createRow();

    /**
     * 创建一个单元格
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:25:48
     * @param cellNum
     */
    public void createCell(int cellNum);

    /**
     * 设置一个单元格内容
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:26:03
     * @param data
     * @param cellNum
     */
    public void setCell(String data, int cellNum);

    /**
     * 设置标题内容
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:26:13
     * @param title
     * @return
     */
    public ICreateExcel setTitle(String title);

    /**
     * 设置表头内容
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:26:22
     * @return
     */
    public ICreateExcel setHead();

    /**
     * 设置单元格内容
     * 
     * @author: panxb
     * @date: 2011-8-10 上午10:26:30
     * @param datas
     * @return
     * @throws Exception
     */
    public ICreateExcel setCellData(List<?> datas) throws Exception;
}
