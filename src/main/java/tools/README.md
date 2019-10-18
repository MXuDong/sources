# Java 常用的工具、网站、学习资源
	文档持续更新并置顶
	最后更新时间：2019年10月18日
	修订次数：2
	如有问题或建议请留言
# Java开发中常用的编辑器
	注意这里是编辑器不是编译器,我只列出常用的
|编辑器名称|编辑器特点|编辑器官网链接|备注|
|:---|:---|:---:|:---|
|Eclipse|Eclipse 是一个开放源代码的、基于Java的可扩展开发平台，而且免费|[https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/)|比较灵活，项目底层为``WorkSpace``，不支持模块（可以手动指定），适合新手|
|Intellij|是目前非常优秀的编辑器，但是价格不是很低，学生可免费申请|[https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/)|智能提示，扩展性较高，代码重构功能比较强大，适合老鸟|
|MyEclipse|没有用过不做说明|[https://www.myeclipsecn.com/](https://www.myeclipsecn.com/)||
|Sublime|轻量级编辑器，可编辑很多种代码|[http://www.sublimetext.com/](http://www.sublimetext.com/)|适合做小项目，大型项目的维护极其复杂|
# Java常用的相关网站
1. [JDK官网](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 下载JDK、查阅文档
1. [How2j](http://how2j.cn/) 通常用来学习Java的一些框架
2. [V2ex](https://www.v2ex.com/) 技术探讨、求职、创新等交流
3. [Github](https://github.com/) 源码库
4. [廖大仙Java教程](https://www.liaoxuefeng.com/wiki/1252599548343744) 大仙有很多其他的学习资料
5. [Java SE Documentation](https://docs.oracle.com/en/) Java官方文档库
6. [Maven 中央仓库](https://mvnrepository.com/) 用来查依赖关系、最新库等
7. [解道](https://www.jdon.com/) 覆盖了很多的Java 技术，可以用来查缺补漏
# Java开发中常用工具、第三方软件
1. Maven
2. Gradle
3. Ant
4. Git

# Java开发中常用框架
## 底层常用支持库
1. CGLib - 动态代理库 - [Github链接](https://github.com/cglib/cglib)

## Web开发常用框架
1. Spring 系列 - [Spring 官网链接](https://spring.io/)

## Java 中常用框架、中间件组合
### Web开发
1. SSM - Spring + SpringMVC + MyBatis
一般情况下前后端耦合会使用这种组合，符合MVC开发规范
2. SSH - Spring + Struct2 + Hibernate
16年之前较为流行和前后端耦合开发

### 日志系统
1. ELK - ElasticSearch +LogStash + Kibana 
一般情况下用来做日志分析、搜集工作，Kibana对与时间线的规划很好、拥有大量的视图模式可以调用。对运维很友好。
可以搭配Kafka一起使用，企业应用的时候常常升级为EFK
2. EFK - ElasticSearch + Filebeat + Kibana
ELK升级版