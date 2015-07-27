/**
 * 
 */
package com.ztesoft.web.http;

import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;

/**
 * 调用Restful的客户端 ，对应于 大数据平台的《通用查询服务(solr索引条件查询)》<Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年7月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.bsn.cloudmgr.rest <br>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:/config/spring-content.xml", "/config/spring-servlet.xml"
})
public class RestfulSolrQueryClient {
    /** log4j对象 */
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(RestfulSolrQueryClient.class);

    public final static String CHARTSET = "UTF-8";

    // 连接池管理器
    private static PoolingHttpClientConnectionManager cm = null;

    /**
     * 初始化连接池管理器
     * 
     * @return
     */
    public static synchronized PoolingHttpClientConnectionManager getPoolingHttpClientConnectionManager() {

        if (cm == null) {
            long t1 = System.currentTimeMillis();
            logger.info("===== Initializing PoolingHttpClientConnectionManager =====");
            cm = new PoolingHttpClientConnectionManager();
            // Increase max total connection to 20
            cm.setMaxTotal(20);
            // Increase default max connection per route to 20
            cm.setDefaultMaxPerRoute(cm.getMaxTotal());
            // Increase max connections for localhost:80 to 50
            // HttpHost localhost = new HttpHost("locahost", 80);
            // cm.setMaxPerRoute(new HttpRoute(localhost), 50);
            long t2 = System.currentTimeMillis();
            logger.info(String
                    .format("===== Initializing PoolingHttpClientConnectionManager cost time =[%d] =====",
                            (t2 - t1)));
        }
        return cm;
    }

    /**
     * 创建HttpClient
     * 
     * @param isMultiThread
     * @return
     */
    public static HttpClient buildHttpClient(boolean isMultiThread) {
        long t1 = System.currentTimeMillis();
        CloseableHttpClient client;
        if (isMultiThread) {
            client = HttpClientBuilder
                    .create()
                    .setConnectionManager(
                            getPoolingHttpClientConnectionManager()).build();
        }
        else {
            client = HttpClientBuilder.create().build();
            // 设置代理服务器地址和端口
            // client.getHostConfiguration().setProxy("proxy_host_addr",proxy_port);
        }
        long t2 = System.currentTimeMillis();
        // logger.info(String.format(
        // "===== bulid httpclient cost time =[%d] =====", (t2 - t1)));
        return client;
    }

    /**
     * 构建公用RequestConfig
     * 
     * @param timeOut
     * @return
     */
    public static RequestConfig buildRequestConfig(int timeOut) {
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(timeOut).setConnectionRequestTimeout(timeOut)
                .setConnectTimeout(timeOut).build();
        return requestConfig;
    }

    /**
     * 调用大数据平台的 《通用查询服务(solr索引条件查询)》<br>
     * 1.http header 设置<br>
     * token=test_token(具体由平台提供)<br>
     * 2.http method 选择<br>
     * method=POST<br>
     * 3.请求URL<br>
     * http://bdp-app-host/BDP/service/库编码/表编码/solrQuery<br>
     * 4.请求参数<br>
     * q=code%3A*2*&ff=name%2Ccode&sort=name+desc&start=0&rows=10<br>
     * 
     * @param url 封装好的url，形如：http://127.0.0.1:8080/BDP/service/库编码/表编码/solrQuery?q=code%3A*2*&ff=name%2Ccode&sort=name+desc&start=0&rows=10
     * @param timeout 连接超时设置，单位毫秒
     * @return
     * @throws BaseAppException
     */
    public String doGet(String url, Integer timeout) {
        logger.info("QUERY FROM BDP BEGIN，URL = " + url);
        long t01 = System.currentTimeMillis();
        HttpClient client = buildHttpClient(true);
        HttpPost httpPost = null;
        HttpResponse httpResponse = null;
        String jsonContent = "";
        InputStream in = null;
        try {
            // post 方法
            httpPost = new HttpPost(url);
            if (timeout != null) {
                httpPost.setConfig(buildRequestConfig(timeout));
            }

            // 1.http header 设置
            httpPost.setHeader("token", "");

            long t11 = System.currentTimeMillis();
            httpResponse = client.execute(httpPost);
            long t12 = System.currentTimeMillis();
            // logger.info(String
            // .format("===== QUERY FROM BDP,SEND AND RECIEVE COST TIME=[%d]ms =====",
            // (t12 - t11)));

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                long t31 = System.currentTimeMillis();
                // 获取响应实体
                HttpEntity httpEntity = httpResponse.getEntity();
                // 响应内容的长度
                long length = httpEntity.getContentLength();
                // 响应内容
                jsonContent = EntityUtils.toString(httpEntity);

                in = httpEntity.getContent();
                System.out.println("in:" + in);

                long t32 = System.currentTimeMillis();
                long t33 = System.currentTimeMillis();
                // logger.info(String
                // .format("===== QUERY FROM BDP,READ RESULT TIME=[%d]ms,JSON TO BEAN COUST TIME=[%d]ms,ALL TIME=[%d]ms =====",
                // (t32 - t31), (t33 - t32), (t33 - t31)));
            }
            else {
                logger.error("QUERY FROM BDP NOT RETURN HTTP 200! PLEASE CHECK OUT! \n");
            }

        }
        catch (Exception e) {
            logger.error("QUERY FROM BDP CATCH EXCEPTION,FAILED! ERROR MESSAGE ：\n"
                    + e.getMessage());
        }
        finally {
            try {
                // 关闭连接 ,释放资源
                if (in != null) {
                    try {
                        in.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            catch (Exception e) {

            }
        }
        long t02 = System.currentTimeMillis();
        logger.info(String
                .format("===== QUERY FROM BDP RETURN,COST TIME=[%d]ms,jsonContent=[%s] =====",
                        (t02 - t01), jsonContent));

        // logger.error("QUERY FROM BDP RETURN ,TIME [" + (t02 - t01)
        // + "]ms jsonContent =[" + jsonContent + "] ");
        return jsonContent;
    }

    public static void main(String[] args) {

        String urlStr = "http://10.45.44.188:52050/framework/demo/amuser/queryRecordByPage.do?page=1&start=0&limit=20";
        RestfulSolrQueryClient client = new RestfulSolrQueryClient();

        for (int i = 0; i < 100; i++) {
            long t1 = System.currentTimeMillis();
            try {
                String json = client.doGet(urlStr, 1000);
                System.out.println("[" + i + "]json=" + json);
                logger.info("[" + i + "]json=" + json);
            }
            catch (Exception e) {
                logger.error(e);
            }
            long t2 = System.currentTimeMillis();
            logger.error(String.format(
                    "--- Query  End, Query Time=[%d]ms, 第[%d]次 ---", (t2 - t1),
                    i));
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                logger.error(e);
            }
        }
    }

    @Test
    public void threadPoolTest() {
        long t1 = System.currentTimeMillis();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 200, 1000,
                TimeUnit.DAYS, new LinkedBlockingQueue());

        for (int i = 0; i < 100; i++) {
            executor.execute(new RequestThread());
        }
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        long t2 = System.currentTimeMillis();
        logger.info("花费时间为：：：：" + (t2 - t1));
        // executor.shutdown();
    }

    class RequestThread implements Runnable {
        String urlStr = "http://10.45.44.188:52050/framework/demo/amuser/queryRecordByPage.do?page=1&start=0&limit=20";

        RestfulSolrQueryClient client = new RestfulSolrQueryClient();

        /*
         * (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            long t1 = System.currentTimeMillis();
            try {
                while (true) {
                    String json = client.doGet(urlStr, 1000);

                    logger.info("[" + this.toString() + "]json=" + json);
                    Thread.sleep(100);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            long t2 = System.currentTimeMillis();
            logger.error(String.format(
                    "--- Query  End, Query Time=[%d]ms, [%s] ---", (t2 - t1),
                    this.toString()));
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                logger.error(e);
            }
        }

    }
}
