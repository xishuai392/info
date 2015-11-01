/**
 * 
 */
package com.ztesoft.web.information.domain.req;

import java.util.Date;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月12日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.domain.req <br>
 */

public class ReportQueryDto extends AbstractDto {

    private Date startDate;// 开始日期

    private String startDateStr;// 开始日期

    private Date endDate;// 结束日期

    private String endDateStr;// 结束日期

    private String czdw;// 操作单位
    
    private String czr;// 操作人（终端：终端名）

    private String cxbs;// 查询标识：10：终端，20：pc端

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
     * @return the startDateStr
     */
    public String getStartDateStr() {
        return startDateStr;
    }

    /**
     * @param startDateStr the startDateStr to set
     */
    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    /**
     * @return the endDateStr
     */
    public String getEndDateStr() {
        return endDateStr;
    }

    /**
     * @param endDateStr the endDateStr to set
     */
    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    /**
     * @return the cxbs
     */
    public String getCxbs() {
        return cxbs;
    }

    /**
     * @param cxbs the cxbs to set
     */
    public void setCxbs(String cxbs) {
        this.cxbs = cxbs;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

}
