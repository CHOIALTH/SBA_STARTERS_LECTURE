package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginsession")
public class LoginSessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 나한테 요청 보냈던 브라우저 세션 있는지 (2번째 이후 요청)
		// true / false 뱉어냄; true -> 이전 생성 session 대체하고 / false -> session 생성 
		HttpSession session = request.getSession();
		
		session.setAttribute("sessionid", id);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id != null && pw != null) {
			out.println("<h1>로그인하셨습니다</h1>");
			out.println("<h1>사용 가능한 메뉴는 다음과 같습니다</h1>");
			out.println("<h1><a href = '/mypage'>내정보 보러 가기</a></h1>");
			out.println("<h1><a href = ''>글 쓰러 가기</a></h1>");
			out.println("<h1><a href = ''>로그아웃 하러 가기</a></h1>");
			out.println("<h1>로그인 정보 유효시간은 " + session.getMaxInactiveInterval() + "초입니다.</h1>");
			
		}
		else {
			out.println("<h1>로그인한 적 없습니다</h1>");
		}
	}

}
