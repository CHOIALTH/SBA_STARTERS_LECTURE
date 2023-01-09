<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- member --- forward --- request.getParameter -->
	<jsp:useBean id="dto" class = "dto.MemberDTO"/>
	<jsp:setProperty property="*" name="dto"/>
	<jsp:useBean id="dao" class="dao.MemberDAO" scope="request"/>
	<%-- <%MemberDAO dao = new MemberDAO(); %> 위 문장과 같은 역할 --%> 
	<%
	int result = dao.insertMember(dto);
	if(result == 1){
		out.println("<h1>회원가입 처리되었습니다</h1>");
	}
	%>
</body>
</html>