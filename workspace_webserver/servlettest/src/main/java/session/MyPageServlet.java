package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 로그인 id 공유
		String sessionid = (String)session.getAttribute("sessionid");
	

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("sessionid") != null) {
			out.println("<h1>" + sessionid + "님의 회원정보 페이지입니다</h1>");			
		}
		else {
			out.println("<h1>로그인부터 하세요. 그래야 회원정보를 보여줌~</h1>");
			out.println("<h1><a href ='loginsession?id=test&pw=1111'>로그인</a></h1>");
		}
	}

}
