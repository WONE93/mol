<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 목록보기(리스트)</title>
</head>
<body>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>	
	
	<c:if test="${loginId != null}">
		<a href="BoardInsert.do">게시글등록</a>
	</c:if>
	<br><br>
	<form name="searchfrm" style=text-align:center;> 
		<input name="p" value="1" type="hidden">
			id:<input id="id" name="id">
			<button >검색</button>
	</form> <br><br>
	
	<table width="80%"  border="1" class="cm_boardlist">
	<tr><td colspan="3">
		<h3>게시판</h3>
	</td></tr>
		<tr><th style=width:30%;>제목</th><th style=width:30%;>작성자</th><th style=width:30%;>작성 일자</th></tr>
		<c:forEach items="${list}" var="vo">
			<tr>
			<td><a href="BoardView.do?seq=${vo.seq}">${vo.title}</a></td>								
			<td>${vo.name}</td>		
			<td>${vo.regdt}</td></tr>

		</c:forEach>
	</table>
			<script>
		function gopage(p) {
			document.searchfrm.p.value = p;
			document.searchfrm.submit();	
		}
		</script>
		
		<my:paging paging="${paging}" jsfunc="gopage"/>
		
	<%@include file="/common/footer.jsp"%>
	
</body>
</html>