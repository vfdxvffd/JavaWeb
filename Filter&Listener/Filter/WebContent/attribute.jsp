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
		//ServletContext：application
		application.setAttribute("name", "zs");		//增加application属性
		application.setAttribute("name", "ls");		//替换
		application.removeAttribute("name");		//删除
		
		
		session.setAttribute("user", "user1");
		session.setAttribute("user", "user2");
		session.removeAttribute("user");
		
		request.setAttribute("school", "bd");
		request.setAttribute("school", "qh");
		request.removeAttribute("school");
	%>
</body>
</html>