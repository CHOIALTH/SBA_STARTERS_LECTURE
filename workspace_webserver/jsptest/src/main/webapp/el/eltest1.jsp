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
	if(request.getParameter("name") != null){%>
	<h1><%=request.getParameter("name") %></h1>
	<%}%>
	<!-- 해석 : param.name이 empty가 아닙니까? true : length()리턴 / false : "없다" 리턴 이상 삼항(조건)연산자 -->
	<h1>${!empty param.name? param.name.length() : "없다"}</h1>
	
	<h1>표현 언어에서 데이터 출력하기</h1>
	<h1>${null}</h1> <!-- el의 null은 무시되어 화면에서 출력되지 않음  -->
	<h1>${100}</h1>
	<h1>\${100}의 결과는 ${100}</h1>
	<h1>${100.1}</h1>
	<h1>${true}</h1>
	<h1>${"베츠"}</h1>
	<%-- <h1>${"무키" +"베츠"}</h1> 오류 출력--%>
	<%-- <h1>${"보가츠 " +2}</h1> 오류 출력--%>
	<h1>${"무키"+=" 베츠"}</h1>
	<h1>${100 + 100}</h1>
	<h1>${requestScope.dto}</h1>
	<h1>${sessionScope.dto}</h1>
	<h1>${applicationScope.dto}</h1>
	
</body>
</html>