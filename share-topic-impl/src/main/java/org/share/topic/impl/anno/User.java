package org.share.topic.impl.anno;

import org.springframework.stereotype.Component;

@ExportModule(type="user", moduleName="用户模块")
@Component
public class User {
	@ExportField(fieldName="id")
	private int id;
	@ExportField(fieldName="userName")
	private String userName;
	@ExportField(fieldName="fieldName")
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
