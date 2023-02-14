<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	$("a").on('click', function(event){
		event.preventDefault();
		alert($(this).attr("id") );
		$.ajax({
			url:'othermemberinform',
			data :{'id': $(this).attr("id")},
			type : 'get',
			dataType : "json",
			success:function(response){
				$("#inform").html(response.id+"<br>");
				$("#inform").append(response.name+"<br>");
				$("#inform").append(response.address+"<br>");
				//if()
				$("#inform").append("<img src='/upload/" + response.image + "'><br>");
				
			}
		});
	});
});
</script>
</head>
<body>
<h1>전체 회원 정보를 가져옵니다. </h1>
<c:forEach items="${memberlist }" var="member">
${member.id } : ${member.pw }:<a id="${member.id }" href=""> ${member.name } </a> : ${member.address } <br> 
</c:forEach>

<h1 id="inform"></h1>
</body>
</html>




