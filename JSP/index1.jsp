<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- html注释 -->
		<%-- jsp注释 --%>
		hello index1   你好！
		<br/>
		<%
		//第一种脚本，在这里面定义局部变量，Java语句
			/* int a = 3;
			double b = Math.pow(a, 3);
			System.out.print(b); */
			init();
		%>
		
		<%!
			//第二种脚本，在这里面定义方法、全局变量
			public String name;		//全局变量
			public void init(){
				name = "张三"+new Date();
			}
		%>
		
		<%="name="+name
			//第三种脚本，用于输出语句
		%>
</body>
</html>