<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판 수정</title>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>

	<h3>수정하기</h3>
	<form action="/mol/BoardUpdate.do" method="post" >
	<input name="seq" value="${vo.seq}" type="hidden"/>
	작성자: <input id="id" name="id" value="${vo.id}"><br/>
	제목: <input id="title" name="title" value="${vo.title}"><br/>
	추천취미: <input id="recommend" name="recommend" value="${vo.recommend}"><br/>
	추천이유:<br><br>
	 <textarea cols="30" row="10" id="reason" name="reason">${vo.reason}</textarea><br/>


	<button>수정완료</button>
	<a href="BoardDelete.do">삭제</a>
		
	</form>

	<%@include file="/common/footer.jsp"%>

</body>
</html>