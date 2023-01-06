<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단output</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script><!-- request.getContextPath가 / 가져오므로 <%%> 앞의 / 생략  -->
<script>
$(document).ready(function(){
	//홀수줄 - 바탕색상 pink
	//짝수줄 - 바탕색상 silver
	// even : 홀수 (첫번째를 0번 인덱스로 가져가므로)
	$('tr:even')	.css("background-color", "pink");
	// odd : 짝수 (첫번째를 0번 인덱스로 가져가므로)
	$('tr:odd')	.css("background-color", "silver");
	
});
</script>
<style>
	table{
		margin : auto;
	}
	td, table{
		border : 2px solid blue;
	}
</style>
</head>
<body>
<h1> 구구단을 출력합니다. </h1>
	<%
		// get / post 방식 동일 로직 처리
	if(request.getMethod().equals("GET") && request.getParameter("id").equals("admin")){
		String start2 = request.getParameter("start");
		String end2 = request.getParameter("end");
		int start= 0, end = 0;
		
		if(start2 != null && !start2.equals("")){
		start = Integer.parseInt(start2);
		}
		if(end2 != null && !end2.equals("")){
			end = Integer.parseInt(end2);			
		}
		
	%>
		<table border = 1>
		<% for(int j = 1; j <= 9; j++){ %>
			<tr>
			<% for(int i = start; i <= end; i ++){ %>
				<td><%=i%> * <%=j%> = <%=i*j%></td>
			<%}%>
			</tr>
		<%}%>
		</table>
	<%
	}
	else {
	%>
		<h3>post방식은 지원하지 않습니다.</h3>
	<%}%>
	<h1><a href="input.jsp">구구단입력하기</a></h1>
	

</body>
</html>