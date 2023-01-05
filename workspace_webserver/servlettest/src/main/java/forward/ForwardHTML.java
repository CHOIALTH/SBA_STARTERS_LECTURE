package forward;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//SPRING DI IOC AOP MVC
//login.html은 반드시 서블릿 통해 호출
@WebServlet("/FowardHTML")
public class ForwardHTML extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// Forward시에 서버 내부 같은 어플리케이션 내부 파일 이동
		System.out.println("클라이언트는 " + req.getRequestURL() + "호출하셨습니니다.");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.html");
		// rd.forward(req,response);
		rd.include(req,response);
		// 응답 추가 출력
	}

}
