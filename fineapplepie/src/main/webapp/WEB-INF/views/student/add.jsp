<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
<head> <!-- 문서에 대한 설명 -->
	<title>학생등록</title>
	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">
	<meta http-equiv='Refresh' content='3;url=list.do'>
</head>
<body> 
<h1>학생등록결과</h1>
<c:if test="${student != null}">
등록되었습니다!!<br>
이름: ${student.name} <br>
전화: ${student.mobile} <br>
이메일: ${student.email} <br>
주소: ${student.address} <br>
재직: ${student.working} <br>
성별: ${student.gender} <br>
</c:if>
</body>
</html>