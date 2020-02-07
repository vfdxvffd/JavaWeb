# response:响应对象
## 提供方法：<br/>
~~~java
void addCookie(Cookie cookie); //服务端向客户端增加Cookie对象
void sendRedirect(String location) throw IOException; //页面跳转的一种方式（重定向）
void setContentType(String type);//设置服务端响应的编码（设置服务端的contentType类型）
~~~

## 示例：登录
用户登录之后提示欢迎信息<br/>
login.jsp  --->   check.jsp  --->   success.jsp
~~~js
//login.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="check.jsp" method="post">
			账号：<input type="text" name="uname"><br/>
			密码：<input type="password" name="upwd"><br/>
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
~~~

~~~js
//success.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		登陆成功！<br/>
		欢迎:
		<%
			String name = request.getParameter("uname");
			out.print("<font color=\"red\">"+name);
		%>
</body>
</html>
~~~

## 请求转发和重定向的区别
|item|请求转发|重定向
|:-:|:-:|:-:|
|地址栏是否改变|不变(还停留在check.jsp)|改变(跳到success.jsp)|
|是否保留第一次请求时的数据|保留|不保留
|请求的次数|1|2|

用去银行办理业务为例做区别的解释：
转发：
&emsp;&emsp;张三（客户端）&emsp;&emsp;——>&emsp;&emsp;服务窗口A（服务端）&emsp;&emsp;——>&emsp;&emsp;服务窗口B
重定向：
&emsp;&emsp;张三（客户端）&emsp;&emsp;——>&emsp;&emsp;服务窗口A（服务端）&emsp;&emsp;——>&emsp;&emsp;去找B
&emsp;&emsp;张三（客户端）&emsp;&emsp;——>&emsp;&emsp;服务窗口B&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;——>&emsp;&emsp;结束