<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전체 회원 정보를 가져옵니다. </h1>
<c:forEach items="${memberlist }" var="member">
${member.id } : ${member.pw } :${member.name } : ${member.address } <br> 
</c:forEach>
</body>
</html>