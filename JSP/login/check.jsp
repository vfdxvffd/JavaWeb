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
			if(name.equals("zhangsan") && pwd.equals("123")){
				 //response.sendRedirect("success.jsp");//页面跳转：重定向，导致数据丢失
			     //页面跳转：请求转发，可以获取到数据，并且地址栏没有改变（任然保留转发时的页面）
			     request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				out.print(name+"\n"+pwd);
				out.write("登陆失败！");
			}
		%>
</body>
</html>