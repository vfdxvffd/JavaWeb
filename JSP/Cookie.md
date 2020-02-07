# Cookie
存在于客户端，不是内置对象。Cookie是由服务端生成的，再发送给客户端保存。
相当于本地缓存的作用：客户端(第一次联网看完后，在本地缓存电影.mp4)——>服务端（电影.mp4）
* 不是内置对象，要使用必须new
* 但是，服务端会自动生成一个name=JSESSIONID的cookie，并返回给客户端


~~~java
Cookie：key->value
javax.servlet.http.Cookie
public Cookie(String name, String value)//构造函数
String getName();//获取name，也就是key
String getValue();//获取value
void setMaxAge(int expiry);//设置最大有效期（秒）

//服务端发送给客户端：
response.addCookie(Cookie cookie)
页面跳转（转发、重定向）
//客户端获取cookie：
request.getCookies();
~~~
a.服务端增加cookie：response对象；客户端获取对象：request对象
b.不能直接获取某一个单独对象，只能一次性将全部的cookie拿到

## 示例：记住密码
用本机既模拟客户端又模拟服务端
~~~js
//login
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
~~~
~~~js
//check.jsp
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
~~~