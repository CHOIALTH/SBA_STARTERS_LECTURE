<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="e.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String menu[] = {"회원관리","게시판관리","쇼핑몰관리","챗봇관리"};
	int index = Integer.parseInt(request.getParameter("menu"));
%>
<h1>선택한 메뉴이름 = <%=menu[index]%></h1>
</body>
</html>