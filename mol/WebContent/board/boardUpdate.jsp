<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판 수정</title>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>
	
	<table border="1" width="80%">
	<tr><td style=text-align:center>
	<h3>수정하기</h3>
	</td></tr> 
	<form action="/mol/BoardUpdate.do" method="post" >
	<input name="seq" value="${vo.seq}" type="hidden"/>
	<td>
	작성자<br> <input style=width:100%; id="id" name="id" value="${vo.id}">
	<br> 
	제목<br> <input style=width:100%; id="title" name="title" value="${vo.title}">
	
	<br>
	추천취미<br> <input style=width:100%; id="recommend" name="recommend" value="${vo.recommend}">
	<br>
	추천이유<br>
	 <textarea style=width:100%; cols="30" row="10" id="reason" name="reason">${vo.reason}</textarea><br/>
	</td>
	</table>
	<br><br>
	<button>수정</button><br>

	<a href="BoardDelete.do?seq=${vo.seq}">삭제</a>
		
	</form>

	<%@include file="/common/footer.jsp"%>

</body>
</html>