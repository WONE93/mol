package mol.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mol.board.model.BoardDAO;
import mol.comments.model.CommentsDAO;

/**  
 * Servlet implementation class BoardDelete
 */
@WebServlet("/BoardDelete.do")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //파라미터 받기 -> 세션에서 seq가져오기
//		  String bseq = request.getParameter("bseq");
	      String seq = request.getParameter("seq");
	      //서비스 로직 처리
	      BoardDAO dao = new BoardDAO();
//	      CommentsDAO comments = new CommentsDAO();
	      
//	      comments.deleteComments(bseq);
	      dao.deleteBoard(seq);
	      //결과저장
	      //request.setAttribute("board", vo);
	      
	      //뷰페이지로 이동
	      response.sendRedirect(request.getContextPath() + "/BoardList.do");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
