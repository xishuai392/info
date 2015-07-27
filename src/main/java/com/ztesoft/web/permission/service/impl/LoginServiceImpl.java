/**
 * 
 */
package com.ztesoft.web.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.exception.ExceptionHandler;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.AssertUtils;
import com.ztesoft.framework.util.MD5Utils;
import com.ztesoft.web.permission.db.dao.AuditUserDao;
import com.ztesoft.web.permission.db.po.AuditUserPO;
import com.ztesoft.web.permission.service.ILoginService;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年7月28日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.service.impl <br>
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {

    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(LoginServiceImpl.class);

    @Autowired
    private AuditUserDao auditUserDao;

    @Override
    public AuditUserPO selectUserInfo(String userCode, String password)
            throws BaseAppException {
        AssertUtils.isNotEmpty(userCode, "用户名不能为空！");
        AssertUtils.isNotEmpty(password, "密码不能为空！");

        // md5密码转换
        // String pasEncode = String.valueOf(CipherDigest.instance("md5Digest")
        // .encrypt(password.getBytes()));

        String pasEncode = MD5Utils.MD5(password).toLowerCase();
        logger.info("This pasEncode=" + pasEncode);
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("userCode", userCode);
        queryMap.put("password", pasEncode);

        List<AuditUserPO> resultList = auditUserDao.selectByMap(queryMap);
        if (null == resultList || resultList.size() == 0)
            throw ExceptionHandler.publish("APP-10-0001", "用户名或密码错误");
        return resultList.get(0);
    }

}
