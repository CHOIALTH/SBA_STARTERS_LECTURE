<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // jsp에서 태그 값 정의하고 -- el로 출력 가능
	String b = "jsp만의 변수";
	pageContext.setAttribute("a", "pageContext공유");
	request.setAttribute("a2", "request공유");
	session.setAttribute("a3", "session공유");
	application.setAttribute("a4", "application공유");
	%>
	<%-- jsp b출력 = <%=b %><br> --%>
	jsp a출력(pageContext) = <%=pageContext.getAttribute("a") %><br>
<%-- 	jsp a2출력 = <%=request.getAttribute("a2") %><br>
	jsp a3출력 = <%=session.getAttribute("a3") %><br>
	jsp a4출력 = <%=application.getAttribute("a4") %><br> --%>
	jsp a출력(request) = <%=request.getAttribute("a") %><br>
	jsp a출력(session) = <%=session.getAttribute("a") %><br>
	jsp a출력(application) = <%=application.getAttribute("a") %><br>
	
	<%-- el b출력 = ${b }<br> --%> <!-- 출력X. 없는 변수 취급받는다.  -->
	el a출력 = ${a }<br>
	el a출력 = ${a }<br>
	el a출력 = ${a}<br>
	el a출력 = ${a }<br>
	<%=request.getContextPath() %>
	<a href="${pageContext.request.contextPath }/el/scopetest2.jsp">링크이동</a>	 <!-- = /jsptest/el/scoptest2.jsp  -->
	<%-- <jsp:forward page="/scopetest2.jsp"/> --%> <!-- /el/scopetest2.jsp -->  <!-- 서로 맨 앞의 슬래시 의미 다름  -->
	
	
</body>
</html>