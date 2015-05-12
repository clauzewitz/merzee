<%@page import="vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생정보3</h1>
<form action='update.do' method='post'>
번호: <input readonly type='text' name='no' value='${student.no}'><br>
이름: <input type='text' name='name' value='${student.name}'><br>
전화: <input type='text' name='mobile' value='${student.mobile}'><br>
이메일: <input type='text' name='email' value='${student.email}'><br>
주소: <textarea name='address' cols='50' rows='2'>${student.address}</textarea><br>
<%-- 
String working = "";
String notWorking = "";
if (s.isWorking()) {
	working = "selected";
} else {
	notWorking = "selected";
}
--%>
<c:set var="working" value=""/>
<c:set var="notWorking" value=""/>
<c:choose>
	<c:when test="${student.working}">
		<c:set var="working" value="selected"/>
	</c:when>
	<c:otherwise>
		<c:set var="notWorking" value="selected"/>
	</c:otherwise>
</c:choose>

재직: <select name='working'>
	<option value='true' ${working}>재직중</option>
	<option value='false' ${notWorking}>미취업</option>
</select><br>
<%-- 
String woman = "";
String man = "";
if (s.getGender() == 0)
	woman = "checked";
else 
	man = "checked";
--%>
<c:set var="woman" value=""/>
<c:set var="man" value=""/>
<c:choose>
	<c:when test="${student.gender == 0}">
		<c:set var="woman" value="checked"/>
	</c:when>
	<c:otherwise>
		<c:set var="man" value="checked"/>
	</c:otherwise>
</c:choose>
성별: <input type='radio' name='gender' value='0' ${woman}>여자 
	 <input type='radio' name='gender' value='1' ${man}>남자<br>
<input type='submit' value='등록'>
</form>

</body>
</html>