<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일업로드 결과</title>
</head>
<body>
업로드 성공!<br>
파일1: ${photo1}<br>
<img src="file/${photo1}"><br>
파일2: ${photo2}<br>
<img src="file/${photo2}"><br>
설명: ${description}<br>
</body>
</html>








