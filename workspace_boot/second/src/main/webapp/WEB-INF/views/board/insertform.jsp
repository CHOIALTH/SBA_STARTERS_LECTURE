<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기 폼</h1>
	<form action="insertboard" method="post">
		제목 : <input type = text name = "title"><br>
		내용 : <textarea rows="" cols=""></textarea><br>
		작성자 : <input type = text name = "writer">
	</form>
</body>
</html>