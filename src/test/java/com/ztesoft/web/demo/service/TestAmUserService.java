/**
 * 
 */
package com.ztesoft.web.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.ztesoft.core.common.Page;
import com.ztesoft.core.convert.IArgConversionService;
import com.ztesoft.core.idproduce.ISequenceGenerator;
import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.demo.customdb.dao.AmUserRoleCustomDao;
import com.ztesoft.web.demo.customdb.dao.dto.AmUserRoleDto;
import com.ztesoft.web.demo.db.arg.AmUserArg;
import com.ztesoft.web.demo.db.arg.AmUserArg.AmUserCriteria;
import com.ztesoft.web.demo.db.dao.AmUserDao;
import com.ztesoft.web.demo.db.po.AmUserPO;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年11月18日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.service <br>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:/config/spring-content.xml", "/config/spring-servlet.xml"
})
public class TestAmUserService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(TestAmUserService.class);

    // 以下纯属测试用的
    @Autowired
    private AmUserRoleCustomDao amUserRoleCustomDao;

    @Autowired
    private AmUserDao amUserDao;

    @Autowired
    private IArgConversionService argConversionService;

    /**
     * 主键生成器
     */
    @Resource(name = "sequenceFuncGenerator")
    private ISequenceGenerator sequenceGenerator;

    @Autowired
    private WebApplicationContext wac;

    private AmUserArg arg;

    /**
     * 纯属测试其他DAO的可用性
     */

    public void testCustomDao() {
        List<AmUserRoleDto> l1 = amUserRoleCustomDao.selectListByUserId(1);
        logger.info("查询结果，L_1长度为：" + l1.size());

        List<AmUserRoleDto> l2 = amUserRoleCustomDao.qryAmUserListByRoleId(1);
        logger.info("查询结果，L_2长度为：" + l2.size());

        List<AmUserPO> l3 = amUserRoleCustomDao.qryAmUserListExcludeRoleId(1);
        logger.info("查询结果，L_3长度为：" + l3.size());

        List<Integer> userRoleIdList = new ArrayList<Integer>();
        userRoleIdList.add(1);
        userRoleIdList.add(2);
        userRoleIdList.add(3);
        List<AmUserRoleDto> l4 = amUserRoleCustomDao
                .qryAmUserListByUserRoleIdList(userRoleIdList);
        logger.info("查询结果，L_4长度为：" + l4.size());

        // 传统分页查询
        AmUserRoleDto dto = new AmUserRoleDto();
        dto.setRoleId(1);
        Page<AmUserRoleDto> resultPage = new Page<AmUserRoleDto>();
        List<AmUserRoleDto> resultList = amUserRoleCustomDao.selectPageList(
                dto, resultPage);
        resultPage.setResultList(resultList);
        logger.info("查询结果，分页总条数为：" + resultPage.getTotalRecords());
        logger.info("查询结果，分页数为：" + resultPage.getTotalPages());

        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("roleId", 1);

        Page<Map> resultMapPage = new Page<Map>();
        List<Map> resultMap = amUserRoleCustomDao.selectPageListByMap(
                paramsMap, resultMapPage);
        resultMapPage.setResultList(resultMap);
        logger.info("查询Page<Map>结果，分页总条数为：" + resultMapPage.getTotalRecords());
        logger.info("查询Page<Map>结果，分页数为：" + resultMapPage.getTotalPages());

        List<Map> l5 = amUserRoleCustomDao.selectListByMap(paramsMap);
        logger.info("查询结果，L_5长度为：" + l5.size());
    }

    @Before
    public void bulidArg() throws BaseAppException {
        if (null == arg) {
            // String jsonStr =
            // "[{\"paramName\":\"userName\",\"operation\":\"Like\",\"paramValue\":[\"1\"]},{\"paramName\":\"state\",\"operation\":\"EqualTo\",\"paramValue\":[\"A\"]},{\"paramName\":\"userId\",\"operation\":\"In\",\"paramValue\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\",\"10\",\"11\",\"12\",\"13\",\"14\",\"15\"]}]";
            String jsonStr = "[{\"paramName\":\"userName\",\"operation\":\"Like\",\"paramValue\":[\"1\"]},{\"paramName\":\"state\",\"operation\":\"EqualTo\",\"paramValue\":[\"A\"]},{\"paramName\":\"age\",\"operation\":\"Between\",\"paramValue\":[\"10\",\"51\"]},{\"paramName\":\"userId\",\"operation\":\"In\",\"paramValue\":[\"1\",\"2\",\"3\",\"4\",\"5\",\"6\",\"7\",\"8\",\"9\",\"10\",\"11\",\"12\",\"13\",\"14\",\"15\"]}]";
            AmUserPO record = new AmUserPO();
            record.setQueryConditions(jsonStr);
            arg = argConversionService.invokeArg(AmUserArg.class, record);
        }

    }

    // @Test
    public void countByArg() throws BaseAppException {
        List<Integer> result = amUserDao.countByArg(arg);
        logger.info("查询结果，长度为：" + result.size() + ",值：" + result.get(0));
    }

    // @Test
    public void selectByArg() throws BaseAppException {
        List<AmUserPO> result = amUserDao.selectByArg(arg);
        Iterator<AmUserPO> it = result.iterator();
        logger.info("查询结果，长度为：" + result.size());
        while (it.hasNext()) {
            logger.info(it.next().toString());
        }
    }

    // @Test
    public void insert() throws BaseAppException {
        AmUserPO record = new AmUserPO();
        record.setUserId(sequenceGenerator.sequenceIntValue("AM_USER",
                "USER_ID"));
        record.setUserName("用户们么么么么");
        record.setCreatedDate(new Date());
        record.setAge(20);
        record.setEmail("dddddd");
        record.setState("A");

        int i = amUserDao.insert(record);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void updateByArgSelective() throws BaseAppException {
        AmUserPO record = new AmUserPO();
        record.setAge(20);
        record.setEmail("dddddd");
        record.setState("A");

        AmUserArg arg = new AmUserArg();
        AmUserCriteria cri = arg.createCriteria();
        cri.andUserNameLike("1");
        cri.andStateEqualTo("X");

        int i = amUserDao.updateByArgSelective(record, arg);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void updateByArg() throws BaseAppException {
        AmUserPO record = new AmUserPO();
        record.setNickName("第三方的司法所");
        record.setAge(20);
        record.setEmail("dddddd");
        record.setState("A");

        AmUserArg arg = new AmUserArg();
        AmUserCriteria cri = arg.createCriteria();
        cri.andUserNameLike("测试");
        cri.andStateEqualTo("X");

        int i = amUserDao.updateByArg(record, arg);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void selectByArgAndPage() throws BaseAppException {
        Page<AmUserPO> resultPage = new Page<AmUserPO>();
        resultPage = amUserDao.selectByArgAndPage(arg, resultPage);
        logger.info("查询结果，长度为：" + resultPage.getTotalRecords());
    }

    // @Test
    public void deleteByArg() throws BaseAppException {
        AmUserArg arg = new AmUserArg();
        AmUserCriteria cri = arg.createCriteria();
        cri.andUserIdEqualTo(20);
        int i = amUserDao.deleteByArg(arg);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void insertSelective() throws BaseAppException {
        AmUserPO record = new AmUserPO();
        record.setUserId(sequenceGenerator.sequenceIntValue("AM_USER",
                "USER_ID"));
        record.setUserName("用户们么么么么111");
        record.setCreatedDate(new Date());
        record.setAge(20);
        record.setEmail("dddddd");
        record.setState("A");
        int i = amUserDao.insertSelective(record);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void insertBatch() throws BaseAppException {
        List<AmUserPO> records = new ArrayList<AmUserPO>();
        for (int i = 0; i < 10; i++) {
            AmUserPO record = new AmUserPO();
            record.setUserId(sequenceGenerator.sequenceIntValue("AM_USER",
                    "USER_ID"));
            record.setUserName("测试" + i);
            record.setCreatedDate(new Date());
            record.setAge(20 + i);
            record.setEmail("dddddd" + i);
            record.setState("A");
            records.add(record);
        }
        int i = amUserDao.insertBatch(records);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void deleteByPrimaryKey() throws BaseAppException {
        Integer key = 20;
        int i = amUserDao.deleteByPrimaryKey(key);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void selectByPrimaryKey() throws BaseAppException {
        Integer key = 1;
        AmUserPO record = amUserDao.selectByPrimaryKey(key);
        logger.info("执行结果，为：" + record);
    }

    // @Test
    public void updateByPrimaryKeySelective() throws BaseAppException {
        AmUserPO record = new AmUserPO();
        record.setUserId(21);
        record.setUserName("神烦大叔法萨芬");
        record.setCreatedDate(new Date());
        record.setAge(20);
        record.setEmail("dddddd");
        record.setState("A");

        int i = amUserDao.updateByPrimaryKeySelective(record);
        logger.info("执行结果，影响值为：" + i);
    }

    // @Test
    public void updateByPrimaryKey() throws BaseAppException {
        AmUserPO record = new AmUserPO();
        record.setUserId(21);
        record.setUserName("神烦大叔法萨芬");
        record.setCreatedDate(new Date());
        record.setAge(20);
        record.setEmail("dddddd");
        record.setState("A");
        int i = amUserDao.updateByPrimaryKey(record);
        logger.info("执行结果，影响值为：" + i);
    }

    @Test
    public void selectByMap() throws BaseAppException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("state", "A");
        params.put("age", 20);
        List<AmUserPO> result = amUserDao.selectByMap(params);
        Iterator<AmUserPO> it = result.iterator();
        logger.info("查询结果，长度为：" + result.size());
        while (it.hasNext()) {
            logger.info(it.next().toString());
        }
    }
}
