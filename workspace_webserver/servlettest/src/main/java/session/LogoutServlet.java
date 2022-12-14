package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 보낸 브라우저 세션 있니?
		// true(두번째 이후 요청)이면 이전 session 공유
		HttpSession session = request.getSession();// 로그인 id 공유
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 로그인 먼저 하고 나서, 로그아웃
		if(session.getAttribute("sessionid") != null) {
			out.println("<h1>" +session.getAttribute("sessionid") + "님 로그아웃하셨습니다</h1>");
			session.removeAttribute("sessionid");
		}
		else {
			out.println("<h1>로그인부터 하세요. 그래야 로그아웃도 가능합니다~</h1>");
		}
	}

}
