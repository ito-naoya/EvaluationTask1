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
		<form action="bookForm" method="POST" id="bookForm">

			<div class="mb-3">
				<% String isExist = (String)request.getAttribute("isExist"); %>
				<label for="janCd" class="form-label">JANコード</label>
				<label for="janCd" style="color: red"><%= isExist != null && !isExist.isEmpty() ? isExist : "" %></label>
				<br>
				<% String janCd = (String)request.getAttribute("janCd"); %>
				<input type="text" min="13" max="13" name="janCd" id="janCd" class="form-control" value="<%= bb == null ? "" : bb.getJanCd() %>" required>
				<label for="janCd" style="color: red;"><%= janCd == null ? "" : janCd %></label>
				<% String originJanCd = (String)request.getAttribute("originJanCd"); %>
				<% if(bb != null && bb.getCreateDatetime() != null) { %>
					<input type="hidden" name="originJanCd" id="originJanCd" class="form-control" value="<%= originJanCd == null ? bb.getJanCd()  : originJanCd %>">
				<% } %>
			</div>

			<div class="mb-3">
				<label for="isbnCd" class="form-label">ISBNコード</label>
				<br>
				<input type="text" name="isbnCd" min="13" max="13" id="isbnCd" class="form-control" value="<%= bb == null ? "" : bb.getIsbnCd() %>" required>
				<% String isbnCd = (String)request.getAttribute("isbnCd"); %>
				<label for="isbnCd" style="color: red;"><%= isbnCd == null ? "" : isbnCd %></label>
			</div>

			<div class="mb-3">
				<label for="bookNm" class="form-label">書籍名称</label>
				<br>
				<input type="text" name="bookNm" min="1" max="100" id="bookNm" class="form-control" value="<%= bb == null ? "" : bb.getBookNm() %>" required>
				<% String bookNm = (String)request.getAttribute("bookNm"); %>
				<label for="bookNm" style="color: red;"><%= bookNm == null ? "" : bookNm %></label>
			</div>
		  
			<div class="mb-3">
				<label for="bookKana" class="form-label">書籍名称カナ</label>
				<br>
				<input type="text" name="bookKana" min="1" max="100" id="bookKana" class="form-control" value="<%= bb == null ? "" : bb.getBookKana() %>" required>
				<% String bookKana = (String)request.getAttribute("bookKana"); %>
				<label for="bookKana" style="color: red;"><%= bookKana == null ? "" : bookKana %></label>
			</div>
		  
			<div class="mb-3">
				<label for="price" class="form-label">価格</label>
				<br>
				<input type="number" name="price" min="1" max="10000" id="price" class="form-control" min="1" value="<%= bb == null ? "" : bb.getPrice() %>" required>
				<% String price = (String)request.getAttribute("price"); %>
				<label for="price" style="color: red;"><%= price == null ? "" : price %></label>
			</div>
		  
			<div class="mb-3">
				<label for="issueDate" class="form-label">発行日</label>
				<br>
				<input type="date" name="issueDate" id="issueDate" class="form-control" value="<%= bb == null ? "" : bb.getIssueDate() %>" required>
				<% String issueDate = (String)request.getAttribute("issueDate"); %>
				<label for="issueDate" style="color: red;"><%= issueDate == null ? "" : issueDate %></label>
			</div>
			
		   <div class="d-flex mb-3 justify-content-around">
			   	<p class="m-0">
			   		登録日時：
			   		<% if(bb != null) { %>
			   			<%= bb.getCreateDatetime() == null ? "" : bb.getCreateDatetime()%>
			   			<input type="hidden" name="createDate" value="<%= bb != null && bb.getCreateDatetime() == null ? "" : bb.getCreateDatetime()%>">
			   		<% } %>
			   	</p>
			   	<p class="m-0">
			   		更新日時：
			   		<% if(bb != null) { %>
				   		<%= bb.getUpdateDatetime() == null ? "" : bb.getUpdateDatetime() %>
				   		<input type="hidden" name="updateDate" value="<%= bb != null && bb.getUpdateDatetime() == null ? "" : bb.getUpdateDatetime() %>">
			   		<% } %>
			   	</p>
		   </div>
		</form>
		<div class="d-flex align-items-center">
			<% if(bb != null && bb.getCreateDatetime() != null) { %>
				<form action="deleteBook" method="GET">
					 <input type="hidden" name="janCd" value="<%= bb.getJanCd() %>">
					 <button type="submit" class="btn btn-danger">削除</button>
				</form>
			<% } %>
			 <button form="bookForm" type="submit" class="btn btn-primary ms-1"><%= bb != null && bb.getCreateDatetime() != null ? "更新" : "新規登録" %></button>
			<a href="bookList" class="ms-3">一覧へ戻る</a>
		</div>
	</div>
</body>
</html>