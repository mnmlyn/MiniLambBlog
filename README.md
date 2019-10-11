# 1. 项目简介

这里将会展示，如何搭建个人博客。技术水平是，刚刚学完Java基础语法，对于未知的那些技术只知道有他们存在，但并不知道到底是何方神圣。

但是，没有关系。前路漫漫，只有真正动手，才能知道路上到底有什么。

## 1.1目标规划

想要做成一个功能丰富，美观与安全性兼备的博客系统。当然，不是专业做前端也不想深究前端技术，所以以后端技术实现原理为主要方向。

目的是把刚刚学的Java用起来，并且融合自己学过的各种技术。

## 1.2 项目管理

既然要规范，那么开发不应该在master分支进行。

仓库至少有release、develop和master三个分支。

release分支是已经可以实际部署的版本。
develop分支是正在开发的版本。
master分支是开发测试完成进行合入的版本。

稳定性：release > master > develop

# 2. 第一期实现

首先，如何访问数据库，如何使用Mybatis框架。

那么先实现一个，使用Mybatis框架进行增删改查的简单程序。

1. 引入JUnit，Mysql的连接器，Mybatis。
2. 在resources文件夹下新建mybatis的xml配置文件。主要是配置数据源和事务管理器。

加入以下格式规范。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
```

3. 随便建个表，并写出对应的Java类，然后书写emp-mapper.xml

```mysql
create table emp( id int primary key, name varchar(10), age int);
```

mapper的格式规范
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
```

搞一个临时数据库用户，用于测试吧，这样就不担心密码泄露了。
（喜闻乐见，果然密码会泄漏，数据库数据被加密，被勒索0.075比特币，然而我不care，goodbye）
新建用户，赋予初始权限
```mysql
create user 'test'@'%' identified by '123456';
```

或直接新建用户，并同时授权相应库的权限
```mysql
grant all on java_jdbc.* to 'test'@'%' identified by '123456';
```








