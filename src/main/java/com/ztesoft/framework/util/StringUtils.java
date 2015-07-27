package com.ztesoft.framework.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description> 字符串帮助类<br>
 */
public abstract class StringUtils {
    private final static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(StringUtils.class);

    private StringUtils() {

    }

    // 转换字符串编

    /**
     * 将字符串转换成GBK编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String toGBK(String val) throws UnsupportedEncodingException {
        return new String(val.getBytes(FrameWorkConstants.GBK_ENCODING));
    }

    /**
     * 将字符串转换成GBK编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String toGB2312_ENCODING(String val)
            throws UnsupportedEncodingException {
        return new String(val.getBytes(), FrameWorkConstants.GB2312_ENCODING);
    }

    /**
     * 将字符串转换成GB2312编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */

    public static String toGB2312(String val)
            throws UnsupportedEncodingException {
        return new String(val.getBytes(FrameWorkConstants.GB2312_ENCODING));
    }

    /**
     * 将字符串转换成ISO-8859-1编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */

    public static String getISO_8859_1(String val)
            throws UnsupportedEncodingException {
        return new String(val.getBytes(FrameWorkConstants.ISO_8859_1_ENCODING));
    }

    /**
     * 将字符串转换成GB2312编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */

    public static String getGB2312(String val)
            throws UnsupportedEncodingException {
        return new String(val.getBytes(FrameWorkConstants.GB2312_ENCODING));
    }

    /**
     * 将字符串转换成ISO-8859-1编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */

    public static String toISO_8859_1(String val)
            throws UnsupportedEncodingException {
        return new String(val.getBytes(),
                FrameWorkConstants.ISO_8859_1_ENCODING);
    }

    /**
     * 将字符串转换成UTF-8编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */

    public static String toUTF_8(String val)
            throws UnsupportedEncodingException {
        return new String(val.getBytes(FrameWorkConstants.UTF_8_ENCODING));
    }

    /**
     * 将字符串转换成指定编码集的字符串
     * 
     * @param val String 要转换的字符
     * @param encoding String 字符编码
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String encode(String val, String encoding)
            throws UnsupportedEncodingException {
        if (val == null) {
            return null;
        }
        return new String(val.getBytes(encoding));
    }

    /**
     * 将字符串从GBK编码转换到ISO_8859_1编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String GBKToISO_8859_1(String val)
            throws UnsupportedEncodingException {
        return encode(val, FrameWorkConstants.GBK_ENCODING,
                FrameWorkConstants.ISO_8859_1_ENCODING);
    }

    /**
     * 将字符串从GBK2312编码转换到ISO_8859_1编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String GB2312ToISO_8859_1(String val)
            throws UnsupportedEncodingException {
        return encode(val, FrameWorkConstants.GB2312_ENCODING,
                FrameWorkConstants.ISO_8859_1_ENCODING);
    }

    /**
     * 将字符串从ISO_8859_1编码转换到GBK编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String ISO_8859_1ToGB2312(String val)
            throws UnsupportedEncodingException {
        return encode(val, FrameWorkConstants.ISO_8859_1_ENCODING,
                FrameWorkConstants.GB2312_ENCODING);
    }

    /**
     * 将字符串从ISO_8859_1编码转换到GBK编码.
     * 
     * @param val String 要转换的字符
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String ISO_8859_1ToGBK(String val)
            throws UnsupportedEncodingException {
        return encode(val, FrameWorkConstants.ISO_8859_1_ENCODING,
                FrameWorkConstants.GBK_ENCODING);
    }

    /**
     * get From GBK
     * 
     * @param val String
     * @return String
     * @throws UnsupportedEncodingException
     */
    public static String getGBK(String val) {
        try {
            return encode(val, FrameWorkConstants.GBK_ENCODING);
        }
        catch (UnsupportedEncodingException ex) {
            return "";
        }
    }

    /**
     * 将字符串从一种指定的编码集转换到另一种编码集
     * 
     * @param val String 要转换的字符
     * @param formEncoding String 要转换的编码
     * @param toEncoding String 被转换的编码
     * @return String 转换后的字符
     * @throws UnsupportedEncodingException
     */
    public static String encode(String val, String formEncoding,
            String toEncoding) throws UnsupportedEncodingException {
        if (val == null) {
            return null;
        }
        return new String(val.getBytes(formEncoding), toEncoding);
    }

    /**
     * 将带下划线的字符串进行处,规则是去掉下划线,并将除了首个单词的的其他单词的首字母大写, 其余字母小写, 同JAVA的变量命名规.
     * 
     * @param columnName String 要转换的字符
     * @return String 处理后的字符
     */
    public static String getStandardStr(String columnName) {
        columnName = columnName.toLowerCase();
        StringBuffer sb = new StringBuffer();
        StringTokenizer token = new StringTokenizer(columnName, "_");
        int itoken = token.countTokens();
        for (int i = 0; i < itoken; i++) {
            if (i == 0) {
                sb.append(token.nextToken());
            }
            else {
                String temp = token.nextToken();
                sb.append(temp.substring(0, 1).toUpperCase());
                sb.append(temp.substring(1));
            }
        }
        return sb.toString();
    }

    /**
     * 查字符串是否为空.值为null或长度为0都为
     * 
     * @param val String 要检查的字符
     * @return boolean true-为空, false-不为
     */
    public static boolean isEmpty(String val) {
        if (val == null || val.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object val) {
        if (val == null || val.equals("null")) {
            return true;
        }
        return false;
    }

    /**
     * 查字符串是否不为空.要求val不为空并且val的长度大于0
     * 
     * @param val String 要检查的字符
     * @return boolean true-为空, false-不为
     */
    public static boolean isNotEmpty(String val) {
        if (val == null || val.length() == 0) {
            return false;
        }

        return true;
    }

    /**
     * 将对象转换成String
     * 
     * @param val Object
     * @return String
     */
    public static String toString(Object val) {
        if (val == null) {
            return "";
        }
        return val.toString();
    }

    /**
     * 将对象数组转换成String
     * 
     * @param objs Object[]
     * @return String
     */
    public static String toString(Object[] objs) {
        if (objs != null && objs.length > 0) {
            StringBuffer buff = new StringBuffer();
            for (int i = 0; i < objs.length; i++) {
                buff.append("\nItem[").append(i).append("]\n").append(objs[i]);
            }
            return buff.toString();
        }
        else {
            return "";
        }
    }

    /**
     * 将int值转换成String
     * 
     * @param val int
     * @return String
     */
    public static String toString(int val) {
        return Integer.toString(val);
    }

    /**
     * 将float值转换成String
     * 
     * @param val float
     * @return String
     */
    public static String toString(float val) {
        return Float.toString(val);
    }

    /**
     * 将double值转换成String
     * 
     * @param val double
     * @return String
     */
    public static String toString(double val) {
        return Double.toString(val);
    }

    /**
     * 将long值转换成String
     * 
     * @param val long
     * @return String
     */
    public static String toString(long val) {
        return Long.toString(val);
    }

    /**
     * 将short值转换成String
     * 
     * @param val short
     * @return String
     */
    public static String toString(short val) {
        return Short.toString(val);
    }

    /**
     * 将boolean值转换成String
     * 
     * @param val boolean
     * @return String
     */
    public static String toString(boolean val) {
        return Boolean.toString(val);
    }

    /**
     * 将Long数组转换成逗号分隔的字串 zhang.nanyu added 2008-05-19
     * 
     * @param longArray Long[]
     * @return String
     */
    public static String toCommaString(Long[] longArray) {
        if (longArray == null || longArray.length <= 0) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < longArray.length; i++) {
            buff.append(longArray[i]);
            if (i != longArray.length - 1) {
                buff.append(",");
            }
        }
        return buff.toString();
    }

    /**
     * 将List列表转换成字符串,取得列表里的每个对象调用其toString()方法
     * 
     * @param list List
     * @param itemName String 列表条目名称
     * @return String
     */
    public static String listToString(List<?> list, String itemName) {
        if (!ValidateUtils.validateNotEmpty(list)) {
            return "";
        }
        else {
            int size = list.size();
            StringBuffer buff = new StringBuffer();
            for (int i = 0; i < size; i++) {
                buff.append(list.get(i).toString()).append("\n");
            }
            return buff.toString();
        }
    }

    /**
     * 将对象数组转换成String
     * 
     * @param objs Object[]
     * @param itemName String
     * @return String
     */
    public static String arrayToString(Object[] objs) {
        if (!ValidateUtils.validateNotEmpty(objs)) {
            return "";
        }
        else {
            int size = objs.length;
            StringBuffer buff = new StringBuffer();
            for (int i = 0; i < size; i++) {
                buff.append(objs[i].toString()).append("\n");
            }
            return buff.toString();
        }
    }

    /**
     * 将重复的数据从ArrayList去除
     * 
     * @param ArrayList 源数
     * @return String 去除后的数据
     */

    public static String[] delRepeatData(ArrayList<String> al) {
        Set<String> set = new HashSet<String>(al);
        Object objs[] = set.toArray(new String[0]);
        return (String[]) objs;
    }

    /**
     * 将重复的数据从String去除
     * 
     * @param str String 源数
     * @return String 去除后的数据
     */
    public static String delRepeatData(String str) {
        ArrayList<String> al = new ArrayList<String>();
        StringBuilder dataBuf = new StringBuilder();
        if (str != null && str.length() >= 1) {
            StringTokenizer st = new StringTokenizer(str, ",");
            while (st.hasMoreTokens()) {
                al.add(st.nextToken());
            }
            String singleDateArr[] = delRepeatData(al);
            if (singleDateArr != null) {
                for (int i = 0; i < singleDateArr.length; i++) {
                    dataBuf.append(singleDateArr[i]);
                    if (i != singleDateArr.length - 1) {
                        dataBuf.append(",");
                    }
                }
            }

        }
        return dataBuf.toString();
    }

    /**
     * 将重复的数据从String[]去除
     * 
     * @param String[] 源数
     * @return String 去除后的数据
     */

    public static String[] delRepeatData(String[] strArr) {
        ArrayList<String> al = new ArrayList<String>();

        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                al.add(strArr[i]);

            }
        }
        String singleDateArr[] = delRepeatData(al);

        return singleDateArr;
    }

    /**
     * 将重复的数据从Integer[]去除
     * 
     * @param Integer[]
     * @return String 去除后的数据
     */

    public static Integer[] delRepeatData(Integer[] intArr) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        if (intArr != null) {
            for (int i = 0; i < intArr.length; i++) {
                al.add(intArr[i]);
            }
        }
        Set<Integer> set = new HashSet<Integer>(al);
        Object objs[] = set.toArray(new Integer[0]);
        return (Integer[]) objs;
    }

    /**
     * 将重复的数据从Long[]去除
     * 
     * @param Long[]
     * @return String 去除后的数据
     */
    public static Long[] delRepeatData(Long[] intArr) {
        ArrayList<Long> al = new ArrayList<Long>();

        if (intArr != null) {
            for (int i = 0; i < intArr.length; i++) {
                al.add(intArr[i]);
            }
        }
        Set<Long> set = new HashSet<Long>(al);
        return set.toArray(new Long[0]);
    }

    public static String format(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }

    /**
     * 在指定字符串的左边用指定 Unicode 字符填充以达到指定的总长
     * 
     * @param s String
     * @param totalWidth int
     * @param paddingChar char
     * @return String
     * @throws BaseAppException
     */
    public static String padLeft(String s, int totalWidth, char paddingChar) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < totalWidth - s.length(); i++) {
            sb.append(paddingChar);
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * 在指定字符串的右边用指定 Unicode 字符填充以达到指定的总长
     * 
     * @param s String
     * @param totalWidth int
     * @param paddingChar char
     * @return String
     * @throws BaseAppException
     */
    public static String padRight(String s, int totalWidth, char paddingChar) {
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        for (int i = 0; i < totalWidth - s.length(); i++) {
            sb.append(paddingChar);
        }
        return sb.toString();
    }

    public static boolean isNumeric(String str) {
        if (str == null)
            return false;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 去掉字符串的空格
     * 
     * @param str String
     * @return String
     */
    public static String trim(String str) {
        return (str == null) ? str : str.trim();
    }

    /**
     * 分割参数
     * 
     * @param paraSrc String
     * @param sepa String
     * @return Map sample : "a=b,c=d,..."
     */
    public static Map<String, String> splitPara(String paraSrc, String sepa) {
        if (paraSrc == null || paraSrc.trim().length() == 0) {
            return null;
        }

        LinkedHashMap<String, String> paraMap = new LinkedHashMap<String, String>();
        if (sepa == null || sepa.equals("")) { // 默认分割参数的分隔符为“,”

            sepa = ",";
        }

        /**
		 * 
		 */
        String[] paras = paraSrc.split(sepa);
        String tmpResult[] = null;
        for (int i = 0, j = 0; i < paras.length; i++) {
            tmpResult = paras[i].split("=");

            if (tmpResult.length >= 2) { // 2 a=b
                paraMap.put(tmpResult[0].trim(), tmpResult[1]);
            }
            else if (tmpResult.length == 1) {
                if (paras[i].indexOf("=") >= 0) { // 1 a=
                    paraMap.put(tmpResult[0].trim(), "");
                }
                else { // 0 a
                    paraMap.put("TEXT." + j, paras[i]);
                    j++;
                }
            }
        }

        return paraMap;
    }

    /**
     * 半角字符转全角字符
     * 
     * @param str String
     * @return String
     */
    public static String toDBCS(String str) {
        if (str == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0, n = str.length(); i < n; i++) {
            int c = str.charAt(i);
            if ((c >= 'a') && (c <= 'z')) {
                c = (c + 'ａ') - 'a';
            }
            else if ((c >= 'A') && (c <= 'Z')) {
                c = (c + 'Ａ') - 'A';
            }
            else if ((c >= '0') && (c <= '9')) {
                c = (c + '０') - '0';
            }

            sb.append((char) c);
        }

        return sb.toString();
    }

    /**
     * 全角字符转半角字符
     * 
     * @param str String
     * @return String
     */
    public static String toSBCS(String str) {
        if (str == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0, n = str.length(); i < n; i++) {
            int c = str.charAt(i);
            if ((c >= 'Ａ') && (c <= 'Ｚ')) { // A ..
                c = (c + 'A') - 'Ａ';
            }
            else if ((c >= 'ａ') && (c <= 'ｚ')) { // a ..
                c = (c + 'a') - 'ａ';
            }
            else if ((c >= '０') && (c <= '９')) { // 0 ..
                c = (c + '0') - '０';
            }
            else if (c == '”') { // 双引号

                c = '"';
            }
            else if (c == '“') {
                c = '"';
            }
            else if (c == '＜') { // 小于号

                c = '<';
            }
            else if (c == '＞') {
                c = '>';
            }
            else if (c == '’') { // 单引号

                c = '\'';
            }
            else if (c == '‘') {
                c = '\'';
            }
            else if (c == '，') { // 逗号
                c = ',';
            }
            else if (c == '；') { // 分号
                c = ';';
            }
            else if (c == '。') {
                c = '.';
            }
            else if (c == '＆') {
                c = '&';
            }

            sb.append((char) c);
        }

        return sb.toString();
    }

    /**
     * 返回某字符串中所有符合正则表达式的子字符串，以字符串数组形式返回
     * 
     * @param src String
     * @param pattern String
     * @return String[]
     */
    public static String[] findAll(String src, String pattern) {
        if (src == null) {
            return new String[0];
        }
        if (pattern == null) {
            return new String[0];
        }

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(src);
        Collection<String> l = new ArrayList<String>();
        while (m.find()) {
            l.add(m.group());
        }

        return (String[]) l.toArray(new String[] {});
    }

    /**
     * 组织数组为SQL查询中的In子句: (x,y,z) 如果数组是字符串，那么组织为 ('x','y','z')
     * 
     * @param conditions String[]
     * @param isString boolean
     * @return String
     */
    public static final String getQryCondtion(String[] conditions,
            boolean isString) {
        if (conditions == null || conditions.length <= 0) {
            return null;
        }
        StringBuffer cond = new StringBuffer("(");
        for (int i = 0; i < conditions.length; i++) {
            if (isString) {
                cond.append("'").append(conditions[i]).append("'");
            }
            else {
                cond.append(conditions[i]);
            }
            cond.append(",");
        }
        cond.replace(cond.length() - 1, cond.length(), ")");

        return cond.toString();
    }

    /**
     * @param c Collection
     * @return String
     */
    public static String loadFromCollection(Collection c) {
        StringBuffer sb = new StringBuffer();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    /**
     * 从TEXT FILE 加载资源, 对英文资源。
     * 
     * @param filename String
     * @throws FileNotFoundException
     * @throws IOException
     * @return String
     */
    public static String loadFromFile(String filename)
            throws FileNotFoundException, IOException {
        StringBuffer sb = new StringBuffer();
        FileInputStream in = new FileInputStream(filename);
        byte[] buf = new byte[1024];

        try {
            while (true) {
                int n = in.read(buf);
                sb.append(new String(buf, 0, n));
                if (n < 1024) {
                    break;
                }
            }
        }
        catch (IOException ex) {
            throw ex;
        }
        finally {
            in.close();
        }

        return sb.toString();
    }

    /**
     * 从TEXT FILE 加载资源，根据文件的具体编码方式
     * 
     * @param filename String
     * @throws FileNotFoundException
     * @throws IOException
     * @return String
     */
    public static String loadFromFile(String filename, String encoding)
            throws FileNotFoundException, IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader b = new BufferedReader(new InputStreamReader(
                new FileInputStream(filename), encoding));

        try {
            while (true) {
                String s = b.readLine();
                if (s != null) {
                    sb.append(s + "\r\n");
                }
                else {
                    break;
                }
            }
        }
        catch (IOException ex) {
            throw ex;
        }
        finally {
            b.close();
        }

        return sb.toString();
    }

    /**
     * 从URL 加载资源
     * 
     * @param url String
     * @throws MalformedURLException
     * @throws IOException
     * @return String
     */
    public static String loadFromUrl(String url) throws MalformedURLException,
            IOException {
        StringBuffer sb = new StringBuffer();
        URL u = new URL(url);
        InputStream in = u.openStream();
        byte[] buf = new byte[1024];

        try {
            while (true) {
                int n = in.read(buf);
                sb.append(new String(buf, 0, n));
                if (n < 1024) {
                    break;
                }
            }
        }
        catch (IOException ex) {
            in.close();
            throw ex;
        }
        finally {
            in.close();
        }

        return sb.toString();
    }

    /**
     * 字符串替换：如（"aa_a","a_","A"）即将字符串"aa_a"中的"a_"替换为"A" 得到aAa
     * 
     * @param source
     * @param oldString
     * @param newString
     * @return
     */
    public static String replace(String source, String oldString,
            String newString) {
        StringBuffer output = new StringBuffer();
        int lengthOfSource = source.length();
        int lengthOfOld = oldString.length();
        int posStart;
        int pos;
        for (posStart = 0; (pos = source.indexOf(oldString, posStart)) >= 0; posStart = pos
                + lengthOfOld) {
            output.append(source.substring(posStart, pos));
            output.append(newString);
        }

        if (posStart < lengthOfSource) {
            output.append(source.substring(posStart));
        }
        return output.toString();
    }

    /**
     * @param name
     * @param split
     * @return
     */
    public static String secondSplit(String name, String split) {
        if (name == null || name.equals("")) {
            return "";
        }
        if (split == null || split.equals("")) {
            split = ".";
        }

        int index = name.indexOf(split);
        if (index >= 0) {
            return name.substring(index + split.length());
        }

        return name;
    }

    /**
     * return String basename
     * 
     * @param name String
     * @param split String
     * @return String com.ztesoft.ispp.ne --> ne
     */
    public static String pathname(String name, String split) {
        if (name == null || name.equals("")) {
            return "";
        }
        if (split == null || split.equals("")) {
            split = ".";
        }

        int index = name.lastIndexOf(split);
        if (index >= 0) {
            return name.substring(0, index);
        }

        return name;
    }

    /**
     * return String basename
     * 
     * @param name String
     * @param split String
     * @return String com.ztesoft.ispp.ne --> ne
     */
    public static String basename(String name, String split) {
        if (name == null || name.equals("")) {
            return "";
        }
        if (split == null || split.equals("")) {
            split = ".";
        }

        int index = name.lastIndexOf(split);
        if (index >= 0) {
            return name.substring(index + split.length());
        }

        return name;
    }

    /**
     * @param src String
     * @return String
     */
    public static String firstCharToUpperCase(String src) {
        if (src == null) {
            return null;
        }

        if (src.length() > 0) {
            src = src.substring(0, 1).toUpperCase() + src.substring(1);
        }

        return src;
    }

    /**
     * @param t
     * @return
     */
    public static String throwableToString(Throwable t) {
        StringBuffer sb = new StringBuffer();
        sb.append(t.getClass().getName());
        if (t.getMessage() != null) {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            t.printStackTrace(new PrintStream(bo));
            sb.append(":\r\n\t" + bo.toString());
        }
        return sb.toString();
    }

    /**
     * long转换成字符串，如果位数不足str长度，把str多余的值补齐 如 long2StringForLen(30,"000000") 返回 000030
     * 
     * @param num
     * @param str
     * @return
     */
    public static String long2StringForLen(long num, String str) {
        int len = String.valueOf(num).length();
        if (len > str.length()) {
            return String.valueOf(num).substring(len - str.length(), len);
        }
        else {

            return str.substring(0, str.length() - len) + String.valueOf(num);
        }
    }

    /**
     * 将为null的object toString()为空字符串
     * 
     * @param obj
     * @return
     */
    public static String objToString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * split操作。
     * 
     * @param line String
     * @param separator String
     * @return String[]
     */
    public static final String[] split(String line, String separator) {
        LinkedList<String> list = new LinkedList<String>();
        if (line != null) {
            int start = 0;
            int end = 0;
            int separatorLen = separator.length();
            while ((end = line.indexOf(separator, start)) >= 0) {
                list.add(line.substring(start, end));
                start = end + separatorLen;
            }
            if (start < line.length()) {
                list.add(line.substring(start, line.length()));
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * 字符串按字节截取
     * 
     * @param str 原字符
     * @param len 截取长度
     * @param elide 省略符
     * @return String
     */
    public static String splitString(String str, int len, String elide) {
        if (str == null) {
            return "";
        }
        byte[] strByte = str.getBytes();
        int strLen = strByte.length;
        int elideLen = (elide.trim().length() == 0) ? 0
                : elide.getBytes().length;
        if (len >= strLen || len < 1) {
            return str;
        }
        if (len - elideLen > 0) {
            len = len - elideLen;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = (int) strByte[i];
            if (value < 0) {
                count++;
            }
        }
        if (count % 2 != 0) {
            len = (len == 1) ? len + 1 : len - 1;

        }
        return new String(strByte, 0, len) + elide.trim();
    }

    /**
     * 获得“，”分隔的字符??
     * 
     * @author Lihaibin
     * @since 2007-03-22
     * @param ArrayList
     * @return String
     */
    public static String getStringDivideByCommaFromList(Object[] inputList,
            boolean isNeedAddSingleQuote) {
        if ((inputList == null) || (inputList.length == 0)) {
            return "";
        }
        String ret = null;
        if (inputList[0] != null) {
            if (isNeedAddSingleQuote) {
                ret = "'" + inputList[0].toString() + "'";
            }
            else {
                ret = inputList[0].toString();
            }
        }

        for (int i = 1; i < inputList.length; i++) {

            if (isNeedAddSingleQuote) {
                ret += "," + "'" + inputList[i].toString() + "'";
            }
            else {
                ret += "," + inputList[i].toString();
            }
        }
        return ret;
    }

    /**
     * 将输入流转换为String Returns the content of a given input stream, as a String object.
     * 
     * @param is the input stream to read.
     * @return the content of the given input stream
     * @throws IOException Reporting failure to read from the InputStream
     */
    public static String getStringFromStream(final InputStream is)
            throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    /**
     * 首字母转小写
     * 
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder())
                    .append(Character.toLowerCase(s.charAt(0)))
                    .append(s.substring(1)).toString();
    }

    /**
     * 首字母转大写
     * 
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder())
                    .append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).toString();
    }

    /**
     * 数据库字段改驼峰，，比如USER_NAME->userName
     * 
     * @param s
     * @return
     */
    public static String toHump(String str) {
        char[] _strs = str.toLowerCase().toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < _strs.length; i++) {
            char c = _strs[i];
            if (c == '_') {
                c = _strs[++i];
                sb.append(new String(c + "").toUpperCase());
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static List<Map<String, Object>> toHump(
            List<Map<String, Object>> records) {
        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> record : records) {
            Map<String, Object> result = new HashMap<String, Object>();
            for (String key : record.keySet()) {
                if (key.indexOf("_") != -1
                        || Character.isUpperCase(key.substring(0, 1).charAt(0))) {
                    result.put(toHump(key), record.get(key));
                }
                else
                    result.put(key, record.get(key));
            }
            results.add(result);
        }
        return results;
    }

    /**
     * 驼峰改数据库字段，，比如userName->USER_NAME
     * 
     * @param s
     * @return
     */
    public static String toDBString(String str) {
        char[] _strs = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < _strs.length; i++) {
            char c = _strs[i];
            if (c >= 'A' && c <= 'Z') {
                sb.append("_" + c);
            }
            else {
                sb.append(new String(c + "").toUpperCase());
            }
        }
        return sb.toString();
    }

}
