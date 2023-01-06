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
	MemberDTO dto = (MemberDTO)request.getAttribute("dto");
	
%>
<h1><%=dto.getId() %></h1>
<h1><%=dto.getPw() %></h1>
<h1><%=dto.getName() %></h1>
	
	
</body>
</html>