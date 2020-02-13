package org.student.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//实现监听器接口ServletRequestListener, HttpSessionListener, ServletContextListener
public class AllListener implements ServletRequestListener, HttpSessionListener, ServletContextListener{

	//request
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("监听request，创建"+sre);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("监听request，销毁"+sre);
	}
	
	//session
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("监听session，创建"+se);
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("监听session，销毁"+se);
	}
	
	//context
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("监听context，创建"+sce);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("监听context，销毁"+sce);
	}
}
