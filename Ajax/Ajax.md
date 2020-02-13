# Ajax

异步js和xml

## 异步刷新

如果网页中某一个地方需要修改，异步刷新可以使：只刷新该刷新的地方，而页面中其它地方保持不变

### 实现

js：XMLHttpRequest对象

方法摘要：

~~~js
open(方法名（提交方式get/post） ,服务器地址 , true是否为异步刷新);					//与服务端建议连接
send();			//发送数据
			get：send(null)
			post:  send(参数值)
setRequestHeader(header,value);			//请求头信息，header和value是一对键值对
			get：不需要设置此方法
            post：需要设置：
            			1、如果请求元素中包含了文件上传：
                        		setRequestHeader("Content-type","multiparty/form-data");	
                        2、不包含
                        		setRequestHeader("Content-type","application/x-www-form-urlencoded");	
~~~

常见的属性

~~~js
readyState：请求状态，只有状态为4才表示请求完毕
status：响应状态，只有200才表示响应正常
onreadystatechange：回调函数
responseText：响应格式为String
responseXML：相应格式为XML
~~~

jquery

~~~js
$.ajax(
    {
		url:服务器地址,
        请求方式：get|post,
        data：请求数据,
        success：function(result , testStatus){
    
		},
         error：function(xhr, errorMessage, e){
             
         }
    }
);
~~~

~~~js
$.get(
服务器地址，
请求数据，
function( result ){
    //success
},
预期返回值类型"xml" 或	"json"	或	"text"
);
~~~

~~~js
$.post(
服务器地址，
请求数据，
function( result ){
    //success
},
预期返回值类型"xml" 或	"json"	或	"text"
);
~~~

~~~js
//在<span id="tip"></span>上显示服务端传回的值result
$("#tip").load(
			   "MobileServlet",			//服务器地址
			   "mobile="+$mobile,   	//请求数据
	   );
~~~

~~~json
//大概了解一下json数组
var student = {"name":"zs", "age":23};
	   alert(student.name+"---"+student.age);	//json属性
	   var students = [
			   {"name":"zs", "age":23},
			   {"name":"ls", "age":21},
			   {"name":"ww", "age":22}
	   ];
	   alert(students[0].name+"---"+students[0].age);
~~~

~~~json
//在servlet中
if("123".equals(mobile)) {
			out.write("{\"msg\":\"true\"}");		//servlet以输出流方式，将信息返回给客户端
		}else {
			out.write("{\"msg\":\"false\"}");		//返回给客户端一个Json字符串
		}

//在jsp中
$.getJSON(
			  "MobileServlet",				//服务器地址
			   {"mobile":$mobile},		//请求数据{"k":v , "k2":v2}
			   function(result){	// msg ：true | false			//result为返回的数据
					  if(result.msg == "true"){
						  alert("已存在！");
					  }else{
						  alert("注册成功！");
					  }
				  }
	  ); 
~~~



