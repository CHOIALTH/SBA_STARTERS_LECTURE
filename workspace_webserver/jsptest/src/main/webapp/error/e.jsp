<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>404 Error</h1>
	<h1>=====오류발생파일명=====</h1>
	<%=request.getAttribute("file") %> 에서 문제가 발생했습니다!
	<!-- exception 내장객체 - 오류정보객체 -->
	<h1>=====toString=====</h1>
	<%=exception %>
	<h1>=====getMessage=====</h1>
	<%=exception.getMessage() %>
	<h1>=====printStackTrace(콘솔)=====</h1>
	<% exception.printStackTrace(); %>
</body>
</html>