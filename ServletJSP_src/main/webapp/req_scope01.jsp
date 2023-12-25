<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chapter07.Human" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request scope</title>
</head>
<body>
<% 
	Human h1 = (Human)request.getAttribute("human1");
%>
<%= h1.getName() %>さん<%= h1.getAge() %>歳
</body>
</html>