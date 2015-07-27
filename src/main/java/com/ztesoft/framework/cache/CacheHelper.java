package com.ztesoft.framework.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 缓存复制类 可扩展的功能：当chche到内存溢出时必须清除掉最早期的一些缓存对象，这就要求对每个缓存对象保存创建时间
 */
public class CacheHelper {
    private static HashMap cacheMap = new HashMap();

    /**
     * 单实例构造方法
     */
    private CacheHelper() {
        super();
    }

    /**
     * 获取布尔值的缓存
     * 
     * @param key 缓存键值
     * @return
     */
    public static boolean getBooleanFlag(String key) {
        try {
            return (Boolean) cacheMap.get(key);
        }
        catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置布尔值的缓存
     * 
     * @param key 缓存名称
     * @param flag 缓存内容
     * @return
     */
    public synchronized static boolean setBooleanFlag(String key, boolean flag) {
        if (flag && getBooleanFlag(key)) {// 假如为真不允许被覆盖
            return false;
        }
        else {
            cacheMap.put(key, flag);
            return true;
        }
    }

    /**
     * 获取long类型缓存
     * 
     * @param key 缓存名称
     * @return
     */
    public static long getLongFlag(String key) {
        try {
            return (Long) cacheMap.get(key);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 设置long类型的缓存
     * 
     * @param key 缓存名称
     * @param serverbegrundt 缓存内容
     * @return
     */
    public synchronized static boolean setLongFlag(String key,
            long serverbegrundt) {
        if (cacheMap.get(key) == null) {
            cacheMap.put(key, serverbegrundt);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 得到缓存。同步静态方法
     * 
     * @param key
     * @return
     */
    private synchronized static Cache getCache(String key) {
        return (Cache) cacheMap.get(key);
    }

    /**
     * 获取缓存信息
     * 
     * @param key
     * @return
     */
    public static Cache getCacheInfo(String key) {

        if (hasCache(key)) {
            Cache cache = getCache(key);
            if (cacheExpired(cache)) { // 调用判断是否终止方法
                cache.setExpired(true);
            }
            return cache;
        }
        else
            return null;
    }

    /**
     * 判断是否存在一个缓存
     * 
     * @param key
     * @return
     */
    private synchronized static boolean hasCache(String key) {
        return cacheMap.containsKey(key);
    }

    // [start]clear

    /**
     * 清除所有缓存
     */
    public synchronized static void clearAll() {
        cacheMap.clear();
    }

    /**
     * 清除某一类特定缓存,通过遍历HASHMAP下的所有对象，来判断它的KEY与传入的TYPE是否匹配
     * 
     * @param type 缓存类型
     */
    public synchronized static void clearAll(String type) {
        Iterator i = cacheMap.entrySet().iterator();
        String key;
        ArrayList<String> arr = new ArrayList<String>();
        try {
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.startsWith(type)) { // 如果匹配则删除掉
                    arr.add(key);
                }
            }
            for (int k = 0; k < arr.size(); k++) {
                clearOnly(arr.get(k));
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 清除指定的缓存
     * 
     * @param key
     */
    public synchronized static void clearOnly(String key) {
        cacheMap.remove(key);
    }

    // [end]

    // [start]put

    /**
     * 载入缓存
     * 
     * @param key
     * @param obj
     */
    public synchronized static void putCache(String key, Cache obj) {
        cacheMap.put(key, obj);
    }

    /**
     * 载入缓存信息
     * 
     * @param key
     * @param obj
     * @param dt
     * @param expired
     */
    public static void putCacheInfo(String key, Cache obj, long dt,
            boolean expired) {
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setTimeOut(dt + System.currentTimeMillis()); // 设置多久后更新缓存
        cache.setValue(obj);
        cache.setExpired(expired); // 缓存默认载入时，终止状态为FALSE
        cacheMap.put(key, cache);
    }

    /**
     * 重写载入缓存信息方法
     * 
     * @param key
     * @param obj
     * @param dt
     */
    public static void putCacheInfo(String key, Cache obj, long dt) {
        Cache cache = new Cache();
        cache.setKey(key);
        cache.setTimeOut(dt + System.currentTimeMillis());
        cache.setValue(obj);
        cache.setExpired(false);
        cacheMap.put(key, cache);
    }

    // [end]

    /**
     * 判断缓存是否终止
     * 
     * @param cache
     * @return
     */
    public static boolean cacheExpired(Cache cache) {
        // 传入的缓存不存在
        if (null == cache) {
            return false;
        }
        // 系统当前的毫秒数
        long nowDt = System.currentTimeMillis();
        // 缓存内的过期毫秒数
        long cacheDt = cache.getTimeOut();
        if (cacheDt <= 0 || cacheDt > nowDt) { // 过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE
            return false;
        }
        else { // 大于过期时间 即过期
            return true;
        }
    }

    /**
     * 获取缓存中的大小
     * 
     * @return
     */
    public static int getCacheSize() {
        return cacheMap.size();
    }

    /**
     * 获取指定的类型的大小
     * 
     * @param type
     * @return
     */
    public static int getCacheSize(String type) {
        int k = 0;
        Iterator i = cacheMap.entrySet().iterator();
        String key;
        try {
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.indexOf(type) != -1) { // 如果匹配则删除掉
                    k++;
                }
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return k;
    }

    /**
     * 获取缓存对象中的所有键值名称
     * 
     * @return
     */
    public static ArrayList<String> getCacheAllkey() {
        ArrayList a = new ArrayList();
        try {
            Iterator i = cacheMap.entrySet().iterator();
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                a.add((String) entry.getKey());
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        finally {
            return a;
        }
    }

    /**
     * 获取缓存对象中指定类型 的键值名称
     * 
     * @param type
     * @return
     */
    public static ArrayList<String> getCacheListkey(String type) {
        ArrayList a = new ArrayList();
        String key;
        try {
            Iterator i = cacheMap.entrySet().iterator();
            while (i.hasNext()) {
                java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
                key = (String) entry.getKey();
                if (key.indexOf(type) != -1) {
                    a.add(key);
                }
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        finally {
            return a;
        }
    }
}