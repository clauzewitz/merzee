<%@page import="vo.Student"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생목록</title>
</head>
<body>
<h1>학생목록 by EL ver 1.0</h1>
<a href="add.do">[신규]</a>       <a href="login.do">[로그인]</a> <br>
<table>
	<tr>
		<th>번호</th> <th>이름</th> <th>전화</th>
		<th>이메일</th> <th>재직</th>
	</tr>

<c:forEach var="s" items="${list}">
<tr>
	<td>${s.no}</td>
	<td><a href="detail.do?no=${s.no}">${s.name}</a></td>
	<td>${s.mobile}</td>
	<td>${s.email}</td>
	<td>	<c:choose>
			<c:when test="${s.working}">재직중</c:when>
			<c:otherwise>미취업</c:otherwise>
	</c:choose></td>
	<td><a href="delete.do?no=${s.no}">삭제</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
<%System.out.println("JSP 실행 종료..."); %>

