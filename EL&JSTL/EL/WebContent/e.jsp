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
		/* Student student = (Student)request.getAttribute("student");
		
		out.print(student+"<br/>");
		out.print(student.getSid()+"<br/>");
		out.print(student.getSname()+"<br/>");
		out.print(student.getAddress()+"<br/>"); */
		
	%>
------------------点操作符----------------------------<br/>
	${requestScope.student }<br/>
	${requestScope.student.getSid() }<br/>
	${requestScope.student.sname }<br/>
	${requestScope.student.getAddress().homeAddress }<br/>	
	${requestScope.student.getAddress().schoolAddress }<br/>	

-----------------中括号操作符-------------------------<br/>
	${requestScope.student.address["schoolAddress"] }<br/>
	${requestScope.student["address"]["schoolAddress"] }<br/>


------------------特殊字符-----------------------------<br/>

	${requestScope["my-name"] }<br/>
	---------------------------------<br/>
	${requestScope.name }<br/>
	${requestScope["name"] }<br/>
	
----------------------数组---------------------------<br/>
	${requestScope.hobbies[0]}<br/>
	${requestScope.hobbies[1] }<br/>
	
----------------------map---------------------------<br/>
   	${requestScope.map["CN"] }<br/>
   	${requestScope.map.US }<br/>

----------------------empty--------------------------<br/>
	${empty requestScope.map["CN"]}<br/>
	
---------------------sessionScope--------------------<br/>
	${sessionScope.sessionKey }<br/>
	${sessionKey }<br/>
	
-----------------------参数对象-----------------------<br/>
	${param.uname}<br/>
	${paramValues.uhobbies[0]}<br/>
	${paramValues.uhobbies[1]}<br/>
	${paramValues.uhobbies[2]}<br/>
























</body>
</html>