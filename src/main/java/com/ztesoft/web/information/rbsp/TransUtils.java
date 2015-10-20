/**
 * 
 */
package com.ztesoft.web.information.rbsp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

import org.apache.commons.net.util.Base64;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年10月19日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.information.rbsp <br>
 */

public class TransUtils {

    /**
     * 转换性别
     * 
     * @param source
     * @return
     */
    public static String transSex(String source) {
        if ("0".equals(source))
            return "男";
        return "女";
    }

    /**
     * 图片转化成base64字符串
     * 
     * @param imgFilePath
     * @return
     */
    public static String Image2Base64String(String imgFilePath)
            throws Exception {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        in = new FileInputStream(imgFilePath);
        data = new byte[in.available()];
        in.read(data);
        in.close();
        // 对字节数组Base64编码
        Base64 encoder = new Base64();
        return encoder.encodeToString(data);// 返回Base64编码过的字节数组字符串
    }

    /**
     * base64字符串转化成图片
     * 
     * @param imgStr
     * @param imgFilePath
     * @return
     */
    public static boolean base64String2Image(String imgFilePath, String imgStr)
            throws Exception { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        Base64 encoder = new Base64();
        // Base64解码
        byte[] b = encoder.decode(imgStr);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {// 调整异常数据
                b[i] += 256;
            }
        }
        // 生成jpeg图片
        // imgFilePath = "C:/Users/Star/Desktop/test22.png";// 新生成的图片
        OutputStream out = new FileOutputStream(imgFilePath);
        out.write(b);
        out.flush();
        out.close();
        return true;
    }

    /**
     * 图片转化成十六进制字符串
     * 
     * @param imagePath
     * @return
     */
    public static String image2hexString(String imagePath) throws Exception {
        String imgStr = null;
        // 将图片转换成字符串
        File imgFile = new File(imagePath);
        FileInputStream fis = new FileInputStream(imgFile);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();

        imgStr = byte2hex(bytes);

        return imgStr;
    }

    /**
     * 把十六进制字符串保存为图片
     * 
     * @param savePathName
     * @param imgStr
     * @throws FileNotFoundException
     */
    public static boolean hexString2Image(String imgFilePath, String imgStr)
            throws Exception {
        if (imgStr == null) // 图像数据为空
            return false;
        // 将字符串转换成二进制，用于显示图片
        byte[] imgByte = hex2byte(imgStr);
        FileOutputStream fos = new FileOutputStream(imgFilePath);
        fos.write(imgByte);
        fos.flush();
        fos.close();
        return true;
    }

    /**
     * 二进制转字符串
     * 
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) // 二进制转字符串
    {
        StringBuffer sb = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                sb.append("0" + stmp);
            }
            else {
                sb.append(stmp);
            }

        }
        return sb.toString();
    }

    /**
     * 字符串转二进制
     * 
     * @param str
     * @return
     */
    public static byte[] hex2byte(String str) { // 字符串转二进制
        if (str == null)
            return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)
            return null;
        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer
                        .decode("0X" + str.substring(i, i + 2)).intValue();
            }
            return b;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {

        String imagePath = "C:\\mvnLib\\a.jpg";
        String hexStr = TransUtils.image2hexString(imagePath);
        System.out.println(hexStr);
        TransUtils.hexString2Image("C:\\mvnLib\\b.jpg", hexStr);

        String base64Str = TransUtils.Image2Base64String(imagePath);
        System.out.println(base64Str);
        TransUtils.base64String2Image("C:\\mvnLib\\base64.jpg", base64Str);
    }
    
}
