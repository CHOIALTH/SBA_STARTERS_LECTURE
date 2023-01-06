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
	int count = 0;
	//서버 시작 후 최초 요청
	if(application.getAttribute("count") == null){
		count = 1;		
		application.setAttribute("count", 1);
	}
	else{
		// application.getAttribute만 작성 시 리턴타입 : obj! 
		count = (int)application.getAttribute("count") + 1;
		application.setAttribute("count", count);
	}

%>
<h1>서버 시작 후 <%=count %>번째 방문자입니다.</h1>
</body>
</html>