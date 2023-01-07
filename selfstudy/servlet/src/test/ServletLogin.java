package test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/*
@WebServlet(name = "ServletLogin", value = "/ServletLogin")
*/
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 웹브라우저에서 전송된 데이터의 인코딩 설정
        req.setCharacterEncoding("utf-8");
        // 응답할 데이터 종류가 HTML임을 설정
        resp.setContentType("text/html;charset=utf-8");
        // HttpServletResponse 객체의 getWriter()을 이용해 출력 스트림 PrintWriter 객체를 받아옴
        PrintWriter out = resp.getWriter();

        
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        System.out.println("입력된 아이디 : " + id);
        System.out.println("입력된 비밀번호 : " + pw);

        String data = "<html>";
        data += "<body>";
        data += "<h2>";
        data += "입력된 아이디 : " + id;
        data += "</h2>";
        data += "<h2>";
        data += "입력된 비밀번호 : " + pw;
        data += "</h2>";
        data += "</body>";
        data += "</html>";
        out.print(data);



        String[] classification = req.getParameterValues("classification");
        for (String classify : classification)
        {
            System.out.println("선택한 구분명 selected classification : " + classify);
        }// for end
        // 전송되어온 name속성들만 Enumeration 타입으로 받아옴
        Enumeration enu = req.getParameterNames();
        String name = (String) enu.nextElement();
        String[] values = req.getParameterValues(name);
        for (String value : values){
            System.out.println("name = " + name + "value + " + value);
        }



    }


}
