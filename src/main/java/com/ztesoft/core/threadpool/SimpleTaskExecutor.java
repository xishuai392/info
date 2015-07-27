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
package com.ztesoft.core.threadpool;

import com.ztesoft.framework.log.ZTEsoftLogManager;


/**
 * 简单任务执行器
 * @author wang.zhenying
 * 
 */

public abstract class SimpleTaskExecutor {
    /**
     * 日志组件
     */
    private static final ZTEsoftLogManager LOGGER = ZTEsoftLogManager
            .getLogger(SimpleTaskExecutor.class);
    /**
     * 执行参数
     */
    private Object param;
    /**
     * 简单任务线程
     */
    private ConcurrentTask ctk;

    /**
     * 构造函数
     * @param param 执行参数
     */
    protected SimpleTaskExecutor(Object param) {
        setParam(param);
        setTask(new ConcurrentTask(this));
        LOGGER.debug("SimpleAsyncTaskExecutor created.");
    }

    public void setTask(ConcurrentTask ctk) {
        this.ctk = ctk;

    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Object getParam() {
        return param;
    }

    /**
     * 执行任务
     * @return int 返回值
     */
    int doWork() {
        int ret = -1;
        beforeExecute(param);
        Throwable e1 = null;
        try {
            ret = doWork(param);
        } 
        catch (Exception e) {
            LOGGER.error("The task execute error", e);
        }
        afterExecute(e1, param);
        LOGGER.debug("The task execute success.");
        return ret;

    }

    /**
     * 执行前任务
     * @param param 执行参数
     */
    void beforeExecute(Object param) {
    }

    /**
     * 执行后任务
     * @param t 异常
     * @param param 执行参数
     */
    void afterExecute(Throwable t, Object param) {
    }

    /**
     * 执行任务
     * @param param 执行参数
     * @return 返回值
     */
    protected abstract int doWork(Object param);

    public ConcurrentTask getConcurrentTask() {
        return this.ctk;
    }
}
