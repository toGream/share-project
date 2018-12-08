package org.share.topic.api.model;

import java.io.Serializable;
import java.util.HashMap;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;//接收方邮件
	private String ccEmail;//抄送
	private String bccEmail;//密送
	private String subject;//邮件主题
	private String content;//邮件内容
	private String template;//模板
	private HashMap<String,String> params;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCcEmail() {
		return ccEmail;
	}
	public void setCcEmail(String ccEmail) {
		this.ccEmail = ccEmail;
	}
	public String getBccEmail() {
		return bccEmail;
	}
	public void setBccEmail(String bccEmail) {
		this.bccEmail = bccEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public HashMap<String, String> getParams() {
		return params;
	}
	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}
}
