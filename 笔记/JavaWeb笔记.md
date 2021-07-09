#### maven推荐的Web项目目录.
```
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── mygroup
    │   │       ├── controller
    │   │       │   ├── HomeController.java
    │   │       │   └── PersonController.java
    │   │       ├── dao
    │   │       │   └── PersonDao.java
    │   │       └── model
    │   │           └── Person.java
    │   ├── resources
    │   │   ├── db.properties
    │   │   ├── log4j.xml
    │   │   └── META-INF
    │   │       └── persistence.xml
    │   └── webapp
    │       ├── index.html
    │       ├── META-INF
    │       │   ├── context.xml
    │       │   └── MANIFEST.MF
    │       ├── resources
    │       │   └── css
    │       │       └── screen.css
    │       └── WEB-INF
    │           ├── spring
    │           │   ├── app
    │           │   │   ├── controllers.xml
    │           │   │   └── servlet-context.xml
    │           │   ├── db.xml
    │           │   └── root-context.xml
    │           ├── views
    │           │   ├── edit.jsp
    │           │   ├── home.jsp
    │           │   └── list.jsp
    │           └── web.xml
    └── test
        ├── java
        │   └── mygroup
        │       ├── controller
        │       │   ├── DataInitializer.java
        │       │   ├── HomeControllerTest.java
        │       │   └── PersonControllerTest.java
        │       └── dao
        │           └── PersonDaoTest.java
        └── resources
            ├── db.properties
            ├── log4j.xml
            ├── test-context.xml
            └── test-db.xml
```

#### Tomcat和JDK版本对应关系
![图片源不存在](https://images2017.cnblogs.com/blog/1116722/201708/1116722-20170831115152874-1854282450.png)

#### Tomcat重新部署和重启等操作区别
```
1.重启tomcat服务：只会重新编译java目录下的文件（相当于更新.classes文件）
2.重新部署：将java目录下文件和.xml等配置文件都复制到tomcat的运行环境中（相当于既更新.classes文件又更新web.xml等配置文件）
3.热部署：在运行时修改jsp文件可以在不重服务器的情况下让修改生效，但是对修改配置文件（例如.xml）和java目录下代码无效！
总结：开启热部署后，
只改.jsp文件，不需要重新部署，直接刷新页面即可看到更改
改配置文件和java目录下代码，就需要重新部署。
```
#### HTTP协议
##### 常见响应码
    200 表示请求成功
    302 表示请求重定向（明天讲）
    404 表示请求服务器已经收到了， 但是你要的数据不存在（请求地址错误）
    500 表示服务器已经收到请求， 但是服务器内部错误（代码错误）
##### HttpServletRequest 类的常用方法
    HttpServletRequest作用：获取请求信息

    i. getRequestURI() 获取请求的资源路径
    ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
    iii. getRemoteHost() 获取客户端的 ip 地址
    iv. getHeader() 获取请求头
    v. getParameter() 获取请求的参数
    vi. getParameterValues() 获取请求的参数（多个值的时候使用）
    vii. getMethod() 获取请求的方式 GET 或 POST
    viii. setAttribute(key, value); 设置域数据
    ix. getAttribute(key); 获取域数据
    x. getRequestDispatcher() 获取请求转发对象


#### Get请求中文乱码解决
```java
获取请求参数
String username = req.getParameter("username");
//1 先以 iso8859-1 进行编码
//2 再以 utf-8 进行解码
username = new String(username.getBytes("iso-8859-1"), "UTF-8");
```
#### POST请求中文乱码解决
```java
// 设置请求体的字符集为 UTF-8， 从而解决 post 请求的中文乱码问题
req.setCharacterEncoding("UTF-8");
System.out.println("-------------doPost------------");
// 获取请求参数
String username = req.getParameter("username");
String password = req.getParameter("password");
String[] hobby = req.getParameterValues("hobby");
System.out.println("用户名： " + username);
System.out.println("密码： " + password);
System.out.println("兴趣爱好： " + Arrays.asList(hobby));
```
#### JS 创建元素的三种方法
1、动态创建元素一 document.write()

例如向页面中输出一个 li 标签
```html
<pre class="html" name="code"><span style="font-size:12px;"><script>
  document.write("<li>123</li>");
</script></span>
```
body标签中就会插入但是这种方法几乎不用，因为这回影响页面的布局，甚至会将页面原来的内容冲刷掉，从而只显示输出内容

2、动态创建元素二 innerHTML

```html
<span style="font-size:12px;"><body>
<div id="box"></div>
<script>
  var box = document.getElementById("box");
  box.innerHTML = "<p>这是p标签</p>";
</script>
</body></span>
```
div标签中就会插入一个p标签，并在在页面上输出“这是标签”，当需要添加的标签比较多的时候使用这种方式。

3、动态创建元素三 document.createElement()

```html
<span style="font-size:12px;"><body>
<div id="div"></div>
<script>
  var divobj = document.getElementById("div"); var li = document.createElement("li"); //创建一个li标签 li.innerHTML = "123"; //给li标签赋值
divobj.appendChild(li); //将创建好的li标签追加到box标签中 </script> </body></span>
```
div标签下面就会创建了一个li标签，当需要动态创建的标签比较少的时候就使用这种方式

#### servlet相关
    /如果被浏览器解析，得到的地址是http://ip:port/
    /如果被服务器解析，得到的地址是http://ip:port/工程路径/ web.xml中的url-pattern标签中的/

#### jsp相关
jsp由这些页面元素组成：
1. 静态内容
就是html,css,javascript等内容
2. 指令
以<%@开始 %> 结尾，比如<%@page import="java.util.*"%>
3. 表达式 <%=%>
用于输出一段html
4. Scriptlet
在<%%> 之间，可以写任何java 代码
5. 声明
在<%!%> 之间可以声明字段或者方法。但是不建议这么做。
6. 动作
<jsp:include page="Filename" > 在jsp页面中包含另一个页面。在包含的章节有详细的讲解
7. 注释 <%-- -- %>
不同于 html的注释 <!-- --> 通过jsp的注释，浏览器也看不到相应的代码，相当于在servlet中注释掉了