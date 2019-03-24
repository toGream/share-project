package org.share.topic.impl.controller;

import java.util.Map;

import org.share.topic.api.domain.IMailService;
import org.share.topic.api.domain.ITopicService;
import org.share.topic.api.domain.IUserService;
import org.share.topic.api.model.Email;
import org.share.topic.api.model.Topic;
import org.share.topic.api.model.User;
import org.share.topic.impl.anno.ModuleVO;
import org.share.topic.impl.anno.MyListenerProcessor;
import org.share.topic.impl.util.UrlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;

import groovy.transform.Synchronized;

@RestController
@RequestMapping("/topic")
public class TopicController {
	private Logger logger = LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private ITopicService topicService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMailService mailService;
	
	@Autowired
	private UrlConfig urlConfig;
	
	@Autowired
	private MyListenerProcessor processor;
	
	@GetMapping("/test")
	public String test() {
		Map<String, ModuleVO> map = processor.getExportBean();
		for(Map.Entry<String, ModuleVO> entry : map.entrySet()) {
			System.err.println(entry.getKey()+":"+entry.getValue());
		}
		return "HelloWorld!";
	}
	
	@GetMapping("/users")
	public PageInfo<User> findUsers(){
		return userService.findUsers();
	}
	
	@GetMapping("/topics")
	public PageInfo<Topic> queryTopics(){
		return topicService.queryTopics();
	}
	
	@GetMapping("/email")
	public void testEmail() throws Exception {
		Email email = new Email();
		email.setEmail("562294358@qq.com");
		email.setSubject("spring cloud测试");
		email.setContent("spring cloud 欢迎你.");
		email.setTemplate("welcome");
//		mailService.sendFreemarker(email);
		mailService.sendVelocity(email);
	}
	
	@GetMapping("/email1")
	public void testEmail1() throws Exception {
		Email email = new Email();
		email.setEmail("562294358@qq.com");
		email.setSubject("spring cloud测试");
		email.setContent("spring cloud 欢迎你666666.");
		email.setTemplate("welcome");
//		mailService.sendFreemarker(email);
		mailService.sendFreemarker(email);
	}
	
	@GetMapping("url")
	public String getUrl() {
		logger.info("test");
		return urlConfig.getHome();
	}
}
