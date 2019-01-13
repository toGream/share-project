Spring cloud相关功能:
1.spring cloud整合mybatis
2.spring整合email
3.





######################spring cloud整合mybatis########################
1.引入对应的依赖
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>mybatis-spring-boot-starter</artifactId>
  <version>1.1.1</version>
 </dependency> 
 <dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc6</artifactId>
    <version>11.1.0.7.0-Production</version>
</dependency>
注意：jdbc驱动需要先下载jar,执行mvn安装到仓库后再引入ojdbc.jar包，不然提示引入错误。

2.application.yml需要的配置
spring:
  datasource:
    url: jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=47.107.142.153)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME =orcl)))
    username: igeneral
    password: igeneral
    driver-class-name: oracle.jdbc.driver.OracleDriver
#实体类扫描包
mybatis:
  type-aliases-package: org.share.topic.api.model
#Mapper.xml文件扫描目录
  mapper-locations: classpath:mapper/*.xml
#驼峰命名
  configuration:
    map-underscore-to-camel-case: true
#分页
pagehelper:
  helper-dialect: oracle
  reasonable: true
  support-methods-arguments: true
  params: count=countSql
  
3.启动类中加dao扫描路径
@MapperScan("org.share.topic.api.dao")
public class ShareTopicApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShareTopicApplication.class, args);
	}
}

########################spring整合email#############################
1.邮件服务
1.1邮件核心jar包
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
1.2基本配置
mail:
    host: smtp.163.com
    username: m13570826865@163.com
    password: zyl562294358??
    port: 25
    properties:
      mail:
        smtp: 
          auth: true
          starttls:
            enable: true
            required: true
    
2.使用velocity模板
2.1引入jar包
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-velocity</artifactId>
	<version>1.1.3.RELEASE</version>
</dependency>
2.2需要写个继承类（无法实例化），并设置初始化属性（找不到模板）
@Component
public class VelocityEngineBean extends VelocityEngine{
	public VelocityEngineBean() {
		this.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
		this.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	}
}

3.使用freemark模板
3.1引入jar包
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
3.2这个路径一定要这样指定否则找不到模板
freemarker:
    template-loader-path:
    - classpath:/template

########################spring整合logback-spring.xml日志#############################
1.引入springboot <parent/>时已经默认使用logback对应的包,此包使用slf4j包具体实现
2.在resources中创建logback-spring.xml,注意只有这个名字才能指定环境

########################spring修改banner.txt#############################
1.创建banner.txt输入自己想要的可以替换spring默认的输出图形




