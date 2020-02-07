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
*