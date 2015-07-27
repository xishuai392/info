package com.ztesoft.core.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;
import com.ztesoft.framework.util.StringUtils;

/**
 * 线程池工厂
 * 
 * @author wang.zhenying
 * 
 */
public class ThreadPoolFactory {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(SimpleTaskExecutor.class);
    /**
     * 线程池map
     */
    private static ConcurrentHashMap<String, GeneralThreadPool> tpHash = new ConcurrentHashMap<String, GeneralThreadPool>();
    
    /**
     * 默认核心线程存活时间
     */
    private static final long DEFAULTKEEPALIVETIME = 60;
    /**
     * 默认核心线程存活时间
     */
    private static final TimeUnit DEFAULTUNIT = TimeUnit.SECONDS;
    /**
     * 默认拒绝策略
     */
    private static final RejectedExecutionHandler DEFAULTHANDLER =
        new ThreadPoolExecutor.CallerRunsPolicy();

    /**
     * 创建单个线程concurrent线程池
     * @param name 线程池名
     * @return GeneralThreadPool 线程池
     * @throws BaseAppException BaseAppException
     */
    public static GeneralThreadPool createSingleThreadPool(String name) throws BaseAppException {
        return createGeneralThreadPool(name, 1, 1, DEFAULTKEEPALIVETIME, DEFAULTUNIT,
                new LinkedBlockingQueue<Runnable>(), DEFAULTHANDLER);
    }
    
    /**
     * 创建固定大小concurrent线程池(不使用队列,直接提交策略)
     * @param name 线程池名
     * @param corePoolSize 核心池大小
     * @return GeneralThreadPool 线程池
     * @throws BaseAppException 异常
     */
    public static GeneralThreadPool createGeneralThreadPool(String name,
            int corePoolSize) throws BaseAppException {
        return createGeneralThreadPool(name, corePoolSize, corePoolSize, DEFAULTKEEPALIVETIME, DEFAULTUNIT,
                new SynchronousQueue<Runnable>(), DEFAULTHANDLER);
    }

    /**
     * 创建固定大小concurrent线程池(使用有界队列)
     * @param name 线程池名
     * @param corePoolSize  核心池大小
     * @param queueSize 队列大小
     * @return GeneralThreadPool 线程池
     * @throws BaseAppException 异常
     */
    public static GeneralThreadPool createGeneralBoundedThreadPool(String name,
            int corePoolSize, int queueSize) throws BaseAppException {
        return createGeneralThreadPool(name, corePoolSize, corePoolSize, DEFAULTKEEPALIVETIME, DEFAULTUNIT,
                new ArrayBlockingQueue<Runnable>(queueSize), DEFAULTHANDLER);
    }

    /**
     * 创建固定大小concurrent线程池(使用无界队列)
     * @param name 线程池名
     * @param corePoolSize  核心池大小
     * @return GeneralThreadPool 线程池
     * @throws BaseAppException 异常
     */
    public static GeneralThreadPool createGeneralUnboundedThreadPool(String name,
            int corePoolSize) throws BaseAppException {
        return createGeneralThreadPool(name, corePoolSize, corePoolSize, DEFAULTKEEPALIVETIME, DEFAULTUNIT,
                new LinkedBlockingQueue<Runnable>(), DEFAULTHANDLER);
    }
    
    /**
     * 创建concurrent线程池
     * @param name 线程池名
     * @param corePoolSize 核心池大小
     * @param maximumPoolSize 线程池最大线程数
     * @param keepAliveTime 核心线程存活时间
     * @param unit 核心线程存活时间单位
     * @param queue 队列
     * @param handler 拒绝策略
     * @return GeneralThreadPool 线程池
     * @throws BaseAppException 异常
     */
    public static GeneralThreadPool createGeneralThreadPool(String name,
            int corePoolSize, int maximumPoolSize, long keepAliveTime,
            TimeUnit unit, BlockingQueue<Runnable> queue,
            RejectedExecutionHandler handler) throws BaseAppException {
        checkThreadPoolName(name);
        ThreadPoolExecutor executor = null;

        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                keepAliveTime, unit, queue, handler);

        GeneralThreadPool cte = new GeneralThreadPool(name, executor);
        LOGGER.info(StringUtils
                .format("Create concurrent thread pool,the name:[{0}],corePoolSize:[{1}],maxPoolSize:[{2}]]",
                        name, String.valueOf(corePoolSize),
                        String.valueOf(corePoolSize)));
        tpHash.putIfAbsent(name, cte);
        return cte;

    }

    /**
     * 校验是否线程池已经存在
     * 
     * @param name 
     * @return boolean
     */
    public static boolean checkThreadPoolExist(String name) {
        return tpHash.containsKey(name);
    }

    /**
     * 校验线程池名
     * @param name 
     * @throws BaseAppException 
     */
    private static void checkThreadPoolName(String name) throws BaseAppException {
        AssertUtils.isNotEmpty(name);
        if (tpHash.containsKey(name)) {
            ExceptionHandler.publish("S-SYS-00100");
        }
    }

    /**
     * 删除线程池
     * @param name 
     */
    static void removeThreadPoolByName(String name) {
        tpHash.remove(name);
    }
    
    /**
     * 根据名字获取线程池
     * @param name 线程池名
     * @return GeneralThreadPool 线程池
     */
    static GeneralThreadPool getThreadPoolByName(String name) {
        AssertUtils.isNotEmpty(name);
        if (tpHash.containsKey(name)) {
            return tpHash.get(name);
        }
        else {
            return null;
        }
    }
}
