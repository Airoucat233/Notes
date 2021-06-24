package airoucat.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

import airoucat.model.dataUtil;
import net.sf.json.JSONObject;

public class HelloHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET请求收到了");
//         //i.getRequestURI() 获取请求的资源路径
//        System.out.println("URI => " + req.getRequestURI());
//        // ii.getRequestURL() 获取请求的统一资源定位符（绝对路径）
//        System.out.println("URL => " + req.getRequestURL());
//        // iii.getRemoteHost() 获取客户端的 ip 地址
//        System.out.println("客户端 ip 地址 => " + req.getRemoteHost());
//        //iv.getHeader() 获取请求头
//        System.out.println("请求头 User-Agent ==>> " + req.getHeader("User-Agent"));
//        //vii.getMethod() 获取请求的方式 GET 或 POST
//        System.out.println( "请求的方式 ==>> " + req.getMethod() );
//        System.out.println(req.getParameter("username"));
//        System.out.println(req.getParameter("password"));
//        //req.getParameter()只会获取第一个参数req.getParameterValues()获取多个
//        System.out.println("兴趣爱好： " + Arrays.asList(req.getParameterValues("hobby")));
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        if(verifyTheuUser(username,password)) {
            String businessType = req.getParameter("businesstype");
                if (businessType.equals("generateTheToken")) {
                req.setAttribute("requestTime", dataUtil.getSysdateStr(""));
                req.setAttribute("key1","1111");
                req.getRequestDispatcher("/hello/generateTheToken").forward(req, resp);
            }
        }
        else{
            PrintWriter writer = resp.getWriter();
            writer.write(username+"用户验证失败!!!==========\n");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST请求收到了");
        InputStream is = req.getInputStream();
        //构造一个字符流缓存
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = "",reqjson="";
        while ((str = br.readLine()) != null){
            reqjson += str;
        }
        JSONObject jsonObject = JSONObject.fromObject(reqjson);
        String username=jsonObject.getString("username");
        //数据库比对
        req.setAttribute("requestTime", dataUtil.getSysdateStr(""));
        req.getRequestDispatcher("/hello/generateTheToken").forward(req, resp);

    }

    private boolean verifyTheuUser(String username,String password){
        if(username.equals("airoucat"))
            return true;
        else
            return false;
    }
}
