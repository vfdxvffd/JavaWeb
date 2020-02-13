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
	
	========================给变量赋值===========================<br/>
	<%--
		request.setAttribute("name","zhangsan");
	--%>
	<c:set var="name" value="zhangsan" scope="request"/>		
	${requestScope.name}<br/>
	
	
	======================给普通对象的属性赋值======================<br/>
	${requestScope.student.sname }<br/>
	<c:set target="${requestScope.student}" property="sname" value="zxs"/>
	${requestScope.student.sname }<br/>
	
	========================给map对象赋值=========================<br/>
	${requestScope.map.CN}<br/>
	<c:set target="${requestScope.map}" property="CN" value="China"/>
	${requestScope.map.CN}<br/>
	
	======================给不存在的变量x赋值======================<br/>
	<c:set var="x" value="z" scope="request"/>
	${requestScope.x}<br/>

	==========================c:out=============================<br/>
	传统的EL：${requestScope.student}<br/>
	c:out：<c:out value="${requestScope.student}"/><br/>
	c:out显示不存在的数据：<c:out value="${requestScope.stu}" default="zs-23"/><br/>
	<a href="https://www.baidu.com">百度</a><br/>
	true:<c:out value='<a href="https://www.baidu.com">百度</a>' escapeXml="true"/><br/>
	false:<c:out value='<a href="https://www.baidu.com">百度</a>' escapeXml="false"/><br/>

	========================c:remove============================<br/>
	<c:set var="a" value="b" scope="request" />
	显示：${a}<br/>
	<c:remove var="a" scope="request"/>
	显示：${a}<br/>

</body>
</html>





























