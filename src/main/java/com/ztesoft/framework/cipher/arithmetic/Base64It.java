package com.ztesoft.framework.cipher.arithmetic;

import com.ztesoft.framework.cipher.handle.EncryptionHandle;
import com.ztesoft.framework.util.AssertUtils;

/**
 * 无密钥Base64实现类
 * 
 * @author wang.zhenying
 * 
 */
public final class Base64It implements EncryptionHandle {

    /**
     * 解密
     * 
     * @param bInputArr 密文
     * @return 明文
     */
    public byte[] decrypt(byte[] bInputArr) {
        AssertUtils.isNotEmpty(bInputArr);

        char[] cInputArr = new char[bInputArr.length];
        for (int loop = 0; loop < bInputArr.length; loop++) {
            cInputArr[loop] = (char) bInputArr[loop];
        }

        return Base64.decode(cInputArr);

    }

    /**
     * 加密
     * 
     * @param bInputArr 明文
     * @return 密文
     */
    public byte[] encrypt(byte[] bInputArr) {

        AssertUtils.isNotEmpty(bInputArr);
        char[] cOutputArr = Base64.encode(bInputArr);

        String temp = new String(cOutputArr);

        return temp.getBytes();

    }

}
