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

