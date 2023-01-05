package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward1")
public class ForwardTest1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); // id 전달받음
		request.setAttribute("upperid", id.toUpperCase());; 
		// 전달받은 id 일괄적으로 대문자로 바꿔주고싶음..
		//setAttribute(어트리뷰트명, 어트리뷰트값)
		
		 response.setContentType("text/html;charset=utf-8");
		 PrintWriter out = response.getWriter(); 
		 // out.println("<h1>"+ request.getAttribute("upperid") + "회원님 반갑습니다 :)</h1>");
		 out.println("<h1> forwardTest1 클래스 입니다</h1>");
		 
		RequestDispatcher rd = request.getRequestDispatcher("/forward2"); // "웹어플리케이션명포함"
		rd.forward(request, response);
		// "이동". forward1,2가 요청객체, 응답객체를 공유하고 있다
		
		// 실행결과 URL 상 forward1 인점은 변화가 없어보이지만, 실질적으로 forward2의 기능을 같이 사용중인 것
	}

}
