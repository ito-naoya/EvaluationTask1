package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DeleteBook;


@WebServlet("/deleteBook")
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteBookController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String janCd = request.getParameter("janCd");
		
		Boolean isCommit = DeleteBook.deleteBook(janCd);
		
		if(!isCommit) {
			request.setAttribute("message", "書籍の削除に失敗しました。");
			String view = "/WEB-INF/views/message.jsp";
			request.getRequestDispatcher(view).forward(request, response);
			return;
		}
		
		response.sendRedirect("bookList");
		
	}
}
