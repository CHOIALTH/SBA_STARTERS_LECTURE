<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bottom.jsp</title>
</head>
<body>
	<img src = "../images/html5.jpg"> <!-- 상대경로.  -->
	<img src = "<%=request.getContextPath() %>/images/html5.jpg">  <!-- 절대경로. 위와 같은 경로임 -->
	<h3>연락처 - 이메일로 문의하세요</h3>
	<h3>오시는 길 - 서울시 용산구 전자월드 3층</h3>
	<% if(request.getParameter("id")!= null){%>
		<h1><%=request.getParameter("id") %></h1><!-- id란 이름의 parameter를 전달받음(value="jsp") -->
	<%}%>
	<h1><%=request.getParameter("filename") %></h1>
	<% if(request.getAttribute("member") != null){ %>
		<%=request.getAttribute("member") %> <!--이 경우 .toString()은 안붙여도 자동으로 적용됨  -->
	<%}%>
	
</body>
</html>