package org.share.topic.impl.controller;

import java.util.List;

import org.share.topic.api.domain.IMailService;
import org.share.topic.api.domain.IUserService;
import org.share.topic.api.model.Email;
import org.share.topic.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMailService mailService;
	
	@GetMapping("/test")
	public String test() {
		return "HelloWorld!";
	}
	
	@GetMapping("/users")
	public List<User> findUsers(){
		return userService.findUsers();
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
}
