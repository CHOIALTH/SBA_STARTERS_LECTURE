<%@page import="java.util.HashMap"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
	String array[] = {"red", "black","white","green","blue"};
	pageContext.setAttribute("colors", array);
	%>
	<!-- pageScope. 생략해도 됨을 알 수 있다 -->
	${colors[0] } : ${pageScope.colors[0] } : ${colors[0].toUpperCase() }<br>
	<!-- 존재하지 않는 index는 공백으로 출력됨 -->
	${colors[100] } : ${pageScope.colors[100] } : ${colors[100].toUpperCase() }<br> 
	${colors[1] } : ${pageScope.colors[1] } : ${colors[1].toUpperCase() }<br>
	${Integer.parseInt("100") + 100 }<br>
	${"100" + "100" }<br>
	${"100" += "100" }<br>
	
	<!-- 오류출력.. 제너릭으로 <MemberDTO> 출력해도 인식을 못함 -->
	<%-- <jsp:useBean id="list" class="java.util.ArrayList<MemberDTO>"/> --%>
	<jsp:useBean id="list" class="java.util.ArrayList"/>
<%-- 	<%
	ArrayList<MemberDTO> list = new ArrayList();
	%>  위 코드와 같은 역할--%>
	<jsp:useBean id="dto" class="dto.MemberDTO"/>
	<jsp:setProperty property="id" name="dto" value="el"/>
	<%
	list.add(dto); // id만 하나 들어감
	list.add(new MemberDTO("MEM1","1","회원1","01012341234","이메일1@a.com","서울시 용산구", "2022-12-12"));
	list.add(new MemberDTO("MEM2","2","회원2","01012344321","이메일2@a.com","부산시 용산구","2023-01-12"));
	list.add(new MemberDTO("MEM3","3","회원3","01043211234","이메일3@a.com","제주시 용산구","2012-08-12"));
	list.add(new MemberDTO("MEM4","4","회원4","01043214321","이메일4@a.com","전주시 용산구","2022-08-12"));
	list.add(new MemberDTO("MEM5","5","회원5","01012345678","이메일5@a.com","청주시 용산구","2022-08-12"));
	
	((MemberDTO)list.get(0)).getId(); // [0]인 dto의 id 출력. jsp태그로 리스트에 접근시 형변환을 해줘야한다!
	%>
	<!-- ((MemberDTO)list.get(0)).getId();와 같은 결과 출력 -->
	${list.get(0).id } : ${list[0] }<br>
	${list.get(1).id } : ${list[1].id }<br>
	${list.get(2).id } : ${list[2] }<br>
	${list.get(3).id } : ${list[3].id }<br>
	${list.get(4).id } : ${list[4].id }<br>
	${list.get(5).id } : ${list[5].id }<br>
	<%
	HashMap<String, String> map = new HashMap(); // jsp의 변수로 map을 만든건데, 바로 el에서 사용할 수 없다.
	// key는 똑같은 값 들어가면 안됨!!!
	map.put("빨강","red");
	map.put("주황","orange");
	map.put("노랑","yellow");
	map.put("초록","green");
	map.put("파랑","blue");
	map.put("남","navy");
	map.put("보라","purple");
	map.put("빨강","purple"); // 똑같은 key값으로 put을 사용시 덮어쓰여짐
	map.put("one","black"); // key값을 영문으로 줌
	pageContext.setAttribute("colormap", map);
	%>
	<!-- 순서대로 저장하는 게 아니라 hashmap에서는 [] index 사용할 수 없다  -->
	<%-- ${colormap[0] } --%>
	<%-- ${colormap."빨강" }<br>--%>
	${colormap["빨강"] }<br> <!-- "빨강"key값의 정보 가져와라~ -->
	${empty colormap["빨강색"]?"해당 색 없음":colormap["빨강색"] }<br> <!-- "빨강"의 key값을 가져와라~ -->
	${colormap.one }<br>
</body>
</html>