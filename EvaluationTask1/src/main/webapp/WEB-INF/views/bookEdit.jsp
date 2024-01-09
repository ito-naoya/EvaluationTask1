<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.BookBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
	<link rel="stylesheet" href="./css/bookEditStyle.css">
</head>
<body>
	<div class="container" style="margin-top: 30px; width: 600px;">
	<% BookBean bb = (BookBean)request.getAttribute("bookBean"); %>
		<form action="editBookInfo" method="POST">
		  <div class="mb-3">
		    <label for="updateJanCd" class="form-label">JANコード</label>
		    <br>
		    <input type="text" name="updateJanCd" id="updateJanCd" class="form-control" value="<%= bb.getJanCd() %>">
		    <input type="hidden" name="janCd" id="janCd" class="form-control" value="<%= bb.getJanCd() %>">
		  </div>
		  <div class="mb-3">
		    <label for="isbnCd" class="form-label">ISBNコード</label>
		    <br>
		    <input type="text" name="isbnCd" id="isbnCd" class="form-control" value="<%= bb.getIsbnCd() %>">
		  </div>
		  <div class="mb-3">
		    <label for="bookNm" class="form-label">書籍名称</label>
		    <br>
		    <input type="text" name="bookNm" id="bookNm" class="form-control" value="<%= bb.getBookNm() %>">
		  </div>
		  <div class="mb-3">
		    <label for="bookKana" class="form-label">書籍名称カナ</label>
		    <br>
		    <input type="text" name="bookKana" id="bookKana" class="form-control" value="<%= bb.getBookKana() %>">
		  </div>
		  <div class="mb-3">
		    <label for="price" class="form-label">価格</label>
		    <br>
		    <input type="number" name="price" id="price" class="form-control" min="1" value="<%= bb.getPrice() %>" required>
		  </div>
		  <div class="mb-3">
		    <label for="issueDate" class="form-label">発行日</label>
		    <br>
		    <input type="date" name="issueDate" id="issueDate" class="form-control" value="<%= bb.getIssueDate() %>">
		  </div>
		  <button type="submit" class="btn btn-primary">更新</button>
		  <a href="bookList" class="ms-3">一覧へ戻る</a>
		</form>
	</div>
</body>
</html>