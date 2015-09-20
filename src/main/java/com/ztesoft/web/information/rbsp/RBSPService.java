package com.ztesoft.web.information.rbsp;
/**
常住人口基本信息数据查询服务方
常住人口户信息数据查询服务方
地址信息数据查询服务方
暂（居）住证信息数据查询服务方
流动人口登记信息数据查询服务方
实有人口相片信息数据查询服务方

 * @author Ocean
 *
 */
public class RBSPService {
	/**
	 * 常住人口基本信息数据查询服务方
	 * @return
	 */
	public String queryCZRKbaseInfo(String pid){
		return null;
	}
	/**
	 * 常住人口户信息数据查询服务方.根据户编号查询地址id
	 * @param huId
	 * @return
	 */
	public String queryCZRKCensusInfo(String huId){
		return null;
	}
	/**
	 * 地址信息数据查询服务方.根据地址id查询具体地址信息
	 * @param huId
	 * @return
	 */
	public String queryDZinfo(String metaAddrId){
		return null;
	}
	/**
	 * 暂（居）住证信息数据查询服务方.genuine
	 * @param pid
	 * @return
	 */
	public String queryZZRKInfo(String pid){
		return null;
		
	}
}
