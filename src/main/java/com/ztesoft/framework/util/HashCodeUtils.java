package com.ztesoft.framework.util;

/**
 * <Description> 哈希码帮助类,得到对象或原始数据类型的哈希值<br>
 * 
 * @see com.ztesoft.framework.util <br>
 */
public final class HashCodeUtils {

    /**
     * 构值器.
     */
    private HashCodeUtils() {

    }

    /**
     * 得到int值的哈希值.
     * 
     * @param val int
     * @return int
     */
    public static int hashCode(int val) {
        return val;
    }

    /**
     * 得到short值的哈希值.
     * 
     * @param val short
     * @return int
     */
    public static int hashCode(short val) {
        return val;
    }

    /**
     * 得到long值的哈希值.
     * 
     * @param val long
     * @return int
     */
    public static int hashCode(long val) {
        return (int) val;
    }

    /**
     * 得到double值的哈希值.
     * 
     * @param val double
     * @return int
     */
    public static int hashCode(double val) {
        return (int) val;
    }

    /**
     * 得到float值的哈希值.
     * 
     * @param val float
     * @return int
     */
    public static int hashCode(float val) {
        return (int) val;
    }

    /**
     * 得到boolean值的哈希值.
     * 
     * @param val boolean
     * @return int
     */
    public static int hashCode(boolean val) {
        return (val ? 1 : 0);
    }

    /**
     * 得到String对象的哈希码
     * 
     * @param val String
     * @return int
     */
    public static int hashCode(String val) {
        if (val != null)
            return val.hashCode();
        return 0;
    }

    /**
     * 得到Short对象的哈希码.
     * 
     * @param val Short
     * @return int
     */
    public static int hashCode(Short val) {
        if (val == null) {
            return FrameWorkConstants.DEF_HASH_CODE;
        }
        return val.shortValue();
    }

    /**
     * 得到Integer对象的哈希码
     * 
     * @param val Integer
     * @return int
     */
    public static int hashCode(Integer val) {
        if (val == null) {
            return FrameWorkConstants.DEF_HASH_CODE;
        }
        return val.intValue();
    }

    /**
     * 得到Float对象的哈希码
     * 
     * @param val Float
     * @return int
     */
    public static int hashCode(Float val) {
        if (val == null) {
            return FrameWorkConstants.DEF_HASH_CODE;
        }
        return val.intValue();
    }

    /**
     * 得到Double对象的哈希码
     * 
     * @param val Double
     * @return int
     */
    public static int hashCode(Double val) {
        if (val == null) {
            return FrameWorkConstants.DEF_HASH_CODE;
        }
        return val.intValue();
    }

    /**
     * 得到Long对象的哈希码
     * 
     * @param val Long
     * @return int
     */
    public static int hashCode(Long val) {
        if (val == null) {
            return FrameWorkConstants.DEF_HASH_CODE;
        }
        return val.intValue();
    }

    /**
     * 得到对象的散列码
     * 
     * @param val Object
     * @return int
     */
    public static int hashCode(Object val) {
        if (val != null) {
            return val.hashCode();
        }
        else
            return FrameWorkConstants.DEF_HASH_CODE;
    }

    /**
     * 得到对象数组的散列码
     * 
     * @param vals Object[]
     * @return int
     */
    public static int hashCode(Object[] vals) {

        if (ValidateUtils.validateNotEmpty(vals)) {
            int len = vals.length;
            int hashCode = 0;

            for (int i = 0; i < len; i++) {
                if (vals[i] != null) {
                    hashCode += vals[i].hashCode();
                }
            }

            return hashCode;
        }
        else
            return FrameWorkConstants.DEF_HASH_CODE;
    }

}
