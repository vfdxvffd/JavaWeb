# JSTL

比EL更加强大

需要引入2个jar：jstl.jar、standard.jar

引入taglib指令

~~~jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		<!--prefix="c"表示前缀-->
~~~

## 核心标签库

* 通用标签库
* 条件标签库
* 迭代标签库

### 通用标签库

#### \<c : set\>（c是前缀）

1. 给某个作用域(四个范围对象)之中，给某个变量赋值

   ~~~jsp
   <c:set var="name" value="zhangsan" scope="request"/>		
   ~~~

2. 在某个作用域里(四个范围对象)，给某个对象的属性赋值(此种写法，不能指定scope属性)

   ~~~jsp
   <c:set target="${requestScope.student}" property="sname" value="zxs"/>		//普通对象赋值
   <c:set target="${requestScope.map}" property="CN" value="China"/>		//map对象赋值
   <!--注意：<c:set>可以给不存在的变量赋值，但是不能给未创建的对象，会先创建，再赋值 -->
   <c:set var="x" value="z" scope="request"/>
   ~~~

#### \<c:out\>

~~~jsp
传统的EL：${requestScope.student}<br/>
	c:out：<c:out value="${requestScope.student}"/><br/>
	c:out显示不存在的数据：<c:out value="${requestScope.stu}" default="zs-23"/><br/>	//value不存在则会显示默认值
	<a href="https://www.baidu.com">百度</a><br/>
	true:<c:out value='<a href="https://www.baidu.com">百度</a>' escapeXml="true"/><br/>
	false:<c:out value='<a href="https://www.baidu.com">百度</a>' escapeXml="false"/><br/>
~~~

### \<c:remove\>

~~~jsp
	<c:set var="a" value="b" scope="request" />
	显示：${a}<br/>
	<c:remove var="a" scope="request"/>
	显示：${a}<br/>
~~~

### 条件标签

if和多重if

~~~jsp
<!--  在使用test时，一定要注意不能有空格，否则布尔值加空格就变成字符串了  -->  

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
~~~

### 迭代标签

~~~jsp
<!--    [0,5]步进为1      -->
<c:forEach begin="0" end="5" step="1" varStatus="status">
		${status.index }
		test<br/>
	</c:forEach>
	
	<!--  for(str:names){syso(str)}  -->
	<c:forEach var="str" items="${requestScope.names}">
		${str}<br/>
	</c:forEach>

	<!--   for(stu:students){syso(stu)}  -->
	<c:forEach var="stu" items="${requestScope.students}">
		${stu}<br/>
	</c:forEach>
~~~

