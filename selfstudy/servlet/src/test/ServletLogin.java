package test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

/*
@WebServlet(name = "ServletLogin", value = "/ServletLogin")
*/
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        System.out.println("입력된 아이디 : " + id);
        System.out.println("입력된 비밀번호 : " + pw);
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
