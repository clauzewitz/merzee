<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%--
RequestDispatcher rd = 
	request.getRequestDispatcher("/login.do");
rd.forward(request, response);
--%>
<%-- 방법1. Forward 
<jsp:forward page="/login.do"/>
--%>

<%
// 방법2. Refresh 이용
//response.setHeader("Refresh", "1;url=login.do");

// 방법3. Redirect 이용
response.sendRedirect("html/main.html");
%>
<html>
<body>
로그인 화면으로 이동합니다!
</body>
</html>






