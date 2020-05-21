<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시판 단건조회 view페이지</title>
<script>

	function commentShow() {
		if (list.style.display == "") {
			list.style.display = "none"
		} else {
			list.style.display = ""
		}

	}
	

</script>
</head>
<body>

	<%@include file="/common/menu.jsp"%>
	<jsp:include page="/common/header.jsp"/>	
	<form action="/mol/BoardView.do" method="get" class="cm_boardview">
	<input type="hidden" name="seq" value="${vo.seq}">
		<table border="1" width="100%" height="200px">
		<tr><td colspan="2" style=text-align:center;>
		<h3>세부내용</h3>
		</td></tr>
		<tr><td style="width:30%;text-align: center;" >작성자</td> <td style="width:70%"><span id="id">${vo.id}</span></td></tr>
		<tr><td style="text-align: center;">제목</td> <td><span id="title"> ${vo.title}</span></td></tr>
		<tr><td style="text-align: center;">추천취미</td> <td><span id="recommend">  ${vo.recommend}</span></td></tr>
		<tr><td style="text-align: center;">추천이유</td> <td><span id="reason"> ${vo.reason}</span></td></tr>
	
		</table><br><br>
	
	<c:if test="${loginId == vo.id}"> 
	<a href="BoardUpdate.do?seq=${vo.seq}">수정하기</a>
	</c:if>
	

	<br><br>
	
	<button type="button" onclick="commentShow()">댓글열기</button> <br><br>


	<table id="list" style="display:none" class="cm_list" border="1">
		<tr><th style="width:30%">작성자</th><th style="width:70%">댓글</th></tr>
		<c:forEach items="${list}" var="vo">
		
			<tr >	
				<td>${vo.id}</td>
				<td>${vo.comments}</td>
			
			</tr>

		</c:forEach>
	</table>	
	
	</form>
	
	<form name="co" action="CommentsInsert.do">
	<input name="bseq" value="${vo.seq}" type="hidden"/>
	<table class="cm_view" >
		<tr><th >ID</th><th >댓글쓰기</th></tr> <br><br>
		<tr>
		<td ><span id="id2">${loginId}</span></td>
		<td ><textarea cols="60" rows="2"  name="comments" id="comments"></textarea></td>
		<td><button onaction="commentsCheck()">등록</button></td>
		</tr> 	
	</table>
	</form>
	
	<%@include file="/common/footer.jsp"%>

</body>
</html>