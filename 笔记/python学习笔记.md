### 基础知识

#### Pycharm自动补全提示选项前面的小标代表含义

c：class类<br/>
f：function函数<br/>
m：method方法<br/>
v：variable变量<br/>
p：parameter参数<br/>

#### 参数类型提示
```python
def f(a: {int, float}):
    pass
#a是一个 具有int和float类型属性 的对象

(web_driver: {save_screenshot})#web_driver需要有一个save_screenshot属性/方法
```
#### 集合类型定义

```
set {'a',1,'b','hello'}
dict {'a':1,'b':'hello'}
list ['a',1,'b','hello']
```
#### lambda表达式
```python
a=lambda x,y:x+y
    print(a,'\n',a(1,2))
#输出
<function mytest.test14.<locals>.<lambda> at 0x000002AA3F0B9670> 
3
```
#### [可迭代对象详解](https://www.cnblogs.com/new-rain/p/9991932.html)

#### Python中单下划线、双下划线、头尾双下划线说明：

`__foo__`: 定义的是特殊方法，一般是系统定义名字 ，类似`__init__()` 之类的。

`_foo`: 以单下划线开头的表示的是 protected 类型的变量，即保护类型只能允许其本身与子类进行访问，不能用于 from module import *

`__foo`: 双下划线的表示的是私有类型(private)的变量, 只能是允许这个类本身进行访问了。Python正则表达式前的 r 表示原生字符串rawstring，该字符串声明了引号中的内容表示该内容的原始含义，避免了多次转义造成的反斜杠困扰。


#### *args、**kwargs的使用方法

   *args 用来将参数打包成tuple给函数体调用

```
def function(*args):
    print(args, type(args))
function(1)
(1,) <class 'tuple'>
```
   **kwargs 打包关键字参数成dict给函数体调用

```
def function(**kwargs):
    print(kwargs,type(kwargs))

function(a=1,b=2,c=3)
{'a': 1, 'b': 2, 'c': 3} <class 'dict'>

```
#### 线程创建
```python
import threading
def test13(sec)
        while 1:
        print(datetime.datetime.now(),"线程%s"%sec)
        time.sleep(sec)
if__name__='__main__'
    t1 = threading.Thread(target=test13,args=(1,))
    t2 = threading.Thread(target=test13,args=(2,))
    t1.start()
    t2.start()
#输出--------------
2021-05-12 11:09:55.742216 线程1
2021-05-12 11:09:55.742216 线程2
2021-05-12 11:09:56.753510 线程1
2021-05-12 11:09:57.751729 线程2
2021-05-12 11:09:57.767124 线程1
2021-05-12 11:09:58.782264 线程1
2021-05-12 11:09:59.756658 线程2
```
#### Python库

- Pandas：数据分析
- Pillow：图像处理
- cx-Oracle：连接Oracle
- requests：HTTP库
- selenium：用于Web应用程序测试的工具
- bs4：爬虫助手
- constant：提供了管理常量的广泛方法

### 字符串相关
#### split()用法
```python
sentence="All good things come to those who wait."
 
#分隔符以空格
print("分隔符以空格: ",sentence.split(' '))
print()
#分隔符以空格 ，分割1次
print("分隔符以空格 ，分割1次: ",sentence.split(' ',1))
print()
#分隔符以空格 ，分割2次
print("分隔符以空格 ，分割2次: ",sentence.split(' ',2))
print()
#分隔符以空格 ，分割2次,并取序列为1的项
print("分隔符以空格 ，分割2次,并取序列为1的项: ",sentence.split(' ',2)[1])

#输出
分隔符以空格:  ['All', 'good', 'things', 'come', 'to', 'those', 'who', 'wait.']

分隔符以空格 ，分割1次:  ['All', 'good things come to those who wait.']

分隔符以空格 ，分割2次:  ['All', 'good', 'things come to those who wait.']

分隔符以空格 ，分割2次,并取序列为1的项:  good
```
```python
#!/usr/bin/python
 
var1 = 'Hello World!'
var2 = "Python Runoob"
 
print "var1[0]: ", var1[0]
print "var2[1:5]: ", var2[1:5]
#输出
var1[0]:  H
var2[1:5]:  ytho
```
```python
os.path.split()#返回文件的路径和文件名
os.path.splitext()#返回文件名和拓展名
```

### 时间日期相关

#### [python时间格式](https://blog.csdn.net/iamcodingmylife/article/details/79820102)
```
%y 两位数的年份表示（00-99)
%Y 四位数的年份表示（000-9999）
%m 月份（01-12）
%d 月内中的一天（0-31）
%H 24小时制小时数（0-23）
%I 12小时制小时数（01-12）
%M 分钟数（00=59）
%S 秒（00-59）%f带小数的秒
%a 本地简化星期名称
%A 本地完整星期名称
%b 本地简化的月份名称
%B 本地完整的月份名称
%c 本地相应的日期表示和时间表示
%j 年内的一天（001-366）
%p 本地A.M.或P.M.的等价符
%U 一年中的星期数（00-53）星期天为星期的开始
%w 星期（0-6），星期天为星期的开始
%W 一年中的星期数（00-53）星期一为星期的开始
%x 本地相应的日期表示
%X 本地相应的时间表示
%Z 当前时区的名称
%% %号本身
```

#### 字符串日期转datetime类型日期(Oracle DATA类型)

```python
t='2021-03-01 09:37:35'
time.strptime(t,'%Y-%m-%d %H:%M:%S')
#字符串->时间结构体
#输出
#<class 'time.struct_time'>
#time.struct_time(tm_year=2021, tm_mon=3, tm_mday=1, tm_hour=9, tm_min=37, tm_sec=35, tm_wday=0, tm_yday=60, tm_isdst=-1)
time.mktime(time.strptime(t,'%Y-%m-%d %H:%M:%S'))
#输出
#2021-03-01 09:37:35--->1614562655.0(<class 'float'>)
datetime.datetime.fromtimestamp(1588176000.0)
#输出
#<class 'datetime.datetime'>
#1588176000.0-->2021-03-01 09:37:35
```


### cx_Oracle

#### Python连接Oracleimport cx_Oracle

```
conn = cx_Oracle.connect('yb_ya/***@10.254.254.*:1521/yaybdb',encoding="UTF-8")
cursor = conn.cursor()
cursor.execute('select * from ac01 where rownum <= 5')
result = cursor.fetchall()
print (cursor.rowcount)
for row in result:
    print(row)  #此处特别注意前面空格
cursor.close()
conn.close()
————————————————
原文链接：https://blog.csdn.net/weixin_42167016/article/details/80895796
```



### pandas
#### [pandas dataframe的合并（append, merge, concat）](https://www.cnblogs.com/guxh/p/9451532.html)

#### pandas.read_csv()参数


### selenium

[Python selenium等待](https://blog.csdn.net/huilan_same/article/details/52544521)

[selenium：css_selector定位详解（css selector和xpath的比较）](https://www.cnblogs.com/haifeima/p/10138154.html)

[selenium webdriver by xpath 定位元素](https://blog.csdn.net/xiaosongbk/article/details/53188355)
#### selenium报错：This version of ChromeDriver only supports Chrome version 76

>将对应版本的ChromeDriver放入浏览器目录和Python目录

#### iframe标签处理
[iframe切换](https://www.jianshu.com/p/6d12c54b8fef)
```
frame标签有frameset、frame、iframe三种,frameset跟其他普通标签没有区别，不会影响到正常的定位，而frame与iframe需要切换进去才能定位到其中的元素
内联框架
根据使用内联框架中的文档，内联框架是一种将文档嵌入到HTML文档中的构造，以便嵌入的数据显示在浏览器窗口的子窗口中。这并不意味着完全包含，这两个文件是独立的，它们都被视为完整的文件，而不是将其作为另一个文件的一部分。

iframe结构和细节
通常，iframe元素的形式为：
 <iframe src="URL" more attributes> alternative content for browsers which do not support iframe </iframe> 
支持iframe的浏览器在子窗口中显示URL引用的文档，通常使用垂直和/或水平滚动条。此类浏览器会忽略iframe元素的内容（即开始标记<iframe...>和结束标记之间的所有内容</iframe>）。不支持iframe（或禁用此类支持）的浏览器则相反，即处理内容，就好像<iframe...>和</iframe>标签不在那里一样。因此，尽管被一些浏览器忽略，但内容很重要。
总而言之，内联框架并不意味着包含功能，尽管它有时可能用于类似目的。
请注意，当使用内联框架时，浏览器（如果它支持它们）向URLiframe元素中引用的服务器发送请求，并在获取所请求的文档后将其显示在内联框架内。从这个意义上说，内联框架是一个联合的浏览器 - 服务器问题，但只有浏览器需要具体的iframe感知; 从服务器的角度来看，文档只有一个普通的HTTP请求，它发送文档时没有（或需要）知道浏览器将对它做什么。
更聪明的东西
根据切换到iframe时的最佳实践，您需要按如下方式引导WebDriverWait：
```

```java
切换到框架名称（Java示例代码）：
 new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("frame_name"))); 
```
```python
切换iframe  XPath（Python示例代码）：
 WebDriverWait(driver, 10).until(EC.frame_to_be_available_and_switch_to_it((By.XPATH,"//iframe[@id='ptifrmtgtframe' and @name='TargetContent']")))
 ```
 ```c# 
切换iframe  CssSelector（C＃示例代码）：
 new WebDriverWait(driver, TimeSpan.FromSeconds(20)).Until(ExpectedConditions.FrameToBeAvailableAndSwitchToIt(By.CssSelector("iframe#twitter-widget-0"))); 
```

#### python+selenium+Chromedriver使用location定位元素坐标偏差
*注：location的值是相对于当前frame来说的*<br>

使用xpath定位元素，用.location获取坐标值，截取网页截图的一部分出现偏差。
之所以会出现这个坐标偏差是因为windows系统下电脑设置的显示缩放比例造成的，location获取的坐标是按显示100%时得到的坐标，而截图所使用的坐标却是需要根据显示缩放比例缩放后对应的图片所确定的，因此就出现了偏差。
解决这个问题有三种方法：
1. 修改电脑显示设置为100%。这是最简单的方法；
2. 缩放截取到的页面图片，即将截图的size缩放为宽和高都除以缩放比例后的大小；
3. 修改Image.crop的参数，将参数元组的四个值都乘以缩放比例。





