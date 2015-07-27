package com.ztesoft.web.demo.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ztesoft.core.cache.EhCacheService;
import com.ztesoft.core.common.Page;
import com.ztesoft.core.spring.cache.HashCodeKeyGenerator;
import com.ztesoft.core.spring.cache.StringKeyGenerator;
import com.ztesoft.core.spring.context.SpringApplicationContextHolder;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.demo.db.po.EhcachePO;
import com.ztesoft.web.demo.service.IEhcacheService;

/**
 * <Description>ehcache管理 <br>
 * 
 * @author codeCreater <br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月11日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.controller <br>
 */

@Controller
@RequestMapping("//demo/ehcache")
public class EhcacheController {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(EhcacheController.class);

    @Autowired
    private IEhcacheService ehcacheService;

    @RequestMapping("index")
    public String index(Model model) {
        // ///////
        // TODO 根据业务场景，进行条件分支跳转、设置页面默认值等

        // ///////

        return "/demo/jsp/ehcache";
    }

    @RequestMapping("queryRecordByPage")
    @ResponseBody
    public Page<EhcachePO> queryRecordByPage(EhcachePO record,
            Page<EhcachePO> resultPage) throws BaseAppException {
        resultPage = ehcacheService.selectByArgAndPage(record, resultPage);
        return resultPage;
    }

    @RequestMapping("add")
    @ResponseBody
    public EhcachePO add(EhcachePO record) throws BaseAppException {
        logger.debug("add record begin...record=[{0}]", record);
        ehcacheService.add(record);
        return record;
    }

    @RequestMapping("update")
    @ResponseBody
    public EhcachePO update(EhcachePO record) throws BaseAppException {
        logger.debug("modify record begin...record=[{0}]", record);
        ehcacheService.update(record);
        return record;
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(EhcachePO record) throws BaseAppException {
        logger.debug("delete record begin...record=[{0}]", record);
        return ehcacheService.delete(record);
    }

    @RequestMapping("qryRecordInfo")
    @ResponseBody
    public EhcachePO qryRecordInfo(@RequestParam(value = "empId",
            required = true) Integer empId) throws BaseAppException {
        EhcachePO record = ehcacheService.selectByPrimaryKey(empId);

        Collection<String> cacheNames = ehCacheService.getCacheNames();
        Iterator<String> it = cacheNames.iterator();
        System.out.println("=======================================");
        while (it.hasNext()) {
            String cacheName = it.next();
            System.out.println(cacheName + ":"
                    + ehCacheService.getSize(cacheName));
        }
        System.out.println("=======================================");

        // System.out.println("defaultCache:"
        // + ehCacheService.getSize("defaultCache"));

        // System.out
        // .println("com.ztesoft.web.demo.db.dao.mapper.IEhcacheMapper:"
        // + ehCacheService
        // .getSize("com.ztesoft.web.demo.db.dao.mapper.IEhcacheMapper"));

        System.out.println("=======================================");
        List<EhcachePO> selectByArgList = ehcacheService.selectByArg(record);
        System.out.println("selectByArgList.size=" + selectByArgList.size());

        System.out.println("=======================================");

        List<Integer> countList = ehcacheService.countByArg(record);
        System.out.println("countList.size=" + countList.size());

        System.out.println("=======================================");

        record.setEmpBirthday(new Date());
        EhcachePO queryRecord = new EhcachePO();
        queryRecord.setEmpName("a");
        ehcacheService.updateByArgSelective(record, queryRecord);
        System.out.println("=======================================");

        return record;
    }

    @Resource(name = "frameworkEhCacheService")
    private EhCacheService ehCacheService;

    @Resource(name = "stringKeyGenerator")
    private StringKeyGenerator stringKeyGenerator;

    @Resource(name = "hashCodeKeyGenerator")
    private HashCodeKeyGenerator hashCodeKeyGenerator;

    @RequestMapping("putToCache")
    public void putToCache() {
        Collection<String> cacheNames = ehCacheService.getCacheNames();
        Iterator<String> it = cacheNames.iterator();
        System.out.println("=======================================");
        while (it.hasNext()) {
            String cacheName = it.next();
            System.out.println(cacheName + ":"
                    + ehCacheService.getSize(cacheName));
        }
        System.out.println("=======================================");

        // 主键，模拟
        long pk = 1000L;

        String strKey = (String) stringKeyGenerator.generate(this, null, pk);
        ehCacheService
                .put("frameworkCache", strKey, System.currentTimeMillis());

        System.out.println("String Key:" + strKey + " Value:"
                + ehCacheService.get("frameworkCache", strKey));

        int hashCodeKey = (Integer) hashCodeKeyGenerator.generate(this, null,
                pk);
        ehCacheService.put("frameworkCache", hashCodeKey,
                System.currentTimeMillis());

        System.out.println("HashCode Key:" + hashCodeKey + " Value:"
                + ehCacheService.get("frameworkCache", hashCodeKey));

        cacheNames = ehCacheService.getCacheNames();
        Iterator<String> it2 = cacheNames.iterator();
        System.out.println("=======================================");
        while (it2.hasNext()) {
            String cacheName = it2.next();
            System.out.println(cacheName + ":"
                    + ehCacheService.getSize(cacheName));
        }
        System.out.println("=======================================");
    }

}
