<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html 
	PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생등록</title>
</head>
<body>
<h1>학생등록</h1>
<form action='add.do' method="post">
이름: <input type="text" name="name"><br>
전화: <input type="text" name="mobile"><br>
이메일: <input type="text" name="email"><br>
주소: <textarea name="address" cols="50" rows="2"></textarea><br>
재직: <select name="working">
	<option value="true">재직중</option>
	<option value="false">미취업</option>
</select><br>
성별: <input type="radio" name="gender" value="0" checked>여자 
	 <input type="radio" name="gender" value="1">남자<br>
<input type="submit" value="등록">
</form>
</body>
</html>