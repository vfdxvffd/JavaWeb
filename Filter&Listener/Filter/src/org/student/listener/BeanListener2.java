package org.student.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

//监听BeanListener2对象的钝化和活化
public class BeanListener2 implements HttpSessionActivationListener, Serializable {
	//准备被钝化、活化的数据
	private int num;
	private String user;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//监听时刻：即将钝化之前
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("即将钝化之前：BeanListener2对象将会随着session的钝化而钝化");
	}
	
	//监听时刻：刚刚已经活化之后
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("活化之后：BeanListener2对象将会随着session的活化而活化");
	}
}
