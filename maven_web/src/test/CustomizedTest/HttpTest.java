import jdk.nashorn.internal.ir.CatchNode;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * @author 包福平
 * @QQ:1140913970
 */
public class HttpTest {
    /**
     * 调用对方接口方法
     * @param path 对方或第三方提供的路径
     * @param data 向对方或第三方发送的数据，大多数情况下给对方发送JSON数据让对方解析
     */
    public static String interfaceUtil(String path,String data,String contenType,String token) {
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
            conn.setRequestMethod("POST");
            if(!token.equals(""))
                conn.setRequestProperty("token",token);
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type",contenType);
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String result = "";
            String line;
            int row_nums=0;
            try {
                while ((line = br.readLine()) != null) {
                    row_nums++;
                    result += line + "\n";
                    System.out.println(line);
                }
            }
            catch(Exception e){
                System.out.println(e);
                return "错误!";
            }
            finally {
                //关闭流
                is.close();
                conn.disconnect();
            }
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            System.out.println("完整结束");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "错误!";
        }
    }
    @Test
    public static void main(String[] args) {
        String getTokenJson = "jsonData={\"userName\":\"csjkzh179055\",\"passWord\":\"3BE4AC54EB7C2D09CD9D7AF512F9B2A0\"}";
        String createFileJson = "{\"businessType\":\"SALE\",\"startDate\":\"2021-05-01\",\"endDate\":\"2021-06-10\",\"ddiCode\":\"csjkzh179055\"}";
        //JSONObject jsonObject = JSONObject.fromObject(json1);
        //System.out.println(jsonObject.get("username"));
//        new Thread()
//        {
//            @Override
//            public void run()
//            {
//                super.run();
//                System.out.println("线程运行中....");
//                result[0] = interfaceUtil("http://passport.shaphar.com/sso/getToken",getTokenJson);
//                System.out.println("线程结束");
//            }
//        }.start();
        String result = interfaceUtil("http://passport.shaphar.com/sso/getToken",getTokenJson,"application/x-www-form-urlencoded;charset=utf-8","");
        JSONObject resultJson= JSONObject.fromObject(result);
        String token = resultJson.getJSONObject("data").getString("token");
        interfaceUtil("https://supplyapidev.shaphar.com/ddi/interfaceTask/createFile",createFileJson,"application/json;charset=utf-8",token);
        //JSONObject keydata = JSONObject.fromObject(resultJson.getString("data"));
        //System.out.println((keydata.getString("token")));

    }
}