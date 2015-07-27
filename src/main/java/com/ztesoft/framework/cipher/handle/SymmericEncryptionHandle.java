package com.ztesoft.framework.cipher.handle;

import java.security.Key;

/**
 * 有密钥对称算法加密、解密
 * 
 * @author dawn
 * 
 */
public interface SymmericEncryptionHandle {

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @param symmetricKey 对称Key
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr, Key symmetricKey);

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @param symmeticKey 对称Key
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr, Key symmeticKey);

    /**
     * 获取对称算法Key
     * 
     * @return 对称Key
     */
    public Key generateSymmetricKey();
}
