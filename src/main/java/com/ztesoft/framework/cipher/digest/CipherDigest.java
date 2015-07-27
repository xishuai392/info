package com.ztesoft.framework.cipher.digest;

import java.security.Key;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

import com.ztesoft.framework.cipher.arithmetic.Base64It;
import com.ztesoft.framework.cipher.arithmetic.DESIt;
import com.ztesoft.framework.cipher.arithmetic.MD5It;
import com.ztesoft.framework.cipher.arithmetic.RSAIt;
import com.ztesoft.framework.cipher.arithmetic.SHAIt;
import com.ztesoft.framework.cipher.handle.AsymmericEncryptionHandle;
import com.ztesoft.framework.cipher.handle.EncryptionHandle;
import com.ztesoft.framework.cipher.handle.SymmericEncryptionHandle;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * 获取加密、解密Digest
 * 
 * @author wang.zhenying
 * 
 */
public class CipherDigest implements AsymmericEncryptionHandle,
        EncryptionHandle, SymmericEncryptionHandle {

    /** 日志对象 */
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager.getLogger(CipherDigest.class);
    /**
     * digestMap
     */
    private static Map digestMap = new HashMap();
    /**
     * 锁
     */
    private static byte[] rwLock = new byte[0];
    /**
     * 是否初始化
     */
    private static boolean isInitDigestMap = false;
    /**
     * 无密钥算法
     */
    private EncryptionHandle encryptionHandle = null;
    /**
     * 有密钥非对称算法处理
     */
    private AsymmericEncryptionHandle asymmericEncryptionHandle = null;
    /**
     * 有密钥对称算法
     */
    private SymmericEncryptionHandle symmericEncryptionHandle = null;
    /**
     * 算法名
     */
    private String name = null;

    /**
     * 构造函数
     * @param name 算法名
     */
    protected CipherDigest(String name) {
        this(name, null, null, null);
    }

    /**
     * 构造函数
     * @param name 算法名
     * @param encryptionHandle 无密钥算法
     */
    protected CipherDigest(String name, EncryptionHandle encryptionHandle) {

        this(name, encryptionHandle, null, null);

    }

    /**
     * 构造函数
     * @param name 算法名
     * @param symmericEncryptionHandle  有密钥对称算法
     */
    protected CipherDigest(String name,
            SymmericEncryptionHandle symmericEncryptionHandle) {
        this(name, null, null, symmericEncryptionHandle);
    }

    /**
     * 构造函数
     * @param name 算法名
     * @param asymmericEncryptionHandle 有密钥非对称算法
     */
    protected CipherDigest(String name,
            AsymmericEncryptionHandle asymmericEncryptionHandle) {

        this(name, null, asymmericEncryptionHandle, null);
    }

    /**
     * 构造函数
     * @param name 算法名
     * @param encryptionHandle 无密钥算法
     * @param asymmericEncryptionHandle 有密钥非对称算法
     * @param symmericEncryptionHandle 有密钥对称算法
     */
    protected CipherDigest(String name, EncryptionHandle encryptionHandle,
            AsymmericEncryptionHandle asymmericEncryptionHandle,
            SymmericEncryptionHandle symmericEncryptionHandle) {
        setName(name);
        setEncryptionHandle(encryptionHandle);
        setAsymmericEncryptionHandle(asymmericEncryptionHandle);
        setSymmericEncryptionHandle(symmericEncryptionHandle);
    }

    /**
     * 获取Digest实例
     * 
     * @param cryptDigestName 加密器名
     * @return CipherDigest 加密器
     */
    public static CipherDigest instance(String cryptDigestName) {
        registerAllDigest();
        CipherDigest digest = null;
        synchronized (rwLock) {
            digest = (CipherDigest) digestMap.get(cryptDigestName);
        }
        return digest;
    }

    /**
     * 注册所有的Digest
     * 
     * @return boolean 是否加载成功
     */
    private static boolean registerAllDigest() {
        if (!isInitDigestMap) {
            //
            synchronized (rwLock) {
                registerDigest(new CipherDigest("base64Digest", new Base64It()));
                registerDigest(new CipherDigest("desDigest", new DESIt()));
                registerDigest(new CipherDigest("md5Digest", new MD5It()));
                registerDigest(new CipherDigest("rsaDigest", new RSAIt()));
                registerDigest(new CipherDigest("shaDigest", new SHAIt()));
            }
            isInitDigestMap = true;
            return true;
        } 
        else {
            return false;
        }

    }

    /**
     * 注册Digest
     * 
     * @param digestImpl 加密器
     * @return boolean 是否注册成功
     */
    public static boolean registerDigest(CipherDigest digestImpl) {
        if (digestImpl != null) {
            String digestName = ((CipherDigest) digestImpl).getName();
            digestMap.put(digestName, digestImpl);
            return true;
        } 
        else {
            return false;
        }
    }


    protected void setName(String name) {
        this.name = name;
    }

 
    public String getName() {
        return name;
    }

    public EncryptionHandle getHandle() {
        return encryptionHandle;
    }

    public void setEncryptionHandle(EncryptionHandle encryptionHandle) {
        this.encryptionHandle = encryptionHandle;
    }

    public void setAsymmericEncryptionHandle(
            AsymmericEncryptionHandle asymmericEncryptionHandle) {
        this.asymmericEncryptionHandle = asymmericEncryptionHandle;
    }

    public void setSymmericEncryptionHandle(
            SymmericEncryptionHandle symmericEncryptionHandle) {
        this.symmericEncryptionHandle = symmericEncryptionHandle;
    }

    public byte[] encrypt(byte[] bInput) {
        if (encryptionHandle != null) {
            return encryptionHandle.encrypt(bInput);
        } 
        else {

            logger.error(getName()
                    + " not support this operation! because encryptionHandle is null! by encrypt(byte[] bInput) ");

            throw new UnsupportedOperationException(getName()
                    + " not support this operation because " + getName()
                    + " is not {SHA,MD5,Base64} ! ");
        }

    }

    public byte[] decrypt(byte[] bInput) {
        if (encryptionHandle != null) {
            return encryptionHandle.decrypt(bInput);
        } 
        else {

            logger.error(getName()
                    + " not support this operation! because encryptionHandle is null! by decrypt(byte[] bInput) ");

            throw new UnsupportedOperationException(getName()
                    + " not support this operation because " + getName()
                    + " is not {SHA,MD5,Base64} ! ");

        }
    }

    public byte[] encrypt(byte[] sInput, Key encryptKey) {
        if (asymmericEncryptionHandle != null) {
            return asymmericEncryptionHandle.encrypt(sInput, encryptKey);
        }
        if (symmericEncryptionHandle != null) {
            return symmericEncryptionHandle.encrypt(sInput, encryptKey);
        } 
        else {

            logger.error(getName()
                    + " not support this operation! because asymmericEncryptionHandle is null and symmericEncryptionHandle is null ! by encrypt(byte[] sInput, Key encryptKey) ");

            throw new UnsupportedOperationException(getName()
                    + " not support this operation because " + getName()
                    + " is not an asymmetric or symmetric algorithm ! ");
        }
    }

    public KeyPair generateAsymmericKey() {

        if (asymmericEncryptionHandle != null) {
            return asymmericEncryptionHandle.generateAsymmericKey();
        } 
        else {
            throw new UnsupportedOperationException(getName()
                    + " not support this operation because " + getName()
                    + " is not an asymmetric algorithm ! ");
        }
    }

    public byte[] decrypt(byte[] sInput, Key decryptKey) {
        if (symmericEncryptionHandle != null) {
            return symmericEncryptionHandle.decrypt(sInput, decryptKey);
        }
        if (asymmericEncryptionHandle != null) {
            return asymmericEncryptionHandle.decrypt(sInput, decryptKey);
        } 
        else {
            throw new UnsupportedOperationException(getName()
                    + " not support this operation because " + getName()
                    + " is not an  algorithm ! ");
        }
    }

    public Key generateSymmetricKey() {
        if (symmericEncryptionHandle != null) {
            return symmericEncryptionHandle.generateSymmetricKey();
        } 
        else {
            throw new UnsupportedOperationException(getName()
                    + " not support this operation because " + getName()
                    + " is not an symmetric algorithm ! ");
        }
    }
}
