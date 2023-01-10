<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scopetest2.jsp 화면 입니다</h1>
<%-- 	jsp a출력 = <%=pageContext.getAttribute("a") %><br>
	jsp a2출력 = <%=request.getAttribute("a2") %><br>
	jsp a3출력 = <%=session.getAttribute("a3") %><br>
	jsp a4출력 = <%=application.getAttribute("a4") %><br>
	 --%>
<%-- 	el a출력 = ${a }<br>
	el a2출력 = ${a2 }<br>
	el a3출력 = ${a3 }<br>
	el a4출력 = ${a4 }<br> --%>
	
	jsp a출력(pageContext) = <%=pageContext.getAttribute("a") %><br>
	jsp a출력(request) = <%=request.getAttribute("a") %><br>
	jsp a출력(session) = <%=session.getAttribute("a") %><br>
	jsp a출력(application) = <%=application.getAttribute("a") %><br>
	
	el a 출력(현재페이지의 jsp 태그 전달값) = ${pageScope.a }<br>
	el a 출력(이동 전의 jsp 태그 전달값) = ${requestScope.a }<br>
	el a 출력(세션 전달값) = ${sessionScope.a }<br>
	el a 출력(어플리케이션 전달값) = ${applicationScope.a }<br>
	
	<!-- 이때 contextPath 소문자로 시작  -->
	el 컨텍스트명 출력 = ${pageContext.request.contextPath }<br>
	el jsp명 출력 = ${pageContext.request.requestURI }<br>
	<%-- <% request.getContextPath(); %> --%>
	<!-- e1 전달변수 출력
	1. pageScope 찾는다 2. requestScope 3. sessionScope 4. applicationScope -->
	
</body>
</html>