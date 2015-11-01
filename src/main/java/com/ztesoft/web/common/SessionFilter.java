/**
 * 
 */
package com.ztesoft.web.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.ztesoft.framework.log.ZTEsoftLogManager;
import com.ztesoft.framework.util.Utils;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2014年12月29日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.common <br>
 */

public class SessionFilter implements Filter {
    private static final ZTEsoftLogManager logger = ZTEsoftLogManager
            .getLogger(SessionFilter.class);

    /** 要检查的 session 的名称 */
    private String sessionKey;

    /** 检查不通过时，转发的URL */
    private String redirectUrl;

    /**
     * 不需要过滤的url地址,以逗号分隔
     */
    private String excludeUrl;

    /**
     * 不需要过滤的url地址，分隔成数组
     */
    private String[] excludeUrlAry;

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sessionKey = filterConfig.getInitParameter("sessionKey");
        redirectUrl = filterConfig.getInitParameter("redirectUrl");
        excludeUrl = filterConfig.getInitParameter("excludeUrl");

        if (Utils.isEmpty(excludeUrl)) {
            excludeUrlAry = new String[0];
        }
        else {
            excludeUrlAry = excludeUrl.split(",");
        }
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        // 如果 sessionKey 为空，则直接放行
        if (StringUtils.isEmpty(sessionKey)) {
            chain.doFilter(req, res);
            return;
        }

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String servletPath = request.getServletPath();
        String contextPath = request.getContextPath();
        // 如果请求的路径与redirectUrl相同，或请求的路径是排除的URL时，则直接放行
        boolean isExclude = false;
        for (String ex : excludeUrlAry) {
            if (ex.equals(servletPath)) {
                isExclude = true;
                break;
            }
        }

        // 不需要过滤的
        if (isExclude) {
            chain.doFilter(req, res);
            return;
        }

        Object sessionObj = request.getSession().getAttribute(sessionKey);

        // 如果Session为空，则跳转到指定页面
        if (sessionObj == null) {
            String redirect = contextPath + redirectUrl;
            // response.sendRedirect(redirect);
            if (servletPath.endsWith(".do")) {
                //兼容前台Ajax的，前台要自行判断SESSION_TIMEOUT_ERROR
                response.setHeader("sessionstatus", "timeout");
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().print(
                        "<script>window.top.location.href='" + redirect
                                + "';</script>SESSION_TIMEOUT_ERROR");

                response.getWriter().flush();
            }
            else {
                //jsp请求等直接跳转
                response.sendRedirect(redirect);
            }

            return;
        }
        else {
            chain.doFilter(req, res);
        }

    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
