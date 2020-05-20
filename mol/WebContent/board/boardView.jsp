<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 단건조회 view페이지</title>
</head>
<body>

	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>	
	<form action="/mol/BoardView.do" method="get" >
	<input type="hidden" name="seq" value="${vo.seq}">
		작성자: <span id="id">${vo.id}</span><br><br>
		제목: <span id="title">${vo.title}</span><br><br>
		추천취미: <span id="recommend">${vo.recommend}</span><br><br>
		추천이유 <br><br>
		<span id="reason">${vo.reason}</span><br><br><br>
	
	<c:if test="${loginId == vo.id}">
	<a href="BoardUpdate.do?seq=${vo.seq}">수정</a>
	</c:if>
	</form>
	
	<a href="BoardLike.do">추천</a>
	
	<%@include file="/common/footer.jsp"%>

</body>
</html>