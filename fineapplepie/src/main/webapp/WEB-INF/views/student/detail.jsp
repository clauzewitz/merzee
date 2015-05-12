<%@ page import="vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생정보</title>
</head>
<body>
<h1>학생정보2</h1>
<c:choose>
	<c:when test="${student != null}">
name : ${student.name}<br>
mobile : ${student.mobile}<br>
email : ${student.email}<br>
address : ${student.address}<br>
working : <c:if test="${student.working}">재직중</c:if>
			<c:if test="${!student.working}">미취업</c:if><br>
<c:set var="gender" value="여자"/>
<%--
String gender = "여자";
--%>
<c:if test="${student.gender == 1}">
	<c:set var="gender" value="남자"/>
</c:if>
gender : ${gender}<br>
<a href='update.do?no=${student.no}'>[변경]</a><br>
	</c:when>
	<c:otherwise>
		학생정보를 찾을 수 없습니다.
	</c:otherwise>
</c:choose>
</body>
</html>



