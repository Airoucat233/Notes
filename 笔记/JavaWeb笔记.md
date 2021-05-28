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
<br><br><br><br><br><br><br><br>




