package mol.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mol.member.model.MemberDAO;
import mol.member.model.MemberVO;



/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//회원가입페이지로 고잉고잉
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberInsert.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
				
		//1.파라미터 받기
		String id = request.getParameter("id"); // 이런식으로 아이디와 패스워드 받기												
		String pwd = request.getParameter("pwd");
		
		//이름, 성별, 가입경로, 자기소개, 가입일자
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String introduction = request.getParameter("introduction");
		
	
		String[] path = request.getParameterValues("path");
		// 값이 체크박스일 경우에만, 선택지가 여러개인 경우에만 파라미터밸류스로 
		String paths = "";
		if(paths != null)
			for(String temp: path) {
				paths += temp + ",";
			}

		
		//2.서비스 로직 처리(DAO)
		MemberDAO memberDAO = new MemberDAO();
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setGender(gender);
		member.setPath(paths);
		member.setIntroduction(introduction);
		
		
		memberDAO.memberInsert(member);
		
		//3.회원목록 이동   // include, forward, sendRedirect
//		String contextPath = getServletContext().getContextPath();
//		response.sendRedirect(contextPath + "/MemberList.do");  
	}

}
