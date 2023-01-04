package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* html태그
 * <IMG SRC="/b.jpg" > --> 서버의 루트에 b.jpg
 * http://localhost:8081/b.jpg
 * 
 * 서블릿,jsp
 * @WebServlet("/b")
 * http://localhost:8081/servlettest/b
 * */
@WebServlet("/b")
public class BServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("두번째 만드는 서블릿");
	}

}
