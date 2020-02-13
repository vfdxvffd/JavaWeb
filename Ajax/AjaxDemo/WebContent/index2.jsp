<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<script type="text/javascript">
	function register()
	{
	   var $mobile = $("#mobile").val();		//拿到mobile属性值
	   /* $.ajax({
		  url:"MobileServlet",
		  type:"post",
		  data:"mobile="+$mobile,
		  success:function(result,testStatus){
			  if(result == "true"){
				  alert("已存在！");
			  }else{
				  alert("注册成功！");
			  }
		  },
		  error:function(xhr,errorMessage,e){
			  
		  }
	   }); */
	   
	   /* $.get(
			   "MobileServlet",
			   "mobile="+$mobile,
			   function(result,testStatus){
					  if(result == "true"){
						  alert("已存在！");
					  }else{
						  alert("注册成功！");
					  }
				  },
			  	"text"	   
	   ); */
	   
	   /* $("#tip").load(
			   "MobileServlet",
			   "mobile="+$mobile,   
	   ); */
	   
	  $.getJSON(
			  "MobileServlet",
			   {"mobile":$mobile},
			   function(result){
					  if(result.msg == "true"){
						  alert("已存在！");
					  }else{
						  alert("注册成功！");
					  }
				  }
	  ); 
	}
	
	function testJson(){
		 $.getJSON(
				  "JsonServlet",
				   {"name":"zs", "age":23},
				   function(result){
						 
					  }
		  ); 
	}
</script>

<title>Insert title here</title>
</head>
<body>

	手机：
	<input id="mobile" />
	<br />
	<input type="button" value="注册" onclick="register()" />
	<span id="tip"></span>
	<input type="button" value="测试json" onclick="testJson()"/>
</body>
</html>