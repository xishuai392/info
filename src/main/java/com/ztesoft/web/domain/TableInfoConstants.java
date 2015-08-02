/**
 * 
 */
package com.ztesoft.web.domain;

/**
 * <Description>数据库表名、主键字段等常量定义类 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月27日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.domain <br>
 */

public final class TableInfoConstants {
    /** 用户表AM_USER */
    public static final String AM_USER = "AM_USER";

    /** 用户表AM_USER */
    public static final String AM_USER_PKFIELD = "USER_ID";

    public static final String DB_META = "DB_META";

    public static final String DB_META_PKFIELD = "ID";

    public static final String DB_TABLE = "DB_TABLE";

    public static final String DB_TABLE_PKFIELD = "ID";

    public static final String DB_COLUMN = "DB_COLUMN";

    public static final String DB_COLUMN_PKFIELD = "ID";

    // 组织、用户、角色表 start
    public static final String AUDIT_MENU = "AUDIT_MENU";

    public static final String AUDIT_MENU_PKFIELD = "MENU_ID";

    public static final String AUDIT_MENU_ROLE = "AUDIT_MENU_ROLE";

    public static final String AUDIT_MENU_ROLE_PKFIELD = "MENU_ROLE_ID";

    public static final String AUDIT_ORGANIZATION = "AUDIT_ORGANIZATION";

    public static final String AUDIT_ORGANIZATION_PKFIELD = "ORG_ID";

    public static final String AUDIT_ROLE = "AUDIT_ROLE";

    public static final String AUDIT_ROLE_PKFIELD = "ROLE_ID";

    public static final String AUDIT_USER = "AUDIT_USER";

    public static final String AUDIT_USER_PKFIELD = "USER_ID";

    public static final String AUDIT_USER_ROLE = "AUDIT_USER_ROLE";

    public static final String AUDIT_USER_ROLE_PKFIELD = "USER_ROLE_ID";
    // 组织、用户、角色表 end
}
