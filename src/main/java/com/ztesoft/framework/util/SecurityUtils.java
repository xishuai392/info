package com.ztesoft.framework.util;

import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.ztesoft.framework.cipher.digest.CipherDigest;
import com.ztesoft.framework.cipher.util.ConvertUtil;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;


/**
 * 加密解密帮助类
 * @author wang.zhenying
 * 
 * 本类支持MD5加密、base64的加密、解密等
 */
public class SecurityUtils {

	//
	private static String aesPwdKey = "4EGJ6D9CFFA2GG9A";

	/**
	 * 日志组件
	 */
	public static final ZTEsoftLogManager logger = ZTEsoftLogManager.getLogger(SecurityUtils.class);
	/**
	 * 加密对象
	 */
	static Cipher eCipher = null;
	/**
	 * 解密对象
	 */
	static Cipher dCipher = null;

	static byte[] bkey = null;

	static byte[] biv = null;

	static AlgorithmParameterSpec paramSpec = null;

	static SecretKey keySpec = null;
	/**
	 * 编码方式
	 */
	static String encoding = "UTF-8";
	/**
	 * base64Decoder
	 */
	static BASE64Decoder base64Decoder = new BASE64Decoder();

	static {
		try {
			eCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			dCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

			bkey = base64Decoder.decodeBuffer("SivnBF2z0IY=");
			biv = base64Decoder.decodeBuffer("uK1EBgjPTr0=");
			paramSpec = new IvParameterSpec(biv);
			keySpec = new SecretKeySpec(bkey, "DES");

			dCipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
			eCipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
		} catch (Exception e) {
			//e.printStackTrace();
			logger.error("", e);
		} catch (Throwable t) {
			//t.printStackTrace();
			logger.error("", t);
		}

	}

	/**
	 * 解密
	 * 
	 * @param decryptString
	 *            String
	 * @return String
	 * @throws Exception
	 */
	public static String decrypt(String decryptString) throws Exception {
		try {
			byte[] bout = null;
			synchronized (dCipher) {
				bout = dCipher.doFinal(base64Decoder.decodeBuffer(decryptString));
			}
			return new String(bout, encoding);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	/**
	 * 加密
	 * 
	 * @param encryptString
	 *            String
	 * @return String
	 * @throws Exception
	 */
	public static String encrypt(String encryptString) throws Exception {
		try {
			byte[] eout = null;
			synchronized (eCipher) {
				eout = eCipher.doFinal(encryptString.getBytes(encoding));
			}
			String eStr = new BASE64Encoder().encode(eout);
			return new String(eStr);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	public static String MD5(String encryptString) throws Exception {
		String digestName = "md5Digest";
		CipherDigest it = CipherDigest.instance(digestName);

		// utf_8输出
		byte[] utf_8_output = null;
		try {
			synchronized (it) {
				utf_8_output = it.encrypt(ConvertUtil.str2Byte(encryptString, encoding));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String utf_8_encrypt = ConvertUtil.bytesToHexString(utf_8_output);

		return utf_8_encrypt;
	}

	/**
	 * 对字符串先进行Base64加密后再进行MD5加密
	 * 
	 * @param inputStr
	 * @return
	 * @throws BaseAppException
	 */
	public static String base64AndMD5(String inputStr) throws BaseAppException {
		//参数校验
		AssertUtils.isNotEmpty(inputStr);

		String result = null;
		try {
			CipherDigest it = null;
			byte[] default_output = null;
			it = CipherDigest.instance("base64Digest");
			default_output = it.encrypt(ConvertUtil.str2Byte(inputStr, "utf-8"));

			String after_base64 = ConvertUtil.byte2Str(default_output, "utf-8");

			it = CipherDigest.instance("md5Digest");
			default_output = it.encrypt(ConvertUtil.str2Byte(after_base64, "utf-8"));

			result = ConvertUtil.bytesToHexString(default_output);
		} catch (Exception e) {
			//
			ExceptionHandler.publish("S-PRF-00098", ExceptionHandler.BUSI_ERROR_TYPE);

		}

		return result;
	}

	/**
	 * 采用DES的CBC模式进行加密，补齐方式为PKCS5Padding
	 * @param encryptString
	 * @return
	 * @throws BaseAppException
	 */
	public static String dESEncrypt(String encryptString) throws BaseAppException {
		String result = null;
		try {
			result = SecurityUtils.encrypt(encryptString);
		} catch (Exception e) {
			// 鍔犲瘑澶辫触
			ExceptionHandler.publish("S-PRF-00098", ExceptionHandler.BUSI_ERROR_TYPE);

		}
		return result;
	}

	/**
	 * 采用DES的CBC模式进行解密，补齐方式为PKCS5Padding
	 * @param encryptString
	 * @return
	 * @throws BaseAppException
	 */
	public static String dESDecrypt(String decryptString) throws BaseAppException {
		String result = null;
		try {
			result = SecurityUtils.decrypt(decryptString);
		} catch (Exception e) {
			//			 解密失败
			ExceptionHandler.publish("S-PRF-00143", ExceptionHandler.BUSI_ERROR_TYPE);
		}
		return result;
	}

	/**
	 *  采用AES的CBC模式方式加密
	 * @param encryptString
	 * @return
	 * @throws BaseAppException
	 */
	public static String aESEncrypt(String encryptString) throws BaseAppException {
		String result = null;
		try {
			byte[] raw = aesPwdKey.getBytes();
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//"绠楁硶/妯″紡/琛ョ爜鏂瑰紡"
			IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());//浣跨敤CBC妯″紡锛岄渶瑕佷竴涓悜閲廼v锛屽彲澧炲姞鍔犲瘑绠楁硶鐨勫己搴?
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(encryptString.getBytes());

			result = new BASE64Encoder().encode(encrypted);
		} catch (Exception ex) {
			// 鍔犲瘑澶辫触
			ExceptionHandler.publish("S-PRF-00098", ExceptionHandler.BUSI_ERROR_TYPE, ex);
		}
		return result;
	}

	/**
	 * 采用AES的CBC模式进行解密
	 * @param encryptString
	 * @return
	 * @throws BaseAppException
	 */
	public static String aESDecrypt(String decryptString) throws BaseAppException {
		String result = null;
		try {
			byte[] raw = aesPwdKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(decryptString);//鍏堢敤base64瑙ｅ瘑

			byte[] original = cipher.doFinal(encrypted1);
			result = new String(original);
		} catch (Exception ex) {
			//
			ExceptionHandler.publish("S-PRF-00143", ExceptionHandler.BUSI_ERROR_TYPE, ex);
		}

		return result;

	}

	public static void main(String[] args) throws Exception {
		//System.out.println(SecurityUtil.decrypt("0o4rwbZKivg="));
		String input = "000000";
		System.out.println("Original string : " + input);
		try {

			// heading
			System.out.println("Provider: type.algorithm -> className \n aliases: \n attributes:\n");
			// discover providers
			Provider[] providers = Security.getProviders();
			for (Provider provider : providers) {
				// discover services of each provider
				System.out.println("<><><>" + provider + "<><><>\n");
				for (Provider.Service service : provider.getServices()) {
					System.out.println(service);
				}
				System.out.println();
			}

			//			String after = SecurityHelper.base64AndMD5(input);
			//			System.out.println("MD5 encrypt : " + after);

			System.out.println("======================");
			String after = aESEncrypt(input);
			System.out.println("DES encrypt : " + after);
			
			after = aESDecrypt(after);
			System.out.println("DES decrypt : " + after);
			System.out.println(ByteUtils.bytesToHexString(bkey));
            System.out.println(ByteUtils.bytesToHexString(biv));
		} catch (BaseAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
