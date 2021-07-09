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


#### map()函数映射求两个列表相乘
```python
func = lambda x,y:x*y
result = map(func,[1,2,3,4],[4,3,2,1])
list_result = list(result)
print(list_result)
#运行结果
[4, 6, 6, 4]
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


#### with工作原理
```python
class Sample:
    def __enter__(self):
        print "in __enter__"
        return "Foo"
    def __exit__(self, exc_type, exc_val, exc_tb):
        print "in __exit__"
def get_sample():
    return Sample()
with get_sample() as sample:
    print "Sample: ", sample

"""
输出
in __enter__
Sample:  Foo
in __exit__
"""
```
[with工作原理详解](https://blog.csdn.net/u012609509/article/details/72911564)

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
- PyAutoGUI：一个纯Python的GUI自动化工具，其目的是可以用程序自动控制鼠标和键盘操作，多平台支持
- pyperclip：模块有 copy() 和 paste() 函数， 可以向计算机的剪贴板发送文本， 或从
它接收文本。

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

### os

```python
os.path.split()#返回文件的路径和文件名 (路径/ , 文件名.py)
os.path.splitext()#返回文件名和拓展名 (路径/文件名 , '.py')
```
获取用户名
os.environ['USERNAME']

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

```python
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
#原文链接：https://blog.csdn.net/weixin_42167016/article/details/80895796
```



### pandas
#### DataFrame的创建
```python
pd.DataFrame(columns=['第一列','第二列','第三列'],index=[1,2,3],data={'第一列':[4,5,6],'第二列':3})
#输出
  第一列  第二列  第三列
1    4    3     NaN
2    5    3     NaN
3    6    3     NaN

pd.DataFrame(columns=['第一列','第二列','第三列'],index=[1,2,3],data=[(1,1,1),(2,2,3),(3,3,3)])
#输出
   第一列  第二列  第三列
1    1    1    1
2    2    2    3
3    3    3    3
```
#### [pandas dataframe的合并（append, merge, concat）](https://www.cnblogs.com/guxh/p/9451532.html)
#### DataFrame读写函数参数
- ##### pandas.read_csv()参数
      sep='\t' 读取以制表符分隔的表格
      sep='\s+'等效于delim_whitespace=true 任何空白字符做分隔符
- ##### pandas.read_html()参数
      header=0 表示第0行作为表头

#### 查看/转换DataFrame数据类型
```python
#查看各列数据类型
df.dtypes
#查看A列数据类型
df[A].dtypes
df.dtypes[A]
#转换DataFrame的数据类型
df[A].astypes(int)#将A列数据类型转换为int
将'含税金额'列转换为str,再作替换，返回一个series,再转换为float
df['含税金额']=df['含税金额'].astype(str).str.replace(',','').astype(float)
```
#### DataFrame获得某一列中所有的不重复的值
`dataframe['xxx'].unique()`

### ElementTree XML API
```python
import xml.etree.ElementTree as et
tree = et.parse(tablepath)#将xml解析为树
root = tree.getroot()#获取根节点
rows = root.findall('.//{urn:schemas-microsoft-com:office:spreadsheet}Row')
```
#### [支持的Xpath语法](https://docs.python.org/zh-cn/3/library/xml.etree.elementtree.html#elementtree-xpath)


### selenium

#### 直接获取html文本内容
```python
driver.find_element(By.XPATH.'path').get_attribute('innerHTML')
```
#### 设置网站加载超时
`self.driver.set_page_load_timeout(10)`<br>
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

### pyautogui
#### [更多操作](https://www.jb51.net/article/183926.htm)
#### 基本操作
```python
import pyautogui
 
pyautogui.PAUSE = 1 # 调用在执行动作后暂停的秒数，只能在执行一些pyautogui动作后才能使用，建议用time.sleep
pyautogui.FAILSAFE = True # 启用自动防故障功能，左上角的坐标为（0，0），将鼠标移到屏幕的左上角，来抛出failSafeException异常
 
# 判断(x,y)是否在屏幕上
x, y = 122, 244
pyautogui.onScreen(x, y) # 结果为true
 
width, height = pyautogui.size() # 屏幕的宽度和高度
print(width, height)
```
#### 鼠标常用操作
```python
import pyautogui
 
currentMouseX, currentMouseY = pyautogui.position() # 鼠标当前位置
print(currentMouseX, currentMouseY)
 
# 控制鼠标移动,duration为持续时间
for i in range(2):
  pyautogui.moveTo(100, 100, duration=0.25) # 移动到 (100,100)
  pyautogui.moveTo(200, 100, duration=0.25)
  pyautogui.moveTo(200, 200, duration=0.25)
  pyautogui.moveTo(100, 200, duration=0.25)
 
for i in range(2):
  pyautogui.moveRel(50, 0, duration=0.25) # 从当前位置右移100像素
  pyautogui.moveRel(0, 50, duration=0.25) # 向下
  pyautogui.moveRel(-50, 0, duration=0.25) # 向左
  pyautogui.moveRel(0, -50, duration=0.25) # 向上
 
# 按住鼠标左键，把鼠标拖拽到(100, 200)位置
pyautogui.dragTo(100, 200, button='left')
# 按住鼠标左键，用2秒钟把鼠标拖拽到(300, 400)位置
pyautogui.dragTo(300, 400, 2, button='left')
# 按住鼠标左键，用0.2秒钟把鼠标向上拖拽
pyautogui.dragRel(0, -60, duration=0.2)
 
# pyautogui.click(x=moveToX, y=moveToY, clicks=num_of_clicks, interval=secs_between_clicks, button='left')
# 其中，button属性可以设置成left，middle和right。
pyautogui.click(10, 20, 2, 0.25, button='left')
pyautogui.click(x=100, y=200, duration=2) # 先移动到(100, 200)再单击
pyautogui.click() # 鼠标当前位置点击一下
pyautogui.doubleClick() # 鼠标当前位置左击两下
pyautogui.doubleClick(x=100, y=150, button="left") # 鼠标在（100，150）位置左击两下
pyautogui.tripleClick() # 鼠标当前位置左击三下
 
pyautogui.mouseDown() # 鼠标左键按下再松开
pyautogui.mouseUp()
pyautogui.mouseDown(button='right') # 按下鼠标右键
pyautogui.mouseUp(button='right', x=100, y=200) # 移动到(100, 200)位置，然后松开鼠标右键
 
# scroll函数控制鼠标滚轮的滚动，amount_to_scroll参数表示滚动的格数。正数则页面向上滚动，负数则向下滚动
# pyautogui.scroll(clicks=amount_to_scroll, x=moveToX, y=moveToY)
pyautogui.scroll(5, 20, 2)
pyautogui.scroll(10) # 向上滚动10格
pyautogui.scroll(-10) # 向下滚动10格
pyautogui.scroll(10, x=100, y=100) # 移动到(100, 100)位置再向上滚动10格
 
# 缓动/渐变函数可以改变光标移动过程的速度和方向。通常鼠标是匀速直线运动，这就是线性缓动/渐变函数。
# PyAutoGUI有30种缓动/渐变函数，可以通过pyautogui.ease*?查看。
# 开始很慢，不断加速
pyautogui.moveTo(100, 100, 2, pyautogui.easeInQuad)
# 开始很快，不断减速
pyautogui.moveTo(100, 100, 2, pyautogui.easeOutQuad)
# 开始和结束都快，中间比较慢
pyautogui.moveTo(100, 100, 2, pyautogui.easeInOutQuad)
# 一步一徘徊前进
pyautogui.moveTo(100, 100, 2, pyautogui.easeInBounce)
# 徘徊幅度更大，甚至超过起点和终点
pyautogui.moveTo(100, 100, 2, pyautogui.easeInElastic)


#获取鼠标位置
import pyautogui
 
print('Press Ctrl-C to quit.')
try:
  while True:
    # Get and print the mouse coordinates.
    x, y = pyautogui.position()
    positionStr = 'X:' + str(x).rjust(4) + ' Y:' + str(y).rjust(4)
    pix = pyautogui.screenshot().getpixel((x, y)) # 获取鼠标所在屏幕点的RGB颜色
    positionStr += ' RGB:(' + str(pix[0]).rjust(3) + ',' + str(pix[1]).rjust(3) + ',' + str(pix[2]).rjust(3) + ')'
    print(positionStr, end='') # end='' 替换了默认的换行
    print('\b' * len(positionStr), end='', flush=True) # 连续退格键并刷新，删除之前打印的坐标，就像直接更新坐标效果
except KeyboardInterrupt: # 处理 Ctrl-C 按键
  print('\nDone.')
```

#### 键盘操作
```python
import pyautogui
 
pyautogui.typewrite('Hello world!') # 输入Hello world!字符串
pyautogui.typewrite('Hello world!', interval=0.25) # 每次输入间隔0.25秒，输入Hello world!
 
pyautogui.press('enter') # 按下并松开（轻敲）回车键
pyautogui.press(['left', 'left', 'left', 'left']) # 按下并松开（轻敲）四下左方向键
pyautogui.keyDown('shift') # 按下`shift`键
pyautogui.keyUp('shift') # 松开`shift`键
 
pyautogui.keyDown('shift')
pyautogui.press('4')
pyautogui.keyUp('shift') # 输出 $ 符号的按键
 
pyautogui.hotkey('ctrl', 'v') # 组合按键（Ctrl+V），粘贴功能，按下并松开'ctrl'和'v'按键
 
# pyautogui.KEYBOARD_KEYS数组中就是press()，keyDown()，keyUp()和hotkey()函数可以输入的按键名称
pyautogui.KEYBOARD_KEYS = ['\t', '\n', '\r', ' ', '!', '"', '#', '$', '%', '&', "'", '(', ')', '*', '+', ',', '-', '.',
              '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ':', ';', '<', '=', '>', '?', '@',
              '[', '\\', ']', '^', '_', '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
              'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '{', '|', '}', '~',
              'accept', 'add', 'alt', 'altleft', 'altright', 'apps', 'backspace', 'browserback',
              'browserfavorites', 'browserforward', 'browserhome', 'browserrefresh', 'browsersearch',
              'browserstop', 'capslock', 'clear', 'convert', 'ctrl', 'ctrlleft', 'ctrlright', 'decimal',
              'del', 'delete', 'divide', 'down', 'end', 'enter', 'esc', 'escape', 'execute', 'f1', 'f10',
              'f11', 'f12', 'f13', 'f14', 'f15', 'f16', 'f17', 'f18', 'f19', 'f2', 'f20', 'f21', 'f22',
              'f23', 'f24', 'f3', 'f4', 'f5', 'f6', 'f7', 'f8', 'f9', 'final', 'fn', 'hanguel', 'hangul',
              'hanja', 'help', 'home', 'insert', 'junja', 'kana', 'kanji', 'launchapp1', 'launchapp2',
              'launchmail', 'launchmediaselect', 'left', 'modechange', 'multiply', 'nexttrack',
              'nonconvert', 'num0', 'num1', 'num2', 'num3', 'num4', 'num5', 'num6', 'num7', 'num8', 'num9',
              'numlock', 'pagedown', 'pageup', 'pause', 'pgdn', 'pgup', 'playpause', 'prevtrack', 'print',
              'printscreen', 'prntscrn', 'prtsc', 'prtscr', 'return', 'right', 'scrolllock', 'select',
              'separator', 'shift', 'shiftleft', 'shiftright', 'sleep', 'space', 'stop', 'subtract', 'tab',
              'up', 'volumedown', 'volumemute', 'volumeup', 'win', 'winleft', 'winright', 'yen', 'command',
              'option', 'optionleft', 'optionright']
```


