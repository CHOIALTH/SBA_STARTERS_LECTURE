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
	<jsp:useBean id="dto" class="dto.MemberDTO" scope="request"/>
	<%-- <jsp:setProperty property="id" name="dto" value="<%=request.getParameter("id") %>"/>  --%><!-- dto라는 객체에 포함돼있는 id(property값)를 출력한다. dto.setId()와 같은 역할-->
	<%-- <jsp:setProperty property="id" name="dto" param="id" /> <!-- 위 문장과 같은 역할-->
	<jsp:setProperty property="pw" name="dto" param="password"/> --%>
	<%-- <jsp:setProperty property="name" name="dto" param="name"/> --%>
	<%-- <jsp:setProperty property="name" name="dto" /> <!-- property명과 param명이 같으면 param 생략해도 된다  -->
	<jsp:setProperty property="phone" name="dto" param="phonenumber"/> --%>
	<%-- <jsp:setProperty property="email" name="dto" param="email"/> --%>
	<%-- <jsp:setProperty property="email" name="dto"/> --%>
	<%-- <% MemberDAO().insertMember(dto); %> --%>
	
	<h1> 회원정보를 생성 완료했습니다. 확인해 볼까요?</h1>
	<h3>아이디:<jsp:getProperty name = "dto" property = "id"/></h3>
	<h3>암호:<jsp:getProperty name = "dto" property = "pw"/></h3>
	<h3>이름:<jsp:getProperty name = "dto" property = "name"/></h3>
	<h3>폰:<jsp:getProperty name = "dto" property = "phone"/></h3>
	<h3>이메일:<jsp:getProperty name = "dto" property = "email"/></h3> 
</body>
</html>