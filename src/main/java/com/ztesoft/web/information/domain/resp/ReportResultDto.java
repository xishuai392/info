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

    private int cxcsTotalRows;// 查询次数的总行数

    private int cxcgcsTotalRows;// 查询成功次数的总行数

    private int dycs;// 打印次数

    private String czr;// 操作人 （终端：终端名）

    private String cxsqrlx;// 查询申请人类型

    private String cxsqrlxmc;// 查询申请人类型名称
    
    
    

    /**
     * @return the cxcsTotalRows
     */
    public int getCxcsTotalRows() {
        return cxcsTotalRows;
    }

    /**
     * @param cxcsTotalRows the cxcsTotalRows to set
     */
    public void setCxcsTotalRows(int cxcsTotalRows) {
        this.cxcsTotalRows = cxcsTotalRows;
    }

    /**
     * @return the cxcgcsTotalRows
     */
    public int getCxcgcsTotalRows() {
        return cxcgcsTotalRows;
    }

    /**
     * @param cxcgcsTotalRows the cxcgcsTotalRows to set
     */
    public void setCxcgcsTotalRows(int cxcgcsTotalRows) {
        this.cxcgcsTotalRows = cxcgcsTotalRows;
    }

    /**
     * @return the cxsqrlx
     */
    public String getCxsqrlx() {
        return cxsqrlx;
    }

    /**
     * @param cxsqrlx the cxsqrlx to set
     */
    public void setCxsqrlx(String cxsqrlx) {
        this.cxsqrlx = cxsqrlx;
    }

    /**
     * @return the cxsqrlxmc
     */
    public String getCxsqrlxmc() {
        return cxsqrlxmc;
    }

    /**
     * @param cxsqrlxmc the cxsqrlxmc to set
     */
    public void setCxsqrlxmc(String cxsqrlxmc) {
        this.cxsqrlxmc = cxsqrlxmc;
    }

    /**
     * @return the dycs
     */
    public int getDycs() {
        return dycs;
    }

    /**
     * @param dycs the dycs to set
     */
    public void setDycs(int dycs) {
        this.dycs = dycs;
    }

    /**
     * @return the czr
     */
    public String getCzr() {
        return czr;
    }

    /**
     * @param czr the czr to set
     */
    public void setCzr(String czr) {
        this.czr = czr;
    }

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
