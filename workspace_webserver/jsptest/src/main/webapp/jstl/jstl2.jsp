<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!-- url 생성-->
	<c:url var="mypage" value="http://localhost:8081/jsptest/jstl/loginage.jsp"/>
	<%-- <c:url var="mypage" value="http://www.google.com"/> --%>
	<!-- forward -->
<%-- 	<c:redirect url="${mypage }">
		<c:param name="name" value="김하성"></c:param>
		<c:param name="age" value="29"></c:param>
	</c:redirect> --%>
	
	<!-- jsp:include -->
	<c:import url="${mypage }">
		<c:param name="name" value="김하성"></c:param>
		<c:param name="age" value="29"></c:param>
	</c:import>
	<h1>import한 직후 입니다</h1>
</body>
</html>

