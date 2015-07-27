/**
 * 
 */
package com.ztesoft.web.demo.log;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <Description> <br>
 * 
 * @author pan.xiaobo<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2015年1月28日 <br>
 * @since V1.0<br>
 * @see com.ztesoft.web.demo.log <br>
 */

@Component
@Aspect
public class MyLog {
    @Autowired
    private HttpServletRequest request;

    // 在类里面写方法，方法名诗可以任意的。此处我用标准的before和after来表示
    @Before("execution(* com.ztesoft.web.demo.db.dao..*.*(..))")
    public void before(JoinPoint point) {
        System.out.println("before.point.getArgs():" + point.getArgs());
        System.out.println("before.point.getKind():" + point.getKind());
        System.out.println("before.point.getSignature():"
                + point.getSignature());
        System.out.println("before.point.getTarget():" + point.getTarget());
        System.out.println("before.point.getThis():" + point.getThis());
        System.out.println("before.request:" + request);

        System.out.println("before.被拦截方法调用之前调用此方法，输出此语句");
    }

    @After("execution(* com.ztesoft.web.demo.db.dao..*.*(..))")
    public void after(JoinPoint point) {
        System.out.println("after.point.getArgs():" + point.getArgs());
        System.out.println("after.point.getKind():" + point.getKind());
        System.out
                .println("after.point.getSignature():" + point.getSignature());
        System.out.println("after.point.getTarget():" + point.getTarget());
        System.out.println("after.point.getThis():" + point.getThis());

        System.out.println("after.request:" + request);
        System.out.println("after.point.toLongString:" + point.toLongString());
        System.out.println("after.被拦截方法调用之后调用此方法，输出此语句"
                + request.getRemoteHost() + "  " + request.getRemoteAddr()
                + "  " + request.getRemotePort());
    }
}
