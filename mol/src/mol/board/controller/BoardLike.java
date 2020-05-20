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
 * Servlet implementation class BoardLike
 */
@WebServlet("/BoardLike.do")
public class BoardLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 (회원 아이디 받기) - > 세션에서 id 가져오기 
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null ) {
			response.sendRedirect(request.getContextPath() +"/MemberLogin.do");
			return;
			
		}	
//		String seq =  Integer.parseInt(request.getParameter("seq"));

		//서비스 로직 처리
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(id);
 
		//결과저장
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("/board/boardView.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath()+"/board/boardView.jsp");
	}

	//좋아여처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//요청정보 인코딩
		request.setCharacterEncoding("utf-8"); //post로 받을때는 이거 꼭 해줘야함
			
		//1.파라미터 받기
		String id = request.getParameter("id"); // 이런식으로 아이디와 패스워드 받기												
		String pwd = request.getParameter("pwd");
		
		//좋아요값 담기
		String love = request.getParameter("love");
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = new BoardVO();
		
		board.setLove(love);
		
		boardDAO.getLike(board);
		
		
		
		
	}

}
