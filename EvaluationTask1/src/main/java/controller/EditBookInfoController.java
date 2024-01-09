package controller;

import java.io.IOException;

import beans.BookBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SelectBook;
import model.UpdateBook;

@WebServlet("/editBookInfo")
public class EditBookInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditBookInfoController() {
        super();
    }

    //編集画面表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String janCd = request.getParameter("janCd");
		BookBean bb = SelectBook.selectBook(janCd);
		
		request.setAttribute("bookBean", bb);
		
		String view = "/WEB-INF/views/bookEdit.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}


	//更新
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String janCd = request.getParameter("janCd");
		String bookNm = request.getParameter("bookNm");
		String bookKana = request.getParameter("bookKana");
		Integer price = Integer.valueOf(request.getParameter("price"));
		
		UpdateBook.updateBook(bookNm, bookKana, price, janCd);
		
		response.sendRedirect("bookList");
		
	}

}
