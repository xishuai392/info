package com.ztesoft.framework.cipher.handle;

import java.security.Key;
import java.security.KeyPair;

/**
 * 有密钥非对称算法处理接口
 * 
 * @author wang.zhenying
 * 
 */
public interface AsymmericEncryptionHandle {

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @param publicKey 非对称Key
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr, Key publicKey);

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @param privateKey 非对称Key
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr, Key privateKey);

    /**
     * 生成非对称key
     * 
     * @return 非对称Key
     */
    public KeyPair generateAsymmericKey();
}
