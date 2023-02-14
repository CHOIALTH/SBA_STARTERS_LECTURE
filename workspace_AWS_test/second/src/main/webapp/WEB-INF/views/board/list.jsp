<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>${param.page } 페이지의 게시물 출력</H1>

<table border=3>
<tr><th>번호</th><th>제목</th><th>작성자</th>
<c:forEach items="${list }" var="board">
<tr><td>${board.seq }</td><td><a href="oneboard?seq=${board.seq }">${board.title }</a></td><td>${board.writer }</td></tr>
</c:forEach>
</table>
<% int totalcount = (Integer)request.getAttribute("totalboard"); 
 int totalpage = 0;
 if(totalcount % 3 == 0){
	 totalpage = totalcount / 3;
 }
 else{
	 totalpage = totalcount / 3 + 1;
 }
for(int i = 1; i <= totalpage; i++){
%>
  <a href="boardlist?page=<%=i %>"><%=i %>페이지 </a>	
<%
}
%>

<input type=button id="writebtn" value="글쓰기">
<script src="js/jquery-3.6.1.min.js"></script>
<script>
 $("#writebtn").on('click', function(){
	 location.href="insertboard";//get
 });

</script>
</body>
</html>



