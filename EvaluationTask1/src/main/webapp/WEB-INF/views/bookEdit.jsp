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
</head>
<body>
	<div class="container" style="margin-top: 30px;">
	<% BookBean bb = (BookBean)request.getAttribute("bookBean"); %>
		<form action="editBookInfo" method="POST">
		  <div class="mb-3">
		    <label class="form-label">JAN_CD<span style="color:red;">(編集不可)</span></label>
		    <br>
		    <input disabled type="text" class="form-control" value="<%= bb.getJanCd() %>">
		    <input type=hidden name="janCd" value="<%= bb.getJanCd() %>">
		  </div>
		  <div class="mb-3">
		    <label class="form-label">ISBN_CD<span style="color:red;">(編集不可)</span></label>
		    <br>
		    <input disabled type="text" class="form-control" value="<%= bb.getIsbnCd() %>">
		  </div>
		  <div class="mb-3">
		    <label for="bookNm" class="form-label">BOOK_NM</label>
		    <br>
		    <input type="text" name="bookNm" id="bookNm" class="form-control" value="<%= bb.getBookNm() %>">
		  </div>
		  <div class="mb-3">
		    <label for="bookKana" class="form-label">BOOK_KANA</label>
		    <br>
		    <input type="text" name="bookKana" id="bookKana" class="form-control" value="<%= bb.getBookKana() %>">
		  </div>
		  <div class="mb-3">
		    <label for="price" class="form-label">PRICE</label>
		    <br>
		    <input type="number" name="price" id="price" class="form-control" min="1" value="<%= bb.getPrice() %>" required>
		  </div>
		  <div class="mb-3">
		    <label class="form-label">ISSUE_DATETIME<span style="color:red;">(編集不可)</span></label>
		    <br>
		    <input disabled type="text" class="form-control" value="<%= bb.getIssueDate() %>">
		  </div>
		  <div class="mb-3">
		    <label class="form-label">CREATE_DATETIME<span style="color:red;">(編集不可)</span></label>
		    <br>
		    <input disabled type="text" class="form-control" value="<%= bb.getCreateDatetime() %>">
		  </div>
		  <div class="mb-3">
		    <label class="form-label">UPDATE_DATETIME<span style="color:red;">(編集不可)</span></label>
		    <br>
		    <input disabled type="text" class="form-control" value="<%= bb.getUpdateDatetime() == null ? "更新履歴なし" : bb.getUpdateDatetime() %>">
		  </div>
		  <button type="submit" class="btn btn-primary">更新</button>
		  <a href="bookList" class="ms-3">一覧へ戻る</a>
		</form>
	</div>
</body>
</html>