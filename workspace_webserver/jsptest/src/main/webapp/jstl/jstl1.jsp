<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% String jspname = "홍길동"; %>
	<c:set var = "id" value = "jstl" scope = "request"/>
	<c:set var = "pw" value = "1111"/>
	<c:set var = "name" value = "<%=jspname %>"/>
	<c:set var = "result" value = "${pw + 100 }"/>
	<h1>${id }</h1>
	<h1>${pw }</h1>
	<h1>${name }</h1>
	<h1>${result }</h1>
	
	<c:set var = "clientip" value="${pageContext.request.remoteAddr }"/>
	<c:set var = "clientfile" value="${pageContext.request.requestURI }"/>
	
	<h1>클라이언트ip = ${clientip } : <c:out value="${clientip }"/></h1>
	<h1>클라이언트요청파일명 = ${clientfile }</h1>
	
	<c:remove var="clientip"/>
	<c:remove var="clientfile"/>
	
	<c:if test="${empty clientip}">
		<h1>클라이언트ip변수는 삭제됐습니다</h1>
	</c:if>
	<c:if test="${!empty clientip}">
		<h1>클라이언트ip = ${clientip }</h1>
	</c:if>
	<c:if test="${empty clientfile}">
		<h1>클라이언트요청파일명변수는 삭제됐습니다</h1>
	</c:if>
	<c:if test="${!empty clientfile}">
		<h1>클라이언트ip = ${clientfile }</h1>
	</c:if>
	<!-- java에서 switch-case문 역할을 대체는건 = ? -->
	
	<%-- <c:set var="sum" value="${100+200 }"/> --%>
	<c:set var="sum" value="${param.num1 + param.num2 }"/>
	<c:choose>
		<c:when test="${sum >= 200 }">
			<h1>200 이상으로 최상급임</h1>
		</c:when>
		<c:when test="${sum >= 100 }">
			<h1>100 이상으로 중상급임</h1>
		</c:when>
		<c:when test="${sum >= 50 }">
			<h1>50 이상으로 중하급임</h1>
		</c:when>	
		<c:otherwise>
			<h1>등급이 없음</h1>
		</c:otherwise>
	</c:choose>
	
	
	
	
</body>
</html>