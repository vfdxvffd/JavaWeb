package org.student.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletRequestAttributeListener, HttpSessionAttributeListener, ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		
		String attrName = scab.getName();			//目前正在操作的数姓名
		String attrValue = (String) scab.getServletContext().getAttribute(attrName);
		System.out.println("ServletContext【增加】属性：属性名："+attrName+"，属性值："+attrValue);
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		
		System.out.println("ServletContext【删除】属性："+scab.getName());
	}
	
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		
		/**
		 * application.setAttribute("name","zs");		新增
		 * application.setAttribute("name","ls");		替换
		 */
		String attrName = scab.getName();
		String attrValue = (String)scab.getServletContext().getAttribute(attrName);
		System.out.println("ServletContext【替换】属性：属性名："+attrName+"，属性值："+attrValue);
		System.out.println("这是getValue的结果"+(String)scab.getValue());
	}
	
	
	
	
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		String attrName = se.getName();			//目前正在操作的数姓名
		String attrValue = (String)se.getSession().getAttribute(attrName);
		System.out.println("Session【增加】属性：属性名："+attrName+"，属性值："+attrValue);
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("Session【删除】属性："+se.getName());
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		String attrName = se.getName();
		String attrValue = (String)se.getSession().getAttribute(attrName);
		System.out.println("Session【替换】属性：属性名："+attrName+"，属性值："+attrValue);
		System.out.println("这是getValue的结果"+(String)se.getValue());
	}
	
	
	
	
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		String attrName = srae.getName();			//目前正在操作的数姓名
		String attrValue = (String)srae.getServletRequest().getAttribute(attrName);
		System.out.println("Request【增加】属性：属性名："+attrName+"，属性值："+attrValue);
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("Request【删除】属性："+srae.getName());
	}
	
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		String attrName = srae.getName();
		String attrValue = (String)srae.getServletRequest().getAttribute(attrName);
		System.out.println("Request【替换】属性：属性名："+attrName+"，属性值："+attrValue);
		System.out.println("这是getValue的结果"+(String)srae.getValue());
	}
}





















