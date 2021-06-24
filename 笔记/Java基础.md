#### ==和equals方法的对比
```
　　1.对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；

　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址

　　2.对于equals方法，注意：equals方法不能作用于基本数据类型的变量

　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；

　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
```
#### 字符串相关
```java
String.join(" ", s);//将数组s的元素用空格拼接
String result = temresult.substring(0,1).toUpperCase()+temresult.substring(1).toLowerCase();//首字母大写

char[] cs=temresult.toCharArray();//首字母大写，通过字符数组的形式
cs[0]-=32;
String result=String.valueOf(cs);
```

#### 代理模式理解
代理模式是面向对象编程中比较常见的设计模式
>代理模式可以在不修改被代理对象的基础上，通过扩展代理类，进行一些功能的附加与增强。值得注意的是，代理类和被代理类应该共同实现一个接口，或者是共同继承某个类
![代理模式](https://img-blog.csdn.net/20170629213938736?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvYnJpYmx1ZQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)