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

        System.out.println(req.getAttribute("requestTime"));
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("{\n" +
                "\t\"data\": {\n" +
                "\t\t\"token\": \"8b593d2385032asdfdaac98ca2247294acd3d5\"\n" +
                "\t},\n" +
                "\t\"msg\": \"调用成功\",\n" +
                "\t\"success\": true\n" +
                "}");
    }
}
