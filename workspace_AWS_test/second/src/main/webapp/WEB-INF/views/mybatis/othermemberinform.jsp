<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> ${otherinform.name } 님의 정보입니다. (관리자만 허용)</h1>
<h3>아이디 : ${otherinform.id  }</h3>
<h3>이메일 : ${otherinform.email  }</h3>
<h3>폰 : ${otherinform.phone  }</h3>
<h3>주소 : ${otherinform.address  }</h3>
<h3>사진 : <img src="/upload/${otherinform.image  }" ></h3>
<script>
alert('${updateresult }');
</script>
</body>

</html>

<!-- 
1>일반사용자
2>관리자 id - 소수개 미리 정해놓자
            db member 테이블 role 추가 - admin/user

spring security role 규정
1>관리자--:화면뷰
2>성인사용자
3>미성년사용자
4>손님
 -->
            
             




