<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입페이지</title>
<script>
function validCheck(){
	//필수입력 체크
	if( frm.id.value == "" ) {	//trim함수
		alert("id 입력");
		frm.id.focus();
		return;
	}
	if( frm.pwd.value == "" ) {	
		alert("pwd 입력");
		frm.pwd.focus();
		return;
	}
	//체크박스 (적어도 하나이상 선택이 되었는지췤) ->여러개 선택가능
/*	hobby = document.getElementsByName("hobby"); //넘겨받는 값은 배열임 엘리먼트는 id만 단수!!
	var cnt=0;
	for(i=0; i<hobby.length; i++) {
		if(hobby[i].checked == true) {
			cnt++;
		}
	} */
	var cnt = document.querySelectorAll("[name=path]:checked");
	if(cnt == 0){
		alert("가입경로 적어도 1개 선택");
		return;
	}

	frm.submit(); // 아무 이상없이 밑에까지 내려온다면 제출! 
	
	//성별(라디오)
//	gender = document.
	
	//종교(option select)
	
}
</script>
	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>	
	<table width="80%"  border="1">
	<tr><td>
	<h3 style="text-align: center">회원가입신청</h3> </td></tr>
	<form  name="frm" action="/mol/MemberInsert.do" method="post" class="form_minsert">
	<!-- 여기서 ../안쓰면 member/memberIndert.do 부르는 거랑 같음 -->
	<tr>
	<td>ID <br> <input style=width:100%; type="text" name="id" /><br /> 
	비밀번호 <br>  <input style="width:100%;  type="password" name="pwd" id="pwd" /><br /> 
	이름<br> <input style="width:100%;  type="text" name="name" id="name" /><br /> 
		
		성별: 
		<input  type="radio" name="gender" value="m" />남자
		<input type="radio" name="gender" value="f" />여자</br> 
		
		가입경로: 
		<input type="checkbox" name="path" value="p01" />인터넷
		<input  type="checkbox" name="path" value="p02" />지인소개
		<input  type="checkbox" name="path" value="p03" />기타<br> 

	
		
		
		자기소개<br/>
	<textarea style="width:100%;  cols="40" rows="5" name="introduction" id="introduction"></textarea> <br><br>
	</td></tr>
	
	<table width="50%">
	<tr><td>	
	<button type="button" onclick="validCheck()">회원가입</button>  
	</td></tr>
	</table>
</table>

</form>
	
	<%@include file="/common/footer.jsp"%>

</body>
</html>