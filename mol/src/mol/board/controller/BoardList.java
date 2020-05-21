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
import mol.common.Paging;



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
		
		String id2 = request.getParameter("id");
		
		String strPage = request.getParameter("p");
		int p = 1;
		if(strPage != null && ! strPage.isEmpty()) {
			p = Integer.parseInt(strPage);
		}
		//페이징 객체를 생성
		Paging paging = new Paging();
		paging.setPageUnit(1);  //현재페이지에 출력할 레코드 건수 디폴트는 10개
		paging.setPageSize(3); // 한페이지에 페이지번호가 3개씩 보일것. 디폴트는 10
		paging.setPage(p); // 현재페이지
		paging.setTotalRecord(dao.getCount(id2)); // 전체 레코드 건수 조회 CUZ마지막건수가 정의돼야해서(얘는 필수)
		request.setAttribute("paging", paging);		
		
		//2. 서비스(DAO 목록조회)
		int start = paging.getFirst();
		int end = paging.getLast();
		
		ArrayList<BoardVO> list = dao.getBoardList(start, end, id2);

		// 3. 결과출력 OR 결과저장해서 view 포워드
		request.setAttribute("list", list);
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
