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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ztesoft.framework.cipher.handle.EncryptionHandle;
import com.ztesoft.framework.exception.SysRuntimeException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;

/**
 * 无密钥SHA实现类
 * 
 * 
 * @author wang.zhenying
 * 
 */
public class SHAIt implements EncryptionHandle {

    /**
     * 算法
     */
    private String algorithm = System.getProperty("SHA.algorithm", "SHA");

    /** 日志对象 */
    private static final ZTEsoftLogManager LOG = ZTEsoftLogManager.getLogger(SHAIt.class);

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr) {
        MessageDigest sha = null;
        AssertUtils.isNotEmpty(bInputArr);
        try {
            sha = MessageDigest.getInstance(algorithm);
        } 
        catch (SecurityException se) { 
            LOG.error(" Security failure. SHA encryption error ! ", se);
            throw new SysRuntimeException(se,
                    " Security failure. SHA encryption error ! "
                            + se.getMessage());
        } 
        catch (NoSuchAlgorithmException ex) {
            LOG.error(" No Such Algorithm fail  ure. SHA encryption error ! ", ex);
            throw new SysRuntimeException(ex,
                    " No Such Algorithm failure. SHA encryption error ! "
                            + ex.getMessage());
        }
        sha.update(bInputArr);

        return sha.digest();

    }

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr) {
        // TODO Auto-generated method stub
        throw new SysRuntimeException(" SHA decryption unsupported operation !");
    }
}
