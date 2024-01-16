<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
<link rel="stylesheet" href="./css/bookListStyle.css">
</head>
<body>
 	<div class="container" style="margin-top: 30px">
 	<div class="d-flex justify-content-between mb-3">
 		<span style="color: red;">編集したい行をダブルクリックで選択</span>
 		<form action="bookForm" method="GET">
		 	<button type="submit" class="btn btn-primary ms-1">書籍を新規登録する</button>
 		</form>
 	</div>
		<table id="bookTable" class="table table-bordered text-center m-auto st-tbl1">
			<thead>
				<tr>
					<th style="background-color: darkblue; color: white;">JANコード</th>
					<th style="background-color: darkblue; color: white;">ISBNコード</th>
					<th style="background-color: darkblue; color: white;">書籍名称</th>
					<th style="background-color: darkblue; color: white;">書籍名称カナ</th>
					<th style="background-color: darkblue; color: white;">価格</th>
					<th style="background-color: darkblue; color: white;">発行日</th>
					<th style="background-color: darkblue; color: white;">登録日時</th>
					<th style="background-color: darkblue; color: white;">更新日時</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<BookBean> bookBeanList = (ArrayList<BookBean>) request.getAttribute("bookBeanList");
				%>
	
				<%
				for (BookBean bb : bookBeanList) {
				%>
				<tr ondblclick="location.href='bookForm?janCd=<%=bb.getJanCd()%>'" style="cursor: pointer;">
					<td><%= bb.getJanCd() %></td>
					<td><%= bb.getIsbnCd() %></td>
					<td><%= bb.getBookNm() %></td>
					<td><%= bb.getBookKana() %></td>
					<td><%= String.format("%,d", bb.getPrice()) %></td>
					<td><%= bb.getIssueDate() %></td>
					<td><%= bb.getCreateDatetime() %></td>
					<td><%= bb.getUpdateDatetime() == null ? "更新履歴なし" : bb.getUpdateDatetime() %></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>