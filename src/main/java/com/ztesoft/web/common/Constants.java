package com.ztesoft.web.common;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.ztesoft.core.spring.context.CustomPropertyConfigurer;

public class Constants {
	public static Logger logger = Logger.getLogger(Constants.class);
	
	/** int类型的NULL表示. */
	public static final int NULL_INT = -2147483648;

	/** float类型的NULL表示. */
	public static final float NULL_FLOAT = 1.4E-45F;

	/** double类型的NULL表示. */
	public static final double NULL_DOUBLE = 4.9E-324D;

	/** long类型的NULL表示. */
	public static final long NULL_LONG = -9999999999999998L; // -9223372036854775808L;
																// 前台JAVASCRIPT没有这么大的值

	/** String类型的NULL标识 */
	public static final String NULL_STRING = "";

	// 编码集设置

	/** GBK编码集. */
	public static final String GBK_ENCODING = "GBK";

	/** GB2312编码集. */
	public static final String GB2312_ENCODING = "GB2312";

	/** ISO-8859-1编码集. */
	public static final String ISO_8859_1_ENCODING = "ISO-8859-1";

	/** UTF-8编码集. */
	public static final String UTF_8_ENCODING = "UTF-8";
	
	/**
	 * 员工
	 */
	public static final String STAFF="staff";
	
	/**
	 * 员工权限
	 */
	public static final String STAFF_PRIVILEGE_LIST="staffPrivilegeList";
	/**
	 * 员工资源
	 */
	public static final String STAFF_RESOURCE_LIST="staffResourceList";
	/**
	 * 子系统
	 */
	public static final String STAFF_SUB_SYS_MAP="staffSubSysMap";
	
	public static final String STAFF_SUB_SYS_URL_MAP="staffSubSysUrlMap";
	
	public static final String STAFF_URL_MAP="staffUrlMap";
	
	public static final String STAFF_BUTTON_MAP="staffButtonMap";
	
	public static final String NO_PRIVILEGE_URL="noPrivilegeUrl";
	
	public static final String UPLOAD_PATH="uploadPath";
	
	public static final String SUBSYS_MENU="subsysMenu";
	
	public static String UPLOAD_URL;
	
	public static final String PRIVILEGE_RESOURCE_URL="/web/privilege/jsp/privilege.jsp";
	   
	/**
	 * 数据状态 ：
	 * PUBLISH（发布） -00A、APPROVED（审核通过） -00B、<br/>DISAPPROVE（审核不通过） -00C、CANCELLED（作废） -00X
	 */
	public enum Status {
		/**
		 * 发布 -00A
		 */
		PUBLISH("00A"),
		/**
		 * 审核通过 -00B
		 */
		APPROVED("00B"),
		/**
		 * 审核不通过 -00C
		 */
		DISAPPROVE("00C"),
		/**
		 * 作废 -00X
		 */
		CANCELLED("00X");
		
		private String status ;
		
		Status(String status){
			this.status = status ;
		}
		
		@Override
	    public String toString() {
	        return String.valueOf ( this.status );
	    }
	};
	
	/**
	 * 单点登录cookie
	 */
	public static final String SSO_COOKIE_KEY="sso";	

	public static void main(String[] args) throws FileNotFoundException,IOException {
	}

	public void init(){
		UPLOAD_URL = CustomPropertyConfigurer.getContextProperty("uploadPath").toString();
	}
}
