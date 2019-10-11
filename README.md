# top-xinye

#### 项目介绍
springboot maven项目：druid数据源连接池；mybatis plus配置集成, redis集成；swagger2接口文档集成；WebSocket集成；oss文件上传服务集成；
aop配置；测试；Metrics监控；参数验证；跨域处理；shiro权限控制；zookeeper服务注册，发现；redis分布式锁；SPI服务机制；cat监控；netty服务代理；
websocket；disconf；RocketMq集成；日志集成[logback.xml](https://gitee.com/joven1985/top-suven/blob/master/base-utils/src/main/resources/logback.xml)
自动按天切割,同时长连接上报到elk,存储到搜索引擎elasticsearch

###### [文档从到top-suven/base-global/doc 目录下](https://gitee.com/joven1985/top-suven/tree/master/base-global/doc)
###### 项目展示效果图:

* 1.[kafka 展示效果图](https://gitee.com/joven1985/top-suven/tree/master/base-global/doc/introduce_imgage/kafka.png)
* 2.[elk 展示效果图](https://gitee.com/joven1985/top-suven/tree/master/base-global/doc/introduce_imgage/elk.png)
* 3.[cat 展示效果图](https://gitee.com/joven1985/top-suven/tree/master/base-global/doc/introduce_imgage/cat.png)
* 4.[rocketMq 展示效果图](https://gitee.com/joven1985/top-suven/tree/master/base-global/doc/introduce_imgage/rocketMq.png)
* 5.[admin后台管理系统 展示效果图](https://gitee.com/joven1985/top-suven/tree/master/base-global/doc/introduce_imgage/admin.png)


#### 软件架构
软件架构说明
 * [服务接口说明文档](base-global/doc/http/http-index.md)
 * [服务部署说明文档](base-global/doc/project.md)
 
### Java开发规范

#### 前言

这份文档是 Java编程风格规范的定义。有且只有一个Java源文件符合此文档中的规则， 我们才认为它符合Java编程风格
制定者 : 服务组成员
适用范围 : Java开发人员
术语说明





class 可表示一个普通类，枚举类，接口或是注解类型
comment只用来指代实现的注释
javadoc是文档的说明文档
项目命名规范

#### 项目前缀

http 对外提供短链接服务返回结果对象类
rpc 内部调用的SOA的服务返回结果对象类


#### 项目命名规范

##### 服务


小写+-
mps-soa-api, xxx-logic,xxx-logic
类库

小写+-
top-lib
开发基础规范

开发构建工具为gradle
基础类库为top-lib,根据需要引入对应的类库
如有需要添加插件，邮件申请，具体由XXX负责审核
源文件

##### 文件名

源文件以其最顶层的类名.java来命名
文件编码

源文件编码格式为UTF-8。
特殊字符

特殊字符都要进行转义
具有特殊转义序列的任何字符(\b, \t, \n, \f, \r, \“, \‘及)，我们使用它的转义序列
尽量使用Unicode,并加上注释，包括中文
源文件结构

一个源文件包含(按顺序)：

package语句
import语句
有且只有一个顶级类
以上每个部分之间用一个空行隔开。
package语句

package top.suven.base.http..*

import语句


import不要使用通配符*
import 必须使用量到类名;方便排查重名类
import语句可分为以下几组，按照这个顺序，每组由一个空行分隔：
第三方的包。每个顶级包为一组，字典序。例如：android, com, junit, org, sun
java imports
javax imports
组内不空行，按字典序排列
类声明

有且只有一个顶级类声明

顶级类放在他同名的文件中(UserUtil.java)
类成员顺序

每个类应该以某种逻辑去排序它的成员，维护者应该要能解释这种排序逻辑
按逻辑来排序，而不是按时间顺序排序
方法重载，这些函数/方法应该按顺序出现在一起，中间不要放进其它函数/方法。


##### 代码结构:(后期执行)
1. 类名与头部规范
	a、作者1、类名一定要有标头注释，应该包含以下几个属性：
	b、创建时间
	c、该类的作用和一些概要的说明
类的命名规范
DAO的实现类命名为：XxxDao
Service层接口实现类命名为：XxxService
访问层controller的命名为：XxxController
单元测试类的命名为：XxxDaoImplTest、XxxControllerTest
      注：Xxx 为对象名称

2、方法一定要有注释、应该包含以下几个内容：
	a、方法的作用，实现什么功能或解决什么问题
	b、必要的参数解释
	c、返回值的解释，例如：@return null ：失败，非null：成功

3、包文件类按模块分类存放，遵循MVC设计模式，例如：

	a、单个项目
	top.suven.user	                         	// 顶级包名 /mps/mfanxing
		| 业务模块名	
			| com.ds.software.controller		                // 控制层，请求总入口。处理请求分发，参数校验等
			| face		                // service组装层，提供给controller使用
			| service					// 服务层，一个Action/Controller对应一个独立的service类，有需要可以抽象出BaseService
			| dao						// 应该为每一个实体类建立一个数据库访问对象，应该抽象出BaseDao，提供基本的增删改查方法
		| 业务模块名					// 其他一些业务包，存放相关业务的类文件，按需要，不需要可以省去
			| com.ds.software.controller
			| service
			| dao
		        | cron						// 独立模块
		        | nsq							// 独立模块		
		        | ...							// 其他模块
                    | utils						// 存放工具类等
                    |..common
                    |...redis
		


大括号

使用大括号

即使只有一条语句(或是空)，也应该把大括号写上
非空块：K & R 风格

对于非空块和块状结构，大括号遵循Kernighan和Ritchie风格 (Egyptian brackets):
左大括号前不换行
左大括号后换行
右大括号前换行
如果右大括号是一个语句、函数体或类的终止，则右大括号后换行; 否则不换行。例如，如果右大括号后面是else或逗号，则不换行。
示例：
```
return new MyClass() {
 @Override 
public void method() {
  if (condition()) {
    try {
      something();
    } catch (ProblemException e) {
      recover();
    }
  }
}
};
```
空块：可以用简洁版本

一个空的块状结构里什么也不包含，大括号可以简洁地写成{}，不需要换行
void doNothing() {}
if(true){ // 这种格式重量写上大括号,方便下面维护和增加方法的可请性;
   function();
   //方便维护人再增加方法,或类型操作;
   //funcationB()
}
块缩进

使用IDEA的默认格式化代码 , 加上tab+space来缩进代码
符号与属性间,增加空格,增加代码的可读性
eg:  null  != info 代码 info!=null
 a + b  = c  代码  a+b=c; 
一行一个语句

每个语句后要换行
列限制：100

任何一行如果超过这个字符数限制，必须自动换行
合理的变量方法命名
例外：
不可能满足列限制的行(例如，Javadoc中的一个长URL，或是一个长的JSNI方法参考)
package和import语句
注释中那些可能被剪切并粘贴到shell中的命令行
自动换行

从哪里断开

自动换行的基本准则是：更倾向于在更高的语法级别处断开
如果在非赋值运算符处断开，那么在该符号前断开(比如+，它将位于下一行),这条规则也适用于以下“类运算符”符号
如果在赋值运算符处断开，通常的做法是在该符号后断开(比如=，它与前面的内容留在同一行)。这条规则也适用于foreach语句中的分号
方法名或构造函数名与左括号留在同一行
逗号(,)与其前面的内容留在同一行
自动换行时缩进至少+4个空格

自动换行时，第一行后的每一行至少比第一行多缩进4个空格,或2个Tab
两个连续行使用相同的缩进当且仅当它们开始于同级语法元素
用小括号来限定组：推荐

去掉小括号也不会使代码被误解，或是去掉小括号能让代码更易于阅读，否则我们不应该去掉小括号
命名规范

##### 枚举类

枚举常量间用逗号隔开，换行可选。
没有方法和文档的枚举类可写成数组初始化的格式：
private enum Suit { CLUBS, HEARTS, SPADES, DIAMONDS }
由于枚举类也是一个类，因此所有适用于其它类的格式规则也适用于枚举类
变量声明

每次只声明一个变量

不要使用组合声明，比如int a, b, 常用变化量名,尽量具体有意义,方法内允许简写;
需要时才声明，并尽快进行初始化

在第一次需要使用它时才声明,声明后尽快进行初始化
class中的成员变量的命名

camel命名法
int userAge; //camel命名
##### 数组

数组初始化：可写成块状结构

数组初始化可以写成块状结构
[]是类型的一部分
int[] objArr
switch语句

##### 缩进

每个switch标签后新起一行，再缩进，写下一条或多条语句
Fall-through：注释

在一个switch块内，每个语句组要么通过break, continue, return或抛出异常来终止，要么通过一条注释来说明程序将继续执行到下一个语句组
```
switch (input) {
case 1:
case 2:
  prepareOneOrTwo();
  // fall through
case 3:
  handleOneTwoOrThree();
  break;
default:
  handleLargeNumber(input);
}
```
default的情况要写出来

每个switch语句都包含一个default语句组，即使它什么代码也不包含
注解(Annotations)

注解紧跟在文档块后面，应用于类、方法和构造函数，一个注解独占一行
@Override
@Nullable
public String getNameIfPresent() { ... }
##### 注释

块注释风格

块注释与其周围的代码在同一缩进级别。它们可以是/* ... */风格，也可以是// ...风格。对于多行的/* ... */注释，后续行必须从*开始， 并且与前一行的*对齐
/*
 * This is          // And so           /* Or you can
 * okay.            // is this.          * even do this. */
 */
注释不要封闭在由星号或其它字符绘制的框架里
Modifiers

类和成员的modifiers如果存在，则按Java语言规范中推荐的顺序出现(逻辑顺序)
命名约定

对所有标识符都通用的规则

标识符只能使用ASCII字母和数字，因此每个有效的标识符名称都能匹配正则表达式\w+
标识符类型的规则

##### 包名

package的名字由小写组成
自动构建的类也要遵循规则
package top.suven.xxx.thrift;
package top.suven.xxx.soa;

##### 类名

class命名采用Pascal命名法
```
public class UserUtil
{
}
```
类名通常是名词或名词短语，接口名称有时可能是形容词或形容词短语
测试类的命名以它要测试的类的名称开始，以Test结束
##### 方法名

camel命名法
方法名通常是动词或动词短语
public void setNum(){};
##### 常量名

全大写，同时要包含完整定义
public static final String NSQ_CONFIG_PATH = "xxx";
这些名字通常是名词或名词短语
##### 非常量字段名

非常量字段名以CamelCase风格编写
这些名字通常是名词或名词短语
##### 参数名

参数名要有意义
camel命名
入参不要超过3个，太多就用object或map
public void setAllInfo(int age,String name){};
##### 局部变量名

camel命名
需要的时候创建并尽快初始化
##### 类型变量名

单个的大写字母，后面可以跟一个数字(如：E, T, X, T2)
以类命名方式(5.2.2节)，后面加个大写的T(如：RequestT, FooBarT)
@Override：能用则用

只要是合法的，就把@Override注解给用上
捕获的异常：不能忽视

所有捕获的异常都要处理
如果它确实是不需要在catch块中做任何响应，需要做注释加以说明
静态成员：使用类进行调用

使用类名调用静态的类成员，而不是具体某个对象或表达式。
```
Soa soa = ...;
Soa.dosth(); // good
soa.dosth(); // bad
getSoa().dosth(); // very bad
Finalizers: 禁用
```
极少会去重载Object.finalize。
Javadoc

#### 格式

一般形式

Javadoc块的基本格式如下所示：
```
/**
* Multiple lines of Javadoc text are written here,
* wrapped normally...
*/
public int method(String p1) { ... }
```
或者是以下单行形式：
```
/** An especially short bit of Javadoc. */
```

基本格式总是OK的。当整个Javadoc块能容纳于一行时(且没有Javadoc标记@XXX)，可以使用单行形式
Javadoc标记

标准的Javadoc标记按以下顺序出现：@param, @return, @throws, @deprecated, 前面这4种标记如果出现，描述都不能为空
#### 分页

每页数量 pageSize
nextId nextId
NOTE

foreach中不能干的事

创建连接
数据库查询
io操作
kv存储
memcached
redis


#### 安装教程

1. xxxx
2. xxxx
3. xxxx

#### 使用说明

1. xxxx
2. xxxx
3. xxxx

#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)