<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="" >
<table border=3>
<tr><td>게시물번호</td><td><input type=text value="${oneboard.seq}" readonly ></td></tr>
<tr><td>게시물제목</td><td><input type=text value="${oneboard.title}"  ></td></tr>
<tr><td>게시물내용</td><td><textarea cols=50  rows=5 >${oneboard.contents}</textarea></td></tr>
<tr><td>게시물작성자</td><td><input type=text value="${oneboard.writer}" readonly ></td></tr>
<tr><td>게시물조회수</td><td><input type=text value="${oneboard.viewcount}" readonly ></td></tr>
<tr><td><input type=submit value="수정버튼"> </td><td><input type=submit value="삭제버튼"></td></tr>
</table>
</form>

</body>
</html>