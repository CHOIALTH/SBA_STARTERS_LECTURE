<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${param.page } 페이지의 게시물 출력</h1>

<table border=3>
	<c:forEach items="${list }" var = "board"> <!-- list라는 이름의 모델 -->
		<tr><td>${board.seq }</td><td><a href="oneboard?seq=${board.seq }">${board.title }</a></td><td>${board.writer }</td></tr>
	</c:forEach>
</table>
<% 
	int totalcount = (Integer)request.getAttribute("totalboard"); /* totalboard라는 이름의 모델 */
	int totalpage = 0;
	if(totalcount % 3 == 0){
		totalpage = totalcount / 3;
	}
	else{
		totalpage = totalcount / 3 + 1;
	}
	for(int i = 1; i <= totalpage; i++){
	%>
	<a href = "boardlist?page=<%=i %>"><%=i %>페이지</a>	
	<%}%>
<input type=button id="writebtn" value = "글쓰기">
<script src = "js/jquery-3.6.1.min.js"></script>
<script>
	$("#writebtn").on('click', function(){
		location.href = "insertboard"; //get방식
	})
</script>
</body>
</html>








