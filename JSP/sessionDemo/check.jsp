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
				 //成功！只有成功session中才会存在uname和upwd
				 session.setAttribute("uname", name);
				 session.setAttribute("upwd", pwd);
				// session.setMaxInactiveInterval(10);
				 System.out.println(session.getId());	//在控制台查看sessionid
				 
				 Cookie cookie = new Cookie("a","1");
				 response.addCookie(cookie);
				 
				 request.getRequestDispatcher("Welcome.jsp").forward(request, response);
				 
			}else{
				//登陆失败
				response.sendRedirect("login.jsp");
			}
		%>
</body>
</html>