package com.ztesoft.web.information.domain.resp;

import java.util.List;

/**
 * 暂住人口信息
 * 
 * @author Ocean
 */

public class TRpopulationInfo {
    // 人口基本信息
    private PopulationBaseInfo baseInfo;

    // 暂住信息集
    private List<TRinfo> trInfoList;

    // 操作单位
    private String czdw;

    // 操作人
    private String czr;

    // 打印日期
    private String dyrq;

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
     * @return the dyrq
     */
    public String getDyrq() {
        return dyrq;
    }

    /**
     * @param dyrq the dyrq to set
     */
    public void setDyrq(String dyrq) {
        this.dyrq = dyrq;
    }

    public PopulationBaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(PopulationBaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<TRinfo> getTrInfoList() {
        return trInfoList;
    }

    public void setTrInfoList(List<TRinfo> trInfoList) {
        this.trInfoList = trInfoList;
    }

}
