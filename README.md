# SZTU数据库大作业-Health-Life

这是一个健康管理相关的应用程序，旨在提供健康生活建议、饮食计划、锻炼指导以及用户个性化健康数据管理等功能。适用于希望改善生活习惯、保持健康生活方式的用户。

## 目录结构

- **src/main/java**：Java 源代码目录。
    - **com.stringtinyst.healthlife.config**：配置类，如 [AiConfig.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\config\AiConfig.java) 和 [WebConfig.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\config\WebConfig.java)。
    - **com.stringtinyst.healthlife.controller**：控制器类，处理 HTTP 请求。
        - [BodyController.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\controller\BodyController.java)：身体数据相关请求。
        - [ChatController.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\controller\ChatController.java)：聊天交互逻辑。
        - [DietController.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\controller\DietController.java)：饮食计划管理。
        - [ExerController.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\controller\ExerController.java)：锻炼计划管理。
        - [UserController.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\controller\UserController.java)：用户管理。
    - **com.stringtinyst.healthlife.interceptor**：拦截器类，如 [LoginCheckInterceptor.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\interceptor\LoginCheckInterceptor.java)。
    - **com.stringtinyst.healthlife.mapper**：MyBatis 映射接口。
        - [BodyMapper.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\mapper\BodyMapper.java)：身体数据映射。
        - [DietMapper.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\mapper\DietMapper.java)：饮食数据映射。
        - [ExerMapper.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\mapper\ExerMapper.java)：锻炼数据映射。
        - [UsersMapper.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\mapper\UsersMapper.java)：用户数据映射。
    - **com.stringtinyst.healthlife.pojo**：实体类。
        - [Body.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\pojo\Body.java)：身体数据实体。
        - [Diet.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\pojo\Diet.java)：饮食计划实体。
        - [Exer.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\pojo\Exer.java)：锻炼计划实体。
        - [PageBean.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\pojo\PageBean.java)：分页数据封装。
        - [Result.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\pojo\Result.java)：统一响应结果封装。
        - [User.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\pojo\User.java)：用户实体。
    - **com.stringtinyst.healthlife.service**：业务接口及实现。
        - `impl` 包含具体的服务实现类，如 [BodyServiceImpl.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\service\impl\BodyServiceImpl.java)、[DietServiceImpl.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\service\impl\DietServiceImpl.java) 等。
    - **com.stringtinyst.healthlife.utils**：工具类。
        - [JwtUtils.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\utils\JwtUtils.java)：JWT 认证工具。
        - [UserChatSessionManager.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\utils\UserChatSessionManager.java)：用户聊天会话管理。
    - **HealthLifeApplication.java**：Spring Boot 应用启动类。

- **src/main/resources**：资源文件目录。
    - **application.properties**：应用配置文件。
    - **mapper**：MyBatis 的 XML 映射文件。

- **src/test/java**：测试代码目录。
    - [HealthLifeApplicationTests.java](file://E:\Project\ideaProject\health-life\src\test\java\com\stringtinyst\healthlife\HealthLifeApplicationTests.java)：测试类。

## 功能概述

1. **用户管理**：
    - 用户注册与登录。
    - 用户信息维护。

2. **身体数据管理**：
    - 跟踪用户的身体指标（如体重、身高、体脂率等）。
    - 提供健康数据分析。

3. **饮食计划**：
    - 根据用户需求生成个性化饮食建议。
    - 饮食记录与追踪。

4. **锻炼指导**：
    - 提供适合用户的锻炼计划。
    - 锻炼记录与进度跟踪。

5. **智能交互**：
    - 支持与用户的自然语言交流，解答健康问题。

6. **安全与权限控制**：
    - 登录验证和权限管理（通过 [LoginCheckInterceptor.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\interceptor\LoginCheckInterceptor.java)）。
    - 使用 JWT 进行身份认证（[JwtUtils.java](file://E:\Project\ideaProject\health-life\src\main\java\com\stringtinyst\healthlife\utils\JwtUtils.java)）。

## 技术栈

- **后端框架**：Spring Boot
- **数据库**：MyBatis + MySQL
- **安全**：JWT (JSON Web Token)
- **前端交互**：RESTful API
- **部署**：Maven 构建工具

## 安装与运行

### 前提条件

- JDK 1.8 或更高版本
- Maven
- MySQL 数据库
- Node.js (可选，如果包含前端)

### 步骤

1. 克隆项目到本地：```git clone <repository-url>```
2. 配置数据库连接：
    - 修改 [application.properties](file://E:\Project\ideaProject\health-life\target\classes\application.properties) 文件中的数据库配置。

3. 启动项目：
```
cd health-life 
mvn spring-boot:run
```
4. 打开浏览器访问：http://localhost:8080
