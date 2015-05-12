<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>시스템 메시지!</title>
</head>
<body>
<p>현재 접속자가 많습니다.<p>
<p>계속해서 이 화면이 출력된다면,<br> 
관리자(admin@test.com)에게 연락주세요.<p>
<%
Exception e = (Exception) request.getAttribute("error");
e.printStackTrace(new PrintWriter(out));
%>
</body>
</html>