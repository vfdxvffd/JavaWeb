<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提示</title>
</head>
<body>
		<script>
			alert("账号或密码错误，请重试！")
		</script>
		<form action="loginServlet" method="post">
			账号：<input type="text" name="uname"><br/>
			密码：<input type="password" name="upwd"><br/>
			<input type="submit" value="登陆">
		</form>
</body>
</html>