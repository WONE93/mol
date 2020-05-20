package mol.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mol.member.model.MemberDAO;
import mol.member.model.MemberVO;


@WebServlet("/MemberLogin.do")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 페이지로 포워드
		request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
	}

	//로그인처리 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");

				// 2. 서비스 로직
				MemberDAO dao = new MemberDAO();
				MemberVO vo = dao.getMember(id);
				// id 조회결과 없으면 id 없다
				if (vo.getId() == null) { // id 오류
					request.setAttribute("errorMsg", "id오류");
					request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
				} else if (!vo.getPwd().equals(pwd)) { // pwd 오류
					request.setAttribute("errorMsg", "pwd오류");
					request.getRequestDispatcher("/member/memberLogin.jsp").forward(request, response);
				} else { // login OK
					// 세션에 로그인 여부를 저장
					HttpSession session = request.getSession();
					session.setAttribute("loginId", id);
					session.setAttribute("loginMember", vo);
					response.sendRedirect(request.getContextPath() + "/main/main.jsp");
				}

	}

}
