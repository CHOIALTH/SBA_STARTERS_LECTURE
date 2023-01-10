<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${param.id} 회원님</h1>
	${param.pw} 암호를 입력하셨습니다.
	<h2>점심주문 목록은</h2>
	<!-- el은 반복문이 없다. 따라서 데이터가 몇번 index까지 있는지 확인하기 어려움  -->
	${!empty paramValues.lunch[0]? paramValues.lunch[0]:"없음"}<br>
	${paramValues.lunch[1]}<br>
	${paramValues.lunch[2]}<br>  
	${paramValues.lunch[3]}<br>  
	${!empty paramValues.lunch[4]? paramValues.lunch[4]:"없음"}<br>  
	입니다.
	<!-- select문의 경우, name을 설정했을때.. option 중 무언가 선택하는 순간 선택된 첫번째가 0번인덱스에 담김  -->
	<!-- 따라서 위 경우 한식이 바로 lunch[0]인게 아님..  -->
	<!--  -->	
</body>
</html>