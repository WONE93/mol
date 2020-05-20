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
@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//수정페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 (회원 아이디 받기) - > 세션에서 id 가져오기 
		String id = (String) request.getSession().getAttribute("loginId");
		if(id == null ) {
			response.sendRedirect(request.getContextPath() +"/MemberLogin.do");
			return;
			
		}	
		//서비스 로직 처리
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getMember(id); //한건조회 vo에 id값을 담을것임
 
		//결과저장
		request.setAttribute("member", vo);  // 정말 중요한 부분!! 
		
		//뷰페이지로 이동
		request.getRequestDispatcher("/member/memberUpdate.jsp")
			   .forward(request, response); //리퀘스트 객체를 넘겨줘야하면 forward임 
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
		
		//이름, 가입경로, 자기소개,  
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String introduction = request.getParameter("introduction");
	
		String[] path = request.getParameterValues("path");
		// 값이 체크박스일 경우에만, 선택지가 여러개인 경우에만 파라미터밸류스로 
		String paths = "";
		if(path != null)
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
		memberDAO.memberUpdate(member);
		
		
		response.sendRedirect(request.getContextPath()+ "/MemberUpdate.do");
	}

}
