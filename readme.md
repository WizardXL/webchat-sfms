>个人的Spring Boot+MyBatis项目脚手架，使用了pagehelper、mybatis-generator、tk.mybatis、lombok、devtools、orika、swagger、MockMVC等
方便于开发的插件及工具包，druid数据源以及freemarker模板引擎。并且采用RESTful的设计建立了响应结果类、错误响应处理、以及错误页面的覆盖。

需要修改的地方：
1. mybatis-generator-config.xml配置文件中关于数据库表和生成的相关类的对应关系
2. application文件中相关的配置
3. mybatis.cfg.xml中关于mybatis的配置
4. Spring Boot启动类上相关扫描注解的配置
5. tk.mybatis中自定义Mapper的相关定义，在config包下
6. RESTful的错误响应结果以及异常结果处理的相关类以及常量
7. Swagger的相关配置，在config下的SwaggerConfig类中
