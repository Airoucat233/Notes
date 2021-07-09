#### maven的groupId和artifactId的区别
    　　groupId一般分为多个段，这里我只说两段，第一段为域，第二段为公司名称。域又分为org、com、cn等等许多，其中org为非营利组织，com为商业组织。举个apache公司的tomcat项目例子：这个项目的groupId是org.apache，它的域是org（因为tomcat是非营利项目），公司名称是apache，artigactId是tomcat。

    　　比如创建一个项目，我一般会将groupId设置为cn.zr，cn表示域为中国，zr是我个人姓名缩写，artifactId设置为testProj，表示你这个项目的名称是testProj，依照这个设置，你的包结构最好是cn.zr.testProj打头的，如果有个StudentDao，它的全路径就是cn.zr.testProj.dao.StudentDao

    注：artifactId实际应该是项目名-模块名，不只是项目名

#### 测试用例跳过插件
```xml
<!--
    在工作中,很多情况下我们打包是不想执行测试用例的
    可能是测试用例不完事,或是测试用例会影响数据库数据
    跳过测试用例执
    -->
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
            <!--跳过项目运行测试用例-->
            <skipTests>true</skipTests>
        </configuration>
    </plugin>
```


