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

	<%
		BeanListener2 bean = new BeanListener2();
		bean.setNum(1);
		bean.setUser("zs");
		
		session.setAttribute("bean", bean);
	%>

</body>
</html>