package com.ztesoft.framework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * 日期辅助工具类
 */
public final class DateUtils {

    /** 默认的日期格式.yyyy-MM-dd HH:mm:ss */
    public static String STR_DEFAULT_DATE_FORMAT_WITH_SPLIT = "yyyy-MM-dd HH:mm:ss";

    /** 日期格式.yyyyMMddHHmmss */
    public static String STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT = "yyyyMMddHHmmss";

    /** 用于文件命名的日期格式.yyyyMMdd_HHmmss */
    public static String STR_NAME_FILE_DATE_FORMAT = "yyyyMMdd_HHmmss";

    /** DAY日期格式. yyyy-MM-dd */
    public static String STR_DATE_FORMAT_DAY_WITH_SPLIT = "yyyy-MM-dd";

    /** DAY日期格式. yyyyMMdd */
    public static String STR_DATE_FORMAT_DAY_WITHOUT_SPLIT = "yyyyMMdd";

    /** DAY日期格式. yyyy-MM */
    public static String STR_DATE_FORMAT_MONTH_WITH_SPLIT = "yyyy-MM";

    /** DAY日期格式. yyyyMM */
    public static String STR_DATE_FORMAT_MONTH_WITHOUT_SPLIT = "yyyyMM";

    /** DAY日期格式. yyyy */
    public static String STR_DATE_FORMAT_YEAR = "yyyy";
    
    /** DAY日期格式. yyyy */
    public static String STR_DATE_FORMAT_DAY_SPLIT = "dd";

    /** 分钟日期格式. yyyy-MM-dd HH:mm */
    public static String STR_DATE_FORMAT_MINUTE = "yyyy-MM-dd HH:mm";

    // //////////////////////////////////////////

    /** SimpleDateFormat. yyyy */
    public static SimpleDateFormat SIMPLE_DATE_FORMAT_yyyy = new SimpleDateFormat(
            STR_DATE_FORMAT_YEAR);

    /** SimpleDateFormat. yyyyMMdd */
    public static SimpleDateFormat SIMPLE_DATE_FORMAT_yyyyMMdd = new SimpleDateFormat(
            STR_DATE_FORMAT_DAY_WITHOUT_SPLIT);

    /** SimpleDateFormat. yyyyMMddhhmmss */
    public static SimpleDateFormat SIMPLE_DATE_FORMAT_yyyyMMddhhmmss = new SimpleDateFormat(
            STR_DEFAULT_DATE_FORMAT_WITHOUT_SPLIT);

    /** SimpleDateFormat. yyyy-MM-dd HH:mm:ss */
    public static SimpleDateFormat SIMPLE_DATE_FORMAT_yyyy_MMdd_HHmmss = new SimpleDateFormat(
            STR_DEFAULT_DATE_FORMAT_WITH_SPLIT);

    // //////////////////////////////////////////
    public static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(DateUtils.class);

    private DateUtils() {

    }

    /**
     * 将Date转换成字符串
     * 
     * @param date Date 要转换的Date实例
     * @param format String 日期格式字符串
     * @return String
     */
    public static String date2String(Date date, String format) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat sdf = null;
        try {
            sdf = new SimpleDateFormat(format);
        }
        catch (Exception e) {
            sdf = new SimpleDateFormat(STR_DEFAULT_DATE_FORMAT_WITH_SPLIT);
        }
        return sdf.format(date);
    }

    /**
     * 将Date转换成字符串(天)
     * 
     * @param date
     * @return
     */
    public static String date2StringDay(Date date) {
        return date2String(date, STR_DATE_FORMAT_DAY_WITH_SPLIT);
    }

    /**
     * 将Date转换成字符串(月)
     * 
     * @param date
     * @return
     */

    public static String date2StringMonth(Date date) {
        return date2String(date, STR_DATE_FORMAT_MONTH_WITH_SPLIT);
    }

    public static String date2StringYear(Date date) {
        return date2String(date, STR_DATE_FORMAT_YEAR);
    }

    /**
     * 得到合适的格式化时间
     * 
     * @param date
     * @param format
     * @return
     */
    public static String date2SuitString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int sec = calendar.get(Calendar.SECOND);
        int minute = calendar.get(Calendar.MINUTE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (sec == 0 && minute != 0) {// 只取分钟
            return date2String(date, STR_DATE_FORMAT_MINUTE);
        }
        if (minute == 0 && hour == 0) {// 取日
            return date2String(date, STR_DATE_FORMAT_DAY_WITH_SPLIT);
        }
        return date2String(date, STR_DATE_FORMAT_MINUTE);
    }

    /**
     * 将Date类转换成字符串形式,使用默认的格式做转换. yyyy年MM月DD日 HH:MM:SS
     * 
     * @param date Date
     * @return String
     */
    public static String date2String(Date date) {
        return date2String(date, STR_DEFAULT_DATE_FORMAT_WITH_SPLIT);
    }

    /**
     * 得到字符串形式的当前时间,日期格式采用默认的格式.
     * 
     * @return String
     */
    public static String getCurrentDate() {
        Date date = new Date();
        return date2String(date, STR_DEFAULT_DATE_FORMAT_WITH_SPLIT);
    }

    /**
     * 得到字符串形式的当前时间,日期格式采用用于文件命名的格式.
     * 
     * @return String
     */
    public static String getNameFileCurrentDate() {
        Date date = new Date();
        return date2String(date, STR_NAME_FILE_DATE_FORMAT);
    }

    /**
     * 将字符串格式的日期转换成SQL日期,格式yyyy-MM-DD
     * 
     * @param date String
     * @return Date
     */
    public static java.util.Date string2Date(String date) {
        return string2Date(date, STR_DEFAULT_DATE_FORMAT_WITH_SPLIT);
    }

    public static java.util.Date string2Date(String date, String dateFormat) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            long time = sdf.parse(date).getTime();
            return new java.util.Date(time);
        }
        catch (Exception e) {
            logger.error("convert date error, " + date, e);
            return null;
        }
    }

    /**
     * 得到当前标准时间 yyyy-MM-dd HH:mm:ss
     * 
     * @return String 得到当前标准时间字符串
     */
    public static String getStandardNowTime() {
        return getStandardTimeFormat().format(new java.util.Date());
    }

    /**
     * @return String 得到当前标准时间
     */
    /**
     * 得到当前 yyyy-MM-dd HH:mm:ss 格式化器
     * 
     * @return SimpleDateFormat 格式化器
     */
    public static SimpleDateFormat getStandardTimeFormat() {
        return new SimpleDateFormat(STR_DEFAULT_DATE_FORMAT_WITH_SPLIT);
    }

    /**
     * 得到当前日期
     * 
     * @return java.sql.Date 当前服务器时间
     */
    public static java.util.Date getNowDate() {
        return new java.util.Date();
    }

    /**
     * 偏移时间
     * 
     * @param date Date 初始时间
     * @param second long 偏移秒数
     * @return Date
     */
    public static Date offsetSecond(Date date, long seconds) {
        long time = date.getTime();
        time = time + (seconds * 1000);
        return new Date(time);
    }

    /**
     * 偏移时间
     * 
     * @param date Date 初始时间
     * @param minute long 偏移分钟数
     * @return Date
     */
    public static Date offsetMinute(Date date, long minutes) {
        return offsetSecond(date, 60 * minutes);
    }

    /**
     * 偏移时间
     * 
     * @param date Date 初始时间
     * @param hour long 偏移小时数
     * @return Date
     */
    public static Date offsetHour(Date date, long hours) {
        return offsetMinute(date, 60 * hours);
    }

    /**
     * 偏移时间
     * 
     * @param date Date 初始时间
     * @param day long 偏移天数
     * @return Date
     */
    public static Date offsetDay(Date date, int days) {
        return offsetHour(date, 24 * days);
    }

    /**
     * 偏移时间
     * 
     * @param date Date 初始时间
     * @param week long 偏移周数
     * @return Date
     */
    public static java.util.Date offsetWeek(java.util.Date date, int weeks) {
        return offsetDay(date, 7 * weeks);
    }

    /**
     * 得到本月的最后时间
     * 
     * @param date Date 要偏移的时间
     * @return Date
     */
    public static java.util.Date getMonthLastday(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, maxDay);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        newDate.setTime(calendar.getTimeInMillis());
        return newDate;
    }

    /**
     * 得到传入当月的天数（即最后一天的日子）
     * 
     * @param date
     * @return
     */
    public static int getMonthMaxDay(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDay;
    }

    /**
     * 得到传入时间的前一天
     * 
     * @param date Date 要偏移的时间
     * @return Date
     */
    public static java.util.Date getYesterday(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.add(Calendar.DATE, -1);
        newDate.setTime(calendar.getTimeInMillis());
        return newDate;
    }

    /**
     * 得到分钟的最开始时间
     * 
     * @param date Date 要偏移的时间
     * @return Date
     */
    public static java.util.Date getMinuteFisrt(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.set(Calendar.SECOND, 00);
        newDate.setTime(calendar.getTimeInMillis());
        return newDate;
    }

    /**
     * 得到分钟的最开始时间
     * 
     * @param date Date 要偏移的时间
     * @return Date
     */
    public static java.util.Date getMinuteLast(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.set(Calendar.SECOND, 59);
        newDate.setTime(calendar.getTimeInMillis());
        return newDate;
    }

    /**
     * 得到本月的开始时间
     * 
     * @param date Date 要偏移的时间
     * @return Date
     */
    public static java.util.Date getMonthBeginday(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        newDate.setTime(calendar.getTimeInMillis());
        return newDate;
    }

    /**
     * 得到时间天
     * 
     * @param date
     * @return
     */
    public static int getDateDay(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到时间月
     * 
     * @param date
     * @return
     */
    public static int getDateMonth(java.util.Date date) {
        Date newDate = new Date(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 偏移时间(按月) 规则: 1. 如果要偏移的时间是月末, 偏移后也是月末 2. 要偏移的时间的当前天大于偏移后的月份的最大天数也调整为月末, 比如12月30号(非月末)偏移两个月 应变为2月28(29)号
     * 
     * @param date Date 要偏移的时间
     * @param months int 要偏移的月份
     * @return Date
     */
    public static java.sql.Date offersetMonth(java.sql.Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 将当前天设置为1号, 然后增加月份数 (先加月份, 再加天)
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, months);

        // 加过月份以后的日期当月的最大天数

        int newMaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 如果当前天为月底, 加过以后也调整为月底
        if (curDay == maxDay) {
            calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);

        }
        else {
            // 如果要加的初始日期的天大于新的月份的最大天数, 则调整为月底, 比如12月30号加两个月

            // 不是2 * 30天 到 3月2号, 而是到2月底
            if (curDay > newMaxDay) {
                calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);
            }
            else {
                calendar.set(Calendar.DAY_OF_MONTH, curDay);
            }
        }

        date.setTime(calendar.getTimeInMillis());
        return date;
    }

    // 加一个Util.date 类型的
    /**
     * 偏移时间(按月) 规则: 1. 如果要偏移的时间是月末, 偏移后也是月末 2. 要偏移的时间的当前天大于偏移后的月份的最大天数也调整为月末, 比如12月30号(非月末)偏移两个月 应变为2月28(29)号
     * 
     * @param date java.util.Date 要偏移的时间
     * @param months int 要偏移的月份
     * @return Date
     */
    public static java.util.Date offersetMonth(java.util.Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        Date reDate = new Date();
        calendar.setTime(date);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 将当前天设置为1号, 然后增加月份数 (先加月份, 再加天)
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, months);

        // 加过月份以后的日期当月的最大天数

        int newMaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 如果当前天为月底, 加过以后也调整为月底
        if (curDay == maxDay) {
            calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);

        }
        else {
            // 如果要加的初始日期的天大于新的月份的最大天数, 则调整为月底, 比如12月30号加两个月

            // 不是2 * 30天 到 3月2号, 而是到2月底
            if (curDay > newMaxDay) {
                calendar.set(Calendar.DAY_OF_MONTH, newMaxDay);
            }
            else {
                calendar.set(Calendar.DAY_OF_MONTH, curDay);
            }
        }

        reDate.setTime(calendar.getTimeInMillis());
        return reDate;
    }

    // add by fzz
    /**
     * 检查指定时间是否在某个时间范围内(闭区间), 时间格式必须一致, 长度一致
     * 
     * @param date String 指定时间
     * @param beginDate String 范围开始时间
     * @param endDate String 范围结束时间
     * @return boolean true-在范围内, false-不在范围内
     * @throws BaseAppException
     */
    public static boolean isInRange(String date, String beginDate,
            String endDate) throws BaseAppException {
        if (Utils.isEmpty(date) || Utils.isEmpty(beginDate)
                || Utils.isEmpty(endDate)) {
            ExceptionHandler.publish("");
            /** @todo */
        }

        int dateLen = date.length();
        int beginDateLen = date.length();
        int endDateLen = date.length();

        if (beginDateLen != dateLen) {
            ExceptionHandler.publish("");
            /** @todo */
        }

        boolean asc = isAsc(beginDate, endDate);

        if (asc) {
            if (date.compareTo(beginDate) >= 0 && date.compareTo(endDate) <= 0) {
                return true;
            }
        }
        else {
            if (date.compareTo(beginDate) >= 0 || date.compareTo(endDate) <= 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * 检查指定时间是否在某个时间范围内(闭区间)
     * 
     * @param date Date 指定时间
     * @param beginDate Date 范围开始时间
     * @param endDate Date 范围结束时间
     * @return boolean true-在范围内, false-不在范围内
     */
    public static boolean isInRange(Date date, Date beginDate, Date endDate) {
        // long time = date.getTime();
        // long beginTime = beginDate.getTime();
        // long endTime = endDate.getTime();

        // if (time >= beginTime && time <= endTime) {
        // return true;
        // } else {
        // return false;
        // }
        if (date.compareTo(beginDate) >= 0 && date.compareTo(endDate) <= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * test date1 is later than date2 or not
     * 
     * @param date1
     * @param date2
     * @return boolean
     */
    public static boolean isLaterThan(Date date1, Date date2) {
        return isCompare(date1, date2) == 2;
    }

    /**
     * test date1 is early than date2 or not
     * 
     * @param date1
     * @param date2
     * @return boolean
     */
    public static boolean isEarlyThan(Date date1, Date date2) {
        return isCompare(date1, date2) == 0;
    }

    /**
     * 检查指定时间比较大小 * @param beginDate Date 范围开始时间
     * 
     * @param endDate Date 范围结束时间
     * @return boolean 0-小于, 1-等于，2-大于
     */
    public static int isCompare(Date beginDate, Date endDate) {
        // int ret=1;
        // long beginTime = beginDate.getTime();
        // long endTime = endDate.getTime();
        //
        // if (beginTime >endTime) {
        // ret=2;
        // }
        // if(beginTime==endTime){
        // ret=1;
        // }
        // if(beginTime<endTime){
        // ret=0;
        // }

        int ret = 1;
        if (beginDate.after(endDate)) {
            ret = 2;
        }
        if (beginDate.equals(endDate)) {
            ret = 1;
        }
        if (beginDate.before(endDate)) {
            ret = 0;
        }
        return ret;
    }

    /**
     * 判断字符串是否升序的, 第一个字符串小于第二个字符串
     * 
     * @param firstStr String
     * @param secondStr String
     * @return boolean true-升序, false-降序
     */
    private static boolean isAsc(String firstStr, String secondStr) {
        return (firstStr.compareTo(secondStr) < 0);
    }

    /** PostgreSQL 取数据库sql */
    public static String POSTGRESQL_GETTIME = " SELECT CURRENT_TIMESTAMP ";

    /** Oracle 取数据库sql */
    public static String ORACLE_GETTIME = " SELECT SYSDATE FROM DUAL ";

    /**
     * 得到数据库当前时间
     * 
     * @return Date
     * @throws BaseAppException
     */
    public static java.util.Date getDBCurrentTime() {
        // 取session 数据库链接
        // DBConnSession.getDBConnSession().regSvcFunc();

        // Connection oneConn =
        // DBConnSession.getDBConnSession().getMainConnection();
        // PreparedStatement ps = null;
        // ResultSet rs = null;
        // java.sql.Date date = null;
        // try {
        // switch (Constants.DB_DIALECT_INT) {
        // case Constants.ORACLE_DIALECT_INT:
        // ps = oneConn.prepareStatement(ORACLE_GETTIME);
        // case Constants.POSTGRESQL_DIALECT_INT:
        // ps = oneConn.prepareStatement(POSTGRESQL_GETTIME);
        // }
        // // ----------------
        // rs = ps.executeQuery();
        // Timestamp dateTs = null;
        // if (rs.next()) {
        // dateTs = rs.getTimestamp(1);
        // }
        // date = new java.sql.Date(dateTs.getTime());
        // } catch (SQLException ex) {
        // throw ExceptionHandler.publish(SysExceptionCode.DB_OPER_EXPCEPTION,
        // ex);
        // } finally {
        // Dustman.cleanUp(ps, rs);
        // DBConnSession.getDBConnSession().unRegSvcFunc();

        // }
        return getNowDate();// 同一台pc_server，就先取机器时间
    }

    /**
     * 获得日期的一天的开始时间 00：00：00
     * 
     * @param date
     * @return
     */
    public static Date getDayStartTime(Date start) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(start);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获得日期的一天的结束时间 23：59：59
     * 
     * @param date
     * @return
     */
    public static Date getDayEndTime(Date start) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(start);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 根据开始时间、结束时间得到两个时间段内所有的日期 要求配置每天时段时，不能跨天，结束时间最大配置成23:59:59
     * 
     * @param start 开始日期
     * @param end 结束日期
     * @param calendarType 类型
     * @return 两个日期之间的日期,例如如果 开始时间是2012-12-30 20:59:17， 结束时间是2013-1-1 10:45:57 结果是如下数组信息 2012-12-30 20:59:17 2012-12-30 23:59:59 2012-12-31 0:00:00
     *         2012-12-31 23:59:59 2013-1-1 10:45:57
     */
    public static Date[] getDateArrays(Date start, Date end, int calendarType) {
        ArrayList<Date> ret = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();

        Date tmpEndDate = getDayEndTime(start);
        calendar.setTime(tmpEndDate);
        // Date tmpDate = calendar.getTime();
        long endTime = end.getTime();

        // System.out.println("tmpEndDate: " + tmpEndDate.toLocaleString());
        ret.add(start);
        int i = 0;
        while (tmpEndDate.before(end) || tmpEndDate.getTime() == endTime) {
            if (i != 0) {
                ret.add(getDayStartTime(calendar.getTime()));
            }
            ret.add(calendar.getTime());
            calendar.add(calendarType, 1);
            tmpEndDate = calendar.getTime();
            // System.out.println("tmpEndDate: " + tmpEndDate.toLocaleString());
            i++;
        }
        ret.add(end);
        Date[] dates = new Date[ret.size()];
        return (Date[]) ret.toArray(dates);
    }

    /**
     * 根据开始时间、结束时间得到两个时间段内所有的日期 要求配置每天时段时，不能跨天，结束时间最大配置成23:59:59
     * 
     * @param start 开始日期
     * @param end 结束日期
     * @param calendarType 类型
     * @return 两个日期之间的日期,例如如果 开始时间是2012-12-30 20:59:17， 结束时间是2013-1-1 10:45:57 结果是如下数组信息 2012-12-30 20:59:17 2012-12-31 0:00:00 2013-1-1 0:00:00 //
     *         注意这个是循环后添加的 2013-1-1 10:45:57
     */
    public static ArrayList<Date> getDateArraysWithoutEndTime(Date start,
            Date end, int calendarType) {
        ArrayList<Date> ret = new ArrayList<Date>();
        Calendar calendar = Calendar.getInstance();

        Date tmpEndDate = getDayEndTime(start);
        calendar.setTime(tmpEndDate);
        Date tmpDate = calendar.getTime();
        long endTime = end.getTime();

        // System.out.println("tmpEndDate: " + tmpEndDate.toLocaleString());
        ret.add(start);
        int i = 0;
        while (tmpEndDate.before(end) || tmpEndDate.getTime() == endTime) {
            if (i != 0) {
                ret.add(getDayStartTime(calendar.getTime()));
            }
            ret.add(calendar.getTime());
            calendar.add(calendarType, 1);
            tmpEndDate = calendar.getTime();
            // System.out.println("tmpEndDate: " + tmpEndDate.toLocaleString());
            i++;
        }
        if (getDayStartTime(tmpEndDate).before(end)
                && getDayStartTime(tmpEndDate).after(start)) {
            ret.add(getDayStartTime(end));
        }
        ret.add(end);
        // Date[] dates = new Date[ret.size()];
        return ret;
    }

    /**
     * 拆分两周
     * 
     * @param start 开始日期
     * @param end 结束日期
     * @return 两个日期之间的第一个时间周结束时间划分,例如如果 开始时间是2006-9-13 17:38:27， 结束时间是2013-1-14 13:11:47 2006-9-13 17:38:27 2006-9-17 23:59:59 2013-1-14 13:11:47
     */
    public static ArrayList<Date> getDateArraysByWeek(Date start, Date end) {

        ArrayList<Date> ret = new ArrayList<Date>();
        Date tmpDate = start;
        ret.add(start);
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);

        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(tmpDate);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 0);
        tmpDate = c.getTime();
        // System.out.println("tmpDate" + tmpDate.toLocaleString());

        if (isCompare(tmpDate, end) == 0) {
            // 拆分
            ret.add(tmpDate);
        }
        ret.add(end);

        return ret;
    }

    // 获取和timeSpanDate相同周几，并且和date在同一周的时间
    // 比如timeSpanDate 2013-1-14 13:31:31 周一
    // date 2006-9-13 17:58:11 周三
    // 则返回2006-9-11 17:58:11 周一
    public static Date getWeekDate(Date date, Date timeSpanDate) {

        Calendar c = new GregorianCalendar();
        Date tmpDate = new Date();

        c.setTime(timeSpanDate);
        int week = c.get(Calendar.DAY_OF_WEEK);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + (week - 1)); // Sunday
        tmpDate = c.getTime();

        return tmpDate;
    }

    // 获取和timeSpanDate相同周周几，
    // 比如timeSpanDate 2006-9-13 18:07:43 周三
    // week 2 ， 本周第几天，周日是 1 周一为二
    // 则返回2006-9-11 17:58:11 周一
    public static Date getWeekDate(Date timeSpanDate, int week) {

        Calendar c = new GregorianCalendar();
        Date tmpDate = new Date();

        c.setTime(timeSpanDate);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + (week - 1)); // Sunday
        tmpDate = c.getTime();

        return tmpDate;
    }

    /**
     * 获取start 和 timespanDate相同周几，时分秒 的日期
     * 
     * @param start
     * @param timeSpanDate
     * @return
     */
    public static Date setWeekDateHHMMSS(Date start, Date timeSpanDate) {
        Calendar c = new GregorianCalendar();
        Calendar c1 = new GregorianCalendar();
        Date tmpDate = new Date();
        c1.setTime(timeSpanDate);
        c.setTime(start);
        c.set(Calendar.DAY_OF_WEEK, c1.get(Calendar.DAY_OF_WEEK)); // Sunday
        c.set(Calendar.HOUR_OF_DAY, c1.get(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c1.get(Calendar.MINUTE));
        c.set(Calendar.SECOND, c1.get(Calendar.SECOND));
        tmpDate = c.getTime();
        return tmpDate;
    }

    /**
     * 获取两个时间间隔的天
     * 
     * @param lastExsitDate
     * @param lastday
     * @return
     * @throws Exception
     */
    public static ArrayList<Date> getIntervalDay(Date lastExsitDate,
            Date lastday) throws Exception {
        if (lastExsitDate == null || lastday == null) {// 没有时间，返回null
            return null;
        }
        int beginDay = getDateDay(lastExsitDate);
        int lastDay = getDateDay(lastday);
        String str = date2String(lastExsitDate, "yyyy-MM");
        ArrayList<Date> al = new ArrayList<Date>();
        for (int i = beginDay; i <= lastDay; i++) {
            al.add(string2Date(str + "-" + i, "yyyy-MM-dd"));
        }
        return al;
    }

    /**
     * 按yyyy-MM-dd比较两个Date的大小
     * 
     * @author: panxb
     * @date: 2012-3-6 下午03:02:02
     * @param date1
     * @param date2
     * @param stype
     * @return
     */
    public static int compareDate(Date date1, Date date2, int stype) {
        String format = "yyyy-MM-dd";
        return compareDate(date2String(date1, format),
                date2String(date2, format), stype);
    }

    /**
     * @param date1 需要比较的时间 不能为空(null),需要正确的日期格式
     * @param date2 被比较的时间 为空(null)则为当前时间
     * @param stype 返回值类型 0为多少天，1为多少个月，2为多少年
     * @return 如果date1比date2提早，返回负数；反之亦然
     */
    public static int compareDate(String date1, String date2, int stype) {
        int n = 0;

        // String[] u = { "天", "月", "年" };
        String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

        date2 = date2 == null ? getCurrentDate() : date2;

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        }
        catch (Exception e3) {
        }
        // List list = new ArrayList();
        if (c1.compareTo(c2) <= 0) {
            while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
                // list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
                n--;
                if (stype == 1) {
                    c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
                }
                else {
                    c1.add(Calendar.DATE, 1); // 比较天数，日期+1
                }
            }
            n = n + 1;
        }
        else {
            while (!c2.after(c1)) { // 循环对比，直到相等，n 就是所要的结果
                // list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
                n++;
                if (stype == 1) {
                    c2.add(Calendar.MONTH, 1); // 比较月份，月份+1
                }
                else {
                    c2.add(Calendar.DATE, 1); // 比较天数，日期+1
                }
            }
            n = n - 1;
        }

        if (stype == 2) {
            n = (int) n / 365;
        }

        return n;
    }
    
    
    public  static void main(String[] args){
        String format = "yyyy-MM-dd HH:mm:ss.S";
        Date date = DateUtils.string2Date("2012-04-17 09:10:12.9",format);
        System.out.println(DateUtils.date2String(date, format));
    }
}
