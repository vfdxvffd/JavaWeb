<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<c:if test="${10>3}" var="result" scope="request">
		真
		${requestScope.result}
	</c:if>
	
	
	<c:set var="role" value="学生" scope="request"></c:set>
	<!-- 比较像switch，多重if -->	
	<c:choose >
		<c:when test="${requestScope.role == '老师'}">老师的代码</c:when>
		<c:when test="${requestScope.role eq '学生'}">学生的代码</c:when>
		<c:otherwise>管理员代码</c:otherwise>
	</c:choose>
	
	=====================循环========================<br/>
	<c:forEach begin="0" end="5" step="1" varStatus="status">
		${status.index }
		test<br/>
	</c:forEach>
	
	<c:forEach var="str" items="${requestScope.names}">
		${str}<br/>

	</c:forEach>

	<c:forEach var="stu" items="${requestScope.students}">
		${stu}<br/>
	</c:forEach>
	
	
	
</body>
</html>