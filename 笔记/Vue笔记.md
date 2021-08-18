#### Vue项目结构/vue-cli创建脚手架
![img](https://img-blog.csdnimg.cn/20190611223319346.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjYwMzAwOQ==,size_16,color_FFFFFF,t_70)

#### Vue安装及项目创建
1. 从官网下载并安装node.js
2. cmd下查看node版本`node -v`,查看npm版本`npm -v`
3. 安装webpack
   ```
   npm install webpack -g
   npm install webpack-cli
   
   查看版本
   webpack -v
   ```
4. 安装vue-cli脚手架构建工具`npm install vue-cli -g`查看版本`vue -V`
5. 在某个目录下初始化项目
   ```
   vue init webpack vuedemo（自己的项目名）
   ```
6. 启动项目
   ```
   cd vuedemo
   npm run dev
   ```
7. 浏览器访问
#### vue项目npm install相关
npm config set registry https://registry.npm.taobao.org 
npm install --msvs_version=2017
npm config set msvs_version 2017 --global

#### webpack相关
##### module.exports/exports/export/export default关系和区别

CommonJS规范规定，每个模块内部，module变量代表当前模块。这个变量是一个对象，它的exports属性（即module.exports）是对外的接口。加载某个模块，其实是加载该模块的module.exports属性。
```js
var x = 5;
var addX = function (value) {
  return value + x;
};
module.exports.x = x;
module.exports.addX = addX;
// 上面代码通过module.exports输出变量x和函数addX

//require方法用于加载模块
var example = require('./example.js');

console.log(example.x); // 5
console.log(example.addX(1)); // 6

/*Node为每个模块提供一个exports变量，指向module.exports
Node 模块是通过 module.exports 导出的
如果直接将exports变量指向一个值，就切断了exports与module.exports的联系，导致意外发生：*/
// a.js
exports = function a() {};

// b.js
const a = require('./a.js') // a 是一个空对象
```
不同于CommonJS，ES6使用 export 和 import 来导出、导入模块
```js
// 写法一
export var m = 1;

// 写法二
var m = 1;
export {m};

// 写法三
var n = 1;
export {n as m};

//使用export default命令，为模块指定默认输出
// export-default.js
export default function () {
  console.log('foo');
}
```
#### vue.config.js
##### resolve.alias 配置路径别名
```js
module.exports = {
  resolve: {
        alias: {
            utils: path.resolve(__dirname, 'src/utils') // 这里使用 path.resolve 和 __dirname 来获取绝对路径
}
  }
}
//import 'utils/query.js' // 等同于 import '[项目绝对路径]/src/utils/query.js'

//精确匹配
alias: {
  utils$: path.resolve(__dirname, 'src/utils') // 只会匹配 import 'utils'
}

//vue-cli的别名配置代码如下：
function resolve (dir) {
  return path.join(__dirname, '..', dir)
}

// ...省略其它代码
resolve: {
    extensions: ['.js', '.vue', '.json'],
    alias: {
      '@': resolve('src'),
      '#': resolve('config')
    }
}
// ...省略其它代码
```
##### 配置跨域
```js
proxy: { //配置跨域
      '/api': {
       target: 'http://localhost:8088/', //后台接口
       changOrigin: true, //允许跨域
       pathRewrite: {
        '^/api': ''// 重写路径
       }
      },
     },
```

#### 一些组件
```
#引入axios
npm install axios --save-dev
import axios from 'axios'
Vue.prototype.$axios = axios
```

### JS相关
#### forEach()
forEach() 方法对数组的每个元素执行一次提供的函数。
```js
var array = ['a', 'b', 'c'];

array.forEach(function(element) {
  console.log(element);
});
```
forEach方法中的function回调有三个参数：
第一个参数是遍历的数组内容，
第二个参数是对应的数组索引，
第三个参数是数组本身
```js
var arr = [1,2,3,4];
var sum =0;
arr.forEach(function(value,index,array){

 array[index] == value; //结果为true

 sum+=value; 

 });

console.log(sum); //结果为 10
```
#### 箭头函数(lamda表达式)
```js
x => x * x
//等价于
function (x) {
    return x * x;
}

//函数体包含多个表达式，需要写成{...}，如果有返回值需要显示return
x => {
    if (x > 0) {
        return x * x;
    }
    else {
        return - x * x;
    }
}
//如果要返回一个对象,且是单表达式，需要用()括起来
// SyntaxError:
x => { foo: x }//和函数体的{}有歧义
// ok:
x => ({ foo: x })
```
#### 关键字 const , let , var 的用法区别
1. const定义的变量不可以修改，而且必须初始化。
2. var定义的变量可以修改，如果不初始化会输出undefined，不会报错。
3. let是块级作用域，函数内部使用let定义后，对函数外部无影响。

#### 插槽slot理解
1. 组件模板定义中预留插槽位
```js
//一个带有如下模板的 <base-layout> 组件：
<div class="container">
  <header>
    <slot name="header"></slot>//有name属性的具名插槽
  </header>
  <main>
    <slot>默认内容</slot>//默认插槽,一个不带 name 的 <slot> 出口会带有隐含的名字“default”
  </main>
  <footer>
    <slot name="footer"></slot>//具名插槽
  </footer>
</div>
```
2. 使用组件时填充插槽内容
```js
<base-layout>
  <template v-slot:header>
    <h1>Here might be a page title</h1>//使用template的v-slot属性指定要填充的插槽，插槽内容为该标签内容
  </template>

  <p>A paragraph for the main content.</p>//这两行将被填充到默认插槽中
  <p>And another one.</p>
  //等价写法
  // <template v-slot:default>
  //   <p>A paragraph for the main content.</p>
  //   <p>And another one.</p>
  // </template>


  <template v-slot:footer>
    <p>Here's some contact info</p>//填充name='footer'插槽的内容
  </template>
</base-layout>
```
3. 最终渲染结果如下
```js
<div class="container">
  <header>
    <h1>Here might be a page title</h1>
  </header>
  <main>
    <p>A paragraph for the main content.</p>
    <p>And another one.</p>
  </main>
  <footer>
    <p>Here's some contact info</p>
  </footer>
</div>
```
- 父子组件间传递数据
1. <slot>绑定一个需要传递的attribute，称其 插槽prop
```js
//一个带有如下模板的 <current-user> 组件：
<span>
  <slot v-bind:user="user">{{ user.lastName }}</slot>
</span>
```
2. 父级使用时通过v-slot来定义绑定插槽prop的集合
```js
<current-user>
  <template v-slot:default="slotProps">//default可省略
    {{ slotProps.user.firstName }}
  </template>
</current-user>
```