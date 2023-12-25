<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>person01</title>
</head>
<body>
	メンバー<br>
	<table border="1" width="70">
		<tr>
			<th>名前</th>
		</tr>
		<c:forEach var="name" items="${names}">
			<tr>
				<td><c:out value="${name}" /></td>
			</tr>
		</c:forEach>
	</table>
	<form method="post">
		追加する名前は<input type="text" name="name"> 
		<input type="submit" value="追加">
	</form>
</body>
</html>