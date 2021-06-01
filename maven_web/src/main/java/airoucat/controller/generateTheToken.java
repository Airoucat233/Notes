package airoucat.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class generateTheToken extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("生成token中...");
        PrintWriter writer = resp.getWriter();
        System.out.println(req.getAttribute("key1"));
        if(req.getAttribute("key1").equals("1111")){
            writer.write("token233");
        }
        else{
            writer.write("未经验证的用户");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
