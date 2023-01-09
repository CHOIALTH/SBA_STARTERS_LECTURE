<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>\
	<h1>회원가입 폼</h1>
	<form action="beansession1.jsp"> <!-- form태그의 기본 method : GET방식-->
		아이디:<input type=text name="id" ><br>
		암호:<input type=password name="pw" ><br>
		이름:<input type=text name="name" ><br>
		폰:<input type=tel name="phone" ><br>
		이메일:<input type=email name="email" ><br>
		<input type=submit value="가입" ><br>
	</form>
</body>
</html>