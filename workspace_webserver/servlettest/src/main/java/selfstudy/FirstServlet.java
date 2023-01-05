package selfstudy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstservlet")
public class FirstServlet extends HttpServlet { // HttpServlet을 상속받는다.
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출-FirstServlet");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메서드 호출-FirstServlet");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw =response.getWriter();
		pw.println("첫번째 서블릿 제작중");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 메서드 호출-FirstServlet");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출-FirstServlet");
	}


}
