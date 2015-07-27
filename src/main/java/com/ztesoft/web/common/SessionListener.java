package com.ztesoft.web.common;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
/* Session创建事件 */
public void sessionCreated(HttpSessionEvent event) {
	System.out.println("========session create==========");
	System.out.println(event.getSession().getId());
}
/* Session失效事件 */
public void sessionDestroyed(HttpSessionEvent event) {
	System.out.println("========session destory==========");
	System.out.println(event.getSession().getId());


}
}