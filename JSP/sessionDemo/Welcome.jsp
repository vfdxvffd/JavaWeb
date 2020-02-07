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
			String name = (String)session.getAttribute("uname");
			String pwd = (String)session.getAttribute("upwd");
			
			if(name == null){//用户没有登陆，直接访问的Welcome，重新登陆
				response.sendRedirect("login.jsp");
			}
			out.print("欢迎:<br/>"+name+"<br/>"+pwd);
			
			//System.out.println();
		%>
		<a href="invalidate.jsp">注销</a>
		
</body>
</html>