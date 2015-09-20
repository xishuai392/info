package com.ztesoft.web.information.db.po;

import java.math.*;
import java.util.*;
import org.apache.commons.lang.StringUtils;
import com.ztesoft.framework.dto.AbstractDto;
/**
 * create table T_SQRXX
(
   ID                   varchar(32) not null comment '编号',
   ZJH                  varchar(60) comment '证件号',
   ZJLX                 varchar(10) comment '证件类型（10：身份证，20：其他）',
   XM                   varchar(30) comment '姓名',
   CXSQRLX              varchar(10) comment '查询申请人类型（10：律师，20：党政军机关，30：司法机关，40：企事业单位，50：个人，60：人民团体，70：其他）',
   CXRDW                varchar(100) comment '查询人单位',
   CXSY                 varchar(300) comment '查询事由',
   CXRQ                 varchar(10) comment '查询日期',
   CZDW                 varchar(32) comment '操作单位',
   CZR                  varchar(32) comment '操作人',
   CXBS                 varchar(10) comment '10：终端，20：pc端',
   primary key (ID)
);

 * @author Ocean
 *
 */
public class TSqrxxPO extends AbstractDto{
	private String  id;
	//证件号
	private String  zjh;
	//证件类型
	private String  zjlx;
	//姓名
	private String  xm;
	//查询申请人类型
	private String  cxsqrlx;
	//查询人单位
	private String  cxrdw;
	//
	private String  cxsy;
	private String  cxrq;
	private String  czdw;
	private String  czr;
	private String  cxbs;
    public String getId() {
        return StringUtils.isBlank(id) ? id : id.trim();
    }
    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getZjh() {
        return StringUtils.isBlank(zjh) ? zjh : zjh.trim();
    }
    public void setZjh(String zjh) {
        this.zjh = zjh;
    }
    
    
    public String getZjlx() {
        return StringUtils.isBlank(zjlx) ? zjlx : zjlx.trim();
    }
    public void setZjlx(String zjlx) {
        this.zjlx = zjlx;
    }
    
    
    public String getXm() {
        return StringUtils.isBlank(xm) ? xm : xm.trim();
    }
    public void setXm(String xm) {
        this.xm = xm;
    }
    
    
    public String getCxsqrlx() {
        return StringUtils.isBlank(cxsqrlx) ? cxsqrlx : cxsqrlx.trim();
    }
    public void setCxsqrlx(String cxsqrlx) {
        this.cxsqrlx = cxsqrlx;
    }
    
    
    public String getCxrdw() {
        return StringUtils.isBlank(cxrdw) ? cxrdw : cxrdw.trim();
    }
    public void setCxrdw(String cxrdw) {
        this.cxrdw = cxrdw;
    }
    
    
    public String getCxsy() {
        return StringUtils.isBlank(cxsy) ? cxsy : cxsy.trim();
    }
    public void setCxsy(String cxsy) {
        this.cxsy = cxsy;
    }
    
    
    public String getCxrq() {
        return StringUtils.isBlank(cxrq) ? cxrq : cxrq.trim();
    }
    public void setCxrq(String cxrq) {
        this.cxrq = cxrq;
    }
    
    
    public String getCzdw() {
        return StringUtils.isBlank(czdw) ? czdw : czdw.trim();
    }
    public void setCzdw(String czdw) {
        this.czdw = czdw;
    }
    
    
    public String getCzr() {
        return StringUtils.isBlank(czr) ? czr : czr.trim();
    }
    public void setCzr(String czr) {
        this.czr = czr;
    }
    
    
    public String getCxbs() {
        return StringUtils.isBlank(cxbs) ? cxbs : cxbs.trim();
    }
    public void setCxbs(String cxbs) {
        this.cxbs = cxbs;
    }
    
    
}