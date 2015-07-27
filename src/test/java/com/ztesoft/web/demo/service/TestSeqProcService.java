/**
 * 
 */
package com.ztesoft.web.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ztesoft.core.db.dao.SequenceProcDao;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月1日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service <br>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:/config/spring-content.xml", "/config/spring-servlet.xml"
})
public class TestSeqProcService {
    final static private long THREAD_MAX_RUNTIME = 100000;

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TestSeqProcService.class);

    @Resource(name = "sequenceProcGenerator")
    private ISequenceGenerator sequenceGenerator;

    @Autowired
    private SequenceProcDao sequenceProcDao;

    private Map<String, Object> resultMap = new HashMap<String, Object>();

    private MySeqProcThread[] threadArray = new MySeqProcThread[10];

    BlockingQueue queue = new LinkedBlockingQueue();

    /**
     * <Description>服务线程类 <br>
     * 
     * @author pan.xiaobo<br>
     * @version 1.0<br>
     * @taskId <br>
     * @CreateDate 2014年12月1日 <br>
     * @since V1.0<br>
     * @see com.ztesoft.web.demo.service <br>
     */
    class MySeqProcThread implements Runnable {

        /*
         * (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            Long[] result;
            long t1 = System.currentTimeMillis();
            try {
                result = sequenceGenerator.sequenceBatchLongValue("TEST_PROC",
                        "PROC_ID", "DEF", 1);
                // System.out.println("wwwwwwwww:::::::" + result[0]);
                // logger.error("获取的主键:::" + result[0]);
                resultMap.put(String.valueOf(result[0]), result[0]);
            }
            catch (BaseAppException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            long t2 = System.currentTimeMillis();
            System.out.println("wwwwwwwww:::::::COST TIME:" + (t2 - t1) + "ms");
        }

    }

    /**
     * <Description>DAO线程类 <br>
     * 
     * @author pan.xiaobo<br>
     * @version 1.0<br>
     * @taskId <br>
     * @CreateDate 2014年12月1日 <br>
     * @since V1.0<br>
     * @see com.ztesoft.web.demo.service <br>
     */
    class MySeqDaoThread implements Runnable {

        /*
         * (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            long t1 = System.currentTimeMillis();
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("tableName", "TEST_PROC");
            params.put("columnName", "PROC_ID");
            params.put("schemaName", "DEF");
            params.put("count", 1);
            sequenceProcDao.selectSequence(params);
            String resultStr = (String) params.get("resultStr");
            // System.out.println("ggggggggg:::::::" + resultStr);
            // logger.error("获取的主键:::" + resultStr);
            resultMap.put(resultStr, resultStr);

            long t2 = System.currentTimeMillis();
            System.out.println("ggggggggg:::::::COST TIME:" + (t2 - t1) + "ms");
        }

    }

    @Before
    public void setUp() {
    }

    /**
     * @Test(timeout = THREAD_MAX_RUNTIME)
     */
    public void multiThreadTest() {

        for (int i = 0; i < threadArray.length; i++) {
            Thread t1 = new Thread(threadArray[i]);
            t1.start();
        }
        try {
            Thread.sleep(10000L);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void threadPoolTest() {
        long t1 = System.currentTimeMillis();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 1000,
                TimeUnit.DAYS, new LinkedBlockingQueue());

        for (int i = 0; i < 1000; i++) {
            executor.execute(new MySeqProcThread());
            //executor.execute(new MySeqDaoThread());
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("所有的主键长度为：：：：" + resultMap.size());
        long t2 = System.currentTimeMillis();
        System.out.println("花费时间为：：：：" + (t2 - t1));
        // executor.shutdown();
    }

    /**
     * 单独一条测试
     */
    @Test
    public void testSelectProcedureParam() {
        Long[] result;
        try {
            result = sequenceGenerator.sequenceBatchLongValue("TEST_PROC",
                    "PROC_ID", "DEF", 1);
            System.out.println("ggggggggg:::::::" + result[0]);
            logger.error("获取的主键:::" + result[0]);
        }
        catch (BaseAppException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
