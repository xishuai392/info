package com.ztesoft.framework.util;

import java.util.Date;

/**
 * 常量类
 */
public final class FrameWorkConstants {

    private FrameWorkConstants() {
    }

    /**
     * CONFIG_PROPERTIES:config配置文件的根目录<br>
     */
    public static final String CONFIG_PROPERTIES_BASENAME = "config";

    /**
     * ERORR_CODE_PROPERTIES_BASENAME: 错误编码文件的目录，所有该目录底下的.properties文件都将被加载到MessageResourceHelper中 <br>
     */
    public static final String ERORR_CODE_PROPERTIES_BASENAME = "config/error_code/";

    /**
     * config/props 配置文件的根目录<br>
     */
    public static final String PROPS_PROPERTIES_BASENAME = "config/props/";

    /** RES_FILE. */
    public static final String RES_FILE = "com.ztesoft.common.CommonMsg";

    /** APP_HOME. */
    public static final String APP_WEB_HOME = "APP_HOME";

    /** Oracle数据库方言. */
    public static final String ORACLE_DIALECT = "Oracle";

    public static final int ORACLE_DIALECT_INT = 1;

    /** PostgreSQL数据库方言. */
    public static final String POSTGRESQL_DIALECT = "PostgreSQL";

    public static final int POSTGRESQL_DIALECT_INT = 2;

    /** TT数据库方言. */
    public static final String TIMESTEN_DIALECT = "TimesTen";

    /** Oracle 时间关键字 */
    public static final String CURRENT_DATE_KEY_ORACLE = "SYSDATE";

    /** INFORMIX 时间关键字 */
    public static final String CURRENT_DATE_KEY_INFORMIX = "CURRENT";

    /** 缓存模式_本地缓存 */
    public static final String CACHE_MODE_LOCAL = "LOCAL";

    /** 缓存模式_REDIS */
    public static final String CACHE_MODE_REDIS = "REDIS";

    public static int DB_DIALECT_INT;

    public static final String TRUE = "T";

    public static final String FALSE = "F";

    public static final String USER_INFO_BEAN = "USER_INFO_BEAN";

    /** NULL_VNO_ID 用于逻辑标识 */
    public static final long NULL_VNO_ID = -999999999999999L;

    // /** 缺省BASE_VNO_ID. */
    // public static final long DEFAULT_BASE_VNO_ID = 0L;
    //
    // /** 是否是VNO模式 */
    // public static final boolean IS_VNO_MODE =
    // ConfigHelper.getCfgBoolean("COMMON", "IS_VNO_MODE", false);

    // 编码集设置

    /** GBK编码集. */
    public static final String GBK_ENCODING = "GBK";

    /** GB2312编码集. */
    public static final String GB2312_ENCODING = "GB2312";

    /** ISO-8859-1编码集. */
    public static final String ISO_8859_1_ENCODING = "ISO-8859-1";

    /** UTF-8编码集. */
    public static final String UTF_8_ENCODING = "UTF-8";

    /** 编码模式, 此种模式的编码转换只用一种指定编码对字符串进行转换. */
    public static final short ALONE_ENCODE_MODE = 1;

    /** 编码模式, 此种模式的编码转换将字符串从一种编码转换到另一种编码. */
    public static final short FROM_TO_ENCOD_MODE = 2;

    public static final int DEF_ACCT_ITME_GROUP_ID = -1;

    public static final int DEF_PAYMENT_RULE = -1;

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
    public static final String NULL_STRING = "-nullnull-";

    /** Date null时间 */
    public static final Date NULL_DATE = DateUtils.string2Date("1900-01-01",
            DateUtils.STR_DATE_FORMAT_DAY_WITH_SPLIT);

    /** 默认的数组大小 */
    public final static int ARRAY_INIT_SIZE = 512;

    /** 操作成功标志. */
    public final static int SUCCESS = 1;

    /** 操作失败标志. */
    public final static int FAILED = 0;

    /** 默认哈希码. */
    public static final int DEF_HASH_CODE = 17;

    /** 用户状态-正常 */
    public static final String SERV_STATE_EFF = "2HA";

    public static final int DEFAULT_CATEGORY_ID = 0;

    /** 默认外键值. */
    public static final int DEF_FOREIEN_KEY = -1;

    public static final String SIMPLE_TRUE = "T";

    public static final String SIMPLE_FALSE = "F";

    /** 短整型 */
    public static final int SHORT_INT_TYPE = 20;

    /** 短整型-网络字节序 */
    public static final int SHORT_INT_LE_TYPE = 21;

    /** int数据类型-网络字节序 */
    public static final int INT_LE_TYPE = 22;

    /** long数据类型-网络字节序 */
    public static final int LONG_LE_TYPE = 23;

    /** int数据类型 */
    public static final int INT_TYPE = 0;

    /** float数据类型 */
    public static final int FLOAT_TYPE = 1;

    /** long数据类型 */
    public static final int LONG_TYPE = 2;

    /** String数据类型 */
    public static final int STRING_TYPE = 3;

    /** date数据类型 */
    public static final int DATE_TYPE = 4;

    /** object数据类型 */
    public static final int OBJECT_TYPE = 5;

    /** 数组数据类型 */
    public static final int ARRAY_TYPE = 6;

    /** int数组数据类型 */
    public static final int INT_ARRAY_TYPE = 7;

    /** String数组数据类型 */
    public static final int STRING_ARRAY_TYPE = 8;

    /** date数组数据类型 */
    public static final int DATE_ARRAY_TYPE = 9;

    /** long数组数据类型 */
    public static final int LONG_ARRAY_TYPE = 10;

    /** 对象数组数据类型 */
    public static final int OBJECT_ARRAY_TYPE = 11;

    /** C语言时间类型 */
    public static final int C_TIME_TYPE = 12;

    /** 关联定义对象类型 */
    public static final int REF_OBJECT_TYPE = 13;

    /** 单字节整型 */
    public static final int SINGLE_INT_TYPE = 14;

    /** 失效时间 */
    public static final String EXP_DATE = "2030-01-01 00:00:00";

    /** 失效时间 */
    public static final String MAX_EXP_DATE = "9999-01-01 00:00:00";

    /** 失效时间日期格式 */
    public static final String EXP_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** 日期类型的失效时间 */
    public static final Date EXP_DATE_DATE_TYPE = DateUtils.string2Date(
            EXP_DATE, EXP_DATE_FORMAT);

    /** 日期类型的失效时间 */
    public static final Date MAX_EXP_DATE_TYPE = DateUtils.string2Date(
            MAX_EXP_DATE, EXP_DATE_FORMAT);

    /** 有效状态 */
    public static final String STATUS_EFF = "00A";

    /** 等待激活状态 */
    public static final String STATUS_WAIT_ACTIVE = "00C";

    /** 无效状态 */
    public static final String STATUS_EXP = "00X";

    /** 归档状态 */
    public static final String STATUS_BAK = "00U";

    /** 服务紧急停用状态 */
    public static final String STATUS_STOP = "XXX";

    /** 状态- 归档 */
    public static final String STATUS_ARCHIVE = "00H";

    /** 过渡状态-即将有效 */
    public static final String STATE_SHOULD_VALIDATE = "0EA";

    /** 过度状态-即将无效 */
    public static final String STATE_SHOULD_INVALIDATE = "0DA";

    /** 未知状态 */
    public static final String STATE_UNKNOWN = "000";

    /**
     * Ext分页查询默认的每页记录数
     */
    public static final int DEFAULT_PAGE_SIZE = 15;

}
