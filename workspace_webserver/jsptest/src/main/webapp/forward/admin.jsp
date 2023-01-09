<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>admin.jsp 입니다</h1>
	<h2>관리자용 메뉴는 다음과 같습니다</h2>
	<%
		String [] menu = (String[])request.getAttribute("menu"); // from start.jsp
		for(String m : menu){
			out.println("<h3>"+ m +"</h3>");
		}// end enhanced for문
	%>
</body>
</html>