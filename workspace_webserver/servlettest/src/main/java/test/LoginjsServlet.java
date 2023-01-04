package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginjs")
public class LoginjsServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//post방식인 경우 필요
		String id = request.getParameter("id");//null
		String pw = request.getParameter("pw");
		String role = request.getParameter("role");
		if(id == null || id.equals("")) {
			id="손님";
		}
		String output = "";
		if(role.equals("admin")) {
			output = "<h1>" + id + " 관리자님 환영합니다</h1>";
		}
		else {//user
			output = "<h1>" + id + " 회원님 환영합니다</h1>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(output);
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







