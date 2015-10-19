/**
 * 
 */
package com.ztesoft.web.information.domain.resp;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月12日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.domain.resp <br>
 */

public class ReportResultDto extends AbstractDto {
    private String czdw;// 操作单位

    private String dwmc;// 单位名称

    private int fwcs;// 服务次数

    private int cxcs;// 查询次数

    private int cxcgcs;// 查询成功次数

    private int totalRows;// 总行数

    /**
     * @return the totalRows
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * @param totalRows the totalRows to set
     */
    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    /**
     * @return the czdw
     */
    public String getCzdw() {
        return czdw;
    }

    /**
     * @param czdw the czdw to set
     */
    public void setCzdw(String czdw) {
        this.czdw = czdw;
    }

    /**
     * @return the dwmc
     */
    public String getDwmc() {
        return dwmc;
    }

    /**
     * @param dwmc the dwmc to set
     */
    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    /**
     * @return the fwcs
     */
    public int getFwcs() {
        return fwcs;
    }

    /**
     * @param fwcs the fwcs to set
     */
    public void setFwcs(int fwcs) {
        this.fwcs = fwcs;
    }

    /**
     * @return the cxcs
     */
    public int getCxcs() {
        return cxcs;
    }

    /**
     * @param cxcs the cxcs to set
     */
    public void setCxcs(int cxcs) {
        this.cxcs = cxcs;
    }

    /**
     * @return the cxcgcs
     */
    public int getCxcgcs() {
        return cxcgcs;
    }

    /**
     * @param cxcgcs the cxcgcs to set
     */
    public void setCxcgcs(int cxcgcs) {
        this.cxcgcs = cxcgcs;
    }

}
