package com.ztesoft.framework.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.mina.core.buffer.IoBuffer;

import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * byte数组操作辅助类
 */
public class ByteUtils {
    private final static ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(ByteUtils.class);

    public static byte[] append(byte[] a, byte[] b) {
        if (a == null) {
            return b;
        }
        return ArrayUtils.addAll(a, b);
    }

    /**
     * 截取数组
     * 
     * @param bytes 数组
     * @param len 截取长度
     * @return
     */
    public static byte[] interception(byte[] bytes, int len) {
        IoBuffer totalData = IoBuffer.allocate(len);
        totalData.put(bytes, 0, len);
        return totalData.array();
    }

    /**
     * 截取数组末尾
     * 
     * @param bytes 数组
     * @param position 开始截取位置
     * @return
     */
    public static byte[] deinterception(byte[] bytes, int position) {
        IoBuffer totalData = IoBuffer.allocate(bytes.length - position);
        totalData.put(bytes, position, bytes.length - position);
        return totalData.array();
    }

    /**
     * 从数据中取数据
     * 
     * @param bytes 数组
     * @param position 开始获取数据位置
     * @param len 获取数据长度
     * @return
     */
    public static byte[] takebytes(byte[] bytes, int position, int len) {
        if (len <= 0) {
            return null;
        }
        byte[] b = new byte[len];
        if (bytes.length - position <= 0) {
            for (int i = 0; i < len; i++) {
                b[i] = 0;
            }
            return b;
        }

        System.arraycopy(bytes, position, b, 0,
                bytes.length - position >= len ? len : bytes.length - position);
        if (bytes.length - position < len) {
            for (int i = bytes.length - position; i < b.length; i++) {
                b[i] = 0;
            }
        }
        return b;
    }

    public static void main(String[] args) {

        byte[] c = new byte[10];
        for (int i = 0; i < 10; i++) {
            c[i] = 1;
        }

        byte[] d = takebytes(c, 0, 6);
        d = takebytes(c, 10, 6);

        for (byte cc : d) {
            System.out.print(cc + ",");
        }

        for (byte cc : d) {
            cc = -1;
        }
        System.out.println("");
        d = takebytes(c, 9, 6);

        for (byte cc : d) {
            System.out.print(cc + ",");
        }
        for (byte cc : d) {
            cc = -1;
        }
        System.out.println("");
        d = takebytes(c, 7, 6);

        for (byte cc : d) {
            System.out.print(cc + ",");
        }
        System.out.println("");

        /*
         * File file = new File("d:/我的文档/桌面/爱丫爱丫.wav"); try { FileInputStream stream = new FileInputStream(file); byte[] b = new byte[44];
         * stream.read(b); for (byte cc : b) { System.out.print(cc + ","); } } catch (Throwable e) { // TODO Auto-generated catch block
         * logger.error(e); }
         */

    }

    public class Byteappender implements Runnable {
        List<byte[]> list;

        ByteUtils byteUtils;

        public Byteappender() {
            list = new ArrayList<byte[]>();
            for (int j = 0; j < 1655; j++) {
                byte[] array = new byte[256];
                for (int i = 0; i < array.length; i++) {
                    array[i] = 1;
                }
                list.add(array);
            }
            byteUtils = new ByteUtils();
        }

        public void run() {
            byte[] a = new byte[0];
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            for (int i = 0; i < 1600; i++) {
                if (i > 10 && i % 10 == 0) {
                    a = byteUtils.interception(a, 2500);
                }
                else {
                    a = byteUtils.append(a, list.get(i));
                }
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    logger.error(e);
                }
            }
            stopWatch.stop();
            logger.info(stopWatch.getTime() + "---" + a.length);
        }

    }

    /**
     * byte数组转换为十六进制string
     * 
     * @param bytes 数组
     * @return
     */
    public static String bytesToHexString(byte[] bytes) {
        String ret = "";
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    public static String byteArrayToString(byte[] bytes) {
        BufferedInputStream bin = null;
        try {
            bin = new BufferedInputStream(new ByteArrayInputStream(bytes));
            int p = 0xefbb;
            p = (bin.read() << 8) + bin.read();
            String code = null;
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                default:
                    code = "GBK";
            }
            String ret = new String(bytes, code);
            // ret=new String(ret.getBytes(), "UTF-8");
            return ret;
        }
        catch (Throwable e) {
            throw new SysRuntimeException(e);
        }
        finally {
            if (bin != null) {
                try {
                    bin.close();
                }
                catch (IOException e) {
                    throw new SysRuntimeException(e);
                }
            }
        }
    }

    public static byte[] double2Bytes(double x) {
        byte[] b = new byte[8];
        long l = Double.doubleToLongBits(x);
        for (int i = 7; i >= 0; i--) {
            b[i] = new Long(l).byteValue();
            l = l >> 8;
        }
        return b;
    }

    public static byte[] int2Bytes(long value) {
        byte[] byts = null;
        if ((value >= -268435456) && (value <= 268435455)) {
            value &= 536870911;
        }
        if (value < 128) {
            byts = new byte[1];
            byts[0] = (byte) value;
        }
        else if (value < 16384) {
            byts = new byte[2];
            byts[0] = (byte) (((value >> 7) & 0x7F) | 0x80);
            byts[1] = (byte) (value & 0x7F);
        }
        else if (value < 2097152) {
            byts = new byte[3];
            byts[0] = (byte) (((value >> 14) & 0x7F) | 0x80);
            byts[1] = (byte) (((value >> 7) & 0x7F) | 0x80);
            byts[2] = (byte) (value & 0x7F);
        }
        else if (value < 1073741824) {
            byts = new byte[4];
            byts[0] = (byte) (((value >> 22) & 0x7F) | 0x80);
            byts[1] = (byte) (((value >> 15) & 0x7F) | 0x80);
            byts[2] = (byte) (((value >> 8) & 0x7F) | 0x80);
            byts[3] = (byte) (value & 0xFF);
        }
        return byts;
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }
}
