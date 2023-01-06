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
	String msg = "콘솔출력";  
	// 여기서 msg 는 지역변수
	//jsp 서블릿 변환시 _jspService() 문장 간주
	//jsp 서블릿 변환시 _jspService()의 지역변수 간주
	System.out.println(msg);
%>
<%! // 선언문 사용하는 형식 (선언문 : JSP에서 변수/메서드 선언할 때 사용)
	String msg2 = "멤버변수";
	int multiply(int a, int b){
	System.out.println(msg2 + ":" + a*b);
	return a*b;
	}
%>
<%
	multiply(10, 30);
%>
<%=
	multiply(10, 30)
%>

</body>
</html>