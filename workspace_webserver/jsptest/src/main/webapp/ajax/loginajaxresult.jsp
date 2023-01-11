<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<%-- <h1>${param.id } 회원님은 ${param.pw}의 암호를 입력하셨습니다.</h1> --%>
	<%-- id ajax 이고 pw ajax 로그인 성공 /나머지 실패 --%>
	<%
		String logintime = null;
		String result = null;
	%>
	<c:if test="${param.id.equals(\"ajax\")&& param.pw.equals(\"ajax\")}">
	
		<% 
		logintime = new SimpleDateFormat("yyy년MM월dd일 HH시mm분ss초 ").format(new Date()); 
		result = "{\"login\":\"success\" , \"logintime\" :\"" + logintime + "\" }";
		%>
	</c:if>
	<%=result%>

