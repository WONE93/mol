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
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 (회원 아이디 받기) - > 세션에서 id 가져오기 
		String id = (String) request.getSession().getAttribute("loginId");
		String seq = (String) request.getParameter("seq");
		if(id == null ) {
			response.sendRedirect(request.getContextPath() +"/MemberLogin.do");
			return;
			
		}	
		//서비스 로직 처리
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(seq); //한건조회 vo에 id값을 담을것임
 
		//결과저장
		request.setAttribute("vo", vo); 
		
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	//수정처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//포스트 방식일때는 밑의 방식으로 해야 한글 안깨짐
		//응답결과 인코딩  
		response.setContentType("text/html; charset=UTF-8");
		//요청정보 인코딩
		request.setCharacterEncoding("utf-8"); //post로 받을때는 이거 꼭 해줘야함
			
		//1.파라미터 받기
		String id = request.getParameter("id"); // 이런식으로 아이디와 패스워드 받기												
		String pwd = request.getParameter("pwd");
		
		//자기소개, 이름, 종교, 취미
		String title = request.getParameter("title");
		String recommend = request.getParameter("recommend");
		String reason = request.getParameter("reason");
		String seq = request.getParameter("seq");
		

		
		//2.서비스 로직 처리(DAO)
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle(title);
		vo.setRecommend(recommend);
		vo.setReason(reason);
		vo.setSeq(seq);

		boardDAO.boardUpdate(vo);
		
		response.sendRedirect(request.getContextPath()+ "/BoardList.do");
	}

}
