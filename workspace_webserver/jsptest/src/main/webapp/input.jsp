<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단input</title>
<!-- <script src="http://localhost:8081/jsptest/js/jquery-3.6.1.min.js"></script>
<script src="/jsptest/js/jquery-3.6.1.min.js"></script>
<script src="js/jquery-3.6.1.min.js"></script> --> <!-- / 없이 쓰면, 현재 input.jsp가 놓인 폴더부터 시작 -->
<script src="<%=request.getContextPath()%>/js/jquery-3.6.1.min.js"></script><!-- request.getContextPath가 / 가져오므로 <%%> 앞의 / 생략  -->


</head>
<body>
	<h1>구구단input창입니다</h1>
	<form action="output.jsp">
		시작단 : <input type = "text" name = "start" value = "2"><br>
		종료단 : <input type = "text" name = "end" value = "9"><br>
		<input type = "text" name = "id" value = <%=request.getParameter("id")%>><br>
		<input type = "submit" value ="구구단출력">
	
<%-- 		<%! 
		void gugu(int num){
			for(int i = 1; i <= 9; i++){
				System.out.printf("%d * %d = %d", num, i, num * i).println();
			}	
		}
		
		%>
		구구단 출력 버튼 : <input type="text" placeholder="2~9사이의 값을 입력하시오"><input type="button" value="계산">
		<% gugu(2); %>
		<% gugu(3); %>
		<% gugu(4); %>
		<% gugu(5); %>
		<% gugu(6); %>
		<% gugu(7); %> --%>
	</form>
</body>
</html>