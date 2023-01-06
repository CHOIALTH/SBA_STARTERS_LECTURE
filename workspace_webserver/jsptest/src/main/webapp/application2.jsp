<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDTO dto = (MemberDTO)application.getAttribute("appdto");
	
%>
전달 아이디 : <h1><%=dto.getId()%></h1>
전달 PW : <h1><%=dto.getPw()%></h1>
전달 이름 : <h1><%=dto.getName()%></h1>
	
	
</body>
</html>