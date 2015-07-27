package com.ztesoft.core.threadpool;

/**
 * 线程任务
 * 一个简单任务的执行线程
 * @author wang.zhenying
 * 
 */
public class ConcurrentTask implements Runnable {

    /**
     * 简单任务执行器
     */
    private SimpleTaskExecutor sate = null;

    /**
     * 构造函数
     * @param sate 简单任务执行器
     */
    public ConcurrentTask(SimpleTaskExecutor sate) {
        this.sate = sate;
    }

    /**
     * run函数
     */
    public void run() {
        sate.doWork();
    }

}
