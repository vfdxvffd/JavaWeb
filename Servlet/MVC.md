# MVC设计模式
M：Model    模型：一个功能。用JavaBean实现
V：View     视图：用于展示、以及与用户交互。html、css、js、jsp、jquery
C：Controller   控制器：接受请求，将请求跳转到模型进行处理；模型处理完毕后，再将处理的结果返回给请求处。可以用jsp实现，但是一般建议使用Servlet实现控制器。

# Servlet

Java类必须符合一定的规范：
* 必须继承javax.servlet.http.HttpServlet

* 重写其中的doGet()或doPost()方法
doGet();接收并处理所有get方式提交的请求
doPost();接收并处理所有post方式提交的请求

* Servlet要想使用，必须配置

  Servlet2.5：web.xml

  Servlet3.0：@WebServlet

  项目的根目录：WebContent、src

  <a href = "WelcomeServlet"></a>所在的jsp是在WebContent目录中，因此发出的请求WelcomeServlet，是去请求项目的根目录

* Servlet2.5的映射流程

  请求 -> <url-pattern> -> 根据<servlet-mapping> 中的<servlet-name>去匹配<servlet>中的<servlet-name>，然后最终寻找到<servlet-class>，将请求交由该<servlet-class>执行。

  url-pattern是路径，不是目录，根据路径找到名字，根据名字找资源文件

* Servlet3.0的映射流程

  请求地址与@WebServlet中的值进行匹配，如果匹配成功，则说明请求的就是该注解所对应的类

  

## 回顾纯手工创建第一个Servlet

* a、编写一个类，继承HttpServlet
* b、重写doGet()、doPost()方法
* c、编写web.xml中的servlet映射关系

## 借助eclipse快us生成Servlet

直接新建Servlet即可！（继承、重写、web.xml可以借助Eclipse自动生成）

## Servlet3.0和Servlet2.5的区别

Servlet3.0不需要在web.xml中配置，但需要在Servlet的类的定义处之上编写注解@WebServlet("/WelcomeServlet")，引号内为url-pattern的值

## 目录

项目目录：WebContent、src（所有构建路径）

例如：

WebContent中有一个文件index.jsp

src中有一个Servlet.java

如果index.jsp中请求<font color = "COLOR.RED">\<a href = "abc"\>...\<a\></font>，则寻找范围：既会在src根目录中找，也会在WebContent根目录中找

如果index.jsp中请求<font color = "COLOR.RED">\<a href = "a/abc"\>...\<a\></font>，则寻找范围：先在src或WebContent根目录中找a目录，然后再在a目录中找abc

web.xml中的 / ：http://localhost:8888/Servlet30Project/		代表项目根路径

jsp中的 / ：http://localhost:8888/		代表服务器根路径

## Servlet生命周期

加载 ——> 初始化（init()）——> 服务(service()一个抽象方法：一般都是doGet()和doPost()) ——> 销毁(destroy()) ——>  卸载

~~~java
init();		//第一次访问Servlet时会被执行，只执行这一次
/**
init()是默认第一次访问只执行一次，可以更改为tomcat启动时自动执行
1、Servlet2.5：
            <servlet>
            		。。。
                    <load-on-startup>1</load-on-startup>
              </servlet>
        其中1代表第一个，假如有两个servlet，都在tomcat启动时，自动执行init()，这个数字就表示了顺序
  
 2、
*/
service();	//doGet()、doPost()调用几次执行几次
destroy();	//关闭tomcat服务器时，执行一次
~~~

## Servlet API

由两个软件包组成：对应于HTTP协议的软件包、对应于除了HTTP协议以外的其他软件包，即Servlet

API适用于任何通信协议

## Servlet继承关系

自定义的Servlet继承自HttpServlet，HttpServlet又继承自GenericServlet，GenericServlet继承自Servlet、ServletConfig、Serializable三个接口

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200208200842233.png)

### ServletConfig：接口

~~~java
ServletContext getServletContext();	//获取Servlet上下文对象		application
/*
	ServletContext对象中的常见方法(application)：
    	getContextPath()	：相对路径
    	GetRealPath()  ：绝对路径
    	setAttribute()	、getAttribute()
    	----->
    	String getInitParameter(String name);	在当前Web容器范围内，获取名为name的参数值（初始化参数）
    	
    	Servlet3.0给当前Servlet设置初始值
    	@WebServlet(value = "/WelcomeServlet", initParams = {@WebInitParam(name = "servletparam30",value = "servletparam30...")},loadOnStartup = 1)
    	注意，此注解只隶属于某一个具体的Servlet，因此无法为整个Web容器设置初始化参数，如果要通过3.0设置Web容器初始化参数，任然要在web.xml中设置
*/
getInitParameter(String name);	//在当前Servlet范围内，获取名为name的参数值（初始化参数）
~~~

### Service

HttpServletRequest中的方法：同request，例如setAttribute()、getCookies()、getMethod()...

HttpServletResponse方法：同response

# Servlet使用层面

使用Eclipse在src中创建一个Servlet，然后重写doGet()、doPost()就可以了