<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginform</title>
</head>
<body>
	<h1>로그인 화면입니다.</h1>
	<%
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember("sql", "sql");
		request.setAttribute("member", dto);
	%>
	<jsp:include page="bottom.jsp">
		<jsp:param value="jsp" name="id"/> 
		<jsp:param value="<%=request.getRequestURI()%>" name="filename"/>
	</jsp:include> 
	<%-- <jsp:include page="bottom.jsp"/> <!-- 다른 태그 포함하지 않을때  -->	 --%>


</body>
</html>