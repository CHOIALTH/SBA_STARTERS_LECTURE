package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginprocess")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.html (id, pw)
		request.setCharacterEncoding("utf-8");//post방식인 경우 필요
		String id = request.getParameter("id");
		if(id != null && !id.equals("")) {
			System.out.println(id.equals("servlet"));
		}
		String pw = request.getParameter("pw");
		// select multiple=multiple, input type=checkbox 
		String title[] = request.getParameterValues("title");
		//id pw 
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + id + " 회원님 환영합니다</h1>");
		out.println("<h1>" + pw + " 암호를 입력하셨습니다.</h1>");	
		for(String t : title) {
			out.println("<h1>" + t + " 을 선택하셨습니다.</h1>");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.html (id, pw)
		System.out.println(request.getMethod());
		request.setCharacterEncoding("utf-8");//post방식인 경우 필요
		doPost(request, response);
	}

}


/*
 * http://localhost:8081/servlettest/loginprocess
 * ?id=%EC%A1%B0%EC%84%B1%ED%9D%AC
 * &pw=111
 * &title=%EC%9B%B9%ED%81%B4%EB%9D%BC%EC%9D%B4%EC%96%B8%ED%8A%B8%EA%B3%BC%EC%A0%95&
 * title=%EC%9B%B9%EC%84%9C%EB%B2%84%EA%B3%BC%EC%A0%95
 * &title=%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4%EA%B3%BC%EC%A0%95
 * &title=%EC%84%9C%EB%B9%84%EC%8A%A4%EB%B0%B0%ED%8F%AC%EA%B3%BC%EC%A0%95
 * */







