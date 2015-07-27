/**
 * 
 */
package com.ztesoft.core.cache;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description>ehcache缓存服务 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年5月26日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.core.cache <br>
 */

public class EhCacheService {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(EhCacheService.class);

    /**
     * 缓存管理器
     */
    private CacheManager ehCacheCacheManager;

    /**
     * 所有缓存实例的集合
     */
    private ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>();

    /**
     * 获取定义的Cache对象
     * 
     * @return
     */
    private Cache getCache(String cacheName) {

        return this.ehCacheCacheManager.getCache(cacheName);
    }

    /**
     * 获取：缓存对象
     * 
     * @param cacheName 缓存名字
     * @param key 对象对应的key值
     * @return 返回缓存中的对象，或者null
     */
    public Object get(String cacheName, Object key) {
        ValueWrapper valueWrapper = getCache(cacheName).get(key);
        if (valueWrapper != null) {
            return getCache(cacheName).get(key).get();
        }
        return valueWrapper;
    }

    /**
     * 存入：缓存对象
     * 
     * @param cacheName 缓存名字
     * @param key 对象对应的key值
     * @param value 缓存对象
     */
    public void put(String cacheName, Object key, Object value) {
        getCache(cacheName).put(key, value);
    }

    /**
     * 删除：如果key对应的缓存数据存在则删除
     * 
     * @param cacheName 缓存名字
     * @param key
     */
    public void evict(String cacheName, Object key) {
        getCache(cacheName).evict(key);
    }

    /**
     * 清除某实例下的所有的缓存对象
     * 
     * @param cacheName 缓存名字
     */
    public void clear(String cacheName) {
        getCache(cacheName).clear();
    }

    /**
     * 清空该缓存管理器下的所有缓存
     */
    public void clearAll() {
        synchronized (this) {
            Collection<String> cacheNames = this.ehCacheCacheManager
                    .getCacheNames();
            Iterator<String> it = cacheNames.iterator();
            while (it.hasNext()) {
                clear(it.next());
            }
        }
    }

    /**
     * 返回所有缓存实例名称
     * 
     * @return
     */
    public Collection<String> getCacheNames() {
        return this.ehCacheCacheManager.getCacheNames();
    }

    /**
     * 获取某缓存实例的大小
     * 
     * @param cacheName
     * @return
     */
    public int getSize(String cacheName) {
        return getNativeCache(cacheName).getSize();
    }

    /**
     * 该方法获取的就是 net.sf.ehcache.Cache对象 cacheName
     * 
     * @return net.sf.ehcache.Cache对象
     */
    public net.sf.ehcache.Ehcache getNativeCache(String cacheName) {
        return (net.sf.ehcache.Ehcache) getCache(cacheName).getNativeCache();
    }

    /**
     * @return the ehCacheCacheManager
     */
    public CacheManager getEhCacheCacheManager() {
        return ehCacheCacheManager;
    }

    /**
     * @param ehCacheCacheManager the ehCacheCacheManager to set
     */
    public void setEhCacheCacheManager(CacheManager ehCacheCacheManager) {
        this.ehCacheCacheManager = ehCacheCacheManager;
    }

}
