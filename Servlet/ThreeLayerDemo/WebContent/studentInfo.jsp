<%@page import="org.student.entity.Student"%>
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
			Student student = (Student)request.getAttribute("stuInfo");
		%>
		
		<!-- 通过一个表单展示此人信息，便于直接修改信息 -->
		<form action="UpdateStudentServlet">
			
				学号：<input type="text" name="sid" value="<%=student.getId()%>" readonly="readonly"/><br/>
				姓名：<input type="text" name="sname" value="<%=student.getName()%>"/><br/>
				年龄：<input type="text" name="sage" value="<%=student.getAge()%>"/><br/>
				地址：<input type="text" name="saddress" value="<%=student.getAddress()%>"/><br/>
				<input type="submit" value="修改"/>
				<a href="QueryAllStudentsServlet">返回</a>
				
			
		</form>
</body>
</html>