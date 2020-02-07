<%@page import="com.sun.prism.paint.Color"%>
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
			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("uname");
			String pwd = request.getParameter("upwd");
			
			//将用户名和密码加入到Cookie中
			Cookie namecookie = new Cookie("n",name);	//不要中文
			Cookie pwdCookie = new Cookie("p",pwd);
			
			//设置5秒后cookie失效
			namecookie.setMaxAge(5);
			pwdCookie.setMaxAge(5);
			
			response.addCookie(namecookie);
			response.addCookie(pwdCookie);
						
			//response.sendRedirect("A.jsp");
		%>
</body>
</html>