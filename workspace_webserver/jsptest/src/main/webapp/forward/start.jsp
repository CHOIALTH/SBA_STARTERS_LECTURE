<%@page import="java.net.URLEncoder"%>
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
	String id = request.getParameter("id");
	String filename = "";
	String menu[] = null;
	if(id != null){
		if(id.equals("admin")|| id.equals("administrator")){
			filename = "admin.jsp";
			menu = new String[3]; /* 3칸짜리 배열  */
			menu[0] = "모든사용자조회";
			menu[1] = "회원강제탈퇴";
			menu[2] = "상품관리";
		}	
		else{
			filename = "user.jsp";
			menu = new String[4]; /* 4칸짜리 배열  */
			menu[0] = "회원가입";
			menu[1] = "상품구입";
			menu[2] = "결제";
			menu[3] = "장바구니조회";
		}
		request.setAttribute("menu", menu);
	}
	else{
		filename = "none.jsp";
		out.println("<h1>아이디를 입력해주세요</h1>");
	}
	%>
	<!-- forward 특징 : forward 전에 써놓은 출력도 무시된다  -->
<jsp:forward page="<%=filename%>">
	<jsp:param value="<%=URLEncoder.encode(\"홍길동\")%>" name="username" />
</jsp:forward>




</body>
</html>