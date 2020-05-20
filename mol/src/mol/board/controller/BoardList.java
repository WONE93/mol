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




@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("loginId");
		if (id == null) {
			request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
			return;
		}
		
		// 2. 서비스(DAO 목록조회)
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.getBoardList();

		// 3. 결과출력 OR 결과저장해서 view 포워드
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
