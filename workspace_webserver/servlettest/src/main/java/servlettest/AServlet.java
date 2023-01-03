package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/AServlet")
// @WebServlet("/a")
// @ : 어노테이션
public class AServlet extends HttpServlet {
	// HttpServlet을 상속받음!

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// servlet의 기본 골격
		System.out.println("최초의 서블릿 실행");
		PrintWriter out = resp.getWriter();
		resp.getWriter().println("<h1>hello output</h1>"); 
		// 클라이언트 브라우저 출력
		// 브라우저에 출력하는 것으로 태그도 포함에도 된다
	}
}
