<%@page import="org.student.listener.BeanListener2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	从硬盘中读取session域中的对象:<br/>
	num:
	<%
		BeanListener2 bean = (BeanListener2)session.getAttribute("bean");
		out.print(bean.getNum());
	%>
	<br/>
	user:
	<%=bean.getUser() %>
</body>
</html>