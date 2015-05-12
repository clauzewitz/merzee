<%@page import="vo.Student"%>
<%@page import="java.util.Collection"%>
<%@page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="gson" class="com.google.gson.Gson"
	scope="application"/>

<%
//com.google.gson.Gson gson =  application.getAttribute("gson");
//if(gson = null){   //무조껀 쓰는거..
//	gson = new com.google.gson.Gson();  //없으면 즉시 만드는 구만...
//	application.setAttribute("gson");   //그래서 무조껀 쓸수 있구만...
%>

<%=gson.toJson(request.getAttribute("list"))%>
