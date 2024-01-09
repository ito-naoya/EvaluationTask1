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
 	<span style="color: red;">編集したい行をダブルクリックで選択</span>
		<table class="table table-bordered text-center m-auto st-tbl1" style="borderColor: orange;"id="bookTable">
			<thead>
				<tr>
					<th style="background-color: darkblue; color: white;">JANコード</th>
					<th style="background-color: darkblue; color: white;">ISBNコード</th>
					<th style="background-color: darkblue; color: white;">書籍名</th>
					<th style="background-color: darkblue; color: white;">書籍名（カナ表記）</th>
					<th style="background-color: darkblue; color: white;">価格</th>
					<th style="background-color: darkblue; color: white;">発行日</th>
					<th style="background-color: darkblue; color: white;">作成日</th>
					<th style="background-color: darkblue; color: white;">更新日</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<BookBean> bookBeanList = (ArrayList<BookBean>) request.getAttribute("bookBeanList");
				%>
	
				<%
				for (BookBean bb : bookBeanList) {
				%>
				<tr ondblclick="location.href='editBookInfo?janCd=<%=bb.getJanCd()%>'" style="cursor: pointer;">
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