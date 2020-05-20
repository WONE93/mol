<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 목록보기(리스트)</title>
</head>
<body>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>	
	
		<h3>게시판</h3>
	<c:if test="${loginId != null}">
		<a href="BoardInsert.do">게시글등록</a>
	</c:if>
	<table border="1">
		<tr><th>제목</th><th>작성자</th><th>추천수</th><th>작성 일자</th></tr>
		<c:forEach items="${list}" var="vo">
			<tr>
			<td><a href="BoardView.do?seq=${vo.seq}">${vo.title}</a></td>								
			<td>${vo.name}</td>
			<td>${vo.love}</td>
			<td>${vo.regdt}</td></tr>

		</c:forEach>
	</table>
	
	<%@include file="/common/footer.jsp"%>
	
</body>
</html>