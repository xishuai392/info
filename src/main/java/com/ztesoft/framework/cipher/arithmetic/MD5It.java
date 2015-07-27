package com.ztesoft.framework.cipher.arithmetic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ztesoft.framework.cipher.handle.EncryptionHandle;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;

/**
 * 无密钥Md5实现
 * 
 * @author wang.zhenying
 * 
 */
public class MD5It implements EncryptionHandle {

    /**
     * 算法
     */
    private String algorithm = System.getProperty("MD5.algorithm", "MD5");

    /** 日志对象 */
    private static final ZTEsoftLogManager LOG = ZTEsoftLogManager.getLogger(MD5It.class);

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr) {
        MessageDigest md = null;
        AssertUtils.isNotEmpty(bInputArr);
        try {
            md = MessageDigest.getInstance(algorithm);
        } 
        catch (SecurityException se) {
            LOG.error(" Security failure. md5 encryption error ", se);
            throw new SysRuntimeException(se,
                    " Security failure. md5 encryption error "
                            + se.getMessage());
        } 
        catch (NoSuchAlgorithmException ex) {
            LOG.error(" No Such Algorithm failure. md5 encryption error", ex);
            throw new SysRuntimeException(ex,
                    " No Such Algorithm failure. md5 encryption error "
                            + ex.getMessage());
        }

        md.update(bInputArr);
        byte bDigest[] = md.digest();

        return bDigest;

    }

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr) {
        throw new SysRuntimeException(
                " MD5 decryption unsupported operation ! ");
    }

}
