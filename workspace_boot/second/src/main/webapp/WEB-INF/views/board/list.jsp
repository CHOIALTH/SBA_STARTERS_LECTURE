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

<table>
	<c:forEach items="${list }" var = "board">
		<tr><td>${board.seq }</td><td>${board.title }</td><td>${board.writer }</td></tr>
	</c:forEach>
</table>
<% 
	int totalcount = (Integer)request.getAttribute("totalboard"); 
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
${totalcount }
</body>
</html>