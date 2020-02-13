# EL

> Expression Language	表达式语言，可以替代JSP中的Java代码

传统的在jsp中嵌套java的弊端：类型转换、需要处理null、代码参杂

### 示例

~~~jsp
<!-- 属性是private还是public无所谓-->
${requestScope.student }<br/>
${requestScope.student.getSid() }<br/>
${requestScope.student.sname }<br/>
${requestScope.student.Address.homeAddress }<br/>	
${requestScope.student.getAddress().schoolAddress }<br/>

域对象.域对象属性.属性.属性.级联属性
~~~

## 操作符

点操作符：.		--使用方便
中括号操作符：[""]	--功能强大：  
	 	1、可以包含特殊字符（.   、-）、	<!-- ${requestScope.my-name }会报错 -->
	 	2、获取变量值	例如存在变量name，则可以${requestScope[name]},加引号是常量，不加引号是变量
	 	3、可以获取数组元素${requestScope.hobbies[0]}，hobbies是一个数组，可以用下标获取值
可以操作map
	Map<String, Object> map = new HashMap<>();
	map.put("CN","中国");
	map.put("US","美国");
	request.setAttribute("map",map);
	request.getRequestDisk("e.jsp").forward(request, response);

	${requestScope.map.CN}<br/>				//中国
	${requestScope.map["US"]}<br/>			//美国
empty：判断是否为空，或为null，空则为true，否则为false

## EL的隐式对象(不需要new就能使用的对象，自带的对象)

1. 作用域访问对象：（EL域对象）pageScope		requestScope		sessionScope		applicationScope

   ​		如果不指定域对象，则默认会根据从大到小的顺序依次取值

2. 参数访问对象：获取表单数据(超链接、地址栏a.jsp?a=b&c=d)（request.getParameter()、request.getParameterValues()）

   ​																			${param}									${paramValues}

3. JSP隐式对象：pageContext

   ​			在jsp中可以通过pageContext获取其他jsp隐式对象，例如：${pageContext.request}

   ​			${pageContext.getSession()}     ——>     ${pageContext.session}

   ​			还可以级联获取