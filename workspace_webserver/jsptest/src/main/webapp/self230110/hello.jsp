<%-- 페이지 디렉티브 태그 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 태그 라이브 디렉티브 태그 --%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 선언문(jsp 페이지에서 사용하는 멤버변수나 멤버메서드 선언시 사용) --%>
<%!
String hello = "안녕하세요";
public String hi(){
	return hello;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js" ></script>
<script>
$(document).ready(function(){

});

</script>

</head>
<body>
	<!-- 이건 html 주석문 : html주석문도 브라우저에 전달됨--> 
	// 이건 java 주석문
	/* 이것도 java 주석문 */ : java 주석문은 서블릿으로 변환시 java 주석문으로 표시됨 
	<%-- 이건 jsp 주석문 : jsp 자체의 주석문이기 때문에 서블릿 코드로 변환되지도, 브라우저에 전달되지도 않음 --%>
	
	<%-- <%%>를 스크립트릿(scriptlet)이라 부른다 --%>
	<%-- 인클루드 디렉티브 태그 --%>
	<%@ include file = "hello2.jsp" %><br>
	<jsp:include page="hello2.jsp"/><br>
	<h1>자 지금부터 jsp 개인공부를 시작해보지~~</h1>
	<h1>모두들 <%=hello %>!!</h1>
	
</body>
</html>

