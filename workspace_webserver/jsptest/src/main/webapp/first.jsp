<!--jsp 시작한다는 증거  -->
<%@page import=
"java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>spring 회원님 환영합니다!</h1>	
	<% System.out.println("jsp 처음 배워봅니다"); %>
	<% 
	String id = request.getParameter("id"); 
	Date now = new Date();
	%>
	<h1><%=id %>회원님(로그인시각 <%=now %>) 환영합니다!</h1>
	
</body>
</html>