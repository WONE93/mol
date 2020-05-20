<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #0e0e0e;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
<%String contextPath = getServletContext().getContextPath(); %>
<body>
	<ul>
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