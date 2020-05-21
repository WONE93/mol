<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<%String contextPath = getServletContext().getContextPath(); %>
<body>
	<ul class="mm">
		<li><a class="active" href="<%=contextPath%>/main/main.jsp">Home</a></li>
		
		<%
			String loginId = (String)session.getAttribute("loginId");
			if(loginId == null ) { %>
				<li><a href="<%=contextPath%>/member/memberLogin.jsp">로그인</a></li>
				<li><a href="<%=contextPath%>/member/memberInsert.jsp">회원가입</a></li>
		<% }else{ %>
			<li><a href="<%=contextPath%>/MemberLogout.do">로그아웃</a></li>
			<li><a href="<%=contextPath%>/MemberUpdate.do">정보수정</a></li>
			
		<% } %>
		
			<li><a href="<%=contextPath%>/BoardList.do">게시판</a></li>
		

	</ul>
</body>
</html>