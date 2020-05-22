package mol.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mol.board.model.BoardDAO;
import mol.board.model.BoardVO;


/**
 * Servlet implementation class BoardInsert
 */
@WebServlet("/BoardInsert.do")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//a태그 클릭시 게시판등록페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/board/boardInsert.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				response.setContentType("text/html; charset=UTF-8");
				request.setCharacterEncoding("utf-8");

				// 1.파라미터 받기
				String seq = request.getParameter("seq"); // 이런식으로 아이디와 패스워드 받기
				String title = request.getParameter("title"); // 이런식으로 아이디와 패스워드 받기
				String id = request.getParameter("id");
				String recommend = request.getParameter("recommend");
				String reason = request.getParameter("reason");
	

				// 2.서비스 로직 처리(DAO)
				BoardDAO boardDAO = new BoardDAO();
				BoardVO board = new BoardVO();

				
				board.setTitle(title);
				board.setId(id);
				board.setRecommend(recommend);
				board.setReason(reason);
		
				
				boardDAO.boardInsert(board);
				
				
				response.sendRedirect(request.getContextPath()+ "/BoardList.do");

			}

}
