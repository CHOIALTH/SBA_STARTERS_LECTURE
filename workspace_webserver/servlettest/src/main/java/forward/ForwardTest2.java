package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward2")
public class ForwardTest2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter(); 
		out.println("<h1>"+ request.getAttribute("upperid") + "회원님 반갑습니다 :)</h1>");
		out.println("<h1>"+ request.getParameter("id") + "회원님 반갑습니다 :)</h1>");
	}

}
