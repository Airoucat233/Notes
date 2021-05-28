package airoucat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;

public class HelloHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET请求收到了");
        // i.getRequestURI() 获取请求的资源路径
//        System.out.println("URI => " + req.getRequestURI());
//        // ii.getRequestURL() 获取请求的统一资源定位符（绝对路径）
//        System.out.println("URL => " + req.getRequestURL());
//        // iii.getRemoteHost() 获取客户端的 ip 地址
//        System.out.println("客户端 ip 地址 => " + req.getRemoteHost());
//        //iv.getHeader() 获取请求头
//        System.out.println("请求头 User-Agent ==>> " + req.getHeader("User-Agent"));
//        //vii.getMethod() 获取请求的方式 GET 或 POST
//        System.out.println( "请求的方式 ==>> " + req.getMethod() );
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        //req.getParameter()只会获取第一个参数req.getParameterValues()获取多个
        System.out.println("兴趣爱好： " + Arrays.asList(req.getParameterValues("hobby")));
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST请求收到了"+req);
    }
}
