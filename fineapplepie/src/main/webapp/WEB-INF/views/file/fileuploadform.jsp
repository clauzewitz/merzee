<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드 폼</title>
</head>
<body>
<form action="fileupload.do" method="post" 
	enctype="multipart/form-data">
사진1: <input type="file" name="photo1"><br>
사진2: <input type="file" name="photo2"><br>
설명: <input type="text" name="description"><br>
<input type="submit" value="등록">
</form>
</body>
</html>