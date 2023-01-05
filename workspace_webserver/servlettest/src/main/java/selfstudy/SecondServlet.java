package selfstudy;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondservlet")
public class SecondServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출-SecondServlet");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출-SecondServlet");
	}
	public void destroy() {
		System.out.println("destroy 호출-SecondServlet");
	}

}
