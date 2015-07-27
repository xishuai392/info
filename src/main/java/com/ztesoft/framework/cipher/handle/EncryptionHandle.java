package com.ztesoft.framework.cipher.handle;

/**
 * 无密钥算法加密、解密
 * 
 * @author wang.zhenying
 * 
 */
public interface EncryptionHandle {

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr);

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr);

}
