package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bank")
public class BankServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 로그인 id 공유
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("sessionid") != null) {
			out.println("<h1>" + session.getAttribute("sessionid") 
			+ "님 인증되셨습니다.(5분간 유효함)</h1>");		
			session.setMaxInactiveInterval(60 * 5); // 60s * 5
		}
		else {
			out.println("<h1><a href ='loginsession?id=test&pw=1111'>로그인</a>부터하세요</h1>");
		}
	}

}
