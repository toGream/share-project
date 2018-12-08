package org.share.topic.impl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("org.share.topic.api.dao")
public class ShareTopicApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShareTopicApplication.class, args);
	}
}
