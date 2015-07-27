/**
 * Copyright 2010 ZTEsoft Inc. All Rights Reserved.
 *
 * This software is the proprietary information of ZTEsoft Inc.
 * Use is subject to license terms.
 * 
 * $Tracker List
 * 
 * $TaskId: $ $Date: 9:24:36 AM (May 9, 2008) $comments: create 
 * $TaskId: $ $Date: 3:56:36 PM (SEP 13, 2010) $comments: upgrade jvm to jvm1.5 
 *  
 *  
 */
package com.ztesoft.framework.cipher.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import com.ztesoft.framework.util.ValidateUtils;

/**
 * Convert工具类
 * 
 * @author wang.zhenying
 * 
 */
public final class ConvertUtil {
	private ConvertUtil() {

	}

	/**
	 * 把字节数组转换成16进制字符串
	 * 
	 * @param bArray
	 * @return
	 */
	public static final String bytesToHexString(byte[] bArray) {
		if (!ValidateUtils.validateNotNull(bArray)) {
			return null;
		}
		StringBuilder sb = new StringBuilder(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp);
		}
		return sb.toString();
	}

	/**
	 * 把字节数组转换为对象
	 * 
	 * @param bytes
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static final Object bytesToObject(byte[] bytes) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream oi = new ObjectInputStream(in);
		Object o = oi.readObject();
		oi.close();
		return o;
	}

	/**
	 * 把可序列化对象转换成字节数组
	 * 
	 * @param s
	 * @return
	 * @throws IOException
	 */
	public static final byte[] objectToBytes(Serializable s) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream ot = new ObjectOutputStream(out);
		ot.writeObject(s);
		ot.flush();
		ot.close();
		return out.toByteArray();
	}

	/**
	 * 把16进制字符串转换成字节数组
	 * 
	 * @param hex
	 * @return
	 */
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	public static void main(String[] args) {
		byte[] b = new byte[] { -116, -8, -86, -11, 18, 126, 10, -100, -20, 60,
				-102, -24, 6, 65, -41, 108, 64, -106, -123, 103, -111, -54, 87,
				-41, 62, 57, -27, -78, 58, 18, 58, 79, -113, -91, -67, -120,
				41, -119, -11, 49, -116, 116, -60, -25, -113, 106, 29, -103,
				101, 44, 22, -102, 85, -127, 108, -35, 30, -104, -116, 104, 61,
				-82, 49, -22, 122, -56, 107, -110, -47, -98, -25, -2, 8, -47,
				30, -106, 117, -39, 52, 58, -56, -11, -8, -90, 106, 103, -22,
				95, 94, -100, 45, 93, -20, 64, 21, 102, 23, 84, -77, -69, -40,
				28, 69, 24, 37, -3, 76, -105, 109, 14, -117, 7, 60, -110, 3,
				-4, -28, -48, -58, 19, 109, -105, 86, 26, 20, 3, 58, -106 };
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "|");
		}
		String byte2hex2 = bytesToHexString(b);
		System.out.println();
		System.out.println("byte2hex=" + byte2hex2);
		byte[] b1 = hexStringToByte(byte2hex2);
		for (int i = 0; i < b1.length; i++) {
			System.out.print(b1[i] + "|");
		}
	}

	public static byte[] str2Byte(String str, String encoding) {
		boolean useDefault = true;
		byte[] retOut = null;
		if (encoding != null) {
			try {
				retOut = str.getBytes(encoding);
				useDefault = false;
			} catch (UnsupportedEncodingException e1) {
				System.out.println("Unsupport Encoding " + encoding
						+ " for str2Byte");

			}
		}

		if (useDefault) {
			retOut = str.getBytes();
		}
		return retOut;
	}

	public static String byte2Str(byte[] inArr, String encoding) {
		boolean useDefault = true;
		String retOut = null;
		if (encoding != null) {
			try {
				retOut = new String(inArr, encoding);
				useDefault = false;
			} catch (UnsupportedEncodingException e1) {
				System.out.println("Unsupport Encoding " + encoding
						+ " for byte2Str");

			}
		}

		if (useDefault) {
			retOut = new String(inArr);
		}
		return retOut;
	}

}
