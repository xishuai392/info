package com.ztesoft.framework.cipher.arithmetic;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import com.ztesoft.framework.cipher.handle.SymmericEncryptionHandle;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;

/**
 * 对称密钥算法Des实现类
 * 
 * @author wang.zhenying
 * 
 */
public class DESIt implements SymmericEncryptionHandle {

    /**
     * 算法
     */
    private String arithmetic = System.getProperty("DES.algorithm", "DES");

    /** 日志对象 */
    private static final ZTEsoftLogManager LOG = ZTEsoftLogManager.getLogger(DESIt.class);

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @param symmetricKey 对称Key
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr, Key symmetricKey) {
        AssertUtils.isNotEmpty(bInputArr);
        AssertUtils.isNotNull(symmetricKey);
        byte[] bOutputArr = doFinal(bInputArr, Cipher.DECRYPT_MODE,
                symmetricKey);
        return bOutputArr;
    }

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @param symmetricKey 对称Key
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr, Key symmetricKey) {
        AssertUtils.isNotEmpty(bInputArr);
        AssertUtils.isNotNull(symmetricKey);
        byte[] bOutputArr = doFinal(bInputArr, Cipher.ENCRYPT_MODE,
                symmetricKey);
        return bOutputArr;
    }

    /**
     * 生成非对称key
     * 
     * @return 非对称Key
     */
    public Key generateSymmetricKey() {
        SecureRandom sr = new SecureRandom();
        KeyGenerator kg;
        Key key = null;
        try {
            kg = KeyGenerator.getInstance(arithmetic);
            kg.init(sr);
            key = kg.generateKey();
        } 
        catch (NoSuchAlgorithmException e) {
            LOG.error(arithmetic + " No such alorithm", e);
            throw new SysRuntimeException(e, " No such alorithm "
                    + e.getMessage());
        }
        return key;
    }

    /**
     * 进行实际加密解密操作
     * 
     * @param bInputArr 明文
     * @param cipherMode 加密类型
     * @param key 对称Key
     * @return 密文
     */
    private byte[] doFinal(byte[] bInputArr, int cipherMode, Key key) {
        byte[] bOutputArr = null;
        try {
            Cipher cipher = Cipher.getInstance(arithmetic);
            cipher.init(cipherMode, key);
            bOutputArr = cipher.doFinal(bInputArr);
        } 
        catch (Exception e) {
            LOG.error(
                    " Encrypt or decrypt error in des arithmetic operation doFinal ",
                    e);
            throw new SysRuntimeException(e,
                    " Encrypt or decrypt error in des arithmetic operation doFinal "
                            + e.getMessage());
        }
        return bOutputArr;
    }
}
