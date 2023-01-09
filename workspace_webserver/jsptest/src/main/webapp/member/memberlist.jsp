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
	<jsp:useBean id = "memberlist" class = "java.util.ArrayList" scope = "request"/>
	<% 
	for(Object o : memberlist){
		MemberDTO dto = (MemberDTO)o;
		out.println("<h2>" + dto.getId() + ":" + dto.getName() + ":" + dto.getAddress() + ":" + dto.getIndate() + "</h2>");
	} 
	%>
</body>
</html>