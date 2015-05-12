<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
</head>
<body>
<h1>메인화면</h1>
이름: ${sessionScope.userName}<br>
전화: ${userMobile}<br>
<a href="myprofile.do">내정보</a><br>
<a href="logout.do">로그아웃</a><br>
</body>
</html>


