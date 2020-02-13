package org.student.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//要想将一个普通类变成一个特定功能的类（过滤器、拦截其），要么继承一个类，要么实现一个接口，要么增加一个注解
public class MyFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("拦截请求");
		
		//放行
		chain.doFilter(request, response);
		
		System.out.println("拦截响应");
	}
	
	
}
