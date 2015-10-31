/**
 * 
 */
package com.ztesoft.web.permission.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ztesoft.framework.exception.BaseAppException;
import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.web.domain.IConstants;
import com.ztesoft.web.permission.db.po.AuditUserPO;
import com.ztesoft.web.permission.service.ILoginService;

/**
 * <Description>登录 <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年7月28日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.permission.controller <br>
 */
@Controller
public class LoginController implements IConstants {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(LoginController.class);

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "login/doLogin", method = RequestMethod.POST)
    public ModelAndView doLogin(HttpServletRequest request,
            @RequestParam("userCode") String userCode,
            @RequestParam("password") String password) {

        try {
            AuditUserPO userInfo = loginService.selectUserInfo(userCode,
                    password);
            HttpSession session = request.getSession(true);
            logger.info("用户登录userInfo:=" + userInfo);
            session.setAttribute(SESSIONUSER, userInfo);
            session.setAttribute(SESSIONUSERNAME, userInfo.getUserName());
            session.setAttribute(SESSIONUSERCODE, userInfo.getUserCode());
        }
        catch (Exception e) {
            // 1.拓展exception在此
            logger.error("登录异常--", e);
            ModelAndView view = new ModelAndView("login");
            view.addObject("error", "登录异常！" + e.getMessage());
            return view;
        }
        ModelAndView view = new ModelAndView("redirect:/index.do");
        return view;
    }

    /**
     * 跳转到登录界面
     * 
     * @return
     */
    @RequestMapping(value = "login/login")
    public ModelAndView login() {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = "login/loginOut", method = {
            RequestMethod.POST, RequestMethod.GET
    })
    @ResponseBody
    public Map<String, Object> loginOut(HttpServletRequest request, Model model)
            throws BaseAppException {
        HttpSession session = request.getSession(true);
        logger.info("用户退出:userName=" + session.getAttribute(SESSIONUSERNAME)
                + ",userCode=" + session.getAttribute(SESSIONUSERCODE));
        // session.removeAttribute(SESSIONUSER);
        // session.removeAttribute(SESSIONUSERNAME);
        // session.removeAttribute(SESSIONUSERCODE);
        session.invalidate();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        return result;
    }
}
