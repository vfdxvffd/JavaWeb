<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	function register()
	{
	    var mobile = document.getElementById("mobile").value;
	    alert(mobile);
	    //通过ajax异步方式请求客户端
	    xmlHttpRequest = new XMLHttpRequest();
	    
	    //设置xmlHttpRequest对象的回调函数
	    xmlHttpRequest.onreadystatechange = callBack;
	    
	    xmlHttpRequest.open("post","MobileServlet",true);
	    //如果是get方式提交则
	    //xmlHttpRequest.open("get","MobileServlet?mobile="+mobile,true);
	    //设置头信息
	    xmlHttpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");	
	    xmlHttpRequest.send("mobile="+mobile);		//k=v
	}
	//定义回调函数,接受服务端的返回值
	function callBack()
	{
		if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
			//接受服务端返回的数据
			var data = xmlHttpRequest.responseText;	//服务端返回值为String格式
			if(data == "true"){
				alert("此号码已存在！");
			}else{
				alert("注册成功！");
			}
		}
	}
</script>

<title>Insert title here</title>
</head>
<body>
		
		手机：<input id="mobile" name="mobile" />
		<br/>
		<input type="button" value="注册" onclick="register()"/>
</body>
</html>