package mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); //   http://localhost:8081/nonspringmvc/a/b/c/hello
		String uri_array[] = uri.split("/");
		String result = uri_array[uri_array.length -1]; // hello
		System.out.println(result);
		   
	}

}
