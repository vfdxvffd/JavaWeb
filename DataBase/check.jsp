<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.lanqiao.dao.loginDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<%
			String name = request.getParameter("uname");
			String pwd = request.getParameter("upwd");
			loginDao dao = new loginDao();
			int result = dao.login(name, pwd);
			if(result == 1){
				out.print("登陆成功！");
			}else if(result == 0){
				out.print("用户名或密码有误！");
			}else{
				out.print("系统异常！");
			}
		%>
		
</body>
</html>