/**
 * 
 */
package com.ztesoft.web.information.domain.resp;

import com.ztesoft.framework.dto.AbstractDto;

/**
 * <Description>全局窗口报表 展现数据<br>
 * ['10', '律师'], ['20', '党政军机关'], ['30', '司法机关'], ['40', '企事业单位'], ['50', '个人'], ['60', '人民团体'], ['70', '其他']
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月12日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.domain.resp <br>
 */

public class ReportFullResultDto extends AbstractDto {

    public ReportFullResultDto() {

    }

    public ReportFullResultDto(String czdw, String dwmc) {
        this.czdw = czdw;
        this.dwmc = dwmc;
    }

    private String czdw;// 操作单位

    private String dwmc;// 单位名称

    private boolean isSumRow = false;// 是否是小计行，每个分局小计一次

    /**
     * ['10', '律师']
     */
    private String sqrlx10 = "10";

    private String sqrlxmc10 = "律师";

    private int fwcs10;// 服务次数

    private int cxcs10;// 查询次数

    private int cxcgcs10;// 查询成功次数

    /**
     * ['20', '党政军机关']
     */
    private String sqrlx20 = "20";

    private String sqrlxmc20 = "党政军机关";

    private int fwcs20;// 服务次数

    private int cxcs20;// 查询次数

    private int cxcgcs20;// 查询成功次数

    /**
     * ['30', '司法机关']
     */
    private String sqrlx30 = "30";

    private String sqrlxmc30 = "司法机关";

    private int fwcs30;// 服务次数

    private int cxcs30;// 查询次数

    private int cxcgcs30;// 查询成功次数

    /**
     * ['40', '企事业单位']
     */
    private String sqrlx40 = "40";

    private String sqrlxmc40 = "企事业单位";

    private int fwcs40;// 服务次数

    private int cxcs40;// 查询次数

    private int cxcgcs40;// 查询成功次数

    /**
     * ['50', '个人']
     */
    private String sqrlx50 = "50";

    private String sqrlxmc50 = "个人";

    private int fwcs50;// 服务次数

    private int cxcs50;// 查询次数

    private int cxcgcs50;// 查询成功次数

    /**
     * ['60', '人民团体']
     */
    private String sqrlx60 = "60";

    private String sqrlxmc60 = "人民团体";

    private int fwcs60;// 服务次数

    private int cxcs60;// 查询次数

    private int cxcgcs60;// 查询成功次数

    /**
     * ['70', '其他']
     */
    private String sqrlx70 = "70";

    private String sqrlxmc70 = "其他";

    private int fwcs70;// 服务次数

    private int cxcs70;// 查询次数

    private int cxcgcs70;// 查询成功次数

    /**
     * 合计
     */
    private int fwcssum;// 服务次数合计

    private int cxcssum;// 查询次数合计

    private int cxcgcssum;// 查询成功次数合计

    private String cxsqrlx;// 查询申请人类型

    private String cxsqrlxmc;// 查询申请人类型名称

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
     * @return the isSumRow
     */
    public boolean isSumRow() {
        return isSumRow;
    }

    /**
     * @param isSumRow the isSumRow to set
     */
    public void setSumRow(boolean isSumRow) {
        this.isSumRow = isSumRow;
    }

    /**
     * @return the sqrlx10
     */
    public String getSqrlx10() {
        return sqrlx10;
    }

    /**
     * @param sqrlx10 the sqrlx10 to set
     */
    public void setSqrlx10(String sqrlx10) {
        this.sqrlx10 = sqrlx10;
    }

    /**
     * @return the sqrlxmc10
     */
    public String getSqrlxmc10() {
        return sqrlxmc10;
    }

    /**
     * @param sqrlxmc10 the sqrlxmc10 to set
     */
    public void setSqrlxmc10(String sqrlxmc10) {
        this.sqrlxmc10 = sqrlxmc10;
    }

    /**
     * @return the fwcs10
     */
    public int getFwcs10() {
        return fwcs10;
    }

    /**
     * @param fwcs10 the fwcs10 to set
     */
    public void setFwcs10(int fwcs10) {
        this.fwcs10 = fwcs10;
    }

    /**
     * @return the cxcs10
     */
    public int getCxcs10() {
        return cxcs10;
    }

    /**
     * @param cxcs10 the cxcs10 to set
     */
    public void setCxcs10(int cxcs10) {
        this.cxcs10 = cxcs10;
    }

    /**
     * @return the cxcgcs10
     */
    public int getCxcgcs10() {
        return cxcgcs10;
    }

    /**
     * @param cxcgcs10 the cxcgcs10 to set
     */
    public void setCxcgcs10(int cxcgcs10) {
        this.cxcgcs10 = cxcgcs10;
    }

    /**
     * @return the sqrlx20
     */
    public String getSqrlx20() {
        return sqrlx20;
    }

    /**
     * @param sqrlx20 the sqrlx20 to set
     */
    public void setSqrlx20(String sqrlx20) {
        this.sqrlx20 = sqrlx20;
    }

    /**
     * @return the sqrlxmc20
     */
    public String getSqrlxmc20() {
        return sqrlxmc20;
    }

    /**
     * @param sqrlxmc20 the sqrlxmc20 to set
     */
    public void setSqrlxmc20(String sqrlxmc20) {
        this.sqrlxmc20 = sqrlxmc20;
    }

    /**
     * @return the fwcs20
     */
    public int getFwcs20() {
        return fwcs20;
    }

    /**
     * @param fwcs20 the fwcs20 to set
     */
    public void setFwcs20(int fwcs20) {
        this.fwcs20 = fwcs20;
    }

    /**
     * @return the cxcs20
     */
    public int getCxcs20() {
        return cxcs20;
    }

    /**
     * @param cxcs20 the cxcs20 to set
     */
    public void setCxcs20(int cxcs20) {
        this.cxcs20 = cxcs20;
    }

    /**
     * @return the cxcgcs20
     */
    public int getCxcgcs20() {
        return cxcgcs20;
    }

    /**
     * @param cxcgcs20 the cxcgcs20 to set
     */
    public void setCxcgcs20(int cxcgcs20) {
        this.cxcgcs20 = cxcgcs20;
    }

    /**
     * @return the sqrlx30
     */
    public String getSqrlx30() {
        return sqrlx30;
    }

    /**
     * @param sqrlx30 the sqrlx30 to set
     */
    public void setSqrlx30(String sqrlx30) {
        this.sqrlx30 = sqrlx30;
    }

    /**
     * @return the sqrlxmc30
     */
    public String getSqrlxmc30() {
        return sqrlxmc30;
    }

    /**
     * @param sqrlxmc30 the sqrlxmc30 to set
     */
    public void setSqrlxmc30(String sqrlxmc30) {
        this.sqrlxmc30 = sqrlxmc30;
    }

    /**
     * @return the fwcs30
     */
    public int getFwcs30() {
        return fwcs30;
    }

    /**
     * @param fwcs30 the fwcs30 to set
     */
    public void setFwcs30(int fwcs30) {
        this.fwcs30 = fwcs30;
    }

    /**
     * @return the cxcs30
     */
    public int getCxcs30() {
        return cxcs30;
    }

    /**
     * @param cxcs30 the cxcs30 to set
     */
    public void setCxcs30(int cxcs30) {
        this.cxcs30 = cxcs30;
    }

    /**
     * @return the cxcgcs30
     */
    public int getCxcgcs30() {
        return cxcgcs30;
    }

    /**
     * @param cxcgcs30 the cxcgcs30 to set
     */
    public void setCxcgcs30(int cxcgcs30) {
        this.cxcgcs30 = cxcgcs30;
    }

    /**
     * @return the sqrlx40
     */
    public String getSqrlx40() {
        return sqrlx40;
    }

    /**
     * @param sqrlx40 the sqrlx40 to set
     */
    public void setSqrlx40(String sqrlx40) {
        this.sqrlx40 = sqrlx40;
    }

    /**
     * @return the sqrlxmc40
     */
    public String getSqrlxmc40() {
        return sqrlxmc40;
    }

    /**
     * @param sqrlxmc40 the sqrlxmc40 to set
     */
    public void setSqrlxmc40(String sqrlxmc40) {
        this.sqrlxmc40 = sqrlxmc40;
    }

    /**
     * @return the fwcs40
     */
    public int getFwcs40() {
        return fwcs40;
    }

    /**
     * @param fwcs40 the fwcs40 to set
     */
    public void setFwcs40(int fwcs40) {
        this.fwcs40 = fwcs40;
    }

    /**
     * @return the cxcs40
     */
    public int getCxcs40() {
        return cxcs40;
    }

    /**
     * @param cxcs40 the cxcs40 to set
     */
    public void setCxcs40(int cxcs40) {
        this.cxcs40 = cxcs40;
    }

    /**
     * @return the cxcgcs40
     */
    public int getCxcgcs40() {
        return cxcgcs40;
    }

    /**
     * @param cxcgcs40 the cxcgcs40 to set
     */
    public void setCxcgcs40(int cxcgcs40) {
        this.cxcgcs40 = cxcgcs40;
    }

    /**
     * @return the sqrlx50
     */
    public String getSqrlx50() {
        return sqrlx50;
    }

    /**
     * @param sqrlx50 the sqrlx50 to set
     */
    public void setSqrlx50(String sqrlx50) {
        this.sqrlx50 = sqrlx50;
    }

    /**
     * @return the sqrlxmc50
     */
    public String getSqrlxmc50() {
        return sqrlxmc50;
    }

    /**
     * @param sqrlxmc50 the sqrlxmc50 to set
     */
    public void setSqrlxmc50(String sqrlxmc50) {
        this.sqrlxmc50 = sqrlxmc50;
    }

    /**
     * @return the fwcs50
     */
    public int getFwcs50() {
        return fwcs50;
    }

    /**
     * @param fwcs50 the fwcs50 to set
     */
    public void setFwcs50(int fwcs50) {
        this.fwcs50 = fwcs50;
    }

    /**
     * @return the cxcs50
     */
    public int getCxcs50() {
        return cxcs50;
    }

    /**
     * @param cxcs50 the cxcs50 to set
     */
    public void setCxcs50(int cxcs50) {
        this.cxcs50 = cxcs50;
    }

    /**
     * @return the cxcgcs50
     */
    public int getCxcgcs50() {
        return cxcgcs50;
    }

    /**
     * @param cxcgcs50 the cxcgcs50 to set
     */
    public void setCxcgcs50(int cxcgcs50) {
        this.cxcgcs50 = cxcgcs50;
    }

    /**
     * @return the sqrlx60
     */
    public String getSqrlx60() {
        return sqrlx60;
    }

    /**
     * @param sqrlx60 the sqrlx60 to set
     */
    public void setSqrlx60(String sqrlx60) {
        this.sqrlx60 = sqrlx60;
    }

    /**
     * @return the sqrlxmc60
     */
    public String getSqrlxmc60() {
        return sqrlxmc60;
    }

    /**
     * @param sqrlxmc60 the sqrlxmc60 to set
     */
    public void setSqrlxmc60(String sqrlxmc60) {
        this.sqrlxmc60 = sqrlxmc60;
    }

    /**
     * @return the fwcs60
     */
    public int getFwcs60() {
        return fwcs60;
    }

    /**
     * @param fwcs60 the fwcs60 to set
     */
    public void setFwcs60(int fwcs60) {
        this.fwcs60 = fwcs60;
    }

    /**
     * @return the cxcs60
     */
    public int getCxcs60() {
        return cxcs60;
    }

    /**
     * @param cxcs60 the cxcs60 to set
     */
    public void setCxcs60(int cxcs60) {
        this.cxcs60 = cxcs60;
    }

    /**
     * @return the cxcgcs60
     */
    public int getCxcgcs60() {
        return cxcgcs60;
    }

    /**
     * @param cxcgcs60 the cxcgcs60 to set
     */
    public void setCxcgcs60(int cxcgcs60) {
        this.cxcgcs60 = cxcgcs60;
    }

    /**
     * @return the sqrlx70
     */
    public String getSqrlx70() {
        return sqrlx70;
    }

    /**
     * @param sqrlx70 the sqrlx70 to set
     */
    public void setSqrlx70(String sqrlx70) {
        this.sqrlx70 = sqrlx70;
    }

    /**
     * @return the sqrlxmc70
     */
    public String getSqrlxmc70() {
        return sqrlxmc70;
    }

    /**
     * @param sqrlxmc70 the sqrlxmc70 to set
     */
    public void setSqrlxmc70(String sqrlxmc70) {
        this.sqrlxmc70 = sqrlxmc70;
    }

    /**
     * @return the fwcs70
     */
    public int getFwcs70() {
        return fwcs70;
    }

    /**
     * @param fwcs70 the fwcs70 to set
     */
    public void setFwcs70(int fwcs70) {
        this.fwcs70 = fwcs70;
    }

    /**
     * @return the cxcs70
     */
    public int getCxcs70() {
        return cxcs70;
    }

    /**
     * @param cxcs70 the cxcs70 to set
     */
    public void setCxcs70(int cxcs70) {
        this.cxcs70 = cxcs70;
    }

    /**
     * @return the cxcgcs70
     */
    public int getCxcgcs70() {
        return cxcgcs70;
    }

    /**
     * @param cxcgcs70 the cxcgcs70 to set
     */
    public void setCxcgcs70(int cxcgcs70) {
        this.cxcgcs70 = cxcgcs70;
    }

    /**
     * @return the fwcssum
     */
    public int getFwcssum() {
        return fwcssum;
    }

    /**
     * @param fwcssum the fwcssum to set
     */
    public void setFwcssum(int fwcssum) {
        this.fwcssum = fwcssum;
    }

    /**
     * @return the cxcssum
     */
    public int getCxcssum() {
        return cxcssum;
    }

    /**
     * @param cxcssum the cxcssum to set
     */
    public void setCxcssum(int cxcssum) {
        this.cxcssum = cxcssum;
    }

    /**
     * @return the cxcgcssum
     */
    public int getCxcgcssum() {
        return cxcgcssum;
    }

    /**
     * @param cxcgcssum the cxcgcssum to set
     */
    public void setCxcgcssum(int cxcgcssum) {
        this.cxcgcssum = cxcgcssum;
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


}
