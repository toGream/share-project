package org.share.topic.api.domain;

import org.share.topic.api.model.Email;

/**
 * 四种方式：纯文本，富文本(图片，附件)，Freemarker模版以及Thymeleaf模版
 * @author Administrator
 *
 */
public interface IMailService {
	 public void send(Email mail) throws Exception;
	 
	 public void sendHtml(Email mail) throws Exception;
	 
	 public void sendVelocity(Email mail) throws Exception;
	 
	 public void sendFreemarker(Email mail) throws Exception;
	 
	 public void sendThymeleaf(Email mail) throws Exception;
	 
}
