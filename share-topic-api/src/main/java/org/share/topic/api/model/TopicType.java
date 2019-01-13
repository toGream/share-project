package org.share.topic.api.model;

public enum TopicType {
	DAILY_RECORD(1,"个人日记"),
	BLOG(2,"最新随笔"),
	FORWARDING_TOPIC(3,"技术网站链接");
	
	private Integer code;
	private String name;
	
	private TopicType(Integer code, String name) {
		this.code = code;
		this.name= name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
