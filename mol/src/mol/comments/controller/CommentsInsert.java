package mol.comments.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;
import mol.comments.model.CommentsDAO;
import mol.comments.model.CommentsVO;

/**
 * Servlet implementation class CommentsInsert
 */
@WebServlet("/CommentsInsert.do")
public class CommentsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		
		String id = (String)request.getSession().getAttribute("loginId");
		String bseq = request.getParameter("bseq");
		String comments = request.getParameter("comments");
		
		CommentsDAO commentsDAO = new CommentsDAO();
		CommentsVO vo = new CommentsVO();
		
		vo.setId(id);
		vo.setComments(comments);
		vo.setBseq(bseq);
		commentsDAO.commentsInsert(vo);
//		
//		PrintWriter out = response.getWriter();
//		out.print("등록완료");
//		request.getRequestDispatcher("/board/boardView.jsp").forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/BoardView.do?seq="+bseq);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
