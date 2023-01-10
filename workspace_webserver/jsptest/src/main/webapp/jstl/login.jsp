<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginage.jsp">
		이름입력 : <input type="text" name = "name" ><br>
		<!-- pattern="[구성요소]{개수}" -->
		나이입력 : <input type="text" name = "age" pattern="[0-9]{1,2,3}" required="required"><br>
		<input type="submit" value="성인인증">
	</form>
</body>
</html>