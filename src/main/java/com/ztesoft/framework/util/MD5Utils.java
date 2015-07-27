/**
 * 
 */
package com.ztesoft.framework.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;

import org.springframework.util.DigestUtils;

/**
 * <Description>MD5加密 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月26日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.framework.util <br>
 */

public class MD5Utils {
    public final static String MD5(String s) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
                'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "454431124b761ac3d75a25ac429b0421387d4dc76512bd43d9caa6e02c990b0a82652dca";
        System.out.println(s.length());

        String password = "189911";
        String p = new String(DigestUtils.md5Digest(password.getBytes(Charset
                .forName("UTF-8"))), Charset.forName("UTF-8"));
        System.out.println(p);
    }
}
