package mol.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mol.board.model.BoardDAO;
import mol.board.model.BoardVO;
import mol.comments.model.CommentsDAO;
import mol.comments.model.CommentsVO;



/**
 * Servlet implementation class BoardView
 */
@WebServlet("/BoardView.do")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String seq = (String) request.getParameter("seq");
		
		//서비스 로직 처리
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq); //한건조회 vo에 id값을 담을것임
 
		//결과저장
		request.setAttribute("vo", vo);  // 정말 중요한 부분!! 
		
		//댓글조회
		CommentsDAO commentsDAO = new CommentsDAO();
		ArrayList<CommentsVO> list = commentsDAO.getComments(seq);
		
	
		// 3. 결과출력 OR 결과저장해서 view 포워드
		request.setAttribute("list", list);
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/board/boardView.jsp")
			   .forward(request, response); //리퀘스트 객체를 넘겨줘야하면 forward임 

			
	}


}
