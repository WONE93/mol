<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 등록</title>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>
	
	<h3>게시판</h3>
	<form action="BoardInsert.do" method="post" >
	작성자 : <input type="text" name="id"  value= "${loginId}"><br/>								
	제목 : <input type ="text" name="title" id="title"/><br/>
	추천취미: <input type="textarea" name="recommend" id="recommend"/><br/>
	추천이유<br><br>
	<textarea cols="40" rows="5" name="reason" id="reason"></textarea><br><br>
	 
		
		<input type="submit" value="저장" />

</form>
	
		
	<%@include file="/common/footer.jsp"%>
</body>
</html>