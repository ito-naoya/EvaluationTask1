<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String message = (String) request.getAttribute("message");%>
	<p>
	<%= message %>
	</p>
	<a href="bookList">一覧へ戻る</a>
</body>
</html>