<%@page import="vo.Student"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
[
<% int count = 0; %>
<c:forEach var="s" items="${list}">
<%
if (count > 0) {out.print(",");} count++;
%>
{
"no": "${s.no}",
"name": "${s.name}",
"mobile": "${s.mobile}",
"email": "${s.email}",
"working": "${s.working}",
}
</c:forEach>
]