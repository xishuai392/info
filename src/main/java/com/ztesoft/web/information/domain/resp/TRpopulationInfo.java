package com.ztesoft.web.information.domain.resp;

import java.util.List;

import com.ztesoft.web.information.db.po.TBcxrxxPO;
import com.ztesoft.web.information.db.po.TSqrxxPO;

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

    // 以上查询信息仅作为..............
    private String tipMessage;

    // 操作单位
    private String czdw;

    // 操作人
    private String czr;

    // 打印日期
    private String dyrq;

    // 申请人
    private TSqrxxPO sqrxxPO;

    // 被查询人
    private TBcxrxxPO bcxrxxPO;

    /**
     * @return the sqrxxPO
     */
    public TSqrxxPO getSqrxxPO() {
        return sqrxxPO;
    }

    /**
     * @param sqrxxPO the sqrxxPO to set
     */
    public void setSqrxxPO(TSqrxxPO sqrxxPO) {
        this.sqrxxPO = sqrxxPO;
    }

    /**
     * @return the bcxrxxPO
     */
    public TBcxrxxPO getBcxrxxPO() {
        return bcxrxxPO;
    }

    /**
     * @param bcxrxxPO the bcxrxxPO to set
     */
    public void setBcxrxxPO(TBcxrxxPO bcxrxxPO) {
        this.bcxrxxPO = bcxrxxPO;
    }

    /**
     * @return the tipMessage
     */
    public String getTipMessage() {
        return tipMessage;
    }

    /**
     * @param tipMessage the tipMessage to set
     */
    public void setTipMessage(String tipMessage) {
        this.tipMessage = tipMessage;
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
