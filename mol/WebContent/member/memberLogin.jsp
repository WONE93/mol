<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인페이지</title>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>

	<h3 style="text-align: center">로그인</h3>
	
	<div>${errorMsg}</div>
	<form action="/mol/MemberLogin.do" method="post" class="cm_login">
		
		<input class="input_login" name="id" placeholder="id" value="${param.id}"><br> 
		<input class="input_login" name="pwd" placeholder="pwd" value="${param.pwd}"><br><br><br>
		<button>로그인</button>
	</form>

	<%@include file="/common/footer.jsp"%>

</body>
</html>