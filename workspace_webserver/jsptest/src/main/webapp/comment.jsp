<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
<script src="jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	
})
</script>
(html식 주석)
 -->
</head>
<body>
	<%String msg = "지역변수"; //_jspService 내부에 포함됨 (java식 주석) %>
	<%=msg %>
	<%--<%=msg%> (jsp식 주석) --%> 
	<%=msg %>



</body>
</html>