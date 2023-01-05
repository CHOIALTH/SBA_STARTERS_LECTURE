package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardwriting")
public class BoardWritingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 로그인 id 공유
		String sessionid = (String)session.getAttribute("sessionid");
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("sessionid") != null) {
			String output = "<h1>글쓰기 폼</h1>";
			output += "<table border=3>";
			output += "<tr><td>제목</td><td><input type = text name = 'title'></td><tr>";
			output += "<tr><td>내용</td><td><textarea name = 'contents' rows = 5 cols = 50>"
					+ "</textarea></td><tr>";
			output += "<tr><td>작성자</td><td><input type = text name = 'writer' value ="
					+ session.getAttribute("sessionid") +  " readonly></td><tr>";
			output += "</table>";
			out.println(output);			
		}
		else {
			out.println("<h1>로그인부터 하세요. 그래야 회원정보를 보여줌~</h1>");
			out.println("<h1><a href ='loginsession?id=test&pw=1111'>로그인</a></h1>");
		}
	}

}
