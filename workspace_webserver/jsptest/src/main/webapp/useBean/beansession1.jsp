<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:useBean id="dto" class="dto.MemberDTO" scope="session"/>
	<jsp:setProperty property="*" name="dto"/><!-- dto.setxxxx(request.getParametner("xxxx")) -->
	<%-- <jsp:forward page="beanrequest2.jsp"/> --%> <!-- 세션에 저장시 forward 사용할 필요 없음!  -->

</body>
</html>