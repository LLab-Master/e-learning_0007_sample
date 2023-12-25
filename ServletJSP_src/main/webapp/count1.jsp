<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 使用する変数の宣言 --%>
<%
	int end = 10;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP Sample</title>
</head>
<body>
	<%-- for ループ --%>
	<% for (int i = 0; i < end; i++) { %>
		<%-- スクリプト式で表示 --%>
		<%= i %><br>
	<% } %>
</body>
</html>