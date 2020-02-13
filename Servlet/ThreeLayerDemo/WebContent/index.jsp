<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>

		<%
			String error = (String)request.getAttribute("error");
			if(error != null){	//如果是第一次进入这个页面，则为null，无需处理
				if(error.endsWith("Error")){
					out.print("增加失败！");
				}else if(error.endsWith("Success")){
					out.print("增加成功！");
				}
			}
		%>
	
		<table border="1px">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
			<%
				List<Student> students = (List<Student>)request.getAttribute("students");
				for(Student student:students){
			%>
			<tr>
				<td><a href="QueryStudentByIdServlet?sid=<%=student.getId()%>"><%=student.getId()%></a></td>
				<td><%=student.getName()%></td>
				<td><%=student.getAge()%></td>
				<td><%=student.getAddress()%></td>
				<td><a href="DeleteStudentServlet?sid=<%=student.getId()%>">删除</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="add.jsp">新增学生</a>
</body>
</html>