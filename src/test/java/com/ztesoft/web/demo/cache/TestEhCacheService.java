/**
 * 
 */
package com.ztesoft.web.demo.cache;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ztesoft.core.cache.EhCacheService;
import com.ztesoft.core.spring.cache.HashCodeKeyGenerator;
import com.ztesoft.core.spring.cache.StringKeyGenerator;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年6月9日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.cache <br>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:/config/spring-content.xml", "/config/spring-servlet.xml"
})
public class TestEhCacheService {

    @Resource(name = "frameworkEhCacheService")
    private EhCacheService ehCacheService;

    @Resource(name = "stringKeyGenerator")
    private StringKeyGenerator stringKeyGenerator;

    @Resource(name = "hashCodeKeyGenerator")
    private HashCodeKeyGenerator hashCodeKeyGenerator;

    /**
     * 打印缓存空间及其大小
     */
    public void printCacheInfo() {
        System.out
                .println("=======================================printCacheInfo start.");
        Collection<String> cacheNames = ehCacheService.getCacheNames();
        Iterator<String> it = cacheNames.iterator();

        while (it.hasNext()) {
            String cacheName = it.next();
            System.out.println(cacheName + ":"
                    + ehCacheService.getSize(cacheName));
        }
        System.out
                .println("=======================================printCacheInfo end.");
    }

    @Test
    public void putToCache() {
        printCacheInfo();
        System.out.println("=======================================");

        // 业务主键，模拟
        long pk = System.currentTimeMillis();

        System.out.println("业务主键:" + pk);

        String strKey = (String) stringKeyGenerator.generate(this, null, pk);
        ehCacheService
                .put("frameworkCache", strKey, System.currentTimeMillis());

        int hashCodeKey = (Integer) hashCodeKeyGenerator.generate(this, null,
                pk);
        ehCacheService.put("frameworkCache", hashCodeKey,
                System.currentTimeMillis());

        System.out.println("缓存 String Key:" + strKey + " Value:"
                + ehCacheService.get("frameworkCache", strKey));
        System.out.println("缓存 HashCode Key:" + hashCodeKey + " Value:"
                + ehCacheService.get("frameworkCache", hashCodeKey));

        System.out.println("=======================================");
        printCacheInfo();
        System.out.println("=======================================");

        // 替换掉主键
        ehCacheService.put("frameworkCache", strKey, "该strKey主键对应的值被更新了");
        ehCacheService.put("frameworkCache", hashCodeKey,
                "该hashCodeKey主键对应的值被更新了");

        System.out.println("缓存 String Key:" + strKey + " Value:"
                + ehCacheService.get("frameworkCache", strKey));
        System.out.println("缓存 HashCode Key:" + hashCodeKey + " Value:"
                + ehCacheService.get("frameworkCache", hashCodeKey));

        System.out.println("=======================================");
        printCacheInfo();
        System.out.println("=======================================");

        // 删除主键
        ehCacheService.evict("frameworkCache", strKey);
        System.out.println("=======================================");
        printCacheInfo();
        System.out.println("=======================================");

        // 删除某一个缓存空间
        ehCacheService.clear("frameworkCache");
        System.out.println("=======================================");
        printCacheInfo();
        System.out.println("=======================================");

        // 删除所有缓存
        ehCacheService.clearAll();
        System.out.println("=======================================");
        printCacheInfo();
        System.out.println("=======================================");

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
