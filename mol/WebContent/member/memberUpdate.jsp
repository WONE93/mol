<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보수정</title>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>
	
	<table border="1" width="80%">
	<form  name="frm" action="/mol/MemberUpdate.do" method="post" class="cm_mupdate">
	<tr><td>
	<h3 style="text-align: center">회원 정보 수정</h3></td></tr>
	<td>
	ID <br> 
	<input style=width:100% type="text" name="id" readonly="readonly" value="${member.id}" /><br /> 
	비밀번호 <br>
	<input style=width:100% type="password" name="pwd" id="pwd" value="${member.pwd}" /><br /> 
	
	이름<br> 
	<input style=width:100% type="text" name="name" id="name" value="${member.name}" /><br /> 
		
	성별: 
		<input type="radio" name="gender" value="m" />남자
		<input type="radio" name="gender" value="f" />여자</br> <br>
		
	가입경로: 
		<input type="checkbox" name="path" value="p01" />인터넷
		<input type="checkbox" name="path" value="p02" />지인소개
		<input type="checkbox" name="path" value="p03" />기타<br> <br>
		
	자기소개<br/>
	<textarea style=width:100% cols="40" rows="5" name="introduction" id="introduction">${member.introduction}</textarea> <br><br>
	</td></table> <br><br>
	
	 <input type="submit" value="정보수정" />

</form>
	<%@include file="/common/footer.jsp"%>

</body>
</html>