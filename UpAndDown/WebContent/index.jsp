<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="UploadServlet" method="post" enctype="multipart/form-data">
			姓名：<input type="text" name="sname"><br/>
			学号：<input type="text" name="sid"><br/>
			照片：<input type="file" name="spicture"/><br/>
			<input type="submit" value="上传"/>
		</form>
		
		<a href="DownloadServlet?filename=示例.txt">示例.txt</a>
</body>
</html>