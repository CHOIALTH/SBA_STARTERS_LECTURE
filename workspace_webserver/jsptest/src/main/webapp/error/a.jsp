<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="e.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	// request.getRequestURI -> a.jsp => a.jsp / b.jsp => b.jsp
	request.setAttribute("file", request.getRequestURI());
%>
<h1>결과 = <%=num %></h1>
</body>
</html>