
<h1 align="center" style="margin: 30px 0 30px; font-weight: bold;">图书管理系统 v1.0.0</h1>
<h4 align="center">基于 Spring Cloud & Alibaba/Vue/Element UI 和 Spring Boot/前后端分离的分布式微服务架构</h4>


## 平台简介

图书管理系统是一套全部开源的微服务Demo案例，毫无保留地供大家学习与使用。

* 后端采用Spring Boot、Spring Cloud & Alibaba。
* 注册中心、配置中心选型Nacos。
* 提供了技术栈（[Vue3](https://v3.cn.vuejs.org) [Element Plus](https://element-plus.org/zh-CN) [Vite](https://cn.vitejs.dev)）版本。

## 系统模块

~~~
per.zdb
├── vue-client            // 前端框架 [80]
├── app-api               // app接口模块 [8091]
├── ruoyi-modules         // 业务模块
│       └── book                          // 图书模块 [8090]
├── docker-compose        // 容器配置
│       └── library-system                // app接口服务配置
│       └── mysql                         // mysql配置
│       └── nginx                         // nginx配置
│       └── docker-compose.yml            // docker-compose总配置
│       └── deploy.sh                     // 部署命令
├──pom.xml      // 公共依赖
~~~


## 内置功能

1.  创建一本新书·按ID检索书籍
2.  更新书籍的详细信息。
3.  删除一本书。
4.  获取一本书详细信息。

## 在线体验

演示地址：http://h5.library.frp.ijjk.top:28092
文档地址：http://library.frp.ijjk.top:28091/swagger-ui.html

## 快速开始

### 先决条件

首先本机先要安装以下环境，建议先学习了解springboot和springcloud基础知识。

- [git](https://git-scm.com/)
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [maven](http://maven.apache.org/)
- [docker](http://www.docker.com/)

### 开发环境搭建

**具体步骤如下：**

1. 克隆代码库：
`git clone https://github.com/zdb1314/library_system.git && cd library_system`

2. maven打包
`mvn -pl ./app-api,./module/book install`

3. jar包复制到docker目录
`cp module\book\target\web.jar docker-compose\library-system\app-api\jar && cp app-api\target\web.jar docker-compose\library-system\book\jar`

4. 构建Docker镜像并运行基础模块容器
`docker-compose\deploy.sh base `

5. 导入library_system\docker-compose\nacos\nacos_config.zip配置文件到nacos服务

6. 构建Docker镜像并运行业务模块容器
`docker-compose\deploy.sh modules`

### 单元测试
**前端单元测试：**

1，单元测试命令：`npm run test`

2，测试代码位置：library_system\vue-client\test\unit\specs

**后端单元测试：**

测试代码位置：library_system\module\模块名\src\test
