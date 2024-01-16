package controller;

import java.io.IOException;
import java.sql.Date;

import beans.BookBean;
import classes.BeanValidation;
import interfaces.GroupA;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.InsertBook;
import model.SelectBook;
import model.UpdateBook;

@WebServlet("/bookForm")
public class BookFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookFormController() {
        super();
    }

    //編集画面表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String janCd = request.getParameter("janCd");
		
		if(janCd == null || janCd.isEmpty() || janCd.equals("")) {
			String view = "/WEB-INF/views/bookForm.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			return;
		}
		
		BookBean bb = SelectBook.selectBook(janCd);
		
		if(bb == null) {
			request.setAttribute("message", "書籍情報の取得に失敗しました。");	
			
			String view = "/WEB-INF/views/message.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			return;
		}
		
		request.setAttribute("bookBean", bb);
		
		String view = "/WEB-INF/views/bookForm.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}


	//更新
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String janCd = request.getParameter("janCd");
		String originJanCd = request.getParameter("originJanCd");
		String isbnCd = request.getParameter("isbnCd");
		String bookNm = request.getParameter("bookNm");
		String bookKana = request.getParameter("bookKana");
		Integer price = Integer.valueOf(request.getParameter("price"));		
		String issueDate = request.getParameter("issueDate");
		String createDate = request.getParameter("createDate");
		String updateDate = request.getParameter("updateDate");
		
		BookBean bb = new BookBean();
		bb.setJanCd(janCd);
		bb.setIsbnCd(isbnCd);
		bb.setBookNm(bookNm);
		bb.setBookKana(bookKana);
		bb.setPrice(price);
		bb.setIssueDate(Date.valueOf(issueDate));
		
		Boolean isViolation = BeanValidation.validate(request, "bookBean", bb, GroupA.class);
		
		if(isViolation) {
			if(createDate != null && !createDate.isEmpty() && !createDate.equals("")) bb.setCreateDatetime(Date.valueOf(createDate));
			if(updateDate != null && !updateDate.isEmpty() && !updateDate.equals(""))bb.setUpdateDatetime(Date.valueOf(updateDate));
			request.setAttribute("bookBean", bb);
			String view = "/WEB-INF/views/bookForm.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			return;
		}
		
		Boolean isCommit = false;
		
		if(originJanCd == null) {
			
			isCommit = InsertBook.insertBook(janCd, isbnCd, bookNm, bookKana, price, issueDate);
			
		}else if(originJanCd != null && !originJanCd.equals("") && !originJanCd.isEmpty())  {
			
			isCommit = UpdateBook.updateBook(originJanCd, isbnCd, bookNm, bookKana, price, issueDate, janCd);
			
		}
		
		if(!isCommit) {
			request.setAttribute("message", "書籍情報の更新に失敗しました。");	
			String view = "/WEB-INF/views/message.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			return;
		}
		
		response.sendRedirect("bookList");
		
	}

}
