package test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class Session extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("서블릿 인텔리제이 스타트");
        pw.println("Servlet Intellij Start ");
        System.out.println("안녕");
        pw.println("req 세션:" + req.getSession());
        pw.println("resp status:" + resp.getStatus());
    }
}
