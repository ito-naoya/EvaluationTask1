package controller;

import java.io.IOException;
import java.util.ArrayList;

import beans.BookBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SelectBookList;

@WebServlet("/bookList")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BookBean> bookBeanList = SelectBookList.selectBookList();
		request.setAttribute("bookBeanList", bookBeanList);
		
		String view = "/WEB-INF/views/bookList.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
}
