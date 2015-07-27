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
package com.ztesoft.framework.cipher.arithmetic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import com.ztesoft.framework.cipher.handle.AsymmericEncryptionHandle;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;

/**
 * 非对称密钥RSA算法实现   
 * 
 * @author dawn
 * 
 */
public class RSAIt implements AsymmericEncryptionHandle {

    /**
     * 算法
     */
    private String algorithm = System.getProperty("MD5.algorithm", "RSA");

    /**
     * key长度
     */
    private int keysize = 1024;

    /** 日志对象 */
    private static final ZTEsoftLogManager LOG = ZTEsoftLogManager.getLogger(RSAIt.class);

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @param privateKey 非对称Key
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr, Key privateKey) {

        ByteArrayOutputStream bout = null;
        byte[] bOutputArr = null;
        AssertUtils.isNotEmpty(bInputArr);
        AssertUtils.isNotNull(privateKey);

        try {
            Cipher cipher = getCipher(privateKey, Cipher.DECRYPT_MODE);
            int blockSize = cipher.getBlockSize();
            bout = new ByteArrayOutputStream(64);

            for (int j = 0; bInputArr.length - j * blockSize > 0; j++) {

                boolean isExec = bInputArr.length > ((j + 1) * blockSize);

                if (isExec) {
                    bout.write(cipher.doFinal(bInputArr, j * blockSize,
                            blockSize));
                } 
                else {
                    bout.write(cipher.doFinal(bInputArr, j * blockSize,
                            (bInputArr.length - j * blockSize)));
                }
            }
            bOutputArr = bout.toByteArray();
        } 
        catch (IOException ie) {
            LOG.error(" RSA decryption IO Exception ! ", ie);
            throw new SysRuntimeException(ie, " RSA decryption IO Exception ! "
                    + ie.getMessage());
        } 
        catch (Exception is) {
            LOG.error(" RSA decrption error ! ", is);
            throw new SysRuntimeException(is, " RSA decrption error ! "
                    + is.getMessage());
        } 
        finally {
            if (bout != null) {
                try {
                    bout.close();
                } 
                catch (IOException e) {
                    ;// Ignore
                } 
                finally {
                    bout = null;
                }
            }
        }
        return bOutputArr;
    }

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @param publicKey 非对称Key
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr, Key publicKey) {
        AssertUtils.isNotEmpty(bInputArr);
        AssertUtils.isNotNull(publicKey);
        byte[] bOutputArr = null;
        try {
            Cipher cipher = getCipher(publicKey, Cipher.ENCRYPT_MODE);
            int blockSize = cipher.getBlockSize();
            // 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
            // 加密块大小为127
            // byte,加密后为128个byte;因此共有2个加密块，第一个127
            // byte第二个为1个byte
            int outputSize = cipher.getOutputSize(bInputArr.length);
            // 获得加密块加密后块大小

            int leavedSize = bInputArr.length % blockSize;
            int blocksSize = leavedSize != 0 ? bInputArr.length / blockSize + 1
                    : bInputArr.length / blockSize;
            bOutputArr = new byte[outputSize * blocksSize];

            for (int i = 0; bInputArr.length - i * blockSize > 0; i++) {
                if (bInputArr.length - i * blockSize > blockSize) {
                    cipher.doFinal(bInputArr, i * blockSize, blockSize,
                            bOutputArr, i * outputSize);
                }
                else {
                    cipher.doFinal(bInputArr, i * blockSize, bInputArr.length
                            - i * blockSize, bOutputArr, i * outputSize);
                }

            }

        } 
        catch (Exception e) {
            LOG.error(" RSA encryption error ! ", e);
            throw new SysRuntimeException(e, " RSA encryption error ! "
                    + e.getMessage());
        }
        return bOutputArr;
    }

    /**
     * 获取加密器
     * @param key 密钥
     * @param mode 模式
     * @return Cipher 加密器
     * @throws NoSuchAlgorithmException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeyException 
     */
    private Cipher getCipher(Key key, int mode) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException {
        Cipher cipher = Cipher.getInstance(algorithm,
                new org.bouncycastle.jce.provider.BouncyCastleProvider());
        cipher.init(mode, key);
        return cipher;
    }

    /**
     * 生成非对称key
     * 
     * @return 非对称Key
     */
    public KeyPair generateAsymmericKey() {
        KeyPair pair = null;
        try {
            KeyPairGenerator kg = KeyPairGenerator.getInstance(algorithm,
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());

            kg.initialize(keysize);
            pair = kg.genKeyPair();
        } 
        catch (Exception e) {
            LOG.error(" RSA generate key error ! ", e);
            throw new SysRuntimeException(e, " RSA generate key error ! "
                    + e.getMessage());

        }
        return pair;
    }

}
