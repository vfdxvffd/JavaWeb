<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%!
			String uname;
			String upwd;
			boolean flag = false;	//用它来检验cookie是否失效
		%>
		<%
			Cookie[] cookies = request.getCookies();
			if(cookies.length != 0){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("n")){
						uname = cookie.getValue();
						flag = true;
					}
					if(cookie.getName().equals("p")){
						upwd = cookie.getValue();
						flag = true;
					}
				}
			}
			if(flag){
				out.print("未失效！");
			}else{
				out.print("失效！");
			}
		%>	
		<form action="check.jsp" method="post">
			账号：<input type="text" name="uname" value="<%=(uname==null?"":uname)%>"><br/>
			密码：<input type="password" name="upwd" value="<%=(upwd==null?"":upwd)%>"><br/>
			<input type="submit" name="提交">

		</form>
</body>
</html>